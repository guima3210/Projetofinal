/*
SQLyog Community v13.1.6 (64 bit)
MySQL - 10.4.14-MariaDB : Database - clinica
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`clinica` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `clinica`;

/*Table structure for table `consulta` */

DROP TABLE IF EXISTS `consulta`;

CREATE TABLE `consulta` (
  `RG` varchar(9) DEFAULT NULL,
  `nome` varchar(50) DEFAULT NULL,
  `data` varchar(20) DEFAULT NULL,
  `hora` varchar(20) DEFAULT NULL,
  `idade` varchar(3) DEFAULT NULL,
  `tipo` varchar(20) DEFAULT NULL,
  `especialidade` varchar(20) NOT NULL,
  `Medico` varchar(50) NOT NULL,
  `valor` float DEFAULT 0,
  `id` int(11) NOT NULL AUTO_INCREMENT,
  UNIQUE KEY `hora` (`hora`),
  KEY `id` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

/*Data for the table `consulta` */

/*Table structure for table `declaracao` */

DROP TABLE IF EXISTS `declaracao`;

CREATE TABLE `declaracao` (
  `id` varchar(5) DEFAULT NULL,
  `nome` varchar(50) DEFAULT NULL,
  `categoria` varchar(50) DEFAULT NULL,
  `quantidade` int(11) NOT NULL DEFAULT 0,
  `mes` varchar(50) DEFAULT NULL,
  `preco` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `declaracao` */

insert  into `declaracao`(`id`,`nome`,`categoria`,`quantidade`,`mes`,`preco`) values 
('01','veja','Limpeza',1000,'02',5000),
('1','veja','Limpeza',3000,'03',5000),
('1','veja','Limpeza',1000,'02',1000),
('1','veja','Limpeza',7000,'02',5000);

/*Table structure for table `especialidade` */

DROP TABLE IF EXISTS `especialidade`;

CREATE TABLE `especialidade` (
  `especialidade` varchar(20) NOT NULL,
  `nome` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `especialidade` */

insert  into `especialidade`(`especialidade`,`nome`) values 
('Cardiaco','claudia');

/*Table structure for table `estoque` */

DROP TABLE IF EXISTS `estoque`;

CREATE TABLE `estoque` (
  `id` varchar(4) DEFAULT NULL,
  `Nome` varchar(50) DEFAULT NULL,
  `Categoria` varchar(20) DEFAULT NULL,
  `quantidade` int(11) DEFAULT 0,
  UNIQUE KEY `id` (`id`,`Nome`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `estoque` */

insert  into `estoque`(`id`,`Nome`,`Categoria`,`quantidade`) values 
('1','veja','Limpeza',14000),
('02','carne','Alimenticio',0);

/*Table structure for table `funce` */

DROP TABLE IF EXISTS `funce`;

CREATE TABLE `funce` (
  `id` varchar(20) NOT NULL,
  `Data` timestamp NULL DEFAULT NULL,
  `nome` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `funce` */

insert  into `funce`(`id`,`Data`,`nome`) values 
('12345678','2020-09-16 02:39:13','edson'),
('123456798','2020-09-16 02:42:51','gabriela');

/*Table structure for table `funcionario` */

DROP TABLE IF EXISTS `funcionario`;

CREATE TABLE `funcionario` (
  `rg` varchar(9) NOT NULL,
  `nome` varchar(50) NOT NULL,
  `idade` varchar(3) DEFAULT NULL,
  `loguin` varchar(50) DEFAULT NULL,
  `senha` varchar(50) DEFAULT NULL,
  `salario` float DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `numeroTel` varchar(8) DEFAULT NULL,
  `numeroCarteira` varchar(10) DEFAULT NULL,
  `sexo` varchar(20) DEFAULT NULL,
  `cargo` varchar(20) DEFAULT NULL,
  `especialidade` varchar(50) DEFAULT NULL,
  `Situacao` varchar(50) DEFAULT 'Contratado',
  UNIQUE KEY `rg` (`rg`),
  UNIQUE KEY `numeroCarteira` (`numeroCarteira`),
  UNIQUE KEY `loguin` (`loguin`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `funcionario` */

insert  into `funcionario`(`rg`,`nome`,`idade`,`loguin`,`senha`,`salario`,`email`,`numeroTel`,`numeroCarteira`,`sexo`,`cargo`,`especialidade`,`Situacao`) values 
('123456789','claudia','50','123456789','1234567810',5000,'dadad','1232','202020','Feminino','Medico','Cardiaco','Contratado'),
('17297178','edson','53','12345678','12345678',10000,'dadad','25642','5454545','Masculino','Gerente',NULL,'Contratado'),
('987654312','gabriela','30','123456798','gui',2000,'dadadadada','262626','50505050','Feminino','Gerente',NULL,'Contratado'),
('987654321','guilherme','21','1234567','1234567',1000,'dadadad','252525','323232','Masculino','Medico','Pediatra','Demitido');

/*Table structure for table `funcs` */

DROP TABLE IF EXISTS `funcs`;

CREATE TABLE `funcs` (
  `id` varchar(20) NOT NULL,
  `date` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  `nome` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `funcs` */

insert  into `funcs`(`id`,`date`,`nome`) values 
('123456798','2020-09-16 02:43:12','gabriela');

/*Table structure for table `paciente` */

DROP TABLE IF EXISTS `paciente`;

CREATE TABLE `paciente` (
  `rg` varchar(9) DEFAULT NULL,
  `nome` varchar(50) DEFAULT NULL,
  `idade` varchar(3) DEFAULT NULL,
  `alergia` varchar(100) DEFAULT NULL,
  `descricao` varchar(100) DEFAULT NULL,
  `sexo` varchar(10) DEFAULT NULL,
  `doenca` varchar(50) DEFAULT NULL,
  `medico` varchar(50) DEFAULT NULL,
  `especialidade` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `paciente` */

/*Table structure for table `produto` */

DROP TABLE IF EXISTS `produto`;

CREATE TABLE `produto` (
  `id` varchar(5) DEFAULT NULL,
  `nome` varchar(50) DEFAULT NULL,
  `categoria` varchar(50) DEFAULT NULL,
  UNIQUE KEY `id` (`id`,`nome`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `produto` */

insert  into `produto`(`id`,`nome`,`categoria`) values 
('1','veja','Limpeza'),
('02','carne','Alimenticio');

/*Table structure for table `valores` */

DROP TABLE IF EXISTS `valores`;

CREATE TABLE `valores` (
  `especialidade` varchar(50) DEFAULT NULL,
  `valor` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `valores` */

insert  into `valores`(`especialidade`,`valor`) values 
('Pediatra',500),
('Cardiaco',1000),
('ortopedia',100),
('Cirugiao',5000);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
