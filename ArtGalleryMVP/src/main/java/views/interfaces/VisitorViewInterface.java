package views.interfaces;

import javax.swing.table.DefaultTableModel;

public interface VisitorViewInterface {
    DefaultTableModel getModel();
    String getArtist();
    String getArtForm();
    void setArtPieceModel(DefaultTableModel model);
    void dispose();
}
