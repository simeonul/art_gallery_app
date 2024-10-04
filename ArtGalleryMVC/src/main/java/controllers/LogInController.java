package controllers;

import models.model.Users;
import models.services.Subject;
import models.services.TranslationService;
import models.services.UserService;
import views.LogInView;

import javax.swing.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.List;
import java.util.Optional;

public class LogInController implements Observer{
    private LogInView view;
    private UserService userService;
    private VisitorController visitorController;
    private EmployeeController employeeController;
    private AdministratorController administratorController;

    public LogInController(){
        this.view = new LogInView();
        this.userService = new UserService();
        this.addActionListeners();
    }

    public void addTies(VisitorController visitorController, EmployeeController employeeController, AdministratorController administratorController){
        this.visitorController = visitorController;
        this.administratorController = administratorController;
        this.employeeController = employeeController;

    }

    private void translatePage(TranslationService translationService) {
        List<String> translations = translationService.getTranslation("log_in");
        view.getTitleLabel().setText(translations.get(0));
        view.getEmailLabel().setText(translations.get(1));
        view.getPassLabel().setText(translations.get(2));
        view.getLogInBttn().setText(translations.get(0));
        view.getFrame().repaint();
    }

    private void addActionListeners() {
        this.view.getLogInBttn().addActionListener(e -> {logIn();});
        this.view.getFrame().addWindowListener(new WindowListener() {
            @Override
            public void windowOpened(WindowEvent e) {

            }

            @Override
            public void windowClosing(WindowEvent e) {
                intiateVisitor();
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

    public void makeViewVisible(){
        this.view.getFrame().setVisible(true);
    }

    private void intiateVisitor() {
        visitorController.makeViewVisible();
        dispose();
    }

    private void initiateEmployee() {
        employeeController.makeViewVisible();
        dispose();
    }

    private void initiateAdministrator() {
        administratorController.makeViewVisible();
        dispose();
    }

    private void logIn() {
        String email = view.getEmailTxtField().getText();
        String password = view.getPassTxtField().getText();
        Optional<Users> user = userService.getUserByEmail(email);
        if (user.isPresent()) {
            Users account = user.get();
            if (account.getPassword().equals(password)) {
                if (account.isEnabled()) {
                    if (account.getUserType().toString().equals("EMPLOYEE")) {
                        initiateEmployee();
                    }
                    if (account.getUserType().toString().equals("ADMINISTRATOR")) {
                        initiateAdministrator();
                    }
                    dispose();
                } else {
                    showMessage("This account has not been enabled by an administrator!");
                }
            } else {
                showMessage("Wrong password!");
            }
        } else {
            showMessage("No user is registered with this email!");
        }
    }

    private void showMessage(String message){
        JOptionPane.showMessageDialog(view.getFrame(), message);
    }

    private void dispose() {
        view.getFrame().setVisible(false);
    }

    @Override
    public void update(Subject subject) {
        TranslationService translationService = (TranslationService) subject;
        translatePage(translationService);
    }
}
