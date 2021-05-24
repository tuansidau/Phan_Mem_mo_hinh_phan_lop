/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import DAL.chitietphieunhapDAO;
import DTO.chitietphieunhapDTO;
import DTO.phieunhapDTO;
import java.util.ArrayList;

/**
 *
 * @author MY PC
 */
public class chitietphieunhapBUS 
{ 
    public static ArrayList<chitietphieunhapDTO> dschitiet; 

    public chitietphieunhapBUS() {
    }
    
    public void themchitiet(chitietphieunhapDTO ctpn)
    {
//        dschitiet.add(ctpn);
        chitietphieunhapDAO dao = new chitietphieunhapDAO();
        dao.themchitiet(ctpn);    
    }
    public void docChitiet1(String ctpn)
    {
        chitietphieunhapDAO dao = new chitietphieunhapDAO();
        dao.docChitiet1(ctpn);//truyen mã giam cần lấy chi tiet xuog dao
        dschitiet = new ArrayList<chitietphieunhapDTO>();

        dschitiet = dao.docChitiet1(ctpn);//gán arrbus = arr dao
    }
    public void docChitiet()
    {
        chitietphieunhapDAO dao = new chitietphieunhapDAO();
            dschitiet = new ArrayList<chitietphieunhapDTO>();
            dschitiet = dao.docChitiet();//ghi arraylist cua DAO vao arraylist cua BUS
    }
    public static void main(String[] args) {
        System.out.println(dschitiet);
    }
}
