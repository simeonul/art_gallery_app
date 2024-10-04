package controllers;

import models.model.ArtPieceArtist;
import models.services.ArtService;
import models.services.Subject;
import models.services.TranslationService;
import views.VisitorView;

import javax.swing.*;
import javax.swing.table.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.List;

public class VisitorController implements Observer{
    private VisitorView view;
    private ArtService artService;
    private TranslationService translationService;
    private SignUpController signUpController;
    private LogInController logInController;

    public VisitorController() {
        this.view = new VisitorView();
        this.artService = new ArtService();
        addActionListeners();
    }

/*    public VisitorController(TranslationService translationService) {
        this.view = new VisitorView();
        this.artService = new ArtService();
        this.translationService = translationService;
        initiateLanguageBox();
        addActionListeners();
        translatePage();
    }*/

    public void addTies(SignUpController signUpController, LogInController logInController){
        this.signUpController = signUpController;
        this.logInController = logInController;
    }

    private void initiateLanguageBox() {
        int selectedIndex = -1;
        switch (this.translationService.getLanguage()){
            case "english":
                selectedIndex = 0;
                break;
            case "spanish":
                selectedIndex = 1;
                break;
            case "french":
                selectedIndex = 2;
                break;
        }
        this.view.getLanguageComboBox().setSelectedIndex(selectedIndex);
    }

    private void addActionListeners(){
        this.view.getShowAllBttn().addActionListener(e -> {getAllArtPieceArtist();});
        this.view.getFilterBttn().addActionListener(e -> {filterArtPieceArtist();});
        this.view.getSearchBttn().addActionListener(e -> {searchArtPieceArtist();});
        this.view.getSortBttn().addActionListener(e -> {sortArtPieceArtist();});
        this.view.getSignUpBttn().addActionListener(e -> {initiateSignUp();});
        this.view.getLogInBttn().addActionListener(e -> {initiateLogIn();});
        this.view.getFrame().addWindowListener(new WindowListener() {
            @Override
            public void windowOpened(WindowEvent e) {
                populateArtPieceArtistTable();
                designTables(view.getTable());
            }

            @Override
            public void windowClosing(WindowEvent e) {

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
        this.view.getLanguageComboBox().addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                getTranslation();
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

    private void initiateSignUp() {
        signUpController.makeViewVisible();
        dispose();
    }

    private String capitalizeEnum(String input){
        return input.substring(0, 1).toUpperCase() + input.substring(1).toLowerCase();
    }

    private void getAllArtPieceArtist(){
        populateArtPieceArtistTable();
        designTables(view.getTable());
    }

    private void populateArtPieceArtistTable(){
        int num_columns = view.getTable().getModel().getColumnCount();
        Object[] column_identifiers = new Object[num_columns];
        for (int i = 0; i < num_columns; i++) {
            column_identifiers[i] = view.getTable().getModel().getColumnName(i);
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
        view.getTable().setModel(defaultTableModel);
    }

    private void populateArtPieceArtistTable(List<ArtPieceArtist> artPieceArtistList){
        int num_columns = view.getTable().getModel().getColumnCount();
        Object[] column_identifiers = new Object[num_columns];
        for (int i = 0; i < num_columns; i++) {
            column_identifiers[i] = view.getTable().getModel().getColumnName(i);
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
        view.getTable().setModel(defaultTableModel);
    }

    private void filterArtPieceArtist(){
        List<ArtPieceArtist> artPieceArtistList = artService.filterNotSoldArtPieceArtistByArtistForm(
                view.getArtistTxtField().getText(), view.getFormTxtField().getText());
        populateArtPieceArtistTable(artPieceArtistList);
        designTables(view.getTable());
    }

    private void searchArtPieceArtist(){
        List<ArtPieceArtist> artPieceArtistList = artService.searchNotSoldArtPieceArtistByTitle(view.getTitleTxtField().getText());
        populateArtPieceArtistTable(artPieceArtistList);
        designTables(view.getTable());
    }

    private void sortArtPieceArtist(){
        List<ArtPieceArtist> artPieceArtistList = artService.sortNotSoldArtPieceArtistByYear();
        populateArtPieceArtistTable(artPieceArtistList);
        designTables(view.getTable());
    }

    private void designTables(JTable table){
        DefaultTableCellRenderer cellRenderer = new DefaultTableCellRenderer();
        cellRenderer.setHorizontalAlignment(JLabel.CENTER);
        for(int i = 0; i < table.getColumnModel().getColumnCount(); i++){
            table.getColumnModel().getColumn(i).setCellRenderer(cellRenderer);
        }
        table.getColumnModel().getColumn(0).setPreferredWidth(10);
    }

    private void dispose() {
        view.getFrame().setVisible(false);
    }

    private void getTranslation() {
        String selectedLanguage = null;
        if (view.getLanguageComboBox().getSelectedItem().equals("English")) {
            selectedLanguage = "english";
        }
        if (view.getLanguageComboBox().getSelectedItem().equals("Espanol")) {
            selectedLanguage = "spanish";
        }
        if (view.getLanguageComboBox().getSelectedItem().equals("Francais")) {
            selectedLanguage = "french";
        }
        this.translationService.setLanguage(selectedLanguage);
        this.translationService.update();
    }

    private void translatePage(TranslationService translationService) {
        List<String> translations = translationService.getTranslation("visitor");
        view.getTitle().setText(translations.get(0));
        Object columns[] = new Object[6];
        columns[0] = translations.get(1);
        columns[1] = translations.get(2);
        columns[2] = translations.get(3);
        columns[3] = translations.get(4);
        columns[4] = translations.get(5);
        columns[5] = translations.get(6);
        ((DefaultTableModel)view.getTable().getModel()).setColumnIdentifiers(columns);
        view.getTitleLabel().setText(translations.get(2));
        view.getFormLabel().setText(translations.get(4));
        view.getArtistNameLabel().setText(translations.get(3));
        view.getSearchBttn().setText(translations.get(7));
        view.getFilterBttn().setText(translations.get(8));
        view.getSortBttn().setText(translations.get(9));
        view.getShowAllBttn().setText(translations.get(10));
        view.getFrame().repaint();
    }

    @Override
    public void update(Subject subject) {
        TranslationService translationService = (TranslationService) subject;
        translatePage(translationService);
    }

    public void setTranslationService(TranslationService translationService) {
        this.translationService = translationService;
    }
}
