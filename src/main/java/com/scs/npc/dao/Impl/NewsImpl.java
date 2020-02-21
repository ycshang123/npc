package com.scs.npc.dao.Impl;/*@ClassName NewsImpl
 *@Description:todo
 *@author yc_shang
 *@Date2020/2/21
 *@Version 1.0
 **/

import com.scs.npc.dao.News;
import com.scs.npc.dto.New;
import com.scs.npc.util.DbUtil;
import net.sf.json.JSONArray;

import java.io.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class NewsImpl implements News {
    @Override
    public List<New> selectNews() throws SQLException {
        List<New> newList = new ArrayList<>();
        Connection connection = DbUtil.getConnection();
        String sql ="SELECT provinceId,title,summary,infoSource,sourceUrl,provinceName FROM t_news ORDER BY provinceId;";
        PreparedStatement pstmt = connection.prepareStatement(sql);
        ResultSet rs = pstmt.executeQuery();
        while (rs.next()) {
            New news = new New();
           news.setProvinceId(rs.getInt("provinceId"));
           news.setTitle(rs.getString("title"));
           news.setSummary(rs.getString("summary"));
           news.setInfoSource(rs.getString("infoSource"));
           news.setSourceUrl(rs.getString("sourceUrl"));
           news.setProvinceName(rs.getString("provinceName"));
           newList.add(news);
        }
        JSONArray newjson = JSONArray.fromObject(newList);
        try {
            FileOutputStream fos = new FileOutputStream(new File("E:\\Java\\NCP-yiqing\\src\\main\\resources\\newInfo.json"));
            try {
                Writer writer = new OutputStreamWriter(fos,"UTF-8");
                try {
                    writer.write(String.valueOf(newjson));
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
        return newList;
    }
}
