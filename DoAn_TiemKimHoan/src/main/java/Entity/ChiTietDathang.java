package Entity;

public class ChiTietDatHang {
	private int maSanPham;
	private int maDatHang;
	private int soLuong;
	private String ghiChu;
	private int size;
	private double gia;
	
	public ChiTietDatHang() {
		
	}
	public ChiTietDatHang(int maSanPham, int maDatHang, int soLuong, String ghiChu, int size, double gia) {
		super();
		this.maSanPham = maSanPham;
		this.maDatHang = maDatHang;
		this.soLuong = soLuong;
		this.ghiChu = ghiChu;
		this.size = size;
		this.gia = gia;
	}
	public int getMaSanPham() {
		return maSanPham;
	}
	public void setMaSanPham(int maSanPham) {
		this.maSanPham = maSanPham;
	}
	public int getMaDatHang() {
		return maDatHang;
	}
	public void setMaDatHang(int maDatHang) {
		this.maDatHang = maDatHang;
	}
	public int getSoLuong() {
		return soLuong;
	}
	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}
	public String getGhiChu() {
		return ghiChu;
	}
	public void setGhiChu(String ghiChu) {
		this.ghiChu = ghiChu;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	public double getGia() {
		return gia;
	}
	public void setGia(double gia) {
		this.gia = gia;
	}
	
}
