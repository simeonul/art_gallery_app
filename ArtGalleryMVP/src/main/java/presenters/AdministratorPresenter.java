package presenters;

import model.models.ArtPieceArtist;
import model.models.Users;
import model.models.enums.UserType;
import model.services.ArtService;
import model.services.UserService;
import views.LogInView;
import views.interfaces.AdministratorViewInterface;

import javax.swing.table.DefaultTableModel;
import java.util.List;

public class AdministratorPresenter {
    private AdministratorViewInterface administratorViewInterface;
    private UserService userService;
    private ArtService artService;
    private int selectedRowUser;


    public AdministratorPresenter(AdministratorViewInterface administratorViewInterface){
        this.administratorViewInterface = administratorViewInterface;
        this.userService = new UserService();
        this.artService = new ArtService();
    }


    private String capitalizeEnum(String input){
        return input.substring(0, 1).toUpperCase() + input.substring(1).toLowerCase();
    }

    private void getArtPieceArtistRowValues(Object[] rowData, ArtPieceArtist artPieceArtist){
        rowData[0] = artPieceArtist.getId();
        rowData[1] = artPieceArtist.getTitle();
        rowData[2] = artPieceArtist.getArtistName();
        rowData[3] = capitalizeEnum(artPieceArtist.getArtForm().toString());
        rowData[4] = artPieceArtist.getYear();
        float price = artPieceArtist.getPrice();
        rowData[5] = price != 0 ? price : "Unknown";
    }

    private void populateArtPieceArtistTable(List<ArtPieceArtist> artPieceArtistList){
        Object[] rowData = new Object[6];
        DefaultTableModel model = administratorViewInterface.getArtPieceArtistModel();
        model.setRowCount(0);
        for(ArtPieceArtist artPieceArtist : artPieceArtistList){
            getArtPieceArtistRowValues(rowData, artPieceArtist);
            model.addRow(rowData);
        }
        administratorViewInterface.setArtPieceArtistModel(model);
    }

    public void getAllArtPieceArtist(){
        List<ArtPieceArtist> artPieceArtistList = artService.getAllArtPieceArtist();
        populateArtPieceArtistTable(artPieceArtistList);
    }

    public void sortArtPieceArtistByYear(){
        List<ArtPieceArtist> artPieceArtistList = artService.sortArtPieceArtistByYear();
        populateArtPieceArtistTable(artPieceArtistList);
    }

    public void filterArtPieceArtistByArtistForm() {
        String artist = administratorViewInterface.getArtist();
        String artForm = administratorViewInterface.getArtForm();
        List<ArtPieceArtist> artPieceArtistList = artService.filterArtPieceArtistByArtistForm(artist, artForm);
        populateArtPieceArtistTable(artPieceArtistList);
    }

    public void getAllUsers() {
        List<Users> users = userService.getAllUsers();
        populateUserTable(users);
    }

    private void populateUserTable(List<Users> users){
        Object[] rowData = new Object[7];
        DefaultTableModel userModel = administratorViewInterface.getUserModel();
        userModel.setRowCount(0);
        for(Users user : users){
            getUserRowValues(rowData, user);
            userModel.addRow(rowData);
        }
        administratorViewInterface.setUserModel(userModel);
    }

    private void getUserRowValues(Object[] rowData, Users user){
        rowData[0] = user.getId();
        rowData[1] = user.getEmail();
        rowData[2] = user.getPassword();
        rowData[3] = user.getPhone();
        rowData[4] = user.getAddress();
        rowData[5] = capitalizeEnum(user.getUserType().toString());
        rowData[6] = user.isEnabled();
    }

    public void populateUserFields() {
        DefaultTableModel model = administratorViewInterface.getUserModel();
        selectedRowUser = administratorViewInterface.getRow();
        administratorViewInterface.setEmailTxtField(model.getValueAt(selectedRowUser, 1).toString());
        administratorViewInterface.setPasswordTxtField(model.getValueAt(selectedRowUser, 2).toString());
        administratorViewInterface.setPhoneTxtField(model.getValueAt(selectedRowUser, 3).toString());
        administratorViewInterface.setAddressTxtField(model.getValueAt(selectedRowUser, 4).toString());
        administratorViewInterface.setTypeTxtField(model.getValueAt(selectedRowUser, 5).toString());
        administratorViewInterface.setEnabledTxtField(model.getValueAt(selectedRowUser, 6).toString());
    }

    private boolean isValidInput() {
        String email = administratorViewInterface.getEmail();
        String password = administratorViewInterface.getPassword();
        String phone = administratorViewInterface.getPhone();
        String address = administratorViewInterface.getAddress();
        if(!email.isEmpty() && !password.isEmpty() && !phone.isEmpty() && !address.isEmpty()){
            return true;
        }else{
            administratorViewInterface.showError("Please complete all necessary fields!");
            return false;
        }
    }

    private Users createUser(){
        String email = administratorViewInterface.getEmail();
        String password = administratorViewInterface.getPassword();
        String phone = administratorViewInterface.getPhone();
        String address = administratorViewInterface.getAddress();
        UserType userType = Enum.valueOf(UserType.class, administratorViewInterface.getType().toUpperCase());
        Boolean isEnabled = Boolean.parseBoolean(administratorViewInterface.getEnabled());
        return new Users(email, password, phone, address, userType, isEnabled);
    }

    public void addUser() {
        if(isValidInput()){
            userService.addUser(createUser());
            getAllUsers();
        }
    }

    public void updateUser() {
        selectedRowUser = administratorViewInterface.getRow();
        int id = (int)administratorViewInterface.getUserModel().getValueAt(selectedRowUser, 0);
        userService.updateUser(id, createUser());
        getAllUsers();
    }

    public void deleteUser() {
        selectedRowUser = administratorViewInterface.getRow();
        int id = (int)administratorViewInterface.getUserModel().getValueAt(selectedRowUser, 0);
        userService.deleteUser(id);
        getAllUsers();
    }

    public void initiateLogInView() {
        LogInView logInView = new LogInView();
    }

}
