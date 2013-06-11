-- phpMyAdmin SQL Dump
-- version 3.4.10.1
-- http://www.phpmyadmin.net
--
-- Client: localhost
-- Généré le : Mar 11 Juin 2013 à 16:54
-- Version du serveur: 5.5.20
-- Version de PHP: 5.3.10

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de données: `tournois`
--

-- --------------------------------------------------------

--
-- Structure de la table `arbitre`
--

CREATE TABLE IF NOT EXISTS `arbitre` (
  `id_arbitre` int(11) NOT NULL AUTO_INCREMENT,
  `nom_arbitre` varchar(255) NOT NULL,
  `id_match` int(11) NOT NULL,
  PRIMARY KEY (`id_arbitre`),
  KEY `id_match` (`id_match`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Structure de la table `equipe`
--

CREATE TABLE IF NOT EXISTS `equipe` (
  `id_equipe` int(11) NOT NULL AUTO_INCREMENT,
  `nom_equipe` varchar(255) NOT NULL,
  `entraineur_equipe` varchar(255) NOT NULL,
  `capitaine_equipe` varchar(255) NOT NULL,
  `nombre_joueur` int(11) NOT NULL,
  `id_match` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_equipe`),
  KEY `id_match` (`id_match`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=42 ;

--
-- Contenu de la table `equipe`
--

INSERT INTO `equipe` (`id_equipe`, `nom_equipe`, `entraineur_equipe`, `capitaine_equipe`, `nombre_joueur`, `id_match`) VALUES
(34, 'Zao', 'DO', 'CH', 9, NULL),
(35, 'JITING', 'JI', 'TING', 9, NULL),
(36, 'aa', 'jjj', 'ppp', 9, NULL),
(39, 'RRR', 'RR', 'R', 9, NULL),
(40, 'KKKK', 'UU', 'U', 9, NULL),
(41, 'XXX', 'XX', 'X', 9, NULL);

-- --------------------------------------------------------

--
-- Structure de la table `joueur`
--

CREATE TABLE IF NOT EXISTS `joueur` (
  `id_joueur` int(11) NOT NULL AUTO_INCREMENT,
  `nom_joueur` varchar(255) CHARACTER SET utf8 NOT NULL,
  `type_joueur` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `nom_equipe` varchar(255) NOT NULL,
  `id_equipe` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_joueur`),
  KEY `id_equipe` (`id_equipe`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=63 ;

--
-- Contenu de la table `joueur`
--

INSERT INTO `joueur` (`id_joueur`, `nom_joueur`, `type_joueur`, `nom_equipe`, `id_equipe`) VALUES
(9, 'J1', NULL, 'JITING', 35),
(10, 'J2', NULL, 'JITING', 35),
(11, 'J3', NULL, 'JITING', 35),
(12, 'J4', NULL, 'JITING', 35),
(13, 'J5', NULL, 'JITING', 35),
(14, 'J6', NULL, 'JITING', 35),
(15, 'J7', NULL, 'JITING', 35),
(16, 'J8', NULL, 'JITING', 35),
(17, 'D1s', NULL, 'ZHA', 34),
(18, 'D2s', NULL, 'ZHA', 34),
(19, 'D3s', NULL, 'ZHA', 34),
(20, 'D4s', NULL, 'ZHA', 34),
(21, 'D5s', NULL, 'ZHA', 34),
(22, 'D6s', NULL, 'Zao', 34),
(23, '', NULL, 'Zao', 34),
(24, '', NULL, 'Zao', 34),
(25, 'J1', NULL, 'OP', NULL),
(26, 'J2', NULL, 'OP', NULL),
(27, 'J3', NULL, 'OP', NULL),
(28, 'J4', NULL, 'OP', NULL),
(29, 'J5', NULL, 'OP', NULL),
(30, 'J6', NULL, 'OP', NULL),
(31, 'J7', NULL, 'OP', NULL),
(32, 'J8', NULL, 'OP', NULL),
(39, 'R1', NULL, 'RRR', 39),
(40, 'R2', NULL, 'RRR', 39),
(41, 'R3', NULL, 'RRR', 39),
(42, 'R4', NULL, 'RRR', 39),
(43, 'R5', NULL, 'RRR', 39),
(44, 'R6', NULL, 'RRR', 39),
(45, 'R7', NULL, 'RRR', 39),
(46, 'R8', NULL, 'RRR', 39),
(47, 'K1', NULL, 'KKKK', 40),
(48, 'K2', NULL, 'KKKK', 40),
(49, 'U3', NULL, 'KKKK', 40),
(50, 'U4', NULL, 'KKKK', 40),
(51, 'U5', NULL, 'KKKK', 40),
(52, 'U6', NULL, 'KKKK', 40),
(53, 'U7', NULL, 'KKKK', 40),
(54, 'U8', NULL, 'KKKK', 40),
(55, 'X1', NULL, 'XXX', 41),
(56, 'X2', NULL, 'XXX', 41),
(57, 'X3', NULL, 'XXX', 41),
(58, 'X4', NULL, 'XXX', 41),
(59, 'X5', NULL, 'XXX', 41),
(60, 'SDD', NULL, 'XXX', 41),
(61, '', NULL, 'XXX', 41),
(62, '', NULL, 'XXX', 41);

-- --------------------------------------------------------

--
-- Structure de la table `match`
--

CREATE TABLE IF NOT EXISTS `match` (
  `id_match` int(11) NOT NULL,
  `type_match` varchar(255) NOT NULL,
  `equipe_a` varchar(255) NOT NULL,
  `equipe_b` varchar(255) NOT NULL,
  `id_tournois` int(11) NOT NULL,
  PRIMARY KEY (`id_match`),
  KEY `id_match` (`id_match`),
  KEY `id_tournois` (`id_tournois`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `terrain`
--

CREATE TABLE IF NOT EXISTS `terrain` (
  `id_terrain` int(11) NOT NULL AUTO_INCREMENT,
  `nom_terrain` varchar(255) NOT NULL,
  `type_terrain` varchar(255) NOT NULL,
  `id_match` int(11) NOT NULL,
  PRIMARY KEY (`id_terrain`),
  KEY `id_match` (`id_match`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Structure de la table `tournois`
--

CREATE TABLE IF NOT EXISTS `tournois` (
  `id_tournois` int(11) NOT NULL AUTO_INCREMENT,
  `nom_tournois` varchar(255) CHARACTER SET utf8 NOT NULL,
  `type_tournois` varchar(255) CHARACTER SET utf8 NOT NULL,
  `DateD` date NOT NULL,
  `DateF` date NOT NULL,
  `nombre_equipe` int(11) NOT NULL,
  PRIMARY KEY (`id_tournois`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

--
-- Contraintes pour les tables exportées
--

--
-- Contraintes pour la table `arbitre`
--
ALTER TABLE `arbitre`
  ADD CONSTRAINT `arbitre_ibfk_1` FOREIGN KEY (`id_match`) REFERENCES `match` (`id_match`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Contraintes pour la table `equipe`
--
ALTER TABLE `equipe`
  ADD CONSTRAINT `equipe_ibfk_1` FOREIGN KEY (`id_match`) REFERENCES `match` (`id_match`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Contraintes pour la table `joueur`
--
ALTER TABLE `joueur`
  ADD CONSTRAINT `joueur_ibfk_1` FOREIGN KEY (`id_equipe`) REFERENCES `equipe` (`id_equipe`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Contraintes pour la table `match`
--
ALTER TABLE `match`
  ADD CONSTRAINT `match_ibfk_1` FOREIGN KEY (`id_tournois`) REFERENCES `tournois` (`id_tournois`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Contraintes pour la table `terrain`
--
ALTER TABLE `terrain`
  ADD CONSTRAINT `terrain_ibfk_1` FOREIGN KEY (`id_match`) REFERENCES `match` (`id_match`) ON DELETE NO ACTION ON UPDATE NO ACTION;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
