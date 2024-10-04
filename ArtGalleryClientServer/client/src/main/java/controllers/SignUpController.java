package controllers;

import connections.UserConnection;
import models.model.Users;
import models.model.enums.UserType;
import models.services.Subject;
import models.services.TranslationService;
import views.SignUpView;

import javax.swing.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.List;

public class SignUpController implements Observer{
    private SignUpView view;
    private UserConnection userConnection;
    private VisitorController visitorController;

    public SignUpController(){
        this.view = new SignUpView();
        this.userConnection = new UserConnection();
        this.addActionListeners();
    }

    public void addTies(VisitorController visitorController){
        this.visitorController = visitorController;
    }

    private void addActionListeners() {
        this.view.getCreateAccountBttn().addActionListener(e -> {addUser();});
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

    private boolean isValidInput() {
        String email = view.getEmailTxtField().getText();
        String password = view.getPassTxtField().getText();
        String phone = view.getPhoneTxtField().getText();
        String address = view.getAddressTxtField().getText();
        if(!email.isEmpty() && !password.isEmpty() && !phone.isEmpty() && !address.isEmpty()){
            return true;
        }else{
            showMessage("Please complete all necessary fields!");
            return false;
        }
    }

    private Users createUser(){
        String email = view.getEmailTxtField().getText();
        String password = view.getPassTxtField().getText();
        String phone = view.getPhoneTxtField().getText();
        String address = view.getAddressTxtField().getText();
        UserType userType = Enum.valueOf(UserType.class, view.getTypeComboBox().getSelectedItem().toString().toUpperCase());
        return new Users(email, password, phone, address, userType, false);
    }

    private void addUser(){
        if(isValidInput()){
            userConnection.addUser(createUser());
        }
    }

    private void showMessage(String message){
        JOptionPane.showMessageDialog(view.getFrame(), message);
    }

    private void dispose() {
        view.getFrame().setVisible(false);
    }

    private void translatePage(TranslationService translationService) {
        List<String> translations = translationService.getTranslation("sign_up");
        view.getTitleLabel().setText(translations.get(0));
        view.getEmailLabel().setText(translations.get(1));
        view.getPassLabel().setText(translations.get(2));
        view.getPhoneLabel().setText(translations.get(3));
        view.getAddressLabel().setText(translations.get(4));
        view.getRoleLabel().setText(translations.get(5));
        view.getCreateAccountBttn().setText(translations.get(6));
        view.getFrame().repaint();
    }

    @Override
    public void update(Subject subject) {
        TranslationService translationService = (TranslationService) subject;
        translatePage(translationService);
    }
}
