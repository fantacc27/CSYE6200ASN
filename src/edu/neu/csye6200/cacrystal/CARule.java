/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.neu.csye6200.cacrystal;

/**
 *
 * @author Xiao
 */
public class CARule {

    private CAFlakeCell[][] cafc = null;

    public static void display(CAFlakeCell[][] c) {
        for (int i = 1; i < c.length - 1; i++) {
            for (int j = 1; j < c.length - 1; j++) {

                System.out.print(c[i][j].cellshape);
            }
            System.out.println();
        }
    }

    private CAFlakeCell[][] emptyFlake() {
        CAFlake cafempty = new CAFlake();
        CAFlakeCell[][] Flake = cafempty.getFlake();
        for (int i = 0; i < 67; i++) {
            for (int j = 0; j < 67; j++) {

                Flake[i][j] = new CAFlakeCell();
                Flake[i][j].CAFlakeJudge(0);

            }
        }
        return Flake;
    }

    public CAFlakeCell[][] getEmptyFlake() {
        return emptyFlake();
    }

    private CAFlakeCell[][] initFlake() {

        CAFlake cafinit = new CAFlake();
        CAFlakeCell[][] Flake = cafinit.getFlake();
        for (int i = 0; i < 67; i++) {
            for (int j = 0; j < 67; j++) {

                Flake[i][j] = new CAFlakeCell();
                Flake[i][j].CAFlakeJudge(0);

            }
        }

        Flake[33][33].CAFlakeJudge(1);

        return Flake;
    }

    private CAFlakeCell[][] generateNextFlake(CAFlakeCell[][] Flake) {

        for (int i = 1; i < 66; i++) {
            for (int j = 1; j < 66; j++) {

                if (Flake[i][j].cellshape == "\u25A0") {
                    continue;
                } else {
                    int count = 0;
                    if (Flake[i + 1][j].cellshape == "\u25A0") {
                        count++;
                    }
                    if (Flake[i - 1][j].cellshape == "\u25A0") {
                        count++;
                    }
                    if (Flake[i][j + 1].cellshape == "\u25A0") {
                        count++;
                    }
                    if (Flake[i][j - 1].cellshape == "\u25A0") {
                        count++;
                    }
                    if (count == 1 || count == 3) {
                        Flake[i][j].eorf = true;

                    }
                }
            }
        }
        for (int i = 0; i < 67; i++) {
            for (int j = 0; j < 67; j++) {
                if (Flake[i][j].eorf == true) {
                    Flake[i][j].cellshape = "\u25A0";
                }
            }
        }

        return Flake;

    }

    public CAFlakeCell[][] getNextFlake(int a) {
        cafc = initFlake();
        for (int i = 0; i < a; i++) {
            cafc = generateNextFlake(cafc);
        }
        return cafc;
    }

    private CAFlakeCell[][] generateNextFlake_2(CAFlakeCell[][] Flake) {

        for (int i = 1; i < 66; i++) {
            for (int j = 1; j < 66; j++) {

                if (Flake[i][j].cellshape == "\u25A0") {
                    continue;
                } else {
                    int count = 0;
                    if (Flake[i + 1][j].cellshape == "\u25A0") {
                        count++;
                    }
                    if (Flake[i - 1][j].cellshape == "\u25A0") {
                        count++;
                    }
                    if (Flake[i][j + 1].cellshape == "\u25A0") {
                        count++;
                    }
                    if (Flake[i][j - 1].cellshape == "\u25A0") {
                        count++;
                    }
                    if (count == 1) {
                        Flake[i][j].eorf = true;

                    }
                }
            }
        }
        for (int i = 0; i < 67; i++) {
            for (int j = 0; j < 67; j++) {
                if (i % 2 == 0 && j % 2 == 0) {
                    Flake[i][j].eorf = false;
                }
            }
        }
        for (int i = 0; i < 67; i++) {
            for (int j = 0; j < 67; j++) {
                if (Flake[i][j].eorf == true) {
                    Flake[i][j].cellshape = "\u25A0";
                }
            }
        }

        return Flake;

    }

    public CAFlakeCell[][] getNextFlake_2(int a) {
        cafc = initFlake();
        for (int i = 0; i < a; i++) {
            cafc = generateNextFlake_2(cafc);
        }
        return cafc;
    }

    private CAFlakeCell[][] generateNextFlake_3(CAFlakeCell[][] Flake) {

        for (int i = 1; i < 66; i++) {
            for (int j = 1; j < 66; j++) {

                if (Flake[i][j].cellshape == "\u25A0") {
                    continue;
                } else {
                    int count = 0;
                    if (Flake[i + 1][j].cellshape == "\u25A0") {
                        count++;
                    }
                    if (Flake[i - 1][j].cellshape == "\u25A0") {
                        count++;
                    }
                    if (Flake[i][j + 1].cellshape == "\u25A0") {
                        count++;
                    }
                    if (Flake[i][j - 1].cellshape == "\u25A0") {
                        count++;
                    }
                    if (count == 1 || count == 3) {
                        Flake[i][j].eorf = true;

                    }
                }
            }
        }
        for (int i = 0; i < 67; i++) {
            for (int j = 0; j < 67; j++) {
                if (i % 3 == 0 && j % 3 == 0) {
                    Flake[i][j].eorf = false;
                }
            }
        }
        for (int i = 0; i < 67; i++) {
            for (int j = 0; j < 67; j++) {
                if (Flake[i][j].eorf == true) {
                    Flake[i][j].cellshape = "\u25A0";
                }
            }
        }

        return Flake;

    }

    public CAFlakeCell[][] getNextFlake_3(int a) {
        cafc = initFlake();
        for (int i = 0; i < a; i++) {
            cafc = generateNextFlake_3(cafc);
        }
        return cafc;
    }

    public CAFlakeCell[][] getInitFlake() {
        return initFlake();
    }

}
