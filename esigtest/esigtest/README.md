# Projeto Gerenciador de Tarefas

Este é um projeto de exemplo de um gerenciador de tarefas desenvolvido em Java com Spring Boot.

## Requisitos

- Java 11 ou superior
- PostgreSQL

## Configuração do Banco de Dados

1. Crie um banco de dados PostgreSQL com o nome `gerenciador_tarefas`.
2. Atualize as configurações do banco de dados no arquivo `application.properties`.

## Executando o Projeto

1. Clone o repositório:

   ```bash
   git clone https://github.com/RychardRS/gerenciador-tarefas.git






# Tutorial para leigos
Aqui está um guia passo a passo sobre como desenvolver o backend utilizando Java 11 e Spring Boot para criar um simples gerenciador de tarefas com os requisitos especificados:

Passo 1: Configuração do Ambiente

Certifique-se de ter o seguinte ambiente configurado em sua máquina:

Java 11 instalado.
PostgreSQL instalado e configurado.
Um ambiente de desenvolvimento Java IDE (VsCode).

Passo 2: Configuração do Projeto

Crie um projeto Spring Boot utilizando o Spring Initializr ou sua IDE preferida, e inclua as seguintes dependências:

Spring Web
Spring Data JPA
Spring Security
PostgreSQL Driver
Spring Boot DevTools
Spring Boot Actuator
Springdoc OpenAPI (para a documentação do Swagger)
Passo 3: Configuração do Banco de Dados

Configure as propriedades do banco de dados no arquivo application.properties:

spring.datasource.url=jdbc:postgresql://localhost:5432/nome-do-seu-banco
spring.datasource.username=seu-usuario
spring.datasource.password=sua-senha
spring.datasource.driver-class-name=org.postgresql.Driver
spring.jpa.hibernate.ddl-auto=update

Passo 4: Implementação da Entidade de Tarefa

Crie uma entidade de Tarefa com os campos especificados (Título, descrição, responsável, prioridade, deadline, situação)

Passo 5: Criar um Repositório JPA

Crie um repositório JPA para a entidade Tarefa

Passo 6: Implementar os Controllers

Crie um controller para gerenciar as operações de CRUD das tarefas. Você pode criar endpoints RESTful para criar, atualizar, remover e listar tarefas. Certifique-se de configurar a autenticação JWT para proteger esses endpoints.

Passo 7: Implementar o Serviço

Crie um serviço para realizar a lógica de negócios para criar, atualizar, remover e listar tarefas. Use o repositório JPA para interagir com o banco de dados.

Passo 8: Implementar a Autenticação JWT

Configure o Spring Security para lidar com a autenticação por usuário e senha e gerar tokens JWT para os usuários autenticados.

Passo 9: Implementar os Testes de Unidade

Escreva testes de unidade para os serviços e controllers para garantir que o aplicativo funcione conforme o esperado.

Passo 10: Documentação com Swagger

Configure o Swagger (Springdoc OpenAPI) para documentar a API. Isso incluirá informações sobre os endpoints, parâmetros, respostas e autenticação.

Passo 11: Criar o arquivo de Orientações/README.md

Crie um arquivo chamado 'orientacoes' ou inclua as instruções no arquivo 'README.md' explicando brevemente o que foi feito e fornecendo instruções detalhadas sobre como executar o projeto em um ambiente local.

Passo 12: Testar e Executar o Projeto

Teste todas as funcionalidades do seu aplicativo e verifique se a documentação do Swagger está acessível em uma URL específica.

Isso deve fornecer um ponto de partida para desenvolver o backend Java 11 com Spring Boot para um gerenciador de tarefas com autenticação JWT, persistência JPA em um banco de dados PostgreSQL, testes de unidades e documentação do Swagger. Certifique-se de adaptar o código às necessidades específicas do seu projeto.