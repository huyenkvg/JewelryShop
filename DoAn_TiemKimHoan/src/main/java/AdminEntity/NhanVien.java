/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AdminEntity;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author HUYENKUTE
 */
@Entity
@Table(name = "NHAN_VIEN")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "NhanVien.findAll", query = "SELECT n FROM NhanVien n")})
public class NhanVien implements Serializable {

    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @Column(name = "SDT")
    private String sdt;
    @Basic(optional = false)
    @Column(name = "HO_TEN")
    private String hoTen;
    @Basic(optional = false)
    @Column(name = "NGAY_SINH")
    @Temporal(TemporalType.DATE)
    private Date ngaySinh;
    @Id
    @Basic(optional = false)
    @Column(name = "CMND")
    private String cmnd;
    @Basic(optional = false)
    @Column(name = "EMAIL")
    private String email;
    @Column(name = "GIOI_TINH")
    private Boolean gioiTinh;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "nhanVien")
    private TaiKhoanDangNhap taiKhoanDangNhap;

    public NhanVien() {
    }

    public NhanVien(String cmnd) {
        this.cmnd = cmnd;
    }

    public NhanVien(String cmnd, String sdt, String hoTen, Date ngaySinh, String email) {
        this.cmnd = cmnd;
        this.sdt = sdt;
        this.hoTen = hoTen;
        this.ngaySinh = ngaySinh;
        this.email = email;
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

 

    public String getCmnd() {
		return cmnd;
	}

	public void setCmnd(String cmnd) {
		this.cmnd = cmnd;
	}

	public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Boolean getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(Boolean gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public TaiKhoanDangNhap getTaiKhoanDangNhap() {
        return taiKhoanDangNhap;
    }

    public void setTaiKhoanDangNhap(TaiKhoanDangNhap taiKhoanDangNhap) {
        this.taiKhoanDangNhap = taiKhoanDangNhap;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cmnd != null ? cmnd.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof NhanVien)) {
            return false;
        }
        NhanVien other = (NhanVien) object;
        if ((this.cmnd == null && other.cmnd != null) || (this.cmnd != null && !this.cmnd.equals(other.cmnd))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.NhanVien_1[ cmnd=" + cmnd + " ]";
    }
    
}
