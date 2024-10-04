package views;

import javax.swing.*;
import java.awt.*;

public class LogInView {
    private JFrame frame;
    private JTextField emailTxtField;
    private JTextField passTxtField;
    private JLabel titleLabel;
    private JLabel emailLabel;
    private JLabel passLabel;
    private JButton logInBttn;

    public LogInView() {
        initialize();
    }

    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 600, 360);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        titleLabel = new JLabel("Log In");
        titleLabel.setFont(new Font("Times New Roman", Font.PLAIN, 30));
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        titleLabel.setBounds(160, 60, 250, 35);
        frame.getContentPane().add(titleLabel);

        emailLabel = new JLabel("Email");
        emailLabel.setFont(new Font("Times New Roman", Font.PLAIN, 25));
        emailLabel.setHorizontalAlignment(SwingConstants.LEFT);
        emailLabel.setBounds(20, 130, 200, 25);
        frame.getContentPane().add(emailLabel);

        emailTxtField = new JTextField();
        emailTxtField.setFont(new Font("Times New Roman", Font.PLAIN, 21));
        emailTxtField.setBounds(285, 130, 260, 25);
        frame.getContentPane().add(emailTxtField);
        emailTxtField.setColumns(10);

        passLabel = new JLabel("Password");
        passLabel.setHorizontalAlignment(SwingConstants.LEFT);
        passLabel.setFont(new Font("Times New Roman", Font.PLAIN, 25));
        passLabel.setBounds(20, 190, 200, 25);
        frame.getContentPane().add(passLabel);

        passTxtField = new JTextField();
        passTxtField.setFont(new Font("Times New Roman", Font.PLAIN, 21));
        passTxtField.setColumns(10);
        passTxtField.setBounds(285, 190, 260, 25);
        frame.getContentPane().add(passTxtField);

        logInBttn = new JButton("Log In");
        logInBttn.setFont(new Font("Times New Roman", Font.PLAIN, 25));
        logInBttn.setBounds(75, 250, 420, 30);
        frame.getContentPane().add(logInBttn);

    }

    public JFrame getFrame() {
        return frame;
    }

    public JTextField getEmailTxtField() {
        return emailTxtField;
    }

    public JTextField getPassTxtField() {
        return passTxtField;
    }

    public JLabel getTitleLabel() {
        return titleLabel;
    }

    public JLabel getEmailLabel() {
        return emailLabel;
    }

    public JLabel getPassLabel() {
        return passLabel;
    }

    public JButton getLogInBttn() {
        return logInBttn;
    }
}
