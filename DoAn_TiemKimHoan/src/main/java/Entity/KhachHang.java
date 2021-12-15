/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;


/**
 *
 * @author HUYENKUTE
 */
@Entity
@Table(name = "KHACH_HANG")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "KhachHang.findAll", query = "SELECT k FROM KhachHang k")})
public class KhachHang implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "SDT")
    private String sdt;
    @Column(name = "HO_TEN")
    private String hoTen;
    @Column(name = "NGAY_SINH")
    @Temporal(TemporalType.DATE)
    private Date ngaySinh;
    @Column(name = "DIA_CHI")
    private String diaChi;
    @Column(name = "DANH_GIA_TIEM_NANG")
    private Integer danhGiaTiemNang;
    @Column(name = "LUU_Y")
    private String luuY;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "maKhachHang")
    private Collection<HoaDon> hoaDonCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "khachHang")
    private Collection<DanhGia> danhGiaCollection;
    
    
    



	public KhachHang() {
    }
//    public KhachHang(beanKhachHang kh) {
//    	this.sdt = kh.getSdt();
//		this.hoTen = kh.getHoTen();
//		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-dd-MM");
//	       
//        Date date = null;
//		try {
//			date = formatter.parse(kh.getNgaySinh());
//		} catch (ParseException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		
//		this.ngaySinh = date;
//		this.diaChi = kh.getDiaChi();
//		this.danhGiaTiemNang = kh.getDanhGiaTiemNang();
//		this.luuY = kh.getLuuY();
//    }

    public KhachHang(String sdt) {
        this.sdt = sdt;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public Date getNgaySinh() {
        return ngaySinh;
    }
    public void setNgaySinh(Date ngaySinh) {
        this.ngaySinh = ngaySinh;
    }
    public void setNgaySinh(String ngaySinh) {
    	 SimpleDateFormat formatter = new SimpleDateFormat("yyyy-dd-MM");
	       
         Date date = null;
		try {
			date = formatter.parse(ngaySinh);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
    	this.ngaySinh = date;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public Integer getDanhGiaTiemNang() {
        return danhGiaTiemNang;
    }

    public void setDanhGiaTiemNang(Integer danhGiaTiemNang) {
        this.danhGiaTiemNang = danhGiaTiemNang;
    }

    public String getLuuY() {
        return luuY;
    }

    public void setLuuY(String luuY) {
        this.luuY = luuY;
    }

    @XmlTransient
    public Collection<HoaDon> getHoaDonCollection() {
        return hoaDonCollection;
    }

    public void setHoaDonCollection(Collection<HoaDon> hoaDonCollection) {
        this.hoaDonCollection = hoaDonCollection;
    }

    @XmlTransient
    public Collection<DanhGia> getDanhGiaCollection() {
        return danhGiaCollection;
    }

    public void setDanhGiaCollection(Collection<DanhGia> danhGiaCollection) {
        this.danhGiaCollection = danhGiaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (sdt != null ? sdt.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof KhachHang)) {
            return false;
        }
        KhachHang other = (KhachHang) object;
        if ((this.sdt == null && other.sdt != null) || (this.sdt != null && !this.sdt.equals(other.sdt))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.KhachHang[ sdt=" + sdt + " ]";
    }
    
}
