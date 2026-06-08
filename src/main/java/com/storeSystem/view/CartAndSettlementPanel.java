package com.storeSystem.view;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class CartAndSettlementPanel extends JPanel {

    public CartAndSettlementPanel() {
        setLayout(new BorderLayout(10, 10));
        setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));

        JPanel topPanel = createTopPanel();
        add(topPanel, BorderLayout.NORTH);

        JPanel centerPanel = createCenterPanel();
        add(centerPanel, BorderLayout.CENTER);
    }

    private JPanel createTopPanel() {
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        JButton btnNewCustomer = new JButton("مشتری جدید");
        btnNewCustomer.putClientProperty("FlatLaf.style", "buttonType: default; arc: 8;");

        JTextField txtSearchCustomer = new JTextField();
        txtSearchCustomer.putClientProperty("JTextField.placeholderText", "جستجوی مشتری...");
        txtSearchCustomer.putClientProperty("FlatLaf.style", "arc: 8;");

        JLabel lblSearch = new JLabel("جستجوی مشتری:");

        String[] customers = {"انتخاب مشتری...", "علی رضایی", "زهرا محمدی"};
        JComboBox<String> comboCustomers = new JComboBox<>(customers);
        comboCustomers.putClientProperty("FlatLaf.style", "arc: 8;");

        JLabel lblSelect = new JLabel("انتخاب مشتری:");

        gbc.gridx = 4; gbc.weightx = 0.0; panel.add(btnNewCustomer, gbc);
        gbc.gridx = 2; gbc.weightx = 1.0; panel.add(txtSearchCustomer, gbc);
        gbc.gridx = 3; gbc.weightx = 0.0; panel.add(lblSearch, gbc);
        gbc.gridx = 0; gbc.weightx = 0.5; panel.add(comboCustomers, gbc);
        gbc.gridx = 1; gbc.weightx = 0.0; panel.add(lblSelect, gbc);

        return panel;
    }

    private JPanel createCenterPanel() {
        JPanel mainCenter = new JPanel(new GridLayout(1, 2, 15, 0));

        JPanel rightProductPanel = new JPanel(new BorderLayout(5, 10));

        JPanel rightTopFilter = new JPanel(new GridBagLayout());
        GridBagConstraints gbcRight = new GridBagConstraints();
        gbcRight.insets = new Insets(2, 2, 2, 2);
        gbcRight.fill = GridBagConstraints.HORIZONTAL;

        JComboBox<String> comboCategory = new JComboBox<>(new String[]{"همه", "دفتری", "لوازم تحریر"});
        JLabel lblCategory = new JLabel("دسته:");
        JTextField txtSearchProduct = new JTextField();
        txtSearchProduct.putClientProperty("JTextField.placeholderText", "کد یا نام...");
        JLabel lblSearchProd = new JLabel("جستجوی کد/نام:");

        gbcRight.gridx = 0; gbcRight.weightx = 0.4; rightTopFilter.add(comboCategory, gbcRight);
        gbcRight.gridx = 1; gbcRight.weightx = 0.0; rightTopFilter.add(lblCategory, gbcRight);
        gbcRight.gridx = 2; gbcRight.weightx = 0.6; rightTopFilter.add(txtSearchProduct, gbcRight);
        gbcRight.gridx = 3; gbcRight.weightx = 0.0; rightTopFilter.add(lblSearchProd, gbcRight);

        String[] prodColumns = {"کد", "نام کالا", "قیمت", "موجودی", "دسته"};
        DefaultTableModel prodModel = new DefaultTableModel(prodColumns, 0);
        prodModel.addRow(new Object[]{"953065", "خودکار بیک", "100,000 ریال", "37", "خودکار"});
        JTable prodTable = new JTable(prodModel);
        prodTable.setRowHeight(30);
        JScrollPane prodScroll = new JScrollPane(prodTable);

        JButton btnAddToCart = new JButton("افزودن به سبد");
        btnAddToCart.putClientProperty("FlatLaf.style", "buttonType: default; font: bold; arc: 5;");

        rightProductPanel.add(rightTopFilter, BorderLayout.NORTH);
        rightProductPanel.add(prodScroll, BorderLayout.CENTER);
        rightProductPanel.add(btnAddToCart, BorderLayout.SOUTH);


        JPanel leftCartPanel = new JPanel(new BorderLayout(5, 10));

        String[] cartColumns = {"کد", "کالا", "قیمت واحد", "تعداد", "جمع"};
        DefaultTableModel cartModel = new DefaultTableModel(cartColumns, 0);
        JTable cartTable = new JTable(cartModel);
        cartTable.setRowHeight(30);
        JScrollPane cartScroll = new JScrollPane(cartTable);

        JPanel cartButtonsPanel = new JPanel(new GridLayout(1, 4, 5, 0));
        JButton btnRefresh = new JButton("رفرش");
        JButton btnCheckout = new JButton("تسویه");
        JButton btnDeleteRow = new JButton("حذف قلم");
        JButton btnEditCount = new JButton("ویرایش تعداد");

        cartButtonsPanel.add(btnRefresh);
        cartButtonsPanel.add(btnCheckout);
        cartButtonsPanel.add(btnDeleteRow);
        cartButtonsPanel.add(btnEditCount);

        JLabel lblTotal = new JLabel("جمع کل: 0 ریال", SwingConstants.RIGHT);
        lblTotal.putClientProperty("FlatLaf.style", "font: bold +3; foreground: @accentColor;");

        JPanel leftBottomLayout = new JPanel(new BorderLayout(0, 5));
        leftBottomLayout.add(cartButtonsPanel, BorderLayout.CENTER);
        leftBottomLayout.add(lblTotal, BorderLayout.SOUTH);

        leftCartPanel.add(cartScroll, BorderLayout.CENTER);
        leftCartPanel.add(leftBottomLayout, BorderLayout.SOUTH);

        mainCenter.add(rightProductPanel);
        mainCenter.add(leftCartPanel);

        return mainCenter;
    }
}