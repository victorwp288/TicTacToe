package com.company;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {

    static ArrayList<Integer> playerPost = new ArrayList <Integer>();
    static ArrayList<Integer> cpuPost = new ArrayList<Integer>();


    public static void main(String[] args) {

        System.out.println("Welcome to tic-tac-toe");
        Board board = new Board();
        board.drawBoard();


        while (true){
            System.out.println("Enter your placement 1-9 (you go first, as X)");
            Scanner sc = new Scanner(System.in);
            int playPos = sc.nextInt();

            while (playerPost.contains(playPos) || cpuPost.contains(playPos)){
                System.out.println("Position taken");
                playPos = sc.nextInt();
            }

            board.turn(playPos, "human");
            String result = board.checkWinner();
            if (result.length() > 0) {
                System.out.println(result);
                break;
            }

            Random rand = new Random();
            int cpuPos = rand.nextInt(9)+1;
            while (playerPost.contains(cpuPos) || cpuPost.contains(cpuPos)){
                cpuPos = rand.nextInt(9)+1;
            }

            board.turn(cpuPos, "cpu");
            result = board.checkWinner();
            board.drawBoard();
            if (result.length() > 0) {
                System.out.println(result);
                break;
            }
        }
    }
}
