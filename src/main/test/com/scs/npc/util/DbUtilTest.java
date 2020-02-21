package com.scs.npc.util;

import org.junit.Test;

import java.sql.SQLException;

public class DbUtilTest {




    @Test
    public void createDatabase() throws SQLException {
        DbUtil dbUtil = new DbUtil();
        dbUtil.getCon();
        dbUtil.createDatabase();
    }

    @Test
    public void createTableArea() throws SQLException{
        DbUtil dbUtil = new DbUtil();
        dbUtil.getCon();
        dbUtil.createTableArea();
    }

    @Test
    public void createTableNews() throws SQLException{
        DbUtil dbUtil = new DbUtil();
        dbUtil.getCon();
        dbUtil.createTableNews();
    }

    @Test
    public void createTableOverall() throws SQLException {
        DbUtil dbUtil = new DbUtil();
        dbUtil.getCon();
        dbUtil.createTableOverall();
    }

    @Test
    public void createTableRumors() throws SQLException{
        DbUtil dbUtil = new DbUtil();
        dbUtil.getCon();
        dbUtil.createTableRumors();

    }


    @Test
    public void addAreaInfo() throws SQLException {
        DbUtil dbUtil = new DbUtil();
        dbUtil.getCon();
        dbUtil.addAreaInfo();









    }

    @Test
    public void getCon() throws SQLException {
        DbUtil dbUtil = new DbUtil();
        dbUtil.getCon();
    }
}