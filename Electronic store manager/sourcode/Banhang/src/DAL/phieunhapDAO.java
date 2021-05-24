/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;


import DTO.phieunhapDTO;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import static javax.swing.UIManager.getString;

/**
 *
 * @author MY PC
 */
public class phieunhapDAO 
{
    MyDBConnection conn = new MyDBConnection();
    public static ArrayList dspn123 ;
    public phieunhapDAO() 
    {
        
    }
    
    public ArrayList<String> getIdphieunhap(){
        ArrayList<String> dsidpn = new ArrayList();
        try{
            String query = "select pn_id from sale_storage";
            ResultSet rs = conn.executeQuery(query);
            while(rs.next()){
                String pn_id = rs.getString("pn_id");
                dsidpn.add(pn_id);
            }
        }catch(Exception e){
            System.out.println(e);
            System.out.println("Khong doc duoc idpn");
        }
        return dsidpn;
    }
//    public ArrayList<phieunhapDTO> DocPhieunhap(){
//        ArrayList dspn = new ArrayList<phieunhapDTO>();
//        try{
//            String query = "select * from sale_storage inner join sale_storagedetail on sale_storage.pn_id = sale_storage.pn_id";
//            ResultSet rs = conn.executeQuery(query);
//            while (rs.next()){
//                phieunhapDTO pn = new phieunhapDTO();
//                
//                pn.setPn_id(rs.getInt("pn_id"));
//                pn.setPn_ngaylap(rs.getString("pn_ngaylap"));
//                
//                dspn.add(pn);
//                System.out.println(dspn);
//            }
//        }catch(Exception e){
//            JOptionPane.showMessageDialog(null,"khong doc duoc ds sp");
//        }
//        return dspn;
//    }
    public ArrayList docphieunhap()
            //ham lay thong in user
    {
        ArrayList dspn = new ArrayList<phieunhapDTO>();
        try
        {
            String query = "SELECT `pn_id`, `pn_ngaylap` FROM `sale_storage`";
            ResultSet rs = conn.executeQuery(query);//thuc thi truy van
        while (rs.next())
            {
                //System.out.println(rs.getString(1)+" "+rs.getString(2));
                phieunhapDTO pndto = new phieunhapDTO(rs.getInt(1), rs.getString(2));
               
                dspn.add(pndto);//them DTO vao array cua DAO
            }
        } catch(Exception e)
        {
            System.out.println(e);
        }
        return dspn;
    }
//    public ArrayList docphieunhap(String id)
//            //ham lay thong in user
//    {
//        dspn123 = new ArrayList<phieunhapDTO>();
//        try
//        {
//            String query = "SELECT `idpn`, `idncc`, `idnv`, `ngaynhap`, `tongtien`, `trangthai` FROM `phieunhap` "
//                    + "where idnv='"+id+"'";
//            ResultSet rs = conn.executeQuery(query);//thuc thi truy van
//        while (rs.next())
//            {
//                //System.out.println(rs.getString(1)+" "+rs.getString(2));
//                phieunhapDTO pndto = new phieunhapDTO();
//                pndto.setIdpn(rs.getString(1));//ghi du lieu tu databse vao DTO
//                pndto.setIdncc(rs.getString(2));
//                pndto.setIdnv(rs.getString(3));
//                pndto.setNgaynhap(rs.getString(4));
//                pndto.setTongtien(rs.getFloat(5));
//                pndto.setTrangthai(Integer.toString(rs.getInt(6)));
//                dspn123.add(pndto);//them DTO vao array cua DAO
//            }
//        } catch(Exception e)
//        {
//            System.out.println(e);
//        }
//        return dspn123;
//    }
    
    public void themphieunhap(phieunhapDTO pn)
    {
        try
        {
        String query = "INSERT INTO `sale_storage` VALUES ("
                + "'" +pn.getPn_id()+ "',"
                + "'" +pn.getPn_ngaylap()+ "');";
        conn.executeUpdate(query);
        } catch(Exception e)
        {
            System.out.println(e);
        }
    }
    
    public void suaphieunhap(phieunhapDTO pn)
    {
        try
        {
            String query = "UPDATE `sale_storage` SET "
                    +"pn_ngaylap="+"'"+pn.getPn_ngaylap()
                    +"' where pn_id='"+pn.getPn_id()+"'";
            conn.executeUpdate(query);
        } catch (Exception e)
        {
            System.out.println("Lỗi sữa phiếu nhập");
        }
    }
    
    public void xoaphieunhap(int pn)
    {
        try
        {
            String query = "delete from sale_storage where pn_id='"+pn+"'";
            conn.executeUpdate(query);
        } catch (Exception e)
        {
            System.out.println("Lỗi xoa");
        }
    }
    

}
