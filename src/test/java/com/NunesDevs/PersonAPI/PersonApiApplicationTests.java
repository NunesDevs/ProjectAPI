package com.NunesDevs.PersonAPI;

import com.NunesDevs.PersonAPI.repositoy.IPersonREPO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@AutoConfigureMockMvc
class PersonApiApplicationTests {
    @Autowired MockMvc mvc;
    @Autowired IPersonREPO repo;
    private final String payload = """
        {"firstName":"Pessoa","lastName":"Teste","cpf":"52998224725","birthDate":"2000-01-01",
         "phones":[{"type":"MOBILE","number":"11999990000"}],
         "address":[{"type":"FIRST","cep":"01001000","street":"Rua teste","district":"Centro","city":"São Paulo","state":"SP","country":"Brasil"}]}
        """;
    @BeforeEach void reset() { repo.deleteAll(); }
    @Test void crudUsesUrlIdentityAndKeepsDate() throws Exception {
        mvc.perform(post("/api/v1/people").contentType(MediaType.APPLICATION_JSON).content(payload)).andExpect(status().isCreated());
        Long id = repo.findAll().get(0).getId();
        mvc.perform(get("/api/v1/people/{id}", id)).andExpect(status().isOk()).andExpect(jsonPath("$.birthDate").value("2000-01-01"));
        String changed = payload.replace("Pessoa", "Atualizada").replace("{\"firstName\"", "{\"id\":999999,\"firstName\"");
        mvc.perform(put("/api/v1/people/{id}", id).contentType(MediaType.APPLICATION_JSON).content(changed)).andExpect(status().isOk());
        assertEquals(1, repo.count()); assertEquals("Atualizada", repo.findById(id).orElseThrow().getFirstName());
        mvc.perform(delete("/api/v1/people/{id}", id)).andExpect(status().isNoContent());
        mvc.perform(get("/api/v1/people/{id}", id)).andExpect(status().isNotFound());
    }
    @Test void nestedPhoneValidationReturns400() throws Exception {
        mvc.perform(post("/api/v1/people").contentType(MediaType.APPLICATION_JSON).content(payload.replace("11999990000", "x"))).andExpect(status().isBadRequest());
        assertEquals(0, repo.count());
    }
    @Test void duplicateCpfReturns409() throws Exception {
        mvc.perform(post("/api/v1/people").contentType(MediaType.APPLICATION_JSON).content(payload)).andExpect(status().isCreated());
        mvc.perform(post("/api/v1/people").contentType(MediaType.APPLICATION_JSON).content(payload.replace("52998224725", "529.982.247-25"))).andExpect(status().isConflict());
        assertEquals(1, repo.count());
    }
    @Test void invalidDateAndMissingTypeReturn400() throws Exception {
        mvc.perform(post("/api/v1/people").contentType(MediaType.APPLICATION_JSON).content(payload.replace("2000-01-01", "2000-02-31"))).andExpect(status().isBadRequest());
        mvc.perform(post("/api/v1/people").contentType(MediaType.APPLICATION_JSON).content(payload.replace("\"type\":\"MOBILE\",", ""))).andExpect(status().isBadRequest());
    }
    @Test void missingUpdateAndDeleteReturn404() throws Exception {
        mvc.perform(put("/api/v1/people/999999").contentType(MediaType.APPLICATION_JSON).content(payload)).andExpect(status().isNotFound());
        mvc.perform(delete("/api/v1/people/999999")).andExpect(status().isNotFound());
        assertEquals(0, repo.count());
    }
}
