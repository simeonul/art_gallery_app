package view_models;

import net.sds.mvvm.properties.Property;
import net.sds.mvvm.properties.PropertyFactory;
import view_models.employee_commands.*;

import javax.swing.table.DefaultTableModel;

public class EmployeeViewModel {

    private Property<String> artist;
    private Property<String> birth;
    private Property<String> nationality;
    private Property<String> title;
    private Property<String> artistId;
    private Property<String> artForm;
    private Property<String> year;
    private Property<String> price;
    private Property<Integer> rowArtPiece;
    private Property<Integer> rowArtist;
    private Property<DefaultTableModel> artistModel;
    private Property<DefaultTableModel> artPieceModel;

    public CommandsInterface getAllArtistCommand;
    public CommandsInterface insertArtistCommand;
    public CommandsInterface updateArtistCommand;
    public CommandsInterface populateArtistFieldsCommand;
    public CommandsInterface deleteArtistCommand;
    public CommandsInterface searchArtPieceArtistByTitleCommand;
    public CommandsInterface getAllArtPieceArtistCommand;
    public CommandsInterface sortArtPieceArtistByYearCommand;
    public CommandsInterface filterArtPieceArtistCommand;
    public CommandsInterface insertArtPieceCommand;
    public CommandsInterface updateArtPieceCommand;
    public CommandsInterface deleteArtPieceCommand;
    public CommandsInterface sellArtPieceCommand;
    public CommandsInterface exportCsvCommand;
    public CommandsInterface exportJsonCommand;
    public CommandsInterface exportXmlCommand;
    public CommandsInterface exportTxtCommand;
    public CommandsInterface initiateLoginViewCommand;

    public EmployeeViewModel() {
        artist = PropertyFactory.createProperty("artist", this, String.class);
        birth = PropertyFactory.createProperty("birth", this, String.class);
        nationality = PropertyFactory.createProperty("nationality", this, String.class);
        title = PropertyFactory.createProperty("title", this, String.class);
        artistId = PropertyFactory.createProperty("artistId", this, String.class);
        artForm = PropertyFactory.createProperty("artForm", this, String.class);
        year = PropertyFactory.createProperty("year", this, String.class);
        price = PropertyFactory.createProperty("price", this, String.class);
        rowArtist = PropertyFactory.createProperty("rowArtist", this, Integer.class);
        rowArtPiece = PropertyFactory.createProperty("rowArtPiece", this, Integer.class);
        artistModel = PropertyFactory.createProperty("artistModel", this, new DefaultTableModel());
        artPieceModel = PropertyFactory.createProperty("artPieceModel", this, new DefaultTableModel());

        getAllArtistCommand = new GetAllArtistCommand(this);
        insertArtistCommand = new InsertArtistCommand(this);
        updateArtistCommand = new UpdateArtistCommand(this);
        deleteArtistCommand = new DeleteArtistCommand(this);
        searchArtPieceArtistByTitleCommand = new SearchArtPieceArtistByTitleCommand(this);
        getAllArtPieceArtistCommand = new GetAllArtPieceArtistCommand(this);
        sortArtPieceArtistByYearCommand = new SortArtPieceArtistByYearCommand(this);
        filterArtPieceArtistCommand = new FilterArtPieceArtistCommand(this);
        insertArtPieceCommand = new InsertArtPieceCommand(this);
        updateArtPieceCommand =  new UpdateArtPieceCommand(this);
        deleteArtPieceCommand = new DeleteArtPieceCommand(this);
        sellArtPieceCommand = new SellArtPieceCommand(this);

        exportCsvCommand = new ExportCsvCommand(this);
        exportJsonCommand = new ExportJsonCommand(this);
        exportXmlCommand = new FilterArtPieceArtistCommand.ExportXmlCommand(this);
        exportTxtCommand = new ExportTxtCommand(this);
        initiateLoginViewCommand = new InitiateLogInViewCommand(this);


        populateArtistFieldsCommand = new PopulateArtistFieldsCommand(this);
    }

    public String getArtist() {
        return artist.get();
    }

    public void setArtist(String artistName){artist.set(artistName);}

    public String getBirthYear() {
        return birth.get();
    }

    public void setBirthYear(String birthYear){birth.set(birthYear);}

    public String getNationality() {
        return nationality.get();
    }

    public void setNationality(String nationalityString){nationality.set(nationalityString);}

    public String getTitle(){
        return title.get();
    }

    public String getArtistId(){return artistId.get();}

    public String getArtForm(){
        return artForm.get();
    }

    public String getYear(){
        return year.get();
    }

    public String getPrice(){
        return price.get();
    }

    public Integer getRowArtist(){return rowArtist.get();}

    public Integer getRowArtPiece(){return rowArtPiece.get();}

    public DefaultTableModel getArtistModel(){
        return artistModel.get();
    }

    public void setArtistModel(DefaultTableModel newModel) {
        artistModel.set(newModel);
    }

    public DefaultTableModel getArtPieceModel(){
        return artPieceModel.get();
    }

    public void setArtPieceModel(DefaultTableModel newModel) {
        artPieceModel.set(newModel);
    }
}
