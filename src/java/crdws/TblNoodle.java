/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crdws;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Huy Nguyen
 */
@Entity
@Table(name = "tblNoodle")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblNoodle.findAll", query = "SELECT t FROM TblNoodle t")
    , @NamedQuery(name = "TblNoodle.findByNoodleId", query = "SELECT t FROM TblNoodle t WHERE t.noodleId = :noodleId")
    , @NamedQuery(name = "TblNoodle.findByNoodleName", query = "SELECT t FROM TblNoodle t WHERE t.noodleName = :noodleName")
    , @NamedQuery(name = "TblNoodle.findByPrice", query = "SELECT t FROM TblNoodle t WHERE t.price = :price")})
public class TblNoodle implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name = "NoodleId")
    private Integer noodleId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 500)
    @Column(name = "NoodleName")
    private String noodleName;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "Price")
    private BigDecimal price;

    public TblNoodle() {
    }

    public TblNoodle(Integer noodleId) {
        this.noodleId = noodleId;
    }

    public TblNoodle(Integer noodleId, String noodleName, BigDecimal price) {
        this.noodleId = noodleId;
        this.noodleName = noodleName;
        this.price = price;
    }

    public Integer getNoodleId() {
        return noodleId;
    }

    public void setNoodleId(Integer noodleId) {
        this.noodleId = noodleId;
    }

    public String getNoodleName() {
        return noodleName;
    }

    public void setNoodleName(String noodleName) {
        this.noodleName = noodleName;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (noodleId != null ? noodleId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblNoodle)) {
            return false;
        }
        TblNoodle other = (TblNoodle) object;
        if ((this.noodleId == null && other.noodleId != null) || (this.noodleId != null && !this.noodleId.equals(other.noodleId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "crdws.TblNoodle[ noodleId=" + noodleId + " ]";
    }
    
}
