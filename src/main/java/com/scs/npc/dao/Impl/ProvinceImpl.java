package com.scs.npc.dao.Impl;/*@ClassName ProvinceImpl
 *@Description:todo
 *@author yc_shang
 *@Date2020/2/21
 *@Version 1.0
 **/

import com.scs.npc.dao.Province;
import com.scs.npc.dto.ProvinceInfo;
import com.scs.npc.util.DbUtil;
import net.sf.json.JSONArray;

import java.io.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProvinceImpl implements Province {
    @Override
    public List<ProvinceInfo> selectProvinceInfo() throws SQLException {
        List<ProvinceInfo> provinceInfoList = new ArrayList<>();
        Connection connection = DbUtil.getConnection();
        String sql = "SELECT provinceName,province_confirmedCount,province_suspectedCount,province_curedCount,province_deadCount FROM t_area\n" +
                "GROUP BY provinceName";
        PreparedStatement pstmt = connection.prepareStatement(sql);
        ResultSet rs = pstmt.executeQuery();
        while (rs.next()) {
            ProvinceInfo provinceInfo = new ProvinceInfo();
            provinceInfo.setProvinceName(rs.getString("provinceName"));
            provinceInfo.setProvinceConfirmedCount(rs.getInt("province_confirmedCount"));
            provinceInfo.setProvinceSuspectedCount(rs.getInt("province_suspectedCount"));
            provinceInfo.setProvinceCuredCount(rs.getInt("province_curedCount"));
            provinceInfo.setProvinceDeadCount(rs.getInt("province_deadCount"));
            provinceInfoList.add(provinceInfo);
        }
        JSONArray provinceInfojson = JSONArray.fromObject(provinceInfoList);
        try {
            FileOutputStream fos = new FileOutputStream(new File("E:\\Java\\NCP-yiqing\\src\\main\\resources\\provinceInfo.json"));
            try {
                Writer writer = new OutputStreamWriter(fos,"UTF-8");
                try {
                    writer.write(String.valueOf(provinceInfojson));
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

        return provinceInfoList;
    }
}
