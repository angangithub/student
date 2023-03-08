/*
 Navicat Premium Data Transfer

 Source Server         : cloud
 Source Server Type    : MySQL
 Source Server Version : 50736
 Source Host           : 124.223.161.145:3306
 Source Schema         : students

 Target Server Type    : MySQL
 Target Server Version : 50736
 File Encoding         : 65001

 Date: 03/03/2023 17:43:49
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for classes
-- ----------------------------
DROP TABLE IF EXISTS `classes`;
CREATE TABLE `classes`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `grade` int(11) NOT NULL,
  `teacher_id` int(11) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of classes
-- ----------------------------
INSERT INTO `classes` VALUES (1, '计算机科学与技术1班', 2021, 1);
INSERT INTO `classes` VALUES (2, '计算机科学与技术2班', 2021, 2);
INSERT INTO `classes` VALUES (3, '软件工程1班', 2021, 3);
INSERT INTO `classes` VALUES (4, '软件工程2班', 2021, 4);
INSERT INTO `classes` VALUES (5, '数据科学与大数据技术1班', 2021, 5);
INSERT INTO `classes` VALUES (6, '数据科学与大数据技术2班', 2021, 6);

-- ----------------------------
-- Table structure for courses
-- ----------------------------
DROP TABLE IF EXISTS `courses`;
CREATE TABLE `courses`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `description` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL,
  `credit` int(11) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of courses
-- ----------------------------
INSERT INTO `courses` VALUES (1, '数据结构', '这是一门关于数据结构的课程', 3);
INSERT INTO `courses` VALUES (2, '操作系统', '这是一门关于操作系统的课程', 4);
INSERT INTO `courses` VALUES (3, '计算机网络', '这是一门关于计算机网络的课程', 3);
INSERT INTO `courses` VALUES (4, '算法设计与分析', '这是一门关于算法设计与分析的课程', 3);
INSERT INTO `courses` VALUES (5, '数据库系统', '这是一门关于数据库系统的课程', 4);

-- ----------------------------
-- Table structure for enrollments
-- ----------------------------
DROP TABLE IF EXISTS `enrollments`;
CREATE TABLE `enrollments`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `student_id` int(11) NOT NULL,
  `course_id` int(11) NOT NULL,
  `enroll_date` date NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 12 CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of enrollments
-- ----------------------------
INSERT INTO `enrollments` VALUES (1, 1, 1, '2020-09-01');
INSERT INTO `enrollments` VALUES (2, 1, 2, '2020-09-01');
INSERT INTO `enrollments` VALUES (3, 1, 3, '2020-09-01');
INSERT INTO `enrollments` VALUES (4, 2, 1, '2020-09-01');
INSERT INTO `enrollments` VALUES (5, 2, 4, '2020-09-01');
INSERT INTO `enrollments` VALUES (6, 3, 2, '2020-09-01');
INSERT INTO `enrollments` VALUES (7, 3, 4, '2020-09-01');
INSERT INTO `enrollments` VALUES (8, 4, 1, '2020-09-01');
INSERT INTO `enrollments` VALUES (9, 4, 5, '2020-09-01');
INSERT INTO `enrollments` VALUES (10, 5, 3, '2020-09-01');
INSERT INTO `enrollments` VALUES (11, 5, 5, '2020-09-01');

-- ----------------------------
-- Table structure for grades
-- ----------------------------
DROP TABLE IF EXISTS `grades`;
CREATE TABLE `grades`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `student_id` int(11) NOT NULL,
  `course_id` int(11) NOT NULL,
  `score` int(11) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 12 CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of grades
-- ----------------------------
INSERT INTO `grades` VALUES (1, 1, 1, 90);
INSERT INTO `grades` VALUES (2, 1, 2, 85);
INSERT INTO `grades` VALUES (3, 1, 3, 88);
INSERT INTO `grades` VALUES (4, 2, 1, 92);
INSERT INTO `grades` VALUES (5, 2, 4, 90);
INSERT INTO `grades` VALUES (6, 3, 2, 87);
INSERT INTO `grades` VALUES (7, 3, 4, 91);
INSERT INTO `grades` VALUES (8, 4, 1, 85);
INSERT INTO `grades` VALUES (9, 4, 5, 89);
INSERT INTO `grades` VALUES (10, 5, 3, 90);
INSERT INTO `grades` VALUES (11, 5, 5, 93);

-- ----------------------------
-- Table structure for score_management
-- ----------------------------
DROP TABLE IF EXISTS `score_management`;
CREATE TABLE `score_management`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `student_id` int(11) NOT NULL,
  `course_id` int(11) NOT NULL,
  `score` int(11) NOT NULL,
  `remark` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 13 CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of score_management
-- ----------------------------
INSERT INTO `score_management` VALUES (1, 1, 1, 85, '考试成绩不错，继续保持！');
INSERT INTO `score_management` VALUES (2, 1, 2, 75, '需要加强对课程重点的理解和掌握');
INSERT INTO `score_management` VALUES (3, 2, 1, 90, '出色的表现，继续保持！');
INSERT INTO `score_management` VALUES (4, 2, 3, 65, '需要认真复习并强化基础知识');
INSERT INTO `score_management` VALUES (5, 3, 2, 80, '表现良好，继续努力！');
INSERT INTO `score_management` VALUES (6, 3, 3, 70, '需要认真复习并加强练习');
INSERT INTO `score_management` VALUES (7, 4, 1, 95, '优秀的表现，继续保持！');
INSERT INTO `score_management` VALUES (8, 4, 2, 90, '出色的表现，继续保持！');
INSERT INTO `score_management` VALUES (9, 4, 3, 85, '表现不错，继续努力！');
INSERT INTO `score_management` VALUES (10, 5, 1, 80, '表现良好，继续努力！');
INSERT INTO `score_management` VALUES (11, 5, 2, 70, '需要认真复习并加强练习');
INSERT INTO `score_management` VALUES (12, 5, 3, 75, '考试成绩不错，继续保持！');

-- ----------------------------
-- Table structure for students
-- ----------------------------
DROP TABLE IF EXISTS `students`;
CREATE TABLE `students`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `gender` varchar(50) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL,
  `birthday` date NOT NULL,
  `email` varchar(50) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL,
  `phone` varchar(20) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL,
  `enroll_date` date NOT NULL,
  `class_id` int(11) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of students
-- ----------------------------
INSERT INTO `students` VALUES (1, '张三', 'male', '2000-01-01', 'zhangsan@example.com', '12345678901', '2020-09-01', 0);
INSERT INTO `students` VALUES (2, '李四', 'female', '2001-01-01', 'lisi@example.com', '12345678902', '2020-09-01', 0);
INSERT INTO `students` VALUES (3, '王五', 'male', '2002-01-01', 'wangwu@example.com', '12345678903', '2020-09-01', 0);
INSERT INTO `students` VALUES (4, '赵六', 'other', '2003-01-01', 'zhaoliu@example.com', '12345678904', '2020-09-01', 0);
INSERT INTO `students` VALUES (5, '钱七', 'male', '2004-01-01', 'qianqi@example.com', '12345678905', '2020-09-01', 0);

-- ----------------------------
-- Table structure for teachers
-- ----------------------------
DROP TABLE IF EXISTS `teachers`;
CREATE TABLE `teachers`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL,
  `gender` enum('male','female','other') CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL,
  `birthday` date NOT NULL,
  `email` varchar(50) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL,
  `phone` varchar(20) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL,
  `hire_date` date NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = latin1 COLLATE = latin1_swedish_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of teachers
-- ----------------------------
INSERT INTO `teachers` VALUES (1, 'John Doe', 'male', '1980-02-15', 'johndoe@example.com', '555-1234', '2010-09-01');
INSERT INTO `teachers` VALUES (2, 'Jane Smith', 'female', '1985-05-10', 'janesmith@example.com', '555-5678', '2012-03-15');
INSERT INTO `teachers` VALUES (3, 'Robert Johnson', 'male', '1975-12-31', 'robertjohnson@example.com', '555-4321', '2008-07-01');
INSERT INTO `teachers` VALUES (4, 'Emily Davis', 'female', '1990-08-22', 'emilydavis@example.com', '555-8765', '2015-01-01');
INSERT INTO `teachers` VALUES (5, 'Michael Brown', 'male', '1988-11-05', 'michaelbrown@example.com', '555-2468', '2013-11-15');

SET FOREIGN_KEY_CHECKS = 1;
