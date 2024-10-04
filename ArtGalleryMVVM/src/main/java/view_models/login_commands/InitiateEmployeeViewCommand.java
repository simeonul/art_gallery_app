package view_models.login_commands;

import view_models.CommandsInterface;
import view_models.LogInViewModel;
import views.EmployeeView;

public class InitiateEmployeeViewCommand implements CommandsInterface {
    private LogInViewModel viewModel;

    public InitiateEmployeeViewCommand(LogInViewModel viewModel){
        this.viewModel = viewModel;
    }

    @Override
    public void execute() {
        EmployeeView employeeView = new EmployeeView();
    }
}
