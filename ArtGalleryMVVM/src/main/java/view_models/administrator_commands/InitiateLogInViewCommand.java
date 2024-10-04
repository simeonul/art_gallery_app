package view_models.administrator_commands;

import view_models.AdministratorViewModel;
import view_models.CommandsInterface;
import views.LogInView;

public class InitiateLogInViewCommand implements CommandsInterface {
    private AdministratorViewModel viewModel;

    public InitiateLogInViewCommand(AdministratorViewModel viewModel){
        this.viewModel = viewModel;
    }

    @Override
    public void execute() {
        LogInView logInView = new LogInView();
    }
}
