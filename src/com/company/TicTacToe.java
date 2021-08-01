package com.company;


import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class TicTacToe {

    public static void main(String[] args) {
	// write your code here
        

        char[][] gameBoard = {{' ','|',' ', '|', ' '},
                {'-','+','-', '+', '-'},
                {' ','|',' ', '|', ' '},
                {'-','+','-', '+', '-'},
                {' ','|',' ', '|', ' '}};

        printGameBoard(gameBoard);



        while(true){
            Scanner scan = new Scanner(System.in);
            System.out.println("Enter your placement (1-9):");
            int playerPos = scan.nextInt();
            placePiece(gameBoard, playerPos, "player");
            printGameBoard(gameBoard);
            Random rand = new Random();
            int cpuPos = rand.nextInt(9) + 1;
            placePiece(gameBoard, cpuPos, "cpu");
            printGameBoard(gameBoard);

        }


    }

    public static void printGameBoard(char[][] gameBoard) {
        for(char[] row: gameBoard){
            for(char c: row){
                System.out.print(c);
            }
            System.out.println();
        }
    }

    public static void placePiece(char[][] gameBoard, int pos, String user){
        char symbol = ' ';
        if(user.equals("player")){
            symbol = 'X';
        } else if(user.equals("cpu")){
            symbol = 'O';
        }

        switch (pos){
            case 1:
                gameBoard[0][0] = symbol;
                break;
            case 2:
                gameBoard[0][2] = symbol;
                break;
            case 3:
                gameBoard[0][4] = symbol;
                break;
            case 4:
                gameBoard[2][0] = symbol;
                break;
            case 5:
                gameBoard[2][2] = symbol;
                break;
            case 6:
                gameBoard[2][4] = symbol;
                break;
            case 7:
                gameBoard[4][0] = symbol;
                break;
            case 8:
                gameBoard[4][2] = symbol;
                break;
            case 9:
                gameBoard[4][4] = symbol;
                break;
        }

    }

    public static String checkWinner(){

        List tRow = Arrays.asList(1,2,3);
        List mRow = Arrays.asList(4,5,6);
        List bRow = Arrays.asList(7,8,9);
        List lCol = Arrays.asList(1,4,7);
        List cCol = Arrays.asList(2,5,8);
        List rCol = Arrays.asList(3,6,9);
        List fDiagonal = Arrays.asList(1,5,9);
        List bDiagonal = Arrays.asList(3,5,7);

        return "";
    }


}




