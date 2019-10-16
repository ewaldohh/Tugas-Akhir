/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.Random;

/**
 *
 * @author Ewaldo
 */
public class SOM extends Praprocess{
    cetak ctk = new cetak();
    
    public double[][] inisialisasi_bobot(){
        Random randomNumbers = new Random();
        int jumlah_cluster = 30;
        double w[][] = new double [jumlah_cluster][matrix[0].length];
        for (int i = 0; i < jumlah_cluster; i++)
        {
            for (int j = 0; j < matrix[0].length; j++)
            {
                double randomValue = 0 + randomNumbers.nextDouble()*1.0;
                w[i][j] = randomValue;
                //System.out.println("w["+i+"]["+j+"] = "+w[i][j]);
            }
        }
        return w;
    }
    
    public double[][] nilai_dj(double bobot[][], double db_norm[][]){
        int jumlah_cluster = 30;
        int iterasi = 100;
        double sum = 0;
        double laju_pembelajaran = 0.5;
        double hasil;
        double data2[][] = new double[matrix.length][2];
        int min_bobot;
        double min;
        double hasil2[] = new double[jumlah_cluster];
        double d[][] = new double[matrix.length][jumlah_cluster];  
        for (int loop = 0; loop < iterasi; loop++)    
        {
            for (int i = 0; i < matrix.length; i++)
            {
                for (int j = 0; j < jumlah_cluster; j++)
                {
                    for (int k = 0; k < matrix[0].length; k++)
                    {
                        sum = sum + Math.pow(db_norm[i][k] - bobot[j][k],2);                         
                    }
                    hasil = Math.sqrt(sum);
                    hasil2[j] = hasil;
                    sum = 0;
                    hasil = 0;
                    //System.out.println("X = "+i+" dan d["+j+"] = "+hasil2[j]);                    
                }
                min_bobot = (int) getIndexOfMinimum(hasil2);
                min = getValueOfMinimum(hasil2);
                data2[i][0]= min_bobot;
                data2[i][1]= min;
                //System.out.println("data2["+i+"][0]"+min_bobot);
                //System.out.println("data2["+i+"][1]"+min);
                for(int l = 0;l < bobot[0].length; l++)
                {
                    bobot[min_bobot][l] = bobot[min_bobot][l]+(laju_pembelajaran *(db_norm[i][l]-bobot[min_bobot][l]));
                }       
            }
            laju_pembelajaran = laju_pembelajaran * 0.5;
        }
        ctk.cetak_double(data2);
        return data2;
    }
        public double getIndexOfMinimum(double[] array) {
        if (array == null || array.length == 0) {
            return -1;
        }
        int min = 0;
        for (int i = 1; i < array.length; i++) {
            if (array[i] < array[min]) {
                min = i;
            }
        }
        return min;
    }
    
    public double getValueOfMinimum(double[] array) {
        if (array == null || array.length == 0) {
            return -1;
        }
        int min = 0;
        for (int i = 1; i < array.length; i++) {
            if (array[i] < array[min]) {
                min = i;
            }
        }
        return array[min];
    }
    
    
    
}