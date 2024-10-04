package view_models;

import net.sds.mvvm.properties.Property;
import net.sds.mvvm.properties.PropertyFactory;
import view_models.administrator_commands.*;

import javax.swing.table.DefaultTableModel;

public class AdministratorViewModel {
    private Property<String> artist;
    private Property<String> artForm;
    private Property<String> title;
    private Property<String> email;
    private Property<String> password;
    private Property<String> phone;
    private Property<String> address;
    private Property<String> type;
    private Property<String> enabled;
    private Property<Integer> rowArtPiece;
    private Property<Integer> rowUser;
    private Property<DefaultTableModel> userModel;
    private Property<DefaultTableModel> artPieceModel;

    public CommandsInterface getAllArtPieceArtistCommand;
    public CommandsInterface sortArtPieceArtistByYearCommand;
    public CommandsInterface filterArtPieceArtistCommand;
    public CommandsInterface searchArtPieceArtistByTitleCommand;
    public CommandsInterface getAllUserCommand;
    public CommandsInterface insertUserCommand;
    public CommandsInterface updateUserCommand;
    public CommandsInterface deleteUserCommand;
    public CommandsInterface initiateLoginViewCommand;

    public AdministratorViewModel(){
        artist = PropertyFactory.createProperty("artist", this, String.class);
        artForm = PropertyFactory.createProperty("artForm", this, String.class);
        title = PropertyFactory.createProperty("title", this, String.class);
        email = PropertyFactory.createProperty("email", this, String.class);
        password = PropertyFactory.createProperty("password", this, String.class);
        phone = PropertyFactory.createProperty("phone", this, String.class);
        address = PropertyFactory.createProperty("address", this, String.class);
        type = PropertyFactory.createProperty("type", this, String.class);
        enabled = PropertyFactory.createProperty("enabled", this, String.class);

        rowUser = PropertyFactory.createProperty("rowArtist", this, Integer.class);
        rowArtPiece = PropertyFactory.createProperty("rowArtPiece", this, Integer.class);
        userModel = PropertyFactory.createProperty("userModel", this, new DefaultTableModel());
        artPieceModel = PropertyFactory.createProperty("artPieceModel", this, new DefaultTableModel());

        getAllArtPieceArtistCommand = new GetAllArtPieceArtistCommand(this);
        sortArtPieceArtistByYearCommand = new SortArtPieceArtistByYearCommand(this);
        filterArtPieceArtistCommand = new FilterArtPieceArtistCommand(this);
        searchArtPieceArtistByTitleCommand = new SearchArtPieceArtistByTitleCommand(this);
        getAllUserCommand = new GetAllUserCommand(this);
        insertUserCommand = new InsertUserCommand(this);
        updateUserCommand = new UpdateUserCommand(this);
        deleteUserCommand = new DeleteUserCommand(this);

        initiateLoginViewCommand = new InitiateLogInViewCommand(this);
    }

    public String getArtist() {
        return artist.get();
    }

    public String getArtForm() {
        return artForm.get();
    }

    public String getTitle() {
        return title.get();
    }

    public String getEmail() {
        return email.get();
    }

    public String getPassword() {
        return password.get();
    }

    public String getPhone() {
        return phone.get();
    }

    public String getAddress() {
        return address.get();
    }

    public String getType() {
        return type.get();
    }

    public String getEnabled() {
        return enabled.get();
    }

    public Integer getRowArtPiece() {
        return rowArtPiece.get();
    }

    public Integer getRowUser() {
        return rowUser.get();
    }

    public DefaultTableModel getUserModel() {
        return userModel.get();
    }

    public void setUserModel(DefaultTableModel newModel) {
        userModel.set(newModel);
    }

    public DefaultTableModel getArtPieceModel() {
        return artPieceModel.get();
    }

    public void setArtPieceModel(DefaultTableModel newModel) {
        artPieceModel.set(newModel);
    }
}
