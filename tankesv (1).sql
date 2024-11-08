-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 08-11-2024 a las 08:08:25
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
  `fecha_pago` date DEFAULT NULL
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
(1, 1);

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
(10, 'Comportamiento inadecuado', 1, 'C:\\xampp\\tomcat\\TANKESV-PROYECT\\TANKESV/uploads/ABRAZADERA CONDUIT 1 1-2 APC.webp'),
(11, 'Actividad sospechosa', 2, 'C:\\xampp\\tomcat\\TANKESV-PROYECT\\TANKESV/uploads/iconnotion.jpg'),
(12, 'Test', 2, 'C:\\xampp\\tomcat\\TANKESV-PROYECT\\TANKESV/uploads/iconnotion.jpg');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuario`
--

CREATE TABLE `usuario` (
  `id_usuario` int(11) NOT NULL,
  `nombre` varchar(100) NOT NULL,
  `correo` varchar(100) NOT NULL,
  `tipo` varchar(255) NOT NULL,
  `password` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `usuario`
--

INSERT INTO `usuario` (`id_usuario`, `nombre`, `correo`, `tipo`, `password`) VALUES
(1, 'Juan Pérez', 'juan.perez@example.com', 'cliente', 'contraseñaSegura'),
(2, 'Julian Araújo', 'juli.araujo@example.com', 'cliente', 'contraseñaSegura');

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
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `correo` (`correo`);

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
  ADD KEY `id_crowfunding` (`id_crowfunding`);

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
  MODIFY `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

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
  MODIFY `recuperarpassword_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de la tabla `reporte_incidente`
--
ALTER TABLE `reporte_incidente`
  MODIFY `id_reporteIncidente` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT de la tabla `reporte_usuario`
--
ALTER TABLE `reporte_usuario`
  MODIFY `id_reporte_usuario` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- AUTO_INCREMENT de la tabla `usuario`
--
ALTER TABLE `usuario`
  MODIFY `id_usuario` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

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
