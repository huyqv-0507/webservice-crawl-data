package crdws;

import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-11-05T10:34:42")
@StaticMetamodel(TblMedicine.class)
public class TblMedicine_ { 

    public static volatile SingularAttribute<TblMedicine, Integer> medicineId;
    public static volatile SingularAttribute<TblMedicine, BigDecimal> price;
    public static volatile SingularAttribute<TblMedicine, String> description;
    public static volatile SingularAttribute<TblMedicine, String> packing;
    public static volatile SingularAttribute<TblMedicine, String> categoryName;
    public static volatile SingularAttribute<TblMedicine, String> medicineName;

}