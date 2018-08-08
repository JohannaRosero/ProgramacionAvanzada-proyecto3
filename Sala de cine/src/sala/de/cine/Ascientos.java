/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sala.de.cine;

/**
 *
 * @author Usuario
 */
public class Ascientos {

   //dejame solucuona una cosa nomas y probamos jeje yaya ejjej
    public int peli1[][] = new int[5][5];

    public int peli2[][] = new int[5][5];
    public int peli3[][] = new int[5][5];
    public int peli4[][] = new int[5][5];

    public Ascientos() {
        //encerar la matriz
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                peli1[i][j] = 0;
                peli2[i][j] = 0;
                peli3[i][j] = 0;
                peli4[i][j] = 0;
            }
        }
    }

    public int[][] getPeli1() {
        return peli1;
    }

    public void setPeli1(int[][] peli1) {
        this.peli1 = peli1;
    }

    public int[][] getPeli2() {
        return peli2;
    }

    public void setPeli2(int[][] peli2) {
        this.peli2 = peli2;
    }

    public int[][] getPeli3() {
        return peli3;
    }

    public void setPeli3(int[][] peli3) {
        this.peli3 = peli3;
    }

    public int[][] getPeli4() {
        return peli4;
    }

    public void setPeli4(int[][] peli4) {
        this.peli4 = peli4;
    }

}
