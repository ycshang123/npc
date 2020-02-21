package com.scs.npc.util;/*@ClassName DbUtil
 *@Description:创建数据库
 *@author yc_shang
 *@Date2020/2/19
 *@Version 1.0
 **/

import java.sql.*;

/**
 * @author ASUS
 */
public class DbUtil {
    Connection conn = null;
    Statement stmt = null;
    ResultSet res = null;

    public static Connection getConnection() {
        Connection conn = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("数据库驱动加载失败");
        }
        //2.连接数据库
        String url = "jdbc:mysql://localhost:3306/db_npc?useUnicode=true&characterEncoding=utf8&useSSL=false&autoReconnect=true";
        String user = "root";
        String password = "root";
        try {
            conn = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            System.out.println("数据库连接失败");
        }
        return conn;
    }

    public void getCon() {
        //1.加载驱动
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("数据库驱动加载失败");
        }
        //2.连接数据库
        String url = "jdbc:mysql://localhost:3306?useUnicode=true&characterEncoding=utf8&useSSL=false&autoReconnect=true";
        String user = "root";
        String password = "root";
        try {
            conn = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            System.out.println("数据库连接失败");
        }
        //3.获取Statement对象
        assert conn != null;
        try {
            stmt = conn.createStatement();
        } catch (SQLException e) {
            System.out.println("获取Statement对象出错");
        }
    }

    public void createDatabase() {
        String sql = "CREATE DATABASE db_npc DEFAULT CHARSET utf8mb4 COLLATE utf8mb4_general_ci";
        assert stmt != null;
        try {
            stmt.executeUpdate(sql);
            System.out.println("创建库成功");
        } catch (SQLException e) {
            System.out.println("该库已存在");
        }
    }


    public void createTableArea() {
        String sql = "CREATE TABLE `t_area`  (\n" +
                "  `provinceName` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '省名',\n" +
                "  `provinceEnglishName` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '省英文名',\n" +
                "  `province_zipCode` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '省邮政编码',\n" +
                "  `cityName` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '市名称',\n" +
                "  `cityEnglishName` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '市英文名称',\n" +
                "  `city_zipCode` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '市邮政编码',\n" +
                "  `province_confirmedCount` int(11) NULL DEFAULT NULL COMMENT '省确诊病例',\n" +
                "  `province_suspectedCount` int(11) NULL DEFAULT NULL COMMENT '省疑似病例',\n" +
                "  `province_curedCount` int(11) NULL DEFAULT NULL COMMENT '省确诊病例',\n" +
                "  `province_deadCount` int(11) NULL DEFAULT NULL COMMENT '省死亡病例',\n" +
                "  `city_confirmedCount` int(11) NULL DEFAULT NULL COMMENT '市确诊病例',\n" +
                "  `city_suspectedCount` int(11) NULL DEFAULT NULL COMMENT '市疑似病例',\n" +
                "  `city_curedCount` int(11) NULL DEFAULT NULL COMMENT '市确诊病例',\n" +
                "  `city_deadCount` int(11) NULL DEFAULT NULL COMMENT '市死亡病例',\n" +
                "  `updateTime` timestamp(0) NULL DEFAULT NULL COMMENT '更新时间'\n" +
                ")";
        assert stmt != null;
        try {
            stmt.executeUpdate(sql);
            System.out.println("创建表成功");
        } catch (SQLException e) {
            System.out.println("该表已存在");
        }

    }


    public void createTableNews() {
        String sql = "CREATE TABLE `t_news`  (\n" +
                "  `_id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '_id',\n" +
                "  `id` int(11) NOT NULL COMMENT 'id',\n" +
                "  `pubDate` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '公开时间',\n" +
                "  `title` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '标题',\n" +
                "  `summary` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL COMMENT '摘要',\n" +
                "  `infoSource` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '信息源',\n" +
                "  `sourceUrl` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '来源Url',\n" +
                "  `provinceId` int(11) NULL DEFAULT NULL COMMENT '省份id',\n" +
                "  `provinceName` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '省份名称',\n" +
                "  `createTime` timestamp(0) NULL DEFAULT NULL COMMENT '创建时间',\n" +
                "  `modifyTime` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '修改时间',\n" +
                "  `entryWay` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,\n" +
                "  `adoptType` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,\n" +
                "  `infoType` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '消息类型',\n" +
                "  `dataInfoState` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,\n" +
                "  `dataInfoOperator` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,\n" +
                "  `dataInfoTime` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,\n" +
                "  `crawlTime` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '爬虫时间',\n" +
                "  `body` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL,\n" +
                "  PRIMARY KEY (`id`) USING BTREE\n" +
                ")";
        assert stmt != null;
        try {
            stmt.executeUpdate(sql);
            System.out.println("创建表成功");
        } catch (SQLException e) {
            System.out.println("该表已存在");
        }
    }

    public void createTableOverall() {
        String sql = "CREATE TABLE `t_overall`  (\n" +
                "  `_id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '_id',\n" +
                "  `infectSource` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '传染源',\n" +
                "  `passWay` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '通道',\n" +
                "  `dailyPic` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL,\n" +
                "  `dailyPics` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL,\n" +
                "  `summary` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL COMMENT '总结',\n" +
                "  `countRemark` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '言论总数',\n" +
                "  `currentConfirmedCount` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '当天确诊总数',\n" +
                "  `confirmedCount` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '确诊总数',\n" +
                "  `suspectedCount` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '疑似总数',\n" +
                "  `curedCount` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL COMMENT '确诊总数',\n" +
                "  `deadCount` varchar(255) CHARACTER SET latin1 COLLATE latin1_swedish_ci NULL DEFAULT NULL COMMENT '死亡总数',\n" +
                "  `seriousCount` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '重症总数',\n" +
                "  `suspectedIncr` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '疑似增长数',\n" +
                "  `currentConfirmedIncr` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '目前确诊增长数',\n" +
                "  `confirmedIncr` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '确诊增长数',\n" +
                "  `curedIncr` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '治愈增长数',\n" +
                "  `deadIncr` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '死亡增长数',\n" +
                "  `seriousIncr` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '严重增长数',\n" +
                "  `virus` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '病源',\n" +
                "  `remark1` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '标记1',\n" +
                "  `remark2` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '标记2',\n" +
                "  `remark3` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '标记3',\n" +
                "  `remark4` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '标记4',\n" +
                "  `remark5` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '标记5',\n" +
                "  `note1` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '备注1',\n" +
                "  `note2` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '备注2',\n" +
                "  `note3` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '备注3',\n" +
                "  `generalRemark` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL,\n" +
                "  `abroadRemark` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,\n" +
                "  `marquee` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL,\n" +
                "  `quanguoTrendChart` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL COMMENT '全国疫情发展图',\n" +
                "  `hbFeiHbTrendChart` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL COMMENT '湖北疫情发展图',\n" +
                "  `updateTime` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '更新时间'\n" +
                ")";
        assert stmt != null;
        try {
            stmt.executeUpdate(sql);
            System.out.println("创建表成功");
        } catch (SQLException e) {
            System.out.println("该表已存在");
        }
    }

    public void createTableRumors() {
        String sql = "CREATE TABLE `t_rumors`  (\n" +
                "  `_id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '_id',\n" +
                "  `body` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '主体',\n" +
                "  `id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT 'id',\n" +
                "  `mainSummary` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '主要总结',\n" +
                "  `rumorType` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '谣言类型',\n" +
                "  `sourceUrl` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '资源url',\n" +
                "  `summary` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '总结',\n" +
                "  `title` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '标题',\n" +
                "  `crawlTime` timestamp(0) NULL DEFAULT NULL COMMENT '爬虫时间'\n" +
                ")";
        assert stmt != null;
        try {
            stmt.executeUpdate(sql);
            System.out.println("创建表成功");
        } catch (SQLException e) {
            System.out.println("该表已存在");
        }
    }

    void addAreaInfo() {
        String sql = "load data infile 'D:/csv/DXYArea.csv'\n" +
                "replace into table t_area \n " +
                "fields terminated by ','\n" +
                "optionally enclosed by '\"'\n" +
                "lines terminated by '\\n'\n" +
                "ignore 1 lines";
        try {
            stmt.executeUpdate(sql);
            System.out.println("信息添加成功");
        } catch (SQLException e) {
            System.out.println("信息添加失败");
        }
    }

    void addNewsInfo() {
        String sql = "load data infile 'D:/csv/DXYNews.csv'\n" +
                "replace into table t_news \n " +
                "fields terminated by ','\n" +
                "optionally enclosed by '\"'\n" +
                "lines terminated by '\\n'\n" +
                "ignore 1 lines";
        try {
            stmt.executeUpdate(sql);
            System.out.println("信息添加成功");
        } catch (SQLException e) {
            System.out.println("信息添加失败");
        }
    }

    void addOverall() {
        String sql = "load data infile 'D:/csv/DXYOverall.csv'\n" +
                "replace into table t_overall \n " +
                "fields terminated by ','\n" +
                "optionally enclosed by '\"'\n" +
                "lines terminated by '\\n'\n" +
                "ignore 1 lines";
        try {
            stmt.executeUpdate(sql);
            System.out.println("信息添加成功");
        } catch (SQLException e) {
            System.out.println("信息添加失败");
        }
    }

    void addRumors() {
        String sql = "load data infile 'D:/csv/DXYRumors.csv'\n" +
                "replace into table t_rumors \n " +
                "fields terminated by ','\n" +
                "optionally enclosed by '\"'\n" +
                "lines terminated by '\\n'\n" +
                "ignore 1 lines";
        try {
            stmt.executeUpdate(sql);
            System.out.println("信息添加成功");
        } catch (SQLException e) {
            System.out.println("信息添加失败");
        }
    }
}
