package com.modelo;

import com.modelo.Historia;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-08-24T16:43:18")
@StaticMetamodel(Lugar.class)
public class Lugar_ { 

    public static volatile CollectionAttribute<Lugar, Historia> historiaCollection;
    public static volatile SingularAttribute<Lugar, Date> fechaLugar;
    public static volatile SingularAttribute<Lugar, String> descripcionLugar;
    public static volatile SingularAttribute<Lugar, Integer> idLugar;
    public static volatile SingularAttribute<Lugar, String> nombreLugar;

}