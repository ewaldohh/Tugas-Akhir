/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ta_project;

/**
 *
 * @author Ewaldo
 */
public class cetak {
     public void cetak_double(double data[][]) {
        int i, j;
        int row = 0, col = 0;
        row = data.length;
        col = data[0].length;

        System.out.println("\nrow = " + row + " col = " + col + "\n");

        for (i = 0; i < row; i++) {
            for (j = 0; j < col; j++) {
                System.out.print(data[i][j] + "\t");
            }
            System.out.println("");
        }
    }
     
    public void cetak(double data[]){
        for (int i = 0; i < data.length; i++)
        {
            System.out.println("["+i+"] = "+data[i]);
        }
    }
     
    public void cetak_normalisasi(double db_norm[][]){
        for (int i = 0; i < db_norm.length; i++)
        {
            for (int j = 0; j < db_norm[0].length; j++)
            {
                System.out.println("["+i+"]["+j+"] = "+db_norm[i][j]);
            }
        }
    }
    
    public void cetak_bobot(double bobot[][]){
        for (int i = 0; i < bobot.length; i++)
        {
            for (int j = 0; j < bobot[0].length; j++)
            {
                System.out.println("["+i+"]["+j+"] = "+bobot[i][j]);
            }
        }
    }
}
