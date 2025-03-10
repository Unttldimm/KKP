/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jframe;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.table.DefaultTableModel;


public class FormBarang extends JFrame {
    
    // Deklarasi komponen form
    private JTextField kodeBarangField, namaBarangField, hargaBeliField, hargaJualField;
    private JComboBox<String> kategoriComboBox, satuanComboBox;
    private JTextArea deskripsiArea;
    private JTable table;

    public FormBarang() {
        setTitle("Form Barang");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Header
        JLabel header = new JLabel("Form Barang", SwingConstants.CENTER);
        header.setFont(new Font("Arial", Font.BOLD, 20));
        add(header, BorderLayout.NORTH);

        // Panel Form
        JPanel formPanel = new JPanel(new GridLayout(7, 2, 10, 10));
        formPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        formPanel.add(new JLabel("Kode Barang:"));
        kodeBarangField = new JTextField();
        formPanel.add(kodeBarangField);

        formPanel.add(new JLabel("Nama Barang:"));
        namaBarangField = new JTextField();
        formPanel.add(namaBarangField);

        formPanel.add(new JLabel("Kategori:"));
        String[] kategori = {"CCTV", "Radio", "Alarm"};
        kategoriComboBox = new JComboBox<>(kategori);
        formPanel.add(kategoriComboBox);

        formPanel.add(new JLabel("Harga Beli:"));
        hargaBeliField = new JTextField();
        formPanel.add(hargaBeliField);

        formPanel.add(new JLabel("Harga Jual:"));
        hargaJualField = new JTextField();
        formPanel.add(hargaJualField);

        formPanel.add(new JLabel("Satuan:"));
        String[] satuan = {"pcs", "unit", "pack"};
        satuanComboBox = new JComboBox<>(satuan);
        formPanel.add(satuanComboBox);

        formPanel.add(new JLabel("Deskripsi:"));
        deskripsiArea = new JTextArea(3, 20);
        formPanel.add(new JScrollPane(deskripsiArea));

        add(formPanel, BorderLayout.CENTER);

        // Panel Tombol Aksi
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        JButton tambahButton = new JButton("Tambah");
        JButton simpanButton = new JButton("Simpan");
        JButton editButton = new JButton("Edit");
        JButton hapusButton = new JButton("Hapus");
        JButton batalButton = new JButton("Batal");

        buttonPanel.add(tambahButton);
        buttonPanel.add(simpanButton);
        buttonPanel.add(editButton);
        buttonPanel.add(hapusButton);
        buttonPanel.add(batalButton);

        add(buttonPanel, BorderLayout.SOUTH);

        // Tabel Daftar Barang
        String[] columnNames = {"Kode", "Nama Barang", "Kategori", "Harga Beli", "Harga Jual", "Satuan", "Deskripsi"};
        Object[][] data = {
                {"B001", "CCTV 4K", "CCTV", "1.500.000", "2.000.000", "pcs", "-"},
                {"B002", "Radio HT", "Radio", "300.000", "500.000", "unit", "-"}
        };
        table = new JTable(data, columnNames);
        add(new JScrollPane(table), BorderLayout.EAST);

        // Event Listener untuk tombol
        tambahButton.addActionListener(e -> tambahBarang());
        batalButton.addActionListener(e -> resetForm());

        setVisible(true);
    }

    // Method untuk menambahkan barang ke tabel
    private void tambahBarang() {
        String kode = kodeBarangField.getText();
        String nama = namaBarangField.getText();
        String kategori = (String) kategoriComboBox.getSelectedItem();
        String hargaBeli = hargaBeliField.getText();
        String hargaJual = hargaJualField.getText();
        String satuan = (String) satuanComboBox.getSelectedItem();
        String deskripsi = deskripsiArea.getText();

        if (kode.isEmpty() || nama.isEmpty() || hargaBeli.isEmpty() || hargaJual.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Semua field harus diisi!", "Peringatan", JOptionPane.WARNING_MESSAGE);
            return;
        }

        // Tambah data ke tabel
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.addRow(new Object[]{kode, nama, kategori, hargaBeli, hargaJual, satuan, deskripsi});

        // Reset form setelah menambah data
        resetForm();
    }

    // Method untuk mereset form input
    private void resetForm() {
        kodeBarangField.setText("");
        namaBarangField.setText("");
        hargaBeliField.setText("");
        hargaJualField.setText("");
        deskripsiArea.setText("");
        kategoriComboBox.setSelectedIndex(0);
        satuanComboBox.setSelectedIndex(0);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(FormBarang::new);
    }
}