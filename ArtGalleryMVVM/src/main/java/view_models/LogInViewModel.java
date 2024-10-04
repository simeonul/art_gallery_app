package view_models;

import net.sds.mvvm.properties.Property;
import net.sds.mvvm.properties.PropertyFactory;
import view_models.login_commands.InitiateAdministratorViewCommand;
import view_models.login_commands.InitiateEmployeeViewCommand;
import view_models.login_commands.LogInCommand;
import view_models.login_commands.InitiateVisitorViewCommand;

public class LogInViewModel {
    private Property<String> email;
    private Property<String> password;

    public CommandsInterface logInCommand;
    public CommandsInterface initiateEmployeeViewCommand;
    public CommandsInterface initiateAdministratorViewCommand;
    public CommandsInterface initiateVisitorViewCommand;

    public LogInViewModel(){
        email = PropertyFactory.createProperty("email", this, String.class);
        password = PropertyFactory.createProperty("password", this, String.class);

        logInCommand = new LogInCommand(this);
        initiateEmployeeViewCommand = new InitiateEmployeeViewCommand(this);
        initiateAdministratorViewCommand = new InitiateAdministratorViewCommand(this);
        initiateVisitorViewCommand = new InitiateVisitorViewCommand(this);
    }

    public String getEmail() {
        return email.get();
    }

    public String getPassword() {
        return password.get();
    }
}
