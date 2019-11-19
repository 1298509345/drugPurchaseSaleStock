package myPackage.UI;

import myPackage.BLL.JTextFieldHintListener;
import myPackage.BLL.Util;
import myPackage.BLL.businessProcess;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

public class funcUI {
    public static void funcFrame() {
        JFrame frame = new JFrame("功能界面");
        frame.setSize(1000, 750);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        frame.add(panel);
        SaveDrugComp(panel);
        PurchaseDrugComp(panel);
        removeFromRepositoryComp(panel);
        saleDrugComp(panel);
        providerInfoComp(panel);
        selectResultArea(panel);
        frame.setVisible(true);
    }

    public static void SaveDrugComp(JPanel panel) {
        panel.setLayout(null);
        JLabel label = new JLabel("记录药品");
        label.setBounds(10, 20, 80, 25);
        panel.add(label);

        JTextField jtf = new JTextField(20);
        jtf.addFocusListener(new JTextFieldHintListener(jtf,"药品名称"));
        jtf.setBounds(100, 20, 80, 25);
        panel.add(jtf);

        JTextField jtf2 = new JTextField(20);
        jtf2.addFocusListener(new JTextFieldHintListener(jtf2,"药品编号"));
        jtf2.setBounds(200, 20, 80, 25);
        panel.add(jtf2);

        JTextField jtf3 = new JTextField(20);
        jtf3.addFocusListener(new JTextFieldHintListener(jtf3,"供应商编号"));
        jtf3.setBounds(300, 20, 80, 25);
        panel.add(jtf3);

        JTextField jtf4 = new JTextField(20);
        jtf4.addFocusListener(new JTextFieldHintListener(jtf4,"零售价"));
        jtf4.setBounds(400, 20, 80, 25);
        panel.add(jtf4);

        JTextField jtf5 = new JTextField(20);
        jtf5.addFocusListener(new JTextFieldHintListener(jtf5,"进货价"));
        jtf5.setBounds(500, 20, 80, 25);
        panel.add(jtf5);

        JTextField jtf6=new JTextField(20);
        jtf6.addFocusListener(new JTextFieldHintListener(jtf6,"有效期 yy MM dd"));
        jtf6.setBounds(600,20,100,25);
        panel.add(jtf6);

        JButton button = new JButton("保存药品");
        button.setBounds(750, 20, 100, 25);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (businessProcess.saveDrug(jtf.getText(),
                        new Integer(jtf2.getText()),
                        new Integer(jtf3.getText()),
                        new Float(jtf4.getText()),
                        new Float(jtf5.getText()),
                        jtf6.getText())
            ) JOptionPane.showMessageDialog(null, "保存成功", "tips", JOptionPane.INFORMATION_MESSAGE);
                else
                    JOptionPane.showMessageDialog(null, "保存失败", "error", JOptionPane.ERROR_MESSAGE);
            }
        });
        panel.add(button);
    }

    public static void PurchaseDrugComp(JPanel panel) {
        JLabel label = new JLabel("购进药品");
        label.setBounds(10, 60, 80, 25);
        panel.add(label);

        JTextField jtf = new JTextField(20);
        jtf.addFocusListener(new JTextFieldHintListener(jtf,"药品名称"));
        jtf.setBounds(100, 60, 80, 25);
        panel.add(jtf);

        JTextField jtf2 = new JTextField(20);
        jtf2.addFocusListener(new JTextFieldHintListener(jtf2,"药品编号"));
        jtf2.setBounds(200, 60, 80, 25);
        panel.add(jtf2);

        JTextField jtf3 = new JTextField(20);
        jtf3.addFocusListener(new JTextFieldHintListener(jtf3,"供应商编号"));
        jtf3.setBounds(300, 60, 80, 25);
        panel.add(jtf3);

        JTextField jtf4 = new JTextField(20);
        jtf4.addFocusListener(new JTextFieldHintListener(jtf4,"购进数量"));
        jtf4.setBounds(400, 60, 80, 25);
        panel.add(jtf4);

        JButton button = new JButton("购进");
        button.setBounds(600, 60, 100, 25);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (businessProcess.purchaseDrug(jtf.getText(),
                        new Integer(jtf2.getText()),
                        new Integer(jtf3.getText()),
                        new Integer(jtf4.getText())))
                    JOptionPane.showMessageDialog(null, "购入成功", "tips", JOptionPane.INFORMATION_MESSAGE);
                else
                    JOptionPane.showMessageDialog(null, "购入失败", "error", JOptionPane.ERROR_MESSAGE);
            }
        });
        panel.add(button);
    }

    public static void removeFromRepositoryComp(JPanel panel) {
        JLabel label = new JLabel("移除过期药品");
        label.setBounds(10, 100, 80, 25);
        panel.add(label);

        JTextField jtf = new JTextField(20);
        jtf.addFocusListener(new JTextFieldHintListener(jtf,"药品编号"));
        jtf.setBounds(100, 100, 80, 25);
        panel.add(jtf);

        JTextField jtf2 = new JTextField(20);
        jtf2.addFocusListener(new JTextFieldHintListener(jtf2,"处理方式"));
        jtf2.setBounds(200, 100, 80, 25);
        panel.add(jtf2);

        JButton button = new JButton("移除");
        button.setBounds(600, 100, 100, 25);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (businessProcess.removeFromRepository(new Integer(jtf.getText()),jtf2.getText())
                )
                    JOptionPane.showMessageDialog(null, "移除成功", "tips", JOptionPane.INFORMATION_MESSAGE);
                else
                    JOptionPane.showMessageDialog(null, "移除失败", "error", JOptionPane.ERROR_MESSAGE);
            }
        });
        panel.add(button);
    }

    public static void saleDrugComp(JPanel panel) {
        JLabel label = new JLabel("药品销售");
        label.setBounds(10, 140, 80, 25);
        panel.add(label);

        JTextField jtf = new JTextField(20);
        jtf.addFocusListener(new JTextFieldHintListener(jtf,"药品编号"));
        jtf.setBounds(100, 140, 80, 25);
        panel.add(jtf);

        JTextField jtf2 = new JTextField(20);
        jtf2.addFocusListener(new JTextFieldHintListener(jtf2,"药品名称"));
        jtf2.setBounds(200, 140, 80, 25);
        panel.add(jtf2);

        JTextField jtf3 = new JTextField(20);
        jtf3.addFocusListener(new JTextFieldHintListener(jtf3,"销售数量"));
        jtf3.setBounds(300, 140, 80, 25);
        panel.add(jtf3);

        JTextField jtf4 = new JTextField(20);
        jtf4.addFocusListener(new JTextFieldHintListener(jtf4,"销售价格"));
        jtf4.setBounds(400, 140, 80, 25);
        panel.add(jtf4);

        JTextField jtf5 = new JTextField(20);
        jtf5.addFocusListener(new JTextFieldHintListener(jtf5,"顾客名称"));
        jtf5.setBounds(500, 140, 80, 25);
        panel.add(jtf5);

        JButton button = new JButton("保存销售记录");
        button.setBounds(600, 140, 120, 25);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (businessProcess.saleDrug(new Integer(jtf.getText()),
                        jtf2.getText(),
                        new Integer(jtf3.getText()),
                        new Float(jtf4.getText()),
                        jtf5.getText())
                ) JOptionPane.showMessageDialog(null, "保存成功", "tips", JOptionPane.INFORMATION_MESSAGE);
                else
                    JOptionPane.showMessageDialog(null, "保存失败", "error", JOptionPane.ERROR_MESSAGE);
            }
        });
        panel.add(button);
    }

    public static void providerInfoComp(JPanel panel) {
        JLabel label = new JLabel("供应商信息");
        label.setBounds(10, 180, 80, 25);
        panel.add(label);

        JTextField jtf = new JTextField(20);
        jtf.addFocusListener(new JTextFieldHintListener(jtf,"供应商编号"));
        jtf.setBounds(100, 180, 80, 25);
        panel.add(jtf);

        JTextField jtf2 = new JTextField(20);
        jtf2.addFocusListener(new JTextFieldHintListener(jtf2,"供应商名称"));
        jtf2.setBounds(200, 180, 80, 25);
        panel.add(jtf2);

        JTextField jtf3 = new JTextField(20);
        jtf3.addFocusListener(new JTextFieldHintListener(jtf3,"供应商联系方式"));
        jtf3.setBounds(300, 180, 100, 25);
        panel.add(jtf3);

        JButton button = new JButton("保存供应商信息");
        button.setBounds(600, 180, 130, 25);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (businessProcess.providerInfo(new Integer(jtf.getText()),
                        jtf2.getText(),
                        jtf3.getText()
                )
                ) JOptionPane.showMessageDialog(null, "保存成功", "tips", JOptionPane.INFORMATION_MESSAGE);
                else
                    JOptionPane.showMessageDialog(null, "保存失败", "error", JOptionPane.ERROR_MESSAGE);
            }
        });
        panel.add(button);
    }

    public static void selectFrame(JTable table) {
        JFrame frame = new JFrame("查询结果");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(1000, 300);
        JScrollPane scrollPane = new JScrollPane(table);
        frame.setLocationRelativeTo(null);
        frame.add(scrollPane);
        frame.setVisible(true);
    }

    public static void selectResultArea(JPanel panel) {
        JLabel label = new JLabel("查询结果集");
        label.setBounds(10, 220, 80, 25);
        panel.add(label);

        final String selectTable = null;

        JComboBox<String> cb = new JComboBox();
        cb.setBounds(10, 250, 200, 40);
        cb.addItem("Drug");
        cb.addItem("Provider");
        cb.addItem("Expired_Drug");
        cb.addItem("Repository");
        cb.addItem("SALE");
        panel.add(cb);

        JTable table = new JTable();
        table.setBounds(10, 350, 1000, 300);

        JScrollPane scrollPane = new JScrollPane(table);

        JButton button = new JButton("查询");
        button.setBounds(100, 300, 80, 25);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ResultSet re = Util.selectRes((String) cb.getSelectedItem());
                try {
                    Util.displayResultSet(table, re);
                    selectFrame(table);
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });
        panel.add(button);
    }

}
