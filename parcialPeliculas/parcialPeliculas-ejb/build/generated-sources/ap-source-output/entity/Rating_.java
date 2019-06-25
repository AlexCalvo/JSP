package entity;

import entity.Film;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-06-25T17:07:42")
@StaticMetamodel(Rating.class)
public class Rating_ { 

    public static volatile SingularAttribute<Rating, Short> ratingId;
    public static volatile ListAttribute<Rating, Film> filmList;
    public static volatile SingularAttribute<Rating, String> description;

}