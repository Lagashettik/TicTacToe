import java.util.Arrays;
import java.util.Scanner;

public class TicTacToe {
    static char[] Board = new char[10];
    static final char HumanPlay;
    static final char ComputerPlay;

    static Scanner scan = new Scanner(System.in);

    static {
        System.out.println("Enter your Choice X or O");
        HumanPlay = scan.next().charAt(0);
        if(HumanPlay == 'X')
            ComputerPlay = 'O';
        else
            ComputerPlay = 'X';
        System.out.println("Player : X\nComputer : O");
    }

    TicTacToe(){
        Arrays.fill(Board,' ');
    }

    void ShowBoard(){
        System.out.println(" | 1| 2| 3");
        for(int i=1; i<10; i++){
            if(i == 1)
                System.out.print("1");
            if(i == 4)
                System.out.print("\n2");
            if (i == 7)
                System.out.print("\n3");

            System.out.print("| "+Board[i]);

        }
    }
    public static void main(String[] args) {
    TicTacToe Game = new TicTacToe();
    Game.ShowBoard();
    }
}
