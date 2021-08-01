package com.company;


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

        Scanner scan = new Scanner(System.in);
        System.out.println("Enter your placement (1-9):");
        int pos = scan.nextInt();

        System.out.println(pos);


    }

    public static void printGameBoard(char[][] gameBoard) {
        for(char[] row: gameBoard){
            for(char c: row){
                System.out.print(c);
            }
            System.out.println();
        }
    }
}
