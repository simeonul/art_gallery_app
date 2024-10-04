package views;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class EmployeeView {

    private static JFrame frame;
    private JTable artPieceTable = new JTable();
    private JTable artistTable = new JTable();
    private JTextField artistTxtField;
    private JTextField birthTxtField;
    private JTextField nationalityTxtField;
    private JTextField titleTxtField;
    private JTextField artistIdTxtField;
    private JTextField artFormTxtField;
    private JTextField yearTxtField;
    private JTextField priceTxtField;
    private JLabel title;
    private JLabel artistNameLabel;
    private JScrollPane artistScrollPane;
    private JLabel birthYearLabel;
    private JButton sortBttn;
    private JButton filterBttn;
    private JLabel artFormLabel;
    private JLabel artistIdLabel;
    private JLabel titleLabel;
    private JScrollPane artPieceScrollPane;
    private JButton searchBttn;
    private JLabel exportLabel;
    private JButton sellArtPieceBttn;
    private JButton updateArtPieceBttn;
    private JButton deleteArtPieceBttn;
    private JButton insertArtistBttn;
    private JButton updateArtistBttn;
    private JButton deleteArtistBttn;
    private JButton insertArtPieceBttn;
    private JButton csvBttn;
    private JButton jsonBttn;
    private JButton xmlBttn;
    private JButton txtBttn;
    private JLabel priceLabel;
    private JLabel nationalityLabel;
    private JLabel yearLabel;
    private JLabel lblCreateGra;
    private JComboBox columnsComboBox;
    private JComboBox structureComboBox;
    private JButton btnGenerate;

    public EmployeeView() {
        initialize();
    }

    private void initialize() {

        frame = new JFrame();
        frame.setBounds(100, 100, 1554, 770);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.getContentPane().setLayout(null);
        frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        title = new JLabel("Employee");
        title.setHorizontalAlignment(SwingConstants.CENTER);
        title.setFont(new Font("Times New Roman", Font.PLAIN, 30));
        title.setBounds(680, 25, 150, 35);
        frame.getContentPane().add(title);

        DefaultTableModel artistModel = new DefaultTableModel();
        Object[] columnsArtist = {"Id", "Name", "Birth Year", "Nationality"};
        artistModel.setColumnIdentifiers(columnsArtist);
        artistTable.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        artistTable.setRowHeight(22);
        artistTable.getTableHeader().setFont(new Font("Times New Roman", Font.PLAIN, 20));
        artistTable.setModel(artistModel);
        artistScrollPane = new JScrollPane(artistTable);
        artistScrollPane.setBounds(789, 70, 730, 197);
        frame.getContentPane().add(artistScrollPane);

        artistNameLabel = new JLabel("Artist Name");
        artistNameLabel.setFont(new Font("Times New Roman", Font.PLAIN, 22));
        artistNameLabel.setBounds(20, 105, 125, 25);
        frame.getContentPane().add(artistNameLabel);

        artistTxtField = new JTextField();
        artistTxtField.setFont(new Font("Times New Roman", Font.PLAIN, 22));
        artistTxtField.setBounds(170, 105, 250, 25);
        frame.getContentPane().add(artistTxtField);
        artistTxtField.setColumns(10);

        birthYearLabel = new JLabel("Birth Year");
        birthYearLabel.setFont(new Font("Times New Roman", Font.PLAIN, 22));
        birthYearLabel.setBounds(20, 145, 125, 25);
        frame.getContentPane().add(birthYearLabel);

        birthTxtField = new JTextField();
        birthTxtField.setFont(new Font("Times New Roman", Font.PLAIN, 22));
        birthTxtField.setColumns(10);
        birthTxtField.setBounds(170, 145, 250, 25);
        frame.getContentPane().add(birthTxtField);

        sortBttn = new JButton("Sort Art Pieces By Year");
        sortBttn.setFont(new Font("Times New Roman", Font.PLAIN, 22));
        sortBttn.setBounds(475, 337, 260, 25);
        frame.getContentPane().add(sortBttn);

        filterBttn = new JButton("Filter Art Pieces");
        filterBttn.setFont(new Font("Times New Roman", Font.PLAIN, 22));
        filterBttn.setBounds(475, 377, 260, 25);
        frame.getContentPane().add(filterBttn);


        nationalityLabel = new JLabel("Nationality");
        nationalityLabel.setFont(new Font("Times New Roman", Font.PLAIN, 22));
        nationalityLabel.setBounds(20, 185, 125, 25);
        frame.getContentPane().add(nationalityLabel);

        nationalityTxtField = new JTextField();
        nationalityTxtField.setFont(new Font("Times New Roman", Font.PLAIN, 22));
        nationalityTxtField.setColumns(10);
        nationalityTxtField.setBounds(170, 185, 250, 25);
        frame.getContentPane().add(nationalityTxtField);

        insertArtistBttn = new JButton("Insert Artist");
        insertArtistBttn.setFont(new Font("Times New Roman", Font.PLAIN, 22));
        insertArtistBttn.setBounds(475, 105, 260, 25);
        frame.getContentPane().add(insertArtistBttn);

        updateArtistBttn = new JButton("Update Artist");
        updateArtistBttn.setFont(new Font("Times New Roman", Font.PLAIN, 22));
        updateArtistBttn.setBounds(475, 145, 260, 25);
        frame.getContentPane().add(updateArtistBttn);

        deleteArtistBttn = new JButton("Delete Artist");
        deleteArtistBttn.setFont(new Font("Times New Roman", Font.PLAIN, 22));
        deleteArtistBttn.setBounds(475, 185, 260, 25);
        frame.getContentPane().add(deleteArtistBttn);

        titleLabel = new JLabel("Title");
        titleLabel.setFont(new Font("Times New Roman", Font.PLAIN, 22));
        titleLabel.setBounds(20, 297, 125, 25);
        frame.getContentPane().add(titleLabel);

        titleTxtField = new JTextField();
        titleTxtField.setFont(new Font("Times New Roman", Font.PLAIN, 22));
        titleTxtField.setColumns(10);
        titleTxtField.setBounds(170, 297, 250, 25);
        frame.getContentPane().add(titleTxtField);

        artistIdLabel = new JLabel("Artist Id");
        artistIdLabel.setFont(new Font("Times New Roman", Font.PLAIN, 22));
        artistIdLabel.setBounds(20, 337, 125, 25);
        frame.getContentPane().add(artistIdLabel);

        artistIdTxtField = new JTextField();
        artistIdTxtField.setFont(new Font("Times New Roman", Font.PLAIN, 22));
        artistIdTxtField.setColumns(10);
        artistIdTxtField.setBounds(170, 337, 250, 25);
        frame.getContentPane().add(artistIdTxtField);

        artFormLabel = new JLabel("Art Form");
        artFormLabel.setFont(new Font("Times New Roman", Font.PLAIN, 22));
        artFormLabel.setBounds(20, 377, 125, 25);
        frame.getContentPane().add(artFormLabel);

        artFormTxtField = new JTextField();
        artFormTxtField.setFont(new Font("Times New Roman", Font.PLAIN, 22));
        artFormTxtField.setColumns(10);
        artFormTxtField.setBounds(170, 377, 250, 25);
        frame.getContentPane().add(artFormTxtField);

        yearLabel = new JLabel("Year");
        yearLabel.setFont(new Font("Times New Roman", Font.PLAIN, 22));
        yearLabel.setBounds(20, 417, 125, 25);
        frame.getContentPane().add(yearLabel);

        yearTxtField = new JTextField();
        yearTxtField.setFont(new Font("Times New Roman", Font.PLAIN, 22));
        yearTxtField.setColumns(10);
        yearTxtField.setBounds(170, 417, 250, 25);
        frame.getContentPane().add(yearTxtField);

        priceTxtField = new JTextField();
        priceTxtField.setFont(new Font("Times New Roman", Font.PLAIN, 22));
        priceTxtField.setColumns(10);
        priceTxtField.setBounds(170, 457, 250, 25);
        frame.getContentPane().add(priceTxtField);

        priceLabel = new JLabel("Price");
        priceLabel.setFont(new Font("Times New Roman", Font.PLAIN, 22));
        priceLabel.setBounds(20, 457, 125, 25);
        frame.getContentPane().add(priceLabel);

        insertArtPieceBttn = new JButton("Insert Art Piece");
        insertArtPieceBttn.setFont(new Font("Times New Roman", Font.PLAIN, 22));
        insertArtPieceBttn.setBounds(475, 417, 260, 25);
        frame.getContentPane().add(insertArtPieceBttn);

        updateArtPieceBttn = new JButton("Update Art Piece");
        updateArtPieceBttn.setFont(new Font("Times New Roman", Font.PLAIN, 22));
        updateArtPieceBttn.setBounds(475, 457, 260, 25);
        frame.getContentPane().add(updateArtPieceBttn);

        deleteArtPieceBttn = new JButton("Delete Art Piece");
        deleteArtPieceBttn.setFont(new Font("Times New Roman", Font.PLAIN, 22));
        deleteArtPieceBttn.setBounds(475, 497, 260, 25);
        frame.getContentPane().add(deleteArtPieceBttn);

        DefaultTableModel artPieceModel = new DefaultTableModel();
        Object[] columnsArtPiece = {"Id", "Title", "Artist Name", "Art Form", "Year", "Price", "Is Sold"};
        artPieceModel.setColumnIdentifiers(columnsArtPiece);
        artPieceTable.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        artPieceTable.setRowHeight(22);
        artPieceTable.getTableHeader().setFont(new Font("Times New Roman", Font.PLAIN, 20));
        artPieceTable.setModel(artPieceModel);
        artPieceScrollPane = new JScrollPane(artPieceTable);
        artPieceScrollPane.setBounds(789, 297, 730, 386);
        frame.getContentPane().add(artPieceScrollPane);

        searchBttn = new JButton("Search Art Piece By Title");
        searchBttn.setFont(new Font("Times New Roman", Font.PLAIN, 22));
        searchBttn.setBounds(475, 297, 260, 25);
        frame.getContentPane().add(searchBttn);

        exportLabel = new JLabel("Export Art Piece list as:");
        exportLabel.setFont(new Font("Times New Roman", Font.PLAIN, 22));
        exportLabel.setBounds(20, 585, 220, 25);
        frame.getContentPane().add(exportLabel);

        sellArtPieceBttn = new JButton("Sell Art Piece");
        sellArtPieceBttn.setFont(new Font("Times New Roman", Font.PLAIN, 22));
        sellArtPieceBttn.setBounds(475, 537, 260, 25);
        frame.getContentPane().add(sellArtPieceBttn);

        csvBttn = new JButton("CSV");
        csvBttn.setFont(new Font("Times New Roman", Font.PLAIN, 22));
        csvBttn.setBounds(250, 585, 100, 25);
        frame.getContentPane().add(csvBttn);

        jsonBttn = new JButton("JSON");
        jsonBttn.setFont(new Font("Times New Roman", Font.PLAIN, 22));
        jsonBttn.setBounds(380, 585, 100, 25);
        frame.getContentPane().add(jsonBttn);

        xmlBttn = new JButton("XML");
        xmlBttn.setFont(new Font("Times New Roman", Font.PLAIN, 22));
        xmlBttn.setBounds(510, 585, 100, 25);
        frame.getContentPane().add(xmlBttn);

        txtBttn = new JButton("TXT");
        txtBttn.setFont(new Font("Times New Roman", Font.PLAIN, 22));
        txtBttn.setBounds(640, 585, 100, 25);
        frame.getContentPane().add(txtBttn);

        lblCreateGra = new JLabel("Create graph using:");
        lblCreateGra.setFont(new Font("Times New Roman", Font.PLAIN, 22));
        lblCreateGra.setBounds(20, 635, 220, 25);
        frame.getContentPane().add(lblCreateGra);

        columnsComboBox = new JComboBox();
        columnsComboBox.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        columnsComboBox.setBounds(250, 635, 170, 25);
        Object[] columns = {"Artist Name", "Art Form"};
        columnsComboBox.setModel(new DefaultComboBoxModel<>(columns));
        frame.getContentPane().add(columnsComboBox);

        structureComboBox = new JComboBox();
        structureComboBox.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        structureComboBox.setBounds(455, 635, 170, 25);
        Object[] structures = {"Radial", "Column", "Ring"};
        structureComboBox.setModel(new DefaultComboBoxModel<>(structures));
        frame.getContentPane().add(structureComboBox);

        btnGenerate = new JButton("Show");
        btnGenerate.setFont(new Font("Times New Roman", Font.PLAIN, 22));
        btnGenerate.setBounds(640, 635, 100, 25);
        frame.getContentPane().add(btnGenerate);
    }

    public static JFrame getFrame() {
        return frame;
    }

    public JTable getArtPieceTable() {
        return artPieceTable;
    }

    public JTable getArtistTable() {
        return artistTable;
    }

    public JTextField getArtistTxtField() {
        return artistTxtField;
    }

    public JTextField getBirthTxtField() {
        return birthTxtField;
    }

    public JTextField getNationalityTxtField() {
        return nationalityTxtField;
    }

    public JTextField getTitleTxtField() {
        return titleTxtField;
    }

    public JTextField getArtistIdTxtField() {
        return artistIdTxtField;
    }

    public JTextField getArtFormTxtField() {
        return artFormTxtField;
    }

    public JTextField getYearTxtField() {
        return yearTxtField;
    }

    public JTextField getPriceTxtField() {
        return priceTxtField;
    }

    public JLabel getTitle() {
        return title;
    }

    public JLabel getArtistNameLabel() {
        return artistNameLabel;
    }

    public JScrollPane getArtistScrollPane() {
        return artistScrollPane;
    }

    public JLabel getBirthYearLabel() {
        return birthYearLabel;
    }

    public JButton getSortBttn() {
        return sortBttn;
    }

    public JButton getFilterBttn() {
        return filterBttn;
    }

    public JLabel getArtFormLabel() {
        return artFormLabel;
    }

    public JLabel getArtistIdLabel() {
        return artistIdLabel;
    }

    public JLabel getTitleLabel() {
        return titleLabel;
    }

    public JScrollPane getArtPieceScrollPane() {
        return artPieceScrollPane;
    }

    public JButton getSearchBttn() {
        return searchBttn;
    }

    public JLabel getExportLabel() {
        return exportLabel;
    }

    public JButton getSellArtPieceBttn() {
        return sellArtPieceBttn;
    }

    public JButton getUpdateArtPieceBttn() {
        return updateArtPieceBttn;
    }

    public JButton getDeleteArtPieceBttn() {
        return deleteArtPieceBttn;
    }

    public JButton getInsertArtistBttn() {
        return insertArtistBttn;
    }

    public JButton getUpdateArtistBttn() {
        return updateArtistBttn;
    }

    public JButton getDeleteArtistBttn() {
        return deleteArtistBttn;
    }

    public JButton getInsertArtPieceBttn() {
        return insertArtPieceBttn;
    }

    public JButton getCsvBttn() {
        return csvBttn;
    }

    public JButton getJsonBttn() {
        return jsonBttn;
    }

    public JButton getXmlBttn() {
        return xmlBttn;
    }

    public JButton getTxtBttn() {
        return txtBttn;
    }

    public JLabel getPriceLabel() {
        return priceLabel;
    }

    public JLabel getNationalityLabel() {
        return nationalityLabel;
    }

    public JLabel getYearLabel() {
        return yearLabel;
    }


    public JLabel getLblCreateGra() {
        return lblCreateGra;
    }

    public JComboBox getColumnsComboBox() {
        return columnsComboBox;
    }

    public JComboBox getStructureComboBox() {
        return structureComboBox;
    }

    public JButton getBtnGenerate() {
        return btnGenerate;
    }
}
