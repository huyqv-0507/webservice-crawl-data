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
import javax.persistence.Lob;
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
@Table(name = "tblMedicine")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TblMedicine.findAll", query = "SELECT t FROM TblMedicine t")
    , @NamedQuery(name = "TblMedicine.findByMedicineId", query = "SELECT t FROM TblMedicine t WHERE t.medicineId = :medicineId")
    , @NamedQuery(name = "TblMedicine.findByMedicineName", query = "SELECT t FROM TblMedicine t WHERE t.medicineName = :medicineName")
    , @NamedQuery(name = "TblMedicine.findByPrice", query = "SELECT t FROM TblMedicine t WHERE t.price = :price")
    , @NamedQuery(name = "TblMedicine.findByPacking", query = "SELECT t FROM TblMedicine t WHERE t.packing = :packing")
    , @NamedQuery(name = "TblMedicine.findByCategoryName", query = "SELECT t FROM TblMedicine t WHERE t.categoryName = :categoryName")})
public class TblMedicine implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name = "MedicineId")
    private Integer medicineId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "MedicineName")
    private String medicineName;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "Price")
    private BigDecimal price;
    @Size(max = 100)
    @Column(name = "Packing")
    private String packing;
    @Lob
    @Size(max = 2147483647)
    @Column(name = "Description")
    private String description;
    @Size(max = 100)
    @Column(name = "CategoryName")
    private String categoryName;

    public TblMedicine() {
    }

    public TblMedicine(Integer medicineId) {
        this.medicineId = medicineId;
    }

    public TblMedicine(Integer medicineId, String medicineName, BigDecimal price) {
        this.medicineId = medicineId;
        this.medicineName = medicineName;
        this.price = price;
    }

    public Integer getMedicineId() {
        return medicineId;
    }

    public void setMedicineId(Integer medicineId) {
        this.medicineId = medicineId;
    }

    public String getMedicineName() {
        return medicineName;
    }

    public void setMedicineName(String medicineName) {
        this.medicineName = medicineName;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getPacking() {
        return packing;
    }

    public void setPacking(String packing) {
        this.packing = packing;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (medicineId != null ? medicineId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TblMedicine)) {
            return false;
        }
        TblMedicine other = (TblMedicine) object;
        if ((this.medicineId == null && other.medicineId != null) || (this.medicineId != null && !this.medicineId.equals(other.medicineId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "crdws.TblMedicine[ medicineId=" + medicineId + " ]";
    }
    
}
