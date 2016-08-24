package com.modelo;

import com.modelo.Lugar;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-08-24T16:43:18")
@StaticMetamodel(Historia.class)
public class Historia_ { 

    public static volatile SingularAttribute<Historia, String> nombreHistoria;
    public static volatile SingularAttribute<Historia, Integer> idHistoria;
    public static volatile SingularAttribute<Historia, Date> fechaHistoria;
    public static volatile SingularAttribute<Historia, String> descripcionHistoria;
    public static volatile SingularAttribute<Historia, Lugar> idLugar;

}