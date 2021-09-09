// import thu vien
import java.util.Scanner;
import java.util.Random;

public class LuckyNumber {
    // khai bao va khoi tao bien static
    private static Scanner sc = new Scanner(System.in);
    private static int totalGame = 1;
    private static int totalGuesses = 0;
    private static double rate = 0;
    private static int bestGame = Integer.MAX_VALUE;
    public static void main(String[] args) {
        // khai bao bien local
        int luckyNumber; // so lucky
        String nextN; 

        // kiem tra nguoi co muon choi tiep hay khong
        do {
            Random rand = new Random();
            luckyNumber = rand.nextInt(100) + 1;

            play(luckyNumber);

            System.out.print("Do you want to play again? ");
            nextN = sc.next();

            if (!(nextN.equalsIgnoreCase("y")||nextN.equalsIgnoreCase("yes"))) {
                System.out.println(" ");
                break;
            }
            totalGame += 1;
        } while (true);

        report();   
    }

    public static void play(int luckyNumber) {
        // khai bao bien local
        int count; // dem so lan du doan
        int number; // so du doan cua nguoi choi

        System.out.println("I'm thinking of a number between 0 and 100");
        count = 0;

        do {
            System.out.print("You guess ? ");
            number = sc.nextInt();

            // check du doan va so lucky
            if (number > luckyNumber) {
                System.out.println("It's higher");
                count++;
            } else if (number < luckyNumber) {
                System.out.println("It's lower");
                count++;
            } else {
                System.out.println("You got it right in " + count + " guesses!");
                System.out.println("* * * * * * * * * * * * * * * * ");
                totalGuesses += count;
                // kiem tra lan du doan it nhat
                if (count < bestGame) {
                    bestGame = count;
                }
                break;
            }
        } while (true);
    }
    
    public static void report() {
        rate = (double)totalGuesses/(double)totalGame;
        System.out.println("Overall results: ");
        System.out.println("Total games   = " + totalGame);
        System.out.println("Total guesses = " + totalGuesses);
        System.out.println("Guesses/game  = " + rate );
        System.out.println("Best game     = " + bestGame);
    }
}
    

