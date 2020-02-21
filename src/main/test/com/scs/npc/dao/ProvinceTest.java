package com.scs.npc.dao;

import com.scs.npc.dto.ProvinceInfo;
import com.scs.npc.factory.DaoFactory;
import org.junit.Test;

import java.sql.SQLException;
import java.util.List;

public class ProvinceTest {
private Province province = DaoFactory.getProvinceInstance();
    @Test
    public void selectProvinceInfo() throws SQLException {
        List<ProvinceInfo> provinceInfoList = province.selectProvinceInfo();
        System.out.println(provinceInfoList.size());
    }
}