/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import DAL.thietbiDAL;
import DTO.loaiDTO;
import DTO.thietbiDTO;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author HOANG MINH HUY
 */
public class thietbiBus {
    private String sp_id;
    private int max;
    public static ArrayList<loaiDTO> dsloaitb;
    public static ArrayList<thietbiDTO> sumArrtb;
    private ArrayList<String> dsidtb;
    public thietbiDTO tbDTO;
    thietbiDAL tbDAO = new thietbiDAL();
    public thietbiBus(){
        sumArrtb = new ArrayList<>();
    }
    public void docThietbi(){
        sumArrtb=tbDAO.Docthietbi();
    }
    public void docDsloai(){
        thietbiDAL data = new thietbiDAL();
        dsloaitb = new ArrayList<loaiDTO>();
        dsloaitb = data.DocDsloaitb();
    }


    public void themThietbi(thietbiDTO object) {
        sumArrtb.add(object);
        tbDAO.themthietbi(object);
    }
    
    public void suaThietbi(int idtb, String ten, String mota, int loai, float dongia){
        
        thietbiDAL data = new thietbiDAL();
        data.suathietbi(idtb,ten,mota,dongia);
        for(thietbiDTO tb : sumArrtb){
            if(tb.sp_id==(tb.sp_id)){
                tb.sp_ten=ten;
                tb.sp_mota=mota;
                tb.loai_id=loai;
                tb.sp_dongia=dongia;
            }
        }
    }
    public void xoaThietbi(int id){
        tbDAO.xoathietbi(id);
        for(thietbiDTO a : sumArrtb){
            if(a.getSp_id()==id){
                sumArrtb.remove(a);
                break;
            }
        }
    }
    public int getsp_id()
    {
        int rs = 0;
        docThietbi();
        int max = 0;
        if(sumArrtb == null)
        {
            rs = 1;
        } else {
            for (thietbiDTO a : sumArrtb) 
            {
                max = Math.max(a.getSp_id(), max);
            }
            rs = max + 1;
        }
        return rs;
    }
    public ArrayList<thietbiDTO> search(String str, int index)
    {
        ArrayList<thietbiDTO> resulT=new ArrayList<>();
        for(thietbiDTO a: sumArrtb)
        {
            if(index==0)//search all
            {
                if( a.getSp_ten().toUpperCase().contains(str) && a.getSp_tonkho()>0
                  ||a.getSp_mota().toUpperCase().contains(str) && a.getSp_tonkho()>0)
                {
                   resulT.add(a);
                }
            }else if(index==1)//laptop
            {
                if(  a.getLoai_id()==1 && a.getSp_tonkho()>0 && a.getSp_ten().toUpperCase().contains(str))               
            {   
                resulT.add(a);
            }
        }
            else if(index==2)//Bàn phím
            {
                if(  a.getLoai_id()==2 && a.getSp_tonkho()>0 && a.getSp_ten().toUpperCase().contains(str))     
            {              
                resulT.add(a);
            }
        }
            else if(index==3)//Màn hình
            {
                if(  a.getLoai_id()==3 && a.getSp_tonkho()>0 && a.getSp_ten().toUpperCase().contains(str))     
            {              
                resulT.add(a);
            }
        }
            else if(index==4)//chuột gaming
            {
                if( a.getLoai_id()==4 && a.getSp_tonkho()>0 && a.getSp_ten().toUpperCase().contains(str))     
            {              
                resulT.add(a);
            }
        }
            else if(index==5)//tai nghe
            {
                if( a.getLoai_id()==5 && a.getSp_tonkho()>0 && a.getSp_ten().toUpperCase().contains(str))     
            {              
                resulT.add(a);
            }
        }
        }
        return resulT;
    }
    public void congTonkho(int value, int idtb)
    {
        thietbiDAL dao = new thietbiDAL();
        dao.congTonkho(value, idtb);// truyền ct vào dao để update
        
    }
    public void truTonkho(int value, int idtb)
    {
        thietbiDAL dao = new thietbiDAL();
        dao.truTonkho(value, idtb);// truyền ct vào dao để update
        
    }
    public void Soluongdaban(int value, int idtb)
    {
        thietbiDAL dao = new thietbiDAL();
        dao.Soluongdaban(value, idtb);// truyền ct vào dao để update
        
    }
}
