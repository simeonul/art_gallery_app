package view_models.login_commands;

import models.model.Users;
import models.model.enums.UserType;
import models.services.UserService;
import view_models.CommandsInterface;
import view_models.LogInViewModel;
import views.AdministratorView;
import views.EmployeeView;
import views.LogInView;
import views.SignUpView;

import java.util.Locale;
import java.util.Optional;

public class LogInCommand implements CommandsInterface {
    private LogInViewModel viewModel;
    private UserService userService;

    public LogInCommand(LogInViewModel viewModel){
        this.viewModel = viewModel;
        this.userService = new UserService();
    }


    @Override
    public void execute() {
        String email = viewModel.getEmail();
        String password = viewModel.getPassword();
        Optional<Users> user = userService.getUserByEmail(email);
        if (user.isPresent()) {
            Users account = user.get();
            if (account.getPassword().equals(password)) {
                if (account.isEnabled()) {
                    if (account.getUserType().toString().equals("EMPLOYEE")) {
                        viewModel.initiateEmployeeViewCommand.execute();
                    }
                    if (account.getUserType().toString().equals("ADMINISTRATOR")) {
                        viewModel.initiateAdministratorViewCommand.execute();
                    }
                    LogInView.dispose();
                } else {
                    LogInView.showMessage("This account has not been enabled by an administrator!");
                }
            } else {
                LogInView.showMessage("Wrong password!");
            }
        } else {
            LogInView.showMessage("No user is registered with this email!");
        }
    }
}
