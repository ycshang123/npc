package com.scs.npc.dao;/*@ClassName Rumor
 *@Description:todo
 *@author yc_shang
 *@Date2020/2/21
 *@Version 1.0
 **/

import com.scs.npc.dto.Rumors;

import java.sql.SQLException;
import java.util.List;

public interface Rumor {
    List<Rumors> selectRumor() throws SQLException;
}
