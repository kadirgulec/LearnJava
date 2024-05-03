import java.util.Scanner;

public class DezimalBinaerHex {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Willkommen zum Dezimal-Umrechner!");
        int option = 0;

        while (option != 3){
            System.out.println("1. Dezimal zu Binär");
            System.out.println("2. Dezimal zu Hexadezimal");
            System.out.println("3. um zu Beenden");
            System.out.print("Bitte wählen Sie eine Option (1 oder 2): ");
            option = scanner.nextInt();
            int decimal = 1;
            if(option == 1){
                
                while (decimal != 0){
                    System.out.print("Geben Sie eine Dezimalzahl ein: ");
                    System.out.print("(0 um zu Beenden) ");
                    decimal = scanner.nextInt();
                    String binary = decimalToBinary(decimal);
                    System.out.println("Die Binärzahl für " + decimal + " lautet: " + binary);
                }
                continue;
              }
            else if(option == 2){
                while (decimal != 0){
                    System.out.print("Geben Sie eine Dezimalzahl ein: ");
                    System.out.print("(0 um zu Beenden) ");
                    decimal = scanner.nextInt();
                    String hexaDecimal = decimalToHexadecimal(decimal);
                    System.out.println("Die Hexadezimalzahl für " + decimal + " lautet: " + hexaDecimal);
                }
                continue;
            }
            else if(option == 3){
                break;
            }
            else{
                System.out.println("Ungültige Option! Bitte wählen Sie 1 oder 2.(3 um zu Beenden)");
            } 
        }
        
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
