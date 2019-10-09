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
public class normalisasi extends bacaCSV{

    @Override
    public String[][] dataValue() {
        return super.dataValue();

    }
    
    public double h_pembukaan_max(double dmat[][]){
        double pembukaan_max = dmat[0][0];
        for (int i = 0 ; i < matrix.length; i++ )
        {
            if ((dmat[i][0])>pembukaan_max)
            {
                pembukaan_max = dmat[i][0];
            }
        }
        //System.out.println(pembukaan_max);
        return pembukaan_max;
    }
    
    public double h_pembukaan_min(double dmat[][]){
        double pembukaan_min = dmat[0][0];
        for (int i = 0 ; i < matrix.length; i++ )
        {
            if ((dmat[i][0])<pembukaan_min)
            {
                pembukaan_min = dmat[i][0];
            }
        }
        //System.out.println(pembukaan_min);
        return pembukaan_min;
    }
    
    public double h_tertinggi_max(double dmat[][]){
        double tertinggi_max = dmat[0][0];
        for (int i = 0 ; i < matrix.length; i++ )
        {
            if ((dmat[i][1])>tertinggi_max)
            {
                tertinggi_max = dmat[i][1];
            }
        }
        //System.out.println(tertinggi_max);
        return tertinggi_max;
    }
    
    public double h_tertinggi_min(double dmat[][]){
        double tertinggi_min = dmat[0][0];
        for (int i = 0 ; i < matrix.length; i++ )
        {
            if ((dmat[i][1])<tertinggi_min)
            {
                tertinggi_min = dmat[i][1];
            }
        }
        //System.out.println(tertinggi_min);
        return tertinggi_min;
    }
    
    public double h_terendah_max(double dmat[][]){
        double terendah_max = dmat[0][0];
        for (int i = 0 ; i < matrix.length; i++ )
        {
            if ((dmat[i][2])>terendah_max)
            {
                terendah_max = dmat[i][2];
            }
        }
        //System.out.println(terendah_max);
        return terendah_max;
    }
    
    public double h_terendah_min(double dmat[][]){
        double terendah_min = dmat[0][0];
        for (int i = 0 ; i < matrix.length; i++ )
        {
            if ((dmat[i][2])<terendah_min)
            {
                terendah_min = dmat[i][2];
            }
        }
        //System.out.println(terendah_min);
        return terendah_min;
    }
    
    public double h_penutupan_max(double dmat[][]){
        double penutupan_max = dmat[0][0];
        for (int i = 0 ; i < matrix.length; i++ )
        {
            if ((dmat[i][3])>penutupan_max)
            {
                penutupan_max = dmat[i][3];
            }
        }
        //System.out.println(penutupan_max);
        return penutupan_max;
    }
    
    public double h_penutupan_min(double dmat[][]){
        double penutupan_min = dmat[0][0];
        for (int i = 0 ; i < matrix.length; i++ )
        {
            if ((dmat[i][3])<penutupan_min)
            {
                penutupan_min = dmat[i][3];
            }
        }
        //System.out.println(penutupan_min);
        return penutupan_min;
    }
    
    public double [] db_h_pembukaan(double dmat[][]){
        double databaru [] = new double [matrix.length];
        double minlama = h_pembukaan_min(dmat);
        double maxlama = h_pembukaan_max(dmat);
        double maxbaru = 1;
        double minbaru = 0;
        for (int i=0;i<matrix.length;i++)
        {
            databaru[i] = (((dmat[i][0] - minlama)/(maxlama - minlama))*(maxbaru-minbaru))+minbaru;
            //System.out.println("["+i+"][0] = "+databaru[i]);
        }
        
        return databaru;
    }
    
    public double [] db_h_terendah(double dmat[][]){
        double databaru [] = new double [matrix.length];
        double minlama = h_terendah_min(dmat);
        double maxlama = h_terendah_max(dmat);
        double maxbaru = 1;
        double minbaru = 0;
        for (int i=0;i<matrix.length;i++)
        {
            databaru[i] = (((dmat[i][2] - minlama)/(maxlama - minlama))*(maxbaru-minbaru))+minbaru;
            //System.out.println("["+i+"][2] = "+databaru[i]);
        }
        
        return databaru;
    }
    
    public double [] db_h_tertinggi(double dmat[][]){
        double databaru []  = new double [matrix.length];
        double minlama = h_tertinggi_min(dmat);
        double maxlama = h_tertinggi_max(dmat);
        double maxbaru = 1;
        double minbaru = 0;
        for (int i=0;i<matrix.length;i++)
        {
            databaru[i] = (((dmat[i][1] - minlama)/(maxlama - minlama))*(maxbaru-minbaru))+minbaru;
            //System.out.println("["+i+"][1] = "+databaru[i]);
        }
        
        return databaru;
    }
    
    public double [] db_h_penutupan(double dmat[][]){
        double databaru [] = new double[matrix.length];
        double minlama = h_penutupan_min(dmat);
        double maxlama = h_penutupan_max(dmat);
        double maxbaru = 1;
        double minbaru = 0;
        for (int i=0;i<matrix.length;i++)
        {
            databaru[i] = (((dmat[i][3] - minlama)/(maxlama - minlama))*(maxbaru-minbaru))+minbaru;
            //System.out.println("["+i+"][3] = "+databaru[i]);
        }        
        return databaru;
    }
    
    public double [][] db_normalisasi(double a[], double b[], double c[], double d[]){
        double db_norm[][] = new double [matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++)
        {
            db_norm[i][0] = a[i];
            db_norm[i][1] = b[i];
            db_norm[i][2] = c[i];
            db_norm[i][3] = d[i];
            
            for (int j = 0; j < matrix[0].length; j++)
            {
                //System.out.println("["+i+"]["+j+"] = "+db_norm[i][j]);
            }
        }
        return db_norm; 
    }
    
}
