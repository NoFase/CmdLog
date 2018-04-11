package processing;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

public class MyDate {

    private SimpleDateFormat form = new SimpleDateFormat("yyyy&MM&dd hh&mm");
    private LocalDateTime localDate;


    public Date setStartTime(){
        String time[] = form.format(new Date().getTime()).split("\\s+")[0].split("&");
//        need write check when changing month, and year
//        return new Date(Integer.parseInt(time[0])- 1900, 3, 5, 12, 37); // for testing
        localDate = LocalDate.now().plusDays(1).atTime(1, 0);
//        return new Date(Integer.parseInt(time[0])- 1900, Integer.parseInt(time[1]) - 1, Integer.parseInt(time[2]) + 1, 01, 00);
        return java.sql.Date.valueOf(String.valueOf(localDate));
    }

    public String dateForCommand (long period){
        return form.format(new Date().getTime() - period).split("\\s+")[0];
    }
    public String localDate(){
        return form.format(new Date().getTime());
    }

}
