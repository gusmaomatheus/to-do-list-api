# To-do List 📝

## Descrição 🚀

Este projeto é uma API criada para gerenciar tarefas (CRUD) como parte do [desafio backend junior da Simplify](https://github.com/simplify-tec/desafio-junior-backend-simplify).

## Tecnologias Utilizadas 💻

- [Spring Boot](https://spring.io/projects/spring-boot) 🌱
- [Spring Web](https://docs.spring.io/spring-boot/docs/current/reference/html/web.html) 🕸️
- [Spring MVC](https://docs.spring.io/spring-framework/reference/web/webmvc.html) 🌐
- [Spring Data JPA](https://spring.io/projects/spring-data-jpa) 🎲
- [PostgreSQL](https://www.postgresql.org/download/) 🐘

## Práticas Adotadas 🛠️

Ao desenvolver esta aplicação, foram seguidas algumas práticas fundamentais:

- **SOLID** 🏋️‍♂️: Princípios sólidos da programação orientada a objetos foram aplicados para garantir um design flexível e escalável.
  
- **DRY** 🌵: "Don't Repeat Yourself" foi seguido para evitar redundâncias no código, promovendo a reutilização e a manutenção eficiente.
  
- **YAGNI** 🤷‍♂️: "You Aren't Gonna Need It" foi mantido em mente para evitar o desenvolvimento de recursos que não são necessários no momento, mantendo o foco na simplicidade.
  
- **KISS** 💋: "Keep It Simple, Stupid" foi seguido para manter a simplicidade na implementação, facilitando a compreensão e a manutenção do código.


## Como Executar 🚀

Siga os passos abaixo para executar localmente:

1. **Clonar o Repositório:**
   ```bash
   git clone https://seu-repositorio.com/to-do-list.git
   cd to-do-list
   ```

2. **Construir o Projeto:**
   ```bash
   ./mvnw clean package
   ```

3. **Configurar o PostgreSQL:**
   - [Instalar](https://www.postgresql.org/download/) o PostgreSQL.
   - Configurar o PostgreSQL conforme as configurações especificadas no arquivo [application.properties](https://github.com/gusmaomatheus/to-do-list/blob/main/src/main/resources/application.properties).
     - obs: configure o `username` e a `password` de acordo com o que você especificou na hora da instalação do banco de dados.

4. **Executar a Aplicação:**
   ```bash
   java -jar target/to-do-list-1.0.0.jar
   ```

A API poderá ser acessada em [localhost:8080](http://localhost:8080). 🚀

## API Endpoints 🌐

Para fazer as requisições HTTP abaixo, foi utilizada a ferramenta [httpie](https://httpie.io):

1. **Criar tarefa**
    ```bash
    http POST :8080/task-api/tasks name="Tarefa #1" description="Muito legal!" active="true" priority="HIGH"
    ```
    - Resultado esperado:
    ```json
    [
        {
            "id": "6ee8af2e-e0dc-4817-926f-19b1621387ec",
            "name": "Tarefa #1",
            "description": "Muito legal!",
            "active": true,
            "priority": "HIGH"
        }
    ]
    ```
2. **Listar tarefas**
    ```bash
    http GET :8080/task-api/tasks
    ```
    - Resultado esperado:
    ```json
    [
        {
            "id": "6ee8af2e-e0dc-4817-926f-19b1621387ec",
            "name": "Tarefa #1",
            "description": "Muito legal!",
            "active": true,
            "priority": "HIGH"
        }
    ]
    ```
3. **Atualizar tarefa**
    ```bash
    PUT :8080/task-api/tasks name="Nova tarefa #1" description="Nova descrição muito legal!" active="false" priority="LOW"
    ```
    - Resultado esperado:
    ```json
    [
        {
            "id": "6ee8af2e-e0dc-4817-926f-19b1621387ec",
            "name": "Nova tarefa #1",
            "description": "Nova descrição muito legal!",
            "active": false,
            "priority": "LOW"
        }
    ]
    ```
4. **Remover tarefa**
    ```bash
    http DELETE :8080/task-api/tasks
    ```
    - Resultado esperado: (ele não retorna body apenas um NO_CONTENT, então use o GET novamente para visualizar as alterações)
    ```json
    []
    ```