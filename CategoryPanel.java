package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.FlowLayout;
import java.awt.Font;

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
import data.categoryStore;
public class CategoryPanel extends JPanel {

    private JButton btnAdd;
    private JButton btnEdit;
    private JButton btnDelete;
    private JButton btnRefresh;

    private JTable table;
    private DefaultTableModel model;

    public CategoryPanel() {

        setLayout(new BorderLayout());

        setBackground(new Color(245, 245, 245));

        applyComponentOrientation(
                ComponentOrientation.RIGHT_TO_LEFT);

        Font font = new Font("Tahoma", Font.PLAIN, 14);
        JPanel bottomPanel = new JPanel();

        bottomPanel.setBackground(
                new Color(245, 245, 245));

        bottomPanel.setLayout(
                new FlowLayout(
                        FlowLayout.CENTER));

        bottomPanel.setComponentOrientation(
                ComponentOrientation.RIGHT_TO_LEFT);

        btnAdd = new JButton("افزودن");
        btnEdit = new JButton("ویرایش");
        btnDelete = new JButton("حذف");
        btnRefresh = new JButton("بروزرسانی");

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
        btnRefresh.setForeground(Color.WHITE);

        bottomPanel.add(btnAdd);
        bottomPanel.add(btnEdit);
        bottomPanel.add(btnDelete);
        bottomPanel.add(btnRefresh);

        String[] columns = { "نام دسته" };

        model = new DefaultTableModel(
                columns, 0);

        table = new JTable(model);

        table.setFont(font);

        table.getTableHeader()
                .setFont(font);

        table.setRowHeight(30);

        table.setComponentOrientation(
                ComponentOrientation.RIGHT_TO_LEFT);

        DefaultTableCellRenderer rightRenderer =new DefaultTableCellRenderer();
        rightRenderer.setHorizontalAlignment(SwingConstants.RIGHT);
        table.getColumnModel().getColumn(0).setCellRenderer(rightRenderer);
        table.getTableHeader().setBackground(new Color(63,81,181));
        table.getTableHeader().setForeground(Color.WHITE);
        JScrollPane scrollPane =new JScrollPane(table);
        add(scrollPane,BorderLayout.CENTER);
        add(bottomPanel,BorderLayout.SOUTH);
        btnAdd.addActionListener(e -> openAddDialog());
        btnEdit.addActionListener(e -> openEditDialog());
        btnDelete.addActionListener(e -> deleteCategory());
        btnRefresh.addActionListener(e -> { table.clearSelection();
        table.repaint();
        });
    }

    private void openAddDialog() {JDialog dialog =new JDialog();

        dialog.setTitle("افزودن دسته");
        dialog.setSize(350,180);
        dialog.setModal(true);
        dialog.setLocationRelativeTo(null);
        JPanel panel =new JPanel();
        panel.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        JLabel lblName =new JLabel("نام دسته:");
        JTextField txtName =new JTextField(15);
        txtName.setHorizontalAlignment(JTextField.RIGHT);
        JButton btnSave =new JButton("ثبت");
        panel.add(lblName);
        panel.add(txtName);
        panel.add(btnSave);
        dialog.add(panel);
        btnSave.addActionListener(e -> {
            String name = txtName.getText();
            if (name.trim().isEmpty()) {
                JOptionPane.showMessageDialog(dialog,"نام دسته را وارد کنید");
                return;
            }
            if (categoryStore.categories.contains(name)) {
                JOptionPane.showMessageDialog(dialog,"این دسته قبلاً ثبت شده است");
                return;
            }
            model.addRow(new Object[] {name});
            categoryStore.categories.add(name);
            dialog.dispose();
        });
        dialog.setVisible(true);
    }
    private void openEditDialog() {int selectedRow =table.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this,"ابتدا یک دسته را انتخاب کنید");
            return;
        }
        JDialog dialog = new JDialog();
        dialog.setTitle("ویرایش دسته");
        dialog.setSize(350,180);
        dialog.setModal(true);
        dialog.setLocationRelativeTo( null);
        JPanel panel =new JPanel();

        panel.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        JTextField txtName =new JTextField( model.getValueAt(selectedRow,0).toString(),15);
        txtName.setHorizontalAlignment(
                JTextField.RIGHT);
        JButton btnSave =new JButton("ثبت تغییرات");
        panel.add(new JLabel("نام دسته:"));
        panel.add(txtName);
        panel.add(btnSave);
        dialog.add(panel);
        btnSave.addActionListener(e -> {model.setValueAt(txtName.getText(),selectedRow,0);
            dialog.dispose();
        });

        dialog.setVisible(true);
    }

    private void deleteCategory() {int selectedRow =table.getSelectedRow();
        if (selectedRow == -1) {JOptionPane.showMessageDialog(this,"ابتدا یک دسته را انتخاب کنید");
            return;
        }

        model.removeRow(selectedRow);
    }
}