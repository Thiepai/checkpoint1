📌 Checkpoint 1 - API Java para Controle de Pacientes

Bem-vindo à API Java para controle de pacientes! Este projeto utiliza Spring Boot e Swagger para facilitar a documentação e o desenvolvimento.

🚀 Instalação

Limpe e crie a pasta /target executando o seguinte comando:

mvn clean package

⚙️ Configuração do Swagger

Para configurar o Swagger, utilize as propriedades abaixo no arquivo application.properties:

springdoc.swagger-ui.path=/
springdoc.swagger-ui.disable-swagger-default-url=true

Mais detalhes sobre a configuração podem ser encontrados na documentação oficial do SpringDoc: SpringDoc Properties

🔍 Navegação

▶️ Executando a API

Para rodar a API com o Maven, utilize o comando:

mvn spring-boot:run

📜 Acessando a documentação (Swagger)

Após iniciar a aplicação, acesse a interface do Swagger pelo seguinte link:
http://localhost:8080/swagger-ui/index.html

📚 Referências

🔗 SpringDoc - Documentação Oficial
