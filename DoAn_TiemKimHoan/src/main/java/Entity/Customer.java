package Entity;

public class Customer {
	@Override
	public String toString() {
		return "Customer [hoTen=" + hoTen + ", ngaySinh=" + ngaySinh + ", diaChi=" + diaChi + ", SDT=" + SDT
				+ ", danhGiaTiemNang=" + danhGiaTiemNang + ", luuY=" + luuY + "]";
	}
	private String hoTen;
	private String ngaySinh;
	private String diaChi;
	private String SDT;
	private int danhGiaTiemNang;
	private String luuY;
	
	
	
	public Customer(String hoTen, String ngaySinh, String diaChi, String sDT) {
		super();
		this.hoTen = hoTen;
		this.ngaySinh = ngaySinh;
		this.diaChi = diaChi;
		SDT = sDT;
	}
	public Customer(String sDT, String hoTen, String ngaySinh, String diaChi, int danhGiaTiemNang, String luuY) {
		super();
		this.hoTen = hoTen;
		this.ngaySinh = ngaySinh;
		this.diaChi = diaChi;
		SDT = sDT;
		this.danhGiaTiemNang = danhGiaTiemNang;
		this.luuY = luuY;
	}
	public String getHoTen() {
		return hoTen;
	}
	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}
	public String getNgaySinh() {
		return ngaySinh;
	}
	public void setNgaySinh(String ngaySinh) {
		this.ngaySinh = ngaySinh;
	}
	public String getDiaChi() {
		return diaChi;
	}
	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}
	public String getSDT() {
		return SDT;
	}
	public void setSDT(String sDT) {
		SDT = sDT;
	}
	public int getDanhGiaTiemNang() {
		return danhGiaTiemNang;
	}
	public void setDanhGiaTiemNang(int danhGiaTiemNang) {
		this.danhGiaTiemNang = danhGiaTiemNang;
	}
	public String getLuuY() {
		return luuY;
	}
	public void setLuuY(String luuY) {
		this.luuY = luuY;
	}
	
}
