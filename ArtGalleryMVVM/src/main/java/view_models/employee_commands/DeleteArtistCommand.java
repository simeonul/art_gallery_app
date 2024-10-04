package view_models.employee_commands;

import models.services.ArtService;
import view_models.CommandsInterface;
import view_models.EmployeeViewModel;

public class DeleteArtistCommand implements CommandsInterface {
    private EmployeeViewModel viewModel;
    private ArtService artService;

    public DeleteArtistCommand(EmployeeViewModel viewModel){
        this.viewModel = viewModel;
        this.artService = new ArtService();
    }


    @Override
    public void execute() {
        int selectedRowArtist = viewModel.getRowArtist();
        if(selectedRowArtist > -1){
            int id = Integer.parseInt(String.valueOf(viewModel.getArtistModel().getValueAt(selectedRowArtist, 0)));
            artService.deleteArtist(id);
            viewModel.getAllArtistCommand.execute();
            viewModel.getAllArtPieceArtistCommand.execute();
        }
    }
}
