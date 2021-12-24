-- phpMyAdmin SQL Dump
<<<<<<< HEAD
-- version 5.0.1
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1
-- Généré le : mar. 21 déc. 2021 à 11:42
-- Version du serveur :  10.4.11-MariaDB
-- Version de PHP : 7.4.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
=======
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3306
-- Généré le : mar. 14 déc. 2021 à 15:52
-- Version du serveur :  5.7.31
-- Version de PHP : 7.4.9

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
>>>>>>> origin/yannK
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `pepon`
--

-- --------------------------------------------------------

--
-- Structure de la table `article`
--

<<<<<<< HEAD
CREATE TABLE `article` (
  `id_article` int(11) NOT NULL,
  `nom_article` varchar(255) NOT NULL,
  `nutripoint` int(11) NOT NULL,
  `prix` double NOT NULL,
  `id_categorie` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `article`
--

INSERT INTO `article` (`id_article`, `nom_article`, `nutripoint`, `prix`, `id_categorie`) VALUES
(1, 'betrave', 90, 1, 1),
(2, 'coca', 50, 2, 3),
(3, 'gigot agneau', 78, 15, 4),
(4, 'cerise', 72, 2, 2);
=======
DROP TABLE IF EXISTS `article`;
CREATE TABLE IF NOT EXISTS `article` (
  `id_article` int(11) NOT NULL AUTO_INCREMENT,
  `nom_article` varchar(255) NOT NULL,
  `nutripoint` int(11) NOT NULL,
  `prix` double NOT NULL,
  `id_categorie` int(11) NOT NULL,
  PRIMARY KEY (`id_article`),
  KEY `fk_id_categorie` (`id_categorie`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
>>>>>>> origin/yannK

-- --------------------------------------------------------

--
-- Structure de la table `categorie`
--

<<<<<<< HEAD
CREATE TABLE `categorie` (
  `id_categorie` int(11) NOT NULL,
  `libelle` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `categorie`
--

INSERT INTO `categorie` (`id_categorie`, `libelle`) VALUES
(1, 'legume'),
(2, 'fruit'),
(3, 'boisson'),
(4, 'viande');
=======
DROP TABLE IF EXISTS `categorie`;
CREATE TABLE IF NOT EXISTS `categorie` (
  `id_categorie` int(11) NOT NULL AUTO_INCREMENT,
  `libelle` varchar(255) NOT NULL,
  PRIMARY KEY (`id_categorie`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
>>>>>>> origin/yannK

-- --------------------------------------------------------

--
-- Structure de la table `commande`
--

<<<<<<< HEAD
CREATE TABLE `commande` (
  `id_commande` int(11) NOT NULL,
  `prix_total` double DEFAULT NULL,
  `date_achat` date NOT NULL,
  `id_user` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `commande`
--

INSERT INTO `commande` (`id_commande`, `prix_total`, `date_achat`, `id_user`) VALUES
(1, NULL, '2021-12-21', 5);
=======
DROP TABLE IF EXISTS `commande`;
CREATE TABLE IF NOT EXISTS `commande` (
  `id_commande` int(11) NOT NULL AUTO_INCREMENT,
  `date_commande` date NOT NULL,
  PRIMARY KEY (`id_commande`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
>>>>>>> origin/yannK

-- --------------------------------------------------------

--
<<<<<<< HEAD
-- Structure de la table `panier`
--

CREATE TABLE `panier` (
  `id_commande` int(11) NOT NULL,
  `id_article` int(11) NOT NULL,
  `quantite` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `panier`
--

INSERT INTO `panier` (`id_commande`, `id_article`, `quantite`) VALUES
(1, 1, 2),
(1, 2, 3);
=======
-- Structure de la table `detail_commande`
--

DROP TABLE IF EXISTS `detail_commande`;
CREATE TABLE IF NOT EXISTS `detail_commande` (
  `id_commande` int(11) NOT NULL,
  `id_article` int(11) NOT NULL,
  `id_user` int(11) NOT NULL,
  `prix` double NOT NULL,
  `quantite` int(11) NOT NULL,
  PRIMARY KEY (`id_commande`,`id_user`),
  KEY `fk_id_user` (`id_user`),
  KEY `fk_id_article` (`id_article`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
>>>>>>> origin/yannK

-- --------------------------------------------------------

--
-- Structure de la table `statut`
--

<<<<<<< HEAD
CREATE TABLE `statut` (
  `id_statut` int(11) NOT NULL,
  `libelle` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `statut`
--

INSERT INTO `statut` (`id_statut`, `libelle`) VALUES
(1, 'client'),
(2, 'admin');
=======
DROP TABLE IF EXISTS `statut`;
CREATE TABLE IF NOT EXISTS `statut` (
  `id_statut` int(11) NOT NULL,
  `libelle` varchar(255) NOT NULL,
  PRIMARY KEY (`id_statut`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
>>>>>>> origin/yannK

-- --------------------------------------------------------

--
-- Structure de la table `user`
--

<<<<<<< HEAD
CREATE TABLE `user` (
  `id_user` int(11) NOT NULL,
=======
DROP TABLE IF EXISTS `user`;
CREATE TABLE IF NOT EXISTS `user` (
  `id_user` int(11) NOT NULL AUTO_INCREMENT,
>>>>>>> origin/yannK
  `nom` varchar(255) NOT NULL,
  `prenom` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `mot_passe` varchar(255) NOT NULL,
<<<<<<< HEAD
  `id_statut` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `user`
--

INSERT INTO `user` (`id_user`, `nom`, `prenom`, `email`, `mot_passe`, `id_statut`) VALUES
(5, 'ton', 'kam', 'tonkam@test.fr', '1234', 1),
(6, 'admin', 'admin', 'admin@admin.admin', '1234', 2);

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `article`
--
ALTER TABLE `article`
  ADD PRIMARY KEY (`id_article`),
  ADD KEY `fk_id_categorie` (`id_categorie`);

--
-- Index pour la table `categorie`
--
ALTER TABLE `categorie`
  ADD PRIMARY KEY (`id_categorie`);

--
-- Index pour la table `commande`
--
ALTER TABLE `commande`
  ADD PRIMARY KEY (`id_commande`),
  ADD KEY `fk_id_user` (`id_user`);

--
-- Index pour la table `panier`
--
ALTER TABLE `panier`
  ADD PRIMARY KEY (`id_commande`,`id_article`),
  ADD KEY `pk_id_article` (`id_article`);

--
-- Index pour la table `statut`
--
ALTER TABLE `statut`
  ADD PRIMARY KEY (`id_statut`);

--
-- Index pour la table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id_user`),
  ADD UNIQUE KEY `email` (`email`),
  ADD KEY `fk_id_statut` (`id_statut`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `article`
--
ALTER TABLE `article`
  MODIFY `id_article` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT pour la table `categorie`
--
ALTER TABLE `categorie`
  MODIFY `id_categorie` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT pour la table `commande`
--
ALTER TABLE `commande`
  MODIFY `id_commande` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT pour la table `statut`
--
ALTER TABLE `statut`
  MODIFY `id_statut` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT pour la table `user`
--
ALTER TABLE `user`
  MODIFY `id_user` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;
=======
  `id_statut` int(11) NOT NULL,
  PRIMARY KEY (`id_user`),
  KEY `fk_id_statut` (`id_statut`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
>>>>>>> origin/yannK

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `article`
--
ALTER TABLE `article`
  ADD CONSTRAINT `fk_id_categorie` FOREIGN KEY (`id_categorie`) REFERENCES `categorie` (`id_categorie`);

--
<<<<<<< HEAD
-- Contraintes pour la table `commande`
--
ALTER TABLE `commande`
  ADD CONSTRAINT `fk_id_user` FOREIGN KEY (`id_user`) REFERENCES `user` (`id_user`);

--
-- Contraintes pour la table `panier`
--
ALTER TABLE `panier`
  ADD CONSTRAINT `pk_id_article` FOREIGN KEY (`id_article`) REFERENCES `article` (`id_article`),
  ADD CONSTRAINT `pk_id_commande` FOREIGN KEY (`id_commande`) REFERENCES `commande` (`id_commande`);

--
=======
-- Contraintes pour la table `detail_commande`
--
ALTER TABLE `detail_commande`
  ADD CONSTRAINT `fk_id_article` FOREIGN KEY (`id_article`) REFERENCES `article` (`id_article`),
  ADD CONSTRAINT `fk_id_commande` FOREIGN KEY (`id_commande`) REFERENCES `commande` (`id_commande`),
  ADD CONSTRAINT `fk_id_user` FOREIGN KEY (`id_user`) REFERENCES `user` (`id_user`);

--
>>>>>>> origin/yannK
-- Contraintes pour la table `user`
--
ALTER TABLE `user`
  ADD CONSTRAINT `fk_id_statut` FOREIGN KEY (`id_statut`) REFERENCES `statut` (`id_statut`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
