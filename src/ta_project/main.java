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
        CSV.print(CSV.gabung());
        
        normalisasi normalin = new normalisasi();
        
        SOM p_som = new SOM();
        //p_som.dataValue();
        //p_som.nilai_dj(p_som.inisialisasi_bobot(), normalin.data_baru(CSV.gabung()));
        
        backpropagation bp = new backpropagation();
        
        double db_norm[][] = normalin.data_baru(CSV.gabung());
        double y[] = bp.y_netk(bp.z_netj(db_norm));
        double faktor[] = bp.error_u_keluaran(y, db_norm);
        bp.perubahan_wkj(faktor, bp.zj(db_norm));
        bp.error_u_tersembunyi(bp.bobot_lk(), faktor);
    }
}