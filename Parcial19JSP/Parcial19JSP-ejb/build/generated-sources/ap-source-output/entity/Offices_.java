package entity;

import entity.Employees;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-06-25T16:45:44")
@StaticMetamodel(Offices.class)
public class Offices_ { 

    public static volatile SingularAttribute<Offices, String> country;
    public static volatile ListAttribute<Offices, Employees> employeesList;
    public static volatile SingularAttribute<Offices, String> city;
    public static volatile SingularAttribute<Offices, String> phone;
    public static volatile SingularAttribute<Offices, String> postalcode;
    public static volatile SingularAttribute<Offices, String> officecode;
    public static volatile SingularAttribute<Offices, String> addressline2;
    public static volatile SingularAttribute<Offices, String> addressline1;
    public static volatile SingularAttribute<Offices, String> state;
    public static volatile SingularAttribute<Offices, String> territory;

}