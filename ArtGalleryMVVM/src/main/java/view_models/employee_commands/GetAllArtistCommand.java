package view_models.employee_commands;

import models.model.Artist;
import models.services.ArtService;
import view_models.CommandsInterface;
import view_models.EmployeeViewModel;

import javax.swing.table.DefaultTableModel;
import java.util.List;

public class GetAllArtistCommand implements CommandsInterface {
    private EmployeeViewModel viewModel;
    private ArtService artService;

    public GetAllArtistCommand(EmployeeViewModel viewModel) {
        this.viewModel = viewModel;
        this.artService = new ArtService();
    }

    @Override
    public void execute() {
        Object[] columns = {"Id", "Name", "Birth Year", "Nationality"};
        int rowIndex = 0;
        List<Artist> artists = artService.getAllArtists();
        int noRows = artists.size();
        Object [][] data = new Object[noRows][4];
        for (Artist artist: artists)
        {
            data[rowIndex][0] = String.valueOf(artist.getId());
            data[rowIndex][1] = artist.getName();
            data[rowIndex][2] = artist.getBirthYear();
            data[rowIndex][3] = artist.getNationality();

            rowIndex++;
        }
        DefaultTableModel defaultTableModel = new DefaultTableModel(data, columns);
        viewModel.setArtistModel(defaultTableModel);
    }
}
