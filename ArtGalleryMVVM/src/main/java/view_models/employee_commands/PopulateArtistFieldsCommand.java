package view_models.employee_commands;

import view_models.CommandsInterface;
import view_models.EmployeeViewModel;

import javax.swing.table.DefaultTableModel;

public class PopulateArtistFieldsCommand implements CommandsInterface {
    private EmployeeViewModel viewModel;

    public PopulateArtistFieldsCommand(EmployeeViewModel viewModel){
        this.viewModel = viewModel;
    }


    @Override
    public void execute() {
        DefaultTableModel model = viewModel.getArtistModel();
        int selectedRowArtist = viewModel.getRowArtist();
        viewModel.setArtist(model.getValueAt(selectedRowArtist, 1).toString());
        viewModel.setBirthYear(model.getValueAt(selectedRowArtist, 2).toString());
        viewModel.setNationality(model.getValueAt(selectedRowArtist, 3).toString());
    }
}
