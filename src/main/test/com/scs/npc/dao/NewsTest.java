package com.scs.npc.dao;

import com.scs.npc.dto.New;
import com.scs.npc.factory.DaoFactory;
import org.junit.Test;

import java.sql.SQLException;
import java.util.List;

import static org.junit.Assert.*;

public class NewsTest {
private  News news = DaoFactory.getNewsInstance();
    @Test
    public void selectNews() throws SQLException {
        List<New> newList = news.selectNews();
        System.out.println(newList.size());
    }
}