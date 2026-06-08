package com.storeSystem.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.JComboBox;
import com.storeSystem.data.CategoryStore;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
public class ProductPanel extends JPanel {
    private JComboBox<String>cmbFilter;
    private static int nextCode=1001;
    private JButton btnAdd;
    private JButton btnEdit;
    private JButton btnDelete;
    private JButton btnRefresh;
    private JTextField txtSearch;
    private JButton btnSearch;
    private JTable table;
    private DefaultTableModel model;

    public ProductPanel() {

        setLayout(new BorderLayout());

        setBackground(new Color(245, 245, 245));
        applyComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        Font font =new Font("Tahoma",Font.PLAIN,14);
        JPanel bottomPanel =new JPanel();
        bottomPanel.setBackground(new Color(245, 245, 245));
        bottomPanel.setLayout(new FlowLayout( FlowLayout.CENTER));
        bottomPanel.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        btnAdd =new JButton("افزودن");
        btnEdit = new JButton("ویرایش");
        btnDelete =new JButton("حذف");
        btnRefresh =new JButton("بروزرسانی");
        btnAdd.setFont(font);
        btnEdit.setFont(font);
        btnDelete.setFont(font);
        btnRefresh.setFont(font);
        btnAdd.setBackground(
                new Color(76, 175, 80));
        btnAdd.setForeground(Color.WHITE);

        btnEdit.setBackground(
                new Color(33, 150, 243));
        btnEdit.setForeground(Color.WHITE);

        btnDelete.setBackground(
                new Color(244, 67, 54));
        btnDelete.setForeground(Color.WHITE);

        btnRefresh.setBackground(
                new Color(255, 193, 7));
        cmbFilter=new JComboBox<>();
        cmbFilter.addItem("همه");
        for(String category:CategoryStore.categories) {
            cmbFilter.addItem(category);
        }
        JPanel searchPanel =new JPanel();
        searchPanel.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        txtSearch=new JTextField(20);
        txtSearch.setHorizontalAlignment(JTextField.RIGHT);
        btnSearch=new JButton("جستجو");
        searchPanel.add(new JLabel("جستجو:",SwingConstants.RIGHT));
        searchPanel.add(txtSearch);
        searchPanel.add(btnSearch);
        add(searchPanel,BorderLayout.NORTH);
        btnRefresh.setForeground(Color.WHITE);
        btnSearch.addActionListener(e->{
            String searchText=txtSearch.getText().trim();
            if(searchText.isEmpty()) {
                return;
            }
            for(int i=0;i<table.getRowCount();i++){
                String productName=table.getValueAt(i,1).toString();
                if(productName.contains(searchText)) {
                    table.setRowSelectionInterval(i, i);
                    table.scrollRectToVisible(table.getCellRect(i, 0, true));
                    return;
                }
            }
            JOptionPane.showMessageDialog(this, "کالایی پیدا نشد");
        });
        searchPanel.add(cmbFilter);
        cmbFilter.addActionListener(e ->{
            String selectedCategory=cmbFilter.getSelectedItem().toString();
            if(selectedCategory.equals("همه")) {
                table.clearSelection();
                return;
            }
            for(int i =0;i<table.getRowCount();i++) {
                String category=table.getValueAt(i, 4).toString();
                if(category.equals(selectedCategory)) {
                    table.scrollRectToVisible(table.getCellRect(i,0,true));
                    return;
                }}});
        searchPanel.add(new JLabel("دسته بندی"),SwingConstants.RIGHT);

        bottomPanel.add(btnAdd);
        bottomPanel.add(btnEdit);
        bottomPanel.add(btnDelete);
        bottomPanel.add(btnRefresh);

        String[] columns = {"کد کالا","نام کالا","قیمت","موجودی","دسته بندی"
        };


        model = new DefaultTableModel(columns,0);
        table =new JTable(model);
        table.setFont(font);
        table.getTableHeader().setFont(font);
        table.setRowHeight(30);
        table.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        DefaultTableCellRenderer rightRenderer = new DefaultTableCellRenderer();
        rightRenderer.setHorizontalAlignment(SwingConstants.RIGHT);
        for (int i = 0;i < table.getColumnCount();i++) {
            table.getColumnModel().getColumn(i).setCellRenderer( rightRenderer);
        }
        table.getTableHeader()
                .setBackground(
                        new Color(63,81,181));
        table.getTableHeader().setForeground(Color.WHITE);
        JScrollPane scrollPane =new JScrollPane(table);
        add(scrollPane,BorderLayout.CENTER);
        add(bottomPanel,BorderLayout.SOUTH);
        btnAdd.addActionListener( e -> openAddDialog());
        btnEdit.addActionListener(e -> openEditDialog());
        btnDelete.addActionListener(e -> deleteProduct());
        btnRefresh.addActionListener(e -> {table.clearSelection();
            JOptionPane.showMessageDialog(this,"اطلاعات بروزرسانی شد");
        });
    }
    private void openAddDialog() {

        JDialog dialog = new JDialog();dialog.setTitle("افزودن کالا");
        dialog.setSize(450,300);
        dialog.setModal(true);
        dialog.setLocationRelativeTo(null);
        dialog.applyComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        JPanel panel =new JPanel(new GridLayout(6,2,5,5));
        panel.setComponentOrientation(
                ComponentOrientation.RIGHT_TO_LEFT);
        JTextField txtCode =
                new JTextField(String.valueOf(nextCode));
        txtCode.setEditable(false);
        JTextField txtName =
                new JTextField();
        JTextField txtPrice =
                new JTextField();
        JTextField txtStock =
                new JTextField();
        JComboBox<String> cmbCategory =
                new JComboBox<>();
        for(String category:CategoryStore.categories) {
            cmbCategory.addItem(category);
        }
        txtCode.setHorizontalAlignment(
                JTextField.RIGHT);

        txtName.setHorizontalAlignment(
                JTextField.RIGHT);

        txtPrice.setHorizontalAlignment(
                JTextField.RIGHT);

        txtStock.setHorizontalAlignment(
                JTextField.RIGHT);

        panel.add(new JLabel("کد کالا",SwingConstants.RIGHT));
        panel.add(txtCode);
        panel.add(new JLabel("نام کالا",SwingConstants.RIGHT));
        panel.add(txtName);
        panel.add(new JLabel("قیمت",SwingConstants.RIGHT));
        panel.add(txtPrice);
        panel.add(new JLabel("موجودی",SwingConstants.RIGHT));
        panel.add(txtStock);
        panel.add(new JLabel("دسته بندی",SwingConstants.RIGHT));
        panel.add(cmbCategory);
        JButton btnSave =new JButton("ثبت");
        panel.add(new JLabel());
        panel.add(btnSave);
        dialog.add(panel);
        btnSave.addActionListener(e -> {
            int stock=Integer.parseInt(txtStock.getText());
            model.addRow(
                    new Object[] {
                            txtCode.getText(),
                            txtName.getText(),
                            txtPrice.getText(),
                            txtStock.getText(),
                            cmbCategory.getSelectedItem()
                    });
            if(stock<5) {JOptionPane.showMessageDialog(dialog, "هشدار:موجودی کالا کمتر از 5 عدد است");}
            nextCode++;
            dialog.dispose();
        });
        dialog.setVisible(true);
    }
    private void openEditDialog() {

        int selectedRow =
                table.getSelectedRow();

        if (selectedRow == -1) {

            JOptionPane.showMessageDialog(
                    this,
                    "ابتدا یک کالا را انتخاب کنید");

            return;
        }
        JDialog dialog =new JDialog();
        dialog.setTitle("ویرایش کالا");
        dialog.setSize(450,300);
        dialog.setModal(true);
        dialog.setLocationRelativeTo(
                null);
        dialog.applyComponentOrientation(
                ComponentOrientation.RIGHT_TO_LEFT);
        JPanel panel =new JPanel(new GridLayout( 6,2,5, 5));
        panel.setComponentOrientation(
                ComponentOrientation.RIGHT_TO_LEFT);
        JTextField txtCode =
                new JTextField(
                        model.getValueAt(selectedRow,0).toString());
        JTextField txtName =
                new JTextField(
                        model.getValueAt(selectedRow,1).toString());
        JTextField txtPrice =
                new JTextField(model.getValueAt(selectedRow,2).toString());
        JTextField txtStock =new JTextField(model.getValueAt(selectedRow,3).toString());
        JComboBox<String>cmbCategory =new JComboBox<>();
        for(String category:CategoryStore.categories) {
            cmbCategory.addItem(category);
        }
        cmbCategory.setSelectedItem(model.getValueAt(selectedRow, 4));
        txtCode.setHorizontalAlignment(
                JTextField.RIGHT);
        txtName.setHorizontalAlignment(
                JTextField.RIGHT);
        txtPrice.setHorizontalAlignment(
                JTextField.RIGHT);
        txtStock.setHorizontalAlignment(JTextField.RIGHT);
        panel.add(new JLabel("کد کالا",SwingConstants.RIGHT));
        panel.add(txtCode);
        panel.add(new JLabel("نام کالا",SwingConstants.RIGHT));
        panel.add(txtName);
        panel.add(new JLabel("قیمت",SwingConstants.RIGHT));
        panel.add(txtPrice);
        panel.add(new JLabel("موجودی",SwingConstants.RIGHT));
        panel.add(txtStock);
        panel.add(new JLabel("دسته بندی",SwingConstants.RIGHT));
        panel.add(cmbCategory);
        JButton btnSave = new JButton("ثبت تغییرات");
        panel.add(new JLabel());
        panel.add(btnSave);
        dialog.add(panel);
        btnSave.addActionListener(e -> {
            model.setValueAt(txtCode.getText(),selectedRow,0);
            model.setValueAt(txtName.getText(),selectedRow,1);
            model.setValueAt(txtPrice.getText(),selectedRow, 2);
            model.setValueAt(txtStock.getText(),selectedRow,3);
            model.setValueAt(cmbCategory.getSelectedItem(),selectedRow,4);
            dialog.dispose();});
        dialog.setVisible(true);
    }
    private void deleteProduct() {
        int selectedRow = table.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(
                    this,"ابتدا یک کالا را انتخاب کنید");
            return;
        }

        model.removeRow(selectedRow);
    }
}
