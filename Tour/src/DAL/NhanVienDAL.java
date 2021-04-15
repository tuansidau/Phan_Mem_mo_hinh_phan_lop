/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import DTO.NhanvienDTO;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Nam
 */
public class NhanVienDAL {
    MyDBConnection conn = new MyDBConnection();
    NhanvienDTO nv;
    
    public NhanVienDAL(){};
    
    public ArrayList docNhanvien()
    {
        ArrayList list = new ArrayList<NhanvienDTO>();
        try
        {
            String query = "Select * from tour_nhanvien";
            ResultSet rs = conn.executeQuery(query);
        while (rs.next())
            {
                nv = new NhanvienDTO(rs.getInt(1), rs.getString(2), rs.getString(3),
                        rs.getString(4), rs.getString(5), rs.getString(6), rs.getInt(7));
                list.add(nv);
            }
        } catch(Exception e)
        {
            System.out.println(e);
            System.out.println("Lỗi đọc DAL");
        } 
        return list;
    }
    
    public void themNhanvien(NhanvienDTO object)
    {
        try
        {
        String query = "INSERT INTO `tour_nhanvien`"
                + "(`nv_ten`, `nv_sdt`, `nv_ngaysinh`, `nv_email`, `nv_nhiemvu`, `nv_trangthai`) VALUES ('"
                + object.getNv_ten()+ "','"
                + object.getNv_sdt()+ "','"
                + object.getNv_ngaysinh()+ "','"
                + object.getNv_email()+ "','"
                + object.getNv_nhiemvu()+ "','"
                + "0"
                + "')";
        conn.executeUpdate(query);
        } catch(Exception e)
        {
            System.out.println("Lỗi thêm DAL");
        }
    }
    
    public void suaNhanvien(NhanvienDTO object)
    {
        try
        {
            String query = "UPDATE `tour_nhanvien` SET "
                    + "`nv_ten`= '" + object.getNv_ten() +"',"
                    + "`nv_sdt`= '" + object.getNv_sdt() +"',"
                    + "`nv_ngaysinh`= '" + object.getNv_ngaysinh() +"',"
                    + "`nv_email`= '" + object.getNv_email() +"',"
                    + "`nv_nhiemvu`= '" + object.getNv_nhiemvu() +"'"                    
                    + " WHERE nv_id = " + object.getNv_id();
            conn.executeUpdate(query);
        } catch (Exception e)
        {
            System.out.println("Lỗi sữa DAL");
        }
    }
    
    public void xoaNhanvien(int id)
    {
        try
        {
            String query = "DELETE FROM `tour_nhanvien` WHERE nv_id = " + id;
            conn.executeUpdate(query);
        } catch (Exception e)
        {
            System.out.println("Lỗi xóa DAL");
        }
    }
    public void suaTrangthai(int id, int trangthai)
    {
        try
        {
            String query = "UPDATE `tour_nhanvien` SET "
                    + "`nv_trangthai`= '" + trangthai +"'"                    
                    + " WHERE nv_id = " + id;
            conn.executeUpdate(query);
        } catch (Exception e)
        {
            System.out.println("Lỗi sữa DAL");
        }
    }
}
