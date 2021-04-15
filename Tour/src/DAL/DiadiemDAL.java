package DAL;

import DTO.DiadiemDTO;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
import java.util.ArrayList;

public class DiadiemDAL {
    String database = "tour_dulich";
    String tour_id;
    MyDBConnection conn = new MyDBConnection();
    ResultSet rs;
   
    public DiadiemDAL(){};

    public ArrayList<DiadiemDTO> docDsdd(){
       ArrayList<DiadiemDTO> dsdiadiem = new ArrayList();
        try{
            String query = "select * from tour_diadiem";
            rs = conn.executeQuery(query);
            while(rs.next()){
                DiadiemDTO dd = new DiadiemDTO(rs.getInt("dd_id"),rs.getString("dd_thanhpho"),
                        rs.getString("dd_ten"),rs.getString("dd_mota"));
                dsdiadiem.add(dd);
            } 
        }catch(SQLException e){
            //System.out.println(e);
        }
        return dsdiadiem;
    }
    
    public boolean them(DiadiemDTO dd){
        try{
            String query = "insert into tour_diadiem(dd_thanhpho,dd_ten,dd_mota) values ('"+dd.getDd_tp()+"','"
                    +dd.getDd_ten()+"','"+dd.getMota()+"')";
            conn.executeUpdate(query);
        }catch(Exception e){
            return false;
        }
        return true;
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
    
    public boolean sua(DiadiemDTO dd){
        try{   
            String query = "update tour_diadiem set dd_thanhpho='"+dd.getDd_tp()+"',dd_ten='"+dd.getDd_ten()+"',dd_mota='"+dd.getMota()
                    +"'where dd_id='"+dd.getDd_id()+"'";
            conn.executeUpdate(query);
        }catch(Exception e){
            //System.out.println(e);
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
