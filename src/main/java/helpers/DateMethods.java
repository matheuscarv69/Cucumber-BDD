package helpers;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateMethods {




    public static Date calcularDataEntrega(Integer diasAlugados) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());
        cal.add(Calendar.DAY_OF_MONTH, diasAlugados);

        return cal.getTime();
    }

    public static String sdfFormater(Date date) {
        DateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        return sdf.format(date);
    }

}
