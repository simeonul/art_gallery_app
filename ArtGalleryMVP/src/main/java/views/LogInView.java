package views;

import presenters.LogInPresenter;
import views.interfaces.LogInViewInterface;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class LogInView implements LogInViewInterface {
    private JFrame frame;
    private JLabel titleLabel;
    private JTextField emailTxtField;
    private JLabel emailLabel;
    private JTextField passTxtField;
    private JLabel passLabel;
    private JButton logInBttn;
    private LogInPresenter logInPresenter;

    public LogInView() {
        initialize();
    }

    private void initialize() {
        logInPresenter = new LogInPresenter(this);
        frame = new JFrame();
        frame.setBounds(100, 100, 500, 330);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.getContentPane().setLayout(null);
        frame.setVisible(true);

        titleLabel = new JLabel("Log In");
        titleLabel.setFont(new Font("Times New Roman", Font.PLAIN, 30));
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        titleLabel.setBounds(125, 25, 250, 35);
        frame.getContentPane().add(titleLabel);

        emailLabel = new JLabel("Email");
        emailLabel.setFont(new Font("Times New Roman", Font.PLAIN, 25));
        emailLabel.setHorizontalAlignment(SwingConstants.LEFT);
        emailLabel.setBounds(30, 100, 130, 25);
        frame.getContentPane().add(emailLabel);

        emailTxtField = new JTextField();
        emailTxtField.setFont(new Font("Times New Roman", Font.PLAIN, 21));
        emailTxtField.setBounds(180, 100, 260, 25);
        frame.getContentPane().add(emailTxtField);
        emailTxtField.setColumns(10);

        passLabel = new JLabel("Password");
        passLabel.setHorizontalAlignment(SwingConstants.LEFT);
        passLabel.setFont(new Font("Times New Roman", Font.PLAIN, 25));
        passLabel.setBounds(30, 150, 130, 25);
        frame.getContentPane().add(passLabel);

        passTxtField = new JTextField();
        passTxtField.setFont(new Font("Times New Roman", Font.PLAIN, 21));
        passTxtField.setColumns(10);
        passTxtField.setBounds(180, 150, 260, 25);
        frame.getContentPane().add(passTxtField);

        logInBttn = new JButton("Log In");
        logInBttn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                logInPresenter.logInUser();
            }
        });
        logInBttn.setFont(new Font("Times New Roman", Font.PLAIN, 25));
        logInBttn.setBounds(30, 220, 420, 30);
        frame.getContentPane().add(logInBttn);

        frame.addWindowListener(new WindowListener() {
            @Override
            public void windowOpened(WindowEvent e) {

            }

            @Override
            public void windowClosing(WindowEvent e) {
                logInPresenter.initiateVisitorPresenter();
            }

            @Override
            public void windowClosed(WindowEvent e) {

            }

            @Override
            public void windowIconified(WindowEvent e) {

            }

            @Override
            public void windowDeiconified(WindowEvent e) {

            }

            @Override
            public void windowActivated(WindowEvent e) {

            }

            @Override
            public void windowDeactivated(WindowEvent e) {

            }
        });
    }

    @Override
    public String getEmail() {
        return emailTxtField.getText();
    }

    @Override
    public String getPassword() {
        return passTxtField.getText();
    }

    @Override
    public void showError(String errorMessage) {
        JOptionPane.showMessageDialog(frame, errorMessage);
    }

    @Override
    public void dispose() {
        frame.setVisible(false);
        frame.dispose();
    }


}
