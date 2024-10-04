package view_models.signup_commands;

import view_models.CommandsInterface;
import view_models.SignUpViewModel;
import views.VisitorView;

public class InitiateVisitorViewCommand implements CommandsInterface {
    private SignUpViewModel viewModel;

    public InitiateVisitorViewCommand(SignUpViewModel viewModel){
        this.viewModel = viewModel;
    }

    @Override
    public void execute() {
        VisitorView visitorView = new VisitorView();
    }
}
