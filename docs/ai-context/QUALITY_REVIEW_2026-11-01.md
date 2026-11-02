# Revisão de qualidade — 2026-11-01

API REST de estudo com Spring Boot, JPA, validação aninhada e H2 em memória.

## Escopo

Leitura de fontes, documentação, configurações e scripts do projeto, excluindo dependências, metadados Git e saídas geradas. Sem alteração visual; mudanças de interface gráfica exigem Figma.

## Correções e decisões

- CRUD em `/api/v1/people` com respostas 400, 404 e 409 para erros esperados.
- Atualização usa a identidade da URL; IDs enviados pelo cliente não escolhem outro cadastro.
- Telefones e endereços usam DTOs validados, com IDs de filhos atribuídos pelo servidor.
- Datas em ISO `yyyy-MM-dd`, preservadas no retorno; CPF normalizado para evitar duplicação por pontuação.
- Spring Boot 4.1.2, Java 17, Jakarta, MapStruct 1.6.3 e Maven Wrapper com hashes fixados.

## Como validar

JDK 17+; o Maven Wrapper baixa Maven 3.9.11 e dependências oficiais na primeira execução.

```powershell
./mvnw.cmd -B verify
java -jar target/PersonAPI-0.0.1-SNAPSHOT.jar
```

Linux/macOS: `./mvnw -B verify`. A API escuta `http://127.0.0.1:8080` por padrão. `PORT` muda a porta; `SERVER_ADDRESS` pode mudar o endereço. `GET /actuator/health` informa a saúde do processo.

O contrato de data anterior `dd-MM-yyyy` foi substituído por ISO. Exemplo de criação:

```json
{"firstName":"Pessoa","lastName":"Teste","cpf":"52998224725","birthDate":"2000-01-01","phones":[{"type":"MOBILE","number":"11999990000"}],"address":[{"type":"FIRST","cep":"01001000","street":"Rua Teste","district":"Centro","city":"São Paulo","state":"SP","country":"Brasil"}]}
```

Cinco testes de integração verificam CRUD, identidade da URL, datas, validação aninhada, duplicidade e recursos ausentes.

## Limites reais

O banco padrão é volátil (`create-drop` em H2); reiniciar descarta os registros. A API não implementa autenticação ou autorização e deve ser usada localmente com dados fictícios. Não a exponha com dados pessoais reais. Persistência e controle de acesso precisam de um projeto de implantação próprio antes de qualquer uso operacional.

Confira `PROJECT_MEMORY.md` para continuidade. Os resultados executados estão registrados abaixo.

## Resultado executado

Maven verify com Spring Boot 4.1.2 e JDK 17 aprovado; cinco testes de integração, zero falhas/erros. Inclui PUT pela identidade da URL, datas ISO, validação aninhada, CPF duplicado com pontuação e 404. JAR com avisos de licença empacotado.

Publicação em produção não foi realizada. Pacotes foram preparados e a publicação da branch será registrada na auditoria local; integração e distribuição são coordenadas separadamente.
