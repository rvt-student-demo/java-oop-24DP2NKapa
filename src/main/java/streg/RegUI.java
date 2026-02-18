package streg;

import java.util.Scanner;

public class RegUI {
    private final Registrate registrate = new Registrate();
    private final Scanner scanner = new Scanner(System.in);

    public void start() {
        System.out.println(
            """
            Commands:\n\n
            help\n\n
            register\n
            show\n
            remove\n
            edit\n
            exit\n
            """
        );
        while (true) {
            System.out.println("Command:");
            String command = scanner.nextLine();
            if (command.equals("register")) {
                registrate.register();
                continue;
            } else if (command.equals("show")) {
                registrate.show();
                continue;
            } else if (command.equals("remove")) {
                registrate.remove();
                continue;
            } else if (command.equals("edit")) {
                registrate.edit();
                continue;
            } else if (command.equals("exit")) {
                break;
            } else if (command.equals("help")) {
                System.out.println(
                """
                Commands:\n
                help\n
                register
                show
                remove
                edit
                exit
                """
        );
            } else {
                System.out.println("Invalid command.");
            }
        }
    }
}
