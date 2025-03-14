import java.util.Scanner;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        GuessTheNumber game1 = new GuessTheNumber();
        game1.chooseTheDifficulty();
        game1.gameplay();
    }
}