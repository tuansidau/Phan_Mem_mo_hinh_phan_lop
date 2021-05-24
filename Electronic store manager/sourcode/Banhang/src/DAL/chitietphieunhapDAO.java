/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import java.sql.ResultSet;
import java.util.ArrayList;
import DTO.chitietphieunhapDTO;
import DTO.phieunhapDTO;

import static javax.swing.UIManager.getString;
/**
 *
 * @author MY PC
 */
public class chitietphieunhapDAO 
{
    MyDBConnection conn = new MyDBConnection();
    public static ArrayList<chitietphieunhapDTO> dschitietDAO;
    public chitietphieunhapDAO() 
    {
        
    }  
    public ArrayList docChitiet1(String ctpn)
            //ham lay thong in user
    {
        dschitietDAO = new ArrayList<chitietphieunhapDTO>();
        try
        {
            String query = "Select * from `sale_storagedetail` where pn_id='"+ctpn+"'";
//            String query1 = "SELECT * FROM `chitietgiam` INNER JOIN "
//                    + "monan ON chitietgiam.idmon = monan.idmon WHERE chitietgiam.idgiam ='"+ctg.getIdGiam()+"'";
            ResultSet rs = conn.executeQuery(query);//thuc thi truy van
        while (rs.next())
            {
                //System.out.println(rs.getString(1)+" "+rs.getString(2));
                chitietphieunhapDTO dto = new chitietphieunhapDTO();
                dto.setPn_id(rs.getInt("pn_id"));//ghi du lieu tu databse vao DTO
                dto.setSp_id(rs.getInt("sp_id"));//ghi du lieu tu databse vao DTO
                dto.setCt_soluong(rs.getInt("ct_soluong"));
                
                
                dschitietDAO.add(dto);//them DTO vao array cua DAO
            }
        } catch(Exception e)
        {
            System.out.println(e);
        }
        return dschitietDAO;
    }
    public ArrayList docChitiet()
            //ham lay thong in user
    {
        ArrayList dschitiet = new ArrayList<chitietphieunhapDTO>();
        try
        {
            String query = "Select * from `sale_storagedetail`";
            ResultSet rs = conn.executeQuery(query);//thuc thi truy van
        while (rs.next())
            {
                //System.out.println(rs.getString(1)+" "+rs.getString(2));
                chitietphieunhapDTO dto = new chitietphieunhapDTO();
                dto.setPn_id(rs.getInt("pn_id"));//ghi du lieu tu databse vao DTO
                dto.setSp_id(rs.getInt("sp_id"));//ghi du lieu tu databse vao DTO
                dto.setCt_soluong(rs.getInt("ct_soluong"));
                dschitiet.add(dto);//them DTO vao array cua DAO
            }
        } catch(Exception e)
        {
            System.out.println(e);
        }
        return dschitiet;
    }
    
   public void themchitiet(chitietphieunhapDTO object)
    {
        try
        {
        String query = "INSERT INTO `sale_storagedetail`"
                + "(`pn_id`,`sp_id`, `ct_soluong`"
                + ") VALUES ('"
                + object.getPn_id()+ "','"
                + object.getSp_id()+ "','"
                + object.getCt_soluong()              
                + "')";
        conn.executeUpdate(query);
        } catch(Exception e)
        {
            System.out.println("Lỗi thêm DAL");
        }
    }
}
