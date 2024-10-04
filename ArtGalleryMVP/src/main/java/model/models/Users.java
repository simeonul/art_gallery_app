package model.models;

import model.models.enums.UserType;

public class Users {
    private int id;
    private String email;
    private String password;
    private UserType userType;
    private String phone;
    private String address;
    private boolean isEnabled;


    public Users(String email, String password, String phone, String address, UserType userType, boolean isEnabled) {
        this.email = email;
        this.password = password;
        this.userType = userType;
        this.phone = phone;
        this.address = address;
        this.isEnabled = isEnabled;
    }

    public Users() {
    }

    public Users(int id, String email, String password, String phone, String address, UserType userType, Boolean isEnabled) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.userType = userType;
        this.phone = phone;
        this.address = address;
        this.isEnabled = isEnabled;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserType getUserType() {
        return userType;
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public boolean isEnabled() {
        return isEnabled;
    }

    public void setEnabled(boolean enabled) {
        isEnabled = enabled;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", userType=" + userType +
                ", phone=" + phone +
                ", address=" + address +
                ", isEnabled=" + isEnabled +
                '}';
    }

    public String toQueryString(){
        return  "(" + "'" + email + "','" + password + "','" + phone +  "','" + address + "','" +
                userType +  "','" + isEnabled + "')";
    }
    public String toUpdateQueryString() {
        return  "email='" +  email + "', password='" + password + "', phone='" + phone +
                "', address='" + address + "', user_type='" + userType + "', is_enabled=" + isEnabled;
    }
}
