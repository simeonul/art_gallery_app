package views.interfaces;


public interface SignUpViewInterface {
    String getEmail();
    String getPassword();
    String getPhone();
    String getAddress();
    String getType();
    void showError(String errorMessage);
}
