package views;

import model.models.enums.UserType;
import presenters.SignUpPresenter;
import views.interfaces.SignUpViewInterface;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;
import java.util.Arrays;

public class SignUpView implements SignUpViewInterface {
    private JFrame frame;
    private JTextField emailTxtField;
    private JTextField passTxtField;
    private JTextField phoneTxtField;
    private JTextField addressTxtField;
    private JLabel titleLabel;
    private JLabel emailLabel;
    private JLabel passLabel;
    private JLabel phoneLabel;
    private JLabel addressLabel;
    private JLabel roleLabel;
    private JComboBox typeComboBox;
    private JButton createAccountBttn;
    private SignUpPresenter signUpPresenter;

    public SignUpView() {
        initialize();
    }

    private void initialize() {
        signUpPresenter = new SignUpPresenter(this);
        frame = new JFrame();
        frame.setBounds(100, 100, 500, 500);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.getContentPane().setLayout(null);
        frame.setVisible(true);

        titleLabel = new JLabel("Sign Up");
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        titleLabel.setFont(new Font("Times New Roman", Font.PLAIN, 30));
        titleLabel.setBounds(130, 20, 250, 35);
        frame.getContentPane().add(titleLabel);

        emailLabel = new JLabel("Email");
        emailLabel.setHorizontalAlignment(SwingConstants.LEFT);
        emailLabel.setFont(new Font("Times New Roman", Font.PLAIN, 25));
        emailLabel.setBounds(35, 95, 130, 25);
        frame.getContentPane().add(emailLabel);

        emailTxtField = new JTextField();
        emailTxtField.setFont(new Font("Times New Roman", Font.PLAIN, 21));
        emailTxtField.setColumns(10);
        emailTxtField.setBounds(185, 95, 260, 25);
        frame.getContentPane().add(emailTxtField);

        passLabel = new JLabel("Password");
        passLabel.setHorizontalAlignment(SwingConstants.LEFT);
        passLabel.setFont(new Font("Times New Roman", Font.PLAIN, 25));
        passLabel.setBounds(35, 145, 130, 25);
        frame.getContentPane().add(passLabel);

        passTxtField = new JTextField();
        passTxtField.setFont(new Font("Times New Roman", Font.PLAIN, 21));
        passTxtField.setColumns(10);
        passTxtField.setBounds(185, 145, 260, 25);
        frame.getContentPane().add(passTxtField);

        roleLabel = new JLabel("Sign Up As");
        roleLabel.setHorizontalAlignment(SwingConstants.LEFT);
        roleLabel.setFont(new Font("Times New Roman", Font.PLAIN, 25));
        roleLabel.setBounds(35, 295, 130, 25);
        frame.getContentPane().add(roleLabel);

        typeComboBox = new JComboBox();
        typeComboBox.setFont(new Font("Times New Roman", Font.PLAIN, 21));
        Object[] values = {UserType.EMPLOYEE, UserType.ADMINISTRATOR};
        typeComboBox.setModel(new DefaultComboBoxModel<>(values));
        typeComboBox.setBounds(185, 295, 260, 25);
        frame.getContentPane().add(typeComboBox);

        createAccountBttn = new JButton("Create Account");
        createAccountBttn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                signUpPresenter.addUser();
            }
        });
        createAccountBttn.setFont(new Font("Times New Roman", Font.PLAIN, 25));
        createAccountBttn.setBounds(35, 400, 420, 30);
        frame.getContentPane().add(createAccountBttn);

        phoneLabel = new JLabel("Phone");
        phoneLabel.setHorizontalAlignment(SwingConstants.LEFT);
        phoneLabel.setFont(new Font("Times New Roman", Font.PLAIN, 25));
        phoneLabel.setBounds(35, 195, 130, 25);
        frame.getContentPane().add(phoneLabel);

        phoneTxtField = new JTextField();
        phoneTxtField.setFont(new Font("Times New Roman", Font.PLAIN, 21));
        phoneTxtField.setColumns(10);
        phoneTxtField.setBounds(185, 195, 260, 25);
        frame.getContentPane().add(phoneTxtField);

        addressLabel = new JLabel("Address");
        addressLabel.setHorizontalAlignment(SwingConstants.LEFT);
        addressLabel.setFont(new Font("Times New Roman", Font.PLAIN, 25));
        addressLabel.setBounds(35, 245, 130, 25);
        frame.getContentPane().add(addressLabel);

        addressTxtField = new JTextField();
        addressTxtField.setFont(new Font("Times New Roman", Font.PLAIN, 21));
        addressTxtField.setColumns(10);
        addressTxtField.setBounds(185, 245, 260, 25);
        frame.getContentPane().add(addressTxtField);

        frame.addWindowListener(new WindowListener() {
            @Override
            public void windowOpened(WindowEvent e) {

            }

            @Override
            public void windowClosing(WindowEvent e) {
                signUpPresenter.initiateVisitorPresenter();
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
    public String getPhone() {
        return phoneTxtField.getText();
    }

    @Override
    public String getAddress() {
        return addressTxtField.getText();
    }

    @Override
    public String getType() {
        return typeComboBox.getSelectedItem().toString();
    }


    @Override
    public void showError(String errorMessage) {
            JOptionPane.showMessageDialog(frame, errorMessage);
    }

}