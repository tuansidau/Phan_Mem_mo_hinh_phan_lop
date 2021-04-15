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
public class ChiphiDTO extends DoanDTO{
    private int chiphi_id;
    private double chiphi_total;
    private String chiphi_chitiet;

    public ChiphiDTO(int chiphi_id, double chiphi_total, String chiphi_chitiet, int doan_id) {
        super(doan_id);
        this.chiphi_id = chiphi_id;
        this.chiphi_total = chiphi_total;
        this.chiphi_chitiet = chiphi_chitiet;
    }

    public ChiphiDTO(double chiphi_total, String chiphi_chitiet, int doan_id) {
        super(doan_id);
        this.chiphi_total = chiphi_total;
        this.chiphi_chitiet = chiphi_chitiet;
    }

    public int getChiphi_id() {
        return chiphi_id;
    }

    public double getChiphi_total() {
        return chiphi_total;
    }

    public String getChiphi_chitiet() {
        return chiphi_chitiet;
    }

    public void setChiphi_id(int chiphi_id) {
        this.chiphi_id = chiphi_id;
    }

    public void setChiphi_total(double chiphi_total) {
        this.chiphi_total = chiphi_total;
    }

    public void setChiphi_chitiet(String chiphi_chitiet) {
        this.chiphi_chitiet = chiphi_chitiet;
    }
    
    
}
