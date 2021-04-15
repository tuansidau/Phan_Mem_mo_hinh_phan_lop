/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import DTO.NhiemvuDTO;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Nam
 */
public class NhiemvuDAL {
    MyDBConnection conn = new MyDBConnection();
    NhiemvuDTO nv;
    
    public NhiemvuDAL(){};
    
    public ArrayList docNhiemvu()
    {
        ArrayList list = new ArrayList<NhiemvuDTO>();
        try
        {
            String query = "Select * from tour_nhiemvu";
            ResultSet rs = conn.executeQuery(query);
        while (rs.next())
            {
                nv = new NhiemvuDTO(rs.getInt(1), rs.getString(2));
                list.add(nv);
            }
        } catch(Exception e)
        {
            System.out.println(e);
            System.out.println("Lỗi đọc DAL");
        } 
        return list;
    }
}
