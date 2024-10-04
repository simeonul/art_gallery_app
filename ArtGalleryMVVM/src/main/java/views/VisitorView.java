package views;

import net.sds.mvvm.bindings.Bind;
import net.sds.mvvm.bindings.Binder;
import net.sds.mvvm.bindings.BindingException;
import net.sds.mvvm.bindings.BindingType;
import view_models.VisitorViewModel;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VisitorView {

    private static JFrame frame;

    @Bind(value = "model", target = "model.value", type = BindingType.BI_DIRECTIONAL)
    private JTable table = new JTable(new DefaultTableModel());

    @Bind(value = "text", target = "artist.value")
    private JTextField artistTxtField;

    @Bind(value = "text", target = "artForm.value")
    private JTextField formTxtField;

    @Bind(value = "text", target = "title.value")
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
    private VisitorViewModel visitorViewModel;

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


        table.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        table.setRowHeight(22);
        table.getTableHeader().setFont(new Font("Times New Roman", Font.PLAIN, 20));
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
        frame.setVisible(true);

        visitorViewModel = new VisitorViewModel();


        try{
            Binder.bind(this, visitorViewModel);
        } catch (BindingException e) {
            e.printStackTrace();
        }

        visitorViewModel.getAllArtPieceArtistCommand.execute();
        designTables();

        showAllBttn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                visitorViewModel.getAllArtPieceArtistCommand.execute();
                designTables();
            }

        });

        searchBttn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                visitorViewModel.searchArtPieceArtistByTitleCommand.execute();
                designTables();
            }
        });

        sortBttn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                visitorViewModel.sortArtPieceArtistByYearCommand.execute();
                designTables();
            }
        });

        filterBttn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                visitorViewModel.filterArtPieceArtistCommand.execute();
                designTables();
            }
        });

        signUpBttn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                visitorViewModel.initiateSignUpViewCommand.execute();
                dispose();
            }
        });

        logInBttn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                visitorViewModel.initiateLogInView.execute();
                dispose();
            }
        });
    }

    public void designTables(){
        DefaultTableCellRenderer cellRenderer = new DefaultTableCellRenderer();
        cellRenderer.setHorizontalAlignment(JLabel.CENTER);
        for(int i = 0; i < table.getColumnModel().getColumnCount(); i++){
            table.getColumnModel().getColumn(i).setCellRenderer(cellRenderer);
        }
        table.getColumnModel().getColumn(0).setPreferredWidth(10);
    }

    public static void dispose(){
        frame.setVisible(false);
        frame.dispose();
    }


}
