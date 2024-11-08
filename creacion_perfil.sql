-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 08-11-2024 a las 20:33:58
-- Versión del servidor: 10.4.32-MariaDB
-- Versión de PHP: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `tankesv`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `creacion_perfil`
--

CREATE TABLE `creacion_perfil` (
  `id` bigint(20) UNSIGNED NOT NULL,
  `nombre` varchar(255) NOT NULL,
  `correo` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL CHECK (octet_length(`password`) >= 8),
  `confirm_password` varchar(255) NOT NULL,
  `telefono` varchar(255) NOT NULL,
  `fecha_nacimiento` date NOT NULL,
  `direccion` varchar(255) NOT NULL,
  `foto_perfil` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `creacion_perfil`
--

INSERT INTO `creacion_perfil` (`id`, `nombre`, `correo`, `password`, `confirm_password`, `telefono`, `fecha_nacimiento`, `direccion`, `foto_perfil`) VALUES
(4, 'harold', 'haroldorellana20@gmail.com', '12345678', '12345678', '79609096', '2010-03-17', 'El Salvador\r\nSan Salvador', 'c:\\Users\\harol\\Desktop\\TANKESV-PROYECT/uploads/diagram-export-5-11-2024-9_33_01.png');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `creacion_perfil`
--
ALTER TABLE `creacion_perfil`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `correo` (`correo`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `creacion_perfil`
--
ALTER TABLE `creacion_perfil`
  MODIFY `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
