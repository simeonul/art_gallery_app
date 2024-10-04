package views;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class VisitorView {
    private JFrame frame;
    private JTable table = new JTable();
    private JTextField artistTxtField;
    private JTextField formTxtField;
    private JTextField titleTxtField;
    private JLabel title;
    private JLabel artistNameLabel;
    private JScrollPane scrollPane;
    private JLabel formLabel;
    private JButton showAllBttn;
    private JButton sortBttn;
    private JButton filterBttn;
    private JButton signUpBttn;
    private JButton logInBttn;
    private JLabel titleLabel;
    private JButton searchBttn;
    private JComboBox languageComboBox;

    public VisitorView() {
        initialize();
    }
    private void initialize() {

        frame = new JFrame();
        frame.setBounds(100, 100, 1350, 620);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        title = new JLabel("Visitor");
        title.setHorizontalAlignment(SwingConstants.CENTER);
        title.setFont(new Font("Times New Roman", Font.PLAIN, 30));
        title.setBounds(575, 20, 150, 35);
        frame.getContentPane().add(title);


        DefaultTableModel model = new DefaultTableModel();
        Object[] columns = {"Id", "Title", "Artist Name", "Art Form", "Year", "Price"};
        model.setColumnIdentifiers(columns);
        table.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        table.setRowHeight(22);
        table.getTableHeader().setFont(new Font("Times New Roman", Font.PLAIN, 20));
        table.setModel(model);
        scrollPane = new JScrollPane(table);
        scrollPane.setBounds(580, 70, 730, 480);
        frame.getContentPane().add(scrollPane);

        artistNameLabel = new JLabel("Artist Name");
        artistNameLabel.setFont(new Font("Times New Roman", Font.PLAIN, 22));
        artistNameLabel.setBounds(20, 70, 125, 25);
        frame.getContentPane().add(artistNameLabel);

        artistTxtField = new JTextField();
        artistTxtField.setFont(new Font("Times New Roman", Font.PLAIN, 22));
        artistTxtField.setBounds(170, 70, 350, 25);
        frame.getContentPane().add(artistTxtField);
        artistTxtField.setColumns(10);

        formLabel = new JLabel("Art Form");
        formLabel.setFont(new Font("Times New Roman", Font.PLAIN, 22));
        formLabel.setBounds(20, 110, 125, 25);
        frame.getContentPane().add(formLabel);

        formTxtField = new JTextField();
        formTxtField.setFont(new Font("Times New Roman", Font.PLAIN, 22));
        formTxtField.setColumns(10);
        formTxtField.setBounds(170, 110, 350, 25);
        frame.getContentPane().add(formTxtField);

        showAllBttn = new JButton("Show All Art Pieces");
        showAllBttn.setFont(new Font("Times New Roman", Font.PLAIN, 22));
        showAllBttn.setBounds(55, 370, 440, 30);
        frame.getContentPane().add(showAllBttn);

        sortBttn = new JButton("Sort Art Pieces By Year");
        sortBttn.setFont(new Font("Times New Roman", Font.PLAIN, 22));
        sortBttn.setBounds(55, 420, 440, 30);
        frame.getContentPane().add(sortBttn);

        filterBttn = new JButton("Filter Art Pieces");
        filterBttn.setFont(new Font("Times New Roman", Font.PLAIN, 22));
        filterBttn.setBounds(55, 470, 440, 30);
        frame.getContentPane().add(filterBttn);

        signUpBttn = new JButton("Sign Up");
        signUpBttn.setFont(new Font("Times New Roman", Font.PLAIN, 22));
        signUpBttn.setBounds(55, 520, 200, 30);
        frame.getContentPane().add(signUpBttn);

        logInBttn = new JButton("Log In");
        logInBttn.setFont(new Font("Times New Roman", Font.PLAIN, 22));
        logInBttn.setBounds(295, 520, 200, 30);
        frame.getContentPane().add(logInBttn);

        titleLabel = new JLabel("Title");
        titleLabel.setFont(new Font("Times New Roman", Font.PLAIN, 22));
        titleLabel.setBounds(20, 150, 125, 25);
        frame.getContentPane().add(titleLabel);

        titleTxtField = new JTextField();
        titleTxtField.setFont(new Font("Times New Roman", Font.PLAIN, 22));
        titleTxtField.setColumns(10);
        titleTxtField.setBounds(170, 150, 350, 25);
        frame.getContentPane().add(titleTxtField);

        searchBttn = new JButton("Search Art Piece By Title");
        searchBttn.setFont(new Font("Times New Roman", Font.PLAIN, 22));
        searchBttn.setBounds(55, 320, 440, 30);
        frame.getContentPane().add(searchBttn);

        languageComboBox = new JComboBox();
        languageComboBox.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        languageComboBox.setBounds(20, 20, 200, 25);
        Object[] languages = {"English", "Espanol", "Francais"};
        languageComboBox.setModel(new DefaultComboBoxModel<>(languages));
        frame.getContentPane().add(languageComboBox);

        frame.setVisible(true);

    }

    public JFrame getFrame() {
        return frame;
    }

    public JTable getTable() {
        return table;
    }

    public JTextField getArtistTxtField() {
        return artistTxtField;
    }

    public JTextField getFormTxtField() {
        return formTxtField;
    }

    public JTextField getTitleTxtField() {
        return titleTxtField;
    }

    public JButton getShowAllBttn() {
        return showAllBttn;
    }

    public JButton getSortBttn() {
        return sortBttn;
    }

    public JButton getFilterBttn() {
        return filterBttn;
    }

    public JButton getSignUpBttn() {
        return signUpBttn;
    }

    public JButton getLogInBttn() {
        return logInBttn;
    }

    public JButton getSearchBttn() {
        return searchBttn;
    }

    public JLabel getTitle() {
        return title;
    }

    public JLabel getArtistNameLabel() {
        return artistNameLabel;
    }

    public JScrollPane getScrollPane() {
        return scrollPane;
    }

    public JLabel getFormLabel() {
        return formLabel;
    }

    public JLabel getTitleLabel() {
        return titleLabel;
    }

    public JComboBox getLanguageComboBox() {
        return languageComboBox;
    }
}
