/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import DTO.DoanDTO;
import DTO.NguoidiDTO;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Nam
 */
public class DoanDAL {
    MyDBConnection conn = new MyDBConnection();
    DoanDTO doan;
    NguoidiDTO nguoidi;
    
    public ArrayList docDoan()
    {
        ArrayList list = new ArrayList<DoanDTO>();
        try
        {
            String query = "Select * from tour_doan";
            ResultSet rs = conn.executeQuery(query);
        while (rs.next())
            {
                doan = new DoanDTO(rs.getInt(1), rs.getInt(2), rs.getInt(3),
                        rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getBoolean(8));
                list.add(doan);
            }
        } catch(Exception e)
        {
            System.out.println("Lỗi đọc DAL");
        }
        return list;
    }
    
    public ArrayList docNguoidi()
    {
        ArrayList list = new ArrayList<DoanDTO>();
        try
        {
            String query = "Select * from tour_nguoidi";
            ResultSet rs = conn.executeQuery(query);
        while (rs.next())
            {
                nguoidi = new NguoidiDTO(rs.getInt(1), rs.getString(3), rs.getString(4), rs.getInt(2));
                list.add(nguoidi);
            }
        } catch(Exception e)
        {
            System.out.println("Lỗi đọc DAL");
        }
        return list;
    }
    
    public void themDoan(DoanDTO object)
    {
        try
        {
        String query = "INSERT INTO `tour_doan`"
                + "(`doan_id`,`doan_name`, `tour_id`, `gia_id`, `doan_ngaydi`, `doan_ngayve`"
                + ", `doan_chitietchuongtrinh`, `doan_tinhtrang`) VALUES ('"
                + object.getDoan_id()+ "','"
                + object.getDoan_ten()+ "','"
                + object.getTour_id() + "','"
                + object.getGia_id() + "','"
                + object.getDoan_ngaydi() + "','"
                + object.getDoan_ngayve() + "','"
                + object.getDoan_chitiet() + "','"
                + "0"
                + "')";
        conn.executeUpdate(query);
        } catch(Exception e)
        {
            System.out.println("Lỗi thêm DAL");
        }
    }
    
    public void themNguoidi(NguoidiDTO object)
    {
        try
        {
        String query = "INSERT INTO `tour_nguoidi`"
                + "(`doan_id`, `nguoidi_dsnhanvien`, `nguoidi_dskhach`) VALUES ('"
                + object.getDoan_id()+ "','"
                + object.getNguoidi_dsnhanvien()+ "','"
                + object.getNguoidi_dskhach()
                + "')";
        conn.executeUpdate(query);
        } catch(Exception e)
        {
            System.out.println("Lỗi thêm DAL");
        }
    }
    public void suaDoan(DoanDTO object)
    {
        try
        {
            String query = "UPDATE `tour_doan` SET "
                    + "`doan_name`= '" + object.getDoan_ten() +"',"
                    + "`doan_ngaydi`= '" + object.getDoan_ngaydi() +"',"
                    + "`doan_ngayve`= '" + object.getDoan_ngayve() +"',"
                    + "`doan_chitietchuongtrinh`= '" + object.getDoan_chitiet() +"',"
                    + "`tour_id`= '" + object.getTour_id()+"',"
                    + "`gia_id`= '" + object.getGia_id()+"'"
                    + " WHERE doan_id = " + object.getDoan_id();
            conn.executeUpdate(query);
        } catch (Exception e)
        {
            System.out.println("Lỗi sữa DAL");
        }
    }
    
    public void suaNguoidi(NguoidiDTO object)
    {
        try
        {
            String query = "UPDATE `tour_nguoidi` SET "
                    + "`nguoidi_dsnhanvien`= '" + object.getNguoidi_dsnhanvien()+"',"
                    + "`nguoidi_dskhach`= '" + object.getNguoidi_dskhach()
                    + "' WHERE doan_id = " + object.getDoan_id();
            conn.executeUpdate(query);
        } catch (Exception e)
        {
            System.out.println("Lỗi sữa DAL");
        }
    }
    
    public void suaTrangthai(int id)
    {
        try
        {
            String query = "UPDATE `tour_doan` SET "
                    + "`doan_tinhtrang`= " + 1
                    + " WHERE doan_id = " + id;
            conn.executeUpdate(query);
        } catch (Exception e)
        {
            System.out.println("Lỗi sữa DAL");
        }
    }
    public void xoaDoan(int id)
    {
        try
        {
            String query = "DELETE FROM `tour_doan` WHERE doan_id = " + id;
            conn.executeUpdate(query);
        } catch (Exception e)
        {
            System.out.println("Lỗi xóa DAL");
        }
    }
}
