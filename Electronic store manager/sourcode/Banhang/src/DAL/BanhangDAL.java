/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import DTO.KhachHangDTO;
import DTO.hoadonDTO;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author nngia
 */
public class BanhangDAL {
    MyDBConnection conn = new MyDBConnection();
    ResultSet rs;
    public BanhangDAL(){};

    public int getID(){
        try{
            int count=1;
            String query = "select * from sale_invoice";
            rs = conn.executeQuery(query);
            while(rs.next()){
                count++;
            } 
            return count;
        }catch(Exception e){
            System.out.println("loi them"+e);
            return 0;
        }
    }
    
    public boolean themHd(int idhd,String ngaylap,int idkh,String nguoinhan,String diachi,String ngaygiao,float total,String ghichu){
        try{
            String query = "insert into sale_invoice(hd_id,hd_ngaylap,kh_id,hd_nguoinhan,hd_diachi,hd_ngaygiao,hd_total,hd_ghichu,hd_status) values ('"+idhd+"','"+ngaylap+"','"
                    +idkh+"','"+nguoinhan+"','"+diachi+"','"+ngaygiao+"','"+total+"','"+ghichu+"','1')";
            conn.executeUpdate(query);
        }catch(Exception e){
            System.out.println("loi them"+e);
            return false;
        }
        return true;
    }
    
    public boolean themdetailHd(int idhd,int spid,int sl,float dongia,float thanhtien){
        try{
            String query = "insert into sale_invoicedetail(hd_id,sp_id,ct_soluong,ct_dongia,ct_thanhtien) values ('"+idhd+"','"+spid+"','"
                    +sl+"','"+dongia+"','"+thanhtien+"')";
            conn.executeUpdate(query);
        }catch(Exception e){
            System.out.println("loi them"+e);
            return false;
        }
        return true;
    }
    
    public ArrayList docHd()
    {
        hoadonDTO hd;
        ArrayList<hoadonDTO> list = new ArrayList() ; 
        try
        {
            String query = "Select * from sale_invoice";
            ResultSet rs = conn.executeQuery(query);
        while (rs.next())
            {
                hd = new hoadonDTO(rs.getInt(1), rs.getString(2), rs.getInt(3),
                        rs.getString(4), rs.getString(5), rs.getString(6), rs.getFloat(7), rs.getString(8));
                list.add(hd);
            }
        } catch(Exception e)
        {
            System.out.println("Lỗi đọc DAL");
        }
        return list;
    }
}
