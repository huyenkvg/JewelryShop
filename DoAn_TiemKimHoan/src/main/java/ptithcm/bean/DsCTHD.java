package ptithcm.bean;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import Entity.ChiTietHoaDon;
import Entity.ChiTietHoaDonPK;
import Entity.ChiTietSizeSp;
import Entity.ChiTietSizeSpPK;

public class DsCTHD {
	public static HashMap<ChiTietSizeSp,ChiTietHoaDon> listCTHD  = new HashMap();


	public HashMap<ChiTietSizeSp, ChiTietHoaDon> getListCTHD() {
		
		return listCTHD;
	}
	public void setListCTHD(HashMap<ChiTietSizeSp, ChiTietHoaDon> listCTHD) {
		this.listCTHD = listCTHD;
	}
	public DsCTHD() {
		super();
		this.listCTHD = new HashMap();
		// TODO Auto-generated constructor stub
	}
	public Collection<ChiTietHoaDon> getDsChiTiet(){
		return listCTHD.values();
	}

	public static List <ChiTietHoaDon> getListCT() {
		List <ChiTietHoaDon> l = new ArrayList<ChiTietHoaDon>();
		listCTHD.forEach((key, value) -> {
		      ChiTietHoaDon x = value;
		      x.setMaSp(key.getMaSp());
		      l.add(x);
		    });
		return l;
	}

	public static void reset() {
		listCTHD  = new HashMap();
	}
	public static boolean isEmpty() {
		// TODO Auto-generated method stub
		if(listCTHD.isEmpty() || listCTHD == null)
			return true;
		return false;
	}
	
}
