/*
Navicat MySQL Data Transfer

Source Server         : 127.0.0.1
Source Server Version : 50716
Source Host           : localhost:3306
Source Database       : test

Target Server Type    : MYSQL
Target Server Version : 50716
File Encoding         : 65001

Date: 2017-05-04 11:22:14
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for cat
-- ----------------------------
DROP TABLE IF EXISTS `cat`;
CREATE TABLE `cat` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `age` int(11) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of cat
-- ----------------------------

-- ----------------------------
-- Table structure for wechat_access_token
-- ----------------------------
DROP TABLE IF EXISTS `wechat_access_token`;
CREATE TABLE `wechat_access_token` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `access_token` varchar(512) DEFAULT NULL,
  `expires_in` int(4) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of wechat_access_token
-- ----------------------------
INSERT INTO `wechat_access_token` VALUES ('1', 'wFwE-WzyuuPFdAB0ilENOydKNoXGiSs-9BEDOiqhjhy7Gbjy7Ccd_Uq9P42-7UouSojqzfA_WvlnYvfZIdT-TvUc_JH2yoqghgq2OBdkN2pSM8SH2lpB80ZIy1saFUcnHDBcAHANJH', '7200', '2017-05-02 13:56:10');

-- ----------------------------
-- Procedure structure for splitString
-- ----------------------------
DROP PROCEDURE IF EXISTS `splitString`;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `splitString`(IN f_string varchar(1000),IN f_delimiter varchar(5))
BEGIN 

# 拆分结果 

declare cnt int default 0; 

declare i int default 0; 

set cnt = func_split_TotalLength(f_string,f_delimiter); 

DROP TABLE IF EXISTS `tmp_split`; 

create temporary table `tmp_split` (`status` varchar(128) not null) DEFAULT CHARSET=utf8; 

while i < cnt 

do 

    set i = i + 1; 

    insert into tmp_split(`status`) values (func_split(f_string,f_delimiter,i)); 

end while; 

END
;;
DELIMITER ;

-- ----------------------------
-- Function structure for func_split
-- ----------------------------
DROP FUNCTION IF EXISTS `func_split`;
DELIMITER ;;
CREATE DEFINER=`root`@`%` FUNCTION `func_split`(f_string varchar(1000),f_delimiter varchar(5),f_order int) RETURNS varchar(255) CHARSET utf8
BEGIN 

    # 拆分传入的字符串，返回拆分后的新字符串 

        declare result varchar(255) default ''; 

        set result = reverse(substring_index(reverse(substring_index(f_string,f_delimiter,f_order)),f_delimiter,1)); 

        return result; 

END
;;
DELIMITER ;

-- ----------------------------
-- Function structure for func_split_TotalLength
-- ----------------------------
DROP FUNCTION IF EXISTS `func_split_TotalLength`;
DELIMITER ;;
CREATE DEFINER=`root`@`%` FUNCTION `func_split_TotalLength`(f_string varchar(1000),f_delimiter varchar(5)) RETURNS int(11)
BEGIN 

    # 计算传入字符串的总length 

    return 1+(length(f_string) - length(replace(f_string,f_delimiter,''))); 

END
;;
DELIMITER ;
