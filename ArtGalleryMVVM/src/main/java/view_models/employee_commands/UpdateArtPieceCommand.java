package view_models.employee_commands;

import models.model.ArtPiece;
import models.model.enums.ArtForm;
import models.services.ArtService;
import view_models.CommandsInterface;
import view_models.EmployeeViewModel;
import views.EmployeeView;

public class UpdateArtPieceCommand implements CommandsInterface {
    private EmployeeViewModel viewModel;
    private ArtService artService;

    public UpdateArtPieceCommand(EmployeeViewModel viewModel) {
        this.viewModel = viewModel;
        this.artService = new ArtService();
    }

    private boolean isValidInputArtPiece() {
        String title = viewModel.getTitle();
        String artistId = viewModel.getArtistId();
        String artForm = viewModel.getArtForm();
        String year = viewModel.getYear();
        String price = viewModel.getPrice();
        if (!title.isEmpty() && !artistId.isEmpty() && !artForm.isEmpty() && !year.isEmpty() && !price.isEmpty()) {
            return true;
        } else {
            EmployeeView.showMessage("Please complete all necessary fields!");
            return false;
        }
    }

    private ArtPiece createArtPiece() {
        String title = viewModel.getTitle();
        int artistId = Integer.parseInt(viewModel.getArtistId());
        ArtForm artForm = Enum.valueOf(ArtForm.class, viewModel.getArtForm().toUpperCase());
        int year = Integer.parseInt(viewModel.getYear());
        float price = Float.parseFloat(viewModel.getPrice());
        return new ArtPiece(title, artistId, artForm, year, price, false);
    }

    @Override
    public void execute() {
        int selectedRowArtPiece = viewModel.getRowArtPiece();
        if(selectedRowArtPiece > -1){
            int id = Integer.parseInt(String.valueOf(viewModel.getArtPieceModel().getValueAt(selectedRowArtPiece, 0)));
            boolean isSold = Boolean.parseBoolean(String.valueOf(viewModel.getArtPieceModel().getValueAt(selectedRowArtPiece, 6)));
            if(!isSold){
                if(isValidInputArtPiece()){
                    artService.updateArtPiece(id, createArtPiece());
                    viewModel.getAllArtPieceArtistCommand.execute();
                }
            }else{
                EmployeeView.showMessage("Cannot edit a sold Art Piece!");
            }
        }
    }
}
