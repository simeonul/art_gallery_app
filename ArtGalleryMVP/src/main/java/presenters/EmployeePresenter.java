package presenters;

import model.models.ArtPiece;
import model.models.ArtPieceArtist;
import model.models.Artist;
import model.models.enums.ArtForm;
import model.services.ArtService;
import views.LogInView;
import views.interfaces.EmployeeViewInterface;

import javax.swing.table.DefaultTableModel;
import java.awt.event.MouseEvent;
import java.util.List;

public class EmployeePresenter {

    private EmployeeViewInterface employeeViewInterface;
    private ArtService artService;
    private int selectedRowArtist;
    private int selectedRowArtPiece;

    public EmployeePresenter(EmployeeViewInterface employeeViewInterface) {
        this.employeeViewInterface = employeeViewInterface;
        this.artService = new ArtService();
    }

    public void getAllArtists() {
        List<Artist> artists = artService.getAllArtists();
        populateArtistTable(artists);
    }

    public void getAllArtPieceArtist() {
        List<ArtPieceArtist> artPieceArtistList = artService.getAllArtPieceArtist();
        populateArtPieceTable(artPieceArtistList);
    }

    public void sortArtPieceArtistByYear() {
        List<ArtPieceArtist> artPieceArtistList = artService.sortArtPieceArtistByYear();
        populateArtPieceTable(artPieceArtistList);
    }

    public void filterArtPieceArtistByArtistForm() {
        String artist = employeeViewInterface.getArtist();
        String artForm = employeeViewInterface.getArtForm();
        List<ArtPieceArtist> artPieceArtistList = artService.filterArtPieceArtistByArtistForm(artist, artForm);
        populateArtPieceTable(artPieceArtistList);
    }

    private String capitalizeEnum(String input) {
        return input.substring(0, 1).toUpperCase() + input.substring(1).toLowerCase();
    }

    private void getArtPieceRowValues(Object[] rowData, ArtPieceArtist artPieceArtist) {
        rowData[0] = artPieceArtist.getId();
        rowData[1] = artPieceArtist.getTitle();
        rowData[2] = artPieceArtist.getArtistId();
        rowData[3] = artPieceArtist.getArtistName();
        rowData[4] = capitalizeEnum(artPieceArtist.getArtForm().toString());
        rowData[5] = artPieceArtist.getYear();
        float price = artPieceArtist.getPrice();
        rowData[6] = price != 0 ? price : "Unknown";
    }

    private void getArtistRowValues(Object[] rowData, Artist artist) {
        rowData[0] = artist.getId();
        rowData[1] = artist.getName();
        rowData[2] = artist.getBirthYear();
        rowData[3] = artist.getNationality();
    }

    private void populateArtistTable(List<Artist> artists) {
        Object[] rowData = new Object[4];
        DefaultTableModel model = employeeViewInterface.getArtistModel();
        model.setRowCount(0);
        for (Artist artist : artists) {
            getArtistRowValues(rowData, artist);
            model.addRow(rowData);
        }
        employeeViewInterface.setArtistModel(model);
    }

    private void populateArtPieceTable(List<ArtPieceArtist> artPieceArtistList) {
        Object[] rowData = new Object[7];
        DefaultTableModel model = employeeViewInterface.getArtPieceModel();
        model.setRowCount(0);
        for (ArtPieceArtist artPieceArtist : artPieceArtistList) {
            getArtPieceRowValues(rowData, artPieceArtist);
            model.addRow(rowData);
        }
        employeeViewInterface.setArtPieceModel(model);
    }

    public void populateArtistFields() {
        DefaultTableModel model = employeeViewInterface.getArtistModel();
        selectedRowArtist = employeeViewInterface.getRowArtist();
        employeeViewInterface.setArtistTxtField(model.getValueAt(selectedRowArtist, 1).toString());
        employeeViewInterface.setBirthTxtField(model.getValueAt(selectedRowArtist, 2).toString());
        employeeViewInterface.setNationalityTxtField(model.getValueAt(selectedRowArtist, 3).toString());
    }

    public void populateArtPieceFields() {
        DefaultTableModel model = employeeViewInterface.getArtPieceModel();
        selectedRowArtPiece = employeeViewInterface.getRowArtPiece();
        employeeViewInterface.setTitleTxtField(model.getValueAt(selectedRowArtPiece, 1).toString());
        employeeViewInterface.setArtistIdTxtField(model.getValueAt(selectedRowArtPiece, 2).toString());
        employeeViewInterface.setArtFormTxtField(model.getValueAt(selectedRowArtPiece, 4).toString());
        employeeViewInterface.setYearTxtField(model.getValueAt(selectedRowArtPiece, 5).toString());
        employeeViewInterface.setPriceTxtField(model.getValueAt(selectedRowArtPiece, 6).toString());
    }

    private Artist createArtist() {
        String name = employeeViewInterface.getArtist();
        int birthYear = Integer.parseInt(employeeViewInterface.getBirthYear());
        String nationality = employeeViewInterface.getNationality();
        return new Artist(name, birthYear, nationality);
    }

    public void addArtist() {
        if (isValidInputArtist()) {
            artService.addArtist(createArtist());
            getAllArtists();
        }
    }

    public void deleteArtist() {
        selectedRowArtist = employeeViewInterface.getRowArtist();
        int id = (int) employeeViewInterface.getArtistModel().getValueAt(selectedRowArtist, 0);
        artService.deleteArtist(id);
        getAllArtists();
        getAllArtPieceArtist();
    }

    public void updateArtist() {
        selectedRowArtist = employeeViewInterface.getRowArtist();
        int id = (int) employeeViewInterface.getArtistModel().getValueAt(selectedRowArtist, 0);
        artService.updateArtist(id, createArtist());
        getAllArtists();
        getAllArtPieceArtist();
    }

    private ArtPiece createArtPiece() {
        String title = employeeViewInterface.getTitle();
        int artistId = Integer.parseInt(employeeViewInterface.getArtistId());
        ArtForm artForm = Enum.valueOf(ArtForm.class, employeeViewInterface.getArtForm().toUpperCase());
        int year = Integer.parseInt(employeeViewInterface.getYear());
        float price = Float.parseFloat(employeeViewInterface.getPrice());
        return new ArtPiece(title, artistId, artForm, year, price);
    }

    private boolean isValidInputArtist() {
        String name = employeeViewInterface.getArtist();
        String birthYear = employeeViewInterface.getBirthYear();
        String nationality = employeeViewInterface.getNationality();
        if (!name.isEmpty() && !birthYear.isEmpty() && !nationality.isEmpty()) {
            return true;
        } else {
            employeeViewInterface.showError("Please complete all necessary fields!");
            return false;
        }
    }

    private boolean isValidInputArtPiece() {
        String title = employeeViewInterface.getTitle();
        String artistId = employeeViewInterface.getArtistId();
        String artForm = employeeViewInterface.getArtForm();
        String year = employeeViewInterface.getYear();
        String price = employeeViewInterface.getPrice();
        if (!title.isEmpty() && !artistId.isEmpty() && !artForm.isEmpty() && !year.isEmpty() && !price.isEmpty()) {
            return true;
        } else {
            employeeViewInterface.showError("Please complete all necessary fields!");
            return false;
        }
    }

    public void addArtPiece() {
        if (isValidInputArtPiece()) {
            artService.addArtPiece(createArtPiece());
            getAllArtPieceArtist();
        }
    }

    public void deleteArtPiece() {
        selectedRowArtPiece = employeeViewInterface.getRowArtPiece();
        int id = (int) employeeViewInterface.getArtPieceModel().getValueAt(selectedRowArtPiece, 0);
        artService.deleteArtPiece(id);
        getAllArtPieceArtist();
    }

    public void updateArtPiece() {
        selectedRowArtPiece = employeeViewInterface.getRowArtPiece();
        int id = (int) employeeViewInterface.getArtPieceModel().getValueAt(selectedRowArtPiece, 0);
        artService.updateArtPiece(id, createArtPiece());
        getAllArtPieceArtist();
    }

    public void initiateLogInView() {
        LogInView logInView = new LogInView();
    }
}
