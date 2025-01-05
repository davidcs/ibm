
# TechManage - API de Gerenciamento de Usuários

Este projeto é uma API RESTful desenvolvida com Spring Boot para o gerenciamento de usuários no sistema **TechManage**. Ele permite operações básicas de CRUD (Criar, Ler, Atualizar e Excluir) e está conectado a um banco de dados relacional. 

## 🛠 Funcionalidades

A API implementa as seguintes operações:

1. **Criar um novo usuário**
   - Endpoint: `POST /api/v1/user`
   - Cria um novo usuário com os dados fornecidos.

2. **Buscar todos os usuários**
   - Endpoint: `GET /api/v1/user`
   - Retorna a lista de todos os usuários cadastrados.

3. **Buscar um usuário por ID**
   - Endpoint: `GET /api/v1/user/{id}`
   - Retorna os dados de um usuário específico.
   - Responde com erro `404` caso o usuário não exista.

4. **Atualizar um usuário existente**
   - Endpoint: `PUT /api/v1/user/{id}`
   - Atualiza os dados de um usuário.
   - Valida os dados enviados.

5. **Excluir um usuário**
   - Endpoint: `DELETE /api/v1/user/{id}`
   - Exclui o usuário correspondente ao ID fornecido.
   - Responde com erro `404` caso o usuário não exista.

## 🗃 Banco de Dados

- Banco utilizado: **PostgreSQL**
- Estrutura das tabelas gerada automaticamente pelo Spring Data JPA com base na entidade `User`.
- Scripts SQL incluídos em `src/main/resources/data.sql`.

## 🚦 Validações

A entidade `User` possui as seguintes validações:

- `id`: Gerado automaticamente.
- `fullName`: Obrigatório, não vazio.
- `email`: Obrigatório, válido e único.
- `phone`: Formato internacional obrigatório (ex.: +55 11 99999-9999).
- `birthDate`: Obrigatório.
- `userType`: Enum com valores possíveis: `ADMIN`, `EDITOR`, `VIEWER`.

## ⚙️ Como Executar o Projeto

### Pré-requisitos

1. **Java 17 ou superior**
2. **Maven** para gerenciamento de dependências.
3. Banco de dados configurado conforme indicado (ou usar H2 em modo in-memory).

### Passos

1. Clone o repositório:
   ```bash
   git clone https://github.com/seu-usuario/seu-repositorio.git
   cd seu-repositorio
   ```

2. Configure o banco de dados no arquivo `application.properties` (exemplo para H2):
   ```properties
   spring.datasource.url=jdbc:h2:mem:testdb
   spring.datasource.driver-class-name=org.h2.Driver
   spring.datasource.username=sa
   spring.datasource.password=
   spring.jpa.database-platform=org.hibernate.dialect.H2Dialect
   ```

3. Compile o projeto:
   ```bash
   mvn clean install
   ```

4. Execute a aplicação:
   ```bash
   mvn spring-boot:run
   ```

5. Acesse a aplicação em: `http://localhost:8080/api/v1/user`.

## 🧪 Testes

- **Testes unitários**: Para rodar os testes, execute:
  ```bash
  mvn test
  ```
- **Cobertura de Testes**:
  - Testes unitários para os serviços.
  - Testes de integração para os endpoints da API.

## 📄 Exemplos de Requisição

### Criar um novo usuário

**POST** `/api/users`
```json
{
  "fullName": "João Silva",
  "email": "joao.silva@example.com",
  "phone": "+55 11 99999-9999",
  "birthDate": "1990-05-15",
  "userType": "ADMIN"
}
```

**Resposta (201):**
```json
{
  "id": 1,
  "fullName": "David Silva",
  "email": "david.silva@example.com",
  "phone": "+55 11 99999-9999",
  "birthDate": "1990-05-15",
  "userType": "ADMIN"
}
```

### Buscar todos os usuários

**GET** `/api/users`

**Resposta (200):**
```json
[
  {
    "id": 1,
    "fullName": "David Silva",
    "email": "david.silva@example.com",
    "phone": "+55 11 99999-9999",
    "birthDate": "1990-05-15",
    "userType": "ADMIN"
  }
]
```

### Atualizar um usuário

**PUT** `/api/users/1`
```json
{
  "fullName": "David Silva",
  "email": "david.silva@example.com",
  "phone": "+55 11 88888-8888",
  "birthDate": "1990-05-15",
  "userType": "EDITOR"
}
```

**Resposta (200):**
```json
{
  "id": 1,
  "fullName": "David Silva",
  "email": "david.silva@example.com",
  "phone": "+55 11 88888-8888",
  "birthDate": "1990-05-15",
  "userType": "EDITOR"
}
```

## 📂 Estrutura do Projeto

```
src
├── main
│   ├── java
│   │   └── br.com.ibm
│   │       ├── controllers
│   │       ├── dtos
│   │       ├── repository
│   │       └── models
│   └── resources
│       ├── application.properties
│       └── data.sql
└── test
    └── java
        └── br.com.ibm
```

## 📜 Licença

Este projeto parte de um processo seletivo. Todos os direitos reservados.
