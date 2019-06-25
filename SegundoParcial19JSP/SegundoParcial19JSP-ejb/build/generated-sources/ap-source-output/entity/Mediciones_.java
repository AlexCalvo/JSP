package entity;

import entity.Clientes;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-06-25T18:11:46")
@StaticMetamodel(Mediciones.class)
public class Mediciones_ { 

    public static volatile SingularAttribute<Mediciones, Date> fechahora;
    public static volatile SingularAttribute<Mediciones, Clientes> cliente;
    public static volatile SingularAttribute<Mediciones, Integer> idmedicion;
    public static volatile SingularAttribute<Mediciones, Double> kw;

}