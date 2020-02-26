# SQL-Front 5.1  (Build 4.16)

/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE */;
/*!40101 SET SQL_MODE='STRICT_TRANS_TABLES,ERROR_FOR_DIVISION_BY_ZERO,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES */;
/*!40103 SET SQL_NOTES='ON' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS */;
/*!40014 SET FOREIGN_KEY_CHECKS=0 */;


# Host: cone.fbsis.com:3316    Database: eventuar_rsvp
# ------------------------------------------------------
# Server version 5.5.5-10.4.6-MariaDB-1:10.4.6+maria~bionic

#
# Source for table invites
#

DROP TABLE IF EXISTS `invites`;
CREATE TABLE `invites` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `data` varchar(255) DEFAULT NULL,
  `idade` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `public_id` varchar(255) DEFAULT NULL,
  `sobrenome` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=66 DEFAULT CHARSET=latin1;

#
# Dumping data for table invites
#

LOCK TABLES `invites` WRITE;
/*!40000 ALTER TABLE `invites` DISABLE KEYS */;
INSERT INTO `invites` VALUES (7,'14/22/2020 22:22:37',NULL,'Vanessa',NULL,'Diniz');
INSERT INTO `invites` VALUES (8,'17/39/2020 13:39:06',NULL,'teste vaness',NULL,'eu mesma');
INSERT INTO `invites` VALUES (9,NULL,'','Felipe',NULL,NULL);
INSERT INTO `invites` VALUES (10,NULL,'1','Eurinho',NULL,NULL);
INSERT INTO `invites` VALUES (11,NULL,'7','alguém',NULL,NULL);
INSERT INTO `invites` VALUES (12,'17/49/2020 13:49:48',NULL,'teste vaness',NULL,'eu mesma');
INSERT INTO `invites` VALUES (14,'17/27/2020 18:27:51',NULL,'teste 3',NULL,'diniz');
INSERT INTO `invites` VALUES (15,NULL,'','teste',NULL,NULL);
INSERT INTO `invites` VALUES (16,NULL,'7','hsgdgd',NULL,NULL);
INSERT INTO `invites` VALUES (17,NULL,'5','djdfjf',NULL,NULL);
INSERT INTO `invites` VALUES (18,'17/29/2020 18:29:26',NULL,'Teste celular ',NULL,'Celular ');
INSERT INTO `invites` VALUES (19,NULL,'','Teste',NULL,NULL);
INSERT INTO `invites` VALUES (20,NULL,'5','Bshshs',NULL,NULL);
INSERT INTO `invites` VALUES (21,NULL,'7','Bshssh',NULL,NULL);
INSERT INTO `invites` VALUES (22,NULL,'','Bshehs',NULL,NULL);
INSERT INTO `invites` VALUES (35,'17/02/2020 19:02:43',NULL,'Teste ',NULL,'Celular 2');
INSERT INTO `invites` VALUES (36,NULL,'33','Ggg',NULL,NULL);
INSERT INTO `invites` VALUES (37,'17/03/2020 19:03:12',NULL,'Teste ',NULL,'Celular 2');
INSERT INTO `invites` VALUES (38,'17/21/2020 19:21:14',NULL,'César',NULL,'Souza');
INSERT INTO `invites` VALUES (39,'18/13/2020 22:13:56',NULL,'Teste celular ',NULL,'Teste ');
INSERT INTO `invites` VALUES (40,NULL,'4','Gggg',NULL,NULL);
INSERT INTO `invites` VALUES (41,'18/03/2020 23:03:56',NULL,'Felipe',NULL,'Sobrenome');
INSERT INTO `invites` VALUES (42,NULL,'12','criança',NULL,NULL);
INSERT INTO `invites` VALUES (43,'20/26/2020 13:26:53',NULL,'Xxx',NULL,'Gggg');
INSERT INTO `invites` VALUES (44,NULL,'3','Jjj',NULL,NULL);
INSERT INTO `invites` VALUES (45,NULL,'5','Ghhhh',NULL,NULL);
INSERT INTO `invites` VALUES (46,'20/31/2020 13:31:48',NULL,'Cristina Helena ',NULL,'Felício dos Santos');
INSERT INTO `invites` VALUES (47,NULL,'','Isabel Cristina',NULL,NULL);
INSERT INTO `invites` VALUES (48,NULL,'','Laura Cristina',NULL,NULL);
INSERT INTO `invites` VALUES (49,NULL,'','Eduarda Cristina',NULL,NULL);
INSERT INTO `invites` VALUES (50,'20/32/2020 13:32:39',NULL,'Cristina Helena ',NULL,'Felício dos Santos');
INSERT INTO `invites` VALUES (51,'20/35/2020 13:35:12',NULL,'Jhh',NULL,'Nnn');
INSERT INTO `invites` VALUES (52,'20/35/2020 13:35:31',NULL,'Cristina Helena ',NULL,'Laura Cristina,  Isabel Cristina e Eduarda Cristina ');
INSERT INTO `invites` VALUES (53,'20/35/2020 13:35:42',NULL,'Felipe testes áéíóú',NULL,'Felipe testes áéíóú');
INSERT INTO `invites` VALUES (54,NULL,'123','áéíóú',NULL,NULL);
INSERT INTO `invites` VALUES (55,'20/02/2020 15:02:25',NULL,'Vanessa',NULL,'Teste ');
INSERT INTO `invites` VALUES (56,NULL,'3','Felipe',NULL,NULL);
INSERT INTO `invites` VALUES (57,'21/05/2020 01:05:38',NULL,'João',NULL,'Dos Santos Ferreira');
INSERT INTO `invites` VALUES (58,NULL,'','',NULL,NULL);
INSERT INTO `invites` VALUES (59,NULL,'','Bruno Lyra Ferreira',NULL,NULL);
INSERT INTO `invites` VALUES (60,NULL,'','Luzia Nara Lyra ferreira',NULL,NULL);
INSERT INTO `invites` VALUES (61,NULL,'','João dia Santos Ferreira',NULL,NULL);
INSERT INTO `invites` VALUES (62,'21/06/2020 01:06:18',NULL,'João',NULL,'Dos Santos Ferreira');
INSERT INTO `invites` VALUES (63,'21/46/2020 11:46:00',NULL,'',NULL,'');
INSERT INTO `invites` VALUES (64,'21/46/2020 11:46:01',NULL,'',NULL,'');
INSERT INTO `invites` VALUES (65,'24/43/2020 21:43:59',NULL,'Tania (Acolhida)',NULL,'Crespo ');
/*!40000 ALTER TABLE `invites` ENABLE KEYS */;
UNLOCK TABLES;

#
# Source for table invites_companion
#

DROP TABLE IF EXISTS `invites_companion`;
CREATE TABLE `invites_companion` (
  `invites_id` int(11) NOT NULL,
  `companion_id` int(11) NOT NULL,
  UNIQUE KEY `UK_ftucc4lvn5ipm4dwgakxke71f` (`companion_id`),
  KEY `FKhk01ry78ikwly1ihv8bjwle6k` (`invites_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

#
# Dumping data for table invites_companion
#

LOCK TABLES `invites_companion` WRITE;
/*!40000 ALTER TABLE `invites_companion` DISABLE KEYS */;
INSERT INTO `invites_companion` VALUES (8,9);
INSERT INTO `invites_companion` VALUES (8,10);
INSERT INTO `invites_companion` VALUES (8,11);
INSERT INTO `invites_companion` VALUES (14,15);
INSERT INTO `invites_companion` VALUES (14,16);
INSERT INTO `invites_companion` VALUES (14,17);
INSERT INTO `invites_companion` VALUES (18,19);
INSERT INTO `invites_companion` VALUES (18,20);
INSERT INTO `invites_companion` VALUES (18,21);
INSERT INTO `invites_companion` VALUES (18,22);
INSERT INTO `invites_companion` VALUES (35,36);
INSERT INTO `invites_companion` VALUES (39,40);
INSERT INTO `invites_companion` VALUES (41,42);
INSERT INTO `invites_companion` VALUES (43,44);
INSERT INTO `invites_companion` VALUES (43,45);
INSERT INTO `invites_companion` VALUES (46,47);
INSERT INTO `invites_companion` VALUES (46,48);
INSERT INTO `invites_companion` VALUES (46,49);
INSERT INTO `invites_companion` VALUES (53,54);
INSERT INTO `invites_companion` VALUES (55,56);
INSERT INTO `invites_companion` VALUES (57,58);
INSERT INTO `invites_companion` VALUES (57,59);
INSERT INTO `invites_companion` VALUES (57,60);
INSERT INTO `invites_companion` VALUES (57,61);
/*!40000 ALTER TABLE `invites_companion` ENABLE KEYS */;
UNLOCK TABLES;

#
# Source for table party
#

DROP TABLE IF EXISTS `party`;
CREATE TABLE `party` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `data` varchar(255) DEFAULT NULL,
  `event_name` varchar(255) DEFAULT NULL,
  `hour` varchar(255) DEFAULT NULL,
  `imagem` varchar(255) DEFAULT NULL,
  `invite_url` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `description` longtext DEFAULT NULL,
  `local` longtext DEFAULT NULL,
  `sucesso` longtext DEFAULT NULL,
  `img_verso` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

#
# Dumping data for table party
#

LOCK TABLES `party` WRITE;
/*!40000 ALTER TABLE `party` DISABLE KEYS */;
INSERT INTO `party` VALUES (3,'28/03/2020','XV da Eduarda','20:00','-','1724b5bb',NULL,'<p style=\"text-align: center;\"><span style=\"font-family: Verdana, Geneva, sans-serif;\">Estamos muito felizes que veio confirmar sua presen&ccedil;a! As regras s&atilde;o:</span></p>\r\n<ol>\r\n<li><em><strong>Chegue cedo para aproveitar a festa</strong></em></li>\r\n<li><em><strong>Tire muitas fotos</strong></em></li>\r\n<li><strong><em>Divirta-se!!!</em></strong></li>\r\n</ol>\r\n<p style=\"text-align: center;\">Traje: Esporte Fino / Social</p>\r\n<p style=\"text-align: center;\"><span style=\"font-family: Verdana, Geneva, sans-serif;\">Importante: <strong><span style=\"color: #b8312f;\">Caso haja desist&ecirc;ncia, FAVOR INFORME COM ANTECED&Ecirc;NCIA</span></strong> (21) 98312-5436</span></p>','<p><strong><span style=\"font-size: 18px;\">Espa&ccedil;o JR Buffet e Decora&ccedil;&otilde;es&nbsp;</span></strong>- <em>Estrada do Barro Vermelho n&ordm; 1291 - Rocha Mirand</em></p>','<h5 style=\"text-align: center;\">A sua presen&ccedil;a e de seu(s) acompanhante(s) est&aacute; confirmada!</h5>\r\n<p style=\"text-align: center;\">Sua presen&ccedil;a &eacute; o melhor presente mas, caso queira presentear a debutante, fica a dica dos presentes mais desejados</p>','-');
INSERT INTO `party` VALUES (5,'18/04/2020','XV da Mariana','20:00','-','51736443',NULL,'<p>Obrigada por vir confirmar sua presen&ccedil;a no&nbsp;<strong>XV da Mari</strong></p>\r\n<p>As regras s&atilde;o:</p>\r\n<ul>\r\n<li>Chegue cedo</li>\r\n<li>Tire muitas fotos</li>\r\n<li>Coma e beba sem modera&ccedil;&atilde;o</li>\r\n<li>Divirta-se</li>\r\n</ul>','<p>Tropical Festas e Eventos - Avenida Monsenhor Felix 255, Iraj&aacute;</p>','<h5 style=\"text-align: center;\"><span style=\"font-size: 12pt;\">A sua presen&ccedil;a e de seu(s) acompanhante(s) est&aacute; confirmada!</span></h5>\r\n<p style=\"text-align: center;\">Importante: Caso haja desist&ecirc;ncia, INFORMAR COM ANTECED&Ecirc;NCIA para (21) 98312-5436</p>','-');
/*!40000 ALTER TABLE `party` ENABLE KEYS */;
UNLOCK TABLES;

#
# Source for table party_invites
#

DROP TABLE IF EXISTS `party_invites`;
CREATE TABLE `party_invites` (
  `party_id` int(11) NOT NULL,
  `invites_id` int(11) NOT NULL,
  UNIQUE KEY `UK_gx5an7rv8ix5eft0upevclbbs` (`invites_id`),
  KEY `FKgtpf010s061v1vhbre0lohi2s` (`party_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

#
# Dumping data for table party_invites
#

LOCK TABLES `party_invites` WRITE;
/*!40000 ALTER TABLE `party_invites` DISABLE KEYS */;
INSERT INTO `party_invites` VALUES (3,7);
INSERT INTO `party_invites` VALUES (3,8);
INSERT INTO `party_invites` VALUES (3,12);
INSERT INTO `party_invites` VALUES (3,14);
INSERT INTO `party_invites` VALUES (3,18);
INSERT INTO `party_invites` VALUES (3,35);
INSERT INTO `party_invites` VALUES (3,37);
INSERT INTO `party_invites` VALUES (3,38);
INSERT INTO `party_invites` VALUES (3,39);
INSERT INTO `party_invites` VALUES (3,41);
INSERT INTO `party_invites` VALUES (3,43);
INSERT INTO `party_invites` VALUES (3,46);
INSERT INTO `party_invites` VALUES (3,50);
INSERT INTO `party_invites` VALUES (3,51);
INSERT INTO `party_invites` VALUES (3,52);
INSERT INTO `party_invites` VALUES (3,53);
INSERT INTO `party_invites` VALUES (3,65);
INSERT INTO `party_invites` VALUES (5,55);
INSERT INTO `party_invites` VALUES (5,57);
INSERT INTO `party_invites` VALUES (5,62);
INSERT INTO `party_invites` VALUES (5,63);
INSERT INTO `party_invites` VALUES (5,64);
/*!40000 ALTER TABLE `party_invites` ENABLE KEYS */;
UNLOCK TABLES;

#
# Source for table user
#

DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `email` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

#
# Dumping data for table user
#

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'vanessa@fbsis.com','Vanessa','senha');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

#
# Source for table user_parties
#

DROP TABLE IF EXISTS `user_parties`;
CREATE TABLE `user_parties` (
  `user_id` int(11) NOT NULL,
  `parties_id` int(11) NOT NULL,
  UNIQUE KEY `UK_1a4q73yy141fikvl0d8mnd2bo` (`parties_id`),
  KEY `FKl5yuwc6wwwefn8nguysb69omu` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

#
# Dumping data for table user_parties
#

LOCK TABLES `user_parties` WRITE;
/*!40000 ALTER TABLE `user_parties` DISABLE KEYS */;
/*!40000 ALTER TABLE `user_parties` ENABLE KEYS */;
UNLOCK TABLES;

#
#  Foreign keys for table invites_companion
#

ALTER TABLE `invites_companion`
ADD CONSTRAINT `FKbknhm5f5ri9n4oukve36qbg77` FOREIGN KEY (`companion_id`) REFERENCES `invites` (`id`),
ADD CONSTRAINT `FKhk01ry78ikwly1ihv8bjwle6k` FOREIGN KEY (`invites_id`) REFERENCES `invites` (`id`);

#
#  Foreign keys for table party_invites
#

ALTER TABLE `party_invites`
ADD CONSTRAINT `FKgtpf010s061v1vhbre0lohi2s` FOREIGN KEY (`party_id`) REFERENCES `party` (`id`),
ADD CONSTRAINT `FKp3a5wrpbwpf7tykeh2b7a761d` FOREIGN KEY (`invites_id`) REFERENCES `invites` (`id`);

#
#  Foreign keys for table user_parties
#

ALTER TABLE `user_parties`
ADD CONSTRAINT `FKjn5yo153nxx669hxkkt04vegn` FOREIGN KEY (`parties_id`) REFERENCES `party` (`id`),
ADD CONSTRAINT `FKl5yuwc6wwwefn8nguysb69omu` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`);


/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
