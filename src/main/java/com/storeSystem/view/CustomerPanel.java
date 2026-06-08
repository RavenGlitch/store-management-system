package com.storeSystem.view;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class CustomerPanel extends JPanel {

    private JTextField firstNameField;
    private JTextField lastNameField;
    private JTextField mobileField;

    private JButton addButton;
    private JButton deleteButton;
    private JButton editButton;

    private JTable customerTable;
    private DefaultTableModel tableModel;

    public CustomerPanel() {

        setLayout(new BorderLayout());

        initializeComponents();

        layoutComponents();
    }

    private void initializeComponents() {

        firstNameField = new JTextField(15);
        lastNameField = new JTextField(15);
        mobileField = new JTextField(15);

        addButton = new JButton("اضافه");
        deleteButton = new JButton("حذف");
        editButton = new JButton("ویرایش");

        String[] columns = {
                "ID",
                "نام",
                "نام خانوادگی",
                "شماره موبایل"
        };

        tableModel = new DefaultTableModel(columns, 0);

        customerTable = new JTable(tableModel);
    }

    private void layoutComponents() {

        JPanel formPanel = new JPanel(new GridLayout(4, 2, 10, 10));

        formPanel.add(new JLabel("نام:"));
        formPanel.add(firstNameField);

        formPanel.add(new JLabel("نام خانوادگی:"));
        formPanel.add(lastNameField);

        formPanel.add(new JLabel("شماره موبایل:"));
        formPanel.add(mobileField);

        JPanel buttonPanel = new JPanel();

        buttonPanel.add(addButton);
        buttonPanel.add(editButton);
        buttonPanel.add(deleteButton);

        JPanel topPanel = new JPanel(new BorderLayout());

        topPanel.add(formPanel, BorderLayout.CENTER);
        topPanel.add(buttonPanel, BorderLayout.SOUTH);

        JScrollPane scrollPane =new JScrollPane(customerTable);

        add(topPanel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
    }

    public JTextField getFirstNameField() {
        return firstNameField;
    }

    public JTextField getLastNameField() {
        return lastNameField;
    }

    public JTextField getMobileField() {
        return mobileField;
    }

    public JButton getAddButton() {
        return addButton;
    }

    public JButton getDeleteButton() {
        return deleteButton;
    }

    public JButton getEditButton() {
        return editButton;
    }

    public JTable getCustomerTable() {
        return customerTable;
    }

    public DefaultTableModel getTableModel() {
        return tableModel;
    }
}
