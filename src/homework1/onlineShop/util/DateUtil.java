package homework1.onlineShop.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public  abstract class DateUtil {

   public static final SimpleDateFormat  SDF = new SimpleDateFormat("dd-MM-yyyy");
   public static Date stringToDate(String dateStr) throws ParseException {
      return SDF.parse(dateStr);
   }


   public static String dateTString(Date date){
      return SDF.format(date);
   }

}
