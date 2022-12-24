-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Dec 16, 2022 at 02:11 PM
-- Server version: 10.4.25-MariaDB
-- PHP Version: 8.1.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `book_store_g6`
--
CREATE DATABASE IF NOT EXISTS `book_store_g6` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
USE `book_store_g6`;

-- --------------------------------------------------------

--
-- Table structure for table `admin`
--

CREATE TABLE `admin` (
  `id` int(11) NOT NULL,
  `name` varchar(50) CHARACTER SET utf8 NOT NULL,
  `date_of_birth` date DEFAULT NULL,
  `user_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `admin`
--

INSERT INTO `admin` (`id`, `name`, `date_of_birth`, `user_id`) VALUES
(1, 'admin', '2002-10-01', 1);

-- --------------------------------------------------------

--
-- Table structure for table `author`
--

CREATE TABLE `author` (
  `id` int(11) NOT NULL,
  `name` varchar(100) CHARACTER SET utf8 NOT NULL,
  `status` enum('ENABLED','DISABLED') COLLATE utf8mb4_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `author`
--

INSERT INTO `author` (`id`, `name`, `status`) VALUES
(1, 'Ertha Minkin', 'DISABLED'),
(2, 'Bartolomeo Titchmarsh', 'DISABLED'),
(3, 'Laird Selborne', 'ENABLED'),
(4, 'Jonell Shipsey', 'ENABLED'),
(5, 'Kaleena Jost', 'ENABLED'),
(6, 'Lotty Ziemecki', 'DISABLED'),
(7, 'Mel Yewdall', 'ENABLED'),
(8, 'Troy Mayzes', 'ENABLED'),
(9, 'Theresita Folkerts', 'DISABLED'),
(10, 'Cynthie Roblou', 'DISABLED');

-- --------------------------------------------------------

--
-- Table structure for table `book`
--

CREATE TABLE `book` (
  `ID` int(11) NOT NULL,
  `title` varchar(100) CHARACTER SET utf8 NOT NULL,
  `isbn13` varchar(20) COLLATE utf8mb4_unicode_ci NOT NULL,
  `language_id` int(11) NOT NULL,
  `num_pages` int(11) NOT NULL,
  `publisher_id` int(11) NOT NULL,
  `category_id` int(11) NOT NULL,
  `author_id` int(11) NOT NULL,
  `published_date` date DEFAULT NULL,
  `stock` int(11) NOT NULL,
  `status` enum('ENABLED','DISABLED') COLLATE utf8mb4_unicode_ci NOT NULL,
  `price` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `book`
--

INSERT INTO `book` (`ID`, `title`, `isbn13`, `language_id`, `num_pages`, `publisher_id`, `category_id`, `author_id`, `published_date`, `stock`, `status`, `price`) VALUES
(1, 'Close Your Eyes (Hypnotic) (Doctor Sleep)', '633872806-1', 2, 159, 4, 10, 2, '2001-03-27', 111, 'DISABLED', 283.8),
(2, 'Inn of Evil (Inochi bô ni furô)', '131890742-X', 3, 82, 9, 8, 5, '2020-03-18', 20, 'DISABLED', 464.4),
(3, 'Spring in a Small Town (Xiao cheng zhi chun)', '225892349-2', 2, 403, 1, 8, 2, '2004-04-04', 106, 'DISABLED', 929.3),
(4, 'Eight Legged Freaks', '777027861-9', 1, 189, 7, 4, 8, '2012-02-08', 97, 'DISABLED', 846.2),
(5, 'Muppets Most Wanted', '172898217-0', 3, 264, 5, 2, 5, '2001-11-30', 101, 'DISABLED', 907.3),
(6, 'Star Wars: Episode II - Attack of the Clones', '872921727-X', 3, 189, 3, 8, 2, '2021-02-22', 64, 'ENABLED', 97.6),
(7, 'Up in the Wind', '166093394-3', 1, 464, 3, 7, 4, '2014-03-01', 76, 'DISABLED', 830.9),
(8, 'Stone Cold', '003679020-6', 1, 463, 7, 2, 4, '2006-04-03', 168, 'DISABLED', 361.4),
(9, 'Light the Fuse... Sartana Is Coming', '290348956-4', 3, 120, 4, 6, 5, '2012-03-15', 78, 'ENABLED', 801.4),
(10, 'Aliens', '565134395-4', 2, 341, 4, 4, 2, '2014-07-27', 175, 'ENABLED', 903.5),
(11, 'Clara\'s Heart', '399122951-X', 2, 393, 6, 6, 6, '2001-10-13', 158, 'ENABLED', 238.9),
(12, 'Pyramid of Triboulet, The (La pyramide de Triboulet)', '005757618-1', 2, 121, 4, 7, 8, '2024-12-06', 76, 'DISABLED', 84.6),
(13, 'Once Were Warriors', '012820279-3', 1, 238, 2, 6, 9, '2000-12-01', 20, 'ENABLED', 423.5),
(14, 'Return of the Street Fighter (Satsujin ken 2)', '269539066-1', 2, 191, 10, 2, 10, '2007-02-22', 128, 'DISABLED', 997.4),
(15, 'Top of the Food Chain (a.k.a. Invasion!)', '466640883-5', 2, 290, 5, 9, 1, '2018-03-20', 52, 'ENABLED', 872.7),
(16, 'Until Death', '714470422-2', 2, 294, 1, 6, 2, '2003-05-21', 93, 'ENABLED', 589.3),
(17, 'Romasanta: The Werewolf Hunt', '143243939-1', 3, 352, 1, 2, 10, '2009-04-21', 98, 'DISABLED', 780.6),
(18, 'Million Dollar Mystery', '453227950-X', 1, 262, 4, 1, 4, '2024-01-04', 34, 'ENABLED', 718),
(19, 'Me Two (Personne aux deux personnes, La)', '867944226-7', 1, 89, 4, 7, 9, '2015-04-19', 16, 'ENABLED', 781.2),
(20, 'Mysteries of Lisbon (Mistérios de Lisboa)', '706234756-6', 3, 416, 4, 6, 8, '2002-05-13', 134, 'DISABLED', 688.2),
(21, 'Mad Love (Juana la Loca)', '271886549-0', 3, 200, 4, 2, 10, '2024-09-14', 157, 'DISABLED', 627),
(22, 'Barbie: A Perfect Christmas', '317545887-4', 3, 426, 9, 5, 3, '2001-02-21', 67, 'ENABLED', 734.2),
(23, 'Up in Smoke', '254080559-0', 1, 364, 8, 5, 9, '2003-02-11', 41, 'DISABLED', 43.2),
(24, 'Master and Commander: The Far Side of the World', '578395393-8', 3, 165, 10, 7, 7, '2006-07-23', 167, 'DISABLED', 989.9),
(25, 'Duets', '610393768-X', 3, 361, 8, 9, 5, '2021-09-10', 148, 'DISABLED', 917),
(26, 'Collapse', '099967667-9', 1, 139, 5, 6, 5, '2018-12-16', 162, 'ENABLED', 982.1),
(27, 'Shriek If You Know What I Did Last Friday the Thirteenth', '889055549-1', 1, 149, 2, 5, 2, '2018-02-21', 122, 'ENABLED', 376.3),
(28, 'Love Story', '273407416-8', 1, 125, 10, 4, 1, '2004-08-02', 42, 'ENABLED', 277.2),
(29, 'Bishop\'s Wife, The', '551263530-1', 2, 109, 3, 3, 3, '2013-08-22', 63, 'DISABLED', 742.1),
(30, 'Rage of Angels: The Story Continues', '775999533-4', 3, 131, 7, 9, 4, '2017-11-03', 93, 'ENABLED', 816.5),
(31, 'The Raid', '692556094-X', 3, 375, 10, 10, 4, '2008-11-29', 17, 'DISABLED', 148.6),
(32, 'Fans', '122492278-6', 1, 126, 2, 9, 5, '2014-06-14', 20, 'ENABLED', 937.9),
(33, '12 O\'Clock Boys', '523620653-7', 3, 78, 8, 4, 4, '2025-02-28', 47, 'DISABLED', 384),
(34, 'Counterfeiters, The (Le cave se rebiffe)', '446254448-X', 3, 301, 6, 4, 6, '2018-02-05', 75, 'ENABLED', 597.9),
(35, 'Titus', '245204957-3', 3, 468, 7, 5, 1, '2006-01-26', 136, 'ENABLED', 771.6),
(36, 'Force 10 from Navarone', '086874781-5', 3, 70, 7, 6, 5, '2020-10-24', 109, 'DISABLED', 322),
(37, 'Maryam', '116878338-0', 2, 121, 5, 6, 7, '2012-05-01', 11, 'ENABLED', 492.3),
(38, 'House Built on Water, A (Khanei ruye ab)', '915708274-X', 2, 358, 1, 9, 3, '2020-11-15', 32, 'DISABLED', 52),
(39, 'Curse of the Puppet Master (Puppet Master 6: The Curse)', '189150129-1', 2, 104, 6, 10, 5, '2008-02-05', 185, 'DISABLED', 621.6),
(40, '30 Minutes or Less', '240129401-5', 2, 457, 7, 3, 9, '2011-11-22', 29, 'DISABLED', 377.1),
(41, 'Family Game, The (Kazoku gêmu)', '183883733-7', 3, 444, 1, 5, 3, '2002-04-09', 140, 'DISABLED', 987.2),
(42, 'Ghost Dog: The Way of the Samurai', '361387930-1', 2, 103, 7, 9, 4, '2017-01-16', 148, 'DISABLED', 606.3),
(43, 'Mood Indigo (L\'écume des jours)', '034702031-3', 3, 345, 6, 4, 4, '2025-02-05', 149, 'DISABLED', 285.7),
(44, 'Too Many Cooks', '752804373-7', 3, 243, 8, 10, 1, '2012-05-29', 69, 'DISABLED', 554.8),
(45, 'The Reverse', '090772534-1', 2, 391, 9, 7, 4, '2002-04-30', 62, 'DISABLED', 559.3),
(46, 'Mickey\'s Once Upon a Christmas', '448324618-6', 1, 292, 4, 1, 5, '2014-07-14', 179, 'ENABLED', 429.3),
(47, 'Me and you (io e te)', '755891866-9', 1, 72, 5, 6, 10, '2018-12-29', 100, 'DISABLED', 205.9),
(48, 'Spartacus', '751568533-6', 3, 306, 6, 2, 1, '2024-03-21', 192, 'ENABLED', 723.7),
(49, 'Mitchell', '991214504-6', 1, 193, 3, 10, 1, '2009-09-21', 61, 'DISABLED', 678.3),
(50, 'Hurricane, The', '536297306-1', 2, 71, 8, 7, 2, '2017-12-21', 197, 'DISABLED', 202.3),
(51, 'The Taking of Deborah Logan', '256250911-0', 2, 397, 6, 8, 9, '2016-03-18', 194, 'ENABLED', 90.7),
(52, 'Those Daring Young Men in Their Jaunty Jalopies', '507424943-0', 3, 302, 8, 9, 10, '2005-10-16', 197, 'DISABLED', 239.7),
(53, 'Terror, The', '370733633-6', 2, 368, 10, 4, 7, '2012-07-14', 165, 'DISABLED', 650.1),
(54, 'Get Smart', '066602288-7', 2, 57, 6, 9, 10, '2020-06-05', 31, 'DISABLED', 921.3),
(55, 'Tom Jones', '213447218-9', 3, 281, 7, 3, 1, '2010-10-27', 113, 'DISABLED', 619.6),
(56, 'Charter Trip, The (a.k.a. Package Tour, The) (Sällskapsresan)', '453085241-5', 3, 464, 4, 1, 5, '2019-01-14', 162, 'DISABLED', 238.1),
(57, 'Being There', '415244669-2', 1, 172, 10, 8, 4, '2016-04-26', 148, 'DISABLED', 680.4),
(58, 'Nenette and Boni (Nénette et Boni)', '760560284-7', 3, 489, 5, 5, 6, '2020-04-03', 15, 'ENABLED', 401.9),
(59, 'Raggedy Man', '330592268-0', 3, 415, 4, 5, 2, '2020-01-06', 58, 'ENABLED', 767.1),
(60, 'Acla, The Descent into Floristella (La discesa di Aclà a Floristella)', '159118818-0', 1, 288, 5, 7, 3, '2014-02-02', 71, 'ENABLED', 97.8),
(61, 'Mademoiselle', '583151051-4', 1, 245, 3, 9, 8, '2021-05-22', 116, 'DISABLED', 564.2),
(62, 'Cooking with Stella', '751687840-5', 2, 212, 9, 1, 8, '2005-07-20', 20, 'DISABLED', 527),
(63, 'A Coming-Out Party', '392549693-9', 1, 337, 4, 2, 2, '2006-06-03', 110, 'DISABLED', 27.3),
(64, 'Cannibal Women in the Avocado Jungle of Death', '335974384-9', 3, 286, 7, 10, 4, '2021-09-07', 55, 'DISABLED', 270.6),
(65, 'Man from Beyond, The', '087863889-X', 1, 92, 5, 3, 8, '2021-02-14', 23, 'ENABLED', 998.3),
(66, 'Mission, The', '226825085-7', 2, 317, 3, 7, 1, '2009-02-08', 40, 'ENABLED', 181),
(67, 'Versus', '258966546-6', 3, 186, 4, 3, 9, '2013-09-23', 41, 'DISABLED', 666),
(68, 'Green Street Hooligans (a.k.a. Hooligans)', '580272207-X', 2, 283, 5, 1, 1, '2019-03-01', 163, 'DISABLED', 229.5),
(69, 'Land of Silence and Darkness (Land des Schweigens und der Dunkelheit)', '740851055-9', 1, 349, 9, 9, 10, '2005-05-13', 42, 'ENABLED', 297),
(70, 'Death Race 3: Inferno', '476258894-6', 1, 130, 1, 8, 6, '2012-12-07', 192, 'DISABLED', 302.3),
(71, 'The Interview', '236447859-6', 3, 230, 4, 6, 9, '2007-09-30', 79, 'ENABLED', 717.6),
(72, 'August: Osage County', '334400818-8', 1, 394, 4, 10, 4, '2025-11-26', 32, 'DISABLED', 331.4),
(73, 'Devil\'s Playground, The', '145953438-7', 1, 268, 7, 7, 6, '2019-11-17', 140, 'ENABLED', 679.8),
(74, 'Short Circuit 2', '389473925-8', 1, 378, 7, 8, 8, '2001-07-26', 18, 'ENABLED', 656.9),
(75, 'Grass Is Greener, The', '755617641-X', 2, 153, 8, 6, 1, '2013-10-11', 166, 'ENABLED', 546.3),
(76, 'Happy Here and Now', '739854877-X', 2, 218, 7, 10, 10, '2004-07-03', 82, 'DISABLED', 708.1),
(77, 'Story of Us, The', '704025342-9', 1, 411, 3, 7, 6, '2015-07-28', 57, 'DISABLED', 197.2),
(78, 'Powaqqatsi', '247726673-X', 2, 433, 8, 8, 8, '2021-05-09', 148, 'DISABLED', 73.8),
(79, 'My Big Fat Greek Wedding', '937281723-6', 2, 63, 8, 8, 5, '2011-08-02', 135, 'DISABLED', 926.2),
(80, 'Illusionist, The (L\'illusionniste)', '085137997-4', 1, 86, 5, 4, 7, '2005-10-05', 15, 'ENABLED', 817.4),
(81, 'Azumi 2: Death or Love', '009147811-1', 1, 334, 9, 6, 6, '2019-01-07', 53, 'ENABLED', 302.5),
(82, 'Old School', '937267357-9', 3, 213, 8, 1, 8, '2006-12-15', 176, 'DISABLED', 342.4),
(83, 'InAPPropriate Comedy', '225811237-0', 2, 125, 8, 7, 6, '2013-02-06', 82, 'ENABLED', 775.2),
(84, 'It\'s My Mother\'s Birthday Today', '847162369-2', 1, 441, 8, 4, 3, '2017-10-13', 108, 'ENABLED', 953.9),
(85, 'Castle, The (Das Schloß)', '559443645-6', 2, 446, 2, 10, 7, '2001-03-03', 57, 'DISABLED', 564),
(86, '48 Shades', '447793302-9', 3, 78, 5, 10, 3, '2002-01-10', 193, 'ENABLED', 725.3),
(87, 'True Legend (Su Qi-Er)', '342675733-8', 2, 110, 3, 4, 7, '2004-04-06', 108, 'DISABLED', 122.5),
(88, 'Irreconcilable Differences', '346656668-1', 2, 260, 1, 5, 10, '2023-02-14', 135, 'ENABLED', 661.4),
(89, 'Truth in 24', '734184157-5', 1, 294, 8, 6, 2, '2003-04-14', 142, 'DISABLED', 830.5),
(90, 'Strawberries in the Supermarket (Jagoda u supermarketu) ', '732473034-5', 2, 351, 7, 3, 4, '2006-12-19', 22, 'ENABLED', 958.8),
(91, 'Film Geek', '533931279-8', 1, 341, 9, 1, 1, '2001-07-28', 155, 'DISABLED', 282),
(92, 'How to Rob a Bank', '110182050-0', 2, 469, 4, 8, 2, '2006-12-04', 24, 'ENABLED', 364.7),
(93, 'Private Function, A', '149755986-3', 1, 408, 7, 10, 6, '2004-02-13', 183, 'ENABLED', 882.9),
(94, 'D.C.H. (Dil Chahta Hai)', '156516469-5', 2, 66, 4, 4, 2, '2012-11-12', 142, 'ENABLED', 54.2),
(95, 'Puppet Master 5: The Final Chapter', '777161925-8', 1, 113, 3, 5, 3, '2008-05-08', 15, 'DISABLED', 227.9),
(96, 'Cruel Intentions 2 (Cruel Intentions 2: Manchester Prep)', '798508106-2', 3, 230, 7, 7, 6, '2011-09-29', 52, 'ENABLED', 196.3),
(97, 'Everybody\'s Got Somebody... Not Me', '385343847-4', 3, 489, 9, 6, 5, '2016-09-25', 35, 'ENABLED', 257),
(98, 'Evening', '769925317-5', 1, 414, 4, 5, 10, '2007-11-11', 14, 'DISABLED', 890.7),
(99, 'Trembling Before G-d', '706321870-0', 3, 246, 5, 2, 8, '2014-01-14', 82, 'DISABLED', 705.2),
(100, 'Man with the Golden Gun, The', '553232901-X', 1, 358, 7, 9, 10, '2022-05-01', 80, 'ENABLED', 669.6);

-- --------------------------------------------------------

--
-- Table structure for table `book_category`
--

CREATE TABLE `book_category` (
  `id` int(11) NOT NULL,
  `name` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL,
  `status` enum('ENABLED','DISABLED') COLLATE utf8mb4_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `book_category`
--

INSERT INTO `book_category` (`id`, `name`, `status`) VALUES
(1, 'Horror', 'ENABLED'),
(2, 'Romance', 'ENABLED'),
(3, 'Horror', 'DISABLED'),
(4, 'Science fiction', 'DISABLED'),
(5, 'Classics', 'DISABLED'),
(6, 'Classics', 'ENABLED'),
(7, 'Science fiction', 'DISABLED'),
(8, 'Romance', 'DISABLED'),
(9, 'Short stories', 'ENABLED'),
(10, 'Romance', 'ENABLED');

-- --------------------------------------------------------

--
-- Table structure for table `book_language`
--

CREATE TABLE `book_language` (
  `language_id` int(11) NOT NULL,
  `language_code` varchar(10) CHARACTER SET utf8 NOT NULL,
  `language_name` varchar(50) CHARACTER SET utf8 NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `book_language`
--

INSERT INTO `book_language` (`language_id`, `language_code`, `language_name`) VALUES
(1, 'vi-VN', 'Vietnamese (Viet Nam)'),
(2, 'en-US', 'English (United States)'),
(3, 'en-GB', 'English (United Kingdom)');

-- --------------------------------------------------------

--
-- Table structure for table `customer`
--

CREATE TABLE `customer` (
  `id` int(11) NOT NULL,
  `name` varchar(100) CHARACTER SET utf8 NOT NULL,
  `phone` varchar(15) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `email` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `customer`
--

INSERT INTO `customer` (`id`, `name`, `phone`, `email`) VALUES
(1, 'Micheal Gaskins', 'mgaskins0@istoc', '966 713 8390'),
(2, 'Cammi Wetheril', 'cwetheril1@drup', '499 696 7368'),
(3, 'Kendra Risbie', 'krisbie2@auda.o', '610 308 0647'),
(4, 'Christalle Conibere', 'cconibere3@stan', '518 402 8229'),
(5, 'Pincus Cescotti', 'pcescotti4@yaho', '355 752 5293'),
(6, 'Dedie Woodyear', 'dwoodyear5@usda', '660 621 8755'),
(7, 'Heda Simon', 'hsimon6@busines', '789 111 0264'),
(8, 'Barrie Seacroft', 'bseacroft7@topl', '936 210 1683'),
(9, 'Mommy Clemintoni', 'mclemintoni8@st', '101 993 0881'),
(10, 'Hakim Bearns', 'hbearns9@digg.c', '113 917 5197');

-- --------------------------------------------------------

--
-- Table structure for table `employee`
--

CREATE TABLE `employee` (
  `id` int(11) NOT NULL,
  `name` varchar(50) CHARACTER SET utf8 NOT NULL,
  `date_of_birth` date DEFAULT NULL,
  `bank_account` varchar(20) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `is_activate_account` tinyint(4) NOT NULL,
  `user_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `employee`
--

INSERT INTO `employee` (`id`, `name`, `date_of_birth`, `bank_account`, `is_activate_account`, `user_id`) VALUES
(1, 'Aundrea Llop', '1997-04-29', '5724024168', 1, 8),
(2, 'Moria Lester', '2000-08-30', '9285940036', 0, 9),
(3, 'Ellette Symondson', '1998-05-01', '4443497857', 1, 4),
(4, 'Lisbeth Isoldi', '2002-11-25', '7623539244', 1, 2),
(6, 'Opalina Saines', '2002-05-04', '6627658448', 1, 10),
(7, 'Valentia Josskoviz', '1992-04-09', '8771301858', 1, 5),
(8, 'Koren MacHoste', '1999-03-22', '1623204019', 1, 3),
(9, 'Ursala Screech', '1998-12-22', '1820847802', 0, 7),
(10, 'Willis Gerin', '1996-05-30', '4162390548', 0, 6);

-- --------------------------------------------------------

--
-- Table structure for table `line_item`
--

CREATE TABLE `line_item` (
  `ID` int(11) NOT NULL,
  `book_id` int(11) NOT NULL,
  `quantity` int(11) DEFAULT NULL,
  `order_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `line_item`
--

INSERT INTO `line_item` (`ID`, `book_id`, `quantity`, `order_id`) VALUES
(1, 3, 9, 6),
(2, 7, 8, 5),
(3, 9, 8, 5),
(4, 1, 7, 9),
(5, 6, 1, 10),
(6, 4, 6, 8),
(7, 5, 8, 4),
(8, 8, 10, 6),
(9, 5, 3, 7),
(10, 8, 5, 8);

-- --------------------------------------------------------

--
-- Table structure for table `order`
--

CREATE TABLE `order` (
  `id` int(11) NOT NULL,
  `created_date` date NOT NULL,
  `employee_id` int(11) NOT NULL,
  `customer_id` int(11) NOT NULL,
  `actual_total` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `order`
--

INSERT INTO `order` (`id`, `created_date`, `employee_id`, `customer_id`, `actual_total`) VALUES
(1, '2023-08-28', 7, 2, 163),
(2, '2022-01-26', 3, 10, 139),
(3, '2022-02-02', 6, 5, 182),
(4, '2023-07-04', 7, 5, 147),
(5, '2022-01-05', 4, 2, 125),
(6, '2023-08-22', 1, 2, 105),
(7, '2023-10-10', 2, 9, 141),
(8, '2023-10-18', 1, 2, 136),
(9, '2021-12-14', 8, 7, 189),
(10, '2022-04-11', 9, 4, 110);

-- --------------------------------------------------------

--
-- Table structure for table `promotion_books`
--

CREATE TABLE `promotion_books` (
  `book_id` int(11) NOT NULL,
  `promotion_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `promotion_books`
--

INSERT INTO `promotion_books` (`book_id`, `promotion_id`) VALUES
(2, 1),
(4, 5),
(5, 7),
(6, 5),
(6, 7),
(6, 10),
(8, 2),
(8, 9),
(9, 10),
(10, 2);

-- --------------------------------------------------------

--
-- Table structure for table `promotion_campaign`
--

CREATE TABLE `promotion_campaign` (
  `id` int(11) NOT NULL,
  `name` varchar(50) CHARACTER SET utf8 NOT NULL,
  `description` varchar(200) CHARACTER SET utf8 NOT NULL,
  `start_date` date DEFAULT NULL,
  `end_date` date DEFAULT NULL,
  `discount_percent` int(11) DEFAULT NULL,
  `max_number_orders` int(11) DEFAULT NULL,
  `number_apply_customer` int(11) DEFAULT NULL,
  `is_apply_anonymous_customer` tinyint(4) NOT NULL,
  `current_customer_applied` int(11) NOT NULL,
  `current_order_applied` int(11) NOT NULL,
  `status` enum('ENABLED','DISABLED','OPENING','CLOSE') COLLATE utf8mb4_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `promotion_campaign`
--

INSERT INTO `promotion_campaign` (`id`, `name`, `description`, `start_date`, `end_date`, `discount_percent`, `max_number_orders`, `number_apply_customer`, `is_apply_anonymous_customer`, `current_customer_applied`, `current_order_applied`, `status`) VALUES
(1, 'Horizontal grid-enabled website', 'Curabitur gravida nisi at nibh. In hac habitasse platea dictumst. Aliquam augue quam, sollicitudin vitae, consectetuer eget, rutrum at, lorem.\n\nInteger tincidunt ante vel ipsum. Praesent blandit lacin', '2022-12-01', '2022-01-08', 51, 78, 45, 0, 7, 68, 'DISABLED'),
(2, 'Public-key motivating system engine', 'Proin leo odio, porttitor id, consequat in, consequat ut, nulla. Sed accumsan felis. Ut at dolor quis odio consequat varius.\n\nInteger ac leo. Pellentesque ultrices mattis odio. Donec vitae nisi.', '2022-12-04', '2022-01-13', 29, 54, 46, 1, 8, 17, 'DISABLED'),
(3, 'Configurable secondary core', 'Nullam porttitor lacus at turpis. Donec posuere metus vitae ipsum. Aliquam non mauris.\n\nMorbi non lectus. Aliquam sit amet diam in magna bibendum imperdiet. Nullam orci pede, venenatis non, sodales se', '2022-12-01', '2021-12-12', 39, 53, 41, 0, 11, 62, 'ENABLED'),
(4, 'Customizable client-server definition', 'Vestibulum quam sapien, varius ut, blandit non, interdum in, ante. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Duis faucibus accumsan odio. Curabitur conval', '2022-12-04', '2021-12-12', 30, 88, 48, 0, 4, 50, 'OPENING'),
(5, 'Advanced multi-state archive', 'Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Proin risus. Praesent lectus.\n\nVestibulum quam sapien, varius ut, blandit non, interdum in, ante. Vestibulum ante ipsum primis in faucibus orc', '2022-12-01', '2021-12-25', 20, 77, 44, 1, 29, 83, 'OPENING'),
(6, 'Exclusive stable initiative', 'Pellentesque at nulla. Suspendisse potenti. Cras in purus eu magna vulputate luctus.\n\nCum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Vivamus vestibulum sagittis ', '2022-12-01', '2021-12-12', 59, 70, 48, 1, 19, 0, 'ENABLED'),
(7, 'Cross-group uniform model', 'Curabitur in libero ut massa volutpat convallis. Morbi odio odio, elementum eu, interdum eu, tincidunt in, leo. Maecenas pulvinar lobortis est.\n\nPhasellus sit amet erat. Nulla tempus. Vivamus in felis', '2022-12-02', '2022-01-27', 77, 62, 42, 1, 10, 26, 'DISABLED'),
(8, 'Progressive content-based analyzer', 'Maecenas tristique, est et tempus semper, est quam pharetra magna, ac consequat metus sapien ut nunc. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Mauris viv', '2022-12-01', '2022-01-10', 13, 92, 43, 1, 23, 9, 'OPENING'),
(9, 'Integrated maximized task-force', 'Phasellus in felis. Donec semper sapien a libero. Nam dui.\n\nProin leo odio, porttitor id, consequat in, consequat ut, nulla. Sed accumsan felis. Ut at dolor quis odio consequat varius.\n\nInteger ac leo', '2022-12-02', '2021-12-13', 5, 89, 49, 0, 8, 78, 'ENABLED'),
(10, 'Multi-channelled composite alliance', 'In sagittis dui vel nisl. Duis ac nibh. Fusce lacus purus, aliquet at, feugiat non, pretium quis, lectus.\n\nSuspendisse potenti. In eleifend quam a odio. In hac habitasse platea dictumst.', '2022-12-02', '2022-01-25', 29, 55, 42, 1, 22, 46, 'DISABLED'),
(11, 'Decentralized mobile moderator', 'Maecenas ut massa quis augue luctus tincidunt. Nulla mollis molestie lorem. Quisque ut erat.\n\nCurabitur gravida nisi at nibh. In hac habitasse platea dictumst. Aliquam augue quam, sollicitudin vitae, ', '2022-12-01', '2022-01-10', 69, 86, 50, 1, 26, 99, 'ENABLED');

-- --------------------------------------------------------

--
-- Table structure for table `publisher`
--

CREATE TABLE `publisher` (
  `id` int(11) NOT NULL,
  `name` varchar(100) CHARACTER SET utf8 NOT NULL,
  `status` enum('ENABLED','DISABLED') COLLATE utf8mb4_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `publisher`
--

INSERT INTO `publisher` (`id`, `name`, `status`) VALUES
(1, 'DuBuque, Nicolas and Connelly', 'ENABLED'),
(2, 'Osinski, Mayert and Kozey', 'ENABLED'),
(3, 'Mann Group', 'DISABLED'),
(4, 'Mann-Schuppe', 'DISABLED'),
(5, 'Lang LLC', 'ENABLED'),
(6, 'Emard Group', 'ENABLED'),
(7, 'Gutmann, Turcotte and Effertz', 'DISABLED'),
(8, 'White, Fisher and Hackett', 'ENABLED'),
(9, 'Friesen Inc', 'DISABLED'),
(10, 'Yost, Kozey and Spinka', 'DISABLED');

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `id` int(11) NOT NULL,
  `username` varchar(50) NOT NULL,
  `password_identity` varchar(50) NOT NULL,
  `authority` enum('ADMIN','STAFF') NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`id`, `username`, `password_identity`, `authority`) VALUES
(1, 'ncullum0', 'kUju64rFdp39', 'ADMIN'),
(2, 'lterron1', 'sEXMwae', 'STAFF'),
(3, 'tslader2', 'IiSUP5OjT5', 'STAFF'),
(4, 'rsantora3', 'YqtVuwo', 'STAFF'),
(5, 'vmattiussi4', '5eKapp3L', 'STAFF'),
(6, 'sdemer5', '3i58zT', 'STAFF'),
(7, 'bphilcox6', 'Wnor8XTilq2c', 'STAFF'),
(8, 'hosichev7', 'aqkrlFSKYXP', 'STAFF'),
(9, 'mnutt8', 'GE4nSrOFnpJD', 'STAFF'),
(10, 'wstockwell9', 'SWz1ogvUygH', 'STAFF');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `admin`
--
ALTER TABLE `admin`
  ADD PRIMARY KEY (`id`),
  ADD KEY `user_id_idx` (`user_id`);

--
-- Indexes for table `author`
--
ALTER TABLE `author`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `book`
--
ALTER TABLE `book`
  ADD PRIMARY KEY (`ID`),
  ADD UNIQUE KEY `isbn13_UNIQUE` (`isbn13`),
  ADD KEY `publisher_id_idx` (`publisher_id`),
  ADD KEY `language_id_idx` (`language_id`),
  ADD KEY `category_id_idx` (`category_id`),
  ADD KEY `author_id_idx` (`author_id`);

--
-- Indexes for table `book_category`
--
ALTER TABLE `book_category`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `book_language`
--
ALTER TABLE `book_language`
  ADD PRIMARY KEY (`language_id`);

--
-- Indexes for table `customer`
--
ALTER TABLE `customer`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `employee`
--
ALTER TABLE `employee`
  ADD PRIMARY KEY (`id`),
  ADD KEY `user_id_idx` (`user_id`);

--
-- Indexes for table `line_item`
--
ALTER TABLE `line_item`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `order_id_idx` (`order_id`),
  ADD KEY `fk_line-item_book_idx` (`book_id`);

--
-- Indexes for table `order`
--
ALTER TABLE `order`
  ADD PRIMARY KEY (`id`),
  ADD KEY `customer_id_idx` (`customer_id`),
  ADD KEY `fk_order_employee` (`employee_id`);

--
-- Indexes for table `promotion_books`
--
ALTER TABLE `promotion_books`
  ADD PRIMARY KEY (`book_id`,`promotion_id`),
  ADD KEY `promotion_id_idx` (`promotion_id`);

--
-- Indexes for table `promotion_campaign`
--
ALTER TABLE `promotion_campaign`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `publisher`
--
ALTER TABLE `publisher`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `admin`
--
ALTER TABLE `admin`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `author`
--
ALTER TABLE `author`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT for table `book`
--
ALTER TABLE `book`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=102;

--
-- AUTO_INCREMENT for table `book_category`
--
ALTER TABLE `book_category`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT for table `book_language`
--
ALTER TABLE `book_language`
  MODIFY `language_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `customer`
--
ALTER TABLE `customer`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT for table `employee`
--
ALTER TABLE `employee`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT for table `line_item`
--
ALTER TABLE `line_item`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT for table `order`
--
ALTER TABLE `order`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT for table `promotion_campaign`
--
ALTER TABLE `promotion_campaign`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- AUTO_INCREMENT for table `publisher`
--
ALTER TABLE `publisher`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `admin`
--
ALTER TABLE `admin`
  ADD CONSTRAINT `fk_admin_user` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`);

--
-- Constraints for table `book`
--
ALTER TABLE `book`
  ADD CONSTRAINT `fk_book_author` FOREIGN KEY (`author_id`) REFERENCES `author` (`id`),
  ADD CONSTRAINT `fk_book_category` FOREIGN KEY (`category_id`) REFERENCES `book_category` (`id`),
  ADD CONSTRAINT `fk_book_language` FOREIGN KEY (`language_id`) REFERENCES `book_language` (`language_id`),
  ADD CONSTRAINT `fk_book_publisher` FOREIGN KEY (`publisher_id`) REFERENCES `publisher` (`id`);

--
-- Constraints for table `employee`
--
ALTER TABLE `employee`
  ADD CONSTRAINT `fk_employee_user` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`);

--
-- Constraints for table `line_item`
--
ALTER TABLE `line_item`
  ADD CONSTRAINT `fk_line-item_book` FOREIGN KEY (`book_id`) REFERENCES `book` (`ID`),
  ADD CONSTRAINT `fk_line-item_order` FOREIGN KEY (`order_id`) REFERENCES `order` (`id`);

--
-- Constraints for table `order`
--
ALTER TABLE `order`
  ADD CONSTRAINT `fk_order_customer` FOREIGN KEY (`customer_id`) REFERENCES `customer` (`id`),
  ADD CONSTRAINT `fk_order_employee` FOREIGN KEY (`employee_id`) REFERENCES `employee` (`id`);

--
-- Constraints for table `promotion_books`
--
ALTER TABLE `promotion_books`
  ADD CONSTRAINT `fk_promotion-book_book` FOREIGN KEY (`book_id`) REFERENCES `book` (`ID`),
  ADD CONSTRAINT `fk_promotion-book_promotion-campaign` FOREIGN KEY (`promotion_id`) REFERENCES `promotion_campaign` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
