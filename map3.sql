SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";

USE `boulderdash` ;

DELIMITER $$


CREATE DEFINER=`root`@`localhost` PROCEDURE `level3ById` (IN `p_blocksId` INT)  READS SQL DATA
    SQL SECURITY INVOKER
SELECT * FROM level3 WHERE blocksId = p_blocksId$$

DELIMITER ;

CREATE TABLE `level3` (
  `blocksId` int NOT NULL AUTO_INCREMENT,
  `blocksType` varchar(255) NOT NULL,
  `blocksX` int NOT NULL,
  `blocksY` int NOT NULL,
  `blocksDirection` varchar(255) DEFAULT NULL,
  `levelNumber` int NOT NULL,
  PRIMARY KEY (`blocksId`)
) ENGINE=InnoDB;

INSERT INTO `level3` (`blocksType`, `blocksX`, `blocksY`, `blocksDirection`, `levelNumber`) VALUES
('BorderBlock', 0, 0, NULL, 3),
('BorderBlock', 0, 1, NULL, 3),
('BorderBlock', 0, 2, NULL, 3),
('BorderBlock', 0, 3, NULL, 3),
('BorderBlock', 0, 4, NULL, 3),
('BorderBlock', 0, 5, NULL, 3),
('BorderBlock', 0, 6, NULL, 3),
('BorderBlock', 0, 7, NULL, 3),
('BorderBlock', 0, 8, NULL, 3),
('BorderBlock', 0, 9, NULL, 3),
('BorderBlock', 0, 10, NULL, 3),
('BorderBlock', 0, 11, NULL, 3),
('BorderBlock', 0, 12, NULL, 3),
('BorderBlock', 0, 13, NULL, 3),
('BorderBlock', 0, 14, NULL, 3),
('BorderBlock', 0, 15, NULL, 3),
('BorderBlock', 0, 16, NULL, 3),
('BorderBlock', 0, 17, NULL, 3),
('BorderBlock', 0, 18, NULL, 3),
('BorderBlock', 0, 19, NULL, 3),



('BorderBlock', 1, 0, NULL, 3),
('Dirt', 1, 1, NULL, 3),
('Dirt', 1, 2, NULL, 3),
('Dirt', 1, 3, NULL, 3),
('Dirt', 1, 4, NULL, 3),
('Dirt', 1, 5, NULL, 3),
('Dirt', 1, 6, NULL, 3),
('Dirt', 1, 7, NULL, 3),
('Dirt', 1, 8, NULL, 3),
('Dirt', 1, 9, NULL, 3),
('Dirt', 1, 10, NULL, 3),
('Dirt', 1, 11, NULL, 3),
('Dirt', 1, 12, NULL, 3),
('Dirt', 1, 13, NULL, 3),
('Dirt', 1, 14, NULL, 3),
('Dirt', 1, 15, NULL, 3),
('Dirt', 1, 16, NULL, 3),
('Dirt', 1, 17, NULL, 3),
('Dirt', 1, 18, NULL, 3),
('BorderBlock', 1, 19, NULL, 3),



('BorderBlock', 2, 0, NULL, 3),
('Dirt', 2, 1, NULL, 3),
('Dirt', 2, 2, NULL, 3),
('Dirt', 2, 3, NULL, 3),
('Dirt', 2, 4, NULL, 3),
('Dirt', 2, 5, NULL, 3),
('Dirt', 2, 6, NULL, 3),
('Dirt', 2, 7, NULL, 3),
('Dirt', 2, 8, NULL, 3),
('Dirt', 2, 9, NULL, 3),
('Dirt', 2, 10, NULL, 3),
('Dirt', 2, 11, NULL, 3),
('Dirt', 2, 12, NULL, 3),
('Dirt', 2, 13, NULL, 3),
('Dirt', 2, 14, NULL, 3),
('Boulder', 2, 15, NULL, 3),
('Dirt', 2, 16, NULL, 3),
('Dirt', 2, 17, NULL, 3),
('Dirt', 2, 18, NULL, 3),
('BorderBlock', 2, 19, NULL, 3),



('BorderBlock', 3, 0, NULL, 3),
('Dirt', 3, 1, NULL, 3),
('Dirt', 3, 2, NULL, 3),
('Dirt', 3, 3, NULL, 3),
('Dirt', 3, 4, NULL, 3),
('Dirt', 3, 5, NULL, 3),
('Dirt', 3, 6, NULL, 3),
('Dirt', 3, 7, NULL, 3),
('Dirt', 3, 8, NULL, 3),
('Dirt', 3, 9, NULL, 3),
('Dirt', 3, 10, NULL, 3),
('Dirt', 3, 11, NULL, 3),
('Dirt', 3, 12, NULL, 3),
('Dirt', 3, 13, NULL, 3),
('Dirt', 3, 14, NULL, 3),
('Dirt', 3, 15, NULL, 3),
('Dirt', 3, 16, NULL, 3),
('Dirt', 3, 17, NULL, 3),
('Dirt', 3, 18, NULL, 3),
('BorderBlock', 3, 19, NULL, 3),



('BorderBlock', 4, 0, NULL, 3),
('Dirt', 4, 1, NULL, 3),
('Dirt', 4, 2, NULL, 3),
('Dirt', 4, 3, NULL, 3),
('BorderBlock', 4, 4, NULL, 3),
('BorderBlock', 4, 5, NULL, 3),
('Dirt', 4, 6, NULL, 3),
('Dirt', 4, 7, NULL, 3),
('Dirt', 4, 8, NULL, 3),
('Dirt', 4, 9, NULL, 3),
('Dirt', 4, 10, NULL, 3),
('Dirt', 4, 11, NULL, 3),
('Dirt', 4, 12, NULL, 3),
('Dirt', 4, 13, NULL, 3),
('BorderBlock', 4, 14, NULL, 3),
('BorderBlock', 4, 15, NULL, 3),
('Dirt', 4, 16, NULL, 3),
('Dirt', 4, 17, NULL, 3),
('Dirt', 4, 18, NULL, 3),
('BorderBlock', 4, 19, NULL, 3),



('BorderBlock', 5, 0, NULL, 3),
('Dirt', 5, 1, NULL, 3),
('Dirt', 5, 2, NULL, 3),
('Dirt', 5, 3, NULL, 3),
('BorderBlock', 5, 4, NULL, 3),
('BorderBlock', 5, 5, NULL, 3),
('Dirt', 5, 6, NULL, 3),
('Dirt', 5, 7, NULL, 3),
('Dirt', 5, 8, NULL, 3),
('BorderBlock', 5, 9, NULL, 3),
('Boulder', 5, 10, NULL, 3),
('Boulder', 5, 11, NULL, 3),
('Dirt', 5, 12, NULL, 3),
('Dirt', 5, 13, NULL, 3),
('BorderBlock', 5, 14, NULL, 3),
('BorderBlock', 5, 15, NULL, 3),
('Dirt', 5, 16, NULL, 3),
('Dirt', 5, 17, NULL, 3),
('Dirt', 5, 18, NULL, 3),
('BorderBlock', 5, 19, NULL, 3),



('BorderBlock', 6, 0, NULL, 3),
('Dirt', 6, 1, NULL, 3),
('Dirt', 6, 2, NULL, 3),
('Dirt', 6, 3, NULL, 3),
('Dirt', 6, 4, NULL, 3),
('Dirt', 6, 5, NULL, 3),
('Dirt', 6, 6, NULL, 3),
('Dirt', 6, 7, NULL, 3),
('Dirt', 6, 8, NULL, 3),
('BorderBlock', 6, 9, NULL, 3),
('Dirt', 6, 10, NULL, 3),
('Dirt', 6, 11, NULL, 3),
('Dirt', 6, 12, NULL, 3),
('DirtAfterHero', 6, 13, NULL, 3),
('DirtAfterHero', 6, 14, NULL, 3),
('DirtAfterHero', 6, 15, NULL, 3),
('Dirt', 6, 16, NULL, 3),
('Dirt', 6, 17, NULL, 3),
('Dirt', 6, 18, NULL, 3),
('BorderBlock', 6, 19, NULL, 3),



('BorderBlock', 7, 0, NULL, 3),
('Dirt', 7, 1, NULL, 3),
('Dirt', 7, 2, NULL, 3),
('Boulder', 7, 3, NULL, 3),
('Dirt', 7, 4, NULL, 3),
('Dirt', 7, 5, NULL, 3),
('Dirt', 7, 6, NULL, 3),
('Dirt', 7, 7, NULL, 3),
('Dirt', 7, 8, NULL, 3),
('BorderBlock', 7, 9, NULL, 3),
('Diamond', 7, 10, NULL, 3),
('Diamond', 7, 11, NULL, 3),
('Diamond', 7, 12, NULL, 3),
('DirtAfterHero', 7, 13, NULL, 3),
('Enemy', 7, 14, 'FrontEnemy', 3),
('DirtAfterHero', 7, 15, NULL, 3),
('Dirt', 7, 16, NULL, 3),
('Dirt', 7, 17, NULL, 3),
('Dirt', 7, 18, NULL, 3),
('BorderBlock', 7, 19, NULL, 3),



('BorderBlock', 8, 0, NULL, 3),
('Dirt', 8, 1, NULL, 3),
('Dirt', 8, 2, NULL, 3),
('DirtAfterHero', 8, 3, NULL, 3),
('Dirt', 8, 4, NULL, 3),
('Dirt', 8, 5, NULL, 3),
('Dirt', 8, 6, NULL, 3),
('Dirt', 8, 7, NULL, 3),
('Dirt', 8, 8, NULL, 3),
('BorderBlock', 8, 9, NULL, 3),
('Dirt', 8, 10, NULL, 3),
('Dirt', 8, 11, NULL, 3),
('Dirt', 8, 12, NULL, 3),
('DirtAfterHero', 8, 13, NULL, 3),
('DirtAfterHero', 8, 14, NULL, 3),
('Dirt', 8, 15, NULL, 3),
('Dirt', 8, 16, NULL, 3),
('Dirt', 8, 17, NULL, 3),
('Dirt', 8, 18, NULL, 3),
('BorderBlock', 8, 19, NULL, 3),



('BorderBlock', 9, 0, NULL, 3),
('Dirt', 9, 1, NULL, 3),
('Dirt', 9, 2, NULL, 3),
('Dirt', 9, 3, NULL, 3),
('Dirt', 9, 4, NULL, 3),
('BorderBlock', 9, 5, NULL, 3),
('BorderBlock', 9, 6, NULL, 3),
('BorderBlock', 9, 7, NULL, 3),
('BorderBlock', 9, 8, NULL, 3),
('BorderBlock', 9, 9, NULL, 3),
('BorderBlock', 9, 10, NULL, 3),
('BorderBlock', 9, 11, NULL, 3),
('BorderBlock', 9, 12, NULL, 3),
('BorderBlock', 9, 13, NULL, 3),
('BorderBlock', 9, 14, NULL, 3),
('Dirt', 9, 15, NULL, 3),
('Dirt', 9, 16, NULL, 3),
('Dirt', 9, 17, NULL, 3),
('Dirt', 9, 18, NULL, 3),
('BorderBlock', 9, 19, NULL, 3),



('BorderBlock', 10, 0, NULL, 3),
('Dirt', 10, 1, NULL, 3),
('Dirt', 10, 2, NULL, 3),
('Dirt', 10, 3, NULL, 3),
('Dirt', 10, 4, NULL, 3),
('BorderBlock', 10, 5, NULL, 3),
('BorderBlock', 10, 6, NULL, 3),
('BorderBlock', 10, 7, NULL, 3),
('BorderBlock', 10, 8, NULL, 3),
('BorderBlock', 10, 9, NULL, 3),
('BorderBlock', 10, 10, NULL, 3),
('BorderBlock', 10, 11, NULL, 3),
('BorderBlock', 10, 12, NULL, 3),
('BorderBlock', 10, 13, NULL, 3),
('BorderBlock', 10, 14, NULL, 3),
('Dirt', 10, 15, NULL, 3),
('Dirt', 10, 16, NULL, 3),
('ExitDoor', 10, 17, NULL, 3),
('Dirt', 10, 18, NULL, 3),
('BorderBlock', 10, 19, NULL, 3),



('BorderBlock', 11, 0, NULL, 3),
('Dirt', 11, 1, NULL, 3),
('Dirt', 11, 2, NULL, 3),
('Dirt', 11, 3, NULL, 3),
('Dirt', 11, 4, NULL, 3),
('Dirt', 11, 5, NULL, 3),
('Dirt', 11, 6, NULL, 3),
('Dirt', 11, 7, NULL, 3),
('Dirt', 11, 8, NULL, 3),
('BorderBlock', 11, 9, NULL, 3),
('Dirt', 11, 10, NULL, 3),
('Dirt', 11, 11, NULL, 3),
('Dirt', 11, 12, NULL, 3),
('Dirt', 11, 13, NULL, 3),
('Dirt', 11, 14, NULL, 3),
('Dirt', 11, 15, NULL, 3),
('Boulder', 11, 16, NULL, 3),
('Dirt', 11, 17, NULL, 3),
('Dirt', 11, 18, NULL, 3),
('BorderBlock', 11, 19, NULL, 3),



('BorderBlock', 12, 0, NULL, 3),
('Dirt', 12, 1, NULL, 3),
('Dirt', 12, 2, NULL, 3),
('Dirt', 12, 3, NULL, 3),
('Dirt', 12, 4, NULL, 3),
('Dirt', 12, 5, NULL, 3),
('Dirt', 12, 6, NULL, 3),
('DirtAfterHero', 12, 7, NULL, 3),
('DirtAfterHero', 12, 8, NULL, 3),
('BorderBlock', 12, 9, NULL, 3),
('Dirt', 12, 10, NULL, 3),
('Dirt', 12, 11, NULL, 3),
('Dirt', 12, 12, NULL, 3),
('Dirt', 12, 13, NULL, 3),
('Dirt', 12, 14, NULL, 3),
('Dirt', 12, 15, NULL, 3),
('Dirt', 12, 16, NULL, 3),
('Dirt', 12, 17, NULL, 3),
('Dirt', 12, 18, NULL, 3),
('BorderBlock', 12, 19, NULL, 3),



('BorderBlock', 13, 0, NULL, 3),
('Dirt', 13, 1, NULL, 3),
('Boulder', 13, 2, NULL, 3),
('Dirt', 13, 3, NULL, 3),
('Dirt', 13, 4, NULL, 3),
('Dirt', 13, 5, NULL, 3),
('Dirt', 13, 6, NULL, 3),
('Dirt', 13, 7, NULL, 3),
('Dirt', 13, 8, NULL, 3),
('BorderBlock', 13, 9, NULL, 3),
('Dirt', 13, 10, NULL, 3),
('Dirt', 13, 11, NULL, 3),
('Boulder', 13, 12, NULL, 3),
('Dirt', 13, 13, NULL, 3),
('Dirt', 13, 14, NULL, 3),
('Dirt', 13, 15, NULL, 3),
('Dirt', 13, 16, NULL, 3),
('Dirt', 13, 17, NULL, 3),
('Dirt', 13, 18, NULL, 3),
('BorderBlock', 13, 19, NULL, 3),



('BorderBlock', 14, 0, NULL, 3),
('Diamond', 14, 1, NULL, 3),
('Dirt', 14, 2, NULL, 3),
('Dirt', 14, 3, NULL, 3),
('BorderBlock', 14, 4, NULL, 3),
('BorderBlock', 14, 5, NULL, 3),
('Dirt', 14, 6, NULL, 3),
('Dirt', 14, 7, NULL, 3),
('Dirt', 14, 8, NULL, 3),
('BorderBlock', 14, 9, NULL, 3),
('Dirt', 14, 10, NULL, 3),
('Dirt', 14, 11, NULL, 3),
('Dirt', 14, 12, NULL, 3),
('Dirt', 14, 13, NULL, 3),
('BorderBlock', 14, 14, NULL, 3),
('BorderBlock', 14, 15, NULL, 3),
('Dirt', 14, 16, NULL, 3),
('Dirt', 14, 17, NULL, 3),
('Dirt', 14, 18, NULL, 3),
('BorderBlock', 14, 19, NULL, 3),



('BorderBlock', 15, 0, NULL, 3),
('Diamond', 15, 1, NULL, 3),
('Diamond', 15, 2, NULL, 3),
('Dirt', 15, 3, NULL, 3),
('BorderBlock', 15, 4, NULL, 3),
('BorderBlock', 15, 5, NULL, 3),
('Dirt', 15, 6, NULL, 3),
('Dirt', 15, 7, NULL, 3),
('Dirt', 15, 8, NULL, 3),
('Dirt', 15, 9, NULL, 3),
('Dirt', 15, 10, NULL, 3),
('Dirt', 15, 11, NULL, 3),
('Dirt', 15, 12, NULL, 3),
('Dirt', 15, 13, NULL, 3),
('BorderBlock', 15, 14, NULL, 3),
('BorderBlock', 15, 15, NULL, 3),
('Dirt', 15, 16, NULL, 3),
('Dirt', 15, 17, NULL, 3),
('Dirt', 15, 18, NULL, 3),
('BorderBlock', 15, 19, NULL, 3),



('BorderBlock', 16, 0, NULL, 3),
('Diamond', 16, 1, NULL, 3),
('Dirt', 16, 2, NULL, 3),
('Dirt', 16, 3, NULL, 3),
('Dirt', 16, 4, NULL, 3),
('Dirt', 16, 5, NULL, 3),
('Dirt', 16, 6, NULL, 3),
('Dirt', 16, 7, NULL, 3),
('Dirt', 16, 8, NULL, 3),
('Dirt', 16, 9, NULL, 3),
('Dirt', 16, 10, NULL, 3),
('Dirt', 16, 11, NULL, 3),
('Dirt', 16, 12, NULL, 3),
('Dirt', 16, 13, NULL, 3),
('Dirt', 16, 14, NULL, 3),
('Dirt', 16, 15, NULL, 3),
('Dirt', 16, 16, NULL, 3),
('Dirt', 16, 17, NULL, 3),
('Dirt', 16, 18, NULL, 3),
('BorderBlock', 16, 19, NULL, 3),



('BorderBlock', 17, 0, NULL, 3),
('Dirt', 17, 1, NULL, 3),
('Dirt', 17, 2, NULL, 3),
('Dirt', 17, 3, NULL, 3),
('Dirt', 17, 4, NULL, 3),
('Dirt', 17, 5, NULL, 3),
('Dirt', 17, 6, NULL, 3),
('Dirt', 17, 7, NULL, 3),
('Dirt', 17, 8, NULL, 3),
('Dirt', 17, 9, NULL, 3),
('Dirt', 17, 10, NULL, 3),
('Dirt', 17, 11, NULL, 3),
('Boulder', 17, 12, NULL, 3),
('Dirt', 17, 13, NULL, 3),
('Diamond', 17, 14, NULL, 3),
('Diamond', 17, 15, NULL, 3),
('Dirt', 17, 16, NULL, 3),
('Dirt', 17, 17, NULL, 3),
('Dirt', 17, 18, NULL, 3),
('BorderBlock', 17, 19, NULL, 3),



('BorderBlock', 18, 0, NULL, 3),
('Dirt', 18, 1, NULL, 3),
('Dirt', 18, 2, NULL, 3),
('Dirt', 18, 3, NULL, 3),
('Dirt', 18, 4, NULL, 3),
('Dirt', 18, 5, NULL, 3),
('Dirt', 18, 6, NULL, 3),
('Dirt', 18, 7, NULL, 3),
('Dirt', 18, 8, NULL, 3),
('Dirt', 18, 9, NULL, 3),
('Dirt', 18, 10, NULL, 3),
('Dirt', 18, 11, NULL, 3),
('Dirt', 18, 12, NULL, 3),
('Dirt', 18, 13, NULL, 3),
('Dirt', 18, 14, NULL, 3),
('Dirt', 18, 15, NULL, 3),
('Diamond', 18, 16, NULL, 3),
('Dirt', 18, 17, NULL, 3),
('Dirt', 18, 18, NULL, 3),
('BorderBlock', 18, 19, NULL, 3),



('BorderBlock', 19, 0, NULL, 3),
('BorderBlock', 19, 1, NULL, 3),
('BorderBlock', 19, 2, NULL, 3),
('BorderBlock', 19, 3, NULL, 3),
('BorderBlock', 19, 4, NULL, 3),
('BorderBlock', 19, 5, NULL, 3),
('BorderBlock', 19, 6, NULL, 3),
('BorderBlock', 19, 7, NULL, 3),
('BorderBlock', 19, 8, NULL, 3),
('BorderBlock', 19, 9, NULL, 3),
('BorderBlock', 19, 10, NULL, 3),
('BorderBlock', 19, 11, NULL, 3),
('BorderBlock', 19, 12, NULL, 3),
('BorderBlock', 19, 13, NULL, 3),
('BorderBlock', 19, 14, NULL, 3),
('BorderBlock', 19, 15, NULL, 3),
('BorderBlock', 19, 16, NULL, 3),
('BorderBlock', 19, 17, NULL, 3),
('BorderBlock', 19, 18, NULL, 3),
('BorderBlock', 19, 19, NULL, 3);