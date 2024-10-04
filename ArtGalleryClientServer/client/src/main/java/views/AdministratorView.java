package views;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class AdministratorView {
    private JTable artPieceTable = new JTable();
    private JTable userTable = new JTable();
    private JTextField artistTxtField;
    private JTextField artFormTxtField;
    private JTextField titleTxtField;
    private JTextField emailTxtField;
    private JTextField passwordTxtField;
    private JTextField phoneTxtField;
    private JTextField addressTxtField;
    private JTextField typeTxtField;
    private JTextField enabledTxtField;
    private  JFrame frame;
    private JLabel title;
    private JButton addUserBttn;
    private JLabel typeLabel;
    private JLabel passwordLabel;
    private JLabel emailLabel;
    private JScrollPane artPieceScrollPane;
    private JLabel artistNameLabel;
    private JLabel artFormLabel;
    private JButton showAllBttn;
    private JButton sortBttn;
    private JButton filterBttn;
    private JLabel enabledLabel;
    private JButton updateUserBttn;
    private JScrollPane userScrollPane;
    private JLabel titleLabel;
    private JButton searchBttn;
    private JLabel phoneLabel;
    private JLabel addressLabel;
    private JButton deleteUserBttn;
    private JButton viewUserBttn;

    public AdministratorView() {
        initialize();
    }
    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 1554, 750);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        title = new JLabel("Administrator");
        title.setHorizontalAlignment(SwingConstants.CENTER);
        title.setFont(new Font("Times New Roman", Font.PLAIN, 30));
        title.setBounds(680, 25, 170, 35);
        frame.getContentPane().add(title);

        addUserBttn = new JButton("Add User");
        addUserBttn.setFont(new Font("Times New Roman", Font.PLAIN, 22));
        addUserBttn.setBounds(475, 530, 250, 25);
        frame.getContentPane().add(addUserBttn);

        emailLabel = new JLabel("Email");
        emailLabel.setFont(new Font("Times New Roman", Font.PLAIN, 22));
        emailLabel.setBounds(21, 450, 125, 25);
        frame.getContentPane().add(emailLabel);

        emailTxtField = new JTextField();
        emailTxtField.setFont(new Font("Times New Roman", Font.PLAIN, 22));
        emailTxtField.setColumns(10);
        emailTxtField.setBounds(171, 450, 250, 25);
        frame.getContentPane().add(emailTxtField);

        passwordLabel = new JLabel("Password");
        passwordLabel.setFont(new Font("Times New Roman", Font.PLAIN, 22));
        passwordLabel.setBounds(21, 490, 125, 25);
        frame.getContentPane().add(passwordLabel);

        passwordTxtField = new JTextField();
        passwordTxtField.setFont(new Font("Times New Roman", Font.PLAIN, 22));
        passwordTxtField.setColumns(10);
        passwordTxtField.setBounds(171, 490, 250, 25);
        frame.getContentPane().add(passwordTxtField);

        typeLabel = new JLabel("User Type");
        typeLabel.setFont(new Font("Times New Roman", Font.PLAIN, 22));
        typeLabel.setBounds(21, 610, 125, 25);
        frame.getContentPane().add(typeLabel);

        typeTxtField = new JTextField();
        typeTxtField.setFont(new Font("Times New Roman", Font.PLAIN, 22));
        typeTxtField.setColumns(10);
        typeTxtField.setBounds(171, 610, 250, 25);
        frame.getContentPane().add(typeTxtField);

        phoneLabel = new JLabel("Phone");
        phoneLabel.setFont(new Font("Times New Roman", Font.PLAIN, 22));
        phoneLabel.setBounds(21, 530, 125, 25);
        frame.getContentPane().add(phoneLabel);

        phoneTxtField = new JTextField();
        phoneTxtField.setFont(new Font("Times New Roman", Font.PLAIN, 22));
        phoneTxtField.setColumns(10);
        phoneTxtField.setBounds(171, 530, 250, 25);
        frame.getContentPane().add(phoneTxtField);

        addressTxtField = new JTextField();
        addressTxtField.setFont(new Font("Times New Roman", Font.PLAIN, 22));
        addressTxtField.setColumns(10);
        addressTxtField.setBounds(171, 570, 250, 25);
        frame.getContentPane().add(addressTxtField);

        addressLabel = new JLabel("Address");
        addressLabel.setFont(new Font("Times New Roman", Font.PLAIN, 22));
        addressLabel.setBounds(21, 570, 125, 25);
        frame.getContentPane().add(addressLabel);

        updateUserBttn = new JButton("Update User");
        updateUserBttn.setFont(new Font("Times New Roman", Font.PLAIN, 22));
        updateUserBttn.setBounds(475, 570, 250, 25);
        frame.getContentPane().add(updateUserBttn);

        deleteUserBttn = new JButton("Delete User");
        deleteUserBttn.setFont(new Font("Times New Roman", Font.PLAIN, 22));
        deleteUserBttn.setBounds(475, 610, 250, 25);
        frame.getContentPane().add(deleteUserBttn);

        viewUserBttn = new JButton("View Users");
        viewUserBttn.setFont(new Font("Times New Roman", Font.PLAIN, 22));
        viewUserBttn.setBounds(475, 490, 250, 25);
        frame.getContentPane().add(viewUserBttn);

        DefaultTableModel artPieceModel = new DefaultTableModel();
        Object[] columnsArtPiece = new Object[]{"Id", "Title", "Artist Name", "Art Form", "Year", "Price"};
        artPieceModel.setColumnIdentifiers(columnsArtPiece);
        artPieceTable.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        artPieceTable.setRowHeight(22);
        artPieceTable.getTableHeader().setFont(new Font("Times New Roman", Font.PLAIN, 20));
        artPieceTable.setModel(artPieceModel);
        artPieceScrollPane = new JScrollPane(artPieceTable);
        artPieceScrollPane.setBounds(789, 70, 730, 324);
        frame.getContentPane().add(artPieceScrollPane);

        artistNameLabel = new JLabel("Artist Name");
        artistNameLabel.setFont(new Font("Times New Roman", Font.PLAIN, 22));
        artistNameLabel.setBounds(110, 105, 125, 25);
        frame.getContentPane().add(artistNameLabel);

        artistTxtField = new JTextField();
        artistTxtField.setFont(new Font("Times New Roman", Font.PLAIN, 22));
        artistTxtField.setColumns(10);
        artistTxtField.setBounds(260, 105, 350, 25);
        frame.getContentPane().add(artistTxtField);

        artFormLabel = new JLabel("Art Form");
        artFormLabel.setFont(new Font("Times New Roman", Font.PLAIN, 22));
        artFormLabel.setBounds(110, 145, 90, 25);
        frame.getContentPane().add(artFormLabel);

        artFormTxtField = new JTextField();
        artFormTxtField.setFont(new Font("Times New Roman", Font.PLAIN, 22));
        artFormTxtField.setColumns(10);
        artFormTxtField.setBounds(260, 145, 350, 25);
        frame.getContentPane().add(artFormTxtField);

        showAllBttn = new JButton("Show All Art Pieces");
        showAllBttn.setFont(new Font("Times New Roman", Font.PLAIN, 22));
        showAllBttn.setBounds(145, 240, 440, 30);
        frame.getContentPane().add(showAllBttn);

        sortBttn = new JButton("Sort Art Pieces By Year");
        sortBttn.setFont(new Font("Times New Roman", Font.PLAIN, 22));
        sortBttn.setBounds(145, 290, 440, 30);
        frame.getContentPane().add(sortBttn);

        filterBttn = new JButton("Filter Art Pieces");
        filterBttn.setFont(new Font("Times New Roman", Font.PLAIN, 22));
        filterBttn.setBounds(145, 340, 440, 30);
        frame.getContentPane().add(filterBttn);

        enabledLabel = new JLabel("Is Enabled");
        enabledLabel.setFont(new Font("Times New Roman", Font.PLAIN, 22));
        enabledLabel.setBounds(21, 650, 125, 25);
        frame.getContentPane().add(enabledLabel);

        enabledTxtField = new JTextField();
        enabledTxtField.setFont(new Font("Times New Roman", Font.PLAIN, 22));
        enabledTxtField.setColumns(10);
        enabledTxtField.setBounds(171, 650, 250, 25);
        frame.getContentPane().add(enabledTxtField);


        DefaultTableModel userModel = new DefaultTableModel();
        Object[] columnsUser = new Object[]{"Id", "Email", "Password", "Phone", "Address", "Type", "Enabled"};
        userModel.setColumnIdentifiers(columnsUser);
        userTable.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        userTable.setRowHeight(22);
        userTable.getTableHeader().setFont(new Font("Times New Roman", Font.PLAIN, 20));
        userTable.setModel(userModel);
        userScrollPane = new JScrollPane(userTable);
        userScrollPane.setBounds(789, 425, 730, 267);
        frame.getContentPane().add(userScrollPane);

        titleLabel = new JLabel("Title");
        titleLabel.setFont(new Font("Times New Roman", Font.PLAIN, 22));
        titleLabel.setBounds(110, 65, 125, 25);
        frame.getContentPane().add(titleLabel);

        titleTxtField = new JTextField();
        titleTxtField.setFont(new Font("Times New Roman", Font.PLAIN, 22));
        titleTxtField.setColumns(10);
        titleTxtField.setBounds(260, 65, 350, 25);
        frame.getContentPane().add(titleTxtField);

        searchBttn = new JButton("Search Art Piece By Title");
        searchBttn.setFont(new Font("Times New Roman", Font.PLAIN, 22));
        searchBttn.setBounds(145, 190, 440, 30);
        frame.getContentPane().add(searchBttn);
    }

    public JTable getArtPieceTable() {
        return artPieceTable;
    }

    public JTable getUserTable() {
        return userTable;
    }

    public JTextField getArtistTxtField() {
        return artistTxtField;
    }

    public JTextField getArtFormTxtField() {
        return artFormTxtField;
    }

    public JTextField getTitleTxtField() {
        return titleTxtField;
    }

    public JTextField getEmailTxtField() {
        return emailTxtField;
    }

    public JTextField getPasswordTxtField() {
        return passwordTxtField;
    }

    public JTextField getPhoneTxtField() {
        return phoneTxtField;
    }

    public JTextField getAddressTxtField() {
        return addressTxtField;
    }

    public JTextField getTypeTxtField() {
        return typeTxtField;
    }

    public JTextField getEnabledTxtField() {
        return enabledTxtField;
    }

    public JFrame getFrame() {
        return frame;
    }

    public JButton getAddUserBttn() {
        return addUserBttn;
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

    public JButton getUpdateUserBttn() {
        return updateUserBttn;
    }

    public JButton getSearchBttn() {
        return searchBttn;
    }

    public JButton getDeleteUserBttn() {
        return deleteUserBttn;
    }

    public JButton getViewUserBttn() {
        return viewUserBttn;
    }

    public JLabel getTitle() {
        return title;
    }

    public JLabel getTypeLabel() {
        return typeLabel;
    }

    public JLabel getPasswordLabel() {
        return passwordLabel;
    }

    public JLabel getEmailLabel() {
        return emailLabel;
    }

    public JScrollPane getArtPieceScrollPane() {
        return artPieceScrollPane;
    }

    public JLabel getArtistNameLabel() {
        return artistNameLabel;
    }

    public JLabel getArtFormLabel() {
        return artFormLabel;
    }

    public JLabel getEnabledLabel() {
        return enabledLabel;
    }

    public JScrollPane getUserScrollPane() {
        return userScrollPane;
    }

    public JLabel getTitleLabel() {
        return titleLabel;
    }

    public JLabel getPhoneLabel() {
        return phoneLabel;
    }

    public JLabel getAddressLabel() {
        return addressLabel;
    }
}
