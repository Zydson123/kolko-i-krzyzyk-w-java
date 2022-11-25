import java.util.Scanner;

public class Main {
    public static void print(char board[][]){
        for (int i = 0; i < 3; i++)
        {
            for (int j = 0; j < 3; j++)
            {
                System.out.print(" " + board[i][j] + " ");
            }
            System.out.println();
        }
    }
    public static boolean check_draw(char board[][]){
        int XorOamount = 0;
        for (int i = 0; i < 3; i++)
        {
            for (int j = 0; j < 3; j++)
            {
                if(board[i][j]!='n'){
                    XorOamount++;
                }
            }
        }
        return XorOamount == 9;
    }
    public static char check(char board[][]){
        int x=0;
        int y = 0;
        char whoWon='n';
        if(board[x][y]=='x' && board[x+1][y]=='x' && board[x+2][y]=='x'){
            whoWon = 'x';
        }
        else if(board[x][y]=='x' && board[x][y+1]=='x' && board[x][y+2]=='x'){
            whoWon = 'x';
        }
        else if(board[x][y]=='x' && board[x+1][y+1]=='x' && board[x+2][y+2]=='x'){
            whoWon = 'x';
        }
        else if(board[x+2][y]=='x' && board[x+1][y+1]=='x' && board[x][y+2]=='x'){
            whoWon = 'x';
        }

        else if(board[x][y]=='o' && board[x+1][y]=='o' && board[x+2][y]=='o'){
            whoWon = 'o';
        }
        else if(board[x][y]=='o' && board[x][y+1]=='o' && board[x][y+2]=='o'){
            whoWon = 'o';
        }
        else if(board[x][y]=='o' && board[x+1][y+1]=='o' && board[x+2][y+2]=='o'){
            whoWon = 'o';
        }
        else if(board[x+2][y]=='o' && board[x+1][y+1]=='o' && board[x][y+2]=='o'){
            whoWon = 'o';
        }
      return whoWon;
    }
    public static void main(String[] args) {
        System.out.println("Hello world!");
        char[][] board = new char[3][3];
        char whoseTurn = 'x';
        for (int i = 0; i < 3; i++)
        {
            for (int j = 0; j < 3; j++)
            {
                board[i][j] = 'n';
            }
        }
        while(true){
            print(board);
            if(check_draw(board)){
                System.out.println("Its a draw!");
                break;
            }
            else if(check(board)=='x'){
                System.out.println("X won!");
                break;
            }
            else if(check(board)=='o'){
                System.out.println("O won!");
                break;
            }
            else if(whoseTurn=='x'){
                System.out.println("Xs Turn");
                System.out.println("Choose the X coordinates of your move");
                Scanner input = new Scanner(System.in);
                int coordsX = input.nextInt();
                System.out.println("Choose the Y coordinates of your move");
                input = new Scanner(System.in);
                int coordsY = input.nextInt();
                if(board[coordsY][coordsX]!='x' && board[coordsY][coordsX]!='o') {
                    board[coordsY][coordsX] = 'x';
                    whoseTurn ='o';
                }
                else{
                    System.out.println("This spot is taken, please try again");
                }
            }
            else{
                System.out.println("Circles turn");
                System.out.println("Choose the X coordinates of your move");
                Scanner input = new Scanner(System.in);
                int coordsX = input.nextInt();
                System.out.println("Choose the Y coordinates of your move");
                input = new Scanner(System.in);
                int coordsY = input.nextInt();
                if(board[coordsY][coordsX]!='x' && board[coordsY][coordsX]!='o') {
                    board[coordsY][coordsX] = 'o';
                    whoseTurn ='x';
                }
                else{
                    System.out.println("This spot is taken, please try again");
                }
            }
        }
    }
}