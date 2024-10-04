package views;

import presenters.AdministratorPresenter;
import views.interfaces.AdministratorViewInterface;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;

public class AdministratorView implements AdministratorViewInterface {
    private JFrame frame;
    private JLabel title;
    private JButton addUserBttn;
    private JTextField emailTxtField;
    private JTextField passwordTxtField;
    private JTextField typeTxtField;
    private JLabel typeLabel;
    private JLabel passwordLabel;
    private JLabel emailLabel;
    private JTextField phoneTxtField;
    private JTextField addressTxtField;
    private JScrollPane artPieceScrollPane;
    private JTable artPieceTable;
    private DefaultTableModel artPieceModel;
    private JTextField artistTxtField;
    private JTextField artFormTxtField;
    private JLabel artistNameLabel;
    private JLabel artFormLabel;
    private JButton showAllBttn;
    private JButton sortBttn;
    private JButton filterBttn;
    private JLabel enabledLabel;
    private JTextField enabledTxtField;
    private JButton updateUserBttn;
    private JTable userTable;
    private DefaultTableModel userModel;
    private JScrollPane userScrollPane;
    private AdministratorPresenter administratorPresenter;
    private int row;

    public AdministratorView() {
        initialize();
    }
    private void initialize() {
        administratorPresenter = new AdministratorPresenter(this);
        frame = new JFrame();
        frame.setVisible(true);
        frame.setBounds(100, 100, 1554, 750);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        title = new JLabel("Administrator");
        title.setHorizontalAlignment(SwingConstants.CENTER);
        title.setFont(new Font("Times New Roman", Font.PLAIN, 30));
        title.setBounds(680, 25, 170, 35);
        frame.getContentPane().add(title);

        addUserBttn = new JButton("Add User");
        addUserBttn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                administratorPresenter.addUser();
            }
        });
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

        JLabel phoneLabel = new JLabel("Phone");
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

        JLabel addressLabel = new JLabel("Address");
        addressLabel.setFont(new Font("Times New Roman", Font.PLAIN, 22));
        addressLabel.setBounds(21, 570, 125, 25);
        frame.getContentPane().add(addressLabel);

        updateUserBttn = new JButton("Update User");
        updateUserBttn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                administratorPresenter.updateUser();
            }
        });
        updateUserBttn.setFont(new Font("Times New Roman", Font.PLAIN, 22));
        updateUserBttn.setBounds(475, 570, 250, 25);
        frame.getContentPane().add(updateUserBttn);

        JButton deleteUserBttn = new JButton("Delete User");
        deleteUserBttn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                administratorPresenter.deleteUser();
            }
        });
        deleteUserBttn.setFont(new Font("Times New Roman", Font.PLAIN, 22));
        deleteUserBttn.setBounds(475, 610, 250, 25);
        frame.getContentPane().add(deleteUserBttn);

        JButton viewUserBttn = new JButton("View Users");
        viewUserBttn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                administratorPresenter.getAllUsers();
            }
        });
        viewUserBttn.setFont(new Font("Times New Roman", Font.PLAIN, 22));
        viewUserBttn.setBounds(475, 490, 250, 25);
        frame.getContentPane().add(viewUserBttn);

        artPieceScrollPane = new JScrollPane();
        artPieceScrollPane.setBounds(789, 70, 730, 324);
        frame.getContentPane().add(artPieceScrollPane);

        artPieceTable = new JTable();
        artPieceModel = new DefaultTableModel();
        artPieceTable.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        artPieceTable.setRowHeight(22);
        artPieceTable.getTableHeader().setFont(new Font("Times New Roman", Font.PLAIN, 20));
        Object[] columns2 = {"Id", "Title", "Artist Name", "Art Form", "Year", "Price"};
        artPieceModel.setColumnIdentifiers(columns2);
        artPieceScrollPane.setViewportView(artPieceTable);

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
        showAllBttn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                administratorPresenter.getAllArtPieceArtist();
            }
        });
        showAllBttn.setFont(new Font("Times New Roman", Font.PLAIN, 22));
        showAllBttn.setBounds(147, 190, 440, 30);
        frame.getContentPane().add(showAllBttn);

        sortBttn = new JButton("Sort Art Pieces By Year");
        sortBttn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                administratorPresenter.sortArtPieceArtistByYear();
            }
        });
        sortBttn.setFont(new Font("Times New Roman", Font.PLAIN, 22));
        sortBttn.setBounds(147, 240, 440, 30);
        frame.getContentPane().add(sortBttn);

        filterBttn = new JButton("Filter Art Pieces");
        filterBttn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                administratorPresenter.filterArtPieceArtistByArtistForm();
            }
        });
        filterBttn.setFont(new Font("Times New Roman", Font.PLAIN, 22));
        filterBttn.setBounds(147, 290, 440, 30);
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

        userScrollPane = new JScrollPane();
        userScrollPane.setBounds(789, 425, 730, 267);
        frame.getContentPane().add(userScrollPane);


        userTable = new JTable();
        userTable.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getButton() == MouseEvent.BUTTON1) {
                    row = userTable.getSelectedRow();
                    administratorPresenter.populateUserFields();
                }
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
        userModel = new DefaultTableModel();
        userTable.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        userTable.setRowHeight(22);
        userTable.getTableHeader().setFont(new Font("Times New Roman", Font.PLAIN, 20));
        Object[] columns = {"Id", "Email", "Password", "Phone", "Address", "Type", "Enabled"};
        userModel.setColumnIdentifiers(columns);
        userScrollPane.setViewportView(userTable);

        frame.addWindowListener(new WindowListener() {
            @Override
            public void windowOpened(WindowEvent e) {

            }

            @Override
            public void windowClosing(WindowEvent e) {
                administratorPresenter.initiateLogInView();
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

        administratorPresenter.getAllArtPieceArtist();
        administratorPresenter.getAllUsers();
    }


    @Override
    public String getEmail() {
        return emailTxtField.getText();
    }

    @Override
    public String getPassword() {
        return passwordTxtField.getText();
    }

    @Override
    public String getPhone() {
        return phoneTxtField.getText();
    }

    @Override
    public String getAddress() {
        return addressTxtField.getText();
    }

    @Override
    public String getType() {
        return typeTxtField.getText();
    }

    @Override
    public String getEnabled() {
        return enabledTxtField.getText();
    }


    @Override
    public DefaultTableModel getArtPieceArtistModel() {
        return artPieceModel;
    }

    @Override
    public DefaultTableModel getUserModel() {
        return userModel;
    }

    @Override
    public String getArtist() {
        return artistTxtField.getText();
    }

    @Override
    public String getArtForm() {
        return artFormTxtField.getText();
    }

    @Override
    public void setEmailTxtField(String s) {
        emailTxtField.setText(s);
    }

    @Override
    public void setPasswordTxtField(String s) {
        passwordTxtField.setText(s);
    }

    @Override
    public void setPhoneTxtField(String s) {
        phoneTxtField.setText(s);
    }

    @Override
    public void setAddressTxtField(String s) {
        addressTxtField.setText(s);
    }

    @Override
    public void setTypeTxtField(String s) {
        typeTxtField.setText(s);
    }

    @Override
    public void setEnabledTxtField(String s) {
        enabledTxtField.setText(s);
    }

    @Override
    public void showError(String errorMessage) {
        JOptionPane.showMessageDialog(frame, errorMessage);
    }

    @Override
    public void setUserModel(DefaultTableModel model) {
        userTable.setModel(model);
    }

    @Override
    public void setArtPieceArtistModel(DefaultTableModel model) {
        artPieceTable.setModel(model);
    }

    @Override
    public int getRow() {
        return row;
    }

}