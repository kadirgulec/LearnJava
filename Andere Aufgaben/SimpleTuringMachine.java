import java.util.Scanner;

public class SimpleTuringMachine {
    private char[] workingTape;
    private char value = 'a';
    private int headPosition;
    private char[] sourceCode;

    public SimpleTuringMachine(char[] sourceCode) {
        this.workingTape = new char[10];
        for (int i = 0; i < headPosition; i++) {
            workingTape[i] = 'a'; 
        }
        this.headPosition = 0; 
        this.sourceCode = sourceCode;
    }

    public void execute() {
        for (int i = 0; i < sourceCode.length; i++) {
            char instruction = sourceCode[i];
            switch (instruction) {
                case '>':
                    moveRight();
                    break;
                case '<':
                    moveLeft();
                    break;
                case '+':
                    incrementValue();
                    break;
                case '-':
                    decrementValue();
                    break;
                case '#':
                    setValue();
                    break;
                default:
                    break;
            }
        }
        System.out.println(workingTape);
    }

    private void moveRight() {
        headPosition = (headPosition + 1) % workingTape.length;
    }

    private void moveLeft() {
        headPosition = (headPosition - 1 + workingTape.length) % workingTape.length;
    }

    private void incrementValue() {
        value++;
    }

    private void decrementValue() {
        value--;
    }

    private void setValue() {
        workingTape[headPosition] = value;
        moveRight();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Geben Sie das SourceCode (Befehle: > < + - #):");
        String userInput = scanner.nextLine();
        char[] sourceCode = userInput.toCharArray();

        while(sourceCode.length != 0){
            SimpleTuringMachine tm = new SimpleTuringMachine(sourceCode);
            tm.execute();
            userInput = scanner.nextLine();
            sourceCode = userInput.toCharArray();
        }        
        scanner.close();
    }
}
