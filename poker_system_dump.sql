-- MySQL dump 10.13  Distrib 5.7.30, for Win64 (x86_64)
--
-- Host: localhost    Database: poker_system
-- ------------------------------------------------------
-- Server version	5.7.30-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `m_player`
--

DROP TABLE IF EXISTS `m_player`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `m_player` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(10) NOT NULL,
  `coin` int(11) NOT NULL DEFAULT '0',
  `password` varchar(64) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `name` (`name`),
  UNIQUE KEY `UK_48850os02yx5yjsjn7ppx15cc` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `m_player`
--

LOCK TABLES `m_player` WRITE;
/*!40000 ALTER TABLE `m_player` DISABLE KEYS */;
INSERT INTO `m_player` VALUES (1,'test1',100,'BC59C38E04C913FEE6A596F15445138328B60DA3E37405556A9DD5C061596A6E');
/*!40000 ALTER TABLE `m_player` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `m_role`
--

DROP TABLE IF EXISTS `m_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `m_role` (
  `id` int(11) NOT NULL,
  `name` varchar(20) NOT NULL,
  `magnification` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `m_role`
--

LOCK TABLES `m_role` WRITE;
/*!40000 ALTER TABLE `m_role` DISABLE KEYS */;
INSERT INTO `m_role` VALUES (1,'ツーペア',1),(2,'スリーカード',1),(3,'ストレート',3),(4,'フラッシュ',4),(5,'フルハウス',5),(6,'フォーカード',10),(7,'ストレートフラッシュ',20),(8,'ファイブカード',50),(9,'ロイヤルストレートフラッシュ',100),(10,'ロイヤルストレートスペード',500);
/*!40000 ALTER TABLE `m_role` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-06-03 16:19:09
