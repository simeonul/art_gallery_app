package view_models.signup_commands;

import models.model.Users;
import models.model.enums.UserType;
import models.services.UserService;
import view_models.CommandsInterface;
import view_models.SignUpViewModel;
import views.SignUpView;

import java.util.Locale;

public class SignUpCommand implements CommandsInterface {
    private SignUpViewModel signUpViewModel;
    private UserService userService;

    public SignUpCommand(SignUpViewModel signUpViewModel){
        this.signUpViewModel = signUpViewModel;
        this.userService = new UserService();
    }

    private Users createUser(){
        String email = signUpViewModel.getEmail();
        String password = signUpViewModel.getPassword();
        String phone = signUpViewModel.getPhone();
        String address = signUpViewModel.getAddress();
        UserType userType = Enum.valueOf(UserType.class, signUpViewModel.getType().toUpperCase(Locale.ROOT));
        return new Users(email, password, phone, address, userType, false);
    }

    public void addUser() {
        if(isValidInput()){
            userService.addUser(createUser());
        }
    }

    private boolean isValidInput() {
        String email = signUpViewModel.getEmail();
        String password = signUpViewModel.getPassword();
        String phone = signUpViewModel.getPhone();
        String address = signUpViewModel.getAddress();
        if(!email.isEmpty() && !password.isEmpty() && !phone.isEmpty() && !address.isEmpty()){
            return true;
        }else{
            SignUpView.showMessage("Please complete all necessary fields!");
            return false;
        }
    }

    @Override
    public void execute() {
        if(isValidInput()){
            userService.addUser(createUser());
        }
    }
}
