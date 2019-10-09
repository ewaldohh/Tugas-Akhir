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
public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        bacaCSV CSV = new bacaCSV();
        CSV.dataValue();
        normalisasi normalin = new normalisasi();
        normalin.dataValue();       
        //CSV.strtodouble();
        //normalin.db_h_pembukaan(CSV.strtodouble());
        //normalin.db_h_tertinggi(CSV.strtodouble());
        //normalin.db_h_terendah(CSV.strtodouble());
        //normalin.db_h_penutupan(CSV.strtodouble());
        SOM p_som = new SOM();
        p_som.dataValue();
        //p_som.inisialisasi_bobot();
        //normalin.db_normalisasi(normalin.db_h_pembukaan(CSV.strtodouble()), normalin.db_h_tertinggi(CSV.strtodouble()), normalin.db_h_terendah(CSV.strtodouble()), normalin.db_h_penutupan(CSV.strtodouble()));        
        p_som.nilai_dj(p_som.inisialisasi_bobot(), normalin.db_normalisasi(normalin.db_h_pembukaan(CSV.strtodouble()), normalin.db_h_tertinggi(CSV.strtodouble()), normalin.db_h_terendah(CSV.strtodouble()), normalin.db_h_penutupan(CSV.strtodouble())));
    }
    
}
