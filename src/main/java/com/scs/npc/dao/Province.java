package com.scs.npc.dao;/*@ClassName Province
 *@Description:todo
 *@author yc_shang
 *@Date2020/2/21
 *@Version 1.0
 **/

import com.scs.npc.dto.ProvinceInfo;

import java.sql.SQLException;
import java.util.List;

public interface Province {
    List<ProvinceInfo> selectProvinceInfo() throws SQLException;
}
