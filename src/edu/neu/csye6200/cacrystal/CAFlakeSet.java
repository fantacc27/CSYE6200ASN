/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.neu.csye6200.cacrystal;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Xiao
 */
public class CAFlakeSet {

    public ArrayList<CAFlakeCell[][]> CAList = null;

    public CAFlakeSet() {

    }

    public void CAFlakeSet_1() {
        CAList = new ArrayList();
        CARule car = new CARule();
        CAFlakeCell[][] a = car.getInitFlake();
        CAList.add(0, a);
        for (int z = 1; z < 100; z++) {
            CAFlakeCell[][] b = car.getNextFlake(z);
            CAList.add(z, b);
        }

    }

    public void CAFlakeSet_2() {
        CAList = new ArrayList();
        CARule car = new CARule();
        CAFlakeCell[][] a = car.getInitFlake();
        CAList.add(0, a);
        for (int z = 1; z < 100; z++) {
            CAFlakeCell[][] b = car.getNextFlake_2(z);
            CAList.add(z, b);
        }

    }

    public void CAFlakeSet_3() {
        CAList = new ArrayList();
        CARule car = new CARule();
        CAFlakeCell[][] a = car.getInitFlake();
        CAList.add(0, a);
        for (int z = 1; z < 100; z++) {
            CAFlakeCell[][] b = car.getNextFlake_3(z);
            CAList.add(z, b);
        }

    }

    public ArrayList getList() {
        return CAList;
    }

    /*public void run() {
        CARule car = new CARule();

        Scanner input = new Scanner(System.in);
        System.out.println("Please input the number of step.");
        int z = Integer.valueOf(input.nextLine());
        CAFlakeCell[][] cell = CAList.get(z);
        car.display(cell);

    }

    public static void main(String[] args) {
        CAFlakeSet cafs = new CAFlakeSet();
        cafs.run();

    }
     */
}
