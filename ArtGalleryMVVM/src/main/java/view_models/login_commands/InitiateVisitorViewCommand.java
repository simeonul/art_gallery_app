package view_models.login_commands;

import view_models.CommandsInterface;
import view_models.LogInViewModel;
import views.VisitorView;

public class InitiateVisitorViewCommand implements CommandsInterface {
    private LogInViewModel viewModel;

    public InitiateVisitorViewCommand(LogInViewModel viewModel){
        this.viewModel = viewModel;
    }

    @Override
    public void execute() {
        VisitorView visitorView = new VisitorView();
    }
}
