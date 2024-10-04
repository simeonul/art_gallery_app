package views.interfaces;

import javax.swing.*;

public interface LogInViewInterface {
    String getEmail();
    String getPassword();
    void showError(String errorMessage);
    void dispose();
}
