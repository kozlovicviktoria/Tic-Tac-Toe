import java.util.InputMismatchException;
import  java.util.Scanner;

public class Main {
    public static int j = 0;
    public static boolean gameOver = false;
    public static void outputField(char arr[]) {

        if (arr.length == 9) {

            System.out.println("---------");

            for (int i = 0; i < 9; i++) {
                if (i == 0 || i == 3 || i == 6) {

                    System.out.print("|" + " ");

                }

                System.out.print(arr[i] + " ");

                if (i == 2 || i == 5 || i == 8) {

                    System.out.print("|" + " ");
                    System.out.println();
                }

            }
            System.out.println("---------");
        }
    }

    public static void addHod(char arr[]) {
        Scanner scanner = new Scanner(System.in);
        int x = 0;
        int y = 0;

        try {
            x = scanner.nextInt();
            y = scanner.nextInt();
        }
        catch (InputMismatchException ex) {
            System.out.println("You should enter numbers!");
            addHod(arr);
        }
        int convert = 3 * (x - 1) + y - 1;
        if(x>3 || y>3 || x<1 || y<1){
            System.out.println("Coordinates should be from 1 to 3!");
            addHod(arr);
        } else if (arr[convert]=='X' || arr[convert]=='O') {
            System.out.println("This cell is occupied! Choose another one!");
            addHod(arr);
        } else if (j % 2 != 0){
            arr[convert] = 'O';
            j++;
        } else {
            arr[convert] = 'X';
            j++;
        }
    }

    public static void result(char arr[]) {
        int x = 0;
        int o = 0;
        boolean owins = false;
        boolean xwins = false;
        boolean draw = false;
        boolean impos = false;


        for (int i = 0; i < 9; i++){
            if (arr[i] == 'X') {
                x++;
            }
            if (arr[i] == 'O') {
                o++;
            }
        }

        if (arr[0] == arr[4] && arr[4] == arr[8] || arr[2] == arr[4] && arr[4] == arr[6]) {
            if (arr[4] == 'O') {
                owins = true;
            } else if (arr[4] == 'X'){
                xwins =true;
            }
        }

        if(arr[0] == arr[1] && arr[1] == arr[2] && arr[0] == 'O' || arr[3] == arr[4] && arr[4] == arr[5] && arr[3] == 'O' || arr[6] == arr[7] && arr[7] == arr[8] && arr[6] == 'O'){
            owins = true;
        }

        if(arr[0] == arr[1] && arr[1] == arr[2] && arr[0] == 'X' || arr[3] == arr[4] && arr[4] == arr[5] && arr[3] == 'X' || arr[6] == arr[7] && arr[7] == arr[8] && arr[6] == 'X'){
            xwins = true;
        }

        if(arr[0] == arr[3] && arr[3] == arr[6] && arr[0] == 'O' || arr[1] == arr[4] && arr[4] == arr[7] && arr[1] == 'O' || arr[2] == arr[5] && arr[5] == arr[8] && arr[2] == 'O'){
            owins = true;
        }

        if(arr[0] == arr[3] && arr[3] == arr[6] && arr[0] == 'X' || arr[1] == arr[4] && arr[4] == arr[7] && arr[1] == 'X' || arr[2] == arr[5] && arr[5] == arr[8] && arr[2] == 'X'){
            xwins = true;
        }

        if (x + o == 9){
            draw = true;
        }
        if (Math.abs(x - o) > 1 || owins && xwins) {
            impos = true;
        }

        if (impos){
            System.out.println("Impossible");
            gameOver = true;
        }  else if (xwins) {
            System.out.println("X wins");
            gameOver = true;
        } else if(owins){
            System.out.println("O wins");
            gameOver = true;
        } else if (draw){
            System.out.println("Draw");
            gameOver = true;
        }
    }


    public static void main(String[] args) {
        char[] arr =  new char[]{' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '};

        outputField(arr);
        while (gameOver == false){
            addHod(arr);
            outputField(arr);
            result(arr);
        }
    }
}
