# Projeto Spring Boot com JWT e PostgreSQL

## Descrição

Este projeto é uma aplicação Spring Boot configurada para usar JWT (JSON Web Tokens) para autenticação e autorização, e
PostgreSQL como banco de dados. O projeto inclui configuração de segurança, acesso a dados com JPA e uma interface
Swagger para documentação da API.

## Dependências

As principais dependências do projeto são:

- **Spring Boot Starter Data JPA**: Para acesso e manipulação de dados com JPA.
- **Spring Boot Starter Security**: Para configuração de segurança e autenticação.
- **Spring Boot Starter Web**: Para criar a aplicação web.
- **Spring Boot DevTools**: Para desenvolvimento com suporte a recarregamento automático.
- **PostgreSQL**: Banco de dados relacional.
- **Lombok**: Para reduzir a quantidade de código boilerplate.
- **JJWT**: Para criação e verificação de tokens JWT.
- **Springdoc OpenAPI Starter WebMVC UI**: Para gerar a documentação da API com Swagger.

## Configuração

### `application.yaml`

Este arquivo contém a configuração principal da aplicação. As principais configurações incluem:

- **Datasource**: Configuração do banco de dados PostgreSQL.
- **JPA**: Configurações do Hibernate.
- **Security**: Configurações de segurança, incluindo chave secreta para JWT e o período de expiração do token.
- **CORS**: Configurações de CORS para permitir solicitações de determinados domínios e métodos.
- **Swagger**: Configuração padrão para o tipo de mídia de resposta.

## Documentação da API

A documentação da API está disponível através da interface Swagger UI no seguinte link:

[Swagger UI](http://localhost:8088/swagger-ui.html)

### Registro de Usuário

- **Endpoint**: `/api/v1/auth/signup`
- **Método**: `POST`
- **Descrição**: Registra um novo usuário.
- **Requisição**: Necessário enviar `firstname`, `lastname`, `dateOfBirth`, `email` e `password` no corpo da requisição.

### Login

- **Endpoint**: `/api/v1/auth/signin`
- **Método**: `POST`
- **Descrição**: Autentica o usuário e retorna um JWT.
- **Requisição**: Necessário enviar `email` e `password` no corpo da requisição.

### Rota Protegida sem Role

- **Endpoint**: `/api/v1/test/no-role`
- **Método**: `GET`
- **Descrição**: Rota protegida, mas não necessita de nenhuma role.

### Rota Protegida com Role

- **Endpoint**: `/api/v1/test/admin-role`
- **Método**: `GET`
- **Descrição**: Rota protegida que requer uma das roles: `ADMIN`, `MANAGER` ou `STUDENT`.

**PS: Essas roles estão no token JWT passado pelo cabeçalho HTTP Authorization.**

## Rodando o Projeto

**Após clonar o repositório e entrar no diretório, compile e execute a aplicação com o seguinte comando:**

```bash
./mvnw spring-boot:run
