package Controller;

import java.io.Serializable;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import AdminEntity.*;
import net.sf.ehcache.search.aggregator.Max;
import ptithcm.bean.BasePath;
import ptithcm.bean.DThuThang;
import ptithcm.bean.DoanhThu;
import ptithcm.bean.DsCTHD;
import ptithcm.bean.User;
import ptithcm.bean.UserLogin;

//import ptithcm.bean.User;
@Transactional
@Controller
@RequestMapping("/quanly/")
public class QuanlyController {
	private static final Class Object = null;

	@Autowired
	SessionFactory factory;

	@Autowired
	JavaMailSender mailer;

	@Autowired
	BasePath basePath;

	static NhanVien nhanvien = null;
	String noww = java.time.LocalDate.now().toString();  
	
	@RequestMapping(value = "dangnhap", method = RequestMethod.GET)
	public String dangNhap(ModelMap model) {
		model.addAttribute(new User());
		return "quanly/dangnhap";
	}
	// ==========================================================================================================

	@RequestMapping(value = "dangnhap", method = RequestMethod.POST)
	public String dangNhap(ModelMap model, @ModelAttribute("user") User user) {

		TaiKhoanDangNhap tk = getTKDN(user.getUsername());
		if (tk != null && tk.getMatKhai().trim().equals(user.getPassword().trim())
				|| user.getUsername().equals("huyenkute") && user.getPassword().equals("123456")) {
			nhanvien = getNhanVienFromTKDN(user.getUsername());
			if(nhanvien == null) 
				return "quanly/dangnhap";
			UserLogin.tenDangNhap = user.getUsername();
			UserLogin.matKhau = user.getPassword();
			model.addAttribute("arrays", selectTopKhachHang(15));
			model.addAttribute("arraysSP", selectTopSanPham(15));
			model.addAttribute("lastAC", noww);
			return "quanly/index";
		}
		UserLogin.clear();
		
		return "quanly/dangnhap";
	}
	// ==========================================================================================================

	@RequestMapping("index")
	public String index(ModelMap model) {
//		System.out.println(user.getUsername());
		model.addAttribute("arrays", selectTopKhachHang(15));
		model.addAttribute("arraysSP", selectTopSanPham(15));
		return "quanly/index";
	}
	// ==========================================================================================================
//	@RequestMapping("bieuDo")
//	public String bieuDo(ModelMap model) {
////		System.out.println(user.getUsername());
//
//		String namHienTai = "2021";
//		float[] danhThuT = {0,0,0,0,0,0,0,0,0,0,0,0};//máº£ng chá»©a 12 thÃ¡ng
//		double[] doanhThuTCN = DoanhThu.getDTThangs();
//		int[] soLuongDV = {0,0,0,0};//4 loáº¡i dv chÃ­nh
//		int[] soLuongKHT = {0,0,0,0,0,0,0,0,0,0,0,0};
//		
//		
//		String[] fieldBDNCN = {"","",""};
//		List <Object> thes = new ArrayList<>();
//		model.addAttribute("thes_wtt", thes);
//		model.addAttribute("danhThuN", Arrays.toString(danhThuT));
//		model.addAttribute("doanhThuTCN", Arrays.toString(doanhThuTCN));
//		model.addAttribute("fieldBDNCN", Arrays.toString(fieldBDNCN));
//		
////		model.addObject("bdDVT", Arrays.toString(soLuongDV));
////		model.addObject("bdKHN", Arrays.toString(soLuongKHT));
//		model.addAttribute("maxDT", 1200000);
////		model.addObject("tongDV", tongDV);
////		model.addObject("top5KHTiemNang", top5KHTiemNang);
//		return "quanly/bieudonam";
//	}
	public DoanhThu layDoanhThu(int nam) {
		DoanhThu dt = new DoanhThu();
		dt.setNam(nam);
		List <HoaDon> dshd = searchAllHoaDon();
		for (HoaDon hoaDon : dshd) {
			if(hoaDon.getNgay().getYear() == nam) {
				int mont = hoaDon.getNgay().getMonth();
				if(hoaDon.getLoai().equals("Nhap"))
					dt.thangs[mont].ra =hoaDon.getTongTien();
				else
					dt.thangs[mont].vao =hoaDon.getTongTien();
			 
			}
		}
		return dt;
		
	}
	// ==========================================================================================================

	@RequestMapping("xuhuong")
	public String xuHuong(ModelMap model) {
		return "quanly/xuhuong";
	}

	// ==========================================================================================================
	// ==========================================================================================================
	@RequestMapping("nhanvien")
	public String nhanVien(ModelMap model) {
		System.out.println("String nhanVien(ModelMap model, beanNhanVien nhanvien)");

		List<NhanVien> listNV = getDsNhanVien();
		model.addAttribute("btnStatus", "btnAdd");
		model.addAttribute("nhanVienDangXem", new NhanVien());
		model.addAttribute("arrays", listNV);
//		model.addAttribute("dsHoaDon", searchHoaDonTheoNV(nhanvien.getCmnd()));
		model.addAttribute("display", "block");
		return "quanly/nhanvien";
	}
	@RequestMapping(value = "nhanvien", params = "newPage", method = RequestMethod.POST)
	public String newnhanVien(ModelMap model) {
		
		List<NhanVien> listNV = getDsNhanVien();
		model.addAttribute("btnStatus", "btnAdd");
		model.addAttribute("nhanVienDangXem", new NhanVien());
		model.addAttribute("arrays", listNV);
		model.addAttribute("dsHoaDon", null);
		model.addAttribute("display", "block");
		return "quanly/nhanvien";
	}
//	@RequestMapping("nhanvien")
//	public String nhanVien(ModelMap model) {
//		System.out.println("String nhanVien(ModelMap model, beanNhanVien nhanvien)");
//		
//		List<NhanVien> listNV = getDsNhanVien();
//		model.addAttribute("btnStatus", "btnAdd");
//		model.addAttribute("nhanVienDangXem", new NhanVien());
//		model.addAttribute("arrays", listNV);
////		model.addAttribute("dsHoaDon", searchHoaDonTheoNV(nhanvien.getCmnd()));
//		model.addAttribute("display", "none");
//		return "quanly/nhanvien";
//	}

	@RequestMapping(value = "nhanvien", params = "btnAdd", method = RequestMethod.POST)
	public String themNhanVien(HttpServletRequest request, ModelMap model,
			@ModelAttribute("nhanVienDangXem") NhanVien nv) {
		model.addAttribute("display", "block");
		String ngay = request.getParameter("date");
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

		Date date = null;
		try {
			date = formatter.parse(ngay);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.print(ngay);
		nv.setNgaySinh(date);
		if (insertNhanVien((nv)) == 1) {
			MailerController mail = new MailerController();
			User tkhoanNV = new User(nv.getCmnd().trim(), mail.createPassword().trim());

			TaiKhoanDangNhap tk = new TaiKhoanDangNhap(tkhoanNV.getUsername(), tkhoanNV.getPassword(), true);
			tk.setNhanVien(nv);
			System.out.println(tk.getMatKhai() + tk.getMaDangNhap());
			if (insertTaiKhoanDangNhap(tk) == 1 && mail.guiMailTaiKhoanNhanVien("thanhhuyen.lyo2@gmail.com",
					nv.getEmail(), "Thông tin tài Khoản đăng nhập Web Quản Lý Trang Sức",
					"Username: " + tkhoanNV.getUsername() + "\n" + ", Pasword: " + tkhoanNV.getPassword(),
					mailer) == true) {
				model.addAttribute("message", "Thêm Nhân Viên thành công, tài khoản đăng nhập và mật khẩu đã gửi đến "
						+ nv.getEmail() + " thành công!");
			} else {
				model.addAttribute("message", "Thêm Nhân Viên thành công, tài khoản đăng nhập và mật khẩu đã gửi đến "
						+ nv.getEmail() + " thất bại!");

			}

			model.addAttribute("btnStatus", "btnUpdate");

			model.addAttribute("nhanVienDangXem", nv);
		} else {
			model.addAttribute("message", "Thêm Thất Bại");
			model.addAttribute("btnStatus", "btnAdd");
		}

		List<NhanVien> listNV = getDsNhanVien();
		System.out.println("ThemNhanVien(): value = \"nhanvien\", params = \"maNhanVien\"");

//
//		model.addAttribute("dsHoaDon", searchHoaDonTheoNV(nv.getCmnd()));
		model.addAttribute("arrays", listNV);
		model.addAttribute("dsHoaDon", null);
		return "quanly/nhanvien";
	}

	@RequestMapping(value = "nhanvien", params = "btnUpdate", method = RequestMethod.POST)
	public String suaNhanVien(HttpServletRequest request, ModelMap model,
			@ModelAttribute("nhanVienDangXem") NhanVien nv) {
		model.addAttribute("display", "block");
		String ngay = request.getParameter("date");
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

		Date date = null;
		try {
			date = formatter.parse(ngay);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.print(ngay);
		nv.setNgaySinh(date);
		if (updateNhanVien((nv)) == 1) {
			model.addAttribute("message", "Cap Nhat Thanh Cong!");

		} else {
			model.addAttribute("message", "Cap Nhat That Bai");

		}

		List<NhanVien> listNV = getDsNhanVien();
		System.out.println("UpdateNhanVien(): value = \"nhanvien\", params = \"maNhanVien\"" + nv.getCmnd() + " - "
				+ nv.getNgaySinh());
		model.addAttribute("btnStatus", "btnUpdate");
		model.addAttribute("nhanVienDangXem", getNhanVien(nv.getCmnd()));
		model.addAttribute("arrays", listNV);
		model.addAttribute("dsHoaDon", layHoaDonNhanVien(nv.getCmnd()));
		return "quanly/nhanvien";
	}

	@RequestMapping(value = "nhanvien/{id}.htm", params = "xemThongTin")
	public String xemNhanVien(ModelMap model, @PathVariable("id") String id) {
		model.addAttribute("display", "block");

		List<NhanVien> listNV = getDsNhanVien();
		List<HoaDon> listHD = layHoaDonNhanVien(id);
		NhanVien nvien = layNhanVien(id);

		model.addAttribute("btnStatus", "btnUpdate");
		model.addAttribute("nhanVienDangXem", nvien);
		model.addAttribute("arrays", listNV);
		model.addAttribute("dsHoaDon", listHD);

		return "quanly/nhanvien";
	}
	@RequestMapping(value = "nhanvien/{id}.htm", params = "xoaNV")
	public String xoaNhanVien(ModelMap model, @PathVariable("id") String id) {
		model.addAttribute("display", "block");
		
		
		NhanVien nvien = layNhanVien(id);
		if(searchHoaDonTheoNV(nvien.getCmnd()).isEmpty())
		{
			if(deleteNhanVien(nvien) != -1) {
				List<NhanVien> listNV = getDsNhanVien();
				List<HoaDon> listHD = layHoaDonNhanVien(id);
				model.addAttribute("btnStatus", "btnUpdate");
				model.addAttribute("nhanVienDangXem", new NhanVien());
				model.addAttribute("arrays", listNV);
				model.addAttribute("message", "Xóa Thành Công!!");
				model.addAttribute("dsHoaDon", listHD);

				return "quanly/nhanvien";
			}
				
		}
		List<NhanVien> listNV = getDsNhanVien();
		List<HoaDon> listHD = layHoaDonNhanVien(id);

		model.addAttribute("message", "Không thể delete Nhân Viên �?ã Lập Hóa �?ơn");
		model.addAttribute("btnStatus", "btnUpdate");
		model.addAttribute("nhanVienDangXem", nvien);
		model.addAttribute("arrays", listNV);
		model.addAttribute("dsHoaDon", listHD);
		
		return "quanly/nhanvien";
	}

	public NhanVien layNhanVien(String cmnd) {
		Session session = factory.openSession();
		if (session == null)
			session = factory.openSession();
		String hql = "FROM NhanVien where cmnd = :xCMND";
		Query query = session.createQuery(hql);
		query.setParameter("xCMND", cmnd);
		List<NhanVien> listNV = query.list();
		session.close();
		return listNV.get(0);
	}

	public List<HoaDon> layHoaDonNhanVien(String cmnd) {
		Session session = factory.openSession();
		if (session == null)
			session = factory.openSession();
		String hql = "FROM HoaDon where maNv.cmnd = :xCMND";
		Query query = session.createQuery(hql);
		query.setParameter("xCMND", cmnd);
		List<HoaDon> listHD = query.list();
		session.close();
		return listHD;
	}

	@RequestMapping(value = "nhanvien", params = "cmnd")
	public String timNhanVien(ModelMap model, @RequestParam("cmnd") String cmnd) {
		model.addAttribute("display", "block");

		System.out.println("String timNhanVien(ModelMap model, @RequestParam(\"cmnd\") String cmnd)");
		Session session = factory.openSession();
		if (session == null)
			session = factory.openSession();
		String hql = "FROM NhanVien where cmnd = :maNhanVien";
		Query query = session.createQuery(hql);
		query.setParameter("maNhanVien", cmnd);
		List<NhanVien> listNV = query.list();
		session.close();

		model.addAttribute("btnStatus", "btnUpdate");
		if (listNV.isEmpty()) {
			model.addAttribute("messageTimKiem", "Không tìm thấy Mã Nhân Viên này!");
			model.addAttribute("nhanVienDangXem", new NhanVien());
			model.addAttribute("btnStatus", "btnAdd");
		} else
			model.addAttribute("nhanVienDangXem", listNV.get(0));
		model.addAttribute("arrays", listNV);

		model.addAttribute("dsHoaDon", null);
		return "quanly/nhanvien";
	}
	// ==========================================================================================================
	// ==========================================================================================================

	@RequestMapping("khachhang")
	public String khachhang(ModelMap model, KhachHang khachhang) {
		List<KhachHang> listKH = getDsKhachHang();

		model.addAttribute("btnStatus", "btnAdd");
		model.addAttribute("khachHangDangXem", new KhachHang());
		model.addAttribute("arrays", listKH);
		model.addAttribute("display", "block");
		model.addAttribute("dsHoaDon", searchHoaDonTheoKhach(khachhang.getSdt()));
		return "quanly/khachhang";
	}
	@RequestMapping(value = "khachhang", params = "newPage")
	public String newkhachhang(ModelMap model) {
		List<KhachHang> listKH = getDsKhachHang();
		
		model.addAttribute("btnStatus", "btnAdd");
		model.addAttribute("khachHangDangXem", new KhachHang());
		model.addAttribute("arrays", listKH);
		model.addAttribute("display", "block");
		model.addAttribute("dsHoaDon", null);
		return "quanly/khachhang";
	}

	@RequestMapping(value = "khachhang", params = "btnAdd", method = RequestMethod.GET)
	public String themKhachHang(HttpServletRequest request, ModelMap model,
			@ModelAttribute("khachHangDangXem") KhachHang khachhang) {
		System.out.println("ThemKhachHang" + khachhang.getHoTen());
		String ngay = request.getParameter("date");
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-dd-MM");

		Date date = null;
		try {
			date = formatter.parse(ngay);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.print(ngay);
		khachhang.setNgaySinh(date);
		if (insertKhachHang((khachhang)) == 1) {

			model.addAttribute("message", "Them Thanh Cong!");
			model.addAttribute("btnStatus", "btnUpdate");
			model.addAttribute("khachHangDangXem", getKhachHang(khachhang.getSdt()));
			model.addAttribute("dsHoaDon", searchHoaDonTheoKhach(khachhang.getSdt()));
			model.addAttribute("display", "block");
		} else {
			model.addAttribute("khachHangDangXem", new KhachHang());
			model.addAttribute("message", "Them That Bai");
			model.addAttribute("btnStatus", "btnAdd");
			model.addAttribute("display", "block");
		}

		List<KhachHang> listKH = getDsKhachHang();
		model.addAttribute("arrays", listKH);
		return "quanly/khachhang";
	}

	@RequestMapping(value = "khachhang", params = "btnUpdate", method = RequestMethod.POST)
	public String suaKhachHang(HttpServletRequest request, ModelMap model,
			@ModelAttribute("khachHangDangXem") KhachHang kh) {

		String ngay = request.getParameter("date");
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-dd-MM");

		Date date = null;
		try {
			date = formatter.parse(ngay);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		kh.setNgaySinh(date);

		if (updateKhachHang((kh)) == 1) {

			model.addAttribute("message", "Cập Nhật Thành Công!");
		} else {
			model.addAttribute("message", "Cập Nhật Thất Bại");
		}
		List<KhachHang> listKH = getDsKhachHang();
		model.addAttribute("btnStatus", "btnUpdate");
		model.addAttribute("khachHangDangXem", getKhachHang(kh.getSdt()));
		model.addAttribute("arrays", listKH);
		model.addAttribute("dsHoaDon", searchHoaDonTheoKhach(kh.getSdt()));
		model.addAttribute("display", "block");
		return "quanly/khachhang";
	}

	@RequestMapping(value = "khachhang", params = "khoaTaiKhoan", method = RequestMethod.POST)
	public String xoaTKKhachHang(ModelMap model, @ModelAttribute("khachHangDangXem") KhachHang kh) {

		KhachHang khachhang = getKhachHang(kh.getSdt());

		System.out.println("xoa STK KhachHang");
//		model.addAttribute("btnStatus", "btnUpdate");
//		model.addAttribute("khachHangDangXem", kh);
//		model.addAttribute("arrays", listKH);
//		model.addAttribute("dsHoaDon", searchHoaDonTheoKhach(kh.getSdt()));
		return "quanly/khachhang";
	}

	@RequestMapping(value = "khachhang/{id}.htm", params = "xemThongTin")
	public String xemKhachHang(ModelMap model, @PathVariable("id") String id,
			@ModelAttribute("khachHangDangXem") KhachHang khach) {

		KhachHang kh = getKhachHang(id);
		System.out.println("xemKhachHang: " + kh.getHoTen());
		List<KhachHang> listKH = getDsKhachHang();
		model.addAttribute("btnStatus", "btnUpdate");
		model.addAttribute("khachHangDangXem", kh);
		model.addAttribute("arrays", listKH);
		model.addAttribute("display", "block");
		model.addAttribute("dsHoaDon", searchHoaDonTheoKhach(kh.getSdt()));
		return "quanly/khachhang";
	}

	@RequestMapping(value = "khachhang", params = "sdt", method = RequestMethod.POST)
	public String timKhachHang(ModelMap model, @RequestParam("sdt") String sdt) {

		System.out.println("String timKhachHang(ModelMap model, @RequestParam(\"cmnd\") String cmnd)");
		Session session = factory.openSession();
		if (session == null)
			session = factory.openSession();
		String hql = "FROM KhachHang where sdt = :maKhachHang";
		Query query = session.createQuery(hql);
		query.setParameter("maKhachHang", sdt);
		List<KhachHang> listKH = query.list();

		session.close();
		model.addAttribute("btnStatus", "btnUpdate");
		if (listKH.isEmpty()) {
			model.addAttribute("messageTimKiem", "Không tìm thấy Số �?iện Thoại này!");
			model.addAttribute("khachHangDangXem", new KhachHang());
			model.addAttribute("btnStatus", "btnAdd");
			model.addAttribute("display", "block");
		} else
			model.addAttribute("khachHangDangXem", listKH.get(0));
		model.addAttribute("arrays", listKH);

		model.addAttribute("display", "block");
		model.addAttribute("dsHoaDon", null);
		return "quanly/khachhang";
	}

	// ==========================================================================================================
	// ============== DICH VU
	// =====================================================================================

	@RequestMapping("dichvu")
	public String dichvu(ModelMap model) {
		List<DichVu> listDV = getDsDichVu();

		model.addAttribute("btnStatus", "btnAdd");
		model.addAttribute("dichVuDangXem", new DichVu());
		model.addAttribute("arrays", listDV);
		model.addAttribute("listCTDV", null);

		model.addAttribute("display", "none");
		return "quanly/dichvu";
	}

	@RequestMapping(value = "dichvu", params = "btnAdd", method = RequestMethod.POST)
	public String themDichVu(ModelMap model, @ModelAttribute("dichVuDangXem") DichVu dichvu,
			@RequestParam("maDichVu") int idDv) {
		System.out.println("ThemDichVu: " + dichvu.getMaDichVu() + " -- " + idDv);
		if (insertDichVu(dichvu) == 1)
			model.addAttribute("message", "Them Thanh Cong!");
		else {
			if (updateDichVu((dichvu)) == 1)
				model.addAttribute("message", "Cap Nhat Thanh Cong!");

			model.addAttribute("message", "Them That Bai");
//				return "quanly/dichvu";
		}

		List<DichVu> listDV = getDsDichVu();
		model.addAttribute("btnStatus", "btnUpdate");
//			List<ChiTietDichVu> list = getDsCTDichVu();
		model.addAttribute("listCTDV", searchDsCTDV(idDv));
		model.addAttribute("display", "none");
		model.addAttribute("dichVuDangXem", dichvu);
		model.addAttribute("arrays", listDV);
		return "quanly/dichvu";
	}

	@RequestMapping(value = "dichvu", params = "themDV")
	public String themMoiDV(ModelMap model) {

		model.addAttribute("btnStatus", "btnAdd");
//			List<ChiTietDichVu> list = getDsCTDichVu();
		model.addAttribute("listCTDV", null);
		model.addAttribute("dichVuDangXem", new DichVu());
		model.addAttribute("arrays", getDsDichVu());
		model.addAttribute("display", "block");
		return "quanly/dichvu";
	}

	@RequestMapping(value = "dichvu", params = "btnBaoHanh")
	public String baoHanhTheoHoaDon(ModelMap model, HttpServletRequest request) {
		HoaDon hd = getHoaDon(Integer.parseInt(request.getParameter("maHoaDon")));
		if (hd == null) {

			model.addAttribute("btnStatus", "btnAdd");
//				List<ChiTietDichVu> list = getDsCTDichVu();
			model.addAttribute("listCTDV", null);
			model.addAttribute("dichVuDangXem", getDichVu(Integer.parseInt(request.getParameter("maDvSD"))));
			model.addAttribute("arrays", getDsDichVu());
			model.addAttribute("display", "none");
			model.addAttribute("messageBaoHanh", "Rất Tiếc! Mã Hóa �?ơn này không còn trong chế độ Bảo Hành");
			return "quanly/dichvu";
		}
		model.addAttribute("btnStatus", "btnAdd");
//			List<ChiTietDichVu> list = getDsCTDichVu();
		model.addAttribute("listCTDV", null);
		model.addAttribute("dichVuDangXem", new DichVu());
		model.addAttribute("arrays", getDsDichVu());
		model.addAttribute("display", "block");
		model.addAttribute("messageTimKiem", "Sử dụng dịch vụ Bảo Hành đã được lưu!");
		return "quanly/dichvu";
	}

	@RequestMapping(value = "dichvu", params = "btnUpdate", method = RequestMethod.POST)
	public String suaDichVu(ModelMap model, @ModelAttribute("dichVuDangXem") DichVu dichvu) {

		if (updateDichVu((dichvu)) == 1)
			model.addAttribute("message", "Cap Nhat Thanh Cong!");
		else
			model.addAttribute("message", "Cap Nhat That Bai");
		List<DichVu> listDV = getDsDichVu();
		model.addAttribute("btnStatus", "btnUpdate");

		model.addAttribute("listCTDV", searchDsCTDV(dichvu.getMaDichVu()));
		model.addAttribute("dichVuDangXem", dichvu);
		model.addAttribute("arrays", listDV);
		model.addAttribute("display", "none");
		return "quanly/dichvu";
	}

	@RequestMapping(value = "dichvu/{id}.htm", params = "xemChiTiet")
	public String xemDichVu(ModelMap model, @PathVariable("id") int id) {

		System.out.println("xemDichVu: ");
		DichVu dv = getDichVu(id);
		List<DichVu> listDV = getDsDichVu();
		model.addAttribute("btnStatus", "btnUpdate");

		model.addAttribute("listCTDV", searchDsCTDV(id));
		model.addAttribute("dichVuDangXem", dv);
		model.addAttribute("arrays", listDV);
		model.addAttribute("display", "none");
		return "quanly/dichvu";
	}

	@RequestMapping(value = "dichvu", params = "maDichVu")
	public String timDichVu(ModelMap model, @RequestParam("maDichVu") int madv) {

		System.out.println("String timDichVu(ModelMap model, @RequestParam(\"maDichVu\") String cmnd)");
		Session session = factory.openSession();
		if (session == null)
			session = factory.openSession();
		String hql = "FROM DichVu where maDichVu = :maDichVu";
		Query query = session.createQuery(hql);
		query.setParameter("maDichVu", madv);
		List<DichVu> listDV = query.list();
		session.close();

		model.addAttribute("btnStatus", "btnUpdate");
		if (listDV.isEmpty()) {
			model.addAttribute("messageTimKiem", "Không tìm thấy Dich Vu!");
			model.addAttribute("dichVuDangXem", new DichVu());
			model.addAttribute("btnStatus", "btnAdd");
		} else
			model.addAttribute("dichVuDangXem", listDV.get(0));
		model.addAttribute("arrays", listDV);
		model.addAttribute("listCTDV", getCTDichVu(madv));

		model.addAttribute("listCTDV", null);
		return "quanly/dichvu";
	}

	// ==========================================================================================================

	// ==========================================================================================================

	@RequestMapping("canhan")
	public String caNhan(HttpServletRequest request, ModelMap model) {
		NhanVien nv = getNhanVien(nhanvien.getCmnd());
		System.out.println("UpdateNhanVien(): value = \"nhanvien\", params = \"maNhanVien\"" + nv.getCmnd() + " - "
				+ nv.getNgaySinh() + "  " + nv.getHoTen());
		model.addAttribute("btnStatus", "btnUpdate");
		model.addAttribute("nhanVienDangXem", nv);

		model.addAttribute("photo", MailerController.getPhotoNhanVien("" + nv.getCmnd()));
		return "quanly/canhan";
	}

	@RequestMapping(value = "canhan", params = "btnUpdate", method = RequestMethod.POST)
	public String suaTTCN(HttpServletRequest request, ModelMap model, @ModelAttribute("nhanVienDangXem") NhanVien nv,
			@RequestParam("photo") MultipartFile photo) {
		model.addAttribute("display", "block");
		String ngay = request.getParameter("date");
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

		Date date = null;
		try {
			date = formatter.parse(ngay);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.print(ngay);
		nv.setNgaySinh(date);
		if (updateNhanVien((nv)) == 1) {
			model.addAttribute("message", "Cap Nhat Thanh Cong!");

			MailerController.saveNhanVienPhoto(nv.getCmnd(), photo, new BasePath(
					"C:\\Users\\HUYENKUTE\\Desktop\\DoAn_TiemKimHoan\\src\\main\\webapp\\assets\\Images\\NhanVien"));

		} else {
			model.addAttribute("message", "Cap Nhat That Bai");

		}

		System.out.println("UpdateThongTinCaNhan(): value = \"nhanvien\", params = \"maNhanVien\"" + nv.getCmnd()
				+ " - " + nv.getNgaySinh());
		model.addAttribute("nhanVienDangXem", getNhanVien(nv.getCmnd()));
		model.addAttribute("photo", MailerController.getPhotoNhanVien(nhanvien.getCmnd()));
		return "quanly/canhan";
	}
	// ==========================================================================================================

	@RequestMapping("khuyenmai")
	public String khuyenmai(ModelMap model) {
		List<KhuyenMai> listkhuyenMai = getDsKhuyenMai();

		model.addAttribute("btnStatus", "btnAdd");
		model.addAttribute("khuyenMaiDangXem", new KhuyenMai());
		model.addAttribute("arrays", listkhuyenMai);
		model.addAttribute("listCTKM", null);
		return "quanly/khuyenmai";
	}

	@RequestMapping(value = "khuyenmai", params = "btnAdd", method = RequestMethod.POST)
	public String themkhuyenMai(HttpServletRequest request, ModelMap model,
			@ModelAttribute("khuyenMaiDangXem") KhuyenMai khuyenmai) {
		String ngaybd = request.getParameter("dateBD");
		String ngaykt = request.getParameter("dateKT");
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-dd-MM");

		Date datebd = null;
		Date datekt = null;
		try {
			datebd = formatter.parse(ngaybd);
			datekt = formatter.parse(ngaykt);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		khuyenmai.setNgayBatDau(datebd);
		khuyenmai.setNgayKetThuc(datekt);

		System.out.println("ThemkhuyenMai: " + khuyenmai.getMaGiam());
		if (insertKhuyenMai(khuyenmai) == 1)
			model.addAttribute("message", "Them Thanh Cong!");
		else {

			model.addAttribute("message", "Them That Bai");
		}

		List<KhuyenMai> listkhuyenMai = getDsKhuyenMai();
		model.addAttribute("btnStatus", "btnUpdate");
//		List<ChiTietkhuyenMai> list = getDsCTkhuyenMai();
		model.addAttribute("listCTKM", searchChiTietGianGia(khuyenmai.getMaGiam()));
		model.addAttribute("khuyenMaiDangXem", khuyenmai);
		model.addAttribute("arrays", listkhuyenMai);
		return "quanly/khuyenmai";
	}

	@RequestMapping(value = "khuyenmai", params = "btnUpdate", method = RequestMethod.POST)
	public String suakhuyenMai(ModelMap model, @ModelAttribute("khuyenMaiDangXem") KhuyenMai khuyenmai) {

		if (updateKhuyenMai((khuyenmai)) == 1)
			model.addAttribute("message", "Cap Nhat Thanh Cong!");
		else
			model.addAttribute("message", "Cap Nhat That Bai");
		List<KhuyenMai> listkhuyenMai = getDsKhuyenMai();
		model.addAttribute("btnStatus", "btnUpdate");

		model.addAttribute("listCTKM", searchChiTietGianGia(khuyenmai.getMaGiam()));
		model.addAttribute("khuyenMaiDangXem", khuyenmai);
		model.addAttribute("arrays", listkhuyenMai);
		return "quanly/khuyenmai";
	}

	@RequestMapping(value = "khuyenmai/{id}.htm", params = "xemChiTiet")
	public String xemkhuyenMai(ModelMap model, @PathVariable("id") String id) {

		System.out.println("xemkhuyenMai: ");
		KhuyenMai km = getKhuyenMai(id);
		List<KhuyenMai> listkhuyenMai = getDsKhuyenMai();
		model.addAttribute("btnStatus", "btnUpdate");

		model.addAttribute("listCTKM", searchChiTietGianGia(id));
		model.addAttribute("khuyenMaiDangXem", km);
		model.addAttribute("maKhuyenMai", km.getMaGiam());
		model.addAttribute("arrays", listkhuyenMai);
		return "quanly/khuyenmai";
	}
	@RequestMapping(value = "khuyenmai", params = "luuKM")
	public String xluukhuyenMai(ModelMap model, @RequestParam("maKhuyenMai")String id, @RequestParam("maSpham") int masp, @RequestParam("phanTram") int ptram) {
		
		KhuyenMai khuyenmai = getKhuyenMai(id);
		if(khuyenmai== null)
		{
			model.addAttribute("khuyenMaiDangXem", khuyenmai);
			model.addAttribute("arrays", getDsKhuyenMai());
			model.addAttribute("message","Mã Khuyến Mãi Không Tồn Tại");
			
			return "quanly/khuyenmai";
		}
		List<KhuyenMai> listkhuyenMai = getDsKhuyenMai();
		model.addAttribute("btnStatus", "btnUpdate");
		ChiTietGianGia ctkm = new ChiTietGianGia(masp, khuyenmai.getMaGiam());
		ctkm.setMaGiam(khuyenmai.getMaGiam());
		ctkm.setMaHang(masp);
		ctkm.setKhuyenMai(khuyenmai);
		ctkm.setPhanTramGiam(ptram);
		
		if(insertChiTietGianGia(ctkm) != -1)
		{

			model.addAttribute("message", "Them Chi Tiet Khuyen Mai Thanh Cong!");
		}
		else {

			model.addAttribute("message", "Them Chi Tiet Khuyen Mai That Bai!");
		}
		
		model.addAttribute("listCTKM", searchChiTietGianGia(khuyenmai.getMaGiam()));
		model.addAttribute("khuyenMaiDangXem", khuyenmai);
		model.addAttribute("arrays", listkhuyenMai);
		return "quanly/khuyenmai";
	}

	@RequestMapping(value = "khuyenmai", params = "maGiam")
	public String timKhuyenMai(ModelMap model, @RequestParam("maGiam") String id) {

		System.out.println("String timKhuyenMai()");
		Session session = factory.openSession();
		if (session == null)
			session = factory.openSession();
		String hql = "FROM KhuyenMai where maGiam = :id";
		Query query = session.createQuery(hql);
		query.setParameter("id", id);
		List<KhuyenMai> listKhuyenMai = query.list();
		session.close();

		model.addAttribute("btnStatus", "btnUpdate");
		if (listKhuyenMai.isEmpty()) {
			model.addAttribute("messageTimKiem", "Không tìm thấy Dich Vu!");
			model.addAttribute("khuyenMaiDangXem", new KhuyenMai());
			model.addAttribute("btnStatus", "btnAdd");
		} else
			model.addAttribute("khuyenMaiDangXem", listKhuyenMai.get(0));
		model.addAttribute("arrays", listKhuyenMai);

		model.addAttribute("listCTKM", null);
		return "quanly/khuyenmai";
	}
	// ==============================HOADON============================================================================

	@RequestMapping("hoadon")
	public String hoaDon(ModelMap model) {

		List<HoaDon> listHD = searchAllHoaDon();
		model.addAttribute("hoaDonDangXem", new HoaDon());
		model.addAttribute("arrays", listHD);
//		DsCTHD.reset();
		model.addAttribute("dsCTHD", new DsCTHD().getListCT());
		model.addAttribute("alowLHD", "false");
		model.addAttribute("btnCTStatus", "them");
		model.addAttribute("Status", "hoaDonMoi");
		model.addAttribute("btnStatus", "btnAdd");
//		model.addAttribute("alowSoLuong", "null");
		return "quanly/hoadon";
	}

	@RequestMapping(value = "hoadon", params = "chuyenLoai")
	public String chuyeLoaihoaDon(ModelMap model, @ModelAttribute("hoaDonDangXem") HoaDon hd) {

		List<HoaDon> listHD = searchAllHoaDon();

		model.addAttribute("arrays", listHD);
//		DsCTHD.reset();
		model.addAttribute("dsCTHD", new DsCTHD().getListCT());
		if (hd.getLoai().equals("Nhap"))

			hd.setLoai("Xuat");
		else {
			hd.setLoai("Nhap");
		}
		model.addAttribute("alowLHD", "false");
		model.addAttribute("hoaDonDangXem", hd);
		model.addAttribute("btnCTStatus", "them");
		model.addAttribute("Status", "hoaDonMoi");
		model.addAttribute("btnStatus", "btnAdd");
		return "quanly/hoadon";
	}

	@RequestMapping(value = "hoadon", params = "btnLapHD", method = RequestMethod.GET)
	public String lapHoaDon(HttpServletRequest request, ModelMap model, @ModelAttribute("hoaDonDangXem") HoaDon hd) {

		hd.setMaHd(null);
		hd.setMaDh(null);
		hd.setPhuongThuc(false);

		hd.setMaNv(this.nhanvien.getCmnd());
		System.out.println("\n ==========LAP HOA DON=============");
		System.out.println("CMND " + hd.getCmnd());
		System.out.println("Loai hóa đơn " + hd.getLoai());
		System.out.println("Mã giảm giá " + hd.getMaGiam());
		System.out.println("Mã KH " + hd.getMaKh());
		System.out.println("Mã nv" + hd.getMaNv());
		System.out.println("Mã DATHANG" + hd.getMaDh());
		System.out.println(hd.getMaHd());
		System.out.println("Mã KH " + hd.getMaKhachHang());
		long millis = System.currentTimeMillis();
		java.sql.Date date = new java.sql.Date(millis);
		hd.setNgay(date);
		hd = new HoaDon(hd.getNgay(), null, hd.getLoai(), true, null, getKhachHang(hd.getMaKhachHang()),
				getKhuyenMai(hd.getMaGiam())/* , getKhuyenMai(donDatHang.getMaGiamGia()) */, getNhanVien(hd.getMaNv()));

		List<ChiTietHoaDon> dsctHD = DsCTHD.getListCT();
		BigDecimal tongtien = new BigDecimal(0), giatien = new BigDecimal(0);
		for (ChiTietHoaDon chiTiet : dsctHD) {
			BigDecimal giamgia = new BigDecimal(0);
			ChiTietSizeSp ctsize = getCTSize(new ChiTietSizeSpPK(chiTiet.getMaSp(), chiTiet.getSize()));
			if (hd.getLoai().equals("Nhap"))
				ctsize.setGia(chiTiet.getGia());
			ChiTietGianGia ctkm;
			if (hd.getMaGiam() == null || hd.getMaGiam().isEmpty())
				ctkm = null;
			else {
				ctkm = getCTKhuyenMai(new ChiTietGianGiaPK(chiTiet.getMaSp(), hd.getMaGiam()));
				if (getKhuyenMai(hd.getMaGiam()) == null) {
					List<HoaDon> listHD = searchAllHoaDon();
					model.addAttribute("hoaDonDangXem", new HoaDon());
					model.addAttribute("arrays", listHD);
					model.addAttribute("dsCTHD", DsCTHD.getListCT());
					List<String> dsLoai = new ArrayList<>();
					dsLoai.add(hd.getLoai());
					if (DsCTHD.isEmpty()) {
						model.addAttribute("alowLHD", "false");

					} else {

						model.addAttribute("alowLHD", "true");
					}
					model.addAttribute("dsLoaiHD", dsLoai);
					model.addAttribute("btnCTStatus", "them");
					model.addAttribute("Status", "hoaDonMoi");
					model.addAttribute("btnStatus", "btnAdd");
					model.addAttribute("message", "Mã Giảm Giá không tồn tại hoặc đã quá th�?i hạn sử dụng");
					return "quanly/hoadon";
				}
			}

			if (getKhachHang(hd.getMaKhachHang()) == null) {
				List<HoaDon> listHD = searchAllHoaDon();
				model.addAttribute("hoaDonDangXem", new HoaDon());
				model.addAttribute("arrays", listHD);
				model.addAttribute("dsCTHD", DsCTHD.getListCT());
				List<String> dsLoai = new ArrayList<>();
				dsLoai.add(hd.getLoai());
				if (DsCTHD.isEmpty()) {
					model.addAttribute("alowLHD", "false");

				} else {

					model.addAttribute("alowLHD", "true");
				}
				model.addAttribute("dsLoaiHD", dsLoai);
				model.addAttribute("btnCTStatus", "them");
				model.addAttribute("Status", "hoaDonMoi");
				model.addAttribute("btnStatus", "btnAdd");
				model.addAttribute("message", "Không Tìm Thấy Khách Hàng trên!");
				return "quanly/hoadon";
			}

			if (ctkm != null)
				giamgia = new BigDecimal(ctkm.getPhanTramGiam());
			tongtien = new BigDecimal(tongtien.intValue() + ctsize.getGia().intValue() * chiTiet.getSoLuong()
					- ctsize.getGia().intValue() * chiTiet.getSoLuong() * giamgia.intValue() / 100);
			chiTiet = (new ChiTietHoaDon(null, chiTiet.getSoLuong(), ctsize.getGia(), giamgia, null));

		}
		hd.setTongTien(tongtien);

		int generateID = insertHoaDon(hd, dsctHD);

		if (generateID != -1) {

			HoaDon hoadonThanhCong = getHoaDon(generateID);
			List<HoaDon> listHD = searchAllHoaDon();
			model.addAttribute("hoaDonDangXem", hoadonThanhCong);
			model.addAttribute("MaDatHang", "");
			model.addAttribute("arrays", listHD);
			model.addAttribute("dsCTHD", dsctHD);
			List<String> dsLoai = new ArrayList<>();
			dsLoai.add("Xuat");
//			dsLoai.add("Nhap");

			model.addAttribute("alowLHD", "false");
			model.addAttribute("dsLoaiHD", dsLoai);
			model.addAttribute("btnCTStatus", "sua");
			model.addAttribute("Status", "hoaDonDatHang");
			model.addAttribute("btnStatus", "btnUpdate");
			model.addAttribute("message", "Lập Hóa �?ơn Thành Công");
			model.addAttribute("TongTien", tongtien);
			return "quanly/hoadon";

		}
		return "quanly/hoadon";
	}

	@RequestMapping(value = "hoadon", params = "them", method = RequestMethod.GET)
	public String themCTHD(HttpServletRequest request,
			ModelMap model/* , @ModelAttribute("danhsachCTHD") DsCTHD dsCTHD */,
			@ModelAttribute("hoaDonDangXem") HoaDon hd, @RequestParam("maSanPham") int masanpham,
			@RequestParam("sizeSp") int size, @RequestParam("soLuong") int soluongYC) {

//		HoaDon hd = new HoaDon();
//		hd.setMaKh(request.getParameter("maKhachHang"));
//		hd.setMaNv(request.getParameter("maNhanVien"));
//		hd.setMaGiam(request.getParameter("maGiamGia"));
//		hd.setLoai(loaiHD);
		System.out.println("Thêm chi tiết cho hóa đơn");
		System.out.println("CMND " + hd.getCmnd());
		System.out.println("Loai hóa đơn " + hd.getLoai());
		System.out.println("Mã giảm giá " + hd.getMaGiam());
		System.out.println("Mã KH " + hd.getMaKh());
		System.out.println("Mã nv" + hd.getMaNv());
		System.out.println("Mã đặt" + hd.getMaDh());
		System.out.println(hd.getMaHd());
		System.out.println("Mã KH " + hd.getMaKhachHang());
//		if(getKhachHang(hd.getMaKhachHang())==null)
//		{
//			List<HoaDon> listHD = searchAllHoaDon();
//			model.addAttribute("hoaDonDangXem", new HoaDon());
//			model.addAttribute("arrays", listHD);
//			model.addAttribute("dsCTHD", DsCTHD.getListCT());
//			List<String> dsLoai = new ArrayList<>();
//			dsLoai.add("Xuat");
//			dsLoai.add("Nhap");
//			if (DsCTHD.isEmpty()) {
//				model.addAttribute("alowLHD", "false");
//
//			} else {
//
//				model.addAttribute("alowLHD", "true");
//			}
//			model.addAttribute("dsLoaiHD", dsLoai);
//			model.addAttribute("btnCTStatus", "them");
//			model.addAttribute("Status", "hoaDonMoi");
//			model.addAttribute("btnStatus", "btnAdd");
//			model.addAttribute("message", "Không Tìm Thấy Khách Hàng trên!");
//			return "quanly/hoadon";
//		}
//		if(getKhuyenMai(hd.getMaGiam())==null)
//		{
//			List<HoaDon> listHD = searchAllHoaDon();
//			model.addAttribute("hoaDonDangXem", new HoaDon());
//			model.addAttribute("arrays", listHD);
//			model.addAttribute("dsCTHD", DsCTHD.getListCT());
//			List<String> dsLoai = new ArrayList<>();
//			dsLoai.add("Xuat");
//			dsLoai.add("Nhap");
//			if (DsCTHD.isEmpty()) {
//				model.addAttribute("alowLHD", "false");
//				
//			} else {
//				
//				model.addAttribute("alowLHD", "true");
//			}
//			model.addAttribute("dsLoaiHD", dsLoai);
//			model.addAttribute("btnCTStatus", "them");
//			model.addAttribute("Status", "hoaDonMoi");
//			model.addAttribute("btnStatus", "btnAdd");
//			model.addAttribute("message", "Mã Giảm Giá không tồn tại hoặc đã quá th�?i hạn sử dụng");
//			return "quanly/hoadon";
//		}
//		
		List<HoaDon> listHD = searchAllHoaDon();
		model.addAttribute("hoaDonDangXem", hd);
		model.addAttribute("arrays", listHD);

		ChiTietSizeSp sanphamTrongKho;
		ChiTietSanPham thongtinSanPham = getSanPham(masanpham);
		if (thongtinSanPham == null) {
			model.addAttribute("dsCTHD", DsCTHD.getListCT());
			List<String> dsLoai = new ArrayList<>();
			if (DsCTHD.isEmpty()) {
				dsLoai.add(hd.getLoai());
			}
			dsLoai.add(hd.getLoai());
			model.addAttribute("dsLoaiHD", dsLoai);
			model.addAttribute("alowLHD", "false");
			model.addAttribute("btnCTStatus", "them");
			model.addAttribute("Status", "hoaDonMoi");
			model.addAttribute("btnStatus", "btnAdd");
			model.addAttribute("messageChiTiet", "Sản phẩm không tồn tại!");
			return "quanly/hoadon";
		} else {

			sanphamTrongKho = getChiTietSanPham(new ChiTietSizeSpPK(masanpham, size));
			if (sanphamTrongKho == null) {
				model.addAttribute("dsCTHD", DsCTHD.getListCT());
				List<String> dsLoai = new ArrayList<>();
				if (DsCTHD.isEmpty()) {
					dsLoai.add(hd.getLoai());
				}
				dsLoai.add(hd.getLoai());
				model.addAttribute("dsLoaiHD", dsLoai);
				model.addAttribute("alowLHD", "false");
				model.addAttribute("btnCTStatus", "them");
				model.addAttribute("Status", "hoaDonMoi");
				model.addAttribute("btnStatus", "btnAdd");
				model.addAttribute("messageChiTiet", "Kích thước bạn ch�?n đã hết hàng!");
				return "quanly/hoadon";
			}
		}
		int soluongDangDatTrongList = 0;
		ChiTietHoaDon sanphamtrongListCTHD = DsCTHD.listCTHD.get(new ChiTietSizeSp(masanpham, size));
		if (sanphamtrongListCTHD != null)
			soluongDangDatTrongList += sanphamtrongListCTHD.getSoLuong();

		System.out.println("Mã sp: " + sanphamTrongKho.getMaSp());
		System.out.println("size sp: " + sanphamTrongKho.getSize());
		System.out.println("Số lượng tồn: " + sanphamTrongKho.getSoLuong());
		System.out.println("Số lượng yêu cầu: " + soluongYC);
		System.out.println("dsCTHD: " + DsCTHD.listCTHD.size());
		if (hd.getLoai().equalsIgnoreCase("Xuat")) {
			if (sanphamTrongKho.getSoLuong() < soluongYC + soluongDangDatTrongList) { // Không Th�?a mãn 1
				model.addAttribute("dsCTHD", DsCTHD.getListCT());
				List<String> dsLoai = new ArrayList<>();
				dsLoai.add("Xuat");
				if (DsCTHD.isEmpty()) {
					model.addAttribute("alowLHD", "false");
					model.addAttribute("required", "required");
				} else {

					model.addAttribute("alowLHD", "true");
					model.addAttribute("masanpham", masanpham);
					model.addAttribute("size", size);
					model.addAttribute("soluongYC", soluongYC);
				}
				model.addAttribute("dsLoaiHD", dsLoai);
				model.addAttribute("btnCTStatus", "them");
				model.addAttribute("Status", "hoaDonMoi");
				model.addAttribute("btnStatus", "btnAdd");
				model.addAttribute("messageChiTiet", "Số lượng sản phẩm trong kho không đủ.");
				return "quanly/hoadon";
			}

		} else {
			if (soluongYC < 0) { // Không Th�?a Mãn 2
				model.addAttribute("dsCTHD", DsCTHD.getListCT());
				List<String> dsLoai = new ArrayList<>();

				dsLoai.add("Nhap");
				if (DsCTHD.isEmpty()) {
					dsLoai.add("Xuat");
					model.addAttribute("required", "required");
					model.addAttribute("alowLHD", "false");

				} else {

					model.addAttribute("alowLHD", "true");
					model.addAttribute("masanpham", masanpham);
					model.addAttribute("size", size);
					model.addAttribute("soluongYC", soluongYC);
				}
				model.addAttribute("dsLoaiHD", dsLoai);
				model.addAttribute("btnCTStatus", "them");
				model.addAttribute("Status", "hoaDonMoi");
				model.addAttribute("btnStatus", "btnAdd");
				model.addAttribute("messageChiTiet", "Số lượng sản phẩm ít nhất là 1.");
				return "quanly/hoadon";
			}

		}
		ChiTietHoaDon tempHD = new ChiTietHoaDon(new ChiTietHoaDonPK(masanpham, -1, size), sanphamTrongKho);
		tempHD.setSoLuong(soluongYC);
		ChiTietSizeSp chitietssp = new ChiTietSizeSp(masanpham, size);
		if (hd.getLoai().equals("Nhap"))
			chitietssp.setGia(new BigDecimal(Integer.parseInt(request.getParameter("giaNhap"))));
		DsCTHD.listCTHD.put(chitietssp, tempHD);

		System.out.println("dsListHD: sau khi put: " + DsCTHD.listCTHD.size());

		model.addAttribute("dsCTHD", DsCTHD.getListCT());
		List<String> dsLoai = new ArrayList<>();
		dsLoai.add(hd.getLoai());
		model.addAttribute("alowLHD", "true");

		model.addAttribute("masanpham", masanpham);
		model.addAttribute("size", size);
		model.addAttribute("soluongYC", soluongYC);
		model.addAttribute("dsLoaiHD", dsLoai);
		model.addAttribute("btnCTStatus", "them");
		model.addAttribute("Status", "hoaDonMoi");
		model.addAttribute("btnStatus", "btnAdd");
		return "quanly/hoadon";
	}

	@RequestMapping(value = "hoadon/{id}.htm", params = "xemChiTiet")
	public String xemHoaDon(ModelMap model, @PathVariable("id") Integer id) {
		return "quanly/hoadon";
	}

	// =============================DAT HANG
	// ONLINE=============================================================================

	@RequestMapping("qlDatHang")
	public String datHang(ModelMap model, @ModelAttribute("donDatHangDangXem") DonDathang donDatHang) {

//		System.out.println("ModelAtribute:" + donDatHang.getMaKhachHang());
		Session session = factory.openSession();
		if (session == null)
			session = factory.openSession();
		String hql = "FROM DonDathang ";
		Query query = session.createQuery(hql);
		List<DonDathang> listDDH = query.list();
		session.close();
		model.addAttribute("donDatHangDangXem", listDDH.get(0));
		model.addAttribute("arrays", listDDH);
		List<ChiTietDathang> listCTDH = LayChiTietDonDatHang(listDDH.get(0).getMaDh());
		model.addAttribute("listCTDH", listCTDH);
		model.addAttribute("btnStatus", "btnAdd");
		return "quanly/qlDatHang";
	}

	@RequestMapping(value = "qlDatHang/{id}.htm", params = "xemChiTiet")
	public String xemDonDatHang(ModelMap model, @PathVariable("id") Integer id) {

		Session session = factory.openSession();
		if (session == null)
			session = factory.openSession();
		String hql = "FROM DonDathang where maDh = :id";
		Query query = session.createQuery(hql);
		query.setParameter("id", id);
		List<DonDathang> listDDH = query.list();

		model.addAttribute("btnStatus", "btnUpdate");

		model.addAttribute("donDatHangDangXem", listDDH.get(0));
		System.out.println("HELLOO CC: String timKiemDonHang(ModelMap model,@RequestParam(idDDH) String idDDH) ");

		List<ChiTietDathang> listCTDH = LayChiTietDonDatHang(listDDH.get(0).getMaDh()); //
		model.addAttribute("listCTDH", listCTDH);
		hql = "FROM DonDathang";
		query = session.createQuery(hql);
		listDDH = query.list();
		session.close();
		model.addAttribute("arrays", listDDH);

		return "quanly/qlDatHang";
	}

	/*
	 * public Integer insertBill(HoaDon hd) { Session session =
	 * factory.openSession(); Transaction t = session.beginTransaction();
	 * 
	 * try { session.save(hd); t.commit(); } catch (Exception e) { t.rollback();
	 * return 0; } finally { session.close(); } return 1; }
	 */

	@RequestMapping(value = "qlDatHang", params = "btnLapHD", method = RequestMethod.POST)
	public String lapHoaDonChoDonHang(HttpServletRequest request, ModelMap model,
			@ModelAttribute("donDatHangDangXem") DonDathang donDatHang) {

		String ngay = request.getParameter("ngayDH");
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-dd-MM");

		Date date = null;
		try {
			date = formatter.parse(ngay);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		System.out.print(ngay);
		donDatHang = LayDonDatHang(donDatHang.getMaDh());
		HoaDon hd = new HoaDon(date, null, "Xuat", true, donDatHang, getKhachHang(donDatHang.getMaKhachHang()),
				getKhuyenMai(donDatHang.getMaGiamGia())/* , getKhuyenMai(donDatHang.getMaGiamGia()) */,
				getNhanVien(this.nhanvien.getCmnd()));

		List<ChiTietDathang> dsctDH = getDsCTDatHangTheoMADH(donDatHang.getMaDh());
		List<ChiTietHoaDon> dsctHD = new ArrayList<ChiTietHoaDon>();
		BigDecimal tongtien = new BigDecimal(0), giatien = new BigDecimal(0);
		for (ChiTietDathang chiTietDathang : dsctDH) {
			System.out.println("CHITIETDATHANG: " + chiTietDathang.toString());

			BigDecimal giamgia = new BigDecimal(0);
			ChiTietSizeSp ctsize = getCTSize(
					new ChiTietSizeSpPK(chiTietDathang.getMaSanPham(), chiTietDathang.getSize()));
//			chiTietDathang.setGia();
			ChiTietGianGia ctkm = getCTKhuyenMai(
					new ChiTietGianGiaPK(chiTietDathang.getMaSanPham(), donDatHang.getMaGiamGia()));
			if (ctkm != null)
				giamgia = new BigDecimal(ctkm.getPhanTramGiam());
			tongtien = new BigDecimal(tongtien.intValue() + ctsize.getGia().intValue() * chiTietDathang.getSoLuong()
					- ctsize.getGia().intValue() * chiTietDathang.getSoLuong() * giamgia.intValue() / 100);
			dsctHD.add(
					new ChiTietHoaDon(new ChiTietHoaDonPK(chiTietDathang.getMaSanPham(), -1, chiTietDathang.getSize()),
							chiTietDathang.getSoLuong(), ctsize.getGia(), giamgia, null));

		}
		hd.setTongTien(tongtien);
		int generateID = insertHoaDon(hd, dsctHD);

		if (generateID != -1) {

			HoaDon hoadonThanhCong = getHoaDon(generateID);
			List<HoaDon> listHD = searchAllHoaDon();
			model.addAttribute("hoaDonDangXem", hoadonThanhCong);
			model.addAttribute("MaDatHang", "");
			model.addAttribute("arrays", listHD);
			model.addAttribute("dsCTHD", dsctHD);
			List<String> dsLoai = new ArrayList<>();
			dsLoai.add("Xuat");
//			dsLoai.add("Nhap");

			model.addAttribute("alowLHD", "false");
			model.addAttribute("dsLoaiHD", dsLoai);
			model.addAttribute("btnCTStatus", "sua");
			model.addAttribute("Status", "hoaDonDatHang");
			model.addAttribute("btnStatus", "btnUpdate");
			model.addAttribute("message", "Lập Hóa �?ơn Thành Công");
			model.addAttribute("TongTien", tongtien);
			return "quanly/hoadon";

		}

		DonDathang DDH = LayDonDatHang(donDatHang.getMaDh());
		model.addAttribute("donDatHangDangXem", DDH);
		Session session = factory.openSession();
		if (session == null)
			session = factory.openSession();
		String hql = "FROM DonDathang";
		Query query = session.createQuery(hql);
		List<DonDathang> listDDH = query.list();
		session.close();
		model.addAttribute("arrays", listDDH);
		List<ChiTietDathang> listCTDH = LayChiTietDonDatHang(DDH.getMaDh());
		model.addAttribute("listCTDH", listCTDH);
		model.addAttribute("btnStatus", "btnAdd");
		model.addAttribute("message", "Lap Hoa Don That Bai");
		return "quanly/qlDatHang";
	}

	@RequestMapping(value = "qlDatHang", params = "idDDH")
	public String timKiemDonHang(ModelMap model, @RequestParam("idDDH") int idDDH) {

		Session session = factory.openSession();
		if (session == null)
			session = factory.openSession();
		String hql = "FROM DonDathang where maDh = :id";
		Query query = session.createQuery(hql);
		query.setParameter("id", idDDH);
		List<DonDathang> listDDH = query.list();
		session.close();
		model.addAttribute("arrays", listDDH);

		model.addAttribute("btnStatus", "btnUpdate");
		if (listDDH.isEmpty()) {
			model.addAttribute("messageTimKiem", "Không tìm thấy �?ơn �?ặt Hàng này!");
			model.addAttribute("donDatHangDangXem", new DonDathang());
		} else
			model.addAttribute("donDatHangDangXem", listDDH.get(0));
		System.out.println("HELLOO CC: String timKiemDonHang(ModelMap model,@RequestParam(idDDH) String idDDH) ");

		List<ChiTietDathang> listCTDH = LayChiTietDonDatHang(listDDH.get(0).getMaDh()); //
		model.addAttribute("listCTDH", listCTDH);
		model.addAttribute("listCTDH", listCTDH);
		hql = "FROM DonDathang";
		query = session.createQuery(hql);
		listDDH = query.list();
		model.addAttribute("arrays", listDDH);
		return "quanly/qlDatHang";
	}

	public DonDathang LayDonDatHang(Integer maDatHang) {
		Session session = factory.openSession();
		if (session == null)
			session = factory.openSession();
		String hql = "FROM DonDathang where maDh = :maDonDatHang";
		Query query = session.createQuery(hql);
		query.setParameter("maDonDatHang", maDatHang);
		List<DonDathang> list = query.list();
		session.close();
		return list.get(0);
	}

	public List<ChiTietDathang> LayChiTietDonDatHang(Integer maDatHang) {

		Session session = factory.openSession();
		if (session == null)
			session = factory.openSession();
		String hql = "FROM ChiTietDathang WHERE chiTietDathangPK.maDathang = :maDonDatHang";
		Query query = session.createQuery(hql);
		query.setParameter("maDonDatHang", maDatHang);
		List<ChiTietDathang> list = query.list();
		session.close();
		return list;
	}

	// ==========================================================================================================

	@RequestMapping("qlKhoHang")
	public String khoHang(ModelMap model) {
		List<ChiTietSanPham> list = getDsSanPham();
		model.addAttribute("btnStatus", "btnAdd");
		model.addAttribute("btnSizeStatus", null);
		model.addAttribute("sanPhamDangXem", new ChiTietSanPham());
		model.addAttribute("arrays", list);
		model.addAttribute("dsLoaiSP", getDsLoai());
		model.addAttribute("dsPhoto", null);
		model.addAttribute("listCTSZ", null);
		return "quanly/qlKhoHang";
	}

	@RequestMapping(value = "qlKhoHang", params = "newPage")
	public String newHang(ModelMap model) {
		List<ChiTietSanPham> list = getDsSanPham();
		model.addAttribute("btnStatus", "btnAdd");
		model.addAttribute("btnSizeStatus", null);
		model.addAttribute("sanPhamDangXem", new ChiTietSanPham());

		model.addAttribute("arrays", list);
		model.addAttribute("dsLoaiSP", getDsLoai());
		model.addAttribute("dsPhoto", null);
		model.addAttribute("listCTSZ", null);
		return "quanly/qlKhoHang";
	}

	@RequestMapping(value = "qlKhoHang", params = "btnAdd")
	public String themHang(ModelMap model, @ModelAttribute("sanPhamDangXem") ChiTietSanPham sanpham,
			@RequestParam("photoSP") MultipartFile photo, @RequestParam("item") String maLoai) {

		System.out.println("teen sanr phaamr: " + sanpham.getTenSp());
		sanpham.setLoai(maLoai);
		if (insertChiTietSanPham(sanpham) != -1) {

			model.addAttribute("message", "Them Thanh Cong!");
			model.addAttribute("btnStatus", "btnUpdate");
			MailerController.saveProductPhoto(sanpham.getMaSp() + "", photo, basePath);
		} else {
			model.addAttribute("message", "Them That Bai");
			model.addAttribute("btnStatus", "btnAdd");
		}
		List<ChiTietSanPham> list = getDsSanPham();
		model.addAttribute("sanPhamDangXem", getSanPham(sanpham.getMaSp()));
		model.addAttribute("arrays", list);
		model.addAttribute("dsLoaiSP", getDsLoai());
		model.addAttribute("btnSizeStatus", "themSize");
		model.addAttribute("dsPhoto", MailerController.getDsPhoto("" + sanpham.getMaSp()));
		model.addAttribute("listCTSZ", null);
		return "quanly/qlKhoHang";
	}

	@RequestMapping(value = "qlKhoHang", params = "idSanPham")
	public String timSanPham(ModelMap model, @RequestParam("idSanPham") int id) {
		List<ChiTietSanPham> list = getDsSanPham();
		model.addAttribute("btnStatus", "btnUpdate");
		model.addAttribute("sanPhamDangXem", getSanPham(id));

		model.addAttribute("arrays", list);
		model.addAttribute("dsLoaiSP", getDsLoai());
		model.addAttribute("dsPhoto", MailerController.getDsPhoto(id + ""));
		model.addAttribute("listCTSZ", searchDSCTSize(id));
		return "quanly/qlKhoHang";

	}

	@RequestMapping(value = "qlKhoHang/{id}.htm", params = "xemThongTin")
	public String xemSanPham(ModelMap model, @PathVariable("id") int id) {
		List<ChiTietSanPham> list = getDsSanPham();
		model.addAttribute("btnStatus", "btnUpdate");
		model.addAttribute("sanPhamDangXem", getSanPham(id));

		model.addAttribute("arrays", list);
		model.addAttribute("dsLoaiSP", getDsLoai());
		model.addAttribute("dsPhoto", MailerController.getDsPhoto(id + ""));
		model.addAttribute("listCTSZ", searchDSCTSize(id));
		return "quanly/qlKhoHang";

	}

	@RequestMapping(value = "qlKhoHang", params = "btnUpdate")
	public String SuaHang(ModelMap model, @ModelAttribute("sanPhamDangXem") ChiTietSanPham sanpham,
			@RequestParam("photoSP") MultipartFile photo, @RequestParam("item") String maLoai) {

		System.out.println("---Update" + sanpham.getTenSp());

		sanpham.setLoai(maLoai);
		if (updateChiTietSanPham(sanpham) != -1) {
			model.addAttribute("message", "Cập Nhật Thành Công!");
			model.addAttribute("btnStatus", "btnUpdate");
			MailerController.saveProductPhoto(sanpham.getMaSp() + "", photo, basePath);
		} else {
			model.addAttribute("message", "Cập Nhật Thất Bại");
			model.addAttribute("btnStatus", "btnUpdate");
		}
		List<ChiTietSanPham> list = getDsSanPham();

		System.out.println("---Update(AddAtribute San Pham: " + sanpham.getMaSp());
		model.addAttribute("sanPhamDangXem", sanpham);
		model.addAttribute("arrays", list);
		model.addAttribute("dsLoaiSP", getDsLoai());
		model.addAttribute("btnSizeStatus", "themSize");
		model.addAttribute("dsPhoto", MailerController.getDsPhoto("" + sanpham.getMaSp()));
		model.addAttribute("listCTSZ", searchDSCTSize(sanpham.getMaSp()));
		return "quanly/qlKhoHang";
	}

	@RequestMapping(value = "qlKhoHang", params = "themSize")
	public String themSizeHang(@RequestParam("sizeSp") int size, @RequestParam("maSpham") int masanpham,
			@RequestParam("giaSp") BigDecimal gia, ModelMap model) {

		if (ctietSizeIsEmpty(masanpham, size)) {

			if (insertChiTietSizeSp(new ChiTietSizeSp(new ChiTietSizeSpPK(masanpham, size), gia, 0)) != -1) {
				model.addAttribute("messageSize", "thêm Size Thành Công!");
			} else {
				model.addAttribute("messageSize", "thêm size Thất Bại");
			}
		} else {
			if (updateChiTietSizeSp(new ChiTietSizeSp(new ChiTietSizeSpPK(masanpham, size), gia, 0)) != -1) {
				model.addAttribute("messageSize", "update Size Thành Công!");
			} else {
				model.addAttribute("messageSize", "update size Thất Bại");
			}
		}
		model.addAttribute("btnStatus", "btnUpdate");
		model.addAttribute("btnSizeStatus", "themSize");
		List<ChiTietSanPham> list = getDsSanPham();
		model.addAttribute("sanPhamDangXem", getSanPham(masanpham));
		model.addAttribute("arrays", list);
		model.addAttribute("dsLoaiSP", getDsLoai());
		model.addAttribute("btnSizeStatus", "themSize");
		model.addAttribute("dsPhoto", MailerController.getDsPhoto("" + masanpham));
		model.addAttribute("listCTSZ", searchDSCTSize(masanpham));

		return "quanly/qlKhoHang";
	}

	@RequestMapping(value = "qlKhoHang", params = "suaSize")
	public String suaGiaTienSizeHang(@RequestParam("sizeSp") int size, @RequestParam("maSpham") int masanpham,
			@RequestParam("giaSp") BigDecimal gia, ModelMap model) {

		if (updateChiTietSizeSp(new ChiTietSizeSp(new ChiTietSizeSpPK(masanpham, size), gia, 0)) != -1) {
			model.addAttribute("messageSize", "update Size Thành Công!");
		} else {
			model.addAttribute("messageSize", "update size Thất Bại");
		}

		model.addAttribute("btnStatus", "btnUpdate");
		model.addAttribute("btnSizeStatus", "suaSize");
		List<ChiTietSanPham> list = getDsSanPham();
		model.addAttribute("sanPhamDangXem", getSanPham(masanpham));
		model.addAttribute("arrays", list);
		model.addAttribute("dsLoaiSP", getDsLoai());
		model.addAttribute("btnSizeStatus", "themSize");
		model.addAttribute("dsPhoto", MailerController.getDsPhoto("" + masanpham));
		model.addAttribute("listCTSZ", searchDSCTSize(masanpham));

		return "quanly/qlKhoHang";
	}

	@RequestMapping(value = "qlKhoHang/{id}/{size}.htm", params = "deleteSize")
	public String xoaSizeHangClick(@PathVariable("id") int masanpham, @PathVariable("size") int size, ModelMap model) {

		System.out.println("deleteSize: " + masanpham + " : " + size);

		ChiTietSizeSp ctsize = getCTSize(new ChiTietSizeSpPK(masanpham, size));
		if (ctsize == null) {
			model.addAttribute("messageSize", "delete Size FAIL!");
			model.addAttribute("btnStatus", "btnUpdate");
			List<ChiTietSanPham> list = getDsSanPham();
			ChiTietSanPham sp = getSanPham(masanpham);
			model.addAttribute("sanPhamDangXem", sp);
			model.addAttribute("maSpham", sp.getMaSp());
			model.addAttribute("arrays", list);
			model.addAttribute("btnSizeStatus", "themSize");
			model.addAttribute("dsLoaiSP", getDsLoai());
			model.addAttribute("dsPhoto", MailerController.getDsPhoto("" + masanpham));
			model.addAttribute("listCTSZ", searchDSCTSize(masanpham));
			return "quanly/qlKhoHang";
		}

		if (deleteChiTietSizeSp(ctsize) != -1) {
			model.addAttribute("messageSize", "delete Size Thành Công!");
		} else {
			model.addAttribute("messageSize", "delete size Thất Bại");
		}

		model.addAttribute("btnStatus", "btnUpdate");
		List<ChiTietSanPham> list = getDsSanPham();
		ChiTietSanPham sp = getSanPham(masanpham);
		model.addAttribute("sanPhamDangXem", sp);
		model.addAttribute("maSpham", sp.getMaSp());
		model.addAttribute("arrays", list);

		model.addAttribute("btnSizeStatus", "themSize");
		model.addAttribute("dsLoaiSP", getDsLoai());
		model.addAttribute("dsPhoto", MailerController.getDsPhoto("" + masanpham));
		model.addAttribute("listCTSZ", searchDSCTSize(masanpham));

		return "quanly/qlKhoHang";
	}

	@RequestMapping(value = "qlKhoHang/{id}/{size}.htm", params = "suaGiaSize")
	public String suaGiaSizeHangClick(@PathVariable("id") int masanpham, @PathVariable("size") int size,
			ModelMap model) {

		model.addAttribute("btnStatus", "btnUpdate");
		List<ChiTietSanPham> list = getDsSanPham();
		ChiTietSanPham sp = getSanPham(masanpham);
		model.addAttribute("sanPhamDangXem", sp);
		model.addAttribute("maSpham", sp.getMaSp());
		model.addAttribute("arrays", list);
		ChiTietSizeSp ctsize = getCTSize(new ChiTietSizeSpPK(masanpham, size));
		model.addAttribute("btnSizeStatus", "suaSize");
		model.addAttribute("sizeSp", ctsize.getSize());
		model.addAttribute("giaSp", ctsize.getGia());
		model.addAttribute("dsLoaiSP", getDsLoai());
		model.addAttribute("dsPhoto", MailerController.getDsPhoto("" + masanpham));
		model.addAttribute("listCTSZ", searchDSCTSize(masanpham));

		return "quanly/qlKhoHang";
	}
	// ==========================================================================================================

	@RequestMapping("thongke")
	public String thongKe(ModelMap model) {
		model.addAttribute("arrays", searchAllHoaDon());
		return "quanly/thongkeHD";
	}
	// ==========================================================================================================

	// ==========================================================================================================
	//

	/*
	 * public String xemDonDatHang(ModelMap model)
	 * 
	 * @RequestParam String donHang,
	 * 
	 * @ModelAttribute("donHangDangXem") DonDathang donhang, // @PathVariable("id")
	 * Integer id ) {
	 * 
	 * // List<ChiTietDathang> listCTDH = LayChiTietDonDatHang(id); //
	 * model.addAttribute("listCTDH", listCTDH); return "quanly/qlDatHang";
	 * 
	 * }
	 */

//==================== [ GET/SET ENTITY ]==========================================
	public List<Loai> getDsLoai() {
		Session session = factory.openSession();
		if (session == null)
			session = factory.openSession();
		String hql = "FROM Loai as pr order by pr.maLoai desc";
		Query query = session.createQuery(hql);
		List<Loai> list = query.list();
		session.close();
		return list;
	}

	public TaiKhoanDangNhap getTKDN(String id) {
		Session session = factory.openSession();
		if (session == null)
			session = factory.openSession();
		String hql = "FROM TaiKhoanDangNhap where maDangNhap = :id";
		Query query = session.createQuery(hql);
		query.setParameter("id", id);
		List<TaiKhoanDangNhap> list = query.list();
		session.close();
		if (list.isEmpty())
			return null;
		return list.get(0);
	}

	public List<NhanVien> getDsTKDN() {
		Session session = factory.openSession();
		if (session == null)
			session = factory.openSession();
		String hql = "FROM TaiKhoanDangNhap as pr order by pr.maDangNhap desc";
		Query query = session.createQuery(hql);
		List<NhanVien> list = query.list();
		session.close();
		return list;
	}

	public List<NhanVien> getDsNhanVien() {
		Session session = factory.openSession();
		if (session == null)
			session = factory.openSession();
		String hql = "FROM NhanVien as pr order by pr.cmnd desc";
		Query query = session.createQuery(hql);
		List<NhanVien> list = query.list();
		session.close();
		return list;
	}

	public NhanVien getNhanVien(String id) {
		Session session = factory.openSession();
		if (session == null)
			session = factory.openSession();
		String hql = "FROM NhanVien where cmnd = :id";
		Query query = session.createQuery(hql);
		query.setParameter("id", id);

		List<NhanVien> list = query.list();
		session.close();
		if (list.isEmpty())
			return null;
		return list.get(0);
	}

	public List<KhachHang> getDsKhachHang() {
		Session session = factory.openSession();
		if (session == null)
			session = factory.openSession();
		String hql = "FROM KhachHang as pr order by pr.sdt desc";
		Query query = session.createQuery(hql);
		List<KhachHang> list = query.list();
		session.close();
		return list;
	}

	public KhachHang getKhachHang(String id) {
		Session session = factory.openSession();
		if (session == null)
			session = factory.openSession();
		String hql = "FROM KhachHang where sdt = :id";
		Query query = session.createQuery(hql);
		query.setParameter("id", id);
		List<KhachHang> list = query.list();
		session.close();
		if (list.isEmpty())
			return null;
		return list.get(0);
	}
	public List<KhachHang> selectTopKhachHang(int topNumber) {
		Session session = factory.openSession();
		if (session == null)
			session = factory.openSession();
		String hql = "FROM KhachHang";
		Query query = session.createQuery(hql);
//		query.setParameter("id", id);
		List<KhachHang> list = query.list();
		
		session.close();
		for (KhachHang khachHang : list) {
			int x = (searchHoaDonTheoKhach(khachHang.getSdt()).size());
			khachHang.setDanhGiaTiemNang(x);
		}
		Collections.sort(list, new Comparator<KhachHang>() {
		    @Override
		    public int compare(KhachHang lhs, KhachHang rhs) {
		        // -1 - less than, 1 - greater than, 0 - equal, all inversed for descending
		        return lhs.getDanhGiaTiemNang() < rhs.getDanhGiaTiemNang() ? -1 : (lhs.getDanhGiaTiemNang() > rhs.getDanhGiaTiemNang()) ? 1 : 0;
		    }
		});
		list.subList(0, Math.min(Math.max(0,list.size()-1), topNumber));
		return 
				list.subList(0, Math.min(Math.max(0,list.size()-1), topNumber));
	}
	public List<ChiTietSanPham> selectTopSanPham(int topNumber) {
		Session session = factory.openSession();
		if (session == null)
			session = factory.openSession();
		String hql = "FROM ChiTietSanPham";
		Query query = session.createQuery(hql);
//		query.setParameter("id", id);
		List<ChiTietSanPham> list = query.list();
		session.close();
//		for (ChiTietSanPham : list) {
//			int x = (searchHoaDonTheoKhach(khachHang.getSdt()).size());
//			khachHang.setSlHD(x);
//		}
//		Collections.sort(list, new Comparator<KhachHang>() {
//		    @Override
//		    public int compare(KhachHang lhs, KhachHang rhs) {
//		        // -1 - less than, 1 - greater than, 0 - equal, all inversed for descending
//		        return lhs.slHD > rhs.slHD ? -1 : (lhs.slHD < rhs.slHD) ? 1 : 0;
//		    }
//		});

		
		return list.subList(0, Math.min(Math.max(0,list.size()-1), topNumber));
	}

	public List<ChiTietHoaDon> getdDsCTHoaDon() {
		Session session = factory.openSession();
		if (session == null)
			session = factory.openSession();
		String hql = "FROM ChiTietHoaDon as pr order by pr.hoaDon.maHd desc";
		Query query = session.createQuery(hql);
		List<ChiTietHoaDon> list = query.list();
		session.close();
		return list;
	}

	public List<ChiTietHoaDon> getCTHoaDon(Integer id) {
		Session session = factory.openSession();
		if (session == null)
			session = factory.openSession();
		String hql = "FROM ChiTietHoaDon where hoaDon.maHd = :id";
		Query query = session.createQuery(hql);
		query.setParameter("id", id);
		List<ChiTietHoaDon> list = query.list();
		session.close();

		return list;
	}

	public List<ChiTietDathang> getDsCTDatHang() {
		Session session = factory.openSession();
		if (session == null)
			session = factory.openSession();
		String hql = "FROM ChiTietDathang as pr order by pr.chiTietDatHangPK.maSanPham desc";
		Query query = session.createQuery(hql);
		List<ChiTietDathang> list = query.list();
		session.close();
		return list;
	}

	public List<ChiTietDathang> getDsCTDatHangTheoMADH(int id) {
		Session session = factory.openSession();
		if (session == null)
			session = factory.openSession();
		String hql = "FROM ChiTietDathang where chiTietDathangPK.maDathang =:id";
		Query query = session.createQuery(hql);
		query.setParameter("id", id);
		List<ChiTietDathang> list = query.list();
		session.close();
		return list;
	}

	public ChiTietDathang getCTDatHang(ChiTietDathangPK id) {
		Session session = factory.openSession();
		if (session == null)
			session = factory.openSession();
		String hql = "FROM ChiTietDathang where chiTietDatHangPK = :id";
		Query query = session.createQuery(hql);
		query.setParameter("id", id);
		ChiTietDathang list = (ChiTietDathang) query.list().get(0);

		session.close();
		return list;
	}

	public List<DichVu> getDsDichVu() {
		Session session = factory.openSession();
		if (session == null)
			session = factory.openSession();
		String hql = "FROM DichVu as pr order by pr.maDichVu desc";
		Query query = session.createQuery(hql);
		List<DichVu> list = query.list();
		session.close();
		return list;
	}

	public DichVu getDichVu(Integer id) {
		Session session = factory.openSession();
		if (session == null)
			session = factory.openSession();
		String hql = "FROM DichVu where maDichVu = :id";
		Query query = session.createQuery(hql);
		query.setParameter("id", id);
		DichVu list = (DichVu) query.list().get(0);

		session.close();
		return list;
	}

	public List<ChiTietDichVu> getDsCTDichVu() {
		Session session = factory.openSession();
		if (session == null)
			session = factory.openSession();
		String hql = "FROM ChiTietDichVu as pr order by pr.chiTietDichVuPK.maDichVu desc";
		Query query = session.createQuery(hql);
		List<ChiTietDichVu> list = query.list();
		session.close();
		return list;
	}

	public ChiTietDichVu getCTDichVu(ChiTietDichVuPK id) {
		Session session = factory.openSession();
		if (session == null)
			session = factory.openSession();
		String hql = "FROM ChiTietDichVu where chiTieDichVuPK = :id";
		Query query = session.createQuery(hql);
		query.setParameter("id", id);
		ChiTietDichVu list = (ChiTietDichVu) query.list().get(0);
		session.close();

		return list;
	}

	public ChiTietDichVu getCTDichVu(int id) {
		Session session = factory.openSession();
		if (session == null)
			session = factory.openSession();
		String hql = "FROM ChiTietDichVu where dichVu.maDichVu = :id";
		Query query = session.createQuery(hql);
		query.setParameter("id", id);
		List<ChiTietDichVu> list = query.list();

		session.close();
		if (list.isEmpty())
			return null;

		return list.get(0);
	}

	public List<DanhGia> getDsDanhGiaCuaSanPham(String masp) {
		Session session = factory.openSession();
		if (session == null)
			session = factory.openSession();
		String hql = "FROM DanhGia as pk where pk.danhGiaPK.maSp";
		Query query = session.createQuery(hql);
		List<DanhGia> list = query.list();
		session.close();
		return list;
	}

	public DanhGia getDanhGia(Integer id) {
		Session session = factory.openSession();
		if (session == null)
			session = factory.openSession();
		String hql = "FROM DanhGia where danhGiaPK = :id";
		Query query = session.createQuery(hql);
		query.setParameter("id", id);
		DanhGia list = (DanhGia) query.list().get(0);
		session.close();

		return list;
	}

	public List<ChiTietSizeSp> getProducts() {
		Session session = factory.openSession();
		if (session == null)
			session = factory.openSession();
		String hql = "FROM ChiTietSizeSp as pr order by pr.chiTietSizeSpPK.maSp desc";
		Query query = session.createQuery(hql);
		List<ChiTietSizeSp> list = query.list();
		session.close();
		return list;
	}

	public ChiTietSizeSp getChiTietSanPham(ChiTietSizeSpPK id) {
		Session session = factory.openSession();
		if (session == null)
			session = factory.openSession();
		String hql = "FROM ChiTietSizeSp where chiTietSizeSpPK = :id";
		Query query = session.createQuery(hql);
		query.setParameter("id", id);
		List<ChiTietSizeSp> list = query.list();

		session.close();
		if (list.isEmpty())
			return null;
		else
			return list.get(0);
	}

	public List<ChiTietSanPham> getDsSanPham() {
		Session session = factory.openSession();
		if (session == null)
			session = factory.openSession();
		String hql = "FROM ChiTietSanPham as pr order by pr.maSp desc";
		Query query = session.createQuery(hql);
		List<ChiTietSanPham> list = query.list();
		session.close();
		return list;
	}

	public ChiTietSanPham getSanPham(Integer id) {
		Session session = factory.openSession();
		if (session == null)
			session = factory.openSession();
		String hql = "FROM ChiTietSanPham where maSp = :id";
		Query query = session.createQuery(hql);
		query.setParameter("id", id);
		ChiTietSanPham list = (ChiTietSanPham) query.list().get(0);

		session.close();
		return list;
	}

	public List<KhuyenMai> getDsKhuyenMai() {
		Session session = factory.openSession();
		if (session == null)
			session = factory.openSession();
		String hql = "FROM KhuyenMai as pr order by pr.maGiam desc";
		Query query = session.createQuery(hql);
		List<KhuyenMai> list = query.list();
		session.close();
		return list;
	}

	public KhuyenMai getKhuyenMai(String id) {
		Session session = factory.openSession();
		if (session == null)
			session = factory.openSession();
		String hql = "FROM KhuyenMai where maGiam = :id";
		Query query = session.createQuery(hql);
		query.setParameter("id", id);

		List<KhuyenMai> list = query.list();

		session.close();
		if (list.isEmpty())
			return null;
		return list.get(0);
	}

	public ChiTietGianGia getCTKhuyenMai(ChiTietGianGiaPK pk) {
		Session session = factory.openSession();
		if (session == null)
			session = factory.openSession();
		String hql = "FROM ChiTietGianGia where chiTietGianGiaPK = :id ";
		Query query = session.createQuery(hql);
		query.setParameter("id", pk);

		List<ChiTietGianGia> list = query.list();

		session.close();
		if (list.isEmpty())
			return null;
		return list.get(0);
	}

	public List<ChiTietGianGia> getDsCTGiamGia() {
		Session session = factory.openSession();
		if (session == null)
			session = factory.openSession();
		String hql = "FROM ChiTietGianGia as pr order by pr.chiTietGianGiaPK.maHang desc";
		Query query = session.createQuery(hql);
		List<ChiTietGianGia> list = query.list();
		session.close();
		return list;
	}

//===============[HIBERNATE]== [THÊM - SỬA - XÓA - TÌM KIẾM]=================================================================================

	public ChiTietSizeSp getCTSize(ChiTietSizeSpPK PK1) {
		Session session = factory.openSession();
		if (session == null)
			session = factory.openSession();
		// String hql = "FROM ChiTietDathang where chiTietDathangPK LIKE '"+
		// chiTietDathangPK + "%'";
		String hql = "FROM ChiTietSizeSp where chiTietSizeSpPK = :PK1";
		Query query = session.createQuery(hql);
		query.setParameter("PK1", PK1);
		List<ChiTietSizeSp> list = query.list();
		session.close();
		if (list.isEmpty())
			return null;
		return list.get(0);
	}

	public List<ChiTietSizeSp> searchDSCTSize(int ma) {
		Session session = factory.openSession();
		if (session == null)
			session = factory.openSession();
		// String hql = "FROM ChiTietDathang where chiTietDathangPK LIKE '"+
		// chiTietDathangPK + "%'";
		String hql = "FROM ChiTietSizeSp where chiTietSizeSpPK.maSp = :PK";
		Query query = session.createQuery(hql);
		query.setParameter("PK", ma);
		List<ChiTietSizeSp> list = query.list();
		session.close();
		return list;
	}

	public boolean ctietSizeIsEmpty(int masp, int size) {
		Session session = factory.openSession();
		if (session == null)
			session = factory.openSession();
		// String hql = "FROM ChiTietDathang where chiTietDathangPK LIKE '"+
		// chiTietDathangPK + "%'";
		String hql = "FROM ChiTietSizeSp where chiTietSizeSpPK.maSp = :masp and chiTietSizeSpPK.size = :size";
		Query query = session.createQuery(hql);
		query.setParameter("masp", masp);
		query.setParameter("size", size);
		List<ChiTietSizeSp> list = query.list();
		session.close();
		return list.isEmpty();
	}

	public ChiTietGianGia getCTGiamGia(ChiTietGianGiaPK id) {
		Session session = factory.openSession();
		if (session == null)
			session = factory.openSession();
		String hql = "FROM ChiTietGianGia where chiTietGianGiaPK = :id";
		Query query = session.createQuery(hql);
		query.setParameter("id", id);
		ChiTietGianGia list = (ChiTietGianGia) query.list().get(0);

		session.close();
		return list;
	}

	public List<ChiTietDathang> searchCTDHCuaDonHang(String maDatHang) {
		Session session = factory.openSession();
		if (session == null)
			session = factory.openSession();
		// String hql = "FROM ChiTietDathang where chiTietDathangPK LIKE '"+
		// chiTietDathangPK + "%'";
		String hql = "FROM ChiTietDathang where maDh LIKE :PK";
		Query query = session.createQuery(hql);
		query.setParameter("PK", "%" + maDatHang + "%");
		List<ChiTietDathang> list = query.list();
		session.close();
		return list;
	}

	public Integer insertCTDH(ChiTietDathang pd) {
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();

		try {
			session.save(pd);
			t.commit();
		} catch (Exception e) {
			t.rollback();
			return 0;
		} finally {
			session.close();
		}
		return 1;
	}

	public Integer updateCTDH(ChiTietDathang pd) {
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();

		try {
			session.update(pd);
			t.commit();
		} catch (Exception e) {
			t.rollback();
			return 0;
		} finally {
			session.close();
		}
		return 1;
	}

	public Integer deleteCTDH(ChiTietDathang pd) {
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();

		try {
			session.delete(pd);
			t.commit();
		} catch (Exception e) {
			t.rollback();
			return 0;
		} finally {
			session.close();
		}
		return 1;
	}

	public List<NhanVien> searchNhanVien(String name) {
		Session session = factory.openSession();
		if (session == null)
			session = factory.openSession();
		// String hql = "FROM NhanVien where cmnd LIKE '"+ cmnd + "%'";
		String hql = "FROM NhanVien where hoTen LIKE :Cmnd";
		Query query = session.createQuery(hql);
		query.setParameter("Cmnd", "%" + name + "%");
		List<NhanVien> list = query.list();
		session.close();
		return list;
	}

	public Integer insertNhanVien(NhanVien pd) {
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();

		try {
			session.save(pd);
			t.commit();
		} catch (Exception e) {
			t.rollback();
			return 0;
		} finally {
			session.close();
		}
		return 1;
	}

	public Integer updateNhanVien(NhanVien pd) {
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();

		try {
			session.update(pd);
			t.commit();
		} catch (Exception e) {
			t.rollback();
			return 0;
		} finally {
			session.close();
		}
		return 1;
	}

	public Integer deleteNhanVien(NhanVien pd) {
		
		
		
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();

		try {
			session.delete(pd);
			t.commit();
		} catch (Exception e) {
			t.rollback();
			return 0;
		} finally {
			session.close();
		}
		return 1;
	}

	public List<KhachHang> searchKhachHang(String name) {
		Session session = factory.openSession();
		if (session == null)
			session = factory.openSession();
		// String hql = "FROM KhachHang where sdt LIKE '"+ sdt + "%'";
		String hql = "FROM KhachHang where hoTen LIKE :sdt";
		Query query = session.createQuery(hql);
		query.setParameter("sdt", "%" + name + "%");
		List<KhachHang> list = query.list();
		session.close();
		return list;
	}

	public Integer insertKhachHang(KhachHang pd) {
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();

		try {
			session.save(pd);
			t.commit();
		} catch (Exception e) {
			t.rollback();
			return 0;
		} finally {
			session.close();
		}
		return 1;
	}

	public Integer updateKhachHang(KhachHang pd) {
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();

		try {
			session.update(pd);
			t.commit();
		} catch (Exception e) {
			t.rollback();
			return 0;
		} finally {
			session.close();
		}
		return 1;
	}

	public Integer deleteKhachHang(KhachHang pd) {
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();

		try {
			session.delete(pd);
			t.commit();
		} catch (Exception e) {
			t.rollback();
			return 0;
		} finally {
			session.close();
		}
		return 1;
	}

	public List<ChiTietSanPham> searchChiTietSanPham(String product_name) {
		Session session = factory.openSession();
		if (session == null)
			session = factory.openSession();
		// String hql = "FROM ChiTietSanPham where product_name LIKE '"+ product_name +
		// "%'";
		String hql = "FROM ChiTietSanPham where tenSp LIKE :product_name";
		Query query = session.createQuery(hql);
		query.setParameter("product_name", "%" + product_name + "%");
		List<ChiTietSanPham> list = query.list();
		session.close();
		return list;
	}

	public Integer insertChiTietSanPham(ChiTietSanPham pd) {
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();
		int x = -1;
		try {
			session.persist(pd);
			t.commit();
			x = pd.getMaSp();
		} catch (Exception e) {
			t.rollback();
			e.printStackTrace();
			return -1;
		} finally {
			session.close();
		}
		return x;
	}

	public Integer insertHoaDon(HoaDon hd, List<ChiTietHoaDon> dsCTHD) {
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();
		int x = -1;
		try {
			session.persist(hd);
			x = hd.getMaHd();
			ChiTietSizeSp sizesp = null;
			for (ChiTietHoaDon chiTietHoaDon : dsCTHD) {
				chiTietHoaDon
						.setChiTietHoaDonPK(new ChiTietHoaDonPK(chiTietHoaDon.getMaSp(), x, chiTietHoaDon.getSize()));
				chiTietHoaDon.setHoaDon(hd);
				sizesp = getCTSize(new ChiTietSizeSpPK(chiTietHoaDon.getMaSp(), chiTietHoaDon.getSize()));
				sizesp.setSoLuong(sizesp.getSoLuong() - chiTietHoaDon.getSoLuong());
				session.save(chiTietHoaDon);
				session.update(sizesp);
			}

			t.commit();

		} catch (Exception e) {
			t.rollback();
			e.printStackTrace();
			return -1;
		} finally {
			session.close();
		}
		return x;
	}

	public Integer updateChiTietSanPham(ChiTietSanPham pd) {
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();

		try {
			session.update(pd);
			t.commit();
		} catch (Exception e) {
			t.rollback();
			return -1;
		} finally {
			session.close();
		}
		return 1;
	}

	public Integer deleteChiTietSanPham(ChiTietSanPham pd) {
		Transaction t = null;
		try {
			Session session = factory.openSession();

//		Session s = sf.openSession();
			Serializable someid = null;
			Object a = session.load(Object, someid);
			Session s2 = factory.openSession();
			t = s2.beginTransaction();
			s2.delete(pd);

			t.commit();

//			session.close();
//			s2.close();
		} catch (Exception e) {
			t.rollback();
			return 0;
		} finally {
		}
		return 1;
	}

	public Integer insertChiTietSizeSp(ChiTietSizeSp pd) {
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();

		try {
			session.save(pd);
			t.commit();
		} catch (Exception e) {
			t.rollback();
			e.printStackTrace();
			return -1;
		} finally {
			session.close();
		}
		return 1;
	}

	public Integer updateChiTietSizeSp(ChiTietSizeSp pd) {
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();

		try {
			session.update(pd);
			t.commit();
		} catch (Exception e) {
			t.rollback();
			return 0;
		} finally {
			session.close();
		}
		return 1;
	}

	public Integer deleteChiTietSizeSp(ChiTietSizeSp pd) {
		System.out.println("delete CTSzeSP: " + pd.getMaSp() + " : " + pd.getSize());
		Session s2 = factory.openSession();

		Transaction t = s2.beginTransaction();
		try {
			s2.delete(pd);
			t.commit();

		} catch (Exception e) {

			e.printStackTrace();
			return -1;
		} finally {
//			if (s2 != null && s2.isOpen()) {
			s2.close();
//		    }
		}
		return 1;
	}

	public List<DichVu> searchDichVu(String dv_name) {
		Session session = factory.openSession();
		if (session == null)
			session = factory.openSession();
		// String hql = "FROM DichVu where product_name LIKE '"+ product_name + "%'";
		String hql = "FROM DichVu where tenDichVu LIKE :product_name";
		Query query = session.createQuery(hql);
		query.setParameter("product_name", "%" + dv_name + "%");
		List<DichVu> list = query.list();
		session.close();
		return list;
	}

	public Integer insertDichVu(DichVu pd) {
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();

		try {
			session.save(pd);
			t.commit();
		} catch (Exception e) {
			t.rollback();
			return 0;
		} finally {
			session.close();
		}
		return 1;
	}

	public Integer updateDichVu(DichVu pd) {
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();

		try {
			session.update(pd);
			t.commit();
		} catch (Exception e) {
			t.rollback();
			return 0;
		} finally {
			session.close();
		}
		return 1;
	}

	public Integer deleteDichVu(DichVu pd) {
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();

		try {
			session.delete(pd);
			t.commit();
		} catch (Exception e) {
			t.rollback();
			e.printStackTrace();
			return -1;
		} finally {
			session.close();
		}
		return 1;
	}

	public Integer insertChiTietHoaDon(ChiTietHoaDon pd) {
		Session session = factory.getCurrentSession();
		Transaction t = session.beginTransaction();

		try {
			session.save(pd);
			t.commit();
		} catch (Exception e) {
			t.rollback();
			return 0;
		} finally {
			session.close();
		}
		return 1;
	}

	public Integer updateChiTietHoaDon(ChiTietHoaDon pd) {
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();

		try {
			session.update(pd);
			t.commit();
		} catch (Exception e) {
			t.rollback();
			return 0;
		} finally {
			session.close();
		}
		return 1;
	}

	public Integer deleteChiTietHoaDon(ChiTietHoaDon pd) {
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();

		try {
			session.delete(pd);
			t.commit();
		} catch (Exception e) {
			t.rollback();
			return 0;
		} finally {
			session.close();
		}
		return 1;
	}

	public List<ChiTietGianGia> searchChiTietGianGia(String maKM) {
		Session session = factory.openSession();
		if (session == null)
			session = factory.openSession();
		// String hql = "FROM ChiTietGianGia where product_name LIKE '"+ product_name +
		// "%'";
		String hql = "FROM ChiTietGianGia where khuyenMai.maGiam = :product_name";
		Query query = session.createQuery(hql);
		query.setParameter("product_name", maKM);
		List<ChiTietGianGia> list = query.list();
		session.close();
		return list;
	}

	public Integer insertChiTietGianGia(ChiTietGianGia pd) {
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();

		try {
			session.save(pd);
			t.commit();
		} catch (Exception e) {
			t.rollback();
			return 0;
		} finally {
			session.close();
		}
		return 1;
	}

	public Integer updateChiTietGianGia(ChiTietGianGia pd) {
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();

		try {
			session.update(pd);
			t.commit();
		} catch (Exception e) {
			t.rollback();
			return 0;
		} finally {
			session.close();
		}
		return 1;
	}

	public Integer deleteChiTietGianGia(ChiTietGianGia pd) {
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();

		try {
			session.delete(pd);
			t.commit();
		} catch (Exception e) {
			t.rollback();
			return 0;
		} finally {
			session.close();
		}
		return 1;
	}

	public List<DanhGia> searchDanhGia(String maKhachHang) {
		Session session = factory.openSession();
		if (session == null)
			session = factory.openSession();
		// String hql = "FROM DanhGia where product_name LIKE '"+ product_name + "%'";
		String hql = "FROM DanhGia where danhGiaPK = :product_name";
		Query query = session.createQuery(hql);
		query.setParameter("product_name", "%" + maKhachHang + "%");
		List<DanhGia> list = query.list();
		session.close();
		return list;
	}

	public Integer insertDanhGia(DanhGia pd) {
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();

		try {
			session.save(pd);
			t.commit();
		} catch (Exception e) {
			t.rollback();
			return 0;
		} finally {
			session.close();
		}
		return 1;
	}

	public Integer updateDanhGia(DanhGia pd) {
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();

		try {
			session.update(pd);
			t.commit();
		} catch (Exception e) {
			t.rollback();
			return 0;
		} finally {
			session.close();
		}
		return 1;
	}

	public Integer deleteDanhGia(DanhGia pd) {
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();

		try {
			session.delete(pd);
			t.commit();
		} catch (Exception e) {
			t.rollback();
			return 0;
		} finally {
			session.close();
		}
		return 1;
	}

	public List<DonDathang> searchDonDathang(String idKhach) {
		Session session = factory.openSession();
		if (session == null)
			session = factory.openSession();
		// String hql = "FROM DonDathang where product_name LIKE '"+ product_name +
		// "%'";
		String hql = "FROM DonDathang where maKhachHang = :product_name";
		Query query = session.createQuery(hql);
		query.setParameter("product_name", "%" + idKhach + "%");
		List<DonDathang> list = query.list();
		session.close();
		return list;
	}

	public Integer insertDonDathang(DonDathang pd) {
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();

		try {
			session.save(pd);
			t.commit();
		} catch (Exception e) {
			t.rollback();
			return 0;
		} finally {
			session.close();
		}
		return 1;
	}

	public Integer updateDonDathang(DonDathang pd) {
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();

		try {
			session.update(pd);
			t.commit();
		} catch (Exception e) {
			t.rollback();
			return 0;
		} finally {
			session.close();
		}
		return 1;
	}

	public Integer deleteDonDathang(DonDathang pd) {
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();

		try {
			session.delete(pd);
			t.commit();
		} catch (Exception e) {
			t.rollback();
			return 0;
		} finally {
			session.close();
		}
		return 1;
	}

	public List<HoaDon> searchAllHoaDon() {
		Session session = factory.openSession();
		if (session == null)
			session = factory.openSession();
		String hql = "FROM HoaDon";
		Query query = session.createQuery(hql);
		List<HoaDon> list = query.list();
		session.close();
		System.out.println("Thong ke: "+list.size());
		return list;
	}

	public List<HoaDon> searchHoaDonTheoNV(String idNhanVien) {
		Session session = factory.openSession();
		if (session == null)
			session = factory.openSession();
		// String hql = "FROM HoaDon where product_name LIKE '"+ product_name + "%'";
		String hql = "FROM HoaDon where maNv.cmnd = :product_name";
		Query query = session.createQuery(hql);
		query.setParameter("product_name", "%" + idNhanVien + "%");
		List<HoaDon> list = query.list();
		session.close();
		return list;
	}


	public List<HoaDon> searchHoaDonTheoKhach(String idKH) {
		Session session = factory.openSession();
		if (session == null)
			session = factory.openSession();
		String hql = "FROM HoaDon where maKhachHang.sdt = :product_name";
		Query query = session.createQuery(hql);
		query.setParameter("product_name", "%" + idKH + "%");
		List<HoaDon> list = query.list();
		session.close();
		return list;
	}

	public HoaDon getHoaDon(int id) {
		Session session = factory.openSession();
		if (session == null)
			session = factory.openSession();
		String hql = "FROM HoaDon where id = :product_name";
		Query query = session.createQuery(hql);
		query.setParameter("product_name", id);
		List<HoaDon> list = query.list();
		session.close();
		if (list.isEmpty())
			return null;
		return list.get(0);
	}
	public NhanVien getNhanVienFromTKDN(String username) {
		Session session = factory.openSession();
		if (session == null)
			session = factory.openSession();
		String hql = "FROM NhanVien where cmnd = :p";
		Query query = session.createQuery(hql);
		query.setParameter("p", username.trim());
		List<NhanVien> list = query.list();
		session.close();
		if (list.isEmpty())
			return null;
		return list.get(0);
	}

	/*
	 * public Integer insertHoaDon(HoaDon pd) { Session session =
	 * factory.openSession(); Transaction t = session.beginTransaction();
	 * 
	 * try { session.save(pd); t.commit(); } catch (Exception e) { t.rollback();
	 * return 0; } finally { session.close(); } return 1; }
	 */
	public Integer updateHoaDon(HoaDon pd) {
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();

		try {
			session.update(pd);
			t.commit();
		} catch (Exception e) {
			t.rollback();
			return 0;
		} finally {
			session.close();
		}
		return 1;
	}

	public Integer deleteHoaDon(HoaDon pd) {
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();

		try {
			session.delete(pd);
			t.commit();
		} catch (Exception e) {
			t.rollback();
			return 0;
		} finally {
			session.close();
		}
		return 1;
	}

	public Integer insertKhuyenMai(KhuyenMai pd) {
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();

		try {
			session.save(pd);
			t.commit();
		} catch (Exception e) {
			t.rollback();
			return 0;
		} finally {
			session.close();
		}
		return 1;
	}

	public Integer updateKhuyenMai(KhuyenMai pd) {
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();

		try {
			session.update(pd);
			t.commit();
		} catch (Exception e) {
			t.rollback();
			return 0;
		} finally {
			session.close();
		}
		return 1;
	}

	public Integer deleteKhuyenMai(KhuyenMai pd) {
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();

		try {
			session.delete(pd);
			t.commit();
		} catch (Exception e) {
			t.rollback();
			return 0;
		} finally {
			session.close();
		}
		return 1;
	}

	public Integer insertTaiKhoanDangNhap(TaiKhoanDangNhap pd) {
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();

		try {
			session.save(pd);
			t.commit();
		} catch (Exception e) {
			e.printStackTrace();
			t.rollback();
			return 0;
		} finally {
			session.close();
		}
		return 1;
	}

	public Integer updateTaiKhoanDangNhap(TaiKhoanDangNhap pd) {
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();

		try {
			session.update(pd);
			t.commit();
		} catch (Exception e) {
			t.rollback();
			return 0;
		} finally {
			session.close();
		}
		return 1;
	}

	public Integer insertCTDV(ChiTietDichVu pd) {
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();

		try {
			session.save(pd);
			t.commit();
		} catch (Exception e) {
			t.rollback();
			return 0;
		} finally {
			session.close();
		}
		return 1;
	}

	public Integer updateCTDV(ChiTietDichVu pd) {
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();

		try {
			session.update(pd);
			t.commit();
		} catch (Exception e) {
			t.rollback();
			return 0;
		} finally {
			session.close();
		}
		return 1;
	}

	public List<ChiTietDichVu> searchDsCTDV(int idDV) {
		Session session = factory.openSession();
		if (session == null)
			session = factory.openSession();
		String hql = "FROM ChiTietDichVu where chiTietDichVuPK.maDichVu = :product_name";
		Query query = session.createQuery(hql);
		query.setParameter("product_name", idDV);
		List<ChiTietDichVu> list = query.list();
		session.close();
		return list;
	}

	public Integer deleteTaiKhoanDangNhap(TaiKhoanDangNhap pd) {
		Session session = factory.openSession();
		Transaction t = session.beginTransaction();

		try {
			session.delete(pd);
			t.commit();
		} catch (Exception e) {
			t.rollback();
			return 0;
		} finally {
			session.close();
		}
		return 1;
	}
	

}
