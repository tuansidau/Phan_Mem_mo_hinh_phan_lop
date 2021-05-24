/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;


import DTO.loaiDTO;
import DTO.thietbiDTO;
import com.mysql.jdbc.PreparedStatement;
import java.sql.Blob;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.sql.SQLException;
import javax.sql.rowset.serial.SerialBlob;
import javax.swing.JOptionPane;


/**
 *
 * @author HOANG MINH HUY
 */
public class thietbiDAL {
    thietbiDTO tbDTO;
    String database = "project_banhang1",sp_id;
    MyDBConnection conn = new MyDBConnection();
    private ArrayList<String> dsidtb;
 //   PreparedStatement pstmt=conn.
    ResultSet rs;
    
    public thietbiDAL(){}
    
    public ArrayList<thietbiDTO> Docthietbi()
    {
       ArrayList dstb = new ArrayList<thietbiDTO>();
        try {
            String query = "SELECT * FROM `sale_product` ";
            rs = conn.executeQuery(query);
        while (rs.next()) {
             tbDTO=new thietbiDTO(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getString(4),
                     rs.getInt(5), rs.getInt(6), rs.getFloat(7));
             dstb.add(tbDTO);
                
            }
        } catch (SQLException e) 
        {
            JOptionPane.showMessageDialog(null, "Lỗi đọc DAO");
        }
       return dstb;
    }
    public ArrayList<loaiDTO> DocDsloaitb(){
        ArrayList<loaiDTO> dsloai = new ArrayList();
        try{  
            String query = "select * from sale_catalog";
            rs = conn.executeQuery(query);
            while(rs.next()){
                loaiDTO loai = new loaiDTO();
                loai.loai_id = rs.getInt("loai_id");
                loai.loai_ten = rs.getString("loai_ten");
                dsloai.add(loai);
            }
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null,"Khong doc duoc dsloai");
        }
        return dsloai;
    }
    public ArrayList<String> GetIdtb(){
        try{
            dsidtb = new ArrayList<String>();
            String query = "select sp_id from sale_product";
            rs = conn.executeQuery(query);
            while(rs.next()){
                sp_id = rs.getString("sp_id");
                dsidtb.add(sp_id);
            }
        }catch(Exception e){
             JOptionPane.showMessageDialog(null,"Không lấy được sp_id");
        }
        return dsidtb;
    }
    public void themthietbi(thietbiDTO object)  
    {
            
        try {
            String query = "INSERT INTO `sale_product`"
                    +"(`sp_ten`,`loai_id`,`sp_mota`,`sp_tonkho`,`sp_daban`,`sp_dongia`"
                    +") VALUES ('"
                    
                    +object.getSp_ten()+"','"
                    +object.getLoai_id()+"','"
                    +object.getSp_mota()+"','"
                    +object.getSp_tonkho()+"','"
                    +object.getSp_daban()+"','"
                    +object.getSp_dongia()+""
//                    +object.getSp_img()
                    
                    +"')";
                    conn.executeUpdate(query);
        } catch (Exception e) 
        {
            JOptionPane.showMessageDialog(null, "Lỗi Thêm DAO");
        }
    }
    public void suathietbi (int idtb, String ten, String mota, float dongia)
    {
//        if(tbDTO.getSp_img()!=null){
// //               Blob hinh=new SerialBlob(tbDTO.getSp_img());
//                 
//            }else{
//                Blob hinh=null;
           try{
            String query = "update sale_product set sp_ten='"+ten+"', sp_mota='"+mota+"',sp_dongia='"+dongia+"' where sp_id='"+idtb+"'";
            conn.executeUpdate(query);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Lỗi sửa DAO");
        }
        
    }
    
    public void xoathietbi(int idthietbi)
    {
        try {
            String query = "DELETE FROM `sale_product` WHERE sp_id = "+idthietbi;
            conn.executeUpdate(query);
        } catch (Exception e) {
            System.out.println("Lỗi xoá DAO");
        }
    }
    public void congTonkho(int value, int id)
    {
        try
        {
            String query = "UPDATE `sale_product` SET sp_tonkho = sp_tonkho + "+value+" WHERE sp_id = '"+id+"'";
            conn.executeUpdate(query);
        } catch(Exception e)
        {
            System.out.println(e);
            System.out.println("Lỗi cộng tồn kho");
        }
    }
    
    public void updateTonkho(int value, int id)
    {
        MyDBConnection c = new MyDBConnection();
        try
        {
            String query = "UPDATE `sale_product` SET sp_tonkho = "+value+" WHERE sp_id = '"+id+"'";
            c.executeUpdate(query);
        } catch(Exception e)
        {
            System.out.println(e);
            System.out.println("Lỗi cộng tồn kho");
        }
    }
    
     public void updateSlban(int value, int id)
    {
        MyDBConnection d = new MyDBConnection();
        try
        {
            String query = "UPDATE `sale_product` SET sp_daban = "+value+" WHERE sp_id = '"+id+"'";
            d.executeUpdate(query);
        } catch(Exception e)
        {
            System.out.println(e);
            System.out.println("Lỗi cộng tồn kho");
        }
    }
    
    public void truTonkho(int value, int id)
    {
        try
        {
            String query = "UPDATE `sale_product` SET sp_tonkho = sp_tonkho - "+value+" WHERE sp_id = '"+id+"'";
            conn.executeUpdate(query);
        } catch(Exception e)
        {
            System.out.println(e);
            System.out.println("Lỗi trừ tồn kho");
        }
    }
    public void Soluongdaban(int value, int id)
    {
        try
        {
            String query = "UPDATE `sale_product` SET sp_daban = sp_daban + "+value+" WHERE sp_id = '"+id+"'";
            conn.executeUpdate(query);
        } catch(Exception e)
        {
            System.out.println(e);
            System.out.println("Lỗi số lượng");
        }
    }
//    public boolean checkTen(String ten){
//        try{
//            String query = "SELECT * FROM `tours` WHERE tour_ten='"+ten+"'";
//            rs = conn.executeQuery(query);
//            if(rs.next()) return true;
//        }catch(Exception e){
//            //System.out.println(e);
//        }
//        return false;
//     }
}
