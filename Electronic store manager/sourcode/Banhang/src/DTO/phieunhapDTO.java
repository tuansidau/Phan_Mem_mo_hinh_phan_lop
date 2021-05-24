
package DTO;

public class phieunhapDTO {
    private int pn_id;
    private String pn_ngaylap;

    public phieunhapDTO(int pn_id, String pn_ngaylap) {
        this.pn_id = pn_id;
        this.pn_ngaylap = pn_ngaylap;
    }

    public phieunhapDTO() {
    }

    public int getPn_id() {
        return pn_id;
    }

    public String getPn_ngaylap() {
        return pn_ngaylap;
    }

    public void setPn_id(int pn_id) {
        this.pn_id = pn_id;
    }

    public void setPn_ngaylap(String pn_ngaylap) {
        this.pn_ngaylap = pn_ngaylap;
    }

    

}