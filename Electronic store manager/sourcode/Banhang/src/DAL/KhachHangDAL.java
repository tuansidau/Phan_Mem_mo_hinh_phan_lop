/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import DTO.KhachHangDTO;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Nam
 */
public class KhachHangDAL {
    MyDBConnection conn = new MyDBConnection();
    KhachHangDTO kh;
    
    public KhachHangDAL(){};
    
    public ArrayList docKhach()
    {
        ArrayList list = new ArrayList<KhachHangDTO>();
        try
        {
            String query = "Select * from sale_customer";
            ResultSet rs = conn.executeQuery(query);
        while (rs.next())
            {
                kh = new KhachHangDTO(rs.getInt(1), rs.getString(2), rs.getString(3),
                        rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8));
                list.add(kh);
            }
        } catch(Exception e)
        {
            System.out.println("Lỗi đọc DAL");
        }
        return list;
    }
    
    public void themKhach(KhachHangDTO object)
    {
        try
        {
        String query = "INSERT INTO `tour_khachhang`"
                + "(`sale_customer`(`kh_ten`, `kh_sdt`, `kh_diachi`, `kh_email`,"
                + ",`kh_ghichu`, `kh_password`, `kh_joindate`) VALUES ('"
                + object.getKh_ten() + "','"
                + object.getKh_sdt() + "','"
                + object.getKh_dc() + "','"
                + object.getKh_email() + "','"
                + object.getKh_ghichu() + "','"
                + object.getKh_pass() + "','"
                + "2021-24-5"
                + "')";
        conn.executeUpdate(query);
        } catch(Exception e)
        {
            System.out.println("Lỗi thêm DAL");
        }
    }
    
    public void suaKhach(KhachHangDTO object)
    {
        try
        {
            String query = "UPDATE `tour_khachhang` SET "
                    + "`kh_ten`= '" + object.getKh_ten() +"',"
                    + "`kh_sdt`= '" + object.getKh_sdt() +"',"
                    + "`kh_diachi`= '" + object.getKh_dc() +"',"
                    + "`kh_email`= '" + object.getKh_email() +"',"
                    + "`kh_ghichu`= '" + object.getKh_ghichu() +"'"
                     + "`kh_password`= '" + object.getKh_pass() +"'"
                    + " WHERE kh_id = " + object.getIdkh();
            conn.executeUpdate(query);
        } catch (Exception e)
        {
            System.out.println("Lỗi sữa DAL");
        }
    }
    
    public void suaTrangthai(int id, int trangthai)
    {
        try
        {
            String query = "UPDATE `tour_khachhang` SET "
                    + "`kh_trangthai`= '" + trangthai +"'"                    
                    + " WHERE kh_id = " + id;
            conn.executeUpdate(query);
        } catch (Exception e)
        {
            System.out.println("Lỗi sữa DAL");
        }
    }
}
