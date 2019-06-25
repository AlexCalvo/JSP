package entity;

import entity.Orderdetails;
import entity.Productlines;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-06-25T16:45:44")
@StaticMetamodel(Products.class)
public class Products_ { 

    public static volatile SingularAttribute<Products, String> productscale;
    public static volatile SingularAttribute<Products, Productlines> productline;
    public static volatile SingularAttribute<Products, String> productcode;
    public static volatile SingularAttribute<Products, String> productvendor;
    public static volatile SingularAttribute<Products, String> productdescription;
    public static volatile SingularAttribute<Products, String> buyprice;
    public static volatile SingularAttribute<Products, Integer> quantityinstock;
    public static volatile SingularAttribute<Products, String> msrp;
    public static volatile ListAttribute<Products, Orderdetails> orderdetailsList;
    public static volatile SingularAttribute<Products, String> productname;

}