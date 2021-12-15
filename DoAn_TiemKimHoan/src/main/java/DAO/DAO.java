package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Context.DBContext;
import Entity.Account;
import Entity.Category;
import Entity.Customer;
import Entity.DanhGia;
import Entity.Product;

public class DAO {
	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;

	public List<Product> getLastProDuct() {
		List<Product> list = new ArrayList<Product>();
		String sql = "select top(10) * from CHI_TIET_SAN_PHAM sp , (select  sz.MA_SP, MIN(sz.size) as size,MIN(sz.GIA) as gia from CHI_TIET_SIZE_SP sz group by sz.MA_SP) as sz1 \r\n"
				+ "where sp.MA_SP = sz1.MA_SP  order by sp.MA_SP desc";
		try {
			conn = new DBContext().getConnection();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
//				list.add(new Product(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getString(4), rs.getString(5),
//						 rs.getInt(7),rs.getDouble(8),1));
				
				Product p = new Product(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getString(4), rs.getString(5),
						 rs.getInt(7),rs.getDouble(8),1);
				if(p.getImage()==null||p.getImage().trim().length()==0) {
					p.setImage(String.valueOf(p.getId())+".jpg");
				}
				System.out.println("_"+p.getImage()+"_");
				list.add(p);

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;

	}



	public List<Category> getAllCategory() {
		List<Category> list = new ArrayList();
		String sql = "SELECT * FROM LOAI";
		try {
			conn = new DBContext().getConnection();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				list.add(new Category(rs.getInt(1), rs.getString(2)));

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;

	}

	public List<Product> getProductByCategory(String cid) {
		List<Product> list = new ArrayList<Product>();
		String sql = "select * from CHI_TIET_SAN_PHAM as sp,CHI_TIET_SIZE_SP as size where sp.MA_SP = size.MA_SP and size.size=1 and sp.MA_LOAI ="
				+ cid;
		try {
			conn = new DBContext().getConnection();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				list.add(new Product(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getString(4), rs.getString(5),
						rs.getInt(7), rs.getDouble(8), rs.getInt(9)));

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;

	}

	public Customer getCustomer(String id) {
		List<Customer> product = new ArrayList<Customer>();
		String sql = "select * from KHACH_HANG WHERE SDT="+id;
				
		try {
			conn = new DBContext().getConnection();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				return new Customer(rs.getString(1),
						rs.getString(2),
						rs.getString(3),
						rs.getString(4),
						rs.getInt(5),
						rs.getString(6)
						
						);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;

	}
	
	public int editCustomer(String id,String hoTen,String ngaySinh,String diaChi) {
		String sql = "Update KHACH_HANG set HO_TEN=?,NGAY_SINH=?,DIA_CHI=? where SDT="+id;
		
		try {
			conn = new DBContext().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, hoTen);
			ps.setString(2, ngaySinh);
			ps.setString(3, diaChi);
			ps.executeUpdate();
			return 1;
	}
		catch (Exception e) {
			System.out.print(e.getMessage());
			return 0;
		}
	}
	public List<Product> getSize(String id) {
		List<Product> list = new ArrayList<Product>();
		String sql = "select * from CHI_TIET_SAN_PHAM as sp,CHI_TIET_SIZE_SP as size where sp.MA_SP = size.MA_SP and sp.Ma_sp ="
				+ id;
		try {
			conn = new DBContext().getConnection();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				list.add(new Product(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getString(4), rs.getString(5),
						rs.getInt(7), rs.getDouble(8), rs.getInt(9)));

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;

	}

	public Product getProductByID(String id, int size) {
		Product list = new Product();
		String sql = "select * from CHI_TIET_SAN_PHAM as sp,CHI_TIET_SIZE_SP as size where sp.MA_SP = size.MA_SP and sp.Ma_sp ="
				+ id + "  and size.SIZE=" + size;
		try {
			conn = new DBContext().getConnection();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				Product p = new Product(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getString(4), rs.getString(5),
						 rs.getInt(7),rs.getDouble(8),1);
				if(p.getImage()==null||p.getImage().trim().length()==0) {
					p.setImage(String.valueOf(p.getId())+".jpg");
				}
				System.out.println("_"+p.getImage()+"_");
				return p;
				
//				return new Product(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getString(4), rs.getString(5),
//						rs.getInt(7), rs.getDouble(8), rs.getInt(9));

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;

	}

	public int getNumberPage() {
		String sql = "SELECT COUNT(DISTINCT sp.MA_SP) from CHI_TIET_SAN_PHAM sp,CHI_TIET_SIZE_SP size where sp.MA_SP =size.MA_SP	";
		try {
			conn = new DBContext().getConnection();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				int total = rs.getInt(1);
				int countPage = 0;
				countPage = total / 8;
				if (total % 8 != 0) {
					countPage++;
				}
				return countPage;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	public List<Product> getPageProducts(int index) {
		
		List<Product> list = new ArrayList();
		String sql = "select * from  CHI_TIET_SAN_PHAM sp , (select  sz.MA_SP, MIN(sz.size) as size,MIN(sz.GIA) as gia from CHI_TIET_SIZE_SP sz group by sz.MA_SP) as sz1 where sp.MA_SP = sz1.MA_SP order by  sz1.ma_SP offset ?\r\n"
				+ "rows fetch next 8 rows only";

		try {
			conn = new DBContext().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, (index - 1) * 8);
			rs = ps.executeQuery();
			while (rs.next()) {
				Product p = new Product(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getString(4), rs.getString(5),
						 rs.getInt(7),rs.getDouble(8),1);
				if(p.getImage()==null||p.getImage().trim().length()==0) {
					p.setImage(String.valueOf(p.getId())+".jpg");
				}
				System.out.println("_"+p.getImage()+"_");
				list.add(p);
				//list.add(new Product(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getString(4), rs.getString(5),
					//	 rs.getInt(7),rs.getDouble(8),1));
			}
		

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;

	}

//	public List<Product> getPageCateProducts(int index, String id) {
//		List<Product> list = new ArrayList();
//		String sql = "select * from CHI_TIET_SAN_PHAM sp,CHI_TIET_SIZE_SP size where sp.MA_SP =size.MA_SP and sp.MA_LOAI="
//				+ id + "order by sp.MA_SP offset ?\r\n" + "rows fetch next 8 rows only";
//
//		try {
//			conn = new DBContext().getConnection();
//			ps = conn.prepareStatement(sql);
//			ps.setInt(1, (index - 1) * 8);
//			rs = ps.executeQuery();
//			while (rs.next()) {
//				list.add(new Product(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getString(4), rs.getString(5),
//						rs.getInt(7), rs.getDouble(8), rs.getInt(9)));
//			}
//
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return list;
//
//	}
	public Account login(String user, String pass) {
		String sql ="select * from TAI_KHOAN where TEN_TAI_KHOAN=? and MAT_KHAU=?";
		try {
			conn = new DBContext().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, user);
			ps.setString(2, pass);
			rs = ps.executeQuery();
			while(rs.next()) {
				return new Account(rs.getString(1),
						rs.getString(2),
						rs.getString(3));
			}
		}catch(Exception e) {
			
		}
		
		return null;
	}
	
	public Account checkExistslogin(String user) {
		String sql ="select * from TAI_KHOAN where TEN_TAI_KHOAN=?";
		try {
			conn = new DBContext().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, user);
			rs = ps.executeQuery();
			while(rs.next()) {
				return new Account(rs.getString(1),
						rs.getString(2),
						rs.getString(3));
			}
		}catch(Exception e) {
			
		}
		
		return null;
	}
	
	public Customer checkExistsKhachHang(String SDT) {
		String sql ="select * from KHACH_HANG where SDT=?";
		try {
			conn = new DBContext().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, SDT);
			rs = ps.executeQuery();
			while(rs.next()) {
				return new Customer(rs.getString(1),
						rs.getString(2),
						rs.getString(3),
						rs.getString(4));
			}
		}catch(Exception e) {
			
		}
		
		return null;
	}
	
	public void dangKiTaiKhoan(String SDT,String user,String pass) {
		String sql = "insert into TAI_KHOAN values(?,?,?)";
		try {
			conn =new DBContext().getConnection();
			ps= conn.prepareStatement(sql);
			ps.setString(1, SDT);
			ps.setString(2, user);
			ps.setString(3, pass);
			ps.executeUpdate();
		}
		catch(Exception e) {
			
		}
	}
	
	public void themKhachHang(String SDT,String hoTen,String ngaySinh,String diaChi,int danhGiaTiemNang,String luuY) {
		String sql = "insert into KHACH_HANG values(?,?,?,?,?,?)";
		try {
			conn =new DBContext().getConnection();
			ps= conn.prepareStatement(sql);
			ps.setString(1, SDT);
			ps.setString(2, hoTen);
			ps.setString(3, ngaySinh);
			ps.setString(4, diaChi);
			ps.setInt(5,danhGiaTiemNang);
			ps.setString(6,luuY);
			ps.executeUpdate();
		}
		catch(Exception e) {
			
		}
		
		
	}
	public List<DanhGia> GetDanhGia(String id) {
		String sql ="select * from danh_gia where ma_sp="+id;
		  List<DanhGia> list = new ArrayList<DanhGia>();
		try {
			conn = new DBContext().getConnection();
			ps = conn.prepareStatement(sql);
			
			rs = ps.executeQuery();
			while(rs.next()) {
			list.add(new DanhGia(rs.getString(1),
						rs.getString(2),
						rs.getString(3),
						rs.getInt(4)))	;
			}
			
		}catch(Exception e) {
			System.out.print(e.getMessage());
		}
		
		return list;
	}
	
	public void themDanhGia(String maKH, String maSp,String danhGia,int danhgiaSao) {
		
		//String sql = "insert into danh_gia values (?,?,"+"N'"+danhGia+"',"+"?)";
		String sql ="insert into danh_gia values (?,?,?,?,?)";
		try {
			conn = new DBContext().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, maKH);
			ps.setString(2, maSp);
			ps.setString(3, danhGia);
			ps.setInt(4, danhgiaSao);
			ps.setInt(5, 1);
			ps.executeUpdate();
		}
		catch(Exception e) {
			
		}
	}
	
	public void xoaDanhGia(String maKH,String maSp) {
		String sql = "delete from danh_gia where MA_KHACH_HANG =? and MA_SP=?";
		try {
			conn = new DBContext().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, maKH);
			ps.setString(2, maSp);
			ps.executeUpdate();
		}
		catch(Exception e) {
			
		}
	}
	public static void main (String[] args) {
		DAO dao = new DAO();
		List<Product> p = dao.getPageProducts(1);
		for(Product l : p) {
		System.out.print(l);
		}
	}	

	

}
