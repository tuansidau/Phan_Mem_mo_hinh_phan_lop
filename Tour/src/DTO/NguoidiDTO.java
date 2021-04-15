
package DTO;

public class NguoidiDTO extends DoanDTO {
    private int nguoidi_id;
    private String nguoidi_dsnhanvien, nguoidi_dskhach;
    
    public NguoidiDTO()
    {}

    public NguoidiDTO(int nguoidi_id, String nguoidi_dsnhanvien, String nguoidi_dskhach, int doan_id) {
        super(doan_id);
        this.nguoidi_id = nguoidi_id;
        this.nguoidi_dsnhanvien = nguoidi_dsnhanvien;
        this.nguoidi_dskhach = nguoidi_dskhach;
    }

    public NguoidiDTO(String nguoidi_dsnhanvien, String nguoidi_dskhach, int doan_id) {
        super(doan_id);
        this.nguoidi_dsnhanvien = nguoidi_dsnhanvien;
        this.nguoidi_dskhach = nguoidi_dskhach;
    }

    public NguoidiDTO(int nguoidi_id, String nguoidi_dsnhanvien, String nguoidi_dskhach, int tour_id, int gia_id, String doan_ten, String doan_ngaydi, String doan_ngayve, String doan_chitiet) {
        super(tour_id, gia_id, doan_ten, doan_ngaydi, doan_ngayve, doan_chitiet);
        this.nguoidi_id = nguoidi_id;
        this.nguoidi_dsnhanvien = nguoidi_dsnhanvien;
        this.nguoidi_dskhach = nguoidi_dskhach;
    }

    public int getNguoidi_id() {
        return nguoidi_id;
    }

    public String getNguoidi_dsnhanvien() {
        return nguoidi_dsnhanvien;
    }

    public String getNguoidi_dskhach() {
        return nguoidi_dskhach;
    }

    public void setNguoidi_id(int nguoidi_id) {
        this.nguoidi_id = nguoidi_id;
    }

    public void setNguoidi_dsnhanvien(String nguoidi_dsnhanvien) {
        this.nguoidi_dsnhanvien = nguoidi_dsnhanvien;
    }

    public void setNguoidi_dskhach(String nguoidi_dskhach) {
        this.nguoidi_dskhach = nguoidi_dskhach;
    }
    
    
}
