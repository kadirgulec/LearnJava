import java.util.Scanner;

public class SchaltjahrAufgabe {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Wie viele Tage hat der Februar in einem bestimmten Jahr?");

        while (true) {
            System.out.print("(x zum Beenden) ");
            System.out.print("Geben Sie ein Jahr: ");
            String inputYear = scanner.nextLine();
            int year;

            //stop the loop if x is typed
            if(inputYear.equals("x")){
                break;
            }

            //check if the input is an Integer
            try {
                year = Integer.parseInt(inputYear);             
            } catch (NumberFormatException e) {
                System.out.println(help());
                continue;
            }

            //give the result
            if (isLeapYear(year)){
                System.out.println("Es gibt 29 Tagen im Februar " + year);
            }else{
                System.out.println("Es gibt 28 Tagen im Februar " + year);
            }

        }
    }
    public static String help(){
       return "Ein Zahl muss eingegeben werden!";
    }

    public static boolean isLeapYear(int year){
        if (year % 4 == 0) {
            if (year % 100 == 0) {
                if (year % 400 == 0) {
                    return true;
                }
                return false;
            }
            return true;
        } else {
            return false;
        }
    }
}
