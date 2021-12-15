package ptithcm.bean;

import java.math.BigDecimal;

public class DThuThang {
	public int thang;
	public BigDecimal ra= new BigDecimal(0);
	public BigDecimal vao = new BigDecimal(0);
	
	public DThuThang(int thang, int ra, int vao) {
		super();
		this.thang = thang;
		this.ra = new BigDecimal(ra);
		this.vao = new BigDecimal(vao);
	}
	public DThuThang() {
		super();
	}
	public int getThang() {
		return thang;
	}
	
	public void setThang(int thang) {
		this.thang = thang;
	}
	public BigDecimal getRa() {
		return ra;
	}
	public void setRa(BigDecimal ra) {
		this.ra = ra;
	}
	public BigDecimal getVao() {
		return vao;
	}
	public void setVao(BigDecimal vao) {
		this.vao = vao;
	}
	
	
}
