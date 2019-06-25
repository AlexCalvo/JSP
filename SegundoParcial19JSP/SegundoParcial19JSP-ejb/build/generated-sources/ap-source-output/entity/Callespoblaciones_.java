package entity;

import entity.Clientes;
import entity.Poblaciones;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-06-25T18:11:46")
@StaticMetamodel(Callespoblaciones.class)
public class Callespoblaciones_ { 

    public static volatile ListAttribute<Callespoblaciones, Clientes> clientesList;
    public static volatile SingularAttribute<Callespoblaciones, Poblaciones> codpoblacion;
    public static volatile SingularAttribute<Callespoblaciones, Integer> codpostal;
    public static volatile SingularAttribute<Callespoblaciones, String> nombre;
    public static volatile SingularAttribute<Callespoblaciones, Integer> idcalle;

}