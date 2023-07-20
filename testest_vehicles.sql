-- MySQL dump 10.13  Distrib 8.0.33, for Win64 (x86_64)
--
-- Host: localhost    Database: testest
-- ------------------------------------------------------
-- Server version	8.0.33

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `vehicles`
--

DROP TABLE IF EXISTS `vehicles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `vehicles` (
  `Brand` varchar(50) NOT NULL,
  `Model` varchar(50) NOT NULL,
  `Transmission` varchar(50) NOT NULL,
  `Category` varchar(50) NOT NULL,
  `Availability` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `vehicles`
--

LOCK TABLES `vehicles` WRITE;
/*!40000 ALTER TABLE `vehicles` DISABLE KEYS */;
INSERT INTO `vehicles` VALUES ('Toyota','Hilux','Manual','Pick-up','Available'),('Mitsubishi','Lancer','Manual/Automatic','Sedan','Available'),('Nissan','Sentra','Manual/Automatic','Sedan','Available'),('Mazda','323','Manual','Sedan','Available'),('Toyota','Tamaraw FX','Manual','Van','Available'),('Toyota','LiteAce','Manual','Van','Available'),('Mitsubishi','Adventure','Manual','SUV','Available'),('Toyota','Revo','Manual','SUV','Available'),('Nissan','Urvan','Manual','Van','Available'),('Toyota','Land Cruiser','Manual','SUV','Available'),('Mitsubishi','Pajero','Manual','SUV','Available'),('Suzuki','Jimny','Manual','SUV','Available'),('Toyota','Hilux','Manual','Pick-up','Available'),('Isuzu','D-Max','Manual','Pick-up','Available'),('Nissan','Navara','Manual','Pick-up','Available'),('Ford','Ranger','Manual','Pick-up','Available'),('Mazda','B-Series','Manual','Pick-up','Available'),('Toyota','Camry','Automatic','Sedan','Available'),('Honda','Accord','Automatic','Sedan','Available'),('Nissan','Maxima','Automatic','Sedan','Available'),('Mitsubishi','Galant','Automatic','Sedan',' Available'),('Mazda','626','Automatic','Sedan','Available'),('Toyota','Crown','Automatic','Sedan','Available'),('BMW','3-Series','Automatic','Sedan','Available'),('Mercedes-Benz','E-Class','Automatic','Sedan','Available'),('Chevrolet','Corvette','Manual','Sports Car','Available'),('Mazda','MX-5 Miata','Manual','Sports Car','Available'),('Nissan','Skyline GT-R','Manual','Sports Car','Avialable'),('Mitsubishi','Eclipse','Manual','Sports Car','Available'),('Honda','S2000','Manual','Sports Car','Available'),('BMW','Z3','Manual','Sports Car','Available'),('Mercedes-Benz','SLK-Class','Automatic','Sports Car','Available'),('Chevrolet','Camaro','Manual','Sports Car','Available'),('Toyota','MR2','Manual','Sports Car','Available'),('Ford','Mustang','Manual','Sports Car','Available'),('Dodge','Challenger','Manual','Sports Car','Available'),('Mecedes-Benz','E200 Avantgarde','Automatic','Sedan','Available'),('Tesla','Model Y','Automatic','SUV','Available'),('BMW','M850i xDrive Convertible','Automatic','Luxury Sports Coupe','Available'),('Rolls Royce','Rolls-Royce Dawn','Automatic','Super luxury convertible','Available'),('Bentley','Continental GT','Automatic','Exotic','Available'),('Mecedes-Benz','S-Class','Automatic','Sedan','Available'),('Land Rover','Range Rover Velar','Automatic','SUV','Available'),('Toyota','Corolla Altis','Manual','Sedan','Available'),('Audi','R8','Automatic','Sports car','Available'),('Toyota','GR Supra','Manual','Sports car','Available'),('Jaguar','F-Type','Automatic','Supercar','Available'),('Volvo','XC40','Automatic','SUV','Available'),('Volkswagen','Virtus','Automatic','Sedan','Available'),('Jeep','Wrangler Rubicon','Automatic','SUV','Available');
/*!40000 ALTER TABLE `vehicles` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-06-21 16:53:34
