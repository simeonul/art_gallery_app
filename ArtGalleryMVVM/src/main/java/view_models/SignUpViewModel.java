package view_models;

import models.model.enums.UserType;
import net.sds.mvvm.properties.Property;
import net.sds.mvvm.properties.PropertyFactory;
import view_models.signup_commands.InitiateVisitorViewCommand;
import view_models.signup_commands.SignUpCommand;

public class SignUpViewModel {
    private Property<String> email;
    private Property<String> password;
    private Property<String> phone;
    private Property<String> address;
    private Property<UserType> type;

    public CommandsInterface signUpCommand;
    public CommandsInterface initiateVisitorViewCommand;

    public SignUpViewModel(){
        email = PropertyFactory.createProperty("email", this, String.class);
        password = PropertyFactory.createProperty("password", this, String.class);
        phone = PropertyFactory.createProperty("phone", this, String.class);
        address = PropertyFactory.createProperty("address", this, String.class);
        type = PropertyFactory.createProperty("type", this, UserType.class);

        signUpCommand =  new SignUpCommand(this);
        initiateVisitorViewCommand = new InitiateVisitorViewCommand(this);
    }

    public String getEmail() {
        return email.get();
    }

    public String getPassword() {
        return password.get();
    }

    public String getPhone() {
        return phone.get();
    }

    public String getAddress() {
        return address.get();
    }

    public String getType() {
        return type.get().toString();
    }
}
