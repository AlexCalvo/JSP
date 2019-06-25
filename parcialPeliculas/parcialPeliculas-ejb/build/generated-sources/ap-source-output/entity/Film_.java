package entity;

import entity.Actor;
import entity.Category;
import entity.Language;
import entity.Rating;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-06-25T17:07:42")
@StaticMetamodel(Film.class)
public class Film_ { 

    public static volatile SingularAttribute<Film, Short> fLength;
    public static volatile SingularAttribute<Film, String> rentalRate;
    public static volatile SingularAttribute<Film, Short> rentalDuration;
    public static volatile SingularAttribute<Film, Language> languageId;
    public static volatile SingularAttribute<Film, String> description;
    public static volatile SingularAttribute<Film, String> replacementCost;
    public static volatile SingularAttribute<Film, String> title;
    public static volatile SingularAttribute<Film, String> specialFeatures;
    public static volatile SingularAttribute<Film, Short> filmId;
    public static volatile SingularAttribute<Film, Rating> ratingId;
    public static volatile ListAttribute<Film, Category> categoryList;
    public static volatile ListAttribute<Film, Actor> actorList;
    public static volatile SingularAttribute<Film, Integer> releaseYear;

}