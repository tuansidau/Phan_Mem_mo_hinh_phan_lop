package DTO;


public class KhachHangDTO {
    private int idkh;
    private String kh_ten, kh_sdt, kh_ngaysinh, kh_email, kh_cmnd, kh_ghichu;
    private int kh_trangthai;
    
    public KhachHangDTO()
    {}

    public KhachHangDTO(int idkh, String kh_ten, String kh_sdt, String kh_ngaysinh, String kh_email, String kh_cmnd, String kh_ghichu, int kh_trangthai) {
        this.idkh = idkh;
        this.kh_ten = kh_ten;
        this.kh_sdt = kh_sdt;
        this.kh_ngaysinh = kh_ngaysinh;
        this.kh_email = kh_email;
        this.kh_cmnd = kh_cmnd;
        this.kh_ghichu = kh_ghichu;
        this.kh_trangthai = kh_trangthai;
    }

    public KhachHangDTO(String kh_ten, String kh_sdt, String kh_ngaysinh, String kh_email, String kh_cmnd, String kh_ghichu) {
        this.kh_ten = kh_ten;
        this.kh_sdt = kh_sdt;
        this.kh_ngaysinh = kh_ngaysinh;
        this.kh_email = kh_email;
        this.kh_cmnd = kh_cmnd;
        this.kh_ghichu = kh_ghichu;
    }

    public KhachHangDTO(int idkh, String kh_ten, String kh_sdt, String kh_ngaysinh, String kh_email, String kh_cmnd, String kh_ghichu) {
        this.idkh = idkh;
        this.kh_ten = kh_ten;
        this.kh_sdt = kh_sdt;
        this.kh_ngaysinh = kh_ngaysinh;
        this.kh_email = kh_email;
        this.kh_cmnd = kh_cmnd;
        this.kh_ghichu = kh_ghichu;
    }
    
    

    public int getIdkh() {
        return idkh;
    }

    public String getKh_ten() {
        return kh_ten;
    }

    public String getKh_sdt() {
        return kh_sdt;
    }

    public String getKh_ngaysinh() {
        return kh_ngaysinh;
    }

    public String getKh_email() {
        return kh_email;
    }

    public String getKh_cmnd() {
        return kh_cmnd;
    }

    public int isKh_trangthai() {
        return kh_trangthai;
    }

    public void setIdkh(int idkh) {
        this.idkh = idkh;
    }

    public void setKh_ten(String kh_ten) {
        this.kh_ten = kh_ten;
    }

    public void setKh_sdt(String kh_sdt) {
        this.kh_sdt = kh_sdt;
    }

    public void setKh_ngaysinh(String kh_ngaysinh) {
        this.kh_ngaysinh = kh_ngaysinh;
    }

    public void setKh_email(String kh_email) {
        this.kh_email = kh_email;
    }

    public void setKh_cmnd(String kh_cmnd) {
        this.kh_cmnd = kh_cmnd;
    }

    public void setKh_trangthai(int kh_trangthai) {
        this.kh_trangthai = kh_trangthai;
    }
    
    public String formatTrangthai()
    {
        if(this.isKh_trangthai() == 0)
        {
            return "Chưa có đoàn";
        } else {
            return "Đã có đoàn";
        }
    }

    public String getKh_ghichu() {
        return kh_ghichu;
    }

    public void setKh_ghichu(String kh_ghichu) {
        this.kh_ghichu = kh_ghichu;
    }

}
