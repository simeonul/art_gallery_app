package views;

import presenters.EmployeePresenter;
import views.interfaces.EmployeeViewInterface;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;

public class EmployeeView implements EmployeeViewInterface {

    private JFrame frame;
    private JTable artistTable;
    private JTextField artistTxtField;
    private JTextField birthTxtField;
    private JLabel title;
    private JLabel artistNameLabel;
    private JScrollPane artistScrollPane;
    private JLabel birthYearLabel;
    private DefaultTableModel artistModel;
    private JButton sortBttn;
    private JButton filterBttn;
    private JTextField nationalityTxtField;
    private JTextField titleTxtField;
    private JTextField artistIdTxtField;
    private JTextField artFormTxtField;
    private JLabel artFormLabel;
    private JLabel artistIdLabel;
    private JLabel titleLabel;
    private JTextField yearTxtField;
    private JTextField priceTxtField;
    private JScrollPane artPieceScrollPane;
    private JTable artPieceTable;
    private DefaultTableModel artPieceModel;
    private EmployeePresenter employeePresenter;
    private int rowArtist;
    private int rowArtPiece;

    public EmployeeView() {
        initialize();
    }

    private void initialize() {
        this.employeePresenter = new EmployeePresenter(this);

        frame = new JFrame();
        frame.setBounds(100, 100, 1554, 750);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);
        frame.setVisible(true);

        title = new JLabel("Employee");
        title.setHorizontalAlignment(SwingConstants.CENTER);
        title.setFont(new Font("Times New Roman", Font.PLAIN, 30));
        title.setBounds(680, 25, 150, 35);
        frame.getContentPane().add(title);
        frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        artistScrollPane = new JScrollPane();
        artistScrollPane.setBounds(789, 70, 730, 197);
        frame.getContentPane().add(artistScrollPane);

        artistTable = new JTable();
        artistTable.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(e.getButton() == MouseEvent.BUTTON1){
                    rowArtist = artistTable.getSelectedRow();
                    employeePresenter.populateArtistFields();
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
        artistModel = new DefaultTableModel();
        artistTable.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        artistTable.setRowHeight(22);
        artistTable.getTableHeader().setFont(new Font("Times New Roman", Font.PLAIN, 20));
        Object[] columns = {"Id", "Name", "Birth Year", "Nationality"};
        artistModel.setColumnIdentifiers(columns);
        artistScrollPane.setViewportView(artistTable);

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
        sortBttn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                employeePresenter.sortArtPieceArtistByYear();
            }
        });
        sortBttn.setFont(new Font("Times New Roman", Font.PLAIN, 22));
        sortBttn.setBounds(475, 385, 250, 25);
        frame.getContentPane().add(sortBttn);

        filterBttn = new JButton("Filter Art Pieces");
        filterBttn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                employeePresenter.filterArtPieceArtistByArtistForm();
            }
        });
        filterBttn.setFont(new Font("Times New Roman", Font.PLAIN, 22));
        filterBttn.setBounds(475, 425, 250, 25);
        frame.getContentPane().add(filterBttn);


        JLabel nationalityLabel = new JLabel("Nationality");
        nationalityLabel.setFont(new Font("Times New Roman", Font.PLAIN, 22));
        nationalityLabel.setBounds(20, 185, 125, 25);
        frame.getContentPane().add(nationalityLabel);

        nationalityTxtField = new JTextField();
        nationalityTxtField.setFont(new Font("Times New Roman", Font.PLAIN, 22));
        nationalityTxtField.setColumns(10);
        nationalityTxtField.setBounds(170, 185, 250, 25);
        frame.getContentPane().add(nationalityTxtField);

        JButton insertArtistBttn = new JButton("Insert Artist");
        insertArtistBttn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                employeePresenter.addArtist();
            }
        });
        insertArtistBttn.setFont(new Font("Times New Roman", Font.PLAIN, 22));
        insertArtistBttn.setBounds(475, 105, 250, 25);
        frame.getContentPane().add(insertArtistBttn);

        JButton updateArtistBttn = new JButton("Update Artist");
        updateArtistBttn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                employeePresenter.updateArtist();
            }
        });
        updateArtistBttn.setFont(new Font("Times New Roman", Font.PLAIN, 22));
        updateArtistBttn.setBounds(475, 145, 250, 25);
        frame.getContentPane().add(updateArtistBttn);

        JButton deleteArtistBttn = new JButton("Delete Artist");
        deleteArtistBttn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                employeePresenter.deleteArtist();
            }
        });
        deleteArtistBttn.setFont(new Font("Times New Roman", Font.PLAIN, 22));
        deleteArtistBttn.setBounds(475, 185, 250, 25);
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

        JLabel yearLabel = new JLabel("Year");
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

        JLabel priceLabel = new JLabel("Price");
        priceLabel.setFont(new Font("Times New Roman", Font.PLAIN, 22));
        priceLabel.setBounds(20, 545, 125, 25);
        frame.getContentPane().add(priceLabel);

        JButton insertArtPieceBttn = new JButton("Insert Art Piece");
        insertArtPieceBttn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                employeePresenter.addArtPiece();
            }
        });
        insertArtPieceBttn.setFont(new Font("Times New Roman", Font.PLAIN, 22));
        insertArtPieceBttn.setBounds(475, 465, 250, 25);
        frame.getContentPane().add(insertArtPieceBttn);

        JButton updateArtPieceBttn = new JButton("Update Art Piece");
        updateArtPieceBttn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                employeePresenter.updateArtPiece();
            }
        });
        updateArtPieceBttn.setFont(new Font("Times New Roman", Font.PLAIN, 22));
        updateArtPieceBttn.setBounds(475, 505, 250, 25);
        frame.getContentPane().add(updateArtPieceBttn);

        JButton deleteArtPieceBttn = new JButton("Delete Art Piece");
        deleteArtPieceBttn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                employeePresenter.deleteArtPiece();
            }
        });
        deleteArtPieceBttn.setFont(new Font("Times New Roman", Font.PLAIN, 22));
        deleteArtPieceBttn.setBounds(475, 545, 250, 25);
        frame.getContentPane().add(deleteArtPieceBttn);

        artPieceScrollPane = new JScrollPane();
        artPieceScrollPane.setBounds(789, 297, 730, 386);
        frame.getContentPane().add(artPieceScrollPane);

        artPieceTable = new JTable();
        artPieceTable.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getButton() == MouseEvent.BUTTON1) {
                    rowArtPiece = artPieceTable.getSelectedRow();
                    employeePresenter.populateArtPieceFields();
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
        artPieceModel = new DefaultTableModel();
        artPieceTable.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        artPieceTable.setRowHeight(22);
        artPieceTable.getTableHeader().setFont(new Font("Times New Roman", Font.PLAIN, 20));
        Object[] columns2 = {"Id", "Title", "Artist Id", "Artist Name", "Art Form", "Year", "Price"};
        artPieceModel.setColumnIdentifiers(columns2);
        artPieceScrollPane.setViewportView(artPieceTable);

        frame.addWindowListener(new WindowListener() {
            @Override
            public void windowOpened(WindowEvent e) {

            }

            @Override
            public void windowClosing(WindowEvent e) {
                employeePresenter.initiateLogInView();
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

        employeePresenter.getAllArtPieceArtist();
        employeePresenter.getAllArtists();
    }


    @Override
    public DefaultTableModel getArtistModel() {
        return artistModel;
    }

    @Override
    public DefaultTableModel getArtPieceModel() {
        return artPieceModel;
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
    public void setArtistTxtField(String s) {
        artistTxtField.setText(s);
    }

    @Override
    public void setBirthTxtField(String s) {
        birthTxtField.setText(s);
    }

    @Override
    public void setNationalityTxtField(String s) {
        nationalityTxtField.setText(s);
    }

    @Override
    public void setTitleTxtField(String s) {
        titleTxtField.setText(s);
    }

    @Override
    public void setArtistIdTxtField(String s) {
        artistIdTxtField.setText(s);
    }

    @Override
    public void setArtFormTxtField(String s) {
        artFormTxtField.setText(s);
    }

    @Override
    public void setYearTxtField(String s) {
        yearTxtField.setText(s);
    }

    @Override
    public void setPriceTxtField(String s) {
        priceTxtField.setText(s);
    }


    @Override
    public String getBirthYear() {
        return birthTxtField.getText();
    }

    @Override
    public String getNationality() {
        return nationalityTxtField.getText();
    }

    @Override
    public String getTitle() {
        return titleTxtField.getText();
    }

    @Override
    public String getArtistId() {
        return artistIdTxtField.getText();
    }

    @Override
    public String getYear() {
        return yearTxtField.getText();
    }

    @Override
    public String getPrice() {
        return priceTxtField.getText();
    }

    @Override
    public void showError(String s) {
        JOptionPane.showMessageDialog(frame, s);
    }

    @Override
    public void setArtistModel(DefaultTableModel model) {
        artistTable.setModel(model);
    }

    @Override
    public void setArtPieceModel(DefaultTableModel model) {
        artPieceTable.setModel(model);
    }

    @Override
    public int getRowArtist() {
        return rowArtist;
    }

    @Override
    public int getRowArtPiece() {
        return rowArtPiece;
    }


}
