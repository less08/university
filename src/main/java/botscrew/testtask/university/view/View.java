package botscrew.testtask.university.view;

import botscrew.testtask.university.controller.Controller;
import java.util.Scanner;
import lombok.AllArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class View {
    private final Scanner scanner = new Scanner(System.in);
    private final ApplicationContext context;
    private final Controller controller;

    public void start() {
        while (true) {
            showMainMenu();
            executeCommand(readMenuCommand());
        }
    }

    private void showMainMenu() {
        System.out.println("Select one of following options \n"
                + "1. Who is head of department \n"
                + "2. Show department statistics \n"
                + "3. Show the average salary for the department\n"
                + "4. Show count of employee for the department\n"
                + "5. Global search by template\n\n"
                + "6. Exit ");
    }

    private String readMenuCommand() {
        String command = null;
        if (scanner.hasNext()) {
            command = scanner.nextLine();
        }
        return command;
    }

    private void executeCommand(String command) {
        try {
            int number = Integer.parseInt(command);
            switch (number) {
                case 1:
                    findHeadOfDepartment();
                    break;
                case 2:
                    showStatistics();
                    break;
                case 3:
                    showAverageSalary();
                    break;
                case 4:
                    showEmployeeCount();
                    break;
                case 5:
                    searchByTemplate();
                    break;
                case 6:
                    finishApplication();
                    break;
                default:
                    showInvalidCommandMessage();
            }
        } catch (NumberFormatException e) {
            showInvalidCommandMessage();
        }
    }

    private void findHeadOfDepartment() {
        System.out.println("Input department name?");
        String template = "Head of %s department is %s";
        if (scanner.hasNext()) {
            String department = scanner.nextLine();
            String result = controller.getHeadOfDepartment(department);
            System.out.println(String.format(template, department, result));
        }
    }

    private void showStatistics() {
        System.out.println("Input department name?");
        if (scanner.hasNext()) {
            String result = controller.getStatistics(scanner.nextLine());
            System.out.println(result);
        }
    }

    private void showAverageSalary() {
        System.out.println("Input department name?");
        String template = "The average salary of %s is %s";
        if (scanner.hasNext()) {
            String department = scanner.nextLine();
            String result = controller.getAverageSalary(department);
            System.out.println(String.format(template, department, result));
        }
    }

    private void showEmployeeCount() {
        System.out.println("Input department name?");
        if (scanner.hasNext()) {
            String result = controller.getEmployeeCount(scanner.nextLine());
            System.out.println(result);
        }
    }

    private void searchByTemplate() {
        System.out.println("Input template");
        if (scanner.hasNext()) {
            String result = controller.getByTemplate(scanner.nextLine());
            System.out.println(result);
        }
    }

    private void showInvalidCommandMessage() {
        System.out.println("Invalid command try again.\n "
                + "Your input should be a number of command");
    }

    private void finishApplication() {
        int code = SpringApplication.exit(context);
        System.exit(code);
    }
}
