# 🚀 ifood Dev Week 🚀

> Repositório do evento ifood Dev Week da DIO

## 👨‍💻 Tecnologias utilizadas 👩‍💻

- Java 17 : Linguagem de programação

- Spring Framework : Framework para desenvolvimento WEB

	- Spring WEB
	- Spring Dev Tools
	- Spring Data JPA
	- Spring Validation
	- Driver do PostgreSQL
	- Flyway
	- Lombok
	
- REST : Arquitetura da API 
	
- PostgreSQL : Banco de dados

- Docker : Plataforma de containers

- Insomnia : API Client para testes (alternativa ao Postman)

- SpringDoc / Swagger UI : Documentação Open API

## ➕ O que fiz além ✨

- Uso do Flyway para migrações de banco de dados

- Uso do PostgreSQL como banco de dados

- Validação das entradas de dados (input request dto)

- Uso do Docker

	- para criar um container com PostgreSQL
	- comando para criação do container:

				docker volume create postgres_vol
				docker run --name postgresdev -p 5432:5432 -v postgres_vol:/var/lib/postgresql/data -e POSTGRES_PASSWORD=postgres -e POSTGRES_USER=postgres -e POSTGRES_DB=postgres -d postgres:alpine

- Uso do DBeaver

	- para criar o database ifood_sacola
	- para testar as DDL antes da criação da migration
