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
public class backpropagation{
Random randomNumbers = new Random();
double konstanta_mtk = 2.71828182845904;
double laju_pembelajaran = 0.2;

    public double [][] bobot_lp(){
        int input = 4;
        int hl_neuron = 15;
        double bobot[][] = new double [input][hl_neuron];
        for (int i = 0; i < input; i++)
        {
            for (int j = 0; j < hl_neuron; j++)
            {
                double randomValue = -0.5 + randomNumbers.nextDouble()*0.5;
                bobot[i][j] = randomValue;
                System.out.println("v["+i+"]["+j+"] = "+bobot[i][j]);             
            }
        }
        return bobot;
    }
    
    public double [] bobot_lk(){
        int hl_neuron = 16;
        double bobot[] = new double [hl_neuron];
        for (int i = 0; i < hl_neuron; i++)
        {
            double randomValue = -0.5 + randomNumbers.nextDouble()*1.0;
            bobot[i]= randomValue;
            System.out.println("w["+i+"]= "+bobot[i]);
        }
        return bobot;
    }
    
    public double []v0(double arr[][]){
        double n_v0[] = new double [arr[0].length];
        double x;
        for (int i = 0; i < arr[0].length; i++)
        {
            x = arr[3][i];
            n_v0[i] = x; 
            System.out.println("v0["+i+"] = "+n_v0[i]);
        }
        return n_v0;
    }
    
    public double w0(double arr[]){
        double n_w0 = arr[15];
        System.out.println("w0 = "+n_w0);
        return n_w0;
    }
        
    public double [][] z_netj(double db_norm[][]){
        double bobot[][] = bobot_lp();
        int hl_neuron = 15;
        double sum = 0;
        double hasil;
        double hasil2[][] = new double [db_norm.length][bobot[0].length];
        double[] z_net = new double [hl_neuron];
        double v0[] = v0(bobot);
        for (int k = 0; k < db_norm.length; k++)
        {
           for (int i = 0; i < bobot[0].length; i++)
            {
                for (int j = 0; j < (bobot.length-1); j++)
                    {
                        sum = sum + (db_norm[k][j] * bobot[j][i]);
                    }
                hasil = v0[i] + sum;
                hasil2[k][i] = hasil;
                sum = 0;
                hasil = 0;
                System.out.println("Pola ke-"+k+" Z_net["+i+"] = "+hasil2[k][i]);                
            } 
        }
        zj(hasil2);
        return hasil2;
    }
    
    public double [][] zj(double z_netj[][]){
        double zj [][] = new double [z_netj.length][z_netj[0].length];
        double hasil; 
        for (int i = 0; i < z_netj.length; i++)
        {
            for (int j = 0; j < z_netj[0].length; j++)
            {
                hasil =  1/(1 + (Math.pow(konstanta_mtk, -z_netj[i][j])));
                zj[i][j] = hasil;
                hasil = 0;
                System.out.println("Pola ke-["+i+"] Zj["+j+"] = "+zj[i][j]);
            }           
        }
        return zj; 
    }
    
    public double []y_netk(double zj[][]){
        double bobot[] = bobot_lk();
        double w0 = w0(bobot);
        double y_net[] = new double[zj.length];
        double sum = 0;
        for (int k = 0; k < zj.length; k++)
        {
            for (int i = 0; i < zj[0].length; i++)
            {
                sum = sum + (zj[k][i] * bobot[i]);
                y_net[k]= w0 + sum;
                sum = 0;                   
            }             
            System.out.println("y_net["+k+"]= "+y_net[k]);
        }
        y(y_net);
        return y_net;
    }
    
    public double []y(double y_net[]){
        double n_y[] = new double [y_net.length];
        for (int i = 0; i < y_net.length; i++)
        {
            for (int j = 0; j < y_net.length; j++)
            {
                n_y[i] = 1/(1 + Math.pow(konstanta_mtk, -y_net[i])); 
            }
            System.out.println("y["+i+"] = "+n_y[i]);
        }
        return n_y;
    }
    
    public double []error_u_keluaran(double y[], double db_norm[][]){
        double faktor[] = new double [y.length];
        double target[] = new double [y.length];
        for (int i = 0; i < y.length; i++)
        {
            target[i] = db_norm[i][3];
            System.out.println("Target ["+i+"][3] = "+target[i]);
            faktor[i] = (target[i] - y[i]) * y[i] * (1 - y[i]); 
            System.out.println("Faktor unit kesalahan layer keluaran faktor["+i+"] = "+faktor[i]);
        }
        return faktor;
    }
    
    public double [] perubahan_wkj(double faktor[], double zj[][]){
        
        double delta_wkj[] = new double [faktor.length];
        for (int i = 0; i < faktor.length; i++)
        {
            for (int j = 0; j < zj[0].length; j++)
            {
               delta_wkj[i] = laju_pembelajaran * faktor[i] * zj[i][j]; 
                System.out.println("Delta Wkj["+i+"] = "+delta_wkj[i]);
            }           
        }
        return delta_wkj;
    }
    
    public double []error_u_tersembunyi(double wkj[], double faktor_keluaran[]){
        double faktor_terembunyi[] = new double [wkj.length];
        for (int i = 0; i < wkj.length; i++)
        {
            faktor_terembunyi[i] = faktor_keluaran[i] * wkj[i]; 
            System.out.println("Faktor Unit Tersembunyi ["+i+"]= "+faktor_terembunyi[i]);
        }
        return faktor_terembunyi;
    }
    
    public double []faktor_error(double faktor_tersembuyi[], double zj[][]){
        double faktor_error[] = new double [faktor_tersembuyi.length];
        for (int i = 0; i < zj.length; i++)
        {
            for (int j = 0; j < faktor_tersembuyi.length; j++)
            {
                faktor_error[i] = faktor_tersembuyi[i] * zj[i][j] * (1 - zj[i][j]);
                System.out.println("Faktor Error ["+i+"]= "+faktor_error[i]);
            }
        }
        return faktor_error;
    }
    
    public double [][]perubahan_vji(double faktor[], double db_norm[][]){
        double delta_vji[][] = new double[db_norm[0].length][faktor.length];
        for (int i = 0; i < db_norm.length; i++)
        {
            for (int j = 0; j < db_norm[0].length; j++)
            {
                delta_vji[i][j] = laju_pembelajaran * faktor[i] * db_norm[i][j];
            }
        }
        return delta_vji;
    }
    
    public double []wkj_baru(double wkj_lama[], double delta_wkj[]){
        double n_wkj[] = new double [wkj_lama.length];
        for (int i = 0; i < wkj_lama.length; i++)
        {
            n_wkj[i] = wkj_lama[i] + delta_wkj[i];
        }
        return n_wkj;
    }
    
    public double []vji_baru(double vji_lama[], double delta_vji[]){
        double n_vji[] = new double [vji_lama.length];
        for (int i = 0; i < vji_lama.length; i++)
        {
            n_vji[i] = vji_lama[i] + delta_vji[i];
        }
        return n_vji;
    }
}
