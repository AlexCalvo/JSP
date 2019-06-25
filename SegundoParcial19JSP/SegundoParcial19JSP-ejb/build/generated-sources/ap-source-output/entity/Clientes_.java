package entity;

import entity.Callespoblaciones;
import entity.Mediciones;
import entity.Poblaciones;
import entity.Provincias;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-06-25T18:11:46")
@StaticMetamodel(Clientes.class)
public class Clientes_ { 

    public static volatile SingularAttribute<Clientes, String> apellido2;
    public static volatile SingularAttribute<Clientes, Integer> piso;
    public static volatile SingularAttribute<Clientes, Integer> codigo;
    public static volatile ListAttribute<Clientes, Mediciones> medicionesList;
    public static volatile SingularAttribute<Clientes, Integer> numero;
    public static volatile SingularAttribute<Clientes, Poblaciones> codigopoblacion;
    public static volatile SingularAttribute<Clientes, String> apellido;
    public static volatile SingularAttribute<Clientes, Callespoblaciones> calle;
    public static volatile SingularAttribute<Clientes, Provincias> codigoprovincia;
    public static volatile SingularAttribute<Clientes, String> nombre;
    public static volatile SingularAttribute<Clientes, Integer> metros;

}