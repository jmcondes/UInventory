-- phpMyAdmin SQL Dump
-- version 3.5.2.2
-- http://www.phpmyadmin.net
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 22-06-2015 a las 18:10:40
-- Versión del servidor: 5.5.27
-- Versión de PHP: 5.4.7

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de datos: `inventarioprogr`
--

CREATE SCHEMA `inventarioprogr` ;

USE `inventarioprogr`;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `categories`
--

CREATE TABLE IF NOT EXISTS `categories` (
  `id_category` int(11) NOT NULL AUTO_INCREMENT,
  `category_name` varchar(45) NOT NULL,
  PRIMARY KEY (`id_category`),
  UNIQUE KEY `category_name_UNIQUE` (`category_name`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=4 ;

--
-- Volcado de datos para la tabla `categories`
--

INSERT INTO `categories` (`id_category`, `category_name`) VALUES
(3, 'Portatil'),
(1, 'Servidor'),
(2, 'Sobremesa');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `equipments`
--

CREATE TABLE IF NOT EXISTS `equipments` (
  `id_equipment` int(11) NOT NULL AUTO_INCREMENT,
  `processor` varchar(45) NOT NULL,
  `ram_memory` varchar(45) NOT NULL,
  `hard_disk` varchar(45) NOT NULL,
  `ssd` int(11) NOT NULL,
  `graphic_card` varchar(45) NOT NULL,
  `operative_system` varchar(45) NOT NULL,
  `category` int(11) NOT NULL,
  `storage_number` int(11) NOT NULL,
  `observations` varchar(300) DEFAULT NULL,
  PRIMARY KEY (`id_equipment`),
  KEY `storage_number_idx` (`storage_number`),
  KEY `category_idx` (`category`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=10 ;

--
-- Volcado de datos para la tabla `equipments`
--

INSERT INTO `equipments` (`id_equipment`, `processor`, `ram_memory`, `hard_disk`, `ssd`, `graphic_card`, `operative_system`, `category`, `storage_number`, `observations`) VALUES
(1, 'Intel 3 Ghz', '12 Gb', '1 Tb', 1, 'ATI 2 Gb', 'Windows 7', 1, 1, 'Equipo Gama Media'),
(2, 'Intel 4 Ghz', '16 Gb', '500 Gb', 1, 'NVIDIA 4 Gb', 'Windows 8.1', 1, 1, 'Equipo Gama Media'),
(3, 'Amd 2,8 Ghz', '8 Gb', '500 Gb', 0, 'ATI 1 Gb', 'Windows 7', 2, 2, 'Equipo Gama Baja'),
(4, 'Intel 3,4 Ghz', '12 Gb', '2 Tb', 1, 'ATI 6 Gb', 'Windows 8.1', 1, 1, 'Equipo Gama Alta'),
(5, 'Amd 3 Ghz', '12 Gb', '1 Tb', 1, 'NVIDIA 4 Gb', 'Windows 7', 2, 1, 'Equipo Gama Media'),
(6, 'Intel 2,6 Ghz', '6 Gb', '500 Gb', 0, 'ATI 4 Gb', 'Windows 8.1', 3, 1, 'Equipo Gama Baja'),
(7, 'Xeon 6 Ghz', '32 Gb', '2 Tb', 1, 'ATI 12 Gb', 'Windows 8.1', 1, 1, 'Workstation'),
(8, 'Intel Z3736F', ' 2 GB', '32 GB', 1, 'ATI HD 4550', 'Windows 8.1', 3, 2, 'Equipo Gama Baja'),
(9, 'AMD E1-6010', '4 GB', '32GB', 1, 'AMD R2 DVI', 'Windows 8,1', 2, 1, 'Equipo Gama Media');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `reserves`
--

CREATE TABLE IF NOT EXISTS `reserves` (
  `id_reserve` int(11) NOT NULL AUTO_INCREMENT,
  `id_user` int(11) NOT NULL,
  `id_equipment` int(11) NOT NULL,
  `description` varchar(200) DEFAULT NULL,
  `reserve_date` date NOT NULL,
  `return_date` date DEFAULT NULL,
  `observations` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id_reserve`,`id_user`,`id_equipment`,`reserve_date`),
  KEY `id_user_idx` (`id_user`),
  KEY `id_equipment_idx` (`id_equipment`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=2 ;

--
-- Volcado de datos para la tabla `reserves`
--

INSERT INTO `reserves` (`id_reserve`, `id_user`, `id_equipment`, `description`, `reserve_date`, `return_date`, `observations`) VALUES
(1, 1, 3, 'Intel 3 Ghz/ RAM 4 Gb/ HDD 1 Tb', '2015-05-20', '2015-05-22', 'Devuelto - en plazo');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `storages`
--

CREATE TABLE IF NOT EXISTS `storages` (
  `id_storage` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `location` varchar(45) NOT NULL,
  PRIMARY KEY (`id_storage`),
  UNIQUE KEY `name_UNIQUE` (`name`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=4 ;

--
-- Volcado de datos para la tabla `storages`
--

INSERT INTO `storages` (`id_storage`, `name`, `location`) VALUES
(1, 'Armario 1', 'Almacen Sótano'),
(2, 'Armario 2', 'Almacén Sótano'),
(3, 'Armario 3', 'Almacén Planta Baja');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `users`
--

CREATE TABLE IF NOT EXISTS `users` (
  `id_user` int(11) NOT NULL AUTO_INCREMENT,
  `dni` varchar(45) NOT NULL,
  `username` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  `name` varchar(45) NOT NULL,
  `email` varchar(45) NOT NULL,
  `gender` varchar(45) DEFAULT NULL,
  `borndate` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id_user`),
  UNIQUE KEY `username_UNIQUE` (`username`),
  UNIQUE KEY `email_UNIQUE` (`email`),
  UNIQUE KEY `dni_UNIQUE` (`dni`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=10 ;

--
-- Volcado de datos para la tabla `users`
--

INSERT INTO `users` (`id_user`, `dni`, `username`, `password`, `name`, `email`, `gender`, `borndate`) VALUES
(1, '11111111', 'admin', 'admin', 'Administrador', 'admin@root.god', 'male', '1-Enero-1910'),
(2, '50000005', 'jcondes', 'jcondes', 'José Manuel', 'jcondes@gmail.com', 'male', '1-Enero-1492'),
(3, '66666666', 'migueljimenez', '123456789', 'miguel', 'miguel@gmail.com', 'male', '2-Marzo-1990'),
(4, '777777777', 'dndl', '123456789', 'david', 'davidnavarro@gmail.com', 'male', '6-Junio-1666'),
(5, '8888888', 'Quique1', '123456789', 'Quique', 'quique@hotmail.com', 'male', '5-Junio-1987'),
(6, '36598659T', 'JoaqRc', '12456789', 'Joaquin', 'joaquin@gmail..com', 'male', '6-Mayo-1984'),
(7, '63256897X', 'JorgeJ', '123456789', 'Jorge', 'jorge@hotmail.com', 'male', '11-Diciemebre-1995'),
(8, '45698723P', 'NachoTras', '123456789', 'Nacho', 'nacho1@hotmail.com', 'male', '14-Julio-1965'),
(9, '56986534H', 'JesusGarcia', '123456789', 'Jesus', 'JesusG@gmail.com', 'male', '17-Mayo-1997');

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `equipments`
--
ALTER TABLE `equipments`
  ADD CONSTRAINT `category` FOREIGN KEY (`category`) REFERENCES `categories` (`id_category`),
  ADD CONSTRAINT `storage_number` FOREIGN KEY (`storage_number`) REFERENCES `storages` (`id_storage`);

--
-- Filtros para la tabla `reserves`
--
ALTER TABLE `reserves`
  ADD CONSTRAINT `id_equipment` FOREIGN KEY (`id_equipment`) REFERENCES `equipments` (`id_equipment`) ON DELETE CASCADE,
  ADD CONSTRAINT `id_user` FOREIGN KEY (`id_user`) REFERENCES `users` (`id_user`) ON DELETE CASCADE;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
