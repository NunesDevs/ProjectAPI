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


