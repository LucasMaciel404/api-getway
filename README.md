# API de Verificação e Login de Usuários

Este projeto é o getway de autenticação e gerenciamento de usuários de
uma aplicação voltada para manicures.
Ele faz parte de uma arquitetura baseada em microservices, que será toda desenvolvida
com o objetivo de:

-   Aprimorar o aprendizado em desenvolvimento de APIs e microsserviços.
-   Facilitar a manutenção e evolução do sistema, permitindo que cada
    serviço seja atualizado ou expandido de forma independente.
-   Garantir escalabilidade, separando responsabilidades e otimizando
    recursos.
-   Utilização de Migrations para historico do banco de dados
## Tecnologias previstas

-   Java com Spring Boot
-   Spring Data JPA para persistência
-   PostgreSQL como banco de dados
-   Springdoc OpenAPI (Swagger) para documentação
-   suporte a JWT para autenticação segura

## Objetivo inicial

Implementar endpoints para: - Cadastro de usuários - Login e verificação
de credenciais - Integração futura com os demais microservices do
ecossistema

## Como iniciar o banco de dados com Docker Compose

O projeto já possui um arquivo docker-compose.yml na raiz configurado
para PostgreSQL.

### Para iniciar o banco, execute:

    docker-compose up -d

Isso irá: - Baixar a imagem do PostgreSQL (caso não tenha) - Criar e
iniciar o container - Mapear a porta 5432 para acesso local - Manter os
dados persistentes no volume ‘pgdata’

## Coisas feitas

-   Implementação cadastro de usuários
-   Implementação login 
-   Implementação criptografia de senha utilizando hash e salt
-   Implementação do suporte a JWT para autenticação mais segura
-   Implementação da criação do banco de dados com Docker
-   Implementação da arquitetura em camadas de forma simples
