SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";

CREATE DATABASE `boulderdash` ;

USE `boulderdash` ;

DELIMITER $$


CREATE DEFINER=`root`@`localhost` PROCEDURE `level4ById` (IN `p_blocksId` INT)  READS SQL DATA
    SQL SECURITY INVOKER
SELECT * FROM level4 WHERE blocksId = p_blocksId$$

DELIMITER ;

CREATE TABLE `level4` (
  `blocksId` int NOT NULL AUTO_INCREMENT,
  `blocksType` varchar(255) NOT NULL,
  `blocksX` int NOT NULL,
  `blocksY` int NOT NULL,
  `blocksDirection` varchar(255) DEFAULT NULL,
  `levelNumber` int NOT NULL,
  PRIMARY KEY (`blocksId`)
) ENGINE=InnoDB;

INSERT INTO `level4` (`blocksType`, `blocksX`, `blocksY`, `blocksDirection`, `levelNumber`) VALUES
('BorderBlock', 0, 0, NULL, 4),
('BorderBlock', 0, 1, NULL, 4),
('BorderBlock', 0, 2, NULL, 4),
('BorderBlock', 0, 3, NULL, 4),
('BorderBlock', 0, 4, NULL, 4),
('BorderBlock', 0, 5, NULL, 4),
('BorderBlock', 0, 6, NULL, 4),
('BorderBlock', 0, 7, NULL, 4),
('BorderBlock', 0, 8, NULL, 4),
('BorderBlock', 0, 9, NULL, 4),
('BorderBlock', 0, 10, NULL, 4),
('BorderBlock', 0, 11, NULL, 4),
('BorderBlock', 0, 12, NULL, 4),
('BorderBlock', 0, 13, NULL, 4),
('BorderBlock', 0, 14, NULL, 4),
('BorderBlock', 0, 15, NULL, 4),
('BorderBlock', 0, 16, NULL, 4),
('BorderBlock', 0, 17, NULL, 4),
('BorderBlock', 0, 18, NULL, 4),
('BorderBlock', 0, 19, NULL, 4),



('BorderBlock', 1, 0, NULL, 4),
('DirtAfterHero', 1, 1, NULL, 4),
('DirtAfterHero', 1, 2, NULL, 4),
('DirtAfterHero', 1, 3, NULL, 4),
('DirtAfterHero', 1, 4, NULL, 4),
('DirtAfterHero', 1, 5, NULL, 4),
('DirtAfterHero', 1, 6, NULL, 4),
('DirtAfterHero', 1, 7, NULL, 4),
('DirtAfterHero', 1, 8, NULL, 4),
('DirtAfterHero', 1, 9, NULL, 4),
('DirtAfterHero', 1, 10, NULL, 4),
('DirtAfterHero', 1, 11, NULL, 4),
('DirtAfterHero', 1, 12, NULL, 4),
('DirtAfterHero', 1, 13, NULL, 4),
('DirtAfterHero', 1, 14, NULL, 4),
('DirtAfterHero', 1, 15, NULL, 4),
('DirtAfterHero', 1, 16, NULL, 4),
('Diamond', 1, 17, NULL, 4),
('DirtAfterHero', 1, 18, NULL, 4),
('BorderBlock', 1, 19, NULL, 4),



('BorderBlock', 2, 0, NULL, 4),
('DirtAfterHero', 2, 1, NULL, 4),
('DirtAfterHero', 2, 2, NULL, 4),
('DirtAfterHero', 2, 3, NULL, 4),
('DirtAfterHero', 2, 4, NULL, 4),
('DirtAfterHero', 2, 5, NULL, 4),
('DirtAfterHero', 2, 6, NULL, 4),
('DirtAfterHero', 2, 7, NULL, 4),
('DirtAfterHero', 2, 8, NULL, 4),
('DirtAfterHero', 2, 9, NULL, 4),
('DirtAfterHero', 2, 10, NULL, 4),
('DirtAfterHero', 2, 11, NULL, 4),
('DirtAfterHero', 2, 12, NULL, 4),
('DirtAfterHero', 2, 13, NULL, 4),
('DirtAfterHero', 2, 14, NULL, 4),
('DirtAfterHero', 2, 15, NULL, 4),
('Diamond', 2, 16, NULL, 4),
('Diamond', 2, 17, NULL, 4),
('Diamond', 2, 18, NULL, 4),
('BorderBlock', 2, 19, NULL, 4),



('BorderBlock', 3, 0, NULL, 4),
('DirtAfterHero', 3, 1, NULL, 4),
('DirtAfterHero', 3, 2, NULL, 4),
('DirtAfterHero', 3, 3, NULL, 4),
('DirtAfterHero', 3, 4, NULL, 4),
('DirtAfterHero', 3, 5, NULL, 4),
('DirtAfterHero', 3, 6, NULL, 4),
('DirtAfterHero', 3, 7, NULL, 4),
('DirtAfterHero', 3, 8, NULL, 4),
('DirtAfterHero', 3, 9, NULL, 4),
('DirtAfterHero', 3, 10, NULL, 4),
('DirtAfterHero', 3, 11, NULL, 4),
('DirtAfterHero', 3, 12, NULL, 4),
('DirtAfterHero', 3, 13, NULL, 4),
('DirtAfterHero', 3, 14, NULL, 4),
('DirtAfterHero', 3, 15, NULL, 4),
('DirtAfterHero', 3, 16, NULL, 4),
('Diamond', 3, 17, NULL, 4),
('DirtAfterHero', 3, 18, NULL, 4),
('BorderBlock', 3, 19, NULL, 4),



('BorderBlock', 4, 0, NULL, 4),
('DirtAfterHero', 4, 1, NULL, 4),
('DirtAfterHero', 4, 2, NULL, 4),
('DirtAfterHero', 4, 3, NULL, 4),
('DirtAfterHero', 4, 4, NULL, 4),
('DirtAfterHero', 4, 5, NULL, 4),
('DirtAfterHero', 4, 6, NULL, 4),
('DirtAfterHero', 4, 7, NULL, 4),
('DirtAfterHero', 4, 8, NULL, 4),
('DirtAfterHero', 4, 9, NULL, 4),
('DirtAfterHero', 4, 10, NULL, 4),
('DirtAfterHero', 4, 11, NULL, 4),
('DirtAfterHero', 4, 12, NULL, 4),
('DirtAfterHero', 4, 13, NULL, 4),
('DirtAfterHero', 4, 14, NULL, 4),
('DirtAfterHero', 4, 15, NULL, 4),
('DirtAfterHero', 4, 16, NULL, 4),
('DirtAfterHero', 4, 17, NULL, 4),
('DirtAfterHero', 4, 18, NULL, 4),
('BorderBlock', 4, 19, NULL, 4),



('BorderBlock', 5, 0, NULL, 4),
('DirtAfterHero', 5, 1, NULL, 4),
('DirtAfterHero', 5, 2, NULL, 4),
('DirtAfterHero', 5, 3, NULL, 4),
('DirtAfterHero', 5, 4, NULL, 4),
('DirtAfterHero', 5, 5, NULL, 4),
('DirtAfterHero', 5, 6, NULL, 4),
('DirtAfterHero', 5, 7, NULL, 4),
('DirtAfterHero', 5, 8, NULL, 4),
('DirtAfterHero', 5, 9, NULL, 4),
('DirtAfterHero', 5, 10, NULL, 4),
('DirtAfterHero', 5, 11, NULL, 4),
('DirtAfterHero', 5, 12, NULL, 4),
('DirtAfterHero', 5, 13, NULL, 4),
('DirtAfterHero', 5, 14, NULL, 4),
('DirtAfterHero', 5, 15, NULL, 4),
('DirtAfterHero', 5, 16, NULL, 4),
('DirtAfterHero', 5, 17, NULL, 4),
('DirtAfterHero', 5, 18, NULL, 4),
('BorderBlock', 5, 19, NULL, 4),



('BorderBlock', 6, 0, NULL, 4),
('DirtAfterHero', 6, 1, NULL, 4),
('DirtAfterHero', 6, 2, NULL, 4),
('DirtAfterHero', 6, 3, NULL, 4),
('DirtAfterHero', 6, 4, NULL, 4),
('DirtAfterHero', 6, 5, NULL, 4),
('DirtAfterHero', 6, 6, NULL, 4),
('DirtAfterHero', 6, 7, NULL, 4),
('DirtAfterHero', 6, 8, NULL, 4),
('DirtAfterHero', 6, 9, NULL, 4),
('DirtAfterHero', 6, 10, NULL, 4),
('DirtAfterHero', 6, 11, NULL, 4),
('DirtAfterHero', 6, 12, NULL, 4),
('DirtAfterHero', 6, 13, NULL, 4),
('DirtAfterHero', 6, 14, NULL, 4),
('DirtAfterHero', 6, 15, NULL, 4),
('DirtAfterHero', 6, 16, NULL, 4),
('DirtAfterHero', 6, 17, NULL, 4),
('DirtAfterHero', 6, 18, NULL, 4),
('BorderBlock', 6, 19, NULL, 4),



('BorderBlock', 7, 0, NULL, 4),
('DirtAfterHero', 7, 1, NULL, 4),
('DirtAfterHero', 7, 2, NULL, 4),
('DirtAfterHero', 7, 3, NULL, 4),
('DirtAfterHero', 7, 4, NULL, 4),
('DirtAfterHero', 7, 5, NULL, 4),
('DirtAfterHero', 7, 6, NULL, 4),
('Enemy', 7, 7, 'FrontEnemy', 4),
('DirtAfterHero', 7, 8, NULL, 4),
('DirtAfterHero', 7, 9, NULL, 4),
('DirtAfterHero', 7, 10, NULL, 4),
('DirtAfterHero', 7, 11, NULL, 4),
('DirtAfterHero', 7, 12, NULL, 4),
('DirtAfterHero', 7, 13, NULL, 4),
('DirtAfterHero', 7, 14, NULL, 4),
('DirtAfterHero', 7, 15, NULL, 4),
('DirtAfterHero', 7, 16, NULL, 4),
('Enemy', 7, 17, 'FrontEnemy', 4),
('DirtAfterHero', 7, 18, NULL, 4),
('BorderBlock', 7, 19, NULL, 4),



('BorderBlock', 8, 0, NULL, 4),
('DirtAfterHero', 8, 1, NULL, 4),
('DirtAfterHero', 8, 2, NULL, 4),
('DirtAfterHero', 8, 3, NULL, 4),
('DirtAfterHero', 8, 4, NULL, 4),
('DirtAfterHero', 8, 5, NULL, 4),
('DirtAfterHero', 8, 6, NULL, 4),
('DirtAfterHero', 8, 7, NULL, 4),
('DirtAfterHero', 8, 8, NULL, 4),
('DirtAfterHero', 8, 9, NULL, 4),
('DirtAfterHero', 8, 10, NULL, 4),
('DirtAfterHero', 8, 11, NULL, 4),
('DirtAfterHero', 8, 12, NULL, 4),
('DirtAfterHero', 8, 13, NULL, 4),
('DirtAfterHero', 8, 14, NULL, 4),
('DirtAfterHero', 8, 15, NULL, 4),
('DirtAfterHero', 8, 16, NULL, 4),
('DirtAfterHero', 8, 17, NULL, 4),
('DirtAfterHero', 8, 18, NULL, 4),
('BorderBlock', 8, 19, NULL, 4),



('BorderBlock', 9, 0, NULL, 4),
('DirtAfterHero', 9, 1, NULL, 4),
('DirtAfterHero', 9, 2, NULL, 4),
('DirtAfterHero', 9, 3, NULL, 4),
('DirtAfterHero', 9, 4, NULL, 4),
('DirtAfterHero', 9, 5, NULL, 4),
('DirtAfterHero', 9, 6, NULL, 4),
('DirtAfterHero', 9, 7, NULL, 4),
('DirtAfterHero', 9, 8, NULL, 4),
('DirtAfterHero', 9, 9, NULL, 4),
('DirtAfterHero', 9, 10, NULL, 4),
('DirtAfterHero', 9, 11, NULL, 4),
('DirtAfterHero', 9, 12, NULL, 4),
('DirtAfterHero', 9, 13, NULL, 4),
('DirtAfterHero', 9, 14, NULL, 4),
('DirtAfterHero', 9, 15, NULL, 4),
('DirtAfterHero', 9, 16, NULL, 4),
('DirtAfterHero', 9, 17, NULL, 4),
('DirtAfterHero', 9, 18, NULL, 4),
('BorderBlock', 9, 19, NULL, 4),



('BorderBlock', 10, 0, NULL, 4),
('DirtAfterHero', 10, 1, NULL, 4),
('DirtAfterHero', 10, 2, NULL, 4),
('DirtAfterHero', 10, 3, NULL, 4),
('DirtAfterHero', 10, 4, NULL, 4),
('DirtAfterHero', 10, 5, NULL, 4),
('DirtAfterHero', 10, 6, NULL, 4),
('DirtAfterHero', 10, 7, NULL, 4),
('DirtAfterHero', 10, 8, NULL, 4),
('DirtAfterHero', 10, 9, NULL, 4),
('DirtAfterHero', 10, 10, NULL, 4),
('DirtAfterHero', 10, 11, NULL, 4),
('DirtAfterHero', 10, 12, NULL, 4),
('DirtAfterHero', 10, 13, NULL, 4),
('DirtAfterHero', 10, 14, NULL, 4),
('DirtAfterHero', 10, 15, NULL, 4),
('DirtAfterHero', 10, 16, NULL, 4),
('DirtAfterHero', 10, 17, NULL, 4),
('DirtAfterHero', 10, 18, NULL, 4),
('BorderBlock', 10, 19, NULL, 4),



('BorderBlock', 11, 0, NULL, 4),
('DirtAfterHero', 11, 1, NULL, 4),
('DirtAfterHero', 11, 2, NULL, 4),
('DirtAfterHero', 11, 3, NULL, 4),
('DirtAfterHero', 11, 4, NULL, 4),
('DirtAfterHero', 11, 5, NULL, 4),
('DirtAfterHero', 11, 6, NULL, 4),
('DirtAfterHero', 11, 7, NULL, 4),
('DirtAfterHero', 11, 8, NULL, 4),
('DirtAfterHero', 11, 9, NULL, 4),
('DirtAfterHero', 11, 10, NULL, 4),
('DirtAfterHero', 11, 11, NULL, 4),
('DirtAfterHero', 11, 12, NULL, 4),
('DirtAfterHero', 11, 13, NULL, 4),
('DirtAfterHero', 11, 14, NULL, 4),
('DirtAfterHero', 11, 15, NULL, 4),
('DirtAfterHero', 11, 16, NULL, 4),
('DirtAfterHero', 11, 17, NULL, 4),
('DirtAfterHero', 11, 18, NULL, 4),
('BorderBlock', 11, 19, NULL, 4),



('BorderBlock', 12, 0, NULL, 4),
('DirtAfterHero', 12, 1, NULL, 4),
('DirtAfterHero', 12, 2, NULL, 4),
('DirtAfterHero', 12, 3, NULL, 4),
('DirtAfterHero', 12, 4, NULL, 4),
('DirtAfterHero', 12, 5, NULL, 4),
('DirtAfterHero', 12, 6, NULL, 4),
('DirtAfterHero', 12, 7, NULL, 4),
('DirtAfterHero', 12, 8, NULL, 4),
('DirtAfterHero', 12, 9, NULL, 4),
('Enemy', 12, 10, 'FrontEnemy', 4),
('DirtAfterHero', 12, 11, NULL, 4),
('DirtAfterHero', 12, 12, NULL, 4),
('DirtAfterHero', 12, 13, NULL, 4),
('DirtAfterHero', 12, 14, NULL, 4),
('DirtAfterHero', 12, 15, NULL, 4),
('DirtAfterHero', 12, 16, NULL, 4),
('DirtAfterHero', 12, 17, NULL, 4),
('DirtAfterHero', 12, 18, NULL, 4),
('BorderBlock', 12, 19, NULL, 4),



('BorderBlock', 13, 0, NULL, 4),
('DirtAfterHero', 13, 1, NULL, 4),
('DirtAfterHero', 13, 2, NULL, 4),
('Diamond', 13, 3, NULL, 4),
('DirtAfterHero', 13, 4, NULL, 4),
('DirtAfterHero', 13, 5, NULL, 4),
('DirtAfterHero', 13, 6, NULL, 4),
('DirtAfterHero', 13, 7, NULL, 4),
('DirtAfterHero', 13, 8, NULL, 4),
('DirtAfterHero', 13, 9, NULL, 4),
('DirtAfterHero', 13, 10, NULL, 4),
('DirtAfterHero', 13, 11, NULL, 4),
('DirtAfterHero', 13, 12, NULL, 4),
('DirtAfterHero', 13, 13, NULL, 4),
('DirtAfterHero', 13, 14, NULL, 4),
('DirtAfterHero', 13, 15, NULL, 4),
('DirtAfterHero', 13, 16, NULL, 4),
('DirtAfterHero', 13, 17, NULL, 4),
('DirtAfterHero', 13, 18, NULL, 4),
('BorderBlock', 13, 19, NULL, 4),



('BorderBlock', 14, 0, NULL, 4),
('DirtAfterHero', 14, 1, NULL, 4),
('Diamond', 14, 2, NULL, 4),
('Diamond', 14, 3, NULL, 4),
('Diamond', 14, 4, NULL, 4),
('DirtAfterHero', 14, 5, NULL, 4),
('DirtAfterHero', 14, 6, NULL, 4),
('DirtAfterHero', 14, 7, NULL, 4),
('DirtAfterHero', 14, 8, NULL, 4),
('DirtAfterHero', 14, 9, NULL, 4),
('DirtAfterHero', 14, 10, NULL, 4),
('DirtAfterHero', 14, 11, NULL, 4),
('DirtAfterHero', 14, 12, NULL, 4),
('DirtAfterHero', 14, 13, NULL, 4),
('DirtAfterHero', 14, 14, NULL, 4),
('DirtAfterHero', 14, 15, NULL, 4),
('DirtAfterHero', 14, 16, NULL, 4),
('DirtAfterHero', 14, 17, NULL, 4),
('DirtAfterHero', 14, 18, NULL, 4),
('BorderBlock', 14, 19, NULL, 4),



('BorderBlock', 15, 0, NULL, 4),
('DirtAfterHero', 15, 1, NULL, 4),
('DirtAfterHero', 15, 2, NULL, 4),
('Diamond', 15, 3, NULL, 4),
('DirtAfterHero', 15, 4, NULL, 4),
('DirtAfterHero', 15, 5, NULL, 4),
('DirtAfterHero', 15, 6, NULL, 4),
('DirtAfterHero', 15, 7, NULL, 4),
('DirtAfterHero', 15, 8, NULL, 4),
('Enemy', 15, 9, 'FrontEnemy', 4),
('DirtAfterHero', 15, 10, NULL, 4),
('DirtAfterHero', 15, 11, NULL, 4),
('DirtAfterHero', 15, 12, NULL, 4),
('DirtAfterHero', 15, 13, NULL, 4),
('DirtAfterHero', 15, 14, NULL, 4),
('DirtAfterHero', 15, 15, NULL, 4),
('DirtAfterHero', 15, 16, NULL, 4),
('ExitDoor', 15, 17, NULL, 4),
('DirtAfterHero', 15, 18, NULL, 4),
('BorderBlock', 15, 19, NULL, 4),



('BorderBlock', 16, 0, NULL, 4),
('DirtAfterHero', 16, 1, NULL, 4),
('DirtAfterHero', 16, 2, NULL, 4),
('DirtAfterHero', 16, 3, NULL, 4),
('DirtAfterHero', 16, 4, NULL, 4),
('DirtAfterHero', 16, 5, NULL, 4),
('DirtAfterHero', 16, 6, NULL, 4),
('DirtAfterHero', 16, 7, NULL, 4),
('DirtAfterHero', 16, 8, NULL, 4),
('DirtAfterHero', 16, 9, NULL, 4),
('DirtAfterHero', 16, 10, NULL, 4),
('DirtAfterHero', 16, 11, NULL, 4),
('DirtAfterHero', 16, 12, NULL, 4),
('DirtAfterHero', 16, 13, NULL, 4),
('DirtAfterHero', 16, 14, NULL, 4),
('DirtAfterHero', 16, 15, NULL, 4),
('DirtAfterHero', 16, 16, NULL, 4),
('DirtAfterHero', 16, 17, NULL, 4),
('DirtAfterHero', 16, 18, NULL, 4),
('BorderBlock', 16, 19, NULL, 4),



('BorderBlock', 17, 0, NULL, 4),
('DirtAfterHero', 17, 1, NULL, 4),
('DirtAfterHero', 17, 2, NULL, 4),
('DirtAfterHero', 17, 3, NULL, 4),
('DirtAfterHero', 17, 4, NULL, 4),
('DirtAfterHero', 17, 5, NULL, 4),
('DirtAfterHero', 17, 6, NULL, 4),
('DirtAfterHero', 17, 7, NULL, 4),
('DirtAfterHero', 17, 8, NULL, 4),
('DirtAfterHero', 17, 9, NULL, 4),
('DirtAfterHero', 17, 10, NULL, 4),
('DirtAfterHero', 17, 11, NULL, 4),
('DirtAfterHero', 17, 12, NULL, 4),
('DirtAfterHero', 17, 13, NULL, 4),
('DirtAfterHero', 17, 14, NULL, 4),
('DirtAfterHero', 17, 15, NULL, 4),
('DirtAfterHero', 17, 16, NULL, 4),
('DirtAfterHero', 17, 17, NULL, 4),
('DirtAfterHero', 17, 18, NULL, 4),
('BorderBlock', 17, 19, NULL, 4),



('BorderBlock', 18, 0, NULL, 4),
('DirtAfterHero', 18, 1, NULL, 4),
('DirtAfterHero', 18, 2, NULL, 4),
('DirtAfterHero', 18, 3, NULL, 4),
('DirtAfterHero', 18, 4, NULL, 4),
('DirtAfterHero', 18, 5, NULL, 4),
('DirtAfterHero', 18, 6, NULL, 4),
('DirtAfterHero', 18, 7, NULL, 4),
('DirtAfterHero', 18, 8, NULL, 4),
('DirtAfterHero', 18, 9, NULL, 4),
('DirtAfterHero', 18, 10, NULL, 4),
('DirtAfterHero', 18, 11, NULL, 4),
('DirtAfterHero', 18, 12, NULL, 4),
('DirtAfterHero', 18, 13, NULL, 4),
('DirtAfterHero', 18, 14, NULL, 4),
('DirtAfterHero', 18, 15, NULL, 4),
('DirtAfterHero', 18, 16, NULL, 4),
('DirtAfterHero', 18, 17, NULL, 4),
('DirtAfterHero', 18, 18, NULL, 4),
('BorderBlock', 18, 19, NULL, 4),



('BorderBlock', 19, 0, NULL, 4),
('BorderBlock', 19, 1, NULL, 4),
('BorderBlock', 19, 2, NULL, 4),
('BorderBlock', 19, 3, NULL, 4),
('BorderBlock', 19, 4, NULL, 4),
('BorderBlock', 19, 5, NULL, 4),
('BorderBlock', 19, 6, NULL, 4),
('BorderBlock', 19, 7, NULL, 4),
('BorderBlock', 19, 8, NULL, 4),
('BorderBlock', 19, 9, NULL, 4),
('BorderBlock', 19, 10, NULL, 4),
('BorderBlock', 19, 11, NULL, 4),
('BorderBlock', 19, 12, NULL, 4),
('BorderBlock', 19, 13, NULL, 4),
('BorderBlock', 19, 14, NULL, 4),
('BorderBlock', 19, 15, NULL, 4),
('BorderBlock', 19, 16, NULL, 4),
('BorderBlock', 19, 17, NULL, 4),
('BorderBlock', 19, 18, NULL, 4),
('BorderBlock', 19, 19, NULL, 4);