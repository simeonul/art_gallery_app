package controllers;

import models.model.ArtPieceArtist;
import models.model.Users;
import models.model.enums.UserType;
import models.services.ArtService;
import models.services.Subject;
import models.services.TranslationService;
import models.services.UserService;
import views.AdministratorView;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.List;

public class AdministratorController implements Observer{
    private AdministratorView view;
    private ArtService artService;
    private UserService userService;
    private LogInController logInController;

    public AdministratorController(){
        this.view = new AdministratorView();
        this.artService = new ArtService();
        this.userService = new UserService();
        this.addActionListeners();
    }

    public void addTies(LogInController logInController){
        this.logInController = logInController;
    }

    private void addActionListeners() {
        this.view.getAddUserBttn().addActionListener(e -> {addUser();});
        this.view.getUpdateUserBttn().addActionListener(e -> {updateUser();});
        this.view.getDeleteUserBttn().addActionListener(e -> {deleteUser();});
        this.view.getViewUserBttn().addActionListener(e -> {getAllUsers();});
        this.view.getShowAllBttn().addActionListener(e -> {getAllArtPieceArtist();});
        this.view.getFilterBttn().addActionListener(e -> {filterArtPieceArtist();});
        this.view.getSearchBttn().addActionListener(e -> {searchArtPieceArtist();});
        this.view.getSortBttn().addActionListener(e -> {sortArtPieceArtist();});
        this.view.getFrame().addWindowListener(new WindowListener() {
            @Override
            public void windowOpened(WindowEvent e) {
                populateArtPieceArtistTable();
                designTables(view.getArtPieceTable());

                populateUserTable();
                designTables(view.getUserTable());
            }

            @Override
            public void windowClosing(WindowEvent e) {
                initiateLogIn();
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

        this.view.getUserTable().addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                populateUserFields();
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
    }

    public void makeViewVisible(){
        this.view.getFrame().setVisible(true);
    }

    private void initiateLogIn() {
        logInController.makeViewVisible();
        dispose();
    }

    private String capitalizeEnum(String input){
        return input.substring(0, 1).toUpperCase() + input.substring(1).toLowerCase();
    }

    private void getAllUsers(){
        populateUserTable();
        designTables(view.getUserTable());
    }

    private void populateUserTable(){
        int num_columns = view.getUserTable().getModel().getColumnCount();
        Object[] column_identifiers = new Object[num_columns];
        for (int i = 0; i < num_columns; i++) {
            column_identifiers[i] = view.getUserTable().getModel().getColumnName(i);
        }
        int rowIndex = 0;
        List<Users> users = userService.getAllUsers();
        int noRows = users.size();
        Object [][] data = new Object[noRows][7];
        for (Users user: users)
        {
            data[rowIndex][0] = String.valueOf(user.getId());
            data[rowIndex][1] = user.getEmail();
            data[rowIndex][2] = user.getPassword();
            data[rowIndex][3] = user.getPhone();
            data[rowIndex][4] = user.getAddress();
            data[rowIndex][5] = capitalizeEnum(String.valueOf(user.getUserType()));
            data[rowIndex][6] = capitalizeEnum(String.valueOf(user.isEnabled()));

            rowIndex++;
        }
        DefaultTableModel defaultTableModel = new DefaultTableModel(data, column_identifiers);
        view.getUserTable().setModel(defaultTableModel);
    }

    private boolean isValidInput() {
        String email = view.getEmailTxtField().getText();
        String password = view.getPasswordTxtField().getText();
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
        String password = view.getPasswordTxtField().getText();
        String phone = view.getPhoneTxtField().getText();
        String address = view.getAddressTxtField().getText();
        UserType userType = Enum.valueOf(UserType.class, view.getTypeTxtField().getText().toUpperCase());
        Boolean isEnabled = Boolean.parseBoolean(view.getEnabledTxtField().getText());
        return new Users(email, password, phone, address, userType, isEnabled);
    }

    private void addUser(){
        if(isValidInput()){
            userService.addUser(createUser());
            populateUserTable();
            designTables(view.getUserTable());
        }
    }

    private void updateUser(){
        int selectedRowUser = view.getUserTable().getSelectedRow();
        if (selectedRowUser > -1) {
            int id = Integer.parseInt(String.valueOf(view.getUserTable().getModel().getValueAt(selectedRowUser, 0)));
            if (isValidInput()) {
                userService.updateUser(id, createUser());
                populateUserTable();
                designTables(view.getUserTable());
            }
        }
    }

    private void deleteUser(){
        int selectedRowUser = view.getUserTable().getSelectedRow();
        if (selectedRowUser > -1) {
            int id = Integer.parseInt(String.valueOf(view.getUserTable().getModel().getValueAt(selectedRowUser, 0)));
            userService.deleteUser(id);
            populateUserTable();
            designTables(view.getUserTable());
        }
    }

    private void getAllArtPieceArtist(){
        populateArtPieceArtistTable();
        designTables(view.getArtPieceTable());
    }

    private void populateArtPieceArtistTable(){
        int num_columns = view.getArtPieceTable().getModel().getColumnCount();
        Object[] column_identifiers = new Object[num_columns];
        for (int i = 0; i < num_columns; i++) {
            column_identifiers[i] = view.getArtPieceTable().getModel().getColumnName(i);
        }
        int rowIndex = 0;
        List<ArtPieceArtist> artPieceArtistList = artService.getNotSoldArtPieceArtist();
        int noRows = artPieceArtistList.size();
        Object [][] data = new Object[noRows][6];
        for (ArtPieceArtist artPieceArtist: artPieceArtistList)
        {
            data[rowIndex][0] = String.valueOf(artPieceArtist.getId());
            data[rowIndex][1] = artPieceArtist.getTitle();
            data[rowIndex][2] = artPieceArtist.getArtistName();
            data[rowIndex][3] = capitalizeEnum(artPieceArtist.getArtForm().toString());
            data[rowIndex][4] = String.valueOf(artPieceArtist.getYear());
            data[rowIndex][5] = String.valueOf(artPieceArtist.getPrice());

            rowIndex++;
        }
        DefaultTableModel defaultTableModel = new DefaultTableModel(data, column_identifiers);
        view.getArtPieceTable().setModel(defaultTableModel);
    }

    private void populateArtPieceArtistTable(List<ArtPieceArtist> artPieceArtistList){
        int num_columns = view.getArtPieceTable().getModel().getColumnCount();
        Object[] column_identifiers = new Object[num_columns];
        for (int i = 0; i < num_columns; i++) {
            column_identifiers[i] = view.getArtPieceTable().getModel().getColumnName(i);
        }
        int rowIndex = 0;
        int noRows = artPieceArtistList.size();
        Object [][] data = new Object[noRows][6];
        for (ArtPieceArtist artPieceArtist: artPieceArtistList)
        {
            data[rowIndex][0] = String.valueOf(artPieceArtist.getId());
            data[rowIndex][1] = artPieceArtist.getTitle();
            data[rowIndex][2] = artPieceArtist.getArtistName();
            data[rowIndex][3] = capitalizeEnum(artPieceArtist.getArtForm().toString());
            data[rowIndex][4] = String.valueOf(artPieceArtist.getYear());
            data[rowIndex][5] = String.valueOf(artPieceArtist.getPrice());

            rowIndex++;
        }
        DefaultTableModel defaultTableModel = new DefaultTableModel(data, column_identifiers);
        view.getArtPieceTable().setModel(defaultTableModel);
    }

    private void filterArtPieceArtist(){
        List<ArtPieceArtist> artPieceArtistList = artService.filterNotSoldArtPieceArtistByArtistForm(
                view.getArtistTxtField().getText(), view.getArtFormTxtField().getText());
        populateArtPieceArtistTable(artPieceArtistList);
        designTables(view.getArtPieceTable());
    }

    private void searchArtPieceArtist(){
        List<ArtPieceArtist> artPieceArtistList = artService.searchNotSoldArtPieceArtistByTitle(view.getTitleTxtField().getText());
        populateArtPieceArtistTable(artPieceArtistList);
        designTables(view.getArtPieceTable());
    }

    private void sortArtPieceArtist(){
        List<ArtPieceArtist> artPieceArtistList = artService.sortNotSoldArtPieceArtistByYear();
        populateArtPieceArtistTable(artPieceArtistList);
        designTables(view.getArtPieceTable());
    }

    private void populateUserFields() {
        int selectedRowUser =  view.getUserTable().getSelectedRow();
        view.getEmailTxtField().setText(view.getUserTable().getValueAt(selectedRowUser, 1).toString());
        view.getPasswordTxtField().setText(view.getUserTable().getValueAt(selectedRowUser, 2).toString());
        view.getPhoneTxtField().setText(view.getUserTable().getValueAt(selectedRowUser, 3).toString());
        view.getAddressTxtField().setText(view.getUserTable().getValueAt(selectedRowUser, 4).toString());
        view.getTypeTxtField().setText(view.getUserTable().getValueAt(selectedRowUser, 5).toString());
        view.getEnabledTxtField().setText(view.getUserTable().getValueAt(selectedRowUser, 6).toString());
    }

    private void designTables(JTable table){
        DefaultTableCellRenderer cellRenderer = new DefaultTableCellRenderer();
        cellRenderer.setHorizontalAlignment(JLabel.CENTER);
        for(int i = 0; i < table.getColumnModel().getColumnCount(); i++){
            table.getColumnModel().getColumn(i).setCellRenderer(cellRenderer);
        }
        table.getColumnModel().getColumn(0).setPreferredWidth(10);
    }

    private void showMessage(String message){
        JOptionPane.showMessageDialog(view.getFrame(), message);
    }

    private void dispose() {
        view.getFrame().setVisible(false);
    }

    private void translatePage(TranslationService translationService) {
        List<String> translations = translationService.getTranslation("administrator");
        view.getTitle().setText(translations.get(0));
        Object columnsArtPiece[] = new Object[6];
        columnsArtPiece[0] = translations.get(1);
        columnsArtPiece[1] = translations.get(2);
        columnsArtPiece[2] = translations.get(3);
        columnsArtPiece[3] = translations.get(4);
        columnsArtPiece[4] = translations.get(5);
        columnsArtPiece[5] = translations.get(6);
        ((DefaultTableModel)view.getArtPieceTable().getModel()).setColumnIdentifiers(columnsArtPiece);
        view.getTitleLabel().setText(translations.get(2));
        view.getArtistNameLabel().setText(translations.get(3));
        view.getArtFormLabel().setText(translations.get(4));
        view.getSearchBttn().setText(translations.get(7));
        view.getShowAllBttn().setText(translations.get(8));
        view.getSortBttn().setText(translations.get(9));
        view.getFilterBttn().setText(translations.get(10));
        Object columnsUser[] = new Object[7];
        columnsUser[0] = translations.get(1);
        columnsUser[1] = translations.get(11);
        columnsUser[2] = translations.get(12);
        columnsUser[3] = translations.get(13);
        columnsUser[4] = translations.get(14);
        columnsUser[5] = translations.get(15);
        columnsUser[6] = translations.get(16);
        ((DefaultTableModel)view.getUserTable().getModel()).setColumnIdentifiers(columnsUser);
        view.getEmailLabel().setText(translations.get(11));
        view.getPasswordLabel().setText(translations.get(12));
        view.getPhoneLabel().setText(translations.get(13));
        view.getAddressLabel().setText(translations.get(14));
        view.getTypeLabel().setText(translations.get(17));
        view.getEnabledLabel().setText(translations.get(18));
        view.getViewUserBttn().setText(translations.get(19));
        view.getAddUserBttn().setText(translations.get(20));
        view.getUpdateUserBttn().setText(translations.get(21));
        view.getDeleteUserBttn().setText(translations.get(22));
        view.getFrame().repaint();
    }

    @Override
    public void update(Subject subject) {
        TranslationService translationService = (TranslationService) subject;
        translatePage(translationService);
    }
}
