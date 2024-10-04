package view_models.employee_commands;

import view_models.CommandsInterface;
import view_models.EmployeeViewModel;
import views.LogInView;

public class InitiateLogInViewCommand implements CommandsInterface {
    private EmployeeViewModel viewModel;

    public InitiateLogInViewCommand(EmployeeViewModel viewModel){
        this.viewModel = viewModel;
    }

    @Override
    public void execute() {
        LogInView logInView = new LogInView();
    }
}
