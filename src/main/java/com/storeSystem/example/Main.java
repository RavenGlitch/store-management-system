package com.storeSystem.example;

import com.storeSystem.view.MainFrame;
import com.formdev.flatlaf.themes.FlatMacDarkLaf;
import javax.swing.SwingUtilities;
import javax.swing.*;

public class Main {

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(new FlatMacDarkLaf());
        } catch (Exception ex) {
            System.err.println("Failed to initialize LaF");
        }

        SwingUtilities.invokeLater(() -> {
            JFrame frame = new MainFrame();
            frame.setVisible(true);
        });

    }
}
