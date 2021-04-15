package DAL;

import DTO.TourDTO;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
import java.util.ArrayList;

public class TourDAL {
    String database = "tour_dulich";
    String tour_id;
    
    ResultSet rs;
    public ArrayList<TourDTO> dstour;
   MyDBConnection conn = new MyDBConnection();
    public TourDAL(){};

    public ArrayList doctour(){
       ArrayList<TourDTO> dstour = new ArrayList();
       
        try{
            String query = "select * from tours";
            rs = conn.executeQuery(query);
            while(rs.next()){
                TourDTO tour = new TourDTO(rs.getInt("tour_id"),rs.getString("tour_ten"),
                        rs.getString("tour_mota"),rs.getInt("loai_id"));
                dstour.add(tour);
            } 
        }catch(SQLException e){
            System.out.println("loi doc "+ e);
        }
        return dstour;
    }
   
     public boolean them(TourDTO tour){
        try{
            MyDBConnection conn = new MyDBConnection();
            String query = "insert into tours(tour_id,tour_ten,tour_mota,loai_id) values ('"+tour.getTour_id()+"','"+tour.getTour_ten()+"','"
                    +tour.getTour_mota()+"','"+tour.getLoai_id()+"')";
            conn.executeUpdate(query);
        }catch(Exception e){
            System.out.println("loi them"+ e);
            return false;
        }
        return true;
    }
    
     public boolean checkTen(String ten){
        try{
            String query = "SELECT * FROM `tours` WHERE tour_ten='"+ten+"'";
            rs = conn.executeQuery(query);
            if(rs.next()) return true;
        }catch(Exception e){
            //System.out.println(e);
        }
        return false;
     }
     
    public boolean sua(TourDTO tour){
        MyDBConnection conn = new MyDBConnection();
        try{   
            String query = "update tours set tour_ten='"+tour.getTour_ten()+"',tour_mota='"+tour.getTour_mota()+"',"
                    + "loai_id='"+tour.getLoai_id()+"'where tour_id='"+tour.getTour_id()+"'";
            conn.executeUpdate(query);
        }catch(Exception e){
            System.out.println(e);
            return false;
        }
        return true;
    }
    
    public boolean checkDoan(String date,int id){
        try {
            String query = "SELECT * FROM `tour_doan` WHERE tour_doan.doan_ngayve >= '"+date+"' AND tour_doan.tour_id='"+id+"'";
            rs = conn.executeQuery(query);
            if(rs.next()) return true;
        }catch(Exception e){
            System.out.println(e);
        }
        return false;
    }
    
    public boolean xoa(int id){
        try{   
            String query = "DELETE FROM `tours` WHERE tour_id = '"+id+"'";
            conn.executeUpdate(query);
        }catch(Exception e){
            System.out.println("loi xoa"+e);
            return false;
        }
        return true;
    }
}
