package views;

import models.model.enums.UserType;
import net.sds.mvvm.bindings.Bind;
import net.sds.mvvm.bindings.Binder;
import net.sds.mvvm.bindings.BindingException;
import view_models.SignUpViewModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class SignUpView {
    private static JFrame frame;

    @Bind(value = "text", target = "email.value")
    private JTextField emailTxtField;

    @Bind(value = "text", target = "password.value")
    private JTextField passTxtField;

    @Bind(value = "text", target = "phone.value")
    private JTextField phoneTxtField;

    @Bind(value = "text", target = "address.value")
    private JTextField addressTxtField;

    @Bind(value = "selectedItem", target = "type.value")
    private JComboBox typeComboBox;

    private JLabel titleLabel;
    private JLabel emailLabel;
    private JLabel passLabel;
    private JLabel phoneLabel;
    private JLabel addressLabel;
    private JLabel roleLabel;
    private JButton createAccountBttn;
    private SignUpViewModel signUpViewModel;

    public SignUpView() {
        initialize();
    }

    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 500, 500);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.getContentPane().setLayout(null);

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

        frame.setVisible(true);

        signUpViewModel = new SignUpViewModel();

        try{
            Binder.bind(this, signUpViewModel);
        } catch (BindingException e) {
            e.printStackTrace();
        }

        createAccountBttn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                signUpViewModel.signUpCommand.execute();
            }
        });

        frame.addWindowListener(new WindowListener() {
            @Override
            public void windowOpened(WindowEvent e) {

            }

            @Override
            public void windowClosing(WindowEvent e) {
                signUpViewModel.initiateVisitorViewCommand.execute();
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


    public static void showMessage(String errorMessage) {
        JOptionPane.showMessageDialog(frame, errorMessage);
    }

    public static void dispose(){
        frame.setVisible(false);
        frame.dispose();
    }

}

