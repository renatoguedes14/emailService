# 1 - Como executar a aplicação 
<b>Para compilar e executar: </b> na raíz do projeto, execute o comando: mvn spring-boot:run

<b>Requisitos para executar a aplicação: </b> É necessário ter PostgreSQL instalado e um banco de dados configurado. Em 'application.properties', altere os parâmetros '<b>spring.datasource.url',  'spring.datasource.username'</b> e <b>'spring.datasource.password'</b> para conter os parâmetros do banco de dados local da máquina onde a aplicação será executada. A criação das tabelas e colunas é feita automaticamente
# 2 - Como testar a funcionalidade da API: 
Utilizando a requisição "Pay salary" na collection Payroll, que consta no repositório payroll.

# 3 - Informações adicionais:

O arquivo application.properties foi fornecido no anexo do e-mail contendo o link para este repositório. Por razões de segurança, removi o arquivo do repositório público.

<b>Tecnologias e bibliotecas utilizadas: </b> Java 11, Spring Boot e Spring Data, PostgreSQL, Project Lombok e RabbitMQ

## Swagger
http://localhost:8183/swagger-ui/index.html


<b>Este projeto foi desenvolvido por Renato Guedes para o processo seletivo da vaga de Desenvolvedor de back-end Sênior da Somapay.</b>
