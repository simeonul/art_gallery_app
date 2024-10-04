package view_models.login_commands;

import view_models.CommandsInterface;
import view_models.LogInViewModel;
import views.AdministratorView;
import views.LogInView;

public class InitiateAdministratorViewCommand implements CommandsInterface {
    private LogInViewModel viewModel;

    public InitiateAdministratorViewCommand(LogInViewModel viewModel){
        this.viewModel = viewModel;
    }

    @Override
    public void execute() {
        AdministratorView administratorView = new AdministratorView();
        LogInView.dispose();
    }
}
