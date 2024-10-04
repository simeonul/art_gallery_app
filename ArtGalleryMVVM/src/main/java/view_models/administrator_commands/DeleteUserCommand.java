package view_models.administrator_commands;

import models.services.UserService;
import view_models.AdministratorViewModel;
import view_models.CommandsInterface;

public class DeleteUserCommand implements CommandsInterface {
    private AdministratorViewModel viewModel;
    private UserService userService;

    public DeleteUserCommand(AdministratorViewModel viewModel) {
        this.viewModel = viewModel;
        this.userService = new UserService();
    }

    @Override
    public void execute() {
        int selectedRowUser = viewModel.getRowUser();
        if (selectedRowUser > -1) {
            int id = Integer.parseInt(String.valueOf(viewModel.getUserModel().getValueAt(selectedRowUser, 0)));
            userService.deleteUser(id);
            viewModel.getAllUserCommand.execute();
        }

    }
}
