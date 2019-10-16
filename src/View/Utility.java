/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import controller.*;
/**
 *
 * @author shola
 */
public class Utility {
    public DefaultTableModel modelData;
    private double[][] data;
    
    public void Load_Data(JTable Tabel_data, JLabel Filename) {
//        ArrayList<Cuaca> data_cuaca;
//        data_cuaca = new ArrayList();
        String path;
        JFileChooser chooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("CSV FILES", "csv", "Excel");
        chooser.setFileFilter(filter);
        chooser.setCurrentDirectory(new java.io.File("."));
        int result = chooser.showOpenDialog(null);
        Praprocess praprocess = new Praprocess();
        
        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = chooser.getSelectedFile();
            path = selectedFile.getAbsolutePath();
//            Filename.setText(selectedFile.getAbsolutePath());
            Filename.setText(selectedFile.getName());          
            Tabel_data.setModel(new DefaultTableModel());
            data = praprocess.getdata(path);
            loadDataMatrix(Tabel_data, data);
        } else {
            JOptionPane.showMessageDialog(null, "Muat data gagal", "Pesan Error", JOptionPane.ERROR_MESSAGE);
            //JOptionPane.showMessageDialog(null, "Muat Data Gagal");
        }
    }
      
    private void loadDataMatrix(JTable Tabel_data, double data[][]) {
        int baris = data.length;
        int kolom = data[0].length;
        modelData = (DefaultTableModel) Tabel_data.getModel();
        modelData.setColumnCount(kolom);
        for (int i = 0; i < baris; i++) {
            String row[] = new String[kolom];
            for (int j = 0; j < kolom; j++) {
                row[j] = String.valueOf(data[i][j]);
            }
            modelData.addRow(row);
        }
    }
    
    public double [][] get_data(){
        return data;
    }
    
    public void Predict(double [][] data){
        Normalisasi normalisasi = new Normalisasi();
        SOM p_som = new SOM();
        Backpropagation bp = new Backpropagation();
        
        //p_som.dataValue();
//        //p_som.nilai_dj(p_som.inisialisasi_bobot(), normalin.data_baru(CSV.gabung()));        
        
        double db_norm[][] = normalisasi.data_baru(data);
        double y[] = bp.y_netk(bp.z_netj(db_norm));
        double faktor[] = bp.error_u_keluaran(y, db_norm);
        bp.perubahan_wkj(faktor, bp.zj(db_norm));
        bp.error_u_tersembunyi(bp.bobot_lk(), faktor);
    }
    
}
