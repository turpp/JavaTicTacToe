package com.company;

import java.util.*;

public class TicTacToe {
    static ArrayList<Integer> playerPositions = new ArrayList<Integer>();
    static ArrayList<Integer> cpuPositions = new ArrayList<Integer>();

    public static void main(String[] args) {

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
            while(playerPositions.contains(playerPos) || cpuPositions.contains(playerPos)){
                System.out.println("Position taken. Try again!");
                playerPos =  scan.nextInt();
            }

            placePiece(gameBoard, playerPos, "player");
            String result = checkWinner();

            if(result.length()>0){
                System.out.println(result);
                break;
            }

            Random rand = new Random();
            int cpuPos = rand.nextInt(9) + 1;

            while(playerPositions.contains(cpuPos) || cpuPositions.contains(cpuPos)){
                System.out.println("");
                cpuPos = rand.nextInt(9)+1;
            }

            placePiece(gameBoard, cpuPos, "cpu");
            printGameBoard(gameBoard);
            result = checkWinner();

            if(result.length()>0){
                System.out.println(result);
                break;
            }

            System.out.println(result);
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
            playerPositions.add(pos);
        } else if(user.equals("cpu")){
            symbol = 'O';
            cpuPositions.add(pos);
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

    public static String checkWinner() {
        List tRow = Arrays.asList(1, 2, 3);
        List mRow = Arrays.asList(4, 5, 6);
        List bRow = Arrays.asList(7, 8, 9);
        List lCol = Arrays.asList(1, 4, 7);
        List cCol = Arrays.asList(2, 5, 8);
        List rCol = Arrays.asList(3, 6, 9);
        List fDiagonal = Arrays.asList(1, 5, 9);
        List bDiagonal = Arrays.asList(3, 5, 7);

        List<List> winningConditions = new ArrayList<List>();
        winningConditions.add(tRow);
        winningConditions.add(mRow);
        winningConditions.add(bRow);
        winningConditions.add(cCol);
        winningConditions.add(lCol);
        winningConditions.add(rCol);
        winningConditions.add(fDiagonal);
        winningConditions.add(bDiagonal);

        for (List l : winningConditions) {
            if (playerPositions.containsAll(l)) {
                return "Yay you won!";
            } else if (cpuPositions.containsAll(l)) {
                return "Sorry better luck next time!";
            } else if (playerPositions.size() + cpuPositions.size() == 9) {
                return "Cat won!";
            }

        }
        return "";
    }


}





