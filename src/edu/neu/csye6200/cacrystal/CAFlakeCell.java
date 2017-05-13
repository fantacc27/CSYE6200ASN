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
public class CAFlakeCell {

    //private boolean emptyOrfull;
    public String cellshape;
    public boolean eorf;

    public void CAFlakeJudge(int a) {
        if (a == 0) {
            cellshape = "\u25A1";

        } else if (a == 1) {
            cellshape = "\u25A0";

        }

    }

    public String toString() {
        return cellshape;
    }

    public String getShape() {
        return cellshape;
    }
    

    /*public static void main(String[] args) {
        CAFlakeCell c = new CAFlakeCell();
        c.CAFlakeJudge(1);
        System.out.println(cellshape);
    }*/
}
