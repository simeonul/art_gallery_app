package presenters;

import model.models.Users;
import model.services.UserService;
import views.AdministratorView;
import views.EmployeeView;
import views.VisitorView;
import views.interfaces.LogInViewInterface;

import java.util.Optional;

public class LogInPresenter {
    private LogInViewInterface logInViewInterface;
    private UserService userService;

    public LogInPresenter(LogInViewInterface logInViewInterface){
        this.logInViewInterface = logInViewInterface;
        this.userService = new UserService();
    }


    public void logInUser() {
        String email = logInViewInterface.getEmail();
        String password = logInViewInterface.getPassword();
        Optional<Users> user = userService.getUserByEmail(email);
        if (user.isPresent()) {
            Users account = user.get();
            if (account.getPassword().equals(password)) {
                if (account.isEnabled()) {
                    if (account.getUserType().toString().equals("EMPLOYEE")) {
                        EmployeeView employeeView = new EmployeeView();
                    }
                    if (account.getUserType().toString().equals("ADMINISTRATOR")) {
                        AdministratorView administratorView = new AdministratorView();
                    }
                    logInViewInterface.dispose();
                } else {
                    logInViewInterface.showError("This account has not been enabled by an administrator!");
                }
            } else {
                logInViewInterface.showError("Wrong password!");
            }
        } else {
            logInViewInterface.showError("No user is registered with this email!");
        }
    }

    public void initiateVisitorPresenter() {
        VisitorView visitorView = new VisitorView();
    }
}
