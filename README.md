# ProjectAPI
## Projeto de cadastro de pessoas, com dados pessoais, contato e endereço.
##
## Request postman (http://localhost:8080/api/v1/people) or Cloud url. 
### Post:
#### {
#### "firstName": "",
#### "lastName": "",
#### "cpf": "xxx.xxx.xxx-xx",
#### "birthDate":"DD-MM-YYYY",
#### "phones":[
#### {
##### //type = HOME, MOBILE, COMMERCIAL
#### "type":"",
#### "number":"(XX)nnnnn-nnnn"
#### }
#### ],
#### "address": [
#### {
##### //type = FIRST, SECOND, THIRD
#### "type":"",
#### "cep":"xx.xxx-xxx",
#### "street":"",
#### "district":"",
#### "city":"",
#### "state":"",
#### "country":""
#### }
#### ]
#### }

### Get or GetById: 
#### "url/api/v1/people" or "url/api/v1/people/id"

### Put:
#### {
#### "id": "",
#### "firstName": "",
#### "lastName": "",
#### "cpf": "xxx.xxx.xxx-xx",
#### "birthDate":"DD-MM-YYYY",
#### "phones":[
#### {
#### "id":"",
##### //type = HOME, MOBILE, COMMERCIAL
#### "type":"",
#### "number":"(XX)nnnnn-nnnn"
#### }
#### ],
#### "address": [
#### {
#### "id":"",
##### //type = FIRST, SECOND, THIRD
#### "type":"",
#### "cep":"xx.xxx-xxx",
#### "street":"",
#### "district":"",
#### "city":"",
#### "state":"",
#### "country":""
#### }
#### ]
#### }
### DeleteById:
#### "url/api/v1/people/id"

## Operação e arquitetura verificadas

Spring Boot 2.6.3 e Java 17. Controller publica /api/v1/people, serviço aplica regras e repositório JPA persiste entidades.

Arquivos principais: `pom.xml`, `src/main/java/com/NunesDevs/PersonAPI/controller/PersonController.java`, `src/main/java/com/NunesDevs/PersonAPI/service/PersonService.java`.

### Requisitos e execução

JDK 17; Maven Wrapper precisa acesso à rede na primeira execução.

```text
.\mvnw.cmd test
.\mvnw.cmd package
.\mvnw.cmd spring-boot:run
```



### Testes e estado

Existe teste de contexto Spring Boot; não foi executado nesta máquina, que não possui JDK.

Estado: projeto de estudo/experimental. Deploy ativo não foi confirmado nesta revisão.

### Limitações conhecidas

- JDK 17 não disponível; compilação e teste de contexto não executados.
- Não foi identificada autenticação nas operações CRUD.
- Não foi verificado deploy ativo.

### Licença e manutenção

Nenhum arquivo de licença foi identificado nesta revisão; não foi adicionada uma nova licença. Atualize comandos e limitações quando houver mudança de comportamento.
