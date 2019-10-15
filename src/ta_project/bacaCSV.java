/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ta_project;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
       
/**
 *
 * @author Ewaldo
 */
public class bacaCSV {
    
    public String matrix[][] = null;
    public String[][] dataValue () {
        String letakfile = "D:/Folder Belajar/SMT 8/test.csv";  
        String thisLine;
         try {
            BufferedReader br = new BufferedReader(new FileReader(letakfile));
            List<String[]> lines = new ArrayList<String[]>();
            try {
                while ((thisLine = br.readLine())!= null){
                    lines.add(thisLine.split(","));
                }
                matrix = new String[lines.size()][0];
                lines.toArray(matrix);
            } catch (IOException ex) {
                Logger.getLogger(bacaCSV.class.getName()).log(Level.SEVERE, null, ex);
            }             
         } catch (FileNotFoundException ex) {
             Logger.getLogger(bacaCSV.class.getName()).log(Level.SEVERE, null, ex);
         }       
        return matrix;
     }
    
    public double[][] strtodouble (String data[][]){
        double dmat[][] = new double [matrix.length][matrix[0].length];
        for (int i = 0 ; i < matrix.length; i++)
        {
            for (int j = 0 ; j < matrix[0].length ; j++)
            {
                dmat[i][j] = Double.parseDouble(matrix[i][j]);
                //System.out.println("dmat["+i+"]["+j+"] = "+dmat[i][j]);
            }
        }
        
        return dmat;
    }
    
    public double[][] gabung(){
        return strtodouble(dataValue());
    }
    
    public void print (double dmat[][]) {
        for (int i = 0; i < dmat.length; i++)
        {
            for (int j = 0; j <dmat[0].length; j++)
            {
                System.out.println("dmat["+i+"]["+j+"] = "+dmat[i][j]);
            }
        }        
    }
 } 

