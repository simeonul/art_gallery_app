package view_models;


import net.sds.mvvm.properties.Property;
import net.sds.mvvm.properties.PropertyFactory;
import view_models.employee_commands.DeleteArtistCommand;
import view_models.signup_commands.InitiateVisitorViewCommand;
import view_models.visitor_commands.*;

import javax.swing.table.DefaultTableModel;

public class VisitorViewModel {

    private Property<String> artist;
    private Property<String> artForm;
    private Property<String> title;
    private Property<DefaultTableModel> model;

    public CommandsInterface getAllArtPieceArtistCommand;
    public CommandsInterface sortArtPieceArtistByYearCommand;
    public CommandsInterface filterArtPieceArtistCommand;
    public CommandsInterface searchArtPieceArtistByTitleCommand;
    public CommandsInterface initiateSignUpViewCommand;
    public CommandsInterface initiateLogInView;


    public VisitorViewModel(){
        artist = PropertyFactory.createProperty("artist", this, String.class);
        artForm = PropertyFactory.createProperty("artForm", this, String.class);
        title = PropertyFactory.createProperty("title", this, String.class);
        model = PropertyFactory.createProperty("model", this, new DefaultTableModel());

        getAllArtPieceArtistCommand = new GetAllArtPieceArtistCommand(this);
        sortArtPieceArtistByYearCommand = new SortArtPieceArtistByYearCommand(this);
        filterArtPieceArtistCommand = new FilterArtPieceArtistCommand(this);
        searchArtPieceArtistByTitleCommand = new SearchArtPieceArtistByTitleCommand(this);
        initiateSignUpViewCommand = new InitiateSignUpViewCommand(this);
        initiateLogInView = new InitiateLogInViewCommand(this);

    }
    public String getArtist(){
        return artist.get();
    }

    public String getArtForm(){
        return artForm.get();
    }

    public String getTitle(){
        return title.get();
    }

    public DefaultTableModel getModel(){
        return model.get();
    }

    public void setModel(DefaultTableModel newModel) {
        model.set(newModel);
    }
}
