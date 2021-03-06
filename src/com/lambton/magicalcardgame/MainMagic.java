package com.lambton.magicalcardgame;

import java.util.Scanner;

public class MainMagic {

    public static void main(String[] arg) {


        MagicalCardGameModel magicalCardGameModel = new MagicalCardGameModel();
        MagicalCardGameCalculator magicalCardGameCalculator = new MagicalCardGameCalculator();
        String[][] matrix = {{"9", "2", "6"}, {"j", "l", "q"}, {"7", "8", "5"}};
        magicalCardGameModel.setCardList(matrix);
        showMatrix(magicalCardGameModel.getCardList());
        Scanner scan= new Scanner(System.in);
        System.out.println("Enter the column Number which contains your card");
        magicalCardGameModel.setFirstShuffleColPos(scan.nextLine());
        magicalCardGameCalculator.getFirstShuffleResult(magicalCardGameModel);
        System.out.println("Enter the Column no. which shows your no.");
        magicalCardGameModel.setSecShuffleColPos(scan.nextLine());
        magicalCardGameCalculator.getSecShuffleResult(magicalCardGameModel);
        System.out.println("your no. is");
        magicalCardGameModel.setGuessedCard(scan.nextLine());


    }

    private static void counter(String[][] cardList) {
        String matrixx[][] = new String[3][3];
        for (int i = 0; i < cardList.length; i++) {
            for (int j = 0; j < cardList[i].length; j++) {
                matrixx[i][j] = cardList[j][i];
            }
        }
        showMatrix(matrixx);
        shuffleColumns(matrixx);
    }
    private static void shuffleColumns(String[][] matrixx) {

        //x for 1 y for 2
        int x=1;
        int y=2;
        String temp;
        String[][] shuffleMatrix= matrixx;
        for(int i = 0; i < 3; i++)
        {
            temp = shuffleMatrix[(x-1)][i];
            shuffleMatrix[x-1][i] = shuffleMatrix[y-1][i];
            shuffleMatrix[y-1][i] = temp;
        }
        showMatrix(shuffleMatrix);
    }

    private static void showMatrix(String[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
