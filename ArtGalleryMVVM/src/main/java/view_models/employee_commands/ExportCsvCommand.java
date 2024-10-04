package view_models.employee_commands;

import models.services.ExportService;
import view_models.CommandsInterface;
import view_models.EmployeeViewModel;

public class ExportCsvCommand implements CommandsInterface {
    private EmployeeViewModel viewModel;
    private ExportService exportService;

    public ExportCsvCommand(EmployeeViewModel viewModel){
        this.viewModel = viewModel;
        exportService = new ExportService();
    }

    @Override
    public void execute() {
        exportService.writeToCsv();
    }
}
