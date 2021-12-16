package Entity;

public class Account {
	private String SDT;
	private String tenDangNhap;
	private String matKhau;
	
	
	
	@Override
	public String toString() {
		return "Account [SDT=" + SDT + ", tenDangNhap=" + tenDangNhap + ", matKhau=" + matKhau + "]";
	}
	public Account(String sDT, String tenDangNhap, String matKhau) {
		super();
		SDT = sDT;
		this.tenDangNhap = tenDangNhap;
		this.matKhau = matKhau;
	}
	public String getSDT() {
		return SDT;
	}
	public void setSDT(String sDT) {
		SDT = sDT;
	}
	public String getTenDangNhap() {
		return tenDangNhap;
	}

	public void setTenDangNhap(String tenDangNhap) {
		this.tenDangNhap = tenDangNhap;
	}
	public String getMatKhau() {
		return matKhau;
	}
	public void setMatKhau(String matKhau) {
		this.matKhau = matKhau;
	}
}
