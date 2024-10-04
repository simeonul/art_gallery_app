package views.interfaces;

import javax.swing.table.DefaultTableModel;

public interface AdministratorViewInterface {
    String getEmail();
    String getPassword();
    String getPhone();
    String getAddress();
    String getType();
    String getEnabled();
    DefaultTableModel getArtPieceArtistModel();
    DefaultTableModel getUserModel();
    String getArtist();
    String getArtForm();
    void setEmailTxtField(String s);
    void setPasswordTxtField(String s);
    void setPhoneTxtField(String s);
    void setAddressTxtField(String s);
    void setTypeTxtField(String s);
    void setEnabledTxtField(String s);
    void showError(String errorMessage);
    void setUserModel(DefaultTableModel model);
    void setArtPieceArtistModel(DefaultTableModel model);
    int getRow();
}
