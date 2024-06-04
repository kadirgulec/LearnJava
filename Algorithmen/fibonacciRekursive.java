package JavaLearn.Algorithmen;

import java.util.Scanner;

public class fibonacciRekursive {
    public static void main (String args[]){
         try (Scanner userInput = new Scanner(System.in)) {
            System.out.println("Geben Sie ein Zahl: ");
             Integer fibonacciNumber = fibonacciRecursion(userInput.nextInt());
             System.out.println(fibonacciNumber);
             fibonacciNumber = fibonacciIteration(userInput.nextInt());
             System.out.println(fibonacciNumber);
        }
         
    }

    public static Integer fibonacciRecursion(Integer n){
        if (n == 0){
            return 0;
        }
        else if (n == 1){
            return 1;
        }else{
            return fibonacciRecursion(n-1) + fibonacciRecursion(n - 2);
        }
        
    }

    public static Integer fibonacciIteration(Integer n){
        Integer fibonacciNumber = 0;
        Integer fibonacci1 = 1;
        Integer fibonacci2 = 1;
        if (n == 0){
            fibonacciNumber = 0;
        }
        else if (n == 1){
            fibonacciNumber = 1;
        }else if (n==2){
            fibonacciNumber = 1;
        }else{
            while (n > 2){
                
                fibonacciNumber = fibonacci1 + fibonacci2 ;
                fibonacci1 = fibonacci2;
                fibonacci2 = fibonacciNumber;
                n = n-1;
            }
            
        }
        return fibonacciNumber;
    }
}
