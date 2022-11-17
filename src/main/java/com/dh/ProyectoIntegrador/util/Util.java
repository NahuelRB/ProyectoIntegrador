package com.dh.ProyectoIntegrador.util;

import java.sql.Timestamp;
import java.util.Date;

public class Util {

    public static Timestamp dateToTimestamp(Date date){
        Timestamp timestamp = new Timestamp(date.getTime());
        return timestamp;
    }

    //Convierte un Date en un SQL DAte
    public static java.sql.Date utilDateToSqlDate(Date utilDate){
        long timeInMiliseconds = utilDate.getTime();
        java.sql.Date sqlDate = new java.sql.Date(timeInMiliseconds);
        return sqlDate;
    }

}
