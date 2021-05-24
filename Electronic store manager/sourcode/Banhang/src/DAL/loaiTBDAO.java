package DAL;

import DTO.loaiDTO;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
import java.util.ArrayList;

public class loaiTBDAO {
    String database = "tour_dulich";
    MyDBConnection conn = new MyDBConnection();
    ResultSet rs;
    loaiDTO loai;
    public ArrayList<loaiDTO> dsloai;
   
    public loaiTBDAO(){};

    public ArrayList docloai(){
       ArrayList<loaiDTO> dsloai = new ArrayList();
        try{
            String query = "select * from `sale_catalog`";
            rs = conn.executeQuery(query);
            while(rs.next()){
                loai = new loaiDTO(rs.getInt(1), rs.getString(2));
                        
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
