package DAL;

import DTO.GiaTourDTO;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
import java.util.ArrayList;

public class GiaTourDAL {
    String database = "tour_dulich";
    String tour_id;
    MyDBConnection conn = new MyDBConnection();
    ResultSet rs;
    public ArrayList<GiaTourDTO> dsgia;
   
    public GiaTourDAL(){};

    public ArrayList docgia(){
       ArrayList<GiaTourDTO> dsgia = new ArrayList();
        try{
            String query = "select * from tour_gia";
            rs = conn.executeQuery(query);
            while(rs.next()){
                GiaTourDTO gia = new GiaTourDTO(rs.getInt("gia_id"),rs.getInt("tour_id"),
                        rs.getDouble("gia_sotien"),rs.getString("gia_tungay"));
                dsgia.add(gia);
            } 
        }catch(SQLException e){
            System.out.println(e);
        }
        return dsgia;
    }

     public boolean them(GiaTourDTO gia){
        try{
            String query = "insert into tour_gia(gia_sotien,tour_id,gia_tungay) values ('"+gia.getGia_sotien()+"','"
                    +gia.gettour_id()+"','"+gia.getGia_ngay()+"')";
            conn.executeUpdate(query);
        }catch(Exception e){
            return false;
        }
        return true;
    }
    
    public boolean sua(GiaTourDTO gia){
        try{   
            String query = "update tour_gia set gia_tungay='"+gia.getGia_ngay()+"',gia_sotien='"+gia.getGia_sotien()+"' where gia_id='"+gia.getGia_id()+"'";
            conn.executeUpdate(query);
        }catch(Exception e){
            System.out.println(e);
            return false;
        }
        return true;
    }
    
    public boolean xoa(int id){
        try{   
            String query = "DELETE FROM `tour_diadiem` WHERE dd_id = '"+id+"'";
            conn.executeUpdate(query);
        }catch(Exception e){
            //System.out.println(e);
            return false;
        }
        return true;
    }
}
