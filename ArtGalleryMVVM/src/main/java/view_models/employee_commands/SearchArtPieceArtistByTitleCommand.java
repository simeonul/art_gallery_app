package view_models.employee_commands;

import models.model.ArtPieceArtist;
import models.services.ArtService;
import view_models.CommandsInterface;
import view_models.EmployeeViewModel;
import view_models.VisitorViewModel;
import views.EmployeeView;

import javax.swing.table.DefaultTableModel;
import java.util.List;

public class SearchArtPieceArtistByTitleCommand implements CommandsInterface {
    private EmployeeViewModel viewModel;
    private ArtService artService;

    public SearchArtPieceArtistByTitleCommand(EmployeeViewModel viewModel) {
        this.viewModel = viewModel;
        this.artService = new ArtService();
    }

    private String capitalizeEnum(String input){
        return input.substring(0, 1).toUpperCase() + input.substring(1).toLowerCase();
    }
    

    @Override
    public void execute() {
        Object[] columns = new Object[]{"Id", "Title", "Artist Name", "Art Form", "Year", "Price", "Is Sold"};
        int rowIndex = 0;
        List<ArtPieceArtist> artPieceArtistList = artService.searchArtPieceArtistByTitle(viewModel.getTitle());
        int noRows = artPieceArtistList.size();
        Object [][] data = new Object[noRows][7];
        for (ArtPieceArtist artPieceArtist: artPieceArtistList)
        {
            data[rowIndex][0] = String.valueOf(artPieceArtist.getId());
            data[rowIndex][1] = artPieceArtist.getTitle();
            data[rowIndex][2] = artPieceArtist.getArtistName();
            data[rowIndex][3] = capitalizeEnum(artPieceArtist.getArtForm().toString());
            data[rowIndex][4] = String.valueOf(artPieceArtist.getYear());
            data[rowIndex][5] = String.valueOf(artPieceArtist.getPrice());
            data[rowIndex][6] = String.valueOf(artPieceArtist.isSold());

            rowIndex++;
        }
        DefaultTableModel defaultTableModel = new DefaultTableModel(data, columns);
        viewModel.setArtPieceModel(defaultTableModel);
    }
}
