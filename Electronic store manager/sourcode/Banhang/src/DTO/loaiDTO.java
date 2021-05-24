/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

/**
 *
 * @author HOANG MINH HUY
 */
public class loaiDTO {
    
    public int loai_id;
    public String loai_ten;
    public loaiDTO() {
    }

    public loaiDTO(int loai_id, String loai_ten) {
        this.loai_id = loai_id;
        this.loai_ten = loai_ten;
    }

    

    public String getLoai_ten() {
        return loai_ten;
    }

    public int getLoai_id() {
        return loai_id;
    }

    public void setLoai_ten(String loai_ten) {
        this.loai_ten = loai_ten;
    }

    public void setLoai_id(int loai_id) {
        this.loai_id = loai_id;
    }
    
}
