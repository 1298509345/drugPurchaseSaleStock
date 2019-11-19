package myPackage.UI;

import myPackage.BLL.Util;
import myPackage.BLL.businessProcess;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class loginUI {
    public static void main(String[] args) {
        loginUI();
    }

    public static void loginUI() {

        JFrame frame = new JFrame("登录");
        frame.setLayout(null);
        ImageIcon icon = new ImageIcon("src/myPackage/Sources/封面.png");
        JLabel label1 = new JLabel(icon);
        label1.setBounds(0, 0, icon.getIconWidth(), icon.getIconHeight());
        frame.getLayeredPane().add(label1, new Integer(Integer.MIN_VALUE));
        frame.setSize(icon.getIconWidth(), icon.getIconHeight());
        frame.setLocationRelativeTo(null);

        JPanel p = (JPanel) frame.getContentPane();
        p.setOpaque(false);

        JLabel headLine=new JLabel("药品进销存管理系统");
        headLine.setFont(new Font("黑体", Font.PLAIN,35));
        headLine.setBounds(230,150,400,100);
        frame.add(headLine);

        JLabel userLabel = new JLabel("用户名:");
        userLabel.setBounds(250, 300, 80, 25);
        frame.add(userLabel);

        JTextField userText = new JTextField(20);
        userText.setBounds(330, 300, 165, 25);
        frame.add(userText);

        JLabel passwordLabel = new JLabel("密码:");
        passwordLabel.setBounds(250, 330, 80, 25);
        frame.add(passwordLabel);

        JPasswordField passwordText = new JPasswordField(20);
        passwordText.setBounds(330, 330, 165, 25);
        frame.add(passwordText);

        JButton loginButton = new JButton("登录");
        loginButton.setBounds(250, 380, 80, 25);
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (Util.checkAccount(userText.getText(), passwordText.getText())) {
                    funcUI.funcFrame();
                    frame.setVisible(false);
                } else {
                    JOptionPane.showMessageDialog(null, "账号或密码错误", "error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        frame.add(loginButton);

        JButton register = new JButton("注册");
        register.setBounds(415, 380, 80, 25);
        register.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (businessProcess.addUser(userText.getText(), passwordText.getText(), "无"))
                    JOptionPane.showMessageDialog(null, "注册成功", "tips", JOptionPane.INFORMATION_MESSAGE);
                else
                    JOptionPane.showMessageDialog(null, "注册失败", "error", JOptionPane.ERROR_MESSAGE);
            }
        });
        frame.add(register);

        frame.setVisible(true);
    }

    public static void setComp(JPanel panel) {

    }
}
