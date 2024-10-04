package view_models.administrator_commands;

import models.model.Users;
import models.model.enums.UserType;
import models.services.UserService;
import view_models.AdministratorViewModel;
import view_models.CommandsInterface;
import views.AdministratorView;
import views.EmployeeView;

public class UpdateUserCommand implements CommandsInterface {
    private AdministratorViewModel viewModel;
    private UserService userService;

    public UpdateUserCommand(AdministratorViewModel viewModel) {
        this.viewModel = viewModel;
        this.userService = new UserService();
    }

    private boolean isValidInput() {
        String email = viewModel.getEmail();
        String password = viewModel.getPassword();
        String phone = viewModel.getPhone();
        String address = viewModel.getAddress();
        if(!email.isEmpty() && !password.isEmpty() && !phone.isEmpty() && !address.isEmpty()){
            return true;
        }else{
            AdministratorView.showMessage("Please complete all necessary fields!");
            return false;
        }
    }

    private Users createUser(){
        String email = viewModel.getEmail();
        String password = viewModel.getPassword();
        String phone = viewModel.getPhone();
        String address = viewModel.getAddress();
        UserType userType = Enum.valueOf(UserType.class, viewModel.getType().toUpperCase());
        Boolean isEnabled = Boolean.parseBoolean(viewModel.getEnabled());
        return new Users(email, password, phone, address, userType, isEnabled);
    }

    @Override
    public void execute() {
        int selectedRowUser = viewModel.getRowUser();
        if (selectedRowUser > -1) {
            int id = Integer.parseInt(String.valueOf(viewModel.getUserModel().getValueAt(selectedRowUser, 0)));
            if (isValidInput()) {
                userService.updateUser(id, createUser());
                viewModel.getAllUserCommand.execute();
            }
        }
    }
}
