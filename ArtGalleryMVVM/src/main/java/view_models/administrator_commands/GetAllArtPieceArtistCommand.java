package view_models.administrator_commands;

import models.model.ArtPieceArtist;
import models.services.ArtService;
import view_models.AdministratorViewModel;
import view_models.CommandsInterface;
import view_models.VisitorViewModel;

import javax.swing.table.DefaultTableModel;
import java.util.List;

public class GetAllArtPieceArtistCommand implements CommandsInterface {
    private AdministratorViewModel viewModel;
    private ArtService artService;

    public GetAllArtPieceArtistCommand(AdministratorViewModel viewModel) {
        this.viewModel = viewModel;
        this.artService = new ArtService();
    }

    private String capitalizeEnum(String input){
        return input.substring(0, 1).toUpperCase() + input.substring(1).toLowerCase();
    }

    @Override
    public void execute() {
        Object[] columns = new Object[]{"Id", "Title", "Artist Name", "Art Form", "Year", "Price"};
        int rowIndex = 0;
        List<ArtPieceArtist> artPieceArtistList = artService.getNotSoldArtPieceArtist();
        int noRows = artPieceArtistList.size();
        Object [][] data = new Object[noRows][6];
        for (ArtPieceArtist artPieceArtist: artPieceArtistList)
        {
            data[rowIndex][0] = String.valueOf(artPieceArtist.getId());
            data[rowIndex][1] = artPieceArtist.getTitle();
            data[rowIndex][2] = artPieceArtist.getArtistName();
            data[rowIndex][3] = capitalizeEnum(artPieceArtist.getArtForm().toString());
            data[rowIndex][4] = String.valueOf(artPieceArtist.getYear());
            data[rowIndex][5] = String.valueOf(artPieceArtist.getPrice());

            rowIndex++;
        }
        DefaultTableModel defaultTableModel = new DefaultTableModel(data, columns);
        viewModel.setArtPieceModel(defaultTableModel);
    }
}
