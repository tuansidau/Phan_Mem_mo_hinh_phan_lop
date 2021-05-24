package DAL;

import DTO.SanphamDTO;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
import java.util.ArrayList;

public class SanphamDAL {
     String database = "project_banhang";
    String tour_id;
    MyDBConnection conn = new MyDBConnection();
    ResultSet rs;
   
    public SanphamDAL(){};

    public ArrayList<SanphamDTO> docDssp(){
       ArrayList<SanphamDTO> dssp = new ArrayList();
        try{
            String query = "SELECT * FROM `sale_product`";
            rs = conn.executeQuery(query);
            while(rs.next()){
                SanphamDTO sp = new SanphamDTO(rs.getInt("sp_id"),rs.getString("sp_ten"),rs.getInt("loai_id"),rs.getString("mo_ta"),
                        rs.getInt("sp_tonkho"),rs.getInt("sp_daban"),rs.getDouble("sp_dongia"));
                dssp.add(sp);
            } 
        }catch(SQLException e){
            //System.out.println(e);
        }
        System.out.println(dssp.size());
        return dssp;
    }

    public boolean checkTour(int id){
        try{
            String query = "SELECT * FROM `tour_chitiet` where tour_chitiet.dd_id ='"+id+"'";
            rs = conn.executeQuery(query);
            if(rs.next()) return true;
        }catch(Exception e){
            //System.out.println(e);
        }
        return false;
    }
    
    public String getTen(int id){
        try{
            String query = "select dd_ten from tour_diadiem where dd_id='"+id+"'";
            rs = conn.executeQuery(query);
            if(rs.next()){
                return rs.getString("dd_ten");
            }
        }catch(Exception e){
            //System.out.println(e);
        }
        return "Lỗi";
    }
    
    public int getId(String ten){
        try{
            String query = "select * from tour_diadiem where dd_ten='"+ten+"'";
            rs = conn.executeQuery(query);
            if(rs.next()){
                return rs.getInt("dd_id");
            }
        }catch(Exception e){
            //System.out.println(e);
        }
        return -1;
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
