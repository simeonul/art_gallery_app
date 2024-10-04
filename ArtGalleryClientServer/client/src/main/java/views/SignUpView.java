package views;

import models.model.enums.UserType;

import javax.swing.*;
import java.awt.*;

public class SignUpView {
    private JFrame frame;
    private JTextField emailTxtField;
    private JTextField passTxtField;
    private JTextField phoneTxtField;
    private JTextField addressTxtField;
    private JComboBox typeComboBox;
    private JLabel titleLabel;
    private JLabel emailLabel;
    private JLabel passLabel;
    private JLabel phoneLabel;
    private JLabel addressLabel;
    private JLabel roleLabel;
    private JButton createAccountBttn;

    public SignUpView() {
        initialize();
    }

    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 70, 560, 545);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        titleLabel = new JLabel("Sign Up");
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        titleLabel.setFont(new Font("Times New Roman", Font.PLAIN, 30));
        titleLabel.setBounds(150, 70, 250, 35);
        frame.getContentPane().add(titleLabel);

        emailLabel = new JLabel("Email");
        emailLabel.setHorizontalAlignment(SwingConstants.LEFT);
        emailLabel.setFont(new Font("Times New Roman", Font.PLAIN, 25));
        emailLabel.setBounds(35, 165, 130, 25);
        frame.getContentPane().add(emailLabel);

        emailTxtField = new JTextField();
        emailTxtField.setFont(new Font("Times New Roman", Font.PLAIN, 21));
        emailTxtField.setColumns(10);
        emailTxtField.setBounds(215, 165, 260, 25);
        frame.getContentPane().add(emailTxtField);

        passLabel = new JLabel("Password");
        passLabel.setHorizontalAlignment(SwingConstants.LEFT);
        passLabel.setFont(new Font("Times New Roman", Font.PLAIN, 25));
        passLabel.setBounds(35, 215, 130, 25);
        frame.getContentPane().add(passLabel);

        passTxtField = new JTextField();
        passTxtField.setFont(new Font("Times New Roman", Font.PLAIN, 21));
        passTxtField.setColumns(10);
        passTxtField.setBounds(215, 215, 260, 25);
        frame.getContentPane().add(passTxtField);

        roleLabel = new JLabel("Sign Up As");
        roleLabel.setHorizontalAlignment(SwingConstants.LEFT);
        roleLabel.setFont(new Font("Times New Roman", Font.PLAIN, 25));
        roleLabel.setBounds(35, 365, 130, 25);
        frame.getContentPane().add(roleLabel);

        typeComboBox = new JComboBox();
        typeComboBox.setFont(new Font("Times New Roman", Font.PLAIN, 21));
        Object[] values = {UserType.EMPLOYEE, UserType.ADMINISTRATOR};
        typeComboBox.setModel(new DefaultComboBoxModel<>(values));
        typeComboBox.setBounds(215, 365, 260, 25);
        frame.getContentPane().add(typeComboBox);

        createAccountBttn = new JButton("Create Account");
        createAccountBttn.setFont(new Font("Times New Roman", Font.PLAIN, 25));
        createAccountBttn.setBounds(35, 440, 440, 30);
        frame.getContentPane().add(createAccountBttn);

        phoneLabel = new JLabel("Phone");
        phoneLabel.setHorizontalAlignment(SwingConstants.LEFT);
        phoneLabel.setFont(new Font("Times New Roman", Font.PLAIN, 25));
        phoneLabel.setBounds(35, 265, 130, 25);
        frame.getContentPane().add(phoneLabel);

        phoneTxtField = new JTextField();
        phoneTxtField.setFont(new Font("Times New Roman", Font.PLAIN, 21));
        phoneTxtField.setColumns(10);
        phoneTxtField.setBounds(215, 265, 260, 25);
        frame.getContentPane().add(phoneTxtField);

        addressLabel = new JLabel("Address");
        addressLabel.setHorizontalAlignment(SwingConstants.LEFT);
        addressLabel.setFont(new Font("Times New Roman", Font.PLAIN, 25));
        addressLabel.setBounds(35, 315, 130, 25);
        frame.getContentPane().add(addressLabel);

        addressTxtField = new JTextField();
        addressTxtField.setFont(new Font("Times New Roman", Font.PLAIN, 21));
        addressTxtField.setColumns(10);
        addressTxtField.setBounds(215, 315, 260, 25);
        frame.getContentPane().add(addressTxtField);
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

    public JTextField getPhoneTxtField() {
        return phoneTxtField;
    }

    public JTextField getAddressTxtField() {
        return addressTxtField;
    }

    public JComboBox getTypeComboBox() {
        return typeComboBox;
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

    public JLabel getPhoneLabel() {
        return phoneLabel;
    }

    public JLabel getAddressLabel() {
        return addressLabel;
    }

    public JLabel getRoleLabel() {
        return roleLabel;
    }

    public JButton getCreateAccountBttn() {
        return createAccountBttn;
    }
}

