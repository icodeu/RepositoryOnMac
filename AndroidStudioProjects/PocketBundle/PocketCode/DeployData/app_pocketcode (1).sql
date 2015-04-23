-- phpMyAdmin SQL Dump
-- version 3.3.8.1
-- http://www.phpmyadmin.net
--
-- 主机: w.rdc.sae.sina.com.cn:3307
-- 生成日期: 2014 年 12 月 13 日 19:22
-- 服务器版本: 5.5.23
-- PHP 版本: 5.3.3

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- 数据库: `app_pocketcode`
--

-- --------------------------------------------------------

--
-- 表的结构 `category`
--

CREATE TABLE IF NOT EXISTS `category` (
  `category_id` varchar(10) NOT NULL,
  `category_name` text NOT NULL,
  PRIMARY KEY (`category_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- 转存表中的数据 `category`
--

INSERT INTO `category` (`category_id`, `category_name`) VALUES
('1', 'Java'),
('2', 'Android'),
('3', 'PHP'),
('4', 'C语言');

-- --------------------------------------------------------

--
-- 表的结构 `course`
--

CREATE TABLE IF NOT EXISTS `course` (
  `course_id` int(100) NOT NULL AUTO_INCREMENT,
  `lesson_id` int(100) NOT NULL,
  `course_time` text NOT NULL,
  `course_name` text NOT NULL,
  `course_path` text NOT NULL,
  PRIMARY KEY (`course_id`)
) ENGINE=MyISAM  DEFAULT CHARSET=utf8 AUTO_INCREMENT=150 ;

--
-- 转存表中的数据 `course`
--

INSERT INTO `course` (`course_id`, `lesson_id`, `course_time`, `course_name`, `course_path`) VALUES
(1, 1, '4:06', '0准备工作', 'http://icodeyou.qiniudn.com/使用ViewPager+Fragment模仿微信主布局/0准备工作.mp4'),
(2, 1, '3:59', '1Fragment的创建与使用', 'http://icodeyou.qiniudn.com/使用ViewPager+Fragment模仿微信主布局/1Fragment的创建与使用.mp4'),
(3, 1, '5:18', '2Fragment与Viewpager的结合使用', 'http://icodeyou.qiniudn.com/使用ViewPager+Fragment模仿微信主布局/2Fragment与Viewpager的结合使用.mp4'),
(4, 1, '6:11', '3页面底部导航按钮的实现', 'http://icodeyou.qiniudn.com/使用ViewPager+Fragment模仿微信主布局/3页面底部导航按钮的实现.mp4'),
(5, 1, '4:49', '4Fragment ViewPager与底部导航按钮的结合使用', 'http://icodeyou.qiniudn.com/使用ViewPager+Fragment模仿微信主布局/4Fragment ViewPager与底部导航按钮的结合使用.mp4'),
(6, 2, '2:52', '0准备工作', 'http://icodeyou.qiniudn.com/获取手机短信并上传至服务器/0准备工作.mp4'),
(7, 2, '6:38', '1实现BroadCReceiver接收器', 'http://icodeyou.qiniudn.com/获取手机短信并上传至服务器/1实现BroadCReceiver接收器.mp4'),
(8, 2, '5:50', '2解析短信内容', 'http://icodeyou.qiniudn.com/获取手机短信并上传至服务器/2解析短信内容.mp4'),
(9, 2, '4:43', '3使用回调方式传递信息', 'http://icodeyou.qiniudn.com/获取手机短信并上传至服务器/3使用回调方式传递信息.mp4'),
(10, 2, '9:37', '4上传消息至服务器', 'http://icodeyou.qiniudn.com/获取手机短信并上传至服务器/4上传消息至服务器.mp4'),
(11, 3, '17:12', '01_腾讯微博项目介绍', 'http://pocketcode.qiniudn.com/Mars-Android-第四季/01_腾讯微博项目介绍.mp4'),
(12, 3, '19:41', '02_OAuth', 'http://pocketcode.qiniudn.com/Mars-Android-第四季/02_OAuth认证原理.mp4'),
(13, 3, '25:12', '03_OAuth认证（一）', 'http://pocketcode.qiniudn.com/Mars-Android-第四季/03_OAuth认证（一）.mp4'),
(14, 3, '26:37', '04_OAuth认证（二）', 'http://pocketcode.qiniudn.com/Mars-Android-第四季/04_OAuth认证（二）.mp4'),
(15, 3, '23:36', '05_异步操作（一）', 'http://pocketcode.qiniudn.com/Mars-Android-第四季/05_异步操作（一）.mp4'),
(16, 3, '29:47', '06_异步任务（二）', 'http://pocketcode.qiniudn.com/Mars-Android-第四季/06_异步任务（二）.mp4'),
(17, 3, '18:50', '07_HTTP操作（一）', 'http://pocketcode.qiniudn.com/Mars-Android-第四季/07_HTTP操作（一）.mp4'),
(18, 3, '18:44', '08_HTTP操作（二）', 'http://pocketcode.qiniudn.com/Mars-Android-第四季/08_HTTP操作（二）.mp4'),
(19, 3, '35:09', '09_HTTP操作（三）', 'http://pocketcode.qiniudn.com/Mars-Android-第四季/09_HTTP操作（三）.mp4'),
(20, 3, '31:42', '10_OAuth认证流程（三）', 'http://pocketcode.qiniudn.com/Mars-Android-第四季/04_10_OAuth认证流程（三）.mp4'),
(21, 3, '34:40', '11_发送一条微博信息', 'http://pocketcode.qiniudn.com/Mars-Android-第四季/04_11_发送一条微博信息.mp4'),
(22, 3, '31:39', '12_获取主页时间线', 'http://pocketcode.qiniudn.com/Mars-Android-第四季/04_12_获取主页时间线.mp4'),
(23, 3, '29:06', '13_自定义ListView', 'http://pocketcode.qiniudn.com/Mars-Android-第四季/04_13_自定义ListView.mp4'),
(24, 3, '33:40', '14_图片的异步加载', 'http://pocketcode.qiniudn.com/Mars-Android-第四季/04_14_图片的异步加载（一）.mp4'),
(25, 4, '30:31', '01_蓝牙操作（一）', 'http://7sblu3.com1.z0.glb.clouddn.com/Mars-Android-第三季/03_01_蓝牙操作（一）.mp4'),
(26, 4, '22:57', '02_蓝牙操作（二）', 'http://7sblu3.com1.z0.glb.clouddn.com/Mars-Android-第三季/03_02_蓝牙操作（二）.mp4'),
(27, 4, '27:44', '03_用户定位（一）', 'http://7sblu3.com1.z0.glb.clouddn.com/Mars-Android-第三季/03_03_用户定位（一）.mp4'),
(28, 4, '27:17', '04_用户定位（二）', 'http://7sblu3.com1.z0.glb.clouddn.com/Mars-Android-第三季/03_04_用户定位（二）.mp4'),
(29, 4, '31:32', '05_用户定位（三）', 'http://7sblu3.com1.z0.glb.clouddn.com/Mars-Android-第三季/03_05_用户定位（三）.mp4'),
(30, 4, '24:37', '06_GoogleMap(一)', 'http://7sblu3.com1.z0.glb.clouddn.com/Mars-Android-第三季/03_06_GoogleMap(一).mp4'),
(31, 4, '33:17', '07_GoogleMap(二)', 'http://7sblu3.com1.z0.glb.clouddn.com/Mars-Android-第三季/03_07_GoogleMap(二).mp4'),
(32, 4, '29:00', '08_GoogleMap(三)', 'http://7sblu3.com1.z0.glb.clouddn.com/Mars-Android-第三季/03_08_GoogleMap(三).mp4'),
(33, 5, '34:58', '01_spinner的使用', 'http://pocketcode.qiniudn.com/Mars-Android-第二季/02_01_spinner的使用.mp4'),
(34, 5, '28:25', '02_常见控件(五)', 'http://pocketcode.qiniudn.com/Mars-Android-第二季/02_02_常见控件(五).mp4'),
(35, 5, '33:20', '03_常见控件（六）', 'http://pocketcode.qiniudn.com/Mars-Android-第二季/02_03_常见控件（六）.mp4'),
(36, 5, '22:54', '04_常见控件（七）', 'http://pocketcode.qiniudn.com/Mars-Android-第二季/02_04_常见控件（七）.mp4'),
(37, 5, '22:40', '05_appwidget(一)', 'http://pocketcode.qiniudn.com/Mars-Android-第二季/02_05_appwidget(一).mp4'),
(38, 5, '25:32', '06_appwidget(二)', 'http://pocketcode.qiniudn.com/Mars-Android-第二季/02_06_appwidget(二).mp4'),
(39, 5, '33:04', '07_AppWidget的使用(三)', 'http://pocketcode.qiniudn.com/Mars-Android-第二季/02_07_AppWidget的使用(三).mp4'),
(40, 5, '35:31', '08_Animation的使用（一）（上）.mp4', 'http://pocketcode.qiniudn.com/Mars-Android-第二季/02_08_Animation的使用（一）（上）.mp4'),
(41, 5, '39:38', '08_Animation的使用（一）（下）', 'http://pocketcode.qiniudn.com/Mars-Android-第二季/02_08_Animation的使用（一）.mp4'),
(42, 5, '25:16', '09_Animations的使用（二）', 'http://pocketcode.qiniudn.com/Mars-Android-第二季/02_09_Animations的使用（二）.mp4'),
(43, 5, '26:44', '10_Animations的使用(三)', 'http://pocketcode.qiniudn.com/Mars-Android-第二季/02_10_Animations的使用(三).mp4'),
(44, 5, '33:11', '11_Animations的使用（四）', 'http://pocketcode.qiniudn.com/Mars-Android-第二季/02_11_Animations的使用（四）.mp4'),
(45, 5, '37:28', '12_JSON数据解析', 'http://pocketcode.qiniudn.com/Mars-Android-第二季/02_12_JSON数据解析.mp4'),
(46, 6, '20:56', '01_Android平台一日游', 'http://7sblu3.com1.z0.glb.clouddn.com/Mars-Android-第一季/01_01_Android平台一日游.mp4'),
(47, 6, '23:32', '02_搭建Android开发环境', 'http://7sblu3.com1.z0.glb.clouddn.com/Mars-Android-第一季/01_02_搭建Android开发环境.mp4'),
(48, 6, '21:48', '03_say_hello_to_Android', 'http://7sblu3.com1.z0.glb.clouddn.com/Mars-Android-第一季/01_03_say_hello_to_Android.mp4'),
(49, 6, '27:29', '04_Activity初步', 'http://7sblu3.com1.z0.glb.clouddn.com/Mars-Android-第一季/01_04_Activity初步.mp4'),
(50, 6, '33:30', '05_Activity和Intent', 'http://7sblu3.com1.z0.glb.clouddn.com/Mars-Android-第一季/01_05_Activity和Intent.mp4'),
(51, 6, '37:48', '06_Android当中的常见控件', 'http://7sblu3.com1.z0.glb.clouddn.com/Mars-Android-第一季/01_06_Android当中的常见控件.mp4'),
(52, 6, '19:06', '07_Activity生命周期（一）', 'http://7sblu3.com1.z0.glb.clouddn.com/Mars-Android-第一季/01_07_Activity生命周期（一）.mp4'),
(53, 6, '25:35', '08_Activity的生命周期（二）', 'http://7sblu3.com1.z0.glb.clouddn.com/Mars-Android-第一季/01_08_Activity的生命周期（二）.mp4'),
(54, 6, '30:11', '09_Activity布局初步(一)', 'http://7sblu3.com1.z0.glb.clouddn.com/Mars-Android-第一季/01_09_Activity布局初步(一).mp4'),
(55, 6, '12:16', '10_Activity布局初步(二)', 'http://7sblu3.com1.z0.glb.clouddn.com/Mars-Android-第一季/01_10_Activity布局初步(二).mp4'),
(56, 6, '26:30', '11_Activity的布局初步（三）', 'http://7sblu3.com1.z0.glb.clouddn.com/Mars-Android-第一季/01_11_Activity的布局初步（三）.mp4'),
(57, 6, '27:02', '12_Android常见控件（二）', 'http://7sblu3.com1.z0.glb.clouddn.com/Mars-Android-第一季/01_12_Android常见控件（二）.mp4'),
(58, 6, '34:25', '13_常用控件（三）', 'http://7sblu3.com1.z0.glb.clouddn.com/Mars-Android-第一季/01_13_常用控件（三）.mp4'),
(59, 6, '44:54', '14_SQLite的使用1', 'http://7sblu3.com1.z0.glb.clouddn.com/Mars-Android-第一季/SQLite的使用.mp4'),
(60, 6, '44:54', '15_SQLite的使用2', 'http://7sblu3.com1.z0.glb.clouddn.com/Mars-Android-第一季/SQLite的使用.mp4'),
(61, 6, '44:54', '16_SQLite的使用3', 'http://7sblu3.com1.z0.glb.clouddn.com/Mars-Android-第一季/SQLite的使用.mp4'),
(62, 6, '23:05', '17_调试程序', 'http://7sblu3.com1.z0.glb.clouddn.com/Mars-Android-第一季/01_17_调试程序.mp4'),
(63, 6, '33:07', '18_文件下载', 'http://7sblu3.com1.z0.glb.clouddn.com/Mars-Android-第一季/01_18_文件下载.mp4'),
(64, 6, '67:29', '19_ContentProvider初步', 'http://7sblu3.com1.z0.glb.clouddn.com/Mars-Android-第一季/01_19_ContentProvider初步.mp4'),
(65, 6, '38:46', '20_XML文件解析', 'http://7sblu3.com1.z0.glb.clouddn.com/Mars-Android-第一季/01_20_XML文件解析.mp4'),
(66, 6, '25:04', '21_广播机制（一）', 'http://7sblu3.com1.z0.glb.clouddn.com/Mars-Android-第一季/01_21_广播机制（一）.mp4'),
(67, 6, '29:42', '22_广播机制（二）', 'http://7sblu3.com1.z0.glb.clouddn.com/Mars-Android-第一季/02_22_广播机制（二）.mp4'),
(68, 6, '25:25', '23_WIFI网络操作', 'http://7sblu3.com1.z0.glb.clouddn.com/Mars-Android-第一季/01_23_WIFI网络操作.mp4'),
(69, 6, '35:41', '24_Socket编程', 'http://7sblu3.com1.z0.glb.clouddn.com/Mars-Android-第一季/01_24_Socket编程.mp4'),
(70, 6, '20:26', '25_Service初步', 'http://7sblu3.com1.z0.glb.clouddn.com/Mars-Android-第一季/01_25_Service初步（一）.mp4'),
(71, 7, '25:14', '01_Java考古学', 'http://pocketcode.qiniudn.com/Mars-Java/01_Java考古学.mp4'),
(72, 7, '29:57', '02_Java创世纪', 'http://pocketcode.qiniudn.com/Mars-Java/02_Java创世纪.mp4'),
(73, 7, '35:06', '03_Java基本概念（一）', 'http://pocketcode.qiniudn.com/Mars-Java/03_Java基本概念（一）.mp4'),
(74, 7, '26:51', '04_Java的变量', 'http://pocketcode.qiniudn.com/Mars-Java/04_Java的变量.mp4'),
(75, 7, '35:26', '05_Java的基本数据类型', 'http://pocketcode.qiniudn.com/Mars-Java/05_Java的基本数据类型.mp4'),
(76, 7, '36:10', '06_练习课（一）', 'http://pocketcode.qiniudn.com/Mars-Java/06_练习课（一）.mp4'),
(77, 7, '45:05', '07_运算符与表达式', 'http://pocketcode.qiniudn.com/Mars-Java/07_运算符与表达式.mp4'),
(78, 7, '35:47', '08_分支语句', 'http://pocketcode.qiniudn.com/Mars-Java/08_分支语句.mp4'),
(79, 7, '22:51', '09_练习课（二）', 'http://pocketcode.qiniudn.com/Mars-Java/09_练习课（二）.mp4'),
(80, 7, '14:11', '10_循环语句', 'http://pocketcode.qiniudn.com/Mars-Java/10_循环语句.mp4'),
(81, 7, '34:34', '11_练习课（三）', 'http://pocketcode.qiniudn.com/Mars-Java/11_练习课（三）.mp4'),
(82, 7, '20:32', '12_面向对象基础（一）', 'http://pocketcode.qiniudn.com/Mars-Java/12_面向对象基础（一）.mp4'),
(83, 7, '23:07', '13_面向对象基础（二）', 'http://pocketcode.qiniudn.com/Mars-Java/13_面向对象基础（二）.mp4'),
(84, 7, '21:46', '14_面向对象基础（三）', 'http://pocketcode.qiniudn.com/Mars-Java/14_面向对象基础（三）.mp4'),
(85, 7, '28:06', '15_面向对象基础（四）', 'http://pocketcode.qiniudn.com/Mars-Java/15_面向对象基础（四）.mp4'),
(86, 7, '25:17', '16_this的使用方法', 'http://pocketcode.qiniudn.com/Mars-Java/16_this的使用方法.mp4'),
(87, 7, '25:28', '17_static关键字的作用', 'http://pocketcode.qiniudn.com/Mars-Java/17_static关键字的作用.mp4'),
(88, 7, '23:52', '18_继承初步', 'http://pocketcode.qiniudn.com/Mars-Java/18_继承初步.mp4'),
(89, 7, '20:02', '19_子类实例化过程', 'http://pocketcode.qiniudn.com/Mars-Java/19_子类实例化过程.mp4'),
(90, 7, '20:35', '20_函数的复写', 'http://pocketcode.qiniudn.com/Mars-Java/20_函数的复写.mp4'),
(91, 7, '30:52', '21_对象的转型', 'http://pocketcode.qiniudn.com/Mars-Java/21_对象的转型.mp4'),
(92, 7, '21:33', '22_面向对象应用（一）', 'http://pocketcode.qiniudn.com/Mars-Java/22_面向对象应用（一）.mp4'),
(93, 7, '28:26', '23_抽象类和抽象函数', 'http://pocketcode.qiniudn.com/Mars-Java/23_抽象类和抽象函数.mp4'),
(94, 7, '23:40', '24_为什么用抽象类', 'http://pocketcode.qiniudn.com/Mars-Java/24_为什么用抽象类.mp4'),
(95, 7, '23:24', '25_包和访问权限(一)', 'http://pocketcode.qiniudn.com/Mars-Java/25_包和访问权限(一).mp4'),
(96, 7, '26:24', '26_包和访问权限（二）', 'http://pocketcode.qiniudn.com/Mars-Java/26_包和访问权限（二）.mp4'),
(97, 7, '23:59', '27_包和访问权限（三）', 'http://pocketcode.qiniudn.com/Mars-Java/27_包和访问权限（三）.mp4'),
(98, 7, '27:59', '28_接口的基本语法', 'http://pocketcode.qiniudn.com/Mars-Java/28_接口的基本语法.mp4'),
(99, 7, '27:58', '29_接口的应用', 'http://pocketcode.qiniudn.com/Mars-Java/29_接口的应用.mp4'),
(100, 7, '25:58', '30_Java当中的异常（一）', 'http://7sblu3.com1.z0.glb.clouddn.com/Mars-Java/Java当中的异常（一）.mp4'),
(101, 7, '16:29', '31_Java当中的异常（二）', 'http://pocketcode.qiniudn.com/Mars-Java/31_Java当中的异常（二）.mp4'),
(102, 7, '44:47', '32_Java当中的IO(一)', 'http://pocketcode.qiniudn.com/Mars-Java/32_Java当中的IO(一).mp4'),
(103, 7, '36:08', '33_Java当中的IO（二）', 'http://pocketcode.qiniudn.com/Mars-Java/33_Java当中的IO（二）.mp4'),
(104, 7, '34:35', '34_Java当中的IO（三）', 'http://pocketcode.qiniudn.com/Mars-Java/34_Java当中的IO（三）.mp4'),
(105, 7, '23:30', '35_内部类和匿名内部类', 'http://pocketcode.qiniudn.com/Mars-Java/35_内部类和匿名内部类.mp4'),
(106, 7, '31:14', '36_Java当中的线程', 'http://pocketcode.qiniudn.com/Mars-Java/36_Java当中的线程.mp4'),
(107, 7, '23:32', '37_Java当中的线程（二）', 'http://pocketcode.qiniudn.com/Mars-Java/37_Java当中的线程（二）.mp4'),
(108, 7, '27:41', '38_Java当中的线程(三)', 'http://pocketcode.qiniudn.com/Mars-Java/38_Java当中的线程(三).mp4'),
(109, 7, '27:41', '39_Java当中的线程(四)', 'http://pocketcode.qiniudn.com/Mars-Java/38_Java当中的线程(三).mp4'),
(110, 7, '27:06', '40_Java当中的数组', 'http://pocketcode.qiniudn.com/Mars-Java/40_Java当中的数组.mp4'),
(111, 7, '24:32', '41_类集框架（一）', 'http://pocketcode.qiniudn.com/Mars-Java/41_类集框架（一）.mp4'),
(112, 7, '30:46', '42_类集框架(二)', 'http://pocketcode.qiniudn.com/Mars-Java/42_类集框架(二).mp4'),
(113, 7, '22:56', '43_类集框架（三）', 'http://pocketcode.qiniudn.com/Mars-Java/43_类集框架（三）.mp4'),
(114, 7, '31:18', '44_equals函数的作用', 'http://pocketcode.qiniudn.com/Mars-Java/44_equals函数的作用.mp4'),
(115, 7, '22:26', '45_hashCode()与toString()', 'http://pocketcode.qiniudn.com/Mars-Java/45_hashCode()与toString().mp4'),
(116, 7, '27:33', '46_开发工具之Eclipse(一)', 'http://pocketcode.qiniudn.com/Mars-Java/46_开发工具之Eclipse(一).mp4'),
(117, 7, '30:15', '47_开发工具之Eclipse(二)', 'http://pocketcode.qiniudn.com/Mars-Java/47_开发工具之Eclipse(二).mp4'),
(118, 7, '31:41', '48_开发工具之Eclipse(三)', 'http://pocketcode.qiniudn.com/Mars-Java/48_开发工具之Eclipse(三).mp4'),
(119, 7, '24:40', '49_开发工具之Eclipse(四)', 'http://pocketcode.qiniudn.com/Mars-Java/49_开发工具之Eclipse(四).mp4'),
(120, 8, '61:05', '01_C语言概述', 'http://7sblu3.com1.z0.glb.clouddn.com/C-zengyi/01_C语言概述.mp4'),
(121, 8, '60:37', '02_程序的灵魂—算法', 'http://7sblu3.com1.z0.glb.clouddn.com/C-zengyi/02_程序的灵魂—算法.mp4'),
(122, 8, '40:44', '03_数据类型、运算符与表达式一', 'http://7sblu3.com1.z0.glb.clouddn.com/C-zengyi/03_数据类型、运算符与表达式一.mp4'),
(123, 8, '47:09', '04_数据类型、运算符与表达式二', 'http://7sblu3.com1.z0.glb.clouddn.com/C-zengyi/04_数据类型、运算符与表达式二.mp4'),
(124, 8, '51:43', '05_数据类型、运算符与表达式三', 'http://7sblu3.com1.z0.glb.clouddn.com/C-zengyi/05_数据类型、运算符与表达式三.mp4'),
(125, 8, '46:27', '06_数据类型、运算符与表达式四', 'http://7sblu3.com1.z0.glb.clouddn.com/C-zengyi/06_数据类型、运算符与表达式四.mp4'),
(126, 8, '48:04', '07_顺序程序设计一', 'http://7sblu3.com1.z0.glb.clouddn.com/C-zengyi/07_顺序程序设计一.mp4'),
(127, 8, '40:31', '08_顺序程序设计二', 'http://7sblu3.com1.z0.glb.clouddn.com/C-zengyi/08_顺序程序设计二.mp4'),
(128, 8, '48:25', '09_选择结构的程序设计一', 'http://7sblu3.com1.z0.glb.clouddn.com/C-zengyi/09_选择结构的程序设计一.mp4'),
(129, 8, '43:39', '10_选择结构的程序设计二', 'http://7sblu3.com1.z0.glb.clouddn.com/C-zengyi/10_选择结构的程序设计二.mp4'),
(130, 8, '45:48', '11_选择结构的程序设计三', 'http://7sblu3.com1.z0.glb.clouddn.com/C-zengyi/11_选择结构的程序设计三.mp4'),
(131, 8, '49:04', '12_循环结构程序设计一', 'http://7sblu3.com1.z0.glb.clouddn.com/C-zengyi/12_循环结构程序设计一.mp4'),
(132, 8, '49:58', '13_循环结构程序设计二', 'http://7sblu3.com1.z0.glb.clouddn.com/C-zengyi/13_循环结构程序设计二.mp4'),
(133, 8, '47:02', '14_循环结构程序设计三', 'http://7sblu3.com1.z0.glb.clouddn.com/C-zengyi/14_循环结构程序设计三.mp4'),
(134, 8, '57:09', '15_循环结构程序设计四', 'http://7sblu3.com1.z0.glb.clouddn.com/C-zengyi/15_循环结构程序设计四.mp4'),
(135, 8, '49:39', '16_数组一', 'http://7sblu3.com1.z0.glb.clouddn.com/C-zengyi/16_数组一.mp4'),
(136, 8, '49:39', '17_数组二', 'http://7sblu3.com1.z0.glb.clouddn.com/C-zengyi/17_数组二.mp4'),
(137, 8, '46:10', '18_数组三', 'http://7sblu3.com1.z0.glb.clouddn.com/C-zengyi/18_数组三.mp4'),
(138, 8, '41:42', '19_数组四', 'http://7sblu3.com1.z0.glb.clouddn.com/C-zengyi/19_数组四.mp4'),
(139, 8, '54:54', '20_数组五', 'http://7sblu3.com1.z0.glb.clouddn.com/C-zengyi/20_数组五.mp4'),
(140, 8, '53:41', '21_函数一', 'http://7sblu3.com1.z0.glb.clouddn.com/C-zengyi/21_函数一.mp4'),
(141, 8, '43:02', '22_函数二', 'http://7sblu3.com1.z0.glb.clouddn.com/C-zengyi/22_函数二.mp4'),
(142, 8, '43:01', '23_函数三', 'http://7sblu3.com1.z0.glb.clouddn.com/C-zengyi/23_函数三.mp4'),
(143, 8, '42:32', '24_指针一', 'http://7sblu3.com1.z0.glb.clouddn.com/C-zengyi/24_指针一.mp4'),
(144, 8, '45:45', '25_指针二', 'http://7sblu3.com1.z0.glb.clouddn.com/C-zengyi/25_指针二.mp4'),
(145, 8, '46:48', '26_指针三', 'http://7sblu3.com1.z0.glb.clouddn.com/C-zengyi/26_指针三.mp4'),
(146, 8, '44:15', '27_指针四', 'http://7sblu3.com1.z0.glb.clouddn.com/C-zengyi/27_指针四.mp4'),
(147, 8, '21:46', '28_结构体', 'http://7sblu3.com1.z0.glb.clouddn.com/C-zengyi/28_结构体.mp4'),
(148, 8, '57:25', '29_复习总结第一讲', 'http://7sblu3.com1.z0.glb.clouddn.com/C-zengyi/29_复习总结第一讲.mp4'),
(149, 8, '42:28', '30_复习总结第二讲', 'http://7sblu3.com1.z0.glb.clouddn.com/C-zengyi/30_复习总结第二讲.mp4');

-- --------------------------------------------------------

--
-- 表的结构 `lesson`
--

CREATE TABLE IF NOT EXISTS `lesson` (
  `lesson_id` int(100) NOT NULL AUTO_INCREMENT,
  `lesson_name` text NOT NULL,
  `lesson_time` text NOT NULL,
  `category_id` varchar(10) NOT NULL,
  `user_count` int(100) NOT NULL DEFAULT '0',
  `lesson_path` text NOT NULL,
  `lesson_desc` text NOT NULL,
  PRIMARY KEY (`lesson_id`)
) ENGINE=MyISAM  DEFAULT CHARSET=utf8 AUTO_INCREMENT=9 ;

--
-- 转存表中的数据 `lesson`
--

INSERT INTO `lesson` (`lesson_id`, `lesson_name`, `lesson_time`, `category_id`, `user_count`, `lesson_path`, `lesson_desc`) VALUES
(1, 'Android-仿微信布局', '30分钟', '2', 6, 'http://7sblu3.com1.z0.glb.clouddn.com/android_weixin.jpg', '本套课程学习使用Fragment+ViewPager模仿微信主布局的实现，本套课程由王欢icodeyou录制。你将学会Fragment和Viewpager的基本使用。'),
(2, 'Android-窃取手机短信', '35分钟', '2', 3, 'http://7sblu3.com1.z0.glb.clouddn.com/android_hackmessage.png', '分分钟教会你如何编写程序窃取Android手机上的短信，并且借助于Bmob数据库上传到服务器上，做一个简单的hacker，就是这么easy~'),
(3, 'Android入门第四季', '3小时', '2', 3, 'http://7sblu3.com1.z0.glb.clouddn.com/marsandroid4.jpg', '这是一个实战项目，逐步教会你利用腾讯微博API开发出微博应用，重点在于API的使用和Android网络编程的理解'),
(4, 'Android入门第三季', '3小时', '2', 0, 'http://7sblu3.com1.z0.glb.clouddn.com/marsandroid3.jpg', '本套课程教会你怎样进行蓝牙操作、用户定位、GoogleMap的使用，由浅入深，不过需要对前两季的课程有所掌握'),
(5, 'Android入门第二季', '3小时', '2', 2, 'http://7sblu3.com1.z0.glb.clouddn.com/marsandroid2.jpg', 'Android开发入门类课程，主要讲解常见控件、高级控件、基本动画的使用，再结合网络数据传输讲解json的概念和用法'),
(6, 'Android入门第一季', '3小时', '2', 21, 'http://7sblu3.com1.z0.glb.clouddn.com/marsandroid1.jpg', 'Android新手入门类课程，从最简单的环境搭建到四大组件、基本控件的使用，以及网络编程的概念及使用'),
(7, 'Java基础教程', '4小时', '1', 3, 'http://7sblu3.com1.z0.glb.clouddn.com/mars_java.jpg', '从最基础的Java讲起，逐步入深，带你轻松而又愉悦的走进Java开发的殿堂，为Android开发做好铺垫。'),
(8, 'C语言教程', '4小时', '4', 2, 'http://7sblu3.com1.z0.glb.clouddn.com/czengyi.png', '编程永恒的第一课，打好C语言的基础，以后学习任何一门编程语言都很容易。在本套课程中，从零起步，一直到你真正熟练掌握应用C语言。');

-- --------------------------------------------------------

--
-- 表的结构 `version`
--

CREATE TABLE IF NOT EXISTS `version` (
  `version_id` varchar(10) NOT NULL,
  `version_name` text NOT NULL,
  `version_update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `version_path` text NOT NULL,
  `version_desc` text NOT NULL,
  PRIMARY KEY (`version_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

--
-- 转存表中的数据 `version`
--

INSERT INTO `version` (`version_id`, `version_name`, `version_update_time`, `version_path`, `version_desc`) VALUES
('1', 'PocketCodeNew.apk', '2014-12-03 19:40:23', 'http://pocketcode.sinaapp.com/PocketCode.apk', '更新说明：\r\n1.加入搜索功能，课程一键直达\r\n2.加入课程分类，更清晰明了');
