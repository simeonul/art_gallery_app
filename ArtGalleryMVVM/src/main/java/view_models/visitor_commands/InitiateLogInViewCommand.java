package view_models.visitor_commands;

import view_models.CommandsInterface;
import view_models.VisitorViewModel;
import views.LogInView;
import views.SignUpView;

public class InitiateLogInViewCommand implements CommandsInterface {
    private VisitorViewModel viewModel;

    public InitiateLogInViewCommand(VisitorViewModel viewModel){
        this.viewModel = viewModel;
    }

    @Override
    public void execute() {
        LogInView logInView = new LogInView();
    }
}
