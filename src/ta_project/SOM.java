/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ta_project;

import java.util.Random;

/**
 *
 * @author Ewaldo
 */
public class SOM extends bacaCSV{
    @Override
    public String[][] dataValue() {
        return super.dataValue();
    }
    
    
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
        double d[][] = new double[matrix.length][jumlah_cluster];       
        for (int i = 0; i < matrix.length; i++)
        {
            for (int j = 0; j < jumlah_cluster; j++)
            {
                for (int k = 0; k < matrix[0].length; k++)
                {
                    d[i][j] = Math.sqrt(d[i][j] + Math.pow(db_norm[i][k] - bobot[j][k],2));                    
                }
                System.out.println("X = "+i+" dan d["+j+"] = "+d[i][j]);
            }  
        }
        return d;
    }
}
