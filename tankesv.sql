-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 06-12-2024 a las 01:21:03
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
-- Estructura de tabla para la tabla `cliente`
--

CREATE TABLE `cliente` (
  `id_cliente` int(11) NOT NULL,
  `id_usuario` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `comentario`
--

CREATE TABLE `comentario` (
  `id_comentario` int(11) NOT NULL,
  `id_producto` int(11) DEFAULT NULL,
  `id_cliente` int(11) DEFAULT NULL,
  `comentario` text DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `creacion_perfil`
--

CREATE TABLE `creacion_perfil` (
  `id` bigint(20) NOT NULL,
  `confirm_password` varchar(255) NOT NULL,
  `correo` varchar(255) NOT NULL,
  `direccion` varchar(255) NOT NULL,
  `fecha_nacimiento` date NOT NULL,
  `foto_perfil` varchar(255) DEFAULT NULL,
  `nombre` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `telefono` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `crowdfunding`
--

CREATE TABLE `crowdfunding` (
  `id_crowdfunding` int(11) NOT NULL,
  `descripcion` varchar(255) DEFAULT NULL,
  `meta` decimal(38,2) DEFAULT NULL,
  `recaudado` decimal(38,2) DEFAULT NULL,
  `titulo` varchar(255) DEFAULT NULL,
  `id_empresario` int(11) DEFAULT NULL,
  `main_img` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `crowdfunding`
--

INSERT INTO `crowdfunding` (`id_crowdfunding`, `descripcion`, `meta`, `recaudado`, `titulo`, `id_empresario`, `main_img`) VALUES
(1, 'proyecto 1', 2000.00, 0.00, 'miProyecto', NULL, NULL),
(2, 'venta de dulce', 1013.00, 0.00, 'ventaDulce', NULL, NULL),
(3, 'venta de utiles', 1000.00, 0.00, 'miproyecto1.23', NULL, NULL);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `crowdfunding_img`
--

CREATE TABLE `crowdfunding_img` (
  `id_crowdfunding_img` int(11) NOT NULL,
  `url_img` varchar(255) NOT NULL,
  `id_crowdfunding` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `crowfunding`
--

CREATE TABLE `crowfunding` (
  `id_crowfunding` int(11) NOT NULL,
  `id_empresario` int(11) DEFAULT NULL,
  `titulo` varchar(100) NOT NULL,
  `descripcion` text DEFAULT NULL,
  `meta` decimal(10,2) DEFAULT NULL,
  `recaudado` decimal(10,2) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `empresario`
--

CREATE TABLE `empresario` (
  `id_empresario` int(11) NOT NULL,
  `id_usuario` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `gestion_catalogo`
--

CREATE TABLE `gestion_catalogo` (
  `id` bigint(20) NOT NULL,
  `cantidad_producto` int(11) DEFAULT NULL,
  `descripcion_producto` varchar(255) DEFAULT NULL,
  `imagen_producto` varchar(255) DEFAULT NULL,
  `nombre_producto` varchar(255) DEFAULT NULL,
  `precio_producto` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `login`
--

CREATE TABLE `login` (
  `id` bigint(20) NOT NULL,
  `email` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `pago`
--

CREATE TABLE `pago` (
  `id_pago` int(11) NOT NULL,
  `id_crowfunding` int(11) DEFAULT NULL,
  `monto` decimal(10,2) DEFAULT NULL,
  `fecha_pago` date DEFAULT NULL,
  `nombre_donador` varchar(100) NOT NULL,
  `id_crowdfunding` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `portafolio`
--

CREATE TABLE `portafolio` (
  `id_portafolio` int(11) NOT NULL,
  `id_empresario` int(11) DEFAULT NULL,
  `descripcion` text DEFAULT NULL,
  `nombre` varchar(100) DEFAULT NULL,
  `logo_url` varchar(255) DEFAULT NULL,
  `fecha_creacion` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `producto`
--

CREATE TABLE `producto` (
  `id_producto` int(11) NOT NULL,
  `id_portafolio` int(11) DEFAULT NULL,
  `nombre` varchar(100) DEFAULT NULL,
  `descripcion` text DEFAULT NULL,
  `precio` decimal(10,2) DEFAULT NULL,
  `imagen_url` varchar(255) DEFAULT NULL,
  `fecha_creacion` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `recuperarpassword`
--

CREATE TABLE `recuperarpassword` (
  `recuperarpassword_id` int(11) NOT NULL,
  `id_usuario` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `recuperarpassword`
--

INSERT INTO `recuperarpassword` (`recuperarpassword_id`, `id_usuario`) VALUES
(5, 3),
(6, 3),
(7, 4),
(8, 5);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `reporte_incidente`
--

CREATE TABLE `reporte_incidente` (
  `id_reporteIncidente` int(11) NOT NULL,
  `url_img` varchar(255) DEFAULT NULL,
  `descripcion_problema` varchar(255) DEFAULT NULL,
  `id_reporte_incidente` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `reporte_incidente`
--

INSERT INTO `reporte_incidente` (`id_reporteIncidente`, `url_img`, `descripcion_problema`, `id_reporte_incidente`) VALUES
(9, 'C:\\Users\\harol\\Desktop\\TANKESV-PROYECT/uploadsdiagram-export-5-11-2024-9_33_01.png', 'harrrr', 0),
(10, 'C:\\Users\\harol\\Desktop\\TANKESV-PROYECT/uploadsdocument-export-5-11-2024-9_33_01.md', 'sdsdsdsdaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa', 0);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `reporte_usuario`
--

CREATE TABLE `reporte_usuario` (
  `id_reporte_usuario` int(11) NOT NULL,
  `motivo` varchar(255) DEFAULT NULL,
  `id_usuario` int(11) DEFAULT NULL,
  `url_img` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `reporte_usuario`
--

INSERT INTO `reporte_usuario` (`id_reporte_usuario`, `motivo`, `id_usuario`, `url_img`) VALUES
(13, 'insultos en el chat', 4, 'uploads\\diagram-export-5-11-2024-9_33_01.png');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuario`
--

CREATE TABLE `usuario` (
  `id_usuario` int(11) NOT NULL,
  `nombre` varchar(100) NOT NULL,
  `correo` varchar(100) NOT NULL,
  `password` varchar(100) NOT NULL,
  `confirm_password` varchar(255) NOT NULL,
  `telefono` varchar(255) NOT NULL,
  `fecha_nacimiento` date NOT NULL,
  `direccion` varchar(255) NOT NULL,
  `foto_perfil` varchar(255) DEFAULT NULL,
  `tipo` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  `role` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `usuario`
--

INSERT INTO `usuario` (`id_usuario`, `nombre`, `correo`, `password`, `confirm_password`, `telefono`, `fecha_nacimiento`, `direccion`, `foto_perfil`, `tipo`, `username`, `role`) VALUES
(3, 'harold', 'haroldorellana20@gmail.com', '12345678', '12345678', '79609096', '2024-11-13', 'El Salvador\r\nSan Salvador', 'C:\\Users\\harol\\Desktop\\TANKESV-PROYECT\\TANKESV\\uploads/diagram-export-5-11-2024-9_33_01.png', NULL, NULL, NULL),
(4, 'walter', 'walter@gmail.com', '12345678', '12345678', '12345678', '2024-11-06', 'El Salvador\r\nSan Salvador', 'C:\\Users\\harol\\Desktop\\TANKESV-PROYECT\\TANKESV\\uploads/diagram-export-5-11-2024-9_33_01.png', NULL, NULL, NULL),
(5, 'fernando', 'fernando@gmail.com', '12345678', '12345678', '79609096', '2018-02-02', 'El Salvador\r\nSan Salvador', 'C:\\Users\\harol\\Desktop\\TANKESV-PROYECT\\TANKESV\\uploads/diagram-export-5-11-2024-9_33_01.png', NULL, NULL, NULL),
(10, 'walter1', 'walter1@gmail.com', '$2a$10$sUnLq4rhLqRG9g7MGlk1aOSRaCw2bWJnaa2EoPkJxx96rGvU2xHWK', '12345678', '79609096', '1989-07-05', 'El Salvador\r\nSan Salvador', 'C:\\Users\\harol\\Desktop\\TANKESV-PROYECT\\TANKESV\\uploads/WhatsApp Image 2024-11-20 at 4.11.40 PM.jpeg', NULL, NULL, NULL),
(12, 'maria', 'maria@gmail.com', '$2a$10$4FyK2yMDjLc8ZywMl3XyJO/ITlT8uMKicWPLkVi0AitNEF9JCjxKq', 'Moroni123', '79609096', '2012-11-14', 'El Salvador\r\nSan Salvador', 'C:\\Users\\harol\\Desktop\\TANKESV-PROYECT\\TANKESV\\uploads/WhatsApp Image 2024-11-20 at 4.11.40 PM.jpeg', NULL, NULL, NULL),
(14, 'cielo', 'cielo@gmail.com', '$2a$10$Giyp3teiEzL7NQAjKS81z.6JWui0d9J929R.MSjeV5ZzNuTHEaA8q', '12345678', '79609096', '2024-12-18', 'El Salvador\r\nSan Salvador', 'C:\\Users\\harol\\Desktop\\TANKESV-PROYECT\\TANKESV\\uploads/WhatsApp Image 2024-07-29 at 8.22.00 AM.jpeg', NULL, NULL, NULL),
(15, 'fernando', 'fernando@gmail.com', '$2a$10$Zg2332fDEZ7TkfVjscbGkutzcu7yl0K2lEnH11D29RoretDrrsv3y', '12345678', '79609096', '2006-07-11', 'El Salvador\r\nSan Salvador', 'C:\\Users\\harol\\Desktop\\TANKESV-PROYECT\\TANKESV\\uploads/WhatsApp Image 2024-11-20 at 4.11.40 PM.jpeg', NULL, NULL, 'ROLE_USER'),
(16, 'raul', 'raul@gmail.com', '$2a$10$Wezhz4atezyrENn8VW/QIucu0rks/aY0KAs2QscU4ijAXB16SoqBC', '12345678', '79609096', '2014-02-27', 'El Salvador\r\nSan Salvador', 'C:\\Users\\harol\\Desktop\\TANKESV-PROYECT\\TANKESV\\uploads/WhatsApp Image 2024-11-20 at 4.11.40 PM.jpeg', NULL, NULL, 'ROLE_USER'),
(34, 'walter', 'walterwww@gmail.com', '$2a$10$UaK0DEyLWhilXMuh4A/br.qbr.0bTrqCMvEXN6otbFi4bvEcT5/k6', '11111111', '79609096', '2025-01-01', 'El Salvador\r\nSan Salvador', 'uploads/73f8d44c-a11b-4c79-ac1e-dc2097de4808_Anotación 2024-05-20 170917.png', NULL, NULL, 'ROLE_USER'),
(35, 'cielo', 'cielo2@gmail.com', '$2a$10$ESgpqIgFI9SFHWt0bD.vbuSysyBEgzE8aPQXGl1RzxB7KWtH5CRie', '12345678', '79609096', '2024-12-24', 'El Salvador\r\nSan Salvador', 'uploads/e5f1c7fb-4c91-4873-b292-f0ab8850d0ab_Anotación 2024-05-20 170917.png', NULL, NULL, 'ROLE_USER');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `cliente`
--
ALTER TABLE `cliente`
  ADD PRIMARY KEY (`id_cliente`),
  ADD KEY `id_usuario` (`id_usuario`);

--
-- Indices de la tabla `comentario`
--
ALTER TABLE `comentario`
  ADD PRIMARY KEY (`id_comentario`),
  ADD KEY `id_producto` (`id_producto`),
  ADD KEY `id_cliente` (`id_cliente`);

--
-- Indices de la tabla `creacion_perfil`
--
ALTER TABLE `creacion_perfil`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `crowdfunding`
--
ALTER TABLE `crowdfunding`
  ADD PRIMARY KEY (`id_crowdfunding`),
  ADD KEY `FKptmk5047cd3jt9j1gr5wqdisy` (`id_empresario`);

--
-- Indices de la tabla `crowdfunding_img`
--
ALTER TABLE `crowdfunding_img`
  ADD PRIMARY KEY (`id_crowdfunding_img`),
  ADD KEY `FKh4mgmwhy6plol8vvm0c7ag3q2` (`id_crowdfunding`);

--
-- Indices de la tabla `crowfunding`
--
ALTER TABLE `crowfunding`
  ADD PRIMARY KEY (`id_crowfunding`),
  ADD KEY `id_empresario` (`id_empresario`);

--
-- Indices de la tabla `empresario`
--
ALTER TABLE `empresario`
  ADD PRIMARY KEY (`id_empresario`),
  ADD KEY `id_usuario` (`id_usuario`);

--
-- Indices de la tabla `gestion_catalogo`
--
ALTER TABLE `gestion_catalogo`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `login`
--
ALTER TABLE `login`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `UK3cs7dxhnine2f6x5ic4741s6e` (`email`);

--
-- Indices de la tabla `pago`
--
ALTER TABLE `pago`
  ADD PRIMARY KEY (`id_pago`),
  ADD KEY `id_crowfunding` (`id_crowfunding`),
  ADD KEY `FKds09r7tp8f8juq5qrfu2rustj` (`id_crowdfunding`);

--
-- Indices de la tabla `portafolio`
--
ALTER TABLE `portafolio`
  ADD PRIMARY KEY (`id_portafolio`),
  ADD KEY `id_empresario` (`id_empresario`);

--
-- Indices de la tabla `producto`
--
ALTER TABLE `producto`
  ADD PRIMARY KEY (`id_producto`),
  ADD KEY `id_portafolio` (`id_portafolio`);

--
-- Indices de la tabla `recuperarpassword`
--
ALTER TABLE `recuperarpassword`
  ADD PRIMARY KEY (`recuperarpassword_id`),
  ADD KEY `id_usuario` (`id_usuario`);

--
-- Indices de la tabla `reporte_incidente`
--
ALTER TABLE `reporte_incidente`
  ADD PRIMARY KEY (`id_reporteIncidente`);

--
-- Indices de la tabla `reporte_usuario`
--
ALTER TABLE `reporte_usuario`
  ADD PRIMARY KEY (`id_reporte_usuario`),
  ADD KEY `fk_reporte_usuario` (`id_usuario`);

--
-- Indices de la tabla `usuario`
--
ALTER TABLE `usuario`
  ADD PRIMARY KEY (`id_usuario`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `cliente`
--
ALTER TABLE `cliente`
  MODIFY `id_cliente` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `comentario`
--
ALTER TABLE `comentario`
  MODIFY `id_comentario` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `creacion_perfil`
--
ALTER TABLE `creacion_perfil`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `crowdfunding`
--
ALTER TABLE `crowdfunding`
  MODIFY `id_crowdfunding` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de la tabla `crowdfunding_img`
--
ALTER TABLE `crowdfunding_img`
  MODIFY `id_crowdfunding_img` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `crowfunding`
--
ALTER TABLE `crowfunding`
  MODIFY `id_crowfunding` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `empresario`
--
ALTER TABLE `empresario`
  MODIFY `id_empresario` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `gestion_catalogo`
--
ALTER TABLE `gestion_catalogo`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de la tabla `login`
--
ALTER TABLE `login`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `pago`
--
ALTER TABLE `pago`
  MODIFY `id_pago` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `portafolio`
--
ALTER TABLE `portafolio`
  MODIFY `id_portafolio` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `producto`
--
ALTER TABLE `producto`
  MODIFY `id_producto` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `recuperarpassword`
--
ALTER TABLE `recuperarpassword`
  MODIFY `recuperarpassword_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT de la tabla `reporte_incidente`
--
ALTER TABLE `reporte_incidente`
  MODIFY `id_reporteIncidente` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT de la tabla `reporte_usuario`
--
ALTER TABLE `reporte_usuario`
  MODIFY `id_reporte_usuario` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;

--
-- AUTO_INCREMENT de la tabla `usuario`
--
ALTER TABLE `usuario`
  MODIFY `id_usuario` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=36;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `cliente`
--
ALTER TABLE `cliente`
  ADD CONSTRAINT `cliente_ibfk_1` FOREIGN KEY (`id_usuario`) REFERENCES `usuario` (`id_usuario`) ON DELETE CASCADE;

--
-- Filtros para la tabla `comentario`
--
ALTER TABLE `comentario`
  ADD CONSTRAINT `comentario_ibfk_1` FOREIGN KEY (`id_producto`) REFERENCES `producto` (`id_producto`) ON DELETE CASCADE,
  ADD CONSTRAINT `comentario_ibfk_2` FOREIGN KEY (`id_cliente`) REFERENCES `cliente` (`id_cliente`) ON DELETE CASCADE;

--
-- Filtros para la tabla `crowdfunding`
--
ALTER TABLE `crowdfunding`
  ADD CONSTRAINT `FKptmk5047cd3jt9j1gr5wqdisy` FOREIGN KEY (`id_empresario`) REFERENCES `empresario` (`id_empresario`);

--
-- Filtros para la tabla `crowdfunding_img`
--
ALTER TABLE `crowdfunding_img`
  ADD CONSTRAINT `FKh4mgmwhy6plol8vvm0c7ag3q2` FOREIGN KEY (`id_crowdfunding`) REFERENCES `crowdfunding` (`id_crowdfunding`);

--
-- Filtros para la tabla `crowfunding`
--
ALTER TABLE `crowfunding`
  ADD CONSTRAINT `crowfunding_ibfk_1` FOREIGN KEY (`id_empresario`) REFERENCES `empresario` (`id_empresario`) ON DELETE CASCADE;

--
-- Filtros para la tabla `empresario`
--
ALTER TABLE `empresario`
  ADD CONSTRAINT `empresario_ibfk_1` FOREIGN KEY (`id_usuario`) REFERENCES `usuario` (`id_usuario`) ON DELETE CASCADE;

--
-- Filtros para la tabla `pago`
--
ALTER TABLE `pago`
  ADD CONSTRAINT `FKds09r7tp8f8juq5qrfu2rustj` FOREIGN KEY (`id_crowdfunding`) REFERENCES `crowdfunding` (`id_crowdfunding`),
  ADD CONSTRAINT `pago_ibfk_1` FOREIGN KEY (`id_crowfunding`) REFERENCES `crowfunding` (`id_crowfunding`) ON DELETE CASCADE;

--
-- Filtros para la tabla `portafolio`
--
ALTER TABLE `portafolio`
  ADD CONSTRAINT `portafolio_ibfk_1` FOREIGN KEY (`id_empresario`) REFERENCES `empresario` (`id_empresario`) ON DELETE CASCADE;

--
-- Filtros para la tabla `producto`
--
ALTER TABLE `producto`
  ADD CONSTRAINT `producto_ibfk_1` FOREIGN KEY (`id_portafolio`) REFERENCES `portafolio` (`id_portafolio`) ON DELETE CASCADE;

--
-- Filtros para la tabla `recuperarpassword`
--
ALTER TABLE `recuperarpassword`
  ADD CONSTRAINT `recuperarpassword_ibfk_1` FOREIGN KEY (`id_usuario`) REFERENCES `usuario` (`id_usuario`);

--
-- Filtros para la tabla `reporte_usuario`
--
ALTER TABLE `reporte_usuario`
  ADD CONSTRAINT `fk_reporte_usuario` FOREIGN KEY (`id_usuario`) REFERENCES `usuario` (`id_usuario`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
