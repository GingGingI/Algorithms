package main;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class Main {

    private char[][] board = new char[8][12];
    private boolean isOver = false;

    private Scanner sc;
    private HashMap Hm;

    public static void main(String[] args) {
        Main main = new Main();
        main.startgame();
    }

    private void startgame() {
        Init();
        while (!isOver) {
            Hm = GetInputData();

            char spec = (char) Hm.get("spec");
            int num = (int) Hm.get("num");

            char[][] block = Blocks(spec);

            for (int i = 0; i < 2; i++) {
                for (int j = 0; j < 4; j++) {
                    if (block[j][i] == '\u0000') {
                        System.out.print("  ");
                    }else {
                        System.out.print(block[j][i] + " ");
                    }
                }
                System.out.println();
            }
            board[num][0];
        }
    }

    private void Init() {
        sc = new Scanner(System.in);
        Hm = new HashMap();
    }

    private HashMap GetInputData() {
        String value = sc.nextLine();
        String spec = value.substring(0,1);
        String Num = value.substring(1, 2);

        HashMap hm = new HashMap<>();

        if (spec.matches("[^A-Z]") || Num.matches("[^0-9]")) {
            return hm;
        } else {
            hm.put("spec", spec);
            hm.put("num", Num);
            return hm;
        }
    }

    private char[][] Blocks(char Blocks) {
        char[][] block = new char[4][2];
        switch (Blocks) {
            case 'A':
                block = blockMaker(1, 4, 0, 0, Blocks);
                break;
            case 'B':
                block = blockMaker(1, 3, 2, 1, Blocks);
                break;
            case 'C':
                block = blockMaker(1, 2, 1, 2, Blocks);
                break;
            case 'D':
                block = blockMaker(1, 2, 2, 2, Blocks);
                break;
            case 'E':
                block = blockMaker(2, 2, 1, 2, Blocks);
                break;
            case 'F':
                block = blockMaker(1, 3, 3, 1, Blocks);
                break;
            case 'G':
                block = blockMaker(3, 1, 1, 3, Blocks);
                break;
        }
        return block;
    }

    private char[][] blockMaker(int fstStart, int fstEnd, int secStart, int secEnd, char AS) {
        char[][] block = new char[4][2];
        for (int i = fstStart; i < (fstStart + fstEnd); i++) {
            block[i - 1][0] = AS;
        }
        for (int j = secStart; j < (secStart + secEnd); j++) {
            block[j - 1][1] = AS;
        }
        return block;
    }
}
