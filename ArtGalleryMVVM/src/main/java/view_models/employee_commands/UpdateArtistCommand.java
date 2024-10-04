package view_models.employee_commands;

import models.model.Artist;
import models.services.ArtService;
import view_models.CommandsInterface;
import view_models.EmployeeViewModel;
import views.EmployeeView;

public class UpdateArtistCommand implements CommandsInterface {

    private EmployeeViewModel viewModel;
    private ArtService artService;

    public UpdateArtistCommand(EmployeeViewModel viewModel) {
        this.viewModel = viewModel;
        this.artService = new ArtService();
    }

    private boolean isValidInputArtist() {
        String name = viewModel.getArtist();
        String birthYear = viewModel.getBirthYear();
        String nationality = viewModel.getNationality();
        if (!name.isEmpty() && !birthYear.isEmpty() && !nationality.isEmpty()) {
            return true;
        } else {
            EmployeeView.showMessage("Please complete all necessary fields!");
            return false;
        }
    }

    private Artist createArtist() {
        String name = viewModel.getArtist();
        int birthYear = Integer.parseInt(viewModel.getBirthYear());
        String nationality = viewModel.getNationality();
        return new Artist(name, birthYear, nationality);
    }

    @Override
    public void execute() {
        int selectedRowArtist = viewModel.getRowArtist();
        if(selectedRowArtist > -1){
            int id = Integer.parseInt(String.valueOf(viewModel.getArtistModel().getValueAt(selectedRowArtist, 0)));
            if(isValidInputArtist()){
                artService.updateArtist(id, createArtist());
                viewModel.getAllArtistCommand.execute();
                viewModel.getAllArtPieceArtistCommand.execute();
            }
        }
    }
}
