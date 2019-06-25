package entity;

import entity.Customers;
import entity.Employees;
import entity.Offices;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-06-25T16:45:44")
@StaticMetamodel(Employees.class)
public class Employees_ { 

    public static volatile ListAttribute<Employees, Customers> customersList;
    public static volatile SingularAttribute<Employees, String> firstname;
    public static volatile SingularAttribute<Employees, String> extension;
    public static volatile ListAttribute<Employees, Employees> employeesList;
    public static volatile SingularAttribute<Employees, Integer> employeenumber;
    public static volatile SingularAttribute<Employees, String> jobtitle;
    public static volatile SingularAttribute<Employees, Offices> officecode;
    public static volatile SingularAttribute<Employees, Employees> reportsto;
    public static volatile SingularAttribute<Employees, String> email;
    public static volatile SingularAttribute<Employees, String> lastname;

}