# API para praticar REST com criação de usuários e realização de CRUD

### Requisitos:
> - Gradle
> - Java 17
> - Spring Boot versão 3.1.0

### Opcionais:
> - Intellij
> - Postman
> - H2
> - Swagger

## Observações: Estou finalizando os testes unitários e pretendo cobrir toda a aplicação com testes.

### A API está dividida em camadas, cada uma com responsabilidades específicas:

#### Entity: 
> - Nesta camada, encontram-se as entidades utilizadas no sistema.

#### Repository: 
> - A camada de repositório é responsável por definir a interface que estende o JpaRepository. 
> Ela fornece os métodos para realizar operações de persistência no banco de dados.

#### Service:
> - A camada de serviço contém as regras de negócio da aplicação. Aqui são implementadas as 
> lógicas e operações que envolvem os dados e as entidades.

#### DTO: 
> - Nesta camada, são criados os objetos de transferência de dados (DTO, do inglês Data Transfer Objects). 
> São utilizados os objetos CustomerDto e CustomerViewDto para realizar a transição de dados entre as camadas, 
> sem a necessidade de acessar diretamente o objeto Customer.

#### Controller:
> - A camada de controller é responsável por implementar os métodos HTTP utilizando o ResponseEntity. 
> Aqui são definidas as rotas e os métodos que serão executados quando ocorrerem requisições na API.

#### Config: 
> - A camada de configuração é onde é criada a classe para configurar o Swagger. 
> O Swagger é uma ferramenta que facilita a documentação e teste de APIs.

#### Exception:
> - Nesta camada, são tratadas as exceções que podem ocorrer durante a execução da API. 
> - É importante ter um tratamento adequado de exceções para fornecer respostas adequadas aos erros que possam ocorrer.
> - Ainda não terminei, precisa incluir mais tratamentos de exceções.
