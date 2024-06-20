package JavaLearn.Algorithmen;

import java.util.Scanner;

public class decimalToBinary {
    public static void main (String args[]){
        try (Scanner userInput = new Scanner(System.in)) {
            System.out.println("Geben Sie ein Zahl: ");
             String binary = decimalToBinaryRecursion(userInput.nextInt());
             System.out.println(binary);
        }
    }

    public static String decimalToBinaryRecursion(Integer n){
        if(n == 0){
            return "0";
        }else if(n==1){
            return "1";
        }else{
            Integer rest = n % 2 ;
            return decimalToBinaryRecursion(n/2) + Integer.toString(rest);
        }
    }
}
    
    
