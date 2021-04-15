package DAL;

import DTO.ChitietTourDTO;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;

public class ChitietTourDAL {
    String database = "tour_dulich";
    MyDBConnection conn = new MyDBConnection();
    ResultSet rs;
    public ArrayList<ChitietTourDTO> dschitiet;
   
    public ChitietTourDAL(){};

    public ArrayList docDetail(){
       ArrayList<ChitietTourDTO> dschitiet = new ArrayList();
        try{
            String query = "select * from tour_chitiet";
            rs = conn.executeQuery(query);
            while(rs.next()){
                ChitietTourDTO detail = new ChitietTourDTO(rs.getInt("ct_id"),rs.getInt("tour_id"),
                        rs.getInt("ct_thutu"),rs.getInt("dd_id"));
                dschitiet.add(detail);
            } 
        }catch(SQLException e){
            System.out.println("loi doc"+e);
        }
        return dschitiet;
    }

    public boolean them(ChitietTourDTO ct){
        try{
            String query = "insert into tour_chitiet(tour_id,dd_id,ct_thutu) values ('"+ct.gettour_id()+"','"
                    +ct.getDd_id()+"','"+ct.getCt_thutu()+"')";
            MyDBConnection a = new MyDBConnection();
            a.executeUpdate(query);
        }catch(Exception e){
            System.out.println("loi them"+e);
            return false;
        }
        return true;
    }
    
    public boolean sua(ChitietTourDTO ct){
        try{   
            String query = "update tour_chitiet set dd_id='"+ct.getDd_id()+"',ct_thutu='"+ct.getCt_thutu()+"',' where ct_id='"+ct.getCt_id()+"'";
            MyDBConnection a = new MyDBConnection();
            a.executeUpdate(query);
        }catch(Exception e){
            System.out.println(e);
            return false;
        }
        return true;
    }
    
    public boolean xoa(int id){
        try{   
            String query = "DELETE FROM `tour_chitiet` WHERE tour_id = '"+id+"'";
            MyDBConnection c = new MyDBConnection();
            c.executeUpdate(query);
        }catch(Exception e){
            System.out.println(e);
            return false;
        }
        return true;
    }
}
