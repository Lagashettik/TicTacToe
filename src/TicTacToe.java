import java.util.Arrays;
import java.util.Scanner;

public class TicTacToe {
    static char[] Board = new char[10];
    static final char HumanPlay;
    static final char ComputerPlay;
    static int count;

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

    void StartGame(){
        for(int i = 1; i < 10; i++){
            if(count % 2 == 0)
                MakeMove(ComputerPlay);
            else
                MakeMove(HumanPlay);
        }
    }

    void MakeMove(char id){
        boolean itr = true;
        int cell;
        if(id == HumanPlay) {
            do {
                System.out.println("Enter Cell Number");
                cell = scan.nextInt();
                if (Board[cell] == ' ')
                    System.out.println("Cell is free");
                else {
                    itr = false;
                    System.out.println("Cell is not Empty\nEnter other cell number");
                }
            }while (!itr);
        }
        else{
            do {
                cell =(int) Math.floor(Math.random() * 10 ) % 9;

                if (Board[cell] == ' ')
                    System.out.println("Cell is free");
                else {
                    itr = false;
                }

            }while (!itr);
        }
    }

    void ShowBoard(){
        System.out.println(" | 1| 2| 3|");
        for(int i=1; i<10; i++){
            if(i == 1)
                System.out.print(i+"|");
            if(i == 4 || i == 7)
                System.out.print("\n"+i+"|");

            System.out.print(" "+Board[i]+"|");

        }
    }
    public static void main(String[] args) {
    TicTacToe Game = new TicTacToe();
    Game.StartGame();
    Game.ShowBoard();
    }
}
