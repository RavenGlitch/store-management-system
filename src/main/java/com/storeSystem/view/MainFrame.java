package com.storeSystem.view;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    private CardLayout cardLayout;
    private JPanel contentPanel;

    public MainFrame() {
        setTitle("سیستم مدیریت فروشگاه");
        setSize(1100, 700);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // ۱. مقداردهی اولیه لایوت و پنل مادر
        cardLayout = new CardLayout();
        contentPanel = new JPanel(cardLayout);

        // ۲. ساختن پنل سبد خرید و اضافه کردن آن به پنل مادر با یک اسم مستعار (کلید)
        CartAndSettlementPanel cartPanel = new CartAndSettlementPanel();
        contentPanel.add(cartPanel, "cartAndSettlement");

        // ۳. اضافه کردن پنل مادر به خودِ فریم اصلی (این همان خطی است که جا انداخته بودی)
        add(contentPanel, BorderLayout.CENTER);

        // ۴. دستور به کارد لایوت برای نمایش دادن پنل مورد نظر
        cardLayout.show(contentPanel, "cartAndSettlement");
    }
}