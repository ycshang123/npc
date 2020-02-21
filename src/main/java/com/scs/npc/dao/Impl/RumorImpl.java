package com.scs.npc.dao.Impl;/*@ClassName RumorImpl
 *@Description:todo
 *@author yc_shang
 *@Date2020/2/21
 *@Version 1.0
 **/

import com.scs.npc.dao.Rumor;
import com.scs.npc.dto.Rumors;
import com.scs.npc.util.DbUtil;
import net.sf.json.JSONArray;

import java.io.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RumorImpl implements Rumor {
    @Override
    public List<Rumors> selectRumor() throws SQLException {
        List<Rumors> rumorList = new ArrayList<>();
        Connection connection = DbUtil.getConnection();
        String sql ="SELECT rumorType,title, body,mainSummary FROM t_rumors ORDER BY rumorType ASC ";
        PreparedStatement pstmt = connection.prepareStatement(sql);
        ResultSet rs = pstmt.executeQuery();
        while (rs.next()) {
            Rumors rumors = new Rumors();
            rumors.setRumorType(rs.getString("rumorType"));
            rumors.setTitle("title");
            rumors.setBody("body");
            rumors.setMainSummary("mainSummary");
            rumorList.add(rumors);
        }
        JSONArray rumorjson = JSONArray.fromObject(rumorList);
        try {
            FileOutputStream fos = new FileOutputStream(new File("E:\\Java\\NCP-yiqing\\src\\main\\resources\\rumorInfo.json"));
            try {
                Writer writer = new OutputStreamWriter(fos,"UTF-8");
                try {
                    writer.write(String.valueOf(rumorjson));
                    writer.flush();
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } catch (UnsupportedEncodingException e) {
                System.out.println("文件写入失败");
            }
        } catch (FileNotFoundException e){
            System.out.println("文件创建失败");
        }
        return rumorList;
    }
}
