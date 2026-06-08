package Main.java;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import javax.swing.SwingConstants;

import java.awt.ComponentOrientation;
import view.CategoryPanel;
import view.productPanel;


public class Main {

    public static void main(String[] args) {

        JFrame frame =
                new JFrame("سیستم مدیریت فروشگاه");

        frame.setSize(1000, 600);

        frame.setDefaultCloseOperation(
                JFrame.EXIT_ON_CLOSE);

        JTabbedPane tabs =
                new JTabbedPane();
        tabs.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);

        tabs.addTab(
                "دسته بندی ها",
                new CategoryPanel());

        tabs.addTab(
                "کالاها",
                new productPanel());

        frame.add(tabs);

        frame.setLocationRelativeTo(null);

        frame.setVisible(true);
    }  
}