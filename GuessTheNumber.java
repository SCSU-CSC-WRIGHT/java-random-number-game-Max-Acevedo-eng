import java.util.Scanner;
import java.util.Random;

public class GuessTheNumber {
    private String difficulty;
    private int turnCount;
    private int guessedNumber;
    private int winningNumber;
    private boolean win;

    public GuessTheNumber() {
        this.difficulty = "N/A";
        this.turnCount = 0;
        this.guessedNumber = 0;
        this.winningNumber = 0;
        this.win = false;
    }

    public void chooseTheDifficulty() {
        Scanner scanner = new Scanner(System.in);
        while(!(this.difficulty.equals("Easy") || this.difficulty.equals("Medium") || this.difficulty.equals("Hard"))) {
            System.out.println("Type what difficulty would you like. (Case sensitive)");
            System.out.println("Easy (1-50)");
            System.out.println("Medium (1-100)");
            System.out.println("Hard (1-200)");
            this.difficulty = scanner.nextLine();
            if (!(this.difficulty.equals("Easy") || this.difficulty.equals("Medium") || this.difficulty.equals("Hard"))) {
                System.out.println("Invalid difficulty, please try again.");
            }
        }
    }

    public void gameplay() {
        Random random = new Random();
        if (this.difficulty.equals("Easy")) {
            this.winningNumber = random.nextInt(50) + 1; // 1-50
        } else if (this.difficulty.equals("Medium")) {
            this.winningNumber = random.nextInt(100)+1; //1-100
        } else {
            this.winningNumber = random.nextInt(200)+1; //1-200
        }
        Scanner scanner = new Scanner(System.in);
        while(this.win == false && turnCount < 10) {
            System.out.println("What is your guess?");
            this.guessedNumber = scanner.nextInt();
            this.turnCount++;
            if (this.guessedNumber < this.winningNumber) {
                System.out.println("Too Low!");
            } else if (this.guessedNumber > this.winningNumber) {
                System.out.println("Too High!");
            } else if (this.guessedNumber == this.winningNumber) {
                System.out.println("Congratulations! You guessed the number in "+ this.turnCount+ " attempts!");
                this.win = true;
            }
            if (this.turnCount == 10) {
                System.out.println("Sorry, you have run out of attempts. The number was "+ this.winningNumber);
            }
        }
    }
}
