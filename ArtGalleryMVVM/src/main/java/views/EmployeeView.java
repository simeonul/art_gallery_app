package views;

import net.sds.mvvm.bindings.Bind;
import net.sds.mvvm.bindings.Binder;
import net.sds.mvvm.bindings.BindingException;
import net.sds.mvvm.bindings.BindingType;
import view_models.EmployeeViewModel;

import java.awt.Font;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class EmployeeView {

    private static JFrame frame;

    @Bind(value = "model", target = "artPieceModel.value", type = BindingType.BI_DIRECTIONAL)
    @Bind(value = "selectedRow", target = "rowArtPiece.value", type = BindingType.BI_DIRECTIONAL)
    private JTable artPieceTable = new JTable(new DefaultTableModel());

    @Bind(value = "model", target = "artistModel.value", type = BindingType.BI_DIRECTIONAL)
    @Bind(value = "selectedRow", target = "rowArtist.value", type = BindingType.BI_DIRECTIONAL)
    private JTable artistTable = new JTable(new DefaultTableModel());

    @Bind(value = "text", target = "artist.value")
    private JTextField artistTxtField;

    @Bind(value = "text", target = "birth.value")
    private JTextField birthTxtField;

    @Bind(value = "text", target = "nationality.value")
    private JTextField nationalityTxtField;

    @Bind(value = "text", target = "title.value")
    private JTextField titleTxtField;

    @Bind(value = "text", target = "artistId.value")
    private JTextField artistIdTxtField;

    @Bind(value = "text", target = "artForm.value")
    private JTextField artFormTxtField;

    @Bind(value = "text", target = "year.value")
    private JTextField yearTxtField;

    @Bind(value = "text", target = "price.value")
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
    private EmployeeViewModel employeeViewModel;

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

        artistTable.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        artistTable.setRowHeight(22);
        artistTable.getTableHeader().setFont(new Font("Times New Roman", Font.PLAIN, 20));
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
        sortBttn.setBounds(475, 385, 260, 25);
        frame.getContentPane().add(sortBttn);

        filterBttn = new JButton("Filter Art Pieces");
        filterBttn.setFont(new Font("Times New Roman", Font.PLAIN, 22));
        filterBttn.setBounds(475, 425, 260, 25);
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
        titleLabel.setBounds(20, 385, 125, 25);
        frame.getContentPane().add(titleLabel);

        titleTxtField = new JTextField();
        titleTxtField.setFont(new Font("Times New Roman", Font.PLAIN, 22));
        titleTxtField.setColumns(10);
        titleTxtField.setBounds(170, 385, 250, 25);
        frame.getContentPane().add(titleTxtField);

        artistIdLabel = new JLabel("Artist Id");
        artistIdLabel.setFont(new Font("Times New Roman", Font.PLAIN, 22));
        artistIdLabel.setBounds(20, 425, 125, 25);
        frame.getContentPane().add(artistIdLabel);

        artistIdTxtField = new JTextField();
        artistIdTxtField.setFont(new Font("Times New Roman", Font.PLAIN, 22));
        artistIdTxtField.setColumns(10);
        artistIdTxtField.setBounds(170, 425, 250, 25);
        frame.getContentPane().add(artistIdTxtField);

        artFormLabel = new JLabel("Art Form");
        artFormLabel.setFont(new Font("Times New Roman", Font.PLAIN, 22));
        artFormLabel.setBounds(20, 465, 125, 25);
        frame.getContentPane().add(artFormLabel);

        artFormTxtField = new JTextField();
        artFormTxtField.setFont(new Font("Times New Roman", Font.PLAIN, 22));
        artFormTxtField.setColumns(10);
        artFormTxtField.setBounds(170, 465, 250, 25);
        frame.getContentPane().add(artFormTxtField);

        yearLabel = new JLabel("Year");
        yearLabel.setFont(new Font("Times New Roman", Font.PLAIN, 22));
        yearLabel.setBounds(20, 505, 125, 25);
        frame.getContentPane().add(yearLabel);

        yearTxtField = new JTextField();
        yearTxtField.setFont(new Font("Times New Roman", Font.PLAIN, 22));
        yearTxtField.setColumns(10);
        yearTxtField.setBounds(170, 505, 250, 25);
        frame.getContentPane().add(yearTxtField);

        priceTxtField = new JTextField();
        priceTxtField.setFont(new Font("Times New Roman", Font.PLAIN, 22));
        priceTxtField.setColumns(10);
        priceTxtField.setBounds(170, 545, 250, 25);
        frame.getContentPane().add(priceTxtField);

        priceLabel = new JLabel("Price");
        priceLabel.setFont(new Font("Times New Roman", Font.PLAIN, 22));
        priceLabel.setBounds(20, 545, 125, 25);
        frame.getContentPane().add(priceLabel);

        insertArtPieceBttn = new JButton("Insert Art Piece");
        insertArtPieceBttn.setFont(new Font("Times New Roman", Font.PLAIN, 22));
        insertArtPieceBttn.setBounds(475, 465, 260, 25);
        frame.getContentPane().add(insertArtPieceBttn);

        updateArtPieceBttn = new JButton("Update Art Piece");
        updateArtPieceBttn.setFont(new Font("Times New Roman", Font.PLAIN, 22));
        updateArtPieceBttn.setBounds(475, 505, 260, 25);
        frame.getContentPane().add(updateArtPieceBttn);

        deleteArtPieceBttn = new JButton("Delete Art Piece");
        deleteArtPieceBttn.setFont(new Font("Times New Roman", Font.PLAIN, 22));
        deleteArtPieceBttn.setBounds(475, 545, 260, 25);
        frame.getContentPane().add(deleteArtPieceBttn);

        artPieceTable.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        artPieceTable.setRowHeight(22);
        artPieceTable.getTableHeader().setFont(new Font("Times New Roman", Font.PLAIN, 20));
        artPieceScrollPane = new JScrollPane(artPieceTable);
        artPieceScrollPane.setBounds(789, 297, 730, 386);
        frame.getContentPane().add(artPieceScrollPane);
        Object[] columns2 = {"Id", "Title", "Artist Id", "Artist Name", "Art Form", "Year", "Price"};

        searchBttn = new JButton("Search Art Piece By Title");
        searchBttn.setFont(new Font("Times New Roman", Font.PLAIN, 22));
        searchBttn.setBounds(475, 345, 260, 25);
        frame.getContentPane().add(searchBttn);

        exportLabel = new JLabel("Export Art Piece list as:");
        exportLabel.setFont(new Font("Times New Roman", Font.PLAIN, 22));
        exportLabel.setBounds(20, 634, 220, 25);
        frame.getContentPane().add(exportLabel);

        sellArtPieceBttn = new JButton("Sell Art Piece");
        sellArtPieceBttn.setFont(new Font("Times New Roman", Font.PLAIN, 22));
        sellArtPieceBttn.setBounds(475, 585, 260, 25);
        frame.getContentPane().add(sellArtPieceBttn);

        csvBttn = new JButton("CSV");
        csvBttn.setFont(new Font("Times New Roman", Font.PLAIN, 22));
        csvBttn.setBounds(250, 634, 130, 25);
        frame.getContentPane().add(csvBttn);

        jsonBttn = new JButton("JSON");
        jsonBttn.setFont(new Font("Times New Roman", Font.PLAIN, 22));
        jsonBttn.setBounds(430, 634, 130, 25);
        frame.getContentPane().add(jsonBttn);

        xmlBttn = new JButton("XML");
        xmlBttn.setFont(new Font("Times New Roman", Font.PLAIN, 22));
        xmlBttn.setBounds(250, 674, 130, 25);
        frame.getContentPane().add(xmlBttn);
        frame.setVisible(true);

        txtBttn = new JButton("TXT");
        txtBttn.setFont(new Font("Times New Roman", Font.PLAIN, 22));
        txtBttn.setBounds(430, 674, 130, 25);
        frame.getContentPane().add(txtBttn);
        frame.setVisible(true);

        employeeViewModel = new EmployeeViewModel();
        try {
            Binder.bind(this, employeeViewModel);
        } catch (BindingException e) {
            e.printStackTrace();
        }

        employeeViewModel.getAllArtistCommand.execute();
        employeeViewModel.getAllArtPieceArtistCommand.execute();
        designTable(artistTable);
        designTable(artPieceTable);

        insertArtistBttn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                employeeViewModel.insertArtistCommand.execute();
                designTable(artistTable);
            }
        });

        updateArtistBttn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                employeeViewModel.updateArtistCommand.execute();
                designTable(artistTable);
            }
        });

        deleteArtistBttn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                employeeViewModel.deleteArtistCommand.execute();
                designTable(artistTable);
                designTable(artPieceTable);
            }
        });

        searchBttn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                employeeViewModel.searchArtPieceArtistByTitleCommand.execute();
                designTable(artPieceTable);
            }
        });

        filterBttn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                employeeViewModel.filterArtPieceArtistCommand.execute();
                designTable(artPieceTable);
            }
        });

        sortBttn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                employeeViewModel.sortArtPieceArtistByYearCommand.execute();
                designTable(artPieceTable);
            }
        });

        insertArtPieceBttn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                employeeViewModel.insertArtPieceCommand.execute();
                designTable(artPieceTable);
            }
        });

        updateArtPieceBttn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                employeeViewModel.updateArtPieceCommand.execute();
                designTable(artPieceTable);
            }
        });

        deleteArtPieceBttn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                employeeViewModel.deleteArtPieceCommand.execute();
                designTable(artPieceTable);
            }
        });

        sellArtPieceBttn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                employeeViewModel.sellArtPieceCommand.execute();
                designTable(artPieceTable);
            }
        });

        csvBttn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                employeeViewModel.exportCsvCommand.execute();
            }
        });

        jsonBttn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                employeeViewModel.exportJsonCommand.execute();
            }
        });

        xmlBttn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                employeeViewModel.exportXmlCommand.execute();
            }
        });

        txtBttn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                employeeViewModel.exportTxtCommand.execute();
            }
        });

        frame.addWindowListener(new WindowListener() {
            @Override
            public void windowOpened(WindowEvent e) {

            }

            @Override
            public void windowClosing(WindowEvent e) {
                employeeViewModel.initiateLoginViewCommand.execute();
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

    public void designTable(JTable table){
        DefaultTableCellRenderer cellRenderer = new DefaultTableCellRenderer();
        cellRenderer.setHorizontalAlignment(JLabel.CENTER);
        for(int i = 0; i < table.getColumnModel().getColumnCount(); i++){
            table.getColumnModel().getColumn(i).setCellRenderer(cellRenderer);
        }
        table.getColumnModel().getColumn(0).setPreferredWidth(10);
    }

    public static void showMessage(String message){
        JOptionPane.showMessageDialog(frame, message);

    }
}
