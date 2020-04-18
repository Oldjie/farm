/*
 Navicat Premium Data Transfer

 Source Server         : localhost_3306
 Source Server Type    : MySQL
 Source Server Version : 50622
 Source Host           : localhost:3306
 Source Schema         : agritainment

 Target Server Type    : MySQL
 Target Server Version : 50622
 File Encoding         : 65001

 Date: 18/04/2020 12:47:06
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for news
-- ----------------------------
DROP TABLE IF EXISTS `news`;
CREATE TABLE `news`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `sub_title` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `content` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `img_url` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `sub_img_url` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `created` date NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 20 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of news
-- ----------------------------
INSERT INTO `news` VALUES (1, '农家乐-新客图', '去天下第一农庄旅游攻略及费用大概要多少?天下第一农庄有什么好玩的？团队有什么优惠？需要提前预定吗？', '天下第一农家乐融入大自然怀抱，是你在喧闹的城市中放松休闲的一片静土。\r\n\r\n农家乐内设棋牌娱乐区、垂钓区、水上互动娱乐区、田园果蔬区、KTV活动区、摸鱼区、烧烤野炊等多项目娱乐项目\r\n\r\n天下第一农庄是深圳一日游、亲子活动，深圳周边游的首选之地。', '../images/11.jpg', '../images/1.jpg', '2020-02-01');
INSERT INTO `news` VALUES (2, '农家乐-新客图', '天下第一农庄一个被原生态360°包围的绿色空间，远离都市的嘈杂', '天下第一农家乐融入大自然怀抱，是你在喧闹的城市中放松休闲的一片静土。\r\n\r\n农家乐内设棋牌娱乐区、垂钓区、水上互动娱乐区、田园果蔬区、KTV活动区、摸鱼区、烧烤野炊等多项目娱乐项目\r\n\r\n天下第一农庄是深圳一日游、亲子活动，深圳周边游的首选之地。', '../images/11.jpg', '../images/1.jpg', '2020-02-01');
INSERT INTO `news` VALUES (3, '农家乐-新客图', '天下第一农庄一个被原生态360°包围的绿色空间，远离都市的嘈杂', '天下第一农家乐融入大自然怀抱，是你在喧闹的城市中放松休闲的一片静土。\r\n\r\n农家乐内设棋牌娱乐区、垂钓区、水上互动娱乐区、田园果蔬区、KTV活动区、摸鱼区、烧烤野炊等多项目娱乐项目\r\n\r\n天下第一农庄是深圳一日游、亲子活动，深圳周边游的首选之地。', '../images/11.jpg', '../images/1.jpg', '2020-02-01');
INSERT INTO `news` VALUES (4, '农家乐-新客图', '天下第一农庄一个被原生态360°包围的绿色空间，远离都市的嘈杂', '天下第一农家乐融入大自然怀抱，是你在喧闹的城市中放松休闲的一片静土。\r\n\r\n农家乐内设棋牌娱乐区、垂钓区、水上互动娱乐区、田园果蔬区、KTV活动区、摸鱼区、烧烤野炊等多项目娱乐项目\r\n\r\n天下第一农庄是深圳一日游、亲子活动，深圳周边游的首选之地。', '../images/11.jpg', '../images/1.jpg', '2020-02-01');
INSERT INTO `news` VALUES (5, '农家乐-新客图', '天下第一农庄一个被原生态360°包围的绿色空间，远离都市的嘈杂', '天下第一农家乐融入大自然怀抱，是你在喧闹的城市中放松休闲的一片静土。\r\n\r\n农家乐内设棋牌娱乐区、垂钓区、水上互动娱乐区、田园果蔬区、KTV活动区、摸鱼区、烧烤野炊等多项目娱乐项目\r\n\r\n天下第一农庄是深圳一日游、亲子活动，深圳周边游的首选之地。', '../images/11.jpg', '../images/1.jpg', '2020-02-01');
INSERT INTO `news` VALUES (6, '农家乐-新客图', '天下第一农庄一个被原生态360°包围的绿色空间，远离都市的嘈杂', '天下第一农家乐融入大自然怀抱，是你在喧闹的城市中放松休闲的一片静土。\r\n\r\n农家乐内设棋牌娱乐区、垂钓区、水上互动娱乐区、田园果蔬区、KTV活动区、摸鱼区、烧烤野炊等多项目娱乐项目\r\n\r\n天下第一农庄是深圳一日游、亲子活动，深圳周边游的首选之地。', '../images/11.jpg', '../images/1.jpg', '2020-02-01');
INSERT INTO `news` VALUES (7, '农家乐-新客图', '天下第一农庄一个被原生态360°包围的绿色空间，远离都市的嘈杂', '天下第一农家乐融入大自然怀抱，是你在喧闹的城市中放松休闲的一片静土。\r\n\r\n农家乐内设棋牌娱乐区、垂钓区、水上互动娱乐区、田园果蔬区、KTV活动区、摸鱼区、烧烤野炊等多项目娱乐项目\r\n\r\n天下第一农庄是深圳一日游、亲子活动，深圳周边游的首选之地。', '../images/11.jpg', '../images/1.jpg', '2020-02-01');
INSERT INTO `news` VALUES (8, '农家乐-新客图', '天下第一农庄一个被原生态360°包围的绿色空间，远离都市的嘈杂', '天下第一农家乐融入大自然怀抱，是你在喧闹的城市中放松休闲的一片静土。\r\n\r\n农家乐内设棋牌娱乐区、垂钓区、水上互动娱乐区、田园果蔬区、KTV活动区、摸鱼区、烧烤野炊等多项目娱乐项目\r\n\r\n天下第一农庄是深圳一日游、亲子活动，深圳周边游的首选之地。', '../images/11.jpg', '../images/1.jpg', '2020-02-01');
INSERT INTO `news` VALUES (9, '农家乐-新客图', '天下第一农庄一个被原生态360°包围的绿色空间，远离都市的嘈杂', '天下第一农家乐融入大自然怀抱，是你在喧闹的城市中放松休闲的一片静土。\r\n\r\n农家乐内设棋牌娱乐区、垂钓区、水上互动娱乐区、田园果蔬区、KTV活动区、摸鱼区、烧烤野炊等多项目娱乐项目\r\n\r\n天下第一农庄是深圳一日游、亲子活动，深圳周边游的首选之地。', '../images/11.jpg', '../images/1.jpg', '2020-02-01');
INSERT INTO `news` VALUES (10, '农家乐-新客图', '天下第一农庄一个被原生态360°包围的绿色空间，远离都市的嘈杂', '天下第一农家乐融入大自然怀抱，是你在喧闹的城市中放松休闲的一片静土。\r\n\r\n农家乐内设棋牌娱乐区、垂钓区、水上互动娱乐区、田园果蔬区、KTV活动区、摸鱼区、烧烤野炊等多项目娱乐项目\r\n\r\n天下第一农庄是深圳一日游、亲子活动，深圳周边游的首选之地。', '../images/11.jpg', '../images/1.jpg', '2020-02-01');
INSERT INTO `news` VALUES (11, '农家乐-新客图', '天下第一农庄一个被原生态360°包围的绿色空间，远离都市的嘈杂', '天下第一农家乐融入大自然怀抱，是你在喧闹的城市中放松休闲的一片静土。\r\n\r\n农家乐内设棋牌娱乐区、垂钓区、水上互动娱乐区、田园果蔬区、KTV活动区、摸鱼区、烧烤野炊等多项目娱乐项目\r\n\r\n天下第一农庄是深圳一日游、亲子活动，深圳周边游的首选之地。', '../images/11.jpg', '../images/1.jpg', '2020-02-01');
INSERT INTO `news` VALUES (12, '农家乐-新客图', '天下第一农庄一个被原生态360°包围的绿色空间，远离都市的嘈杂', '天下第一农家乐融入大自然怀抱，是你在喧闹的城市中放松休闲的一片静土。\r\n\r\n农家乐内设棋牌娱乐区、垂钓区、水上互动娱乐区、田园果蔬区、KTV活动区、摸鱼区、烧烤野炊等多项目娱乐项目\r\n\r\n天下第一农庄是深圳一日游、亲子活动，深圳周边游的首选之地。', '../images/11.jpg', '../images/1.jpg', '2020-02-01');
INSERT INTO `news` VALUES (13, '农家乐-新客图', '天下第一农庄一个被原生态360°包围的绿色空间，远离都市的嘈杂', '天下第一农家乐融入大自然怀抱，是你在喧闹的城市中放松休闲的一片静土。\r\n\r\n农家乐内设棋牌娱乐区、垂钓区、水上互动娱乐区、田园果蔬区、KTV活动区、摸鱼区、烧烤野炊等多项目娱乐项目\r\n\r\n天下第一农庄是深圳一日游、亲子活动，深圳周边游的首选之地。', '../images/11.jpg', '../images/1.jpg', '2020-02-01');
INSERT INTO `news` VALUES (14, '农家乐-新客图', '天下第一农庄一个被原生态360°包围的绿色空间，远离都市的嘈杂', '天下第一农家乐融入大自然怀抱，是你在喧闹的城市中放松休闲的一片静土。\r\n\r\n农家乐内设棋牌娱乐区、垂钓区、水上互动娱乐区、田园果蔬区、KTV活动区、摸鱼区、烧烤野炊等多项目娱乐项目\r\n\r\n天下第一农庄是深圳一日游、亲子活动，深圳周边游的首选之地。', '../images/11.jpg', '../images/1.jpg', '2020-02-01');
INSERT INTO `news` VALUES (15, '农家乐-新客图', '天下第一农庄一个被原生态360°包围的绿色空间，远离都市的嘈杂', '天下第一农家乐融入大自然怀抱，是你在喧闹的城市中放松休闲的一片静土。\r\n\r\n农家乐内设棋牌娱乐区、垂钓区、水上互动娱乐区、田园果蔬区、KTV活动区、摸鱼区、烧烤野炊等多项目娱乐项目\r\n\r\n天下第一农庄是深圳一日游、亲子活动，深圳周边游的首选之地。', '../images/11.jpg', '../images/1.jpg', '2020-02-01');
INSERT INTO `news` VALUES (16, '农家乐-新客图', '天下第一农庄一个被原生态360°包围的绿色空间，远离都市的嘈杂', '天下第一农家乐融入大自然怀抱，是你在喧闹的城市中放松休闲的一片静土。\r\n\r\n农家乐内设棋牌娱乐区、垂钓区、水上互动娱乐区、田园果蔬区、KTV活动区、摸鱼区、烧烤野炊等多项目娱乐项目\r\n\r\n天下第一农庄是深圳一日游、亲子活动，深圳周边游的首选之地。', '../images/11.jpg', '../images/1.jpg', '2020-02-01');
INSERT INTO `news` VALUES (17, '农家乐-新客图', '天下第一农庄一个被原生态360°包围的绿色空间，远离都市的嘈杂', '天下第一农家乐融入大自然怀抱，是你在喧闹的城市中放松休闲的一片静土。\r\n\r\n农家乐内设棋牌娱乐区、垂钓区、水上互动娱乐区、田园果蔬区、KTV活动区、摸鱼区、烧烤野炊等多项目娱乐项目\r\n\r\n天下第一农庄是深圳一日游、亲子活动，深圳周边游的首选之地。', '../images/11.jpg', '../images/1.jpg', '2020-02-01');
INSERT INTO `news` VALUES (18, '农家乐-新客图', '天下第一农庄一个被原生态360°包围的绿色空间，远离都市的嘈杂', '天下第一农家乐融入大自然怀抱，是你在喧闹的城市中放松休闲的一片静土。\r\n\r\n农家乐内设棋牌娱乐区、垂钓区、水上互动娱乐区、田园果蔬区、KTV活动区、摸鱼区、烧烤野炊等多项目娱乐项目\r\n\r\n天下第一农庄是深圳一日游、亲子活动，深圳周边游的首选之地。', '../images/11.jpg', '../images/1.jpg', '2020-02-01');
INSERT INTO `news` VALUES (19, '农家乐-新客图', '天下第一农庄一个被原生态360°包围的绿色空间，远离都市的嘈杂', '天下第一农家乐融入大自然怀抱，是你在喧闹的城市中放松休闲的一片静土。\r\n\r\n农家乐内设棋牌娱乐区、垂钓区、水上互动娱乐区、田园果蔬区、KTV活动区、摸鱼区、烧烤野炊等多项目娱乐项目\r\n\r\n天下第一农庄是深圳一日游、亲子活动，深圳周边游的首选之地。', '../images/11.jpg', '../images/1.jpg', '2020-02-01');

SET FOREIGN_KEY_CHECKS = 1;
