package presenters;

import model.models.Users;
import model.models.enums.UserType;
import model.services.UserService;
import views.VisitorView;
import views.interfaces.SignUpViewInterface;

import java.util.Locale;

public class SignUpPresenter {

    private SignUpViewInterface signUpViewInterface;
    private UserService userService;

    public SignUpPresenter(SignUpViewInterface signUpViewInterface){
        this.signUpViewInterface = signUpViewInterface;
        this.userService = new UserService();
    }


    private Users createUser(){
        String email = signUpViewInterface.getEmail();
        String password = signUpViewInterface.getPassword();
        String phone = signUpViewInterface.getPhone();
        String address = signUpViewInterface.getAddress();
        UserType userType = Enum.valueOf(UserType.class, signUpViewInterface.getType().toUpperCase(Locale.ROOT));
        return new Users(email, password, phone, address, userType, false);
    }

    public void addUser() {
        if(isValidInput()){
            userService.addUser(createUser());
        }
    }

    private boolean isValidInput() {
        String email = signUpViewInterface.getEmail();
        String password = signUpViewInterface.getPassword();
        String phone = signUpViewInterface.getPhone();
        String address = signUpViewInterface.getAddress();
        if(!email.isEmpty() && !password.isEmpty() && !phone.isEmpty() && !address.isEmpty()){
            return true;
        }else{
            signUpViewInterface.showError("Please complete all necessary fields!");
            return false;
        }
    }

    public void initiateVisitorPresenter() {
        VisitorView visitorView = new VisitorView();
    }

}
