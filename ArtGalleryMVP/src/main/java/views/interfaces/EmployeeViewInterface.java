package views.interfaces;

import javax.swing.table.DefaultTableModel;

public interface EmployeeViewInterface {
    DefaultTableModel getArtistModel();
    DefaultTableModel getArtPieceModel();
    String getArtist();
    String getArtForm();
    void setArtistTxtField(String s);
    void setBirthTxtField(String s);
    void setNationalityTxtField(String s);
    void setTitleTxtField(String s);
    void setArtistIdTxtField(String s);
    void setArtFormTxtField(String s);
    void setYearTxtField(String s);
    void setPriceTxtField(String s);
    String getBirthYear();
    String getNationality();
    String getTitle();
    String getArtistId();
    String getYear();
    String getPrice();
    void showError(String s);
    void setArtistModel(DefaultTableModel model);
    void setArtPieceModel(DefaultTableModel model);
    int getRowArtist();
    int getRowArtPiece();
}
