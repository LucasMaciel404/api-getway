# API de Verificação e Login de Usuários

Este projeto é o serviço de autenticação e gerenciamento de usuários de uma aplicação voltada para manicures.  
Ele faz parte de uma arquitetura baseada em microservices, desenvolvida com o objetivo de:

- Aprimorar o aprendizado em desenvolvimento de APIs e microsserviços.
- Facilitar a manutenção e evolução do sistema, permitindo que cada serviço seja atualizado ou expandido de forma independente.
- Garantir escalabilidade, separando responsabilidades e otimizando recursos.

# Tecnologias previstas
- Java com Spring Boot
- Spring Data JPA para persistência
- PostgreSQL como banco de dados
- Springdoc OpenAPI (Swagger) para documentação
- Futuro suporte a JWT para autenticação segura

# Objetivo inicial
Implementar endpoints para:
- Cadastro de usuários
- Login e verificação de credenciais
- Integração futura com os demais microservices do ecossistema

Como iniciar o banco de dados com Docker Compose
------------------------------------------------
O projeto já possui um arquivo docker-compose.yml na raiz configurado para PostgreSQL.

Para iniciar o banco, execute:

    docker-compose up -d

Isso irá:
- Baixar a imagem do PostgreSQL (caso não tenha)
- Criar e iniciar o container
- Mapear a porta 5432 para acesso local
- Manter os dados persistentes no volume 'pgdata'
