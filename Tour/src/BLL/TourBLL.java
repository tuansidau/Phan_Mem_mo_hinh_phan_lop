package BLL;


import DAL.TourDAL;
import java.util.ArrayList;
import DTO.TourDTO;
import DAL.TourDAL;
import DTO.DiadiemDTO;

public class TourBLL {
    public ArrayList<TourDTO> dstour; 
    private TourDAL data = new TourDAL();
    
    public ArrayList<TourDTO> docdsdd(){
        return dstour = data.doctour();
    }
    
    public String docten(int id){
        for(TourDTO tour : docdsdd()){
            if(tour.getTour_id()== id) return tour.getTour_ten();
        }
        return "";
    }
    
    public boolean them(TourDTO tour){        
        if (data.them(tour)){
            return true;
        }
        return false;
    }
   
    public boolean sua(TourDTO dd){
        if (data.sua(dd)){
            return true;
        }
        return false;
    }
    
    public boolean xoa(String date,int id){
        if(!data.checkDoan(date,id)){
            if(data.xoa(id)) return true;
        }
        return false;
    }
     
    public boolean checkTen(String ten){
        System.out.println("ten"+ten);
        if(data.checkTen(ten)) return true;
        return false;
    }
     
    public ArrayList<TourDTO> timkiem(String s){
        ArrayList<TourDTO> kq = new  ArrayList();
        for(TourDTO tour : docdsdd()){
            if((tour.getTour_ten().indexOf(s) != -1) || (tour.getTour_mota().indexOf(s) != -1)) kq .add(tour);
        }
        return kq;
    }
    
    
}
