package myPackage.UI;

import myPackage.BLL.Util;
import myPackage.BLL.businessProcess;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;


public class test {


    public test() {
        //加载图片
        ImageIcon icon = new ImageIcon("src/myPackage/Sources/封面.png");
        //将图片放入label中
        JLabel label = new JLabel(icon);

        //设置label的大小
        label.setBounds(0, 0, icon.getIconWidth(), icon.getIconHeight());

        JFrame frame = new JFrame();

        //获取窗口的第二层，将label放入
        frame.getLayeredPane().add(label, new Integer(Integer.MIN_VALUE));

        //获取frame的顶层容器,并设置为透明
        JPanel j = (JPanel) frame.getContentPane();
        j.setOpaque(false);

        JPanel panel = new JPanel();
        setComp(panel);

        //必须设置为透明的。否则看不到图片
        panel.setOpaque(false);

        frame.add(panel);
        frame.setSize(icon.getIconWidth(), icon.getIconHeight());
        frame.setVisible(true);

    }

    public static void setComp(JPanel panel){
        JLabel userLabel = new JLabel("用户名:");
        userLabel.setBounds(200, 300, 80, 25);
        panel.add(userLabel);

        JTextField userText = new JTextField(20);
        userText.setBounds(280, 300, 165, 25);
        panel.add(userText);

        JLabel passwordLabel = new JLabel("密码:");
        passwordLabel.setBounds(200, 330, 80, 25);
        panel.add(passwordLabel);

        JPasswordField passwordText = new JPasswordField(20);
        passwordText.setBounds(280, 330, 165, 25);
        panel.add(passwordText);

        JButton loginButton = new JButton("登录");
        loginButton.setBounds(200, 380, 80, 25);
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (Util.checkAccount(userText.getText(), passwordText.getText())) {
                    funcUI.funcFrame();
                    panel.setVisible(false);
                } else {
                    JOptionPane.showMessageDialog(null, "账号或密码错误", "error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        panel.add(loginButton);

        JButton register = new JButton("注册");
        register.setBounds(365, 380, 80, 25);
        register.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(businessProcess.addUser(userText.getText(),passwordText.getText(),"无"))
                    JOptionPane.showMessageDialog(null, "注册成功", "tips", JOptionPane.INFORMATION_MESSAGE);
                else
                    JOptionPane.showMessageDialog(null, "注册失败", "error", JOptionPane.ERROR_MESSAGE);
            }
        });
        panel.add(register);

        panel.setVisible(true);
    }

    public static void main(String[] args) {
        new test();
    }
}