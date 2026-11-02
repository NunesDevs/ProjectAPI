# PersonAPI — cadastro de pessoas

API REST de estudo com Spring Boot, JPA, validação aninhada e H2 em memória.

## Comportamento

- CRUD em `/api/v1/people` com respostas 400, 404 e 409 para erros esperados.
- Atualização usa a identidade da URL; IDs enviados pelo cliente não escolhem outro cadastro.
- Telefones e endereços usam DTOs validados, com IDs de filhos atribuídos pelo servidor.
- Datas em ISO `yyyy-MM-dd`, preservadas no retorno; CPF normalizado para evitar duplicação por pontuação.
- Spring Boot 4.1.2, Java 17, Jakarta, MapStruct 1.6.3 e Maven Wrapper com hashes fixados.

## Executar e validar

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

## Limites

O banco padrão é volátil (`create-drop` em H2); reiniciar descarta os registros. A API não implementa autenticação ou autorização e deve ser usada localmente com dados fictícios. Não a exponha com dados pessoais reais. Persistência e controle de acesso precisam de um projeto de implantação próprio antes de qualquer uso operacional.

## Manutenção e licença

Código autoral licenciado sob a [MIT](LICENSE). Dependências, ferramentas e materiais de terceiros mantêm suas próprias licenças e avisos.

Decisões e continuidade: [PROJECT_MEMORY.md](PROJECT_MEMORY.md).
