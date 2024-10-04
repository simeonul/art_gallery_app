package view_models.visitor_commands;

import view_models.CommandsInterface;
import view_models.VisitorViewModel;
import views.SignUpView;
import views.VisitorView;

public class InitiateSignUpViewCommand implements CommandsInterface {
    private VisitorViewModel viewModel;

    public InitiateSignUpViewCommand(VisitorViewModel viewModel){
        this.viewModel = viewModel;
    }

    @Override
    public void execute() {
        SignUpView signUpView = new SignUpView();
    }
}
