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
public class NhiemvuDTO {
    private int id;
    private String nv_ten;

    public NhiemvuDTO(int id, String nv_ten) {
        this.id = id;
        this.nv_ten = nv_ten;
    }

    public int getId() {
        return id;
    }

    public String getNv_ten() {
        return nv_ten;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNv_ten(String nv_ten) {
        this.nv_ten = nv_ten;
    }
    
    
}
