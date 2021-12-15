/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AdminEntity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author HUYENKUTE
 */
@Entity
@Table(name = "CHI_TIET_DICH_VU")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ChiTietDichVu.findAll", query = "SELECT c FROM ChiTietDichVu c")})
public class ChiTietDichVu implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ChiTietDichVuPK chiTietDichVuPK;
    @JoinColumn(name = "MA_DICH_VU", referencedColumnName = "MA_DICH_VU", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private DichVu dichVu;
    @JoinColumn(name = "MA_HD", referencedColumnName = "MA_HD", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private HoaDon hoaDon;

    
    public int getMaDV() {
    	return dichVu.getMaDichVu();
    }
    public int getMaHD() {
    	return hoaDon.getMaHd();
    }
    public String getNgaySD() {
    	return chiTietDichVuPK.getNgaySd().toString();
    }
    
    public ChiTietDichVu() {
    }

    public ChiTietDichVu(ChiTietDichVuPK chiTietDichVuPK) {
        this.chiTietDichVuPK = chiTietDichVuPK;
    }

    public ChiTietDichVu(int maHd, int maDichVu, Date ngaySd) {
        this.chiTietDichVuPK = new ChiTietDichVuPK(maHd, maDichVu, ngaySd);
    }

    public ChiTietDichVuPK getChiTietDichVuPK() {
        return chiTietDichVuPK;
    }

    public void setChiTietDichVuPK(ChiTietDichVuPK chiTietDichVuPK) {
        this.chiTietDichVuPK = chiTietDichVuPK;
    }

    public DichVu getDichVu() {
        return dichVu;
    }

    public void setDichVu(DichVu dichVu) {
        this.dichVu = dichVu;
    }

    public HoaDon getHoaDon() {
        return hoaDon;
    }

    public void setHoaDon(HoaDon hoaDon) {
        this.hoaDon = hoaDon;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (chiTietDichVuPK != null ? chiTietDichVuPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ChiTietDichVu)) {
            return false;
        }
        ChiTietDichVu other = (ChiTietDichVu) object;
        if ((this.chiTietDichVuPK == null && other.chiTietDichVuPK != null) || (this.chiTietDichVuPK != null && !this.chiTietDichVuPK.equals(other.chiTietDichVuPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.ChiTietDichVu[ chiTietDichVuPK=" + chiTietDichVuPK + " ]";
    }
    
}
