package view_models.employee_commands;

import models.services.ExportService;
import view_models.CommandsInterface;
import view_models.EmployeeViewModel;

public class ExportJsonCommand implements CommandsInterface {
    private EmployeeViewModel viewModel;
    private ExportService exportService;

    public ExportJsonCommand(EmployeeViewModel viewModel){
        this.viewModel = viewModel;
        exportService = new ExportService();
    }

    @Override
    public void execute() {
        exportService.writeToJson();
    }
}
