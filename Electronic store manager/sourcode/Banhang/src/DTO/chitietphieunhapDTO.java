/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

/**
 *
 * @author Nam
 */
public class chitietphieunhapDTO extends thietbiDTO{
    private int pn_id;
    private int sp_id;
    private int ct_soluong;

    public chitietphieunhapDTO() {
    }

    public chitietphieunhapDTO(int pn_id, int sp_id, int ct_soluong) {
        this.pn_id = pn_id;
        this.sp_id=sp_id;  
        this.ct_soluong = ct_soluong;
    }
    public chitietphieunhapDTO(int sp_id,int ct_soluong) {
        this.sp_id=sp_id;;
        this.ct_soluong = ct_soluong;
    }       
    
    

    public int getPn_id() {
        return pn_id;
    }

    public int getCt_soluong() {
        return ct_soluong;
    }
    public int getSp_id() {
        return sp_id;
    }
    public void setSp_id(int sp_id) {
        this.sp_id = sp_id;
    }
    public void setPn_id(int pn_id) {
        this.pn_id = pn_id;
    }

    public void setCt_soluong(int ct_soluong) {
        this.ct_soluong = ct_soluong;
    }

   
}