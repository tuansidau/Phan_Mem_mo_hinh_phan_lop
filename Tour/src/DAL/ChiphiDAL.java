/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import DTO.ChiphiDTO;
import DTO.LoaichiphiDTO;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Nam
 */
public class ChiphiDAL {
    MyDBConnection conn = new MyDBConnection();
    ChiphiDTO chiphi;
    LoaichiphiDTO loaichiphi;
    
    public ArrayList docChiphi()
    {
        ArrayList list = new ArrayList<ChiphiDTO>();
        try
        {
            String query = "Select * from tour_chiphi";
            ResultSet rs = conn.executeQuery(query);
        while (rs.next())
            {
                chiphi = new ChiphiDTO(rs.getInt(1), rs.getDouble(3), rs.getString(4), rs.getInt(2));
                list.add(chiphi);
            }
        } catch(Exception e)
        {
            System.out.println("Lỗi đọc DAL");
        }
        return list;
    }
    
    public ArrayList docLoaichiphi()
    {
        ArrayList list = new ArrayList<LoaichiphiDTO>();
        try
        {
            String query = "Select * from tour_loaichiphi";
            ResultSet rs = conn.executeQuery(query);
        while (rs.next())
            {
                loaichiphi = new LoaichiphiDTO(rs.getInt(1), rs.getString(2), rs.getString(3));
                list.add(loaichiphi);
            }
        } catch(Exception e)
        {
            System.out.println("Lỗi đọc DAL");
        }
        return list;
    }
    
    public void themChiphi(ChiphiDTO object)
    {
        try
        {
        String query = "INSERT INTO `tour_chiphi`"
                + "(`doan_id`, `chiphi_total`, `chiphi_chitiet`) VALUES ('"
                + object.getDoan_id() + "','"
                + object.getChiphi_total() + "','"
                + object.getChiphi_chitiet()
                + "')";
        conn.executeUpdate(query);
        } catch(Exception e)
        {
            System.out.println("Lỗi thêm DAL");
        }
    }
    public void suaChiphi(ChiphiDTO object)
    {
        try
        {
            String query = "UPDATE `tour_chiphi` SET "
                    + "`chiphi_total`= '" + object.getChiphi_total()+"',"
                    + "`chiphi_chitiet`= '" + object.getChiphi_chitiet()
                    + "' WHERE doan_id = " + object.getDoan_id();
            conn.executeUpdate(query);
        } catch (Exception e)
        {
            System.out.println("Lỗi sữa DAL");
        }
    }
}
