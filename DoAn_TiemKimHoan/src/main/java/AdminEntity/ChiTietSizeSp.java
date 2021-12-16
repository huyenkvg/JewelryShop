/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AdminEntity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author HUYENKUTE
 */
@Entity
@Table(name = "CHI_TIET_SIZE_SP")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ChiTietSizeSp.findAll", query = "SELECT c FROM ChiTietSizeSp c")})
public class ChiTietSizeSp implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ChiTietSizeSpPK chiTietSizeSpPK;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "GIA")
    private BigDecimal gia;
    @Column(name = "SO_LUONG")
    private Integer soLuong;
    @JoinColumn(name = "MA_SP", referencedColumnName = "MA_SP", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private ChiTietSanPham chiTietSanPham;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "chiTietSizeSp")
    private Collection<ChiTietHoaDon> chiTietHoaDonCollection;
    
    public void setSize(ChiTietSizeSpPK pk) {
    	chiTietSizeSpPK = pk;
    }
    
    
    public void setSize(int s)
    {
    	chiTietSizeSpPK.setSize(s);
    }
   

	public int getSize()
    {
    	return chiTietSizeSpPK.getSize();
    }
    public void setMaSp(int s)
    {

    	chiTietSizeSpPK = new ChiTietSizeSpPK();
    	chiTietSizeSpPK.setMaSp(s);
    }
    public int getMaSp()
    {
    	return chiTietSizeSpPK.getMaSp();
    }
    public ChiTietSizeSp() {

    	chiTietSizeSpPK = new ChiTietSizeSpPK();
    }

    public ChiTietSizeSp(ChiTietSizeSpPK chiTietSizeSpPK) {
        this.chiTietSizeSpPK = chiTietSizeSpPK;
    }

    public ChiTietSizeSp(int maSp, int size) {
        this.chiTietSizeSpPK = new ChiTietSizeSpPK(maSp, size);
    }

    public ChiTietSizeSp(ChiTietSizeSpPK chiTietSizeSpPK, BigDecimal gia, Integer soLuong) {
		super();
		this.chiTietSizeSpPK = chiTietSizeSpPK;
		this.gia = gia;
		this.soLuong = soLuong;
	}


	public ChiTietSizeSpPK getChiTietSizeSpPK() {
        return chiTietSizeSpPK;
    }

    public void setChiTietSizeSpPK(ChiTietSizeSpPK chiTietSizeSpPK) {
        this.chiTietSizeSpPK = chiTietSizeSpPK;
    }

    public BigDecimal getGia() {
        return gia;
    }

    public void setGia(BigDecimal gia) {
        this.gia = gia;
    }

    public Integer getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(Integer soLuong) {
        this.soLuong = soLuong;
    }

    public ChiTietSanPham getChiTietSanPham() {
        return chiTietSanPham;
    }

    public void setChiTietSanPham(ChiTietSanPham chiTietSanPham) {
        this.chiTietSanPham = chiTietSanPham;
    }

    @XmlTransient
    public Collection<ChiTietHoaDon> getChiTietHoaDonCollection() {
        return chiTietHoaDonCollection;
    }

    public void setChiTietHoaDonCollection(Collection<ChiTietHoaDon> chiTietHoaDonCollection) {
        this.chiTietHoaDonCollection = chiTietHoaDonCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (chiTietSizeSpPK != null ? chiTietSizeSpPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ChiTietSizeSp)) {
            return false;
        }
        ChiTietSizeSp other = (ChiTietSizeSp) object;
        if ((this.chiTietSizeSpPK == null && other.chiTietSizeSpPK != null) || (this.chiTietSizeSpPK != null && !this.chiTietSizeSpPK.equals(other.chiTietSizeSpPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.ChiTietSizeSp[ chiTietSizeSpPK=" + chiTietSizeSpPK + " ]";
    }
    
}
