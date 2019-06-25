package entity;

import entity.Clientes;
import entity.Poblaciones;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-06-25T18:11:46")
@StaticMetamodel(Provincias.class)
public class Provincias_ { 

    public static volatile ListAttribute<Provincias, Clientes> clientesList;
    public static volatile SingularAttribute<Provincias, Integer> codigoprovincia;
    public static volatile SingularAttribute<Provincias, String> provincia;
    public static volatile ListAttribute<Provincias, Poblaciones> poblacionesList;

}