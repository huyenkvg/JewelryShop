package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import Context.DBContext;
import Entity.Account;
import Entity.Cart;
import Entity.ChiTietDatHang;
import Entity.DonDatHang;

public class donHangDAO {
	public int themDonHang(DonDatHang dh) {
		//String sql = "insert into DON_DATHANG values(?,?,?,?,?,?)";
		String sql = "insert into DON_DATHANG (MA_GIAM_GIA,MA_KHACH_HANG,PHUONG_THUC,NGAY,DIA_CHI) values('" + dh.getMaGiamGia()+"',"+"'"+
				dh.getMaKhachHang()+"'," +"'"+
						dh.isPhuongThucThanhToan()+"',"+"'"+
								dh.getNgay()+"',"+
										"'"+dh.getDiaChiNhanHang()+"')";
		Connection conn = new DBContext().getConnection();
		int kq=0;
		
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			kq=ps.executeUpdate();
			
		} catch (SQLException e) {
			System.out.print(e.getMessage());
			e.printStackTrace();
			return 0;
		}
		return kq;
	}
	
	
	public int idDonHangCuoiCung() {
		String sql = " SELECT MAX(MA_DH) FROM DON_DATHANG";
		Connection conn = new DBContext().getConnection();
		
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				return (rs.getInt(1));
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return 0;
	}
	
	public void themChiTiet(ChiTietDatHang chiTiet) {
		String sql = "insert into CHI_TIET_DATHANG (MA_SAN_PHAM,MA_DATHANG,SO_LUONG,SIZE,GIA) values('" + chiTiet.getMaSanPham()+"',"+"'"+
		chiTiet.getMaDatHang()+"'," +"'"+
				chiTiet.getSoLuong()+"',"+"'"+
						chiTiet.getSize()+"',"+
								chiTiet.getGia()+")";
		Connection conn = new DBContext().getConnection();
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.executeUpdate();
			
			
		} catch (SQLException e) {
			System.out.print(e.getMessage());

		}
		
	}
	
	public void themChiTietDonHang(HashMap<String, Cart> carts) {
		donHangDAO dao = new donHangDAO();
		int id =  dao.idDonHangCuoiCung();
	
				for(Map.Entry<String, Cart> itemCart : carts.entrySet()) {
			ChiTietDatHang chiTiet = new ChiTietDatHang();
			chiTiet.setMaDatHang(id);
			chiTiet.setMaSanPham(itemCart.getValue().getProduct().getId());
			chiTiet.setGia(itemCart.getValue().getTotalPrice());
			chiTiet.setSize(itemCart.getValue().getProduct().getSize());
			chiTiet.setSoLuong(itemCart.getValue().getQuanty());
			dao.themChiTiet(chiTiet);
		
		}
	
	}

}
