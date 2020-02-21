package com.scs.npc.factory;/*@ClassName DaoFactory
 *@Description:todo
 *@author yc_shang
 *@Date2020/2/21
 *@Version 1.0
 **/

import com.scs.npc.dao.Impl.NewsImpl;
import com.scs.npc.dao.Impl.ProvinceImpl;
import com.scs.npc.dao.Impl.RumorImpl;
import com.scs.npc.dao.News;
import com.scs.npc.dao.Province;
import com.scs.npc.dao.Rumor;

public class DaoFactory {
    public static Province getProvinceInstance(){
        return new ProvinceImpl();
    }
    public static Rumor getRumorInstance(){
        return new RumorImpl();
    }
    public static News getNewsInstance(){
        return new NewsImpl();
    }
}
