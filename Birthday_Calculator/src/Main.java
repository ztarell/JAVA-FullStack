import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.*;
import java.util.Calendar;
import java.util.Date;
import java.lang.String;
import java.io.*;
import java.time.*;

public class Main {


    public static void main(String[] args) {
        String bDay;
        String dayOFWeek;
        int howManyMore = 0;
        String newAge = "-2001";
        int age = 1;

        Scanner rec = new Scanner(System.in);

        System.out.print("Welcome to the 100% Accurate Birthday Calendar!\n\n");

        System.out.println("When's your birthday?");
        bDay = rec.nextLine();

        // Save bday
        dayOFWeek = bDay;

        String pattern = "MM-dd-yyyy";
        SimpleDateFormat formatter = new SimpleDateFormat(pattern);

        SimpleDateFormat format1 = new SimpleDateFormat("MM-dd-yyyy");
        try {
            Date dt1 = format1.parse(bDay);

            DateFormat format2 = new SimpleDateFormat("EEEE");
            String firstDay = format2.format(dt1);

            System.out.println("That means you were born on a " + firstDay + "!");

        } catch (ParseException e) {
            e.printStackTrace();
        }
            //int tYD = 0;
            SimpleDateFormat format3 = new SimpleDateFormat("MM-dd-yyyy");
            String thisYearDay = "";
            String finalDay = "";
            try {
                Date dt2 = format3.parse(dayOFWeek);

                DateFormat format4 = new SimpleDateFormat("MM-dd");
                finalDay = format4.format(dt2);
                thisYearDay = finalDay + newAge;
                //tYD = Integer.parseInt(thisYearDay);
                System.out.println("This year it falls on a " + thisYearDay);

            } catch (ParseException e) {
                e.printStackTrace();

            }



        /*//int val = DayOfWeekObject.getValue();

        // Day of week with a date
        Calendar cal = Calendar.getInstance();
        //cal.setTime(thisYearTime);
        int tYD = cal.get(Calendar.DAY_OF_WEEK);
        System.out.print("This year it falls on a ");
        switch (tYD) {
            case 1:
                System.out.print("Sunday...\n");
                break;
            case 2:
                System.out.print("Monday...\n");
                break;
            case 3:
                System.out.print("Tuesday...\n");
                break;
            case 4:
                System.out.print("Wednesday...\n");
                break;
            case 5:
                System.out.print("Thursday...\n");
                break;
            case 6:
                System.out.print("Friday...\n");
                break;
            case 7:
                System.out.print("Saturday...\n");
        }*/

        System.out.println("And since today is " + getTodayDate() + ",");
        System.out.println("there's only " + howManyMore + " more days until you turn " + age + "!");


        //Bday_Calc calc = new Bday_Calc(bDay, dayOFWeek, today, howManyMore, newAge);

        //System.out.print(calc.toString());
    }

    public static String getTodayDate() {
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat format1 = new SimpleDateFormat("MM-dd-yyyy");
        String formatted = format1.format(cal.getTime());
        return formatted;
    }
    public static String getTodaysDay(String thisYearDay) {
        SimpleDateFormat format5 = new SimpleDateFormat("MM-dd-yyyy");
        try {
            Date dt3 = format5.parse(thisYearDay);

            DateFormat format6 = new SimpleDateFormat("EEEEE");
            String day = format6.format(dt3);



        } catch (ParseException e) {
            e.printStackTrace();
        }
        return thisYearDay;
    }
    /*public int getValue(String finalDay) {
        // Set a local date whose day is found
        LocalDate localDate = LocalDate.of(finalDay.compareTo(int i));

        // Find the day from the local date
        DayOfWeek dayOfWeek = DayOfWeek.from(localDate);

        // Printing the day of the week
        // and its Int value
        System.out.println("Day of the Week on" + " 15th August 1947 - " + dayOfWeek.name());

        int val = dayOfWeek.getValue();

        System.out.println("Int Value of " + dayOfWeek.name() + " - " + val);
    }*/

}
