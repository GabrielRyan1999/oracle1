/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;
import model_RS.Dokter;
import model_RS.RumahSakit;

/**
 *
 * @author user only
 */
public class TambahDokterDialog extends JDialog {

    private RumahSakit rumahSakit;
    private JLabel tambahDokterLabel;
    private JLabel idDokterLabel;
    private JTextField idDokterText;
    private JLabel namaDokterLabel;
    private JTextField namaDokterText;
    private JButton tambahButton;
    private MyDokterDialog owner;

    public TambahDokterDialog(MyDokterDialog owner, RumahSakit rs) {
        super(owner);
        this.owner = owner;
        rumahSakit = rs;
        init();
    }

    /**
     * Fungsi untuk inisialisasi
     */
    public void init() {
        // set size
        setSize(400, 300);
        // set layout
        setLayout(null);
//        tambahDokterLabel = new JLabel("Tambah Dokter");
//        tambahDokterLabel.setBounds(10, 60, 50, 40);
        idDokterLabel = new JLabel("ID Dokter");
        idDokterLabel.setBounds(20, 40, 80, 25);
        idDokterText = new JTextField();
        idDokterText.setBounds(120, 40, 200, 25);

        namaDokterLabel = new JLabel("Nama");
        namaDokterLabel.setBounds(20, 70, 80, 25);
        namaDokterText = new JTextField();
        namaDokterText.setBounds(120, 70, 200, 25);
        // tambah Tombol Tambah
        tambahButton = new JButton("Tambah");
        tambahButton.setBounds(50, 200, 100, 30);
//        add(tambahDokterLabel);
        add(idDokterLabel);
        add(idDokterText);
        add(namaDokterLabel);
        add(namaDokterText);
        add(tambahButton);

        // set action listener button
        tambahButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                tambahDokter();
            }
        });
    }

    public void tambahDokter() {
                 
                    Dokter baru = new Dokter();
                    baru.setIdDokter(idDokterText.getText());
                    baru.setNama(namaDokterText.getText());
                    rumahSakit.tambahDokter(baru);
                
        owner.refreshTabelDokter();
        dispose();
    }
}
