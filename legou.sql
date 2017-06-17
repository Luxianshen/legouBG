/*
Navicat MySQL Data Transfer

Source Server         : mySql_con
Source Server Version : 50540
Source Host           : 127.0.0.1:3306
Source Database       : legou

Target Server Type    : MYSQL
Target Server Version : 50540
File Encoding         : 65001

Date: 2016-08-24 10:58:46
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for orders
-- ----------------------------
DROP TABLE IF EXISTS `orders`;
CREATE TABLE `orders` (
  `orderId` int(11) NOT NULL AUTO_INCREMENT,
  `userID` int(11) DEFAULT NULL,
  `proId` int(11) DEFAULT NULL,
  `orderTime` datetime DEFAULT NULL,
  `orderNum` int(11) DEFAULT NULL,
  `orderPrice` decimal(10,0) DEFAULT NULL,
  `orderPay` varchar(255) DEFAULT NULL,
  `orderIsDel` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`orderId`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of orders
-- ----------------------------
INSERT INTO `orders` VALUES ('1', '1', '1', '2016-08-12 10:28:55', '1', '1', '1', '1');
INSERT INTO `orders` VALUES ('2', '1', '1', '2016-08-24 09:05:16', '5', '320', '0', '1');
INSERT INTO `orders` VALUES ('3', '2', '1', '2016-08-24 09:31:27', '1', '320', '0', '1');
INSERT INTO `orders` VALUES ('4', '1', '2', '2016-08-24 10:47:40', '2', '3400', '0', '1');
INSERT INTO `orders` VALUES ('5', '1', '4', '2016-08-24 10:52:52', '1', '99', '0', '1');
INSERT INTO `orders` VALUES ('6', '1', '5', '2016-08-24 10:56:11', '1', '400', '0', '1');

-- ----------------------------
-- Table structure for product
-- ----------------------------
DROP TABLE IF EXISTS `product`;
CREATE TABLE `product` (
  `proId` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `proName` varchar(255) DEFAULT NULL,
  `proType` varchar(255) DEFAULT NULL,
  `proPrice` decimal(10,0) DEFAULT NULL,
  `proNum` int(11) DEFAULT NULL,
  `proSrc` varchar(255) DEFAULT NULL,
  `prodescribe` varchar(255) DEFAULT NULL,
  `proalrePay` varchar(255) DEFAULT NULL,
  `proFare` varchar(255) DEFAULT NULL,
  `proAddress` varchar(255) DEFAULT NULL,
  `stock` int(255) DEFAULT NULL,
  PRIMARY KEY (`proId`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of product
-- ----------------------------
INSERT INTO `product` VALUES ('1', '电饭煲', '家电', '320', '2', 'produelectricooker', 'AUX/奥克斯 CFXB50-10 家用5L升学生电饭煲 正品特价电饭锅5-6人', '324', '免运费', '浙江', '123');
INSERT INTO `product` VALUES ('2', '空调', '家电', '3400', '1', 'produaircondition', 'Chigo/志高 NEW-GD9T8H3正1匹冷暖定频挂机高效节能净化挂式空调', '168', '免运费', '北京', '122');
INSERT INTO `product` VALUES ('3', '冰箱', '家电', '6000', '1', 'produrefrigerator', 'Konka/康佳 BCD-288GY4S冰箱多门式家用一级节能法式多门电冰箱', '97', '15元运费', '福建', '121');
INSERT INTO `product` VALUES ('4', '电吹风', '家电', '99', '2', 'produelectrichairdrier', '纳米离子护理电吹风', '104', '5元运费', '海南', '120');
INSERT INTO `product` VALUES ('5', '电磁炉', '家电', '400', '1', 'produinductioncooker', '\r\n嵌入式防爆钢化玻璃燃气灶', '463', '免运费', '湖北', '119');
INSERT INTO `product` VALUES ('6', '电视', '家电', '2300', '1', 'produtalevision', '电视面板模组采用开放式嵌入', '856', '免运费', '上海', '128');
INSERT INTO `product` VALUES ('7', '洗衣机', '图书', '5400', '2', 'produwashingmachine', '欧品6.5公斤波轮家用全自动洗衣机', '564', '免运费', '广州', '154');
INSERT INTO `product` VALUES ('8', '小说', '图书', '33', '3', 'drawable/book.jpg', '福尔摩斯探案全集足本原版插图侦探推理小说', '450', '10运费', '深圳', '458');
INSERT INTO `product` VALUES ('9', '棉服', '衣服', '100', '2', 'drawable/cloths.jpg', '新款2016韩版超长款过膝羽绒棉衣', '1037', '免运费', '天津', '123');
INSERT INTO `product` VALUES ('10', '联想', '笔记本', '24', '1', 'drawable/personal-computer.jpg', '联想四核独显轻薄商务游戏分期笔记本电脑', '632', '免运费', '浙江', '452');
INSERT INTO `product` VALUES ('11', '相机', '数码', '3240', '2', 'drawable/camera.jpg', '李易峰同款 佳能美颜微单 M10相机 支持WIFI', '286', '20元运费', '广州', '751');
INSERT INTO `product` VALUES ('12', '红木椅', '家具', '7680', '1', 'drawable/chair.jpg', '休闲红实木小靠背椅官帽椅儿童椅换鞋椅宝宝', '86', '15运费', '海南', '11');
INSERT INTO `product` VALUES ('13', 'iphone6', '手机', '6400', '2', 'drawable/iphone6.jpg', 'Apple/苹果 iPhone 6 6p 正品未激活 现货', '173', '免运费', '中山', '21');
INSERT INTO `product` VALUES ('14', '洗面奶', '护肤', '78', '3', 'drawable/inisfree.jpg', '悦诗风吟洗面奶', '395', '免运费', '上海', '21');

-- ----------------------------
-- Table structure for productlist
-- ----------------------------
DROP TABLE IF EXISTS `productlist`;
CREATE TABLE `productlist` (
  `proId` int(255) NOT NULL,
  `proName` varchar(255) DEFAULT NULL,
  `proSrc` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of productlist
-- ----------------------------
INSERT INTO `productlist` VALUES ('1', '家电', 'drawable/catergory_appliance.jpg');
INSERT INTO `productlist` VALUES ('2', '图书', 'drawable/catergory_book.jpg');
INSERT INTO `productlist` VALUES ('3', '衣服', 'drawable/catergory_cloth.jpg');
INSERT INTO `productlist` VALUES ('4', '笔记本', 'drawable/catergory_deskbook.jpg');
INSERT INTO `productlist` VALUES ('5', '数码', 'drawable/catergory_digtcamer.jpg');
INSERT INTO `productlist` VALUES ('6', '家具', 'drawable/catergory_furnitrue.jpg');
INSERT INTO `productlist` VALUES ('7', '手机', 'drawable/catergory_mobile');
INSERT INTO `productlist` VALUES ('8', '护肤', 'drawable/catergory_skincare.jpg');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `userID` int(11) NOT NULL AUTO_INCREMENT,
  `userName` varchar(255) NOT NULL,
  `userPwd` varchar(255) NOT NULL,
  `email` varchar(255) DEFAULT NULL,
  `realName` varchar(255) DEFAULT NULL,
  `tel` varchar(255) DEFAULT NULL,
  `age` int(11) DEFAULT NULL,
  `sex` varchar(255) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `postalcode` varchar(255) DEFAULT NULL,
  `isDel` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`userID`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'dong', 'c01abe74c44be79ce0bec6f042353064', '123', '343', '11', '1', 'man', '123', '213', '1');
INSERT INTO `user` VALUES ('5', '12345', '827ccb0eea8a706c4c34a16891f84e7b', '123', '33', '3', '0', '33', '33', '33', '0');
