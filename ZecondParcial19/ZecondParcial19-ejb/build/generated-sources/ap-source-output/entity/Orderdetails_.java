package entity;

import entity.OrderdetailsPK;
import entity.Orders;
import entity.Products;
import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-06-25T17:04:08")
@StaticMetamodel(Orderdetails.class)
public class Orderdetails_ { 

    public static volatile SingularAttribute<Orderdetails, OrderdetailsPK> orderdetailsPK;
    public static volatile SingularAttribute<Orderdetails, BigDecimal> priceeach;
    public static volatile SingularAttribute<Orderdetails, Orders> orders;
    public static volatile SingularAttribute<Orderdetails, Integer> orderlinenumber;
    public static volatile SingularAttribute<Orderdetails, Integer> quantityordered;
    public static volatile SingularAttribute<Orderdetails, Products> products;

}