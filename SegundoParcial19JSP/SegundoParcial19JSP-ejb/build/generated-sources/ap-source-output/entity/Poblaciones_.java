package entity;

import entity.Callespoblaciones;
import entity.Clientes;
import entity.Provincias;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-06-25T18:11:46")
@StaticMetamodel(Poblaciones.class)
public class Poblaciones_ { 

    public static volatile SingularAttribute<Poblaciones, Integer> habitantes;
    public static volatile ListAttribute<Poblaciones, Clientes> clientesList;
    public static volatile SingularAttribute<Poblaciones, String> codigopoblacion;
    public static volatile SingularAttribute<Poblaciones, Provincias> codigoprovincia;
    public static volatile SingularAttribute<Poblaciones, String> poblacion;
    public static volatile ListAttribute<Poblaciones, Callespoblaciones> callespoblacionesList;

}