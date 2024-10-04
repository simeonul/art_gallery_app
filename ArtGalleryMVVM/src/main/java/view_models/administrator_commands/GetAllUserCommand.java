package view_models.administrator_commands;

import models.model.ArtPieceArtist;
import models.model.Users;
import models.services.ArtService;
import models.services.UserService;
import view_models.AdministratorViewModel;
import view_models.CommandsInterface;

import javax.swing.table.DefaultTableModel;
import java.util.List;

public class GetAllUserCommand implements CommandsInterface {
    private AdministratorViewModel viewModel;
    private UserService userService;

    public GetAllUserCommand(AdministratorViewModel viewModel) {
        this.viewModel = viewModel;
        this.userService = new UserService();
    }

    private String capitalizeEnum(String input){
        return input.substring(0, 1).toUpperCase() + input.substring(1).toLowerCase();
    }


    @Override
    public void execute() {
        Object[] columns = new Object[]{"Id", "Email", "Password", "Phone", "Address", "Type", "Enabled"};;
        int rowIndex = 0;
        List<Users> users = userService.getAllUsers();
        int noRows = users.size();
        Object [][] data = new Object[noRows][7];
        for (Users user: users)
        {
            data[rowIndex][0] = String.valueOf(user.getId());
            data[rowIndex][1] = user.getEmail();
            data[rowIndex][2] = user.getPassword();
            data[rowIndex][3] = user.getPhone();
            data[rowIndex][4] = user.getAddress();
            data[rowIndex][5] = capitalizeEnum(String.valueOf(user.getUserType()));
            data[rowIndex][6] = capitalizeEnum(String.valueOf(user.isEnabled()));

            rowIndex++;
        }
        DefaultTableModel defaultTableModel = new DefaultTableModel(data, columns);
        viewModel.setUserModel(defaultTableModel);
    }
}
