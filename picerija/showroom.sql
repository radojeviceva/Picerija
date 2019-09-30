-- phpMyAdmin SQL Dump
-- version 4.8.3
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Sep 30, 2019 at 06:57 PM
-- Server version: 10.1.36-MariaDB
-- PHP Version: 7.2.11

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `showroom`
--

-- --------------------------------------------------------

--
-- Table structure for table `pizza`
--

CREATE TABLE `pizza` (
  `pizzaID` int(11) NOT NULL,
  `nazivVrste` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `cenaPizze` varchar(255) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `pizza`
--

INSERT INTO `pizza` (`pizzaID`, `nazivVrste`, `cenaPizze`) VALUES
(2, 'Kaprićoza', '123'),
(3, 'Margarita', '123'),
(4, 'Sicilijana', '342'),
(5, 'Vezuvio', '321'),
(6, 'Funđi', '213');

-- --------------------------------------------------------

--
-- Table structure for table `porudzbina`
--

CREATE TABLE `porudzbina` (
  `porudzbinaID` int(11) NOT NULL,
  `pizzaID` int(11) NOT NULL,
  `kolicina` int(11) NOT NULL,
  `datumPreuzimanja` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `porudzbina`
--

INSERT INTO `porudzbina` (`porudzbinaID`, `pizzaID`, `kolicina`, `datumPreuzimanja`) VALUES
(3, 3, 3, '2019-09-30 16:53:10'),
(4, 2, 23, '2019-09-30 16:53:18');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `pizza`
--
ALTER TABLE `pizza`
  ADD PRIMARY KEY (`pizzaID`);

--
-- Indexes for table `porudzbina`
--
ALTER TABLE `porudzbina`
  ADD PRIMARY KEY (`porudzbinaID`),
  ADD KEY `pizzaID` (`pizzaID`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `pizza`
--
ALTER TABLE `pizza`
  MODIFY `pizzaID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `porudzbina`
--
ALTER TABLE `porudzbina`
  MODIFY `porudzbinaID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
