package views;

import net.sds.mvvm.bindings.Bind;
import net.sds.mvvm.bindings.Binder;
import net.sds.mvvm.bindings.BindingException;
import view_models.LogInViewModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class LogInView{
    private static JFrame frame;

    @Bind(value = "text", target = "email.value")
    private JTextField emailTxtField;

    @Bind(value = "text", target = "password.value")
    private JTextField passTxtField;

    private JLabel titleLabel;
    private JLabel emailLabel;
    private JLabel passLabel;
    private JButton logInBttn;
    private LogInViewModel viewModel;

    public LogInView() {
        initialize();
    }

    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 500, 330);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.getContentPane().setLayout(null);

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
        logInBttn.setFont(new Font("Times New Roman", Font.PLAIN, 25));
        logInBttn.setBounds(30, 220, 420, 30);
        frame.getContentPane().add(logInBttn);
        frame.setVisible(true);

        viewModel = new LogInViewModel();

        try{
            Binder.bind(this, viewModel);
        } catch (BindingException e) {
            e.printStackTrace();
        }

        logInBttn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                viewModel.logInCommand.execute();
            }
        });

        frame.addWindowListener(new WindowListener() {
            @Override
            public void windowOpened(WindowEvent e) {

            }

            @Override
            public void windowClosing(WindowEvent e) {
                viewModel.initiateVisitorViewCommand.execute();
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

    public static void dispose() {
        frame.setVisible(false);
        frame.dispose();
    }


}
