//import java.util.Calendar;
//import java.text.DateFormat;
//import java.text.SimpleDateFormat;
//import java.util.Date;
//
//public class Bday_Calc {
//
//    // data members
//    public String bDay;
//    public String dayOFWeek;
//    public String today;
//    public int howManyMore;
//    public double newAge;
//
//    // no-argument constructor
//    public Bday_Calc() {
//        bDay = "";
//        dayOFWeek = "";
//        today = "";
//        howManyMore = 0;
//        newAge  = 0;
//    }
//
//    // parameter costructor
//    public Bday_Calc(String bDay, String dayOFWeek, String today, int howManyMore, int newAge) {
//        this.bDay = bDay;
//        this.dayOFWeek = dayOFWeek;
//        this.today = today;
//        this.howManyMore = howManyMore;
//        this.newAge = newAge;
//    }
//    // Date
//    DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
//    Date date = new Date();
////
////    // methods
////    public int getDayNumberOld(Date date) {
////        Calendar cal = Calendar.getInstance();
////        cal.setTime(date);
////        return cal.get(Calendar.DAY_OF_WEEK);
////    }
////    public String getToday() {
////        int x = 0;
////        System.out.println(getDayNumberOld(x));
////    }
////
////    public double salesTax() {
////        return subTotal() * .0825;
////    }
////
////    public double Total() {
////        return subTotal() + salesTax();
////    }
////
////    public double Balance() {
////        return amtPaid - Total();
////    }
//
//    // To String
//    public String toString() {
//
//        String s1 = "\nThat means you were born on a ";
//        String s2 = "\nThis year it falls on a ";
//        String s3 = "\nAnd since today is ";
//        String s4 = ",\nthere's only ";
//        String s5 = "more days until the next one when you turn ";
//        String s6 = "!";
//
//        return String.format("%1s" + bDay + "%2s" + dayOFWeek + "%3s" + dateFormat.format(date), s1, s2)
//                + String.format("%1s %2d", s4, howManyMore)
//                + String.format("%1s %2d %3s", s5, newAge, s6);
//
//    }
//
//}
