import java.util.Scanner;

public class DezimalBinaerHex {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Willkommen zum Dezimal-Umrechner!");
        String option = "1";
        
        while (!option.equals("0")){
            System.out.println("0. um zu Beenden");
            System.out.println("1. Dezimal zu Binär");
            System.out.println("2. Dezimal zu Hexadezimal");
            System.out.println("3. Binär zu Dezimal");
            System.out.println("4. Hexadezimal zu Dezimal");
            System.out.println("Bitte wählen Sie eine Option (0-4): ");
           
            int IntOption = 1 ;
            option = scanner.next();
            
            //check if the user input is a number (Integer)
            try{
                IntOption = Integer.parseInt(option);
                
            }catch(NumberFormatException e){
                System.out.println(errorWrongInput("Option", "1, 2, 3, 4. (0 um zu Beenden)"));
                continue;
            }

            int decimal = 1;
            String hexadecimal = "A";
            String binary = "A";
            if(IntOption == 1){
                
                while (decimal != 0){
                    decimal = askUserForDecimal(scanner);
                    binary = decimalToBinary(decimal);
                    System.out.println("Die Binärzahl für " + decimal + " lautet: " + binary);
                }
                continue;
              }
            else if(IntOption == 2){
                while (decimal != 0){
                    decimal = askUserForDecimal(scanner);
                    String hexaDecimal = decimalToHexadecimal(decimal);
                    System.out.println("Die Hexadezimalzahl für " + decimal + " lautet: " + hexaDecimal);
                }
                continue;
            }
            else if (IntOption == 3){
                while (!binary.equals("0")){
                    System.out.print("Geben Sie eine Binär ein: ");
                    System.out.print("(0 um zu Beenden) ");
                    binary =  scanner.next();
                    String decimalString = binaryToDecimal(binary);
                    System.out.println("Die Dezimalzahl für " + binary + " lautet: " + decimalString);
                }
            }
            else if(IntOption == 4){
                while (!hexadecimal.equals("0")){
                    System.out.print("Geben Sie eine Hexadezimalzahl ein: ");
                    System.out.print("(0 um zu Beenden) ");
                    hexadecimal =  scanner.next();
                    hexadecimal = hexadecimal.toUpperCase();
                    String decimalString = hexadecimalToDecimal(hexadecimal);
                    System.out.println("Die Dezimalzahl für " + hexadecimal + " lautet: " + decimalString);
                }
            }
            else if(IntOption == 0){
                
            }
            else{
                System.out.println(errorWrongInput("Option", "1, 2, 3, 4. (0 um zu Beenden)"));
            } 
        }

        scanner.close();
        
    }
    public static String errorWrongInput(String type, String option){
        return "Ungültige " + type + "! Bitte benutzen Sie " + option;
    }
    public static Integer askUserForDecimal(Scanner scanner){
        System.out.print("Geben Sie eine Dezimalzahl ein: ");
        System.out.print("(0 um zu Beenden) ");
        return scanner.nextInt();
        
    } 
    public static String binaryToDecimal(String binary){
        int value = 0;
        for(int i = 0; i < binary.length(); i++){
            char character = binary.charAt(binary.length() - (i + 1));
            if(Integer.parseInt(String.valueOf(character)) <= 1 ){
                value += Integer.parseInt(String.valueOf(character)) * Math.pow(2, i);
            }else{
                return "Falsh Eingabe";
            }
            
        }

        return Integer.toString(value);

    }
    public static String hexadecimalToDecimal(String hexaDecimal){
        int value = 0 ;
        for (int i= 0; i < hexaDecimal.length(); i++){
            char character = hexaDecimal.charAt(hexaDecimal.length() - (i + 1));
            if(character == 'A'){
                value += 10 * Math.pow(16,i);
            }
            else if(character == 'B'){
                value += 11 * Math.pow(16,i);
            }
            else if(character == 'C'){
                value += 12 * Math.pow(16,i);
            }
            else if(character == 'D'){
                value += 13 * Math.pow(16,i);
            }
            else if(character == 'E'){
                value += 14 * Math.pow(16,i);
            }
            else if(character == 'F'){
                value += 15 * Math.pow(16,i);
            }else if (Character.isDigit(character)){
                value += Integer.parseInt(String.valueOf(character)) * Math.pow(16, i);
            }else{
                return errorWrongInput("Hexadezimalzahl", "A-F und Numerisch");
            }
        }
        return Integer.toString(value);

    }
    public static String decimalToBinary(int decimal){
        StringBuilder binaryBuilder = new StringBuilder();
        if(decimal == 0){
            return "0";
        }else{
            while (decimal > 0){
            int rest = decimal % 2;
            binaryBuilder.insert(0, rest);
            decimal = decimal / 2;
            }
        }
        return binaryBuilder.toString();
    }

    public static String decimalToHexadecimal(int decimal){
        StringBuilder hexBuilder = new StringBuilder();
        if (decimal == 0){
            return "0";
        }else{
            while(decimal > 0 ){
                int rest = decimal % 16;
                char hexChar;
                if(rest > 9){
                    switch(rest){
                        case 10:
                            hexChar = 'A';
                            break;
                        case 11:
                            hexChar = 'B';
                            break;
                        case 12:
                            hexChar = 'C';
                            break;
                        case 13:
                            hexChar = 'D';
                            break;
                        case 14:
                            hexChar = 'E';
                            break;
                        default:
                            hexChar = 'F';
                            break;
                    }
                    decimal /= 16;
                    hexBuilder.insert(0, hexChar);
                    continue;
                }

                hexBuilder.insert(0, rest);
                decimal /=16;
            }

            return hexBuilder.toString();
        }
    }
}
