package com.scs.npc.dao;/*@ClassName News
 *@Description:todo
 *@author yc_shang
 *@Date2020/2/21
 *@Version 1.0
 **/

import com.scs.npc.dto.New;

import java.sql.SQLException;
import java.util.List;

public interface News {
    List<New> selectNews() throws SQLException;
}
