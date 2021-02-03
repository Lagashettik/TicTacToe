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

    void Toss(){
        int Toss =(int) Math.floor(Math.random() * 10) % 2;
        System.out.println("Tossing.....\n");
        if(Toss == 0)
            System.out.println("Computer win the Toss\nComputer makes First move");
        else
        {
            System.out.println("You won the Toss\nYou make First move");
            count++;
        }
    }

    void StartGame(){
        Toss();
        for(int i = 1; i < 10; i++){

            if(count % 2 == 0)
                MakeMove(ComputerPlay);
            else
                MakeMove(HumanPlay);
            ShowBoard();
            count++;

            if(i == 9)
                for(int j = 1; j < 10; j++)
                    if(Board[j] == ' ')
                        i--;

        }
    }

    void MakeMove(char id){
        boolean itr;
        int cell;
        if(id == HumanPlay) {
            System.out.println("\nEnter Cell Number");
            do {
                cell = scan.nextInt();
                itr = true;
                if (Board[cell] == ' '){
                    Board[cell] = HumanPlay;
                }
                else {
                    itr = false;
                    System.out.println("\nCell is not Empty\nEnter other cell number");
                }
            }while (!itr);
        }
        else{
            do {
                cell =(int) Math.floor(Math.random() * 10 ) % 9;
                itr = true;
                if (Board[cell] == ' ')
                    Board[cell] = ComputerPlay;
                else {
                    itr = false;
                }

            }while (!itr);
        }
    }

    void ShowBoard(){
        System.out.println("\n | 1| 2| 3|");
        for(int i=1; i<10; i++){
            if(i == 1)
                System.out.print(i+"|");
            if(i == 4 || i == 7)
                System.out.print("\n"+i+"|");

            System.out.print(" "+Board[i]+"|");
        }
        System.out.println("\n");
    }

    public static void main(String[] args) {
    TicTacToe Game = new TicTacToe();
    Game.StartGame();
    }
}