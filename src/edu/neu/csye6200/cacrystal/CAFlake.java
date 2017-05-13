/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.neu.csye6200.cacrystal;

import java.util.Arrays;

/**
 *
 * @author Xiao
 */
public class CAFlake {

    public CAFlakeCell Flake[][] = null;

    public CAFlake() {
        Flake = new CAFlakeCell[67][67];
    }

    public CAFlakeCell[][] getFlake() {
        return Flake;
    }
}
