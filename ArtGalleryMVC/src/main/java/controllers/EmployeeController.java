package controllers;

import models.model.ArtPiece;
import models.model.ArtPieceArtist;
import models.model.Artist;
import models.model.enums.ArtForm;
import models.services.*;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.labels.PieSectionLabelGenerator;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.RingPlot;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import views.EmployeeView;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.text.DecimalFormat;
import java.util.*;
import java.util.List;

public class EmployeeController implements  Observer{
    private EmployeeView view;
    private ArtService artService;
    private UserService userService;
    private ExportService exportService;
    private LogInController logInController;
    private int selectedColumn = 0;
    private int selectedStructure = 0;
    private Object[] columnsArtist = new Object[4];

    public EmployeeController() {
        this.view = new EmployeeView();
        this.artService = new ArtService();
        this.userService = new UserService();
        this.exportService = new ExportService();
        this.addActionListeners();
    }

    public void addTies(LogInController logInController){
        this.logInController = logInController;
    }

    private void addActionListeners() {
        this.view.getInsertArtistBttn().addActionListener(e -> {addArtist();});
        this.view.getUpdateArtistBttn().addActionListener(e -> {updateArtist();});
        this.view.getDeleteArtistBttn().addActionListener(e -> {deleteArtist();});
        this.view.getInsertArtPieceBttn().addActionListener(e -> {addArtPieceArtist();});
        this.view.getUpdateArtPieceBttn().addActionListener(e -> {updateArtPieceArtist();});
        this.view.getDeleteArtPieceBttn().addActionListener(e -> {deleteArtPieceArtist();});
        this.view.getFilterBttn().addActionListener(e -> {filterArtPieceArtist();});
        this.view.getSearchBttn().addActionListener(e -> {searchArtPieceArtist();});
        this.view.getSortBttn().addActionListener(e -> {sortArtPieceArtist();});
        this.view.getSellArtPieceBttn().addActionListener(e -> {sellArtPieceArtist();});
        this.view.getCsvBttn().addActionListener(e -> {exportCsv();});
        this.view.getXmlBttn().addActionListener(e -> {exportXml();});
        this.view.getJsonBttn().addActionListener(e -> {exportJson();});
        this.view.getTxtBttn().addActionListener(e -> {exportTxt();});
        this.view.getColumnsComboBox().addItemListener(e -> {getChartElements();});
        this.view.getStructureComboBox().addItemListener(e -> {getChartElements();});
        this.view.getBtnGenerate().addActionListener(e -> {showChart();});
        this.view.getFrame().addWindowListener(new WindowListener() {
            @Override
            public void windowOpened(WindowEvent e) {
                populateArtPieceArtistTable();
                designTables(view.getArtPieceTable());

                populateArtistTable();
                designTables(view.getArtistTable());
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

        this.view.getArtistTable().addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                populateArtistFields();
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

        this.view.getArtPieceTable().addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                populateArtPieceArtistFields();
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

    private void showChart() {
        JFrame chartFrame = new JFrame();
        chartFrame.setBounds(10, 10, 600, 600);
        chartFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        chartFrame.getContentPane().setLayout(null);
        chartFrame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        JFreeChart chart = createChart();
        ChartPanel cp = new ChartPanel(chart);
        cp.setBounds(0, 0, 580, 550);
        cp.setMouseWheelEnabled(true);
        chartFrame.getContentPane().add(cp);
        chartFrame.setVisible(true);
    }

    private JFreeChart createChart() {
        HashMap<String, Integer> input = processParameters();
        JFreeChart chart = null;
        String title = "Art Pieces grouped by ";

        switch (selectedColumn){
            case 0:
                title += "Artist Name";
                break;
            case 1:
                title += "Art Form";
                break;
        }

        switch (selectedStructure){
            case 0:
                chart = createPieChart(input, title);
                break;
            case 1:
                chart = createBarChart(input, title);
                break;
            case 2:
                chart = createRingChart(input, title);
                break;
        }
        return chart;
    }

    private JFreeChart createRingChart(HashMap<String, Integer> input, String title) {
        DefaultPieDataset dataset = new DefaultPieDataset();
        for(Map.Entry<String, Integer> entry : input.entrySet()){
            dataset.setValue(entry.getKey(), entry.getValue());
        }
        JFreeChart chart = ChartFactory.createRingChart(title, dataset, true, true, false);

        PieSectionLabelGenerator labelGenerator = new StandardPieSectionLabelGenerator(
                "{0} : {1} ({2})", new DecimalFormat("0"), new DecimalFormat("0%"));
        ((RingPlot)chart.getPlot()).setLabelGenerator(labelGenerator);
        return chart;
    }

    private JFreeChart createBarChart(HashMap<String, Integer> input, String title) {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        for(Map.Entry<String, Integer> entry : input.entrySet()){
            dataset.addValue(entry.getValue(), entry.getKey(), "");
        }
        JFreeChart chart = ChartFactory.createBarChart(title, "", "Number of Art Pieces",
                dataset, PlotOrientation.VERTICAL, true, true, false);
        return chart;
    }

    private JFreeChart createPieChart(HashMap<String, Integer> input, String title) {
        DefaultPieDataset dataset = new DefaultPieDataset();
        for(Map.Entry<String, Integer> entry : input.entrySet()){
            dataset.setValue(entry.getKey(), entry.getValue());
        }
        JFreeChart chart = ChartFactory.createPieChart(title, dataset, true, true, false);
        PieSectionLabelGenerator labelGenerator = new StandardPieSectionLabelGenerator(
                "{0} : {1} ({2})", new DecimalFormat("0"), new DecimalFormat("0%"));
        ((PiePlot)chart.getPlot()).setLabelGenerator(labelGenerator);
        return chart;
    }


    private HashMap<String, Integer> processParameters() {
        List<ArtPieceArtist> artPieceArtistList = artService.getAllArtPieceArtist();
        HashMap<String, Integer> input = new HashMap<>();
        if(selectedColumn == 0){
            for(ArtPieceArtist artPieceArtist : artPieceArtistList){
                if(input.containsKey(artPieceArtist.getArtistName())){
                    input.put(artPieceArtist.getArtistName(), input.get(artPieceArtist.getArtistName()) + 1);
                }else{
                    input.put(artPieceArtist.getArtistName(), 1);
                }
            }
        }
        if(selectedColumn == 1){
            for(ArtPieceArtist artPieceArtist : artPieceArtistList){
                String key = capitalizeEnum(artPieceArtist.getArtForm().toString());
                if(input.containsKey(key)){
                    input.put(key, input.get(key) + 1);
                }else{
                    input.put(key, 1);
                }
            }
        }
        return input;
    }


    private void initiateLogIn() {
        logInController.makeViewVisible();
        dispose();
    }

    private String capitalizeEnum(String input){
        return input.substring(0, 1).toUpperCase() + input.substring(1).toLowerCase();
    }

    private void getChartElements() {
        selectedColumn = this.view.getColumnsComboBox().getSelectedIndex();
        selectedStructure = this.view.getStructureComboBox().getSelectedIndex();
    }

    private void populateArtPieceArtistTable(){
        int num_columns = view.getArtPieceTable().getModel().getColumnCount();
        Object[] column_identifiers = new Object[num_columns];
        for (int i = 0; i < num_columns; i++) {
            column_identifiers[i] = view.getArtPieceTable().getModel().getColumnName(i);
        }
        int rowIndex = 0;
        List<ArtPieceArtist> artPieceArtistList = artService.getAllArtPieceArtist();
        int noRows = artPieceArtistList.size();
        Object [][] data = new Object[noRows][7];
        for (ArtPieceArtist artPieceArtist: artPieceArtistList)
        {
            data[rowIndex][0] = String.valueOf(artPieceArtist.getId());
            data[rowIndex][1] = artPieceArtist.getTitle();
            data[rowIndex][2] = artPieceArtist.getArtistName();
            data[rowIndex][3] = capitalizeEnum(artPieceArtist.getArtForm().toString());
            data[rowIndex][4] = String.valueOf(artPieceArtist.getYear());
            data[rowIndex][5] = String.valueOf(artPieceArtist.getPrice());
            data[rowIndex][6] = String.valueOf(artPieceArtist.isSold());

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
        Object [][] data = new Object[noRows][7];
        for (ArtPieceArtist artPieceArtist: artPieceArtistList)
        {
            data[rowIndex][0] = String.valueOf(artPieceArtist.getId());
            data[rowIndex][1] = artPieceArtist.getTitle();
            data[rowIndex][2] = artPieceArtist.getArtistName();
            data[rowIndex][3] = capitalizeEnum(artPieceArtist.getArtForm().toString());
            data[rowIndex][4] = String.valueOf(artPieceArtist.getYear());
            data[rowIndex][5] = String.valueOf(artPieceArtist.getPrice());
            data[rowIndex][6] = String.valueOf(artPieceArtist.isSold());

            rowIndex++;
        }
        DefaultTableModel defaultTableModel = new DefaultTableModel(data, column_identifiers);
        view.getArtPieceTable().setModel(defaultTableModel);
    }

    private void populateArtistTable(){
        int num_columns = view.getArtistTable().getModel().getColumnCount();
        Object[] column_identifiers = new Object[num_columns];
        for (int i = 0; i < num_columns; i++) {
            column_identifiers[i] = view.getArtistTable().getModel().getColumnName(i);
        }
        int rowIndex = 0;
        List<Artist> artists = artService.getAllArtists();
        int noRows = artists.size();
        Object [][] data = new Object[noRows][4];
        for (Artist artist: artists)
        {
            data[rowIndex][0] = String.valueOf(artist.getId());
            data[rowIndex][1] = artist.getName();
            data[rowIndex][2] = artist.getBirthYear();
            data[rowIndex][3] = artist.getNationality();

            rowIndex++;
        }
        DefaultTableModel defaultTableModel = new DefaultTableModel(data, column_identifiers);
        view.getArtistTable().setModel(defaultTableModel);
    }

    private boolean isValidInputArtist() {
        String name = view.getArtistTxtField().getText();
        String birthYear = view.getBirthTxtField().getText();
        String nationality = view.getNationalityTxtField().getText();
        if (!name.isEmpty() && !birthYear.isEmpty() && !nationality.isEmpty()) {
            return true;
        } else {
            showMessage("Please complete all necessary fields!");
            return false;
        }
    }

    private Artist createArtist() {
        String name = view.getArtistTxtField().getText();
        int birthYear = Integer.parseInt(view.getBirthTxtField().getText());
        String nationality = view.getNationalityTxtField().getText();
        return new Artist(name, birthYear, nationality);
    }

    private void addArtist(){
        if (isValidInputArtist()) {
            artService.addArtist(createArtist());
            populateArtistTable();
            designTables(view.getArtistTable());
        }
    }

    private void updateArtist(){
        int selectedRowArtist = view.getArtistTable().getSelectedRow();
        if(selectedRowArtist > -1){
            int id = Integer.parseInt(String.valueOf(view.getArtistTable().getModel().getValueAt(selectedRowArtist, 0)));
            if(isValidInputArtist()){
                artService.updateArtist(id, createArtist());
                populateArtistTable();
                designTables(view.getArtistTable());

                populateArtPieceArtistTable();
                designTables(view.getArtPieceTable());
            }
        }
    }

    private void deleteArtist(){
        int selectedRowArtist = view.getArtistTable().getSelectedRow();
        if(selectedRowArtist > -1){
            int id = Integer.parseInt(String.valueOf(view.getArtistTable().getModel().getValueAt(selectedRowArtist, 0)));
            artService.deleteArtist(id);
            populateArtistTable();
            designTables(view.getArtistTable());

            populateArtPieceArtistTable();
            designTables(view.getArtPieceTable());
        }
    }

    private boolean isValidInputArtPiece() {
        String title = view.getTitleTxtField().getText();
        String artistId = view.getArtistIdTxtField().getText();
        String artForm = view.getArtFormTxtField().getText();
        String year = view.getYearTxtField().getText();
        String price = view.getPriceTxtField().getText();
        if (!title.isEmpty() && !artistId.isEmpty() && !artForm.isEmpty() && !year.isEmpty() && !price.isEmpty()) {
            return true;
        } else {
            showMessage("Please complete all necessary fields!");
            return false;
        }
    }

    private ArtPiece createArtPiece() {
        String title = view.getTitleTxtField().getText();
        int artistId = Integer.parseInt(view.getArtistIdTxtField().getText());
        ArtForm artForm = Enum.valueOf(ArtForm.class, view.getArtFormTxtField().getText().toUpperCase(Locale.ROOT));
        int year = Integer.parseInt(view.getYearTxtField().getText());
        float price = Float.parseFloat(view.getPriceTxtField().getText());
        return new ArtPiece(title, artistId, artForm, year, price, false);
    }

    private void addArtPieceArtist(){
        if (isValidInputArtPiece()) {
            artService.addArtPiece(createArtPiece());
            populateArtPieceArtistTable();
            designTables(view.getArtPieceTable());
        }
    }

    private void updateArtPieceArtist(){
        int selectedRowArtPiece = view.getArtPieceTable().getSelectedRow();
        if(selectedRowArtPiece > -1){
            int id = Integer.parseInt(String.valueOf(view.getArtPieceTable().getModel().getValueAt(selectedRowArtPiece, 0)));
            boolean isSold = Boolean.parseBoolean(String.valueOf(view.getArtPieceTable().getModel().getValueAt(selectedRowArtPiece, 6)));
            if(!isSold){
                if(isValidInputArtPiece()){
                    artService.updateArtPiece(id, createArtPiece());
                    populateArtPieceArtistTable();
                    designTables(view.getArtPieceTable());
                }
            }else{
                showMessage("Cannot edit a sold Art Piece!");
            }
        }
    }

    private void deleteArtPieceArtist(){
        int selectedRowArtPiece = view.getArtPieceTable().getSelectedRow();
        if (selectedRowArtPiece > -1) {
            int id = Integer.parseInt(String.valueOf(view.getArtPieceTable().getModel().getValueAt(selectedRowArtPiece, 0)));
            artService.deleteArtPiece(id);
            populateArtPieceArtistTable();
            designTables(view.getArtPieceTable());
        }
    }

    private void sellArtPieceArtist(){
        int selectedRowArtPiece = view.getArtPieceTable().getSelectedRow();
        if (selectedRowArtPiece > -1) {
            int id = Integer.parseInt(String.valueOf(view.getArtPieceTable().getModel().getValueAt(selectedRowArtPiece, 0)));
            artService.sellArtPiece(id);
            populateArtPieceArtistTable();
            designTables(view.getArtPieceTable());
        }
    }

    private void filterArtPieceArtist(){
        List<ArtPieceArtist> artPieceArtistList = artService.filterArtPieceArtistByArtistForm(
                view.getArtistTxtField().getText(), view.getArtFormTxtField().getText());
        populateArtPieceArtistTable(artPieceArtistList);
        designTables(view.getArtPieceTable());
    }

    private void searchArtPieceArtist(){
        List<ArtPieceArtist> artPieceArtistList = artService.searchArtPieceArtistByTitle(view.getTitleTxtField().getText());
        populateArtPieceArtistTable(artPieceArtistList);
        designTables(view.getArtPieceTable());
    }

    private void sortArtPieceArtist(){
        List<ArtPieceArtist> artPieceArtistList = artService.sortArtPieceArtistByYear();
        populateArtPieceArtistTable(artPieceArtistList);
        designTables(view.getArtPieceTable());
    }

    private void exportCsv(){
        exportService.writeToCsv();
    }

    private void exportJson(){
        exportService.writeToJson();
    }

    private void exportXml(){
        exportService.writeToXml();
    }

    private void exportTxt(){
        exportService.writeToTxt();
    }

    private void populateArtistFields(){
        int selectedRowArtist =  view.getArtistTable().getSelectedRow();
        view.getArtistTxtField().setText(view.getArtistTable().getValueAt(selectedRowArtist, 1).toString());
        view.getBirthTxtField().setText(view.getArtistTable().getValueAt(selectedRowArtist, 2).toString());
        view.getNationalityTxtField().setText(view.getArtistTable().getValueAt(selectedRowArtist, 3).toString());
    }

    private void populateArtPieceArtistFields(){
        int selectedRowArtPieceArtist =  view.getArtPieceTable().getSelectedRow();
        view.getTitleTxtField().setText(view.getArtPieceTable().getValueAt(selectedRowArtPieceArtist, 1).toString());
        view.getArtFormTxtField().setText(view.getArtPieceTable().getValueAt(selectedRowArtPieceArtist, 3).toString());
        view.getYearTxtField().setText(view.getArtPieceTable().getValueAt(selectedRowArtPieceArtist, 4).toString());
        view.getPriceTxtField().setText(view.getArtPieceTable().getValueAt(selectedRowArtPieceArtist, 5).toString());
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
        List<String> translations = translationService.getTranslation("employee");
        view.getTitle().setText(translations.get(0));
        Object columnsArtist[] = new Object[4];
        columnsArtist[0] = translations.get(1);
        columnsArtist[1] = translations.get(2);
        columnsArtist[2] = translations.get(3);
        columnsArtist[3] = translations.get(4);
        ((DefaultTableModel)view.getArtistTable().getModel()).setColumnIdentifiers(columnsArtist);
        view.getArtistNameLabel().setText(translations.get(6));
        view.getBirthYearLabel().setText(translations.get(3));
        view.getNationalityLabel().setText(translations.get(4));
        view.getInsertArtistBttn().setText(translations.get(11));
        view.getUpdateArtistBttn().setText(translations.get(12));
        view.getDeleteArtistBttn().setText(translations.get(13));
        Object columnsArtPiece[] = new Object[7];
        columnsArtPiece[0] = translations.get(1);
        columnsArtPiece[1] = translations.get(5);
        columnsArtPiece[2] = translations.get(6);
        columnsArtPiece[3] = translations.get(7);
        columnsArtPiece[4] = translations.get(8);
        columnsArtPiece[5] = translations.get(9);
        columnsArtPiece[6] = translations.get(10);
        ((DefaultTableModel)view.getArtPieceTable().getModel()).setColumnIdentifiers(columnsArtPiece);
        view.getTitleLabel().setText(translations.get(5));
        view.getArtistIdLabel().setText(translations.get(24));
        view.getArtFormLabel().setText(translations.get(7));
        view.getYearLabel().setText(translations.get(8));
        view.getPriceLabel().setText(translations.get(9));
        view.getSearchBttn().setText(translations.get(14));
        view.getSortBttn().setText(translations.get(16));
        view.getFilterBttn().setText(translations.get(15));
        view.getInsertArtPieceBttn().setText(translations.get(17));
        view.getUpdateArtPieceBttn().setText(translations.get(18));
        view.getDeleteArtPieceBttn().setText(translations.get(19));
        view.getSellArtPieceBttn().setText(translations.get(20));
        view.getExportLabel().setText(translations.get(21));
        view.getLblCreateGra().setText(translations.get(22));
        view.getBtnGenerate().setText(translations.get(23));
        view.getFrame().repaint();
    }

    @Override
    public void update(Subject subject) {
        TranslationService translationService = (TranslationService) subject;
        translatePage(translationService);
    }
}
