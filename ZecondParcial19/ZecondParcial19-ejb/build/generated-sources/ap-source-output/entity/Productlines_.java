package entity;

import entity.Products;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-06-25T17:04:08")
@StaticMetamodel(Productlines.class)
public class Productlines_ { 

    public static volatile SingularAttribute<Productlines, String> productline;
    public static volatile SingularAttribute<Productlines, String> image;
    public static volatile SingularAttribute<Productlines, String> htmldescription;
    public static volatile ListAttribute<Productlines, Products> productsList;
    public static volatile SingularAttribute<Productlines, String> textdescription;

}