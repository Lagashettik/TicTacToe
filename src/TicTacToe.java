import java.util.Arrays;
import java.util.Scanner;

public class TicTacToe {
    static char[] Board = new char[10];
    static final char HumanPlay;
    static final char ComputerPlay;
    static int count;
    static int tie;

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
        System.out.println("\nTossing.....\n");
        if(Toss == 0)
            System.out.println("Computer won the Toss\nComputer makes First move");
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
            if(i == 9){
                for(int j = 1; j < 10; j++)
                    if(Board[j] == ' ')
                        i--;

                if(i == 9)
                        tie++;
                }

            if(Result() == ' ')
                break;

            count++;
        }
    }

    void MakeMove(char Player){
        if(Player == HumanPlay)
            HumanPlays();
        else
            ComputerPlays();
    }

    void ComputerPlays(){
        System.out.println("Computer Playing");
        boolean itr = false;
        int cell;
        do {
            cell = (int) (Math.floor(Math.random() * 10) % 9) + 1;
            if (Board[cell] == ' ') {
                Board[cell] = ComputerPlay;
                itr = true;
            }

        }while (!itr);
        System.out.println("Computer Played");
    }

    void HumanPlays(){
        boolean itr;
        System.out.println("\nEnter Cell Number");
        do {
            int Cell = scan.nextInt();
             itr = false;

            if(Cell > 0 && Cell < 10){
                if (Board[Cell] == ' '){
                    Board[Cell] = HumanPlay;
                    itr = true;
                }
                else
                    System.out.println("\nCell is not Empty\nEnter other Cell number");

            }
            else
                System.out.println("Enter Correct Index Number");

        }while (!itr);
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

    char Result(){
        if(ResultCheck() == HumanPlay) {
            System.out.println("Player Won");
            return ' ';
        }
        else if (ResultCheck() == ComputerPlay){
                System.out.println("Computer Won");
                return ' ';
        }
        else if(ResultCheck() == 'T') {
            System.out.println("Match is Tie");
            return ' ';
        }
        return 0;
    }

    char ResultCheck(){
        if (Board[1] == Board[2] && Board[2] == Board[3])
            return Board[1];
        else if(Board[1] == Board[4] && Board[4] == Board[7])
            return Board[1];
        else if (Board[1] == Board[5] && Board[5] == Board[9])
            return Board[1];
        else if(Board[2] == Board[5] && Board[5] == Board[8])
            return Board[2];
        else if(Board[3] == Board[6] && Board[6] == Board[9])
            return Board[3];
        else if (Board[3] == Board[5] && Board[5] == Board[7])
            return Board[3];
        else if (Board[4] == Board[5] && Board[5] ==  Board[6])
            return Board[4];
        else if (Board[7] == Board[8] && Board[8] == Board[9])
            return Board[7];
        else if(tie != 0)
            return 'T';
        else
            return ' ';
    }

    public static void main(String[] args) {
    TicTacToe Game = new TicTacToe();
    Game.StartGame();
    }
}