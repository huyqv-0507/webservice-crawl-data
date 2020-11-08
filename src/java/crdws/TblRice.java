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
@Table(name = "tblRice")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblRice.findAll", query = "SELECT t FROM TblRice t")
    , @NamedQuery(name = "TblRice.findByRiceId", query = "SELECT t FROM TblRice t WHERE t.riceId = :riceId")
    , @NamedQuery(name = "TblRice.findByRiceName", query = "SELECT t FROM TblRice t WHERE t.riceName = :riceName")
    , @NamedQuery(name = "TblRice.findByPrice", query = "SELECT t FROM TblRice t WHERE t.price = :price")})
public class TblRice implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name = "RiceId")
    private Integer riceId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "RiceName")
    private String riceName;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "Price")
    private BigDecimal price;

    public TblRice() {
    }

    public TblRice(Integer riceId) {
        this.riceId = riceId;
    }

    public TblRice(Integer riceId, String riceName, BigDecimal price) {
        this.riceId = riceId;
        this.riceName = riceName;
        this.price = price;
    }

    public Integer getRiceId() {
        return riceId;
    }

    public void setRiceId(Integer riceId) {
        this.riceId = riceId;
    }

    public String getRiceName() {
        return riceName;
    }

    public void setRiceName(String riceName) {
        this.riceName = riceName;
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
        hash += (riceId != null ? riceId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblRice)) {
            return false;
        }
        TblRice other = (TblRice) object;
        if ((this.riceId == null && other.riceId != null) || (this.riceId != null && !this.riceId.equals(other.riceId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "crdws.TblRice[ riceId=" + riceId + " ]";
    }
    
}
