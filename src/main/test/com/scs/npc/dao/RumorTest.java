package com.scs.npc.dao;

import com.scs.npc.dto.Rumors;
import com.scs.npc.factory.DaoFactory;
import org.junit.Test;

import java.sql.SQLException;
import java.util.List;


public class RumorTest {
private  Rumor rumor = DaoFactory.getRumorInstance();
    @Test
    public void selectRumor() throws SQLException {

        List<Rumors> rumorsList =rumor.selectRumor();
        System.out.println(rumorsList.size());
    }
}