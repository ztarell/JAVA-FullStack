import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.*;
import java.util.Calendar;
import java.util.Date;
import java.lang.String;

class Birthday_Calculator {

    private static String bDay;

    public static void main(String[] args) {

        Scanner rec = new Scanner(System.in);

        System.out.print("Welcome to the 100% Accurate Birthday Calendar!\n\n");

        System.out.println("When's your birthday?");
        bDay = rec.nextLine();

        System.out.println("That means you were born on a " + dayOfWeek(bDay) + "!");
        System.out.println("This year it falls on a " + dayOfWeek(thisYearDate(bDay)) + "...");
        System.out.println("And since today is " + getTodayDate() + ",");
        System.out.println("there's only " + dayOfYear(bDay) + " more days until you turn "
                + calcAge(bDay) + "!");


    }

    public static String dayOfWeek(String d) {

        String b_date = "";

        try {
            SimpleDateFormat format1 = new SimpleDateFormat("MM-dd-yyyy");

            Date dt1 = format1.parse(d);
            DateFormat format2 = new SimpleDateFormat("EEEE");
            b_date = format2.format(dt1);
            //return str + b_date + "!";

        } catch (ParseException e) {
            e.printStackTrace();
        }
        return b_date;
    }

    public static String thisYearDate(String d) {
        //String dayOFWeek = "";
        String thisYearDay = "";
        String finalDay = "";
        String newAge = "-2001";

        try {
            SimpleDateFormat format3 = new SimpleDateFormat("MM-dd-yyyy");
            Date dt2 = format3.parse(d);
            DateFormat format4 = new SimpleDateFormat("MM-dd");
            finalDay = format4.format(dt2);
            thisYearDay = finalDay + newAge;

        } catch (ParseException e) {
            e.printStackTrace();
        }
        return thisYearDay;
    }

    public static String getTodayDate() {
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat format1 = new SimpleDateFormat("MM-dd-yyyy");
        String formatted = format1.format(cal.getTime());
        return formatted;
    }

    public static int dayOfYear(String date) {
        int m[] = {0, 31, 59, 90, 120, 151, 181, 212, 243, 273, 304, 334};
        int month = Integer.parseInt(date.substring(0, 2));
        int day = Integer.parseInt(date.substring(3, 5));
        int year = Integer.parseInt(date.substring(6, 10));
        int n;

        n = m[month - 1] + day;

        if ((year % 4 == 0 && year % 100 != 0 || year % 400 == 0) && month > 2)
            n++;

        return n;
    }

    public static int calcAge(String date) {
        int m[] = {0, 31, 59, 90, 120, 151, 181, 212, 243, 273, 304, 334};
        int month = Integer.parseInt(date.substring(0, 2));
        int day = Integer.parseInt(date.substring(3, 5));
        int year = Integer.parseInt(date.substring(6, 10));
        int n = 0;
        int r = 2021;

        if ((month <= 03) && (year == r)) {
            r += 1;
        }
        return r - year;
    }

}
