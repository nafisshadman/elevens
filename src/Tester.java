import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class Tester {
    public static void main(String[] args) {
        ElevensBoard board = new ElevensBoard();
        Scanner scan = new Scanner(System.in);
        boolean gameOn = true;
        while (board.anotherPlayIsPossible()) {
            System.out.println(board);
            List<Integer> selectedCards = new ArrayList<Integer>();
            System.out.println("Enter your first card to remove: ");
            int x = scan.nextInt();
            selectedCards.add(x);
            System.out.println("Enter your second card to remove: ");
            int y = scan.nextInt();
            selectedCards.add(y);
            System.out.println("Enter your third card to remove, (-1 if doing pair 11): ");
            int z = scan.nextInt();
            if (z != -1) {
                selectedCards.add(z);
            }
            System.out.println("" + x + y + z);
            if (board.isLegal(selectedCards)) {
                board.replaceSelectedCards(selectedCards);
                System.out.println("Removed selected cards");
            } else {
                System.out.println("Play is not legal. Try again.");
            }
        }
        System.out.println(board);
        if (board.gameIsWon()) {
            System.out.println("Congrats! You win!");
        } else {
            System.out.println("You lost...");
        }

    }
}
