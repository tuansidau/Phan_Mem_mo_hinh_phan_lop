/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

/**
 *
 * @author nngia
 */
public class hoadonDTO {
    int idhd,idkh;
    String ngaylap,ghichu,ngaygiao,diachi,nguoinhan;
    float total;
    public hoadonDTO(){};
    public hoadonDTO(int idhd, String ngaylap, int idkh, String nguoinhan, String diachi, String ngaygiao, float total, String ghichu) {
        this.idhd = idhd;
        this.idkh = idkh;
        this.ngaylap = ngaylap;
        this.ghichu = ghichu;
        this.ngaygiao = ngaygiao;
        this.diachi = diachi;
        this.nguoinhan = nguoinhan;
        this.total = total;
    }

    public int getIdhd() {
        return idhd;
    }

    public void setIdhd(int idhd) {
        this.idhd = idhd;
    }

    public int getIdkh() {
        return idkh;
    }

    public void setIdkh(int idkh) {
        this.idkh = idkh;
    }

    public String getNgaylap() {
        return ngaylap;
    }

    public void setNgaylap(String ngaylap) {
        this.ngaylap = ngaylap;
    }

    public String getGhichu() {
        return ghichu;
    }

    public void setGhichu(String ghichu) {
        this.ghichu = ghichu;
    }

    public String getNgaygiao() {
        return ngaygiao;
    }

    public void setNgaygiao(String ngaygiao) {
        this.ngaygiao = ngaygiao;
    }

    public String getDiachi() {
        return diachi;
    }

    public void setDiachi(String diachi) {
        this.diachi = diachi;
    }

    public String getNguoinhan() {
        return nguoinhan;
    }

    public void setNguoinhan(String nguoinhan) {
        this.nguoinhan = nguoinhan;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }
    
}
