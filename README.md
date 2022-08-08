# Calculadora de Juros Compostos

Calculadora de Juros Compostos de uma aplicação de rendimentos mensais

## Dependências
* Java 17
* Spring Boot 2.7.1
* Maven 3.6.3

_IDE utilizada: IntelliJ IDEA 2021.3.3_

### Iniciando a Aplicação
* __mvn compile__ - Compila o projeto
* __mvn test__ - Executa os testes
* __mvn spring-boot:run__ - Coloca em execução a API na porta padrão (8080).


###Utilizando a API
Os valores de entrada deverão ser enviados através do corpo de uma requisição HTTP, no formato Json seguindo a ordem: Capital a ser investido, Taxa de Juros da aplicação e o Prazo do Investimento.

### Exemplo de corpo da requisição
```javascript
"principal" : "1000.0",
"interestRate" : "0.1",
"period" : "12"
```