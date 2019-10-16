/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

/**
 *
 * @author Ewaldo
 */
public class Normalisasi{
    
    public double [] nilai_minimum(double dmat[][]){
        double n_min[] = new double [dmat[0].length];
        for (int j = 0; j < dmat[0].length; j++)
        {
            double min = dmat[j][0];
            for (int i = 0; i < dmat.length; i++)
            {
                if (dmat[i][j] < min)
                {
                    min = dmat[i][j];
                }
                n_min[j] = min;
            }
            System.out.println("Nilai MIN dmat["+j+"] = "+n_min[j]);
        }
        return n_min;
    }
    
    public double [] nilai_maximum(double dmat[][]){
        double n_max[] = new double [dmat[0].length];
        for (int j = 0; j < dmat[0].length; j++)
        {
            double max = dmat[j][0];
            for (int i = 0; i < dmat.length; i++)
            {
                if (dmat[i][j] > max)
                {
                    max = dmat[i][j];
                }
                n_max[j] = max;
            }
            System.out.println("Nilai MAX dmat["+j+"] = "+n_max[j]);
        }
        return n_max;
    }
    
    public double [][] data_baru(double dmat[][]){
        double n_databaru [][] = new double [dmat.length][dmat[0].length];
        double min_lama [] = nilai_minimum(dmat);
        double max_lama [] = nilai_maximum(dmat);
        System.out.println("Data yang Sudah dinormalisasi");
        for (int i = 0; i < dmat.length; i++)
        {
            for (int j = 0; j < dmat[0].length; j++)
            {
                n_databaru[i][j] = (((dmat[i][j] - min_lama[j])/(max_lama[j] - min_lama[j]))*(1-0)) + 0;
                System.out.println("["+i+"]["+j+"] = "+n_databaru[i][j]);
            }
        }
        return n_databaru;
    }   
}
