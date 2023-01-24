-- phpMyAdmin SQL Dump
-- version 5.0.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1:3307
-- Tiempo de generación: 18-11-2022 a las 10:00:12
-- Versión del servidor: 10.4.11-MariaDB
-- Versión de PHP: 7.4.2

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `foro`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `categorias`
--

CREATE TABLE `categorias` (
  `ID` int(11) NOT NULL,
  `Nombre` varchar(30) COLLATE utf8_spanish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `categorias`
--

INSERT INTO `categorias` (`ID`, `Nombre`) VALUES
(1, 'Coches'),
(2, 'Deportes'),
(3, 'Informática');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `hilos`
--

CREATE TABLE `hilos` (
  `ID` int(11) NOT NULL,
  `Nombre` varchar(30) COLLATE utf8_spanish_ci NOT NULL,
  `ID_Usuario` int(11) NOT NULL,
  `ID_categorias` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `hilos`
--

INSERT INTO `hilos` (`ID`, `Nombre`, `ID_Usuario`, `ID_categorias`) VALUES
(1, 'Nuevo Audi', 2, 1),
(2, 'Nuevo BMW', 3, 1),
(3, 'El clásico', 1, 2),
(4, 'Gran premio de Abu Dhabi', 2, 2),
(5, 'Problemas con excel', 4, 3),
(6, 'Próxima versión de python', 3, 3);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `mensaje`
--

CREATE TABLE `mensaje` (
  `ID` int(11) NOT NULL,
  `Titulo` varchar(50) COLLATE utf8_spanish_ci NOT NULL,
  `Cuerpo` varchar(250) COLLATE utf8_spanish_ci NOT NULL,
  `Fecha_y_hora` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  `ID_Usuario` int(11) NOT NULL,
  `ID_Hilo` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `mensaje`
--

INSERT INTO `mensaje` (`ID`, `Titulo`, `Cuerpo`, `Fecha_y_hora`, `ID_Usuario`, `ID_Hilo`) VALUES
(1, 'Estoy muy emocionada', 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Ut neque mi, dictum ut ipsum nec, interdum mattis massa. Sed accumsan molestie risus, non maximus massa. Ut malesuada diam in nulla consequat, a scelerisque augue ornare. Nulla mollis volutpat.', '2022-11-18 08:22:32', 3, 3),
(2, 'Va a ser un gran premio', 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Ut neque mi, dictum ut ipsum nec, interdum mattis massa. Sed accumsan molestie risus, non maximus massa. Ut malesuada diam in nulla consequat, a scelerisque augue ornare. Nulla mollis volutpat.', '2022-11-18 08:22:32', 4, 4),
(3, 'Va a ser un partidazo', 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Ut neque mi, dictum ut ipsum nec, interdum mattis massa. Sed accumsan molestie risus, non maximus massa. Ut malesuada diam in nulla consequat, a scelerisque augue ornare. Nulla mollis volutpat.', '2022-11-18 08:23:34', 2, 3),
(4, 'El nano va a arrasar', 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Ut neque mi, dictum ut ipsum nec, interdum mattis massa. Sed accumsan molestie risus, non maximus massa. Ut malesuada diam in nulla consequat, a scelerisque augue ornare. Nulla mollis volutpat.', '2022-11-18 08:23:34', 1, 4),
(5, 'Me mola el rediseño', 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Ut neque mi, dictum ut ipsum nec, interdum mattis massa. Sed accumsan molestie risus, non maximus massa. Ut malesuada diam in nulla consequat, a scelerisque augue ornare. Nulla mollis volutpat.', '2022-11-18 08:25:35', 1, 1),
(6, 'Es muy feo', 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Ut neque mi, dictum ut ipsum nec, interdum mattis massa. Sed accumsan molestie risus, non maximus massa. Ut malesuada diam in nulla consequat, a scelerisque augue ornare. Nulla mollis volutpat.', '2022-11-18 08:25:35', 2, 2),
(7, 'Es muy caro', 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Ut neque mi, dictum ut ipsum nec, interdum mattis massa. Sed accumsan molestie risus, non maximus massa. Ut malesuada diam in nulla consequat, a scelerisque augue ornare. Nulla mollis volutpat.', '2022-11-18 08:28:34', 3, 1),
(8, 'Es el mismo coche', 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Ut neque mi, dictum ut ipsum nec, interdum mattis massa. Sed accumsan molestie risus, non maximus massa. Ut malesuada diam in nulla consequat, a scelerisque augue ornare. Nulla mollis volutpat.', '2022-11-18 08:28:34', 4, 2),
(9, 'no me funcionan las funciones', 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Ut neque mi, dictum ut ipsum nec, interdum mattis massa. Sed accumsan molestie risus, non maximus massa. Ut malesuada diam in nulla consequat, a scelerisque augue ornare. Nulla mollis volutpat.', '2022-11-18 08:30:24', 3, 5),
(10, 'añaden un montón de cosas', 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Ut neque mi, dictum ut ipsum nec, interdum mattis massa. Sed accumsan molestie risus, non maximus massa. Ut malesuada diam in nulla consequat, a scelerisque augue ornare. Nulla mollis volutpat.', '2022-11-18 08:30:24', 2, 6),
(11, 'Esta es la solución', 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Ut neque mi, dictum ut ipsum nec, interdum mattis massa. Sed accumsan molestie risus, non maximus massa. Ut malesuada diam in nulla consequat, a scelerisque augue ornare. Nulla mollis volutpat.', '2022-11-18 08:31:12', 2, 5),
(12, 'Estoy emocionada', 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Ut neque mi, dictum ut ipsum nec, interdum mattis massa. Sed accumsan molestie risus, non maximus massa. Ut malesuada diam in nulla consequat, a scelerisque augue ornare. Nulla mollis volutpat.', '2022-11-18 08:31:12', 3, 6);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuarios`
--

CREATE TABLE `usuarios` (
  `ID` int(11) NOT NULL,
  `Nombre` varchar(30) COLLATE utf8_spanish_ci NOT NULL,
  `Email` varchar(50) COLLATE utf8_spanish_ci NOT NULL,
  `Contrasenya` varchar(20) COLLATE utf8_spanish_ci NOT NULL,
  `Fecha_Nacimiento` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `usuarios`
--

INSERT INTO `usuarios` (`ID`, `Nombre`, `Email`, `Contrasenya`, `Fecha_Nacimiento`) VALUES
(1, 'Jorge', 'jorge@ejemplo.com', '1234', '1998-08-21'),
(2, 'Carlos', 'carlos@ejemplo.com', '1234', '1986-05-14'),
(3, 'María', 'maria@ejemplo.com', '1234', '2002-07-16'),
(4, 'Carla', 'carla@ejemplo.com', '1234', '2013-04-16');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `categorias`
--
ALTER TABLE `categorias`
  ADD PRIMARY KEY (`ID`);

--
-- Indices de la tabla `hilos`
--
ALTER TABLE `hilos`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `ID_Usuario` (`ID_Usuario`),
  ADD KEY `ID_categorias` (`ID_categorias`);

--
-- Indices de la tabla `mensaje`
--
ALTER TABLE `mensaje`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `ID_Hilo` (`ID_Hilo`),
  ADD KEY `ID_Usuario` (`ID_Usuario`);

--
-- Indices de la tabla `usuarios`
--
ALTER TABLE `usuarios`
  ADD PRIMARY KEY (`ID`),
  ADD UNIQUE KEY `Email` (`Email`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `categorias`
--
ALTER TABLE `categorias`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de la tabla `hilos`
--
ALTER TABLE `hilos`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT de la tabla `mensaje`
--
ALTER TABLE `mensaje`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- AUTO_INCREMENT de la tabla `usuarios`
--
ALTER TABLE `usuarios`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `hilos`
--
ALTER TABLE `hilos`
  ADD CONSTRAINT `hilos_ibfk_1` FOREIGN KEY (`ID_categorias`) REFERENCES `categorias` (`ID`),
  ADD CONSTRAINT `hilos_ibfk_2` FOREIGN KEY (`ID_Usuario`) REFERENCES `usuarios` (`ID`);

--
-- Filtros para la tabla `mensaje`
--
ALTER TABLE `mensaje`
  ADD CONSTRAINT `mensaje_ibfk_2` FOREIGN KEY (`ID_Usuario`) REFERENCES `usuarios` (`ID`),
  ADD CONSTRAINT `mensaje_ibfk_3` FOREIGN KEY (`ID_Hilo`) REFERENCES `hilos` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
