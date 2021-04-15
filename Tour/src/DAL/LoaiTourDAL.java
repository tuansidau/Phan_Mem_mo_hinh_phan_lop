package DAL;

import DTO.LoaiTourDTO;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
import java.util.ArrayList;

public class LoaiTourDAL {
    String database = "tour_dulich";
    MyDBConnection conn = new MyDBConnection();
    ResultSet rs;
    public ArrayList<LoaiTourDTO> dsloai;
   
    public LoaiTourDAL(){};

    public ArrayList docloai(){
       ArrayList<LoaiTourDTO> dsloai = new ArrayList();
        try{
            String query = "select * from tour_loai";
            rs = conn.executeQuery(query);
            while(rs.next()){
                LoaiTourDTO loai = new LoaiTourDTO(rs.getInt("loai_id"),rs.getString("loai_ten"),
                        rs.getString("loai_mota"));
                dsloai.add(loai);
            } 
        }catch(SQLException e){
            System.out.println(e);
        }
                System.out.println(dsloai.size());
        return dsloai;

    }
     /*public boolean them(LoaiTourDTO dd){
        try{
            String query = "insert into tour_diadiem(dd_thanhpho,dd_ten,dd_mota) values ('"+dd.getDd_ten()+"','"
                    +dd.getDd_tp()+"','"+dd.getMota()+"')";
            conn.executeUpdate(query);
        }catch(Exception e){
            return false;
        }
        return true;
    }
    
    public boolean sua(LoaiTourDTO dd){
        try{   
            String query = "update tour_diadiem set dd_thanhpho='"+dd.getDd_tp()+"',dd_ten='"+dd.getDd_ten()+"',dd_mota='"+dd.getMota()
                    +"'where dd_id='"+dd.getDd_id()+"'";
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
            System.out.println(e);
            return false;
        }
        return true;
    }*/
}
