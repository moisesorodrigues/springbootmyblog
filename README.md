# springbootmyblog
Aplicação desenvolvida com Spring (Boot, MVC, Data JPA e Security), Thymeleaf, Bootstrap e PostgreSQL.

1) Após o desenvolvimento da aplicação será necessário fazer a instalação da AWS CLI e utilizar as suas chaves de acesso para a conexão;

2) No diretório raiz da aplicação será necessário executar o comando eb init;

3) Em seguida serão preenchidas as seguintes informações:<br>
    <i>
    a) Definição da região do servidor;<br>
    b) Definição do nome da aplicação;<br>
    c) Definição do tipo de plataforma (Java);<br>
    d) Definição da versão do Java;<br>
    e) Definição do uso de SSH;<br>
    f) Definição da chave de acesso.
    </i>

4) Após será criada uma pasta de nome .elasticbeanstalk com o arquivo config.yml que contém as informações sobre o ambiente criado na AWS;

5) O próximo passo será a criação do banco de dados Postgresql na AWS RDS através do comando eb create --scale 1 -db -db.engine postgres -db.i db.t2.micro;

6) Em seguida serão preenchidas as seguintes informações:
    <i>
    a) Definição do nome do banco de dados;<br>
    b) Definição do DNS;<br>
    c) Definição do tipo do load balancer (aplicação);<br>
    d) Definição do uso do spot fleet;<br>
    e) Definição do nome do usuário para conexão ao banco de dados;<br>
    f) Definição da senha para conexão ao banco de dados.
    </i>

7) O próximo passo será a criação do arquivo application-beanstalk.properties dentro da pasta resources com o seguinte conteúdo:
    <b>spring.datasource.url=jdbc:postgresql://${rds.hostname}:${rds.port}/${rds.db.name}<br>
    spring.datasource.username=${rds.username}<br>
    spring.datasource.password=${rds.password}
    </b>

8) O próximo passo será a criação de um profile no arquivo pom.xml com as seguintes informações:<br>
    a) Obtenha o profile no repositório.

9) O próximo passo será criação do arquivo .jar através do comando mvn clean package spring-boot:repackage;

10) O próximo passe será a adição dos seguintes parâmetros no arquivo config.yml:<br>
    deploy:<br>
    "tabulação" artifact: target/arquivo.jar (myblog-0.0.1-SNAPSHOT.jar, por exemplo)

11) O próximo passo será necessário executar o comando eb deploy;
