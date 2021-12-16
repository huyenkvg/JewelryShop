package Entity;

public class DanhGia {
	private String maKH;
	private String maSP;
	private String danhGia;
	private int diemDanhgia;
	public String getMaKH() {
		return maKH;
	}
	public void setMaKH(String maKH) {
		this.maKH = maKH;
	}
	public String getMaSP() {
		return maSP;
	}
	public void setMaSP(String maSP) {
		this.maSP = maSP;
	}
	public String getDanhGia() {
		return danhGia;
	}
	public void setDanhGia(String danhGia) {
		this.danhGia = danhGia;
	}
	public int getDiemDanhgia() {
		return diemDanhgia;
	}
	public void setDiemDanhgia(int diemDanhgia) {
		this.diemDanhgia = diemDanhgia;
	}
	public DanhGia(String maKH, String maSP, String danhGia, int diemDanhgia) {
		super();
		this.maKH = maKH;
		this.maSP = maSP;
		this.danhGia = danhGia;
		this.diemDanhgia = diemDanhgia;
	}
	@Override
	public String toString() {
		return "DanhGia [maKH=" + maKH + ", maSP=" + maSP + ", danhGia=" + danhGia + ", diemDanhgia=" + diemDanhgia
				+ "]";
	}
	
}
