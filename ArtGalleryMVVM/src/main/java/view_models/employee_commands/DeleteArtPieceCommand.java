package view_models.employee_commands;

import models.services.ArtService;
import view_models.CommandsInterface;
import view_models.EmployeeViewModel;

public class DeleteArtPieceCommand implements CommandsInterface {
    private EmployeeViewModel viewModel;
    private ArtService artService;

    public DeleteArtPieceCommand(EmployeeViewModel viewModel) {
        this.viewModel = viewModel;
        this.artService = new ArtService();
    }

    @Override
    public void execute() {
        int selectedRowArtPiece = viewModel.getRowArtPiece();
        if (selectedRowArtPiece > -1) {
            int id = Integer.parseInt(String.valueOf(viewModel.getArtPieceModel().getValueAt(selectedRowArtPiece, 0)));
            artService.deleteArtPiece(id);
            viewModel.getAllArtPieceArtistCommand.execute();
        }
    }
}
