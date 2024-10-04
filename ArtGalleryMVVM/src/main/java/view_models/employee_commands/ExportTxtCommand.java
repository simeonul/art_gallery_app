package view_models.employee_commands;

import models.services.ExportService;
import view_models.CommandsInterface;
import view_models.EmployeeViewModel;

public class ExportTxtCommand implements CommandsInterface {
    private EmployeeViewModel viewModel;
    private ExportService exportService;

    public ExportTxtCommand(EmployeeViewModel viewModel){
        this.viewModel = viewModel;
        exportService = new ExportService();
    }

    @Override
    public void execute() {
        exportService.writeToTxt();
    }
}
