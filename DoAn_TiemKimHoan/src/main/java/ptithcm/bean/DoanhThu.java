package ptithcm.bean;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DoanhThu {
	public int nam;
	public static DThuThang[] thangs = {null,new DThuThang(1, 0, 0),new DThuThang(2, 0, 0),new DThuThang(3, 0, 0),new DThuThang(4, 0, 0),new DThuThang(5, 0, 0),new DThuThang(6, 0, 0),new DThuThang(7, 0, 0),new DThuThang(8, 0, 0),new DThuThang(9, 0, 0),new DThuThang(10, 0, 0),new DThuThang(11, 0, 0),new DThuThang(12, 0, 0),};
	public int getNam() {
		return nam;
	}
	public void setNam(int nam) {
		this.nam = nam;
	}
	public int getLoiNhuan() {
		Double ans= 0.0;
		for(int i = 1; i<=12; i++) {
			ans+= thangs[i].vao.doubleValue()- thangs[i].ra.doubleValue();
		}
		return ans.intValue();
	}
	public DThuThang[]  getThangs() {
		return thangs;
	}
	public static double[]  getDTThangs() {
		double[] thang = {0.0,0.0,0.0,0.0,0.0,0.0,9.0,0.0,0.0,0.0,12.0,0.0,0.0,0.0};
		for(int i = 1; i<=12; i++) {
			thang[i] = thangs[i].vao.doubleValue();
		}
		return thang;
	}
	public void setThangs(DThuThang[]  thangs) {
		this.thangs = thangs;
	}
	public DoanhThu(int nam, DThuThang[]  thangs) {
		super();
		this.nam = nam;
		this.thangs = thangs;
	}
	public DoanhThu() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
