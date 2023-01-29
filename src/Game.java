
import java.util.Objects;
import java.util.Scanner;

public class Game {

    public static void main(String[] args) {
        Db myDatabase = new Db();

        Player player1;
        Player player2;
        Scanner scan = new Scanner(System.in);
        while (true) {
            System.out.print("Type name of 1st player: ");
            String player1Name = scan.nextLine();
            if (myDatabase.isUserExists(player1Name)) {
                System.out.print("Type password of 1st player: ");
                String player1Pass = scan.nextLine();
                if (myDatabase.isUserPasswordExists(player1Name, player1Pass)) {
                    player1 = new Player(player1Name);
                    break;
                }
            }
        }
        while (true) {
            System.out.print("Type name of 2nd player: ");
            String player2Name = scan.nextLine();
            if (myDatabase.isUserExists(player2Name) && !Objects.equals(player2Name, player1.getName())) {
                System.out.print("Type password of 2nd player: ");
                String player2Pass = scan.nextLine();
                if (myDatabase.isUserPasswordExists(player2Name, player2Pass)) {
                    player2 = new Player(player2Name);
                    break;
                }
            }
        }
        Field a = new Field(player1, player2);
        a.gameOptions();


        myDatabase.close();
    }
}



//        System.out.print("Enter name of 1st player: ");
//        Player player1 = new Player(scan.nextLine());
//        System.out.print("Enter name of 2nd player: ");
//        Player player2 = new Player(scan.nextLine());