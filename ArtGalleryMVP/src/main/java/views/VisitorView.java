package views;

import presenters.VisitorPresenter;
import views.interfaces.VisitorViewInterface;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VisitorView implements VisitorViewInterface {

    private JFrame frame;
    private JTable table;
    private JTextField artistTxtField;
    private JTextField formTxtField;
    private JLabel title;
    private JLabel artistNameLabel;
    private JScrollPane scrollPane;
    private JLabel formLabel;
    private JButton showAllBttn;
    private DefaultTableModel model;
    private JButton sortBttn;
    private JButton filterBttn;
    private JButton signUpBttn;
    private JButton logInBttn;
    private VisitorPresenter visitorPresenter;

    public VisitorView() {
        initialize();
    }
    private void initialize() {
        visitorPresenter = new VisitorPresenter(this);

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

        scrollPane = new JScrollPane();
        scrollPane.setBounds(580, 70, 730, 480);
        frame.getContentPane().add(scrollPane);

        table = new JTable();
        model = new DefaultTableModel();
        table.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        table.setRowHeight(22);
        table.getTableHeader().setFont(new Font("Times New Roman", Font.PLAIN, 20));
        Object[] columns = {"Id", "Title", "Artist Name", "Art Form", "Year", "Price"};
        model.setColumnIdentifiers(columns);
        scrollPane.setViewportView(table);

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
        showAllBttn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                visitorPresenter.getAllArtPieceArtist();
            }
        });
        showAllBttn.setFont(new Font("Times New Roman", Font.PLAIN, 22));
        showAllBttn.setBounds(55, 370, 440, 30);
        frame.getContentPane().add(showAllBttn);

        sortBttn = new JButton("Sort Art Pieces By Year");
        sortBttn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                visitorPresenter.sortArtPieceArtistByYear();
            }
        });
        sortBttn.setFont(new Font("Times New Roman", Font.PLAIN, 22));
        sortBttn.setBounds(55, 420, 440, 30);
        frame.getContentPane().add(sortBttn);

        filterBttn = new JButton("Filter Art Pieces");
        filterBttn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                visitorPresenter.filterArtPieceArtistByArtistForm();
            }
        });
        filterBttn.setFont(new Font("Times New Roman", Font.PLAIN, 22));
        filterBttn.setBounds(55, 470, 440, 30);
        frame.getContentPane().add(filterBttn);

        signUpBttn = new JButton("Sign Up");
        signUpBttn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                visitorPresenter.openSignUpPage();
            }
        });
        signUpBttn.setFont(new Font("Times New Roman", Font.PLAIN, 22));
        signUpBttn.setBounds(55, 520, 200, 30);
        frame.getContentPane().add(signUpBttn);

        logInBttn = new JButton("Log In");
        logInBttn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                visitorPresenter.openLogInPage();
            }
        });
        logInBttn.setFont(new Font("Times New Roman", Font.PLAIN, 22));
        logInBttn.setBounds(295, 520, 200, 30);
        frame.getContentPane().add(logInBttn);

        visitorPresenter.getAllArtPieceArtist();
        frame.setVisible(true);
    }

    @Override
    public String getArtist() {return this.artistTxtField.getText();}

    @Override
    public String getArtForm() {return this.formTxtField.getText();}

    @Override
    public void setArtPieceModel(DefaultTableModel model) {
        table.setModel(model);
    }

    @Override
    public DefaultTableModel getModel(){return model;}

    @Override
    public void dispose() {
        frame.setVisible(false);
        frame.dispose();
    }

}
