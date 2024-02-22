# SwingTest
 CRUD

<hr>

O teste consiste em desenvolver um simples sistema de estacionamento utilizando Java.

Java
•	A primeira tela da aplicação deve ser a tela de login, onde será preenchido um usuário e senha padrão que já devem estar definidos no banco. Exemplo - Usuário: admin, senha: 123456.
•	Após ser feito o login, irá para a tela principal, onde deve conter a lista de veículos, botões para entrada, edição e saída de veículos.
•	Tela de formulário onde serão preenchidos os dados do veículo com os seguintes campos: Placa e Modelo que serão digitados pelo admin. A data de entrada deve ser adicionada pelo sistema assim que for aberta a tela de inserção, e não pode ser alterada
•	A tela de edição deve permitir somente alterar a placa e o modelo do carro.
•	A tela de saída deve apresentar também o horário de saída, tempo que ficou estacionado e o valor do pagamento, e quando der saída, o carro não será apresentado mais na tabela de veículos estacionados.
•	Sempre que houver qualquer alteração nos veículos, a lista deve ser atualizada.
•	Criar combobox para mostrar na lista os veículos que estão estacionados ou veículos que já saíram.
•	Para os veículos ainda estacionados, a tabela deve conter apenas o id, o modelo, a placa e horário de entrada
•	Para os veículos que já saíram, a tabela deve conter todos os campos da tbl_movimentação do banco

MySQL
•	Criar as tabelas: tbl_movimentacao, tbl_usuario e tbl_valor
•	Tabela de movimentação deve conter os seguintes campos: id, placa, modelo, data_entrada, data_saida, tempo e valor_pago
•	Tabela de usuário deve conter os seguintes campos: id, nome, usuario e senha
•	Tabela de valor deve conter os seguintes campos: id, valor_primeira_hora, valor_demais horas e data_fim
•	Os dados da tabela de valor devem ser definidos direto no banco dessa forma (codigo = 1, valor_primeira_hora=6.00, valor_demais_horas=4.00, data_fim=null)
•	Os dados da tbl_usuario devem ser definidos direto no banco (nome=admin, usuario=admin, senha=123456)
Regra de negócio
•	Assim que um carro for inserido, e logo em seguida houver sua saída, o tempo ficará como 1 hora e será cobrado os R$ 6,00
•	Para cada hora adicional, será cobrado os R$ 4,00
•	Calcular valor do pagamento na hora da saída do veículo, utilizando os valores da tbl_valor e o tempo em que o veículo ficou estacionado
•	Validar todos os campos de entrada de dados

 
<hr> 

crud feito com netbeans 11, java 11 e mysql

**informacao que debe ser modificada nas clases Usuario e ConsultaUsuario

String url = "jdbc:tu_base_de_dados://localhost:3306/interfaz"; String usuario = "tu_usuario"; String contraseña = "tu_senha";

**informacao para a base de datos

CREATE SCHEMA interfaz ;

CREATE TABLE usuarios ( id int NOT NULL AUTO_INCREMENT, nombre varchar(45) NOT NULL, domicilio varchar(45) NOT NULL, telefono varchar(45) NOT NULL, nick varchar(45) NOT NULL, contraseña varchar(45) NOT NULL, tipousuario varchar(45) NOT NULL, PRIMARY KEY (id) ) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb3
