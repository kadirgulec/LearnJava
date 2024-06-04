package JavaLearn.Algorithmen;

import java.util.Scanner;

public class runLengthEncoding {
    public static void main(String[] args){
        Scanner userInput = new Scanner(System.in);
        System.out.println("Was wird encoded: ");
        System.out.println("Encoded Text: " + encode(userInput.nextLine()));
        userInput.close();
    }
    
    public static String encode(String text){
        String encodedText = "";
        Integer i = 0;
        while (i<text.length()){
            Integer count = 1;
            char characther = text.charAt(i);
            Integer j = i;
            while(j<text.length()-1){
                if(text.charAt(j) == text.charAt(j+1)){
                    count +=1;
                    j += 1;
                }else{
                    break;
                }
            }
            encodedText += Integer.toString(count) + characther;
            i = j + 1;
        }
        return encodedText;
    }
}
