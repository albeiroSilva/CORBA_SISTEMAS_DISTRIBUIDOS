-- phpMyAdmin SQL Dump
-- version 4.6.6
-- https://www.phpmyadmin.net/
--
-- Servidor: localhost
-- Tiempo de generación: 01-08-2019 a las 23:49:31
-- Versión del servidor: 10.1.39-MariaDB
-- Versión de PHP: 5.6.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `gestionanteproyectos`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `anteproyecto`
--

CREATE TABLE `anteproyecto` (
  `codigoAnte` int(11) NOT NULL,
  `modalidad` varchar(25) NOT NULL,
  `titulo` varchar(40) NOT NULL,
  `concepto` int(11) NOT NULL,
  `estado` int(11) NOT NULL,
  `numeroRevision` int(11) NOT NULL,
  `fecha_registro` varchar(10) NOT NULL,
  `fecha_aprobación` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `anteproyecto`
--

INSERT INTO `anteproyecto` (`codigoAnte`, `modalidad`, `titulo`, `concepto`, `estado`, `numeroRevision`, `fecha_registro`, `fecha_aprobación`) VALUES
(1, 'Trabajo de investigacion', 'sistemas expertos', 1, 2, 0, '12', '12'),
(2, 'Trabajo de investigacion', 'mineria de datos', 1, 3, 0, '23', '23'),
(3, 'Trabajo de investigacion', 'sistema de recomendaqción', 2, 2, 0, '12', '12'),
(4, 'Trabajo de investigacion', 'máquina del timepo', 2, 4, 0, '21', '21'),
(5, 'Práctica Profesional', 'nueva teoría de cuerdas', 2, 2, 0, '31-07-2019', '31-07-2019'),
(6, 'Trabajo de investigacion', 'Traje invisible', 2, 4, 0, '28-06-2019', '28-06-2019'),
(7, 'Trabajo de investigacion', 'Bomba Atómica', 2, 2, 0, '12-07-2019', '12-07-2019'),
(8, 'Trabajo de investigacion', 'creación de un agujero negro', 2, 2, 0, '10-07-2019', '10-07-2019'),
(9, 'Trabajo de investigacion', 'Patrones de arquitectura', 2, 2, 0, '04-07-2019', '04-07-2019'),
(10, 'Trabajo de investigacion', 'Aprovechamiento de residuos', 2, 2, 0, '11-07-2019', '11-07-2019'),
(11, 'Trabajo de investigacion', 'determinación del espacio tiempo', 2, 1, 0, '28-08-2019', '28-08-2019'),
(12, 'Práctica Profesional', 'Sistema de seguimiento', 2, 2, 0, '25-08-2019', '25-08-2019'),
(13, 'Trabajo de investigacion', 'Relatividad general', 2, 2, 0, '02-08-2019', '02-08-2019'),
(14, 'Trabajo de investigacion', 'Teoría de cuerdas', 2, 1, 0, '02-08-2019', '02-08-2019');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tbl_anteproyectos`
--

CREATE TABLE `tbl_anteproyectos` (
  `CODIGO` int(11) NOT NULL,
  `TITULO` varchar(40) NOT NULL,
  `MODALIDAD` varchar(30) NOT NULL,
  `ESTUDIANTE_1` varchar(35) NOT NULL,
  `ESTUDIANTE_2` varchar(35) NOT NULL,
  `DIRECTOR` varchar(35) NOT NULL,
  `CO_DIRECTOR` varchar(35) NOT NULL,
  `FECHA_INGRESO` varchar(20) NOT NULL,
  `FECHA_APROBACION` varchar(20) NOT NULL,
  `CONCEPTO` int(11) NOT NULL,
  `ESTADO` int(11) NOT NULL,
  `NUMERO_REVISION` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `tbl_anteproyectos`
--

INSERT INTO `tbl_anteproyectos` (`CODIGO`, `TITULO`, `MODALIDAD`, `ESTUDIANTE_1`, `ESTUDIANTE_2`, `DIRECTOR`, `CO_DIRECTOR`, `FECHA_INGRESO`, `FECHA_APROBACION`, `CONCEPTO`, `ESTADO`, `NUMERO_REVISION`) VALUES
(1, 'minería de datos', 'Práctica Profesional', 'maria verónica', 'diana hoyos', 'lucas silva', 'Carlos Coboz', '12/12/2019', '12/12/2019', 2, 2, 0),
(2, 'Aeronáutica', 'Trabajo de investigacion', 'diana hoyos', 'maria verónica', 'lucas silva', 'Armando Casas', '23/12/2020', '23/12/2020', 2, 2, 0),
(3, 'Algoritmo memético', 'Trabajo de investigacion', 'maria verónica', 'Paula Murcia', 'Santiago Silva', 'Martha Mendoza', '26/07/2019', '26/07/2019', 1, 2, 0),
(4, 'Topología de red Unicauca', 'Práctica Profesional', 'diana hoyos', 'Paula Murcia', 'Santiago Silva', 'Andrés Córdoba', '27/12/2022', '27/12/2022', 1, 2, 0);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tbl_evaluadores`
--

CREATE TABLE `tbl_evaluadores` (
  `CODIGO` int(11) NOT NULL,
  `EVALUADOR_1` varchar(30) NOT NULL,
  `CONCEPTO_EVALUADOR_1` int(11) NOT NULL,
  `FECHA_REVISION_1` varchar(30) NOT NULL,
  `EVALUADOR_2` varchar(30) NOT NULL,
  `CONCEPTO_EVALUADOR_2` int(11) NOT NULL,
  `FECHA_REVISION_2` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `tbl_evaluadores`
--

INSERT INTO `tbl_evaluadores` (`CODIGO`, `EVALUADOR_1`, `CONCEPTO_EVALUADOR_1`, `FECHA_REVISION_1`, `EVALUADOR_2`, `CONCEPTO_EVALUADOR_2`, `FECHA_REVISION_2`) VALUES
(1, 'Daniel Eduardo Paz', 2, '12/12/2021', 'Daniel Eduardo Paz', 2, '12/12/2022'),
(2, 'Daniel Eduardo Paz', 1, '12/03/2017', 'Armando casas', 1, '12/03/2017'),
(3, 'Sergio David Silva', 1, '26/07/2019', 'Armando casas', 1, '27/09/2020'),
(4, 'Armando casas', 1, '23/12/2022', 'Sergio David Silva', 1, '23/12/2023');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tbl_historialusuarios`
--

CREATE TABLE `tbl_historialusuarios` (
  `ID` int(11) UNSIGNED NOT NULL,
  `USUARIO_UNICAUCA` varchar(30) NOT NULL,
  `CONTRASENIA` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `tbl_historialusuarios`
--

INSERT INTO `tbl_historialusuarios` (`ID`, `USUARIO_UNICAUCA`, `CONTRASENIA`) VALUES
(24, 'sergioS', '2101'),
(25, 'iduarsilva', 'adaeib'),
(26, 'iduarsilva', 'adaeib'),
(27, 'armandoC', '2311'),
(28, 'santiagoS', 'sant'),
(29, 'iduarsilva', 'adaeib'),
(30, 'sergioS', '2101'),
(31, 'sergioS', '2101'),
(32, 'iduarsilva', 'adaeib'),
(33, 'iduarsilva', 'adaeib'),
(34, 'armandoC', '2311'),
(35, 'albeiroSil', 'ada'),
(36, 'albeiroSil', 'ada'),
(37, 'albeiroSil', 'ada'),
(38, 'albeiroSil', 'ada'),
(39, 'albeiroSil', 'ada'),
(40, 'albeiroSil', 'ada'),
(41, 'albeiroSil', 'ada'),
(42, 'albeiroSil', 'ada'),
(43, 'albeiroSil', 'ada'),
(44, 'albeiroSil', 'ada'),
(45, 'albeiroSil', 'ada'),
(46, 'albeiroSil', 'ada'),
(47, 'albeiroSil', 'ada'),
(48, 'albeiroSil', 'ada'),
(49, 'albeiroSil', 'ada'),
(50, 'albeiroSil', 'ada'),
(51, 'albeiroSil', 'ada'),
(52, 'albeiroSil', 'ada'),
(53, 'albeiroSil', 'ada'),
(54, 'albeiroSil', 'ada'),
(55, 'albeiroSil', 'ada'),
(56, 'albeiroSil', 'ada'),
(57, 'albeiroSil', 'ada'),
(58, 'albeiroSil', 'ada'),
(59, 'veronicaM', '222'),
(60, 'sergioS', '321'),
(61, 'veronicaM', '222'),
(62, 'veronicaM', '222'),
(63, 'veronicaM', '222'),
(64, 'veronicaM', '222'),
(65, 'veronicaM', '222'),
(66, 'albeiroSil', 'ada'),
(67, 'dianaZ', '888'),
(68, 'dianaZ', '888'),
(69, 'lucasS', '333'),
(70, 'albeiroSil', 'ada'),
(71, 'albeiroSil', 'ada'),
(72, 'albeiroSil', 'ada'),
(73, 'albeiroSil', 'ada'),
(74, 'albeiroSil', 'ada'),
(75, 'albeiroSil', 'ada'),
(76, 'albeiroSil', 'ada'),
(77, 'albeiroSil', 'ada'),
(78, 'albeiroSil', 'ada'),
(79, 'dianaZ', '888'),
(80, 'dianaZ', '888'),
(81, 'albeiroSil', 'ada'),
(82, 'albeiroSil', 'ada'),
(83, 'santiagoR', '999'),
(84, 'veronicaM', '222'),
(85, 'albeiroSil', 'ada'),
(86, 'albeiroSil', 'ada'),
(87, 'dianaZ', '888'),
(88, 'albeiroSil', 'ada'),
(89, 'albeiroSil', 'ada'),
(90, 'albeiroSil', 'ada'),
(91, 'albeiroSil', 'ada'),
(92, 'dianaZ', '888'),
(93, 'albeiroSil', 'ada'),
(94, 'albeiroSil', 'ada'),
(95, 'albeiroSil', 'ada'),
(96, 'albeiroSil', 'ada'),
(97, 'albeiroSil', 'ada'),
(98, 'dianaZ', '888'),
(99, 'albeiroSil', 'ada'),
(100, 'dianaZ', '888'),
(101, 'albeiroSil', 'ada'),
(102, 'dianaZ', '888'),
(103, 'albeiroSil', 'ada'),
(104, 'dianaZ', '888'),
(105, 'albeiroSil', 'ada'),
(106, 'dianaZ', '888'),
(107, 'lauraV', '777'),
(108, 'lucasS', '333'),
(109, 'lucasS', '333'),
(110, 'dianaZ', '888'),
(111, 'dianaZ', '888'),
(112, 'dianaZ', '888'),
(113, 'lucasS', '333'),
(114, 'albeiroSil', 'ada'),
(115, 'armandoC', '555'),
(116, 'albeiroSil', 'ada'),
(117, 'armandoC', '555'),
(118, 'albeiroSil', 'ada'),
(119, 'albeiroSil', 'ada'),
(120, 'dianaZ', '888'),
(121, 'albeiroSil', 'ada'),
(122, 'dianaZ', '888'),
(123, 'dianaZ', '888'),
(124, 'dianaZ', '888'),
(125, 'albeiroSil', 'ada'),
(126, 'dianaZ', '888'),
(127, 'albeiroSil', 'ada'),
(128, 'dianaZ', '888'),
(129, 'albeiroSil', 'ada'),
(130, 'albeiroSil', 'ada');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tbl_usuarios`
--

CREATE TABLE `tbl_usuarios` (
  `IDENTIFICACION` int(11) NOT NULL,
  `NOMBRE_APE` varchar(30) NOT NULL,
  `USUARIO_UNICAUCA` varchar(30) NOT NULL,
  `CONTRASENIA` varchar(30) NOT NULL,
  `TIPO_USUARIO` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `tbl_usuarios`
--

INSERT INTO `tbl_usuarios` (`IDENTIFICACION`, `NOMBRE_APE`, `USUARIO_UNICAUCA`, `CONTRASENIA`, `TIPO_USUARIO`) VALUES
(823, 'Paula Murcia', 'paulaM', '823', 'Estudiante'),
(1023, 'lucas silva', 'lucasSilva', '1234', 'Director'),
(1046, 'albeiro silva', 'iduarsilva', 'adaeib', 'Jefe De Departamento'),
(1084, 'diana hoyos', 'dianaHoyos', 'adae', 'Estudiante'),
(1111, 'maria verónica', 'mariaV', '1111', 'Estudiante'),
(2101, 'Sergio David Silva', 'sergioS', '2101', 'Evaluador'),
(2991, 'Santiago Silva', 'santiagoS', 'sant', 'Director'),
(19006, 'Daniel Eduardo Paz', 'danielP', '666', 'Evaluador'),
(23011, 'Armando casas', 'armandoC', '2311', 'Evaluador');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuarios`
--

CREATE TABLE `usuarios` (
  `identificacion` int(11) NOT NULL,
  `nombreApe` varchar(30) NOT NULL,
  `usuario` varchar(10) NOT NULL,
  `contraseña` varchar(10) NOT NULL,
  `rol` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `usuarios`
--

INSERT INTO `usuarios` (`identificacion`, `nombreApe`, `usuario`, `contraseña`, `rol`) VALUES
(123, 'albeiro silva muñoz', 'albeiroSil', 'ada', 3),
(222, 'maria verónica muñoz', 'veronicaM', '222', 2),
(321, 'Sergio David Silva', 'sergioS', '321', 1),
(333, 'lucas silva', 'lucasS', '333', 2),
(444, 'santiado cerón', 'santiagoC', '444', 1),
(777, 'laura vanesa', 'lauraV', '777', 1),
(888, 'diana zúñiga', 'dianaZ', '888', 2),
(999, 'santiago ramirez chavez', 'santiagoR', '999', 2),
(5555, 'Armando Casas', 'armandoC', '555', 2),
(6717, 'pepito pérez', 'pepitoP', '671', 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuario_anteproyecto`
--

CREATE TABLE `usuario_anteproyecto` (
  `identificacion` int(11) NOT NULL,
  `codigoAnte` int(11) NOT NULL,
  `rolAnte` int(11) NOT NULL,
  `concepto` int(11) NOT NULL,
  `fecha_revision_1` varchar(10) NOT NULL,
  `fecha_revision_2` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `usuario_anteproyecto`
--

INSERT INTO `usuario_anteproyecto` (`identificacion`, `codigoAnte`, `rolAnte`, `concepto`, `fecha_revision_1`, `fecha_revision_2`) VALUES
(444, 1, 1, 0, '12', '12'),
(777, 1, 1, 0, '12', '12'),
(333, 1, 3, 0, '12', '12'),
(222, 1, 4, 0, '12', '12'),
(333, 1, 2, 1, '12', '12'),
(222, 1, 2, 2, '12', '12'),
(321, 2, 1, 0, '23', '23'),
(777, 2, 1, 0, '23', '23'),
(333, 2, 3, 0, '23', '23'),
(333, 2, 4, 0, '23', '23'),
(333, 2, 2, 1, '23', '23'),
(333, 2, 2, 1, '23', '23'),
(321, 3, 1, 0, '12', '12'),
(321, 3, 1, 0, '12', '12'),
(222, 3, 3, 0, '12', '12'),
(222, 3, 4, 0, '12', '12'),
(777, 4, 1, 0, '21', '21'),
(444, 4, 1, 0, '21', '21'),
(888, 4, 3, 0, '21', '21'),
(222, 4, 4, 0, '21', '21'),
(888, 4, 2, 1, '21', '21'),
(333, 4, 2, 2, '21', '21'),
(888, 1, 2, 2, '29-07-2019', '29-07-2019'),
(333, 1, 2, 1, '29-07-2019', '29-07-2019'),
(777, 5, 1, 0, '31-07-2019', '31-07-2019'),
(444, 5, 1, 0, '31-07-2019', '31-07-2019'),
(888, 5, 3, 0, '31-07-2019', '31-07-2019'),
(333, 5, 4, 0, '31-07-2019', '31-07-2019'),
(333, 5, 2, 1, '04-07-2019', '04-07-2019'),
(888, 5, 2, 1, '04-07-2019', '04-07-2019'),
(444, 6, 1, 0, '28-06-2019', '28-06-2019'),
(777, 6, 1, 0, '28-06-2019', '28-06-2019'),
(999, 6, 3, 0, '28-06-2019', '28-06-2019'),
(888, 6, 4, 0, '28-06-2019', '28-06-2019'),
(999, 6, 2, 2, '06-07-2019', '06-07-2019'),
(222, 6, 2, 2, '06-07-2019', '06-07-2019'),
(444, 7, 1, 0, '12-07-2019', '12-07-2019'),
(777, 7, 1, 0, '12-07-2019', '12-07-2019'),
(333, 7, 3, 0, '12-07-2019', '12-07-2019'),
(888, 7, 4, 0, '12-07-2019', '12-07-2019'),
(888, 7, 2, 2, '13-07-2019', '13-07-2019'),
(222, 7, 2, 1, '13-07-2019', '13-07-2019'),
(321, 8, 1, 0, '10-07-2019', '10-07-2019'),
(444, 8, 1, 0, '10-07-2019', '10-07-2019'),
(999, 8, 3, 0, '10-07-2019', '10-07-2019'),
(222, 8, 4, 0, '10-07-2019', '10-07-2019'),
(888, 3, 2, 2, '04-07-2019', '04-07-2019'),
(222, 3, 2, 2, '04-07-2019', '04-07-2019'),
(444, 9, 1, 0, '04-07-2019', '04-07-2019'),
(777, 9, 1, 0, '04-07-2019', '04-07-2019'),
(888, 9, 3, 0, '04-07-2019', '04-07-2019'),
(333, 9, 4, 0, '04-07-2019', '04-07-2019'),
(888, 9, 2, 2, '05-07-2019', '05-07-2019'),
(222, 9, 2, 1, '05-07-2019', '05-07-2019'),
(888, 8, 2, 2, '25-07-2019', '25-07-2019'),
(222, 8, 2, 2, '25-07-2019', '25-07-2019'),
(444, 10, 1, 0, '11-07-2019', '11-07-2019'),
(321, 10, 1, 0, '11-07-2019', '11-07-2019'),
(888, 10, 3, 0, '11-07-2019', '11-07-2019'),
(222, 10, 4, 0, '11-07-2019', '11-07-2019'),
(444, 11, 1, 0, '28-08-2019', '28-08-2019'),
(777, 11, 1, 0, '28-08-2019', '28-08-2019'),
(5555, 11, 3, 0, '28-08-2019', '28-08-2019'),
(222, 11, 4, 0, '28-08-2019', '28-08-2019'),
(888, 10, 2, 2, '02-08-2019', '02-08-2019'),
(222, 10, 2, 1, '02-08-2019', '02-08-2019'),
(777, 12, 1, 0, '25-08-2019', '25-08-2019'),
(444, 12, 1, 0, '25-08-2019', '25-08-2019'),
(5555, 12, 3, 0, '25-08-2019', '25-08-2019'),
(888, 12, 4, 0, '25-08-2019', '25-08-2019'),
(888, 12, 2, 1, '01-08-2019', '01-08-2019'),
(333, 12, 2, 2, '01-08-2019', '01-08-2019'),
(444, 13, 1, 0, '02-08-2019', '02-08-2019'),
(777, 13, 1, 0, '02-08-2019', '02-08-2019'),
(888, 13, 3, 0, '02-08-2019', '02-08-2019'),
(222, 13, 4, 0, '02-08-2019', '02-08-2019'),
(6717, 14, 1, 0, '02-08-2019', '02-08-2019'),
(777, 14, 1, 0, '02-08-2019', '02-08-2019'),
(333, 14, 3, 0, '02-08-2019', '02-08-2019'),
(5555, 14, 4, 0, '02-08-2019', '02-08-2019'),
(5555, 13, 2, 1, '02-08-2019', '02-08-2019'),
(888, 13, 2, 1, '02-08-2019', '02-08-2019');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `anteproyecto`
--
ALTER TABLE `anteproyecto`
  ADD PRIMARY KEY (`codigoAnte`);

--
-- Indices de la tabla `tbl_anteproyectos`
--
ALTER TABLE `tbl_anteproyectos`
  ADD PRIMARY KEY (`CODIGO`);

--
-- Indices de la tabla `tbl_evaluadores`
--
ALTER TABLE `tbl_evaluadores`
  ADD PRIMARY KEY (`CODIGO`);

--
-- Indices de la tabla `tbl_historialusuarios`
--
ALTER TABLE `tbl_historialusuarios`
  ADD PRIMARY KEY (`ID`);

--
-- Indices de la tabla `tbl_usuarios`
--
ALTER TABLE `tbl_usuarios`
  ADD PRIMARY KEY (`IDENTIFICACION`),
  ADD UNIQUE KEY `USUARIO_UNICAUCA` (`USUARIO_UNICAUCA`),
  ADD UNIQUE KEY `CONTRASENIA` (`CONTRASENIA`);

--
-- Indices de la tabla `usuarios`
--
ALTER TABLE `usuarios`
  ADD PRIMARY KEY (`identificacion`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `tbl_historialusuarios`
--
ALTER TABLE `tbl_historialusuarios`
  MODIFY `ID` int(11) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=131;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
