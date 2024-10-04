package presenters;

import model.models.ArtPieceArtist;
import model.services.ArtService;
import views.LogInView;
import views.SignUpView;
import views.interfaces.VisitorViewInterface;

import javax.swing.table.DefaultTableModel;
import java.util.List;

public class VisitorPresenter {

    private VisitorViewInterface visitorViewInterface;
    private ArtService artService;

    public VisitorPresenter(VisitorViewInterface visitorViewInterface) {
        this.visitorViewInterface = visitorViewInterface;
        this.artService = new ArtService();
    }


    private void populateTable(List<ArtPieceArtist> artPieceArtistList){
        Object[] rowData = new Object[6];
        DefaultTableModel model = visitorViewInterface.getModel();
        model.setRowCount(0);
        for(ArtPieceArtist artPieceArtist : artPieceArtistList){
            getRowValues(rowData, artPieceArtist);
            model.addRow(rowData);
        }
        visitorViewInterface.setArtPieceModel(model);
    }

    public void getAllArtPieceArtist(){
        List<ArtPieceArtist> artPieceArtistList = artService.getAllArtPieceArtist();
        populateTable(artPieceArtistList);
    }

    public void sortArtPieceArtistByYear(){
        List<ArtPieceArtist> artPieceArtistList = artService.sortArtPieceArtistByYear();
        populateTable(artPieceArtistList);
    }

    public void filterArtPieceArtistByArtistForm() {
        String artist = visitorViewInterface.getArtist();
        String artForm = visitorViewInterface.getArtForm();
        List<ArtPieceArtist> artPieceArtistList = artService.filterArtPieceArtistByArtistForm(artist, artForm);
        populateTable(artPieceArtistList);
    }

    private String capitalizeEnum(String input){
        return input.substring(0, 1).toUpperCase() + input.substring(1).toLowerCase();
    }

    private void getRowValues(Object[] rowData, ArtPieceArtist artPieceArtist){
        rowData[0] = artPieceArtist.getId();
        rowData[1] = artPieceArtist.getTitle();
        rowData[2] = artPieceArtist.getArtistName();
        rowData[3] = capitalizeEnum(artPieceArtist.getArtForm().toString());
        rowData[4] = artPieceArtist.getYear();
        float price = artPieceArtist.getPrice();
        rowData[5] = price != 0 ? price : "Unknown";
    }

    public void openSignUpPage() {
        SignUpView signUpView = new SignUpView();
        visitorViewInterface.dispose();
    }

    public void openLogInPage() {
        LogInView logInView = new LogInView();
        visitorViewInterface.dispose();
    }
}
