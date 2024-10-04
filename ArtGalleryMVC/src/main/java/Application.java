
import controllers.*;
import models.services.TranslationService;

public class Application {

    public static void main(String[] args) {
        VisitorController visitorController = new VisitorController();
        EmployeeController employeeController = new EmployeeController();
        AdministratorController administratorController = new AdministratorController();
        SignUpController signUpController = new SignUpController();
        LogInController logInController = new LogInController();

        visitorController.addTies(signUpController, logInController);
        logInController.addTies(visitorController, employeeController, administratorController);
        signUpController.addTies(visitorController);
        employeeController.addTies(logInController);
        administratorController.addTies(logInController);

        TranslationService translationService = new TranslationService("english");
        translationService.add(employeeController);
        translationService.add(visitorController);
        translationService.add(administratorController);
        translationService.add(signUpController);
        translationService.add(logInController);
        visitorController.setTranslationService(translationService);
    }
}
