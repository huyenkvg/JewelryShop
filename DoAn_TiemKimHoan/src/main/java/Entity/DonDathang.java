package Entity;

public class DonDatHang {
	private int maDonHang;
	private String maGiamGia;
	private String maKhachHang;
	private boolean phuongThucThanhToan;
	private String ngay;
	private String diaChiNhanHang;
	private String ghiChu;
	public DonDatHang(int maDonHang, String maGiamGia, String maKhachHang, boolean phuongThucThanhToan, String ngay,
			String diaChiNhanHang,String ghiChu) {
		super();
		this.maDonHang = maDonHang;
		this.maGiamGia = maGiamGia;
		this.maKhachHang = maKhachHang;
		this.phuongThucThanhToan = phuongThucThanhToan;
		this.ngay = ngay;
		this.diaChiNhanHang = diaChiNhanHang;
		this.ghiChu=ghiChu;
	}
	public String getGhiChu() {
		return ghiChu;
	}
	public void setGhiChu(String ghiChu) {
		this.ghiChu = ghiChu;
	}
	public DonDatHang() {
		
	}
	public int getMaDonHang() {
		return maDonHang;
	}
	public void setMaDonHang(int maDonHang) {
		this.maDonHang = maDonHang;
	}
	public String getMaGiamGia() {
		return maGiamGia;
	}
	public void setMaGiamGia(String maGiamGia) {
		this.maGiamGia = maGiamGia;
	}
	public String getMaKhachHang() {
		return maKhachHang;
	}
	public void setMaKhachHang(String maKhachHang) {
		this.maKhachHang = maKhachHang;
	}
	public boolean isPhuongThucThanhToan() {
		return phuongThucThanhToan;
	}
	public void setPhuongThucThanhToan(boolean phuongThucThanhToan) {
		this.phuongThucThanhToan = phuongThucThanhToan;
	}
	public String getNgay() {
		return ngay;
	}
	public void setNgay(String ngay) {
		this.ngay = ngay;
	}
	public String getDiaChiNhanHang() {
		return diaChiNhanHang;
	}
	public void setDiaChiNhanHang(String diaChiNhanHang) {
		this.diaChiNhanHang = diaChiNhanHang;
	}
	
}
