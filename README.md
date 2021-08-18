# SwingTest
 CRUD
 

crud feito com netbeans 11, java 11 e mysql

**informacao que debe ser modificada nas clases Usuario e ConsultaUsuario

String url = "jdbc:tu_base_de_dados://localhost:3306/interfaz"; String usuario = "tu_usuario"; String contraseña = "tu_senha";

**informacao para a base de datos

CREATE SCHEMA interfaz ;

CREATE TABLE usuarios ( id int NOT NULL AUTO_INCREMENT, nombre varchar(45) NOT NULL, domicilio varchar(45) NOT NULL, telefono varchar(45) NOT NULL, nick varchar(45) NOT NULL, contraseña varchar(45) NOT NULL, tipousuario varchar(45) NOT NULL, PRIMARY KEY (id) ) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb3
