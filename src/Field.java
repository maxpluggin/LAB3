
import java.util.*;

public class Field {
    Player player1;
    Player player2;

    boolean player1IsX = true;
    boolean end = false;

    Map<Integer, Symbol> field = new HashMap<>();



    Field(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
        createField();
    }

    void createField() {
        for (int i = 1; i < 10; i++) {
            field.put(i, Symbol.EMPTY);
        }
    }

    void showField() {
        System.out.println("        |           |       " +
                "                                |           |       ");
        System.out.println("    " + field.get(1).symbol + "   |     "
                + field.get(2).symbol + "     |   " + field.get(3).symbol + "   " +
                "                            1   |     2     |   3   ");
        System.out.println("        |           |       " +
                "                                |           |       ");
        System.out.println("----------------------------" +
                "                        ----------------------------");
        System.out.println("        |           |       " +
                "                                |           |       ");
        System.out.println("    " + field.get(4).symbol + "   |     "
                + field.get(5).symbol + "     |   " + field.get(6).symbol + "   " +
                "                            4   |     5     |   6   ");
        System.out.println("        |           |       " +
                "                                |           |       ");
        System.out.println("----------------------------" +
                "                        ----------------------------");
        System.out.println("        |           |       " +
                "                                |           |       ");
        System.out.println("    " + field.get(7).symbol + "   |     "
                + field.get(8).symbol + "     |   " + field.get(9).symbol + "   " +
                "                            7   |     8     |   9   ");
        System.out.println("        |           |       " +
                "                                |           |       ");
    }




    void startGame() {
        System.out.println("game started");
        showField();

        Scanner scan = new Scanner(System.in);

        while (!end) {
            System.out.println();
            System.out.println("int position");
            int currentNumber = scan.nextInt();
            if (field.get(currentNumber) == Symbol.EMPTY) {
                change(currentNumber);
            }  // параметр в метод хода
            else {
                wrongPos();
            }
            showField();
            checkWinner();
        }
        createField();
        end = false;
        player1IsX = true;
        gameOptions();
    }
    void wrongPos(){
        if(player1IsX){
            System.out.println("wrong position, "+player1.getName()+", please try again");
        }
        else {
            System.out.println("wrong position, "+player2.getName()+", please try again");
        }
    }
    void change(int a) {
        if (player1IsX) {
            field.put(a, Symbol.CROSS);
        } else {
            field.put(a, Symbol.ZERO);
        }
        player1IsX = !player1IsX;
    }

    void checkWinner() {
        if (field.get(1).value + field.get(2).value + field.get(3).value == 30 ||
                field.get(4).value + field.get(5).value + field.get(6).value == 30 ||
                field.get(7).value + field.get(8).value + field.get(9).value == 30 ||
                field.get(1).value + field.get(4).value + field.get(7).value == 30 ||
                field.get(2).value + field.get(5).value + field.get(8).value == 30 ||
                field.get(3).value + field.get(6).value + field.get(9).value == 30 ||
                field.get(1).value + field.get(5).value + field.get(9).value == 30 ||
                field.get(3).value + field.get(5).value + field.get(7).value == 30) {
            win(Symbol.CROSS);
        } else if (field.get(1).value + field.get(2).value + field.get(3).value == 3 ||
                field.get(4).value + field.get(5).value + field.get(6).value == 3 ||
                field.get(7).value + field.get(8).value + field.get(9).value == 3 ||
                field.get(1).value + field.get(4).value + field.get(7).value == 3 ||
                field.get(2).value + field.get(5).value + field.get(8).value == 3 ||
                field.get(3).value + field.get(6).value + field.get(9).value == 3 ||
                field.get(1).value + field.get(5).value + field.get(9).value == 3 ||
                field.get(3).value + field.get(5).value + field.get(7).value == 3) {
            win(Symbol.ZERO);
        } else if (field.get(1).value + field.get(2).value + field.get(3).value +
                field.get(4).value + field.get(5).value + field.get(6).value +
                field.get(7).value + field.get(8).value + field.get(9).value >0) {
            System.out.println("Nobody win");
            end = true;
        }
    }

    void win(Symbol symbol) {
        if (symbol==Symbol.CROSS) {
            player1.win();
            player2.lose();
        } else {
            player2.win();
            player1.lose();
        }
        end = true;
    }
    void gameOptions(){
        Scanner scan = new Scanner(System.in);
        System.out.println();
        System.out.println("Chose option:");
        System.out.println("1.Show player data");
        System.out.println("2.Set X");
        System.out.println("3.Start new game");
        System.out.println("(int number 1 or 2 or 3)");
        System.out.println();
        int a = scan.nextInt();
        if(a == 1){
            System.out.println(player1.getInformation());
            System.out.println(player2.getInformation());
            gameOptions();
        }else if(a == 2){
            System.out.println();
            System.out.println("int number of player x (1 or 2)");
            int playerX = scan.nextInt();
            player1IsX = playerX == 1;
            gameOptions();
        } else if (a == 3) {
            startGame();
        }else {
            System.out.println("wrong number, try again");
            gameOptions();
        }
    }
}


//    Зробити клас, який описує ігрове поле гри хрестики-ноліки та клас, котрий описує ігрока.
//
//        В класі ігрового поля реалізувати методи:
//
//        - вивід ігрового поля на екран;
//
//        - зміна стану ігрового поля;
//
//        - перевірка на перемогу одного із гравців.

//    void showFieldOptions() {
//        System.out.println("        |           |       ");
//        System.out.println("    1   |     2     |   3   ");
//        System.out.println("        |           |       ");
//        System.out.println("----------------------------");
//        System.out.println("        |           |       ");
//        System.out.println("    4   |     5     |   6   ");
//        System.out.println("        |           |       ");
//        System.out.println("----------------------------");
//        System.out.println("        |           |       ");
//        System.out.println("    7   |     8     |   9   ");
//        System.out.println("        |           |       ");
//    }