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

- Insomnia : API Client para testes (alternativa ao Postman)

- SpringDoc / Swagger UI : Documentação Open API (alternativa ao SpringFox)

- Docker : Plataforma de containers

## ➕ O que fiz além ✨

- Codei todo o projeto da minha maneira com base no diagrama de classes apresentado na aula 2 (vide material de apoio dia 2 página 9)

- Depois corrigi algumas regras de negócios para adequar as expostas nas aulas

- Implementei endpoints de CRUD para clientes, restaurantes, produtos e sacolas

- Implementei validações para as entradas de dados (todos os input request DTO's)

- Implementei DTO's de respostas ao invés de retornar os modelos de entidades nos endpoints

- Implementei exceções customizadas e os tratei no exception handler da API

- Coloquei descrições para cada endpoint na documentação

- Usei o PostgreSQL como banco de dados

- Usei o Flyway para migrações de banco de dados

- Usei o DBeaver para criar o database ifood_sacola e para testar as DDL antes da criação das migrations

- Usei o Docker para rodar o PostgreSQL

	- comando para criação do container:

				docker volume create postgres_vol
				docker run --name postgresdev -p 5432:5432 -v postgres_vol:/var/lib/postgresql/data -e POSTGRES_PASSWORD=postgres -e POSTGRES_USER=postgres -e POSTGRES_DB=postgres -d postgres:alpine

## 🖼️ Imagens do projeto 👀

Página de documentação Open API

<img src="https://raw.githubusercontent.com/rodolfoHOk/portfolio-img/main/images/ifood-dev-week-01.png" alt="ifood dev week 01" width="450"/>

<img src="https://raw.githubusercontent.com/rodolfoHOk/portfolio-img/main/images/ifood-dev-week-02.png" alt="ifood dev week 02" width="450"/>

<img src="https://raw.githubusercontent.com/rodolfoHOk/portfolio-img/main/images/ifood-dev-week-03.png" alt="ifood dev week 03" width="450"/>
