package entity;

import entity.Employees;
import entity.Orders;
import entity.Payments;
import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-06-25T16:45:44")
@StaticMetamodel(Customers.class)
public class Customers_ { 

    public static volatile SingularAttribute<Customers, Integer> customernumber;
    public static volatile SingularAttribute<Customers, String> country;
    public static volatile SingularAttribute<Customers, String> contactfirstname;
    public static volatile ListAttribute<Customers, Payments> paymentsList;
    public static volatile SingularAttribute<Customers, String> city;
    public static volatile SingularAttribute<Customers, String> contactlastname;
    public static volatile SingularAttribute<Customers, String> phone;
    public static volatile SingularAttribute<Customers, String> postalcode;
    public static volatile SingularAttribute<Customers, String> addressline2;
    public static volatile SingularAttribute<Customers, String> addressline1;
    public static volatile SingularAttribute<Customers, Employees> salesrepemployeenumber;
    public static volatile SingularAttribute<Customers, String> state;
    public static volatile SingularAttribute<Customers, String> customername;
    public static volatile SingularAttribute<Customers, BigDecimal> creditlimit;
    public static volatile ListAttribute<Customers, Orders> ordersList;

}