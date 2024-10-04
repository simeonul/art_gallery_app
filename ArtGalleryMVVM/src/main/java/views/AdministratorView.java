package views;

import net.sds.mvvm.bindings.Bind;
import net.sds.mvvm.bindings.Binder;
import net.sds.mvvm.bindings.BindingException;
import net.sds.mvvm.bindings.BindingType;
import view_models.AdministratorViewModel;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class AdministratorView {
    @Bind(value = "model", target = "artPieceModel.value", type = BindingType.BI_DIRECTIONAL)
    @Bind(value = "selectedRow", target = "rowArtPiece.value", type = BindingType.BI_DIRECTIONAL)
    private JTable artPieceTable = new JTable(new DefaultTableModel());

    @Bind(value = "model", target = "userModel.value", type = BindingType.BI_DIRECTIONAL)
    @Bind(value = "selectedRow", target = "rowUser.value", type = BindingType.BI_DIRECTIONAL)
    private JTable userTable = new JTable(new DefaultTableModel());

    @Bind(value = "text", target = "artist.value")
    private JTextField artistTxtField;

    @Bind(value = "text", target = "artForm.value")
    private JTextField artFormTxtField;

    @Bind(value = "text", target = "title.value")
    private JTextField titleTxtField;

    @Bind(value = "text", target = "email.value")
    private JTextField emailTxtField;

    @Bind(value = "text", target = "password.value")
    private JTextField passwordTxtField;

    @Bind(value = "text", target = "phone.value")
    private JTextField phoneTxtField;

    @Bind(value = "text", target = "address.value")
    private JTextField addressTxtField;

    @Bind(value = "text", target = "type.value")
    private JTextField typeTxtField;

    @Bind(value = "text", target = "enabled.value")
    private JTextField enabledTxtField;


    private static JFrame frame;
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
    private AdministratorViewModel administratorViewModel;

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

        artPieceTable.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        artPieceTable.setRowHeight(22);
        artPieceTable.getTableHeader().setFont(new Font("Times New Roman", Font.PLAIN, 20));
        artPieceScrollPane = new JScrollPane(artPieceTable);
        artPieceScrollPane.setBounds(789, 70, 730, 324);
        frame.getContentPane().add(artPieceScrollPane);
        Object[] columns2 = {"Id", "Title", "Artist Name", "Art Form", "Year", "Price"};

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


        userTable.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        userTable.setRowHeight(22);
        userTable.getTableHeader().setFont(new Font("Times New Roman", Font.PLAIN, 20));
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

        frame.setVisible(true);

        administratorViewModel = new AdministratorViewModel();
        try {
            Binder.bind(this, administratorViewModel);
        } catch (BindingException e) {
            e.printStackTrace();
        }

        administratorViewModel.getAllArtPieceArtistCommand.execute();
        administratorViewModel.getAllUserCommand.execute();
        designTables(artPieceTable);
        designTables(userTable);

        showAllBttn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                administratorViewModel.getAllArtPieceArtistCommand.execute();
                designTables(artPieceTable);
            }

        });

        searchBttn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                administratorViewModel.searchArtPieceArtistByTitleCommand.execute();
                designTables(artPieceTable);
            }
        });

        sortBttn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                administratorViewModel.sortArtPieceArtistByYearCommand.execute();
                designTables(artPieceTable);
            }
        });

        filterBttn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                administratorViewModel.filterArtPieceArtistCommand.execute();
                designTables(artPieceTable);
            }
        });

        viewUserBttn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                administratorViewModel.getAllUserCommand.execute();
                designTables(userTable);
            }
        });

        addUserBttn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                administratorViewModel.insertUserCommand.execute();
                designTables(userTable);
            }
        });

        updateUserBttn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                administratorViewModel.updateUserCommand.execute();
                designTables(userTable);
            }
        });

        deleteUserBttn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                administratorViewModel.deleteUserCommand.execute();
                designTables(userTable);
            }
        });

        frame.addWindowListener(new WindowListener() {
            @Override
            public void windowOpened(WindowEvent e) {

            }

            @Override
            public void windowClosing(WindowEvent e) {
                administratorViewModel.initiateLoginViewCommand.execute();
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

    public void designTables(JTable table){
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
