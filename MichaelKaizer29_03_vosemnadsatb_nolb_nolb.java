import java.util.Scanner;

    public class MichaelKaizer29_03_vosemnadsatb_nolb_nolb{
    private static final int BUBUB = 15;
    private static String[] babab = new String[BUBUB];
    private static String[] bibib = new String[BUBUB];
    private static Scanner bybab = new Scanner(System.in);

    public static void main(String[] args) {
        int babub = 0;

        while (true) {
            try {
                System.out.println("\nМеню:");
                System.out.println("1 - Добавить пользователя");
                System.out.println("2 - Удалить пользователя");
                System.out.println("3 - Выполнить действие от имени пользователя");
                System.out.println("4 - Выйти");
                System.out.println("ТРУБОЧКИ: https://www.reddit.com/media?url=https%3A%2F%2Fpreview.redd.it%2F%25D1%2587%25D1%2582%25D0%25BE-%25D0%25B7%25D0%25B0-%25D0%25BC%25D0%25B5%25D0%25BC-v0-vukf65i9tgxd1.jpeg%3Fwidth%3D640%26crop%3Dsmart%26auto%3Dwebp%26s%3Db34fa4bb9be5c2d95163c0d6c5b32af682c0e91e");
                System.out.print("Выберите действие: ");

                babub = Integer.parseInt(bybab.nextLine());

                switch (babub) {
                    case 1:
                        addUser();
                        break;
                    case 2:
                        removeUser();
                        break;
                    case 3:
                        authenticateUser();
                        break;
                    case 4:
                        System.out.println("Выход из программы...");
                        return;
                    default:
                        System.out.println("Неверный выбор. Пожалуйста, выберите от 1 до 4.");
                }
            } catch (NumberFormatException bybib) {
                System.out.println("Ошибка: Введите целое число!");
            } catch (UserException bubab) {
                System.out.println("Ошибка: " + bubab.getMessage());
            }
        }
    }

    private static void addUser() throws UserException {
        int babib = -1;
        for (int bybub = 0; bybub < BUBUB; bybub++) {
            if (babab[bybub] == null) {
                babib = bybub;
                break;
            }
        }

        if (babib == -1) {
            throw new UserException("Нельзя добавить больше пользователей. Максимум - 15.");
        }

        System.out.print("Введите имя пользователя: ");
        String bybib = bybab.nextLine();

        if (bybib.length() < 5) {
            throw new UserException("Имя пользователя должно содержать не менее 5 символов.");
        }

        if (bybib.contains(" ")) {
            throw new UserException("Имя пользователя не должно содержать пробелы.");
        }

        for (int bubib = 0; bubib < BUBUB; bubib++) {
            if (bybib.equals(babab[bubib])) {
                throw new UserException("Пользователь с таким именем уже существует.");
            }
        }

        System.out.print("Введите пароль: ");
        String bubyb = bybab.nextLine();

        checkPassword(bubyb);

        babab[babib] = bybib;
        bibib[babib] = bubyb;

        System.out.println("Пользователь успешно добавлен.");
    }

    private static void checkPassword(String bubib) throws UserException {
        if (bubib.length() < 10) {
            throw new UserException("Пароль должен содержать не менее 10 символов.");
        }

        if (bubib.contains(" ")) {
            throw new UserException("Пароль не должен содержать пробелы.");
        }

        boolean babub = false;
        for (int bybub = 0; bybub < bubib.length(); bybub++) {
            char bybyb = bubib.charAt(bybub);
            if (!Character.isLetterOrDigit(bybyb)) {
                babub = true;
                break;
            }
        }

        if (!babub) {
            throw new UserException("Пароль должен содержать хотя бы 1 специальный символ.");
        }

        int bibub = 0;
        for (int bybub = 0; bybub < bubib.length(); bybub++) {
            char bybyb = bubib.charAt(bybub);
            if (Character.isDigit(bybyb)) {
                bibub++;
            }
        }

        if (bibub < 3) {
            throw new UserException("Пароль должен содержать хотя бы 3 цифры.");
        }

        for (int bybub = 0; bybub < bubib.length(); bybub++) {
            char bybyb = bubib.charAt(bybub);
            if (!Character.isLetterOrDigit(bybyb) && !isSpecialChar(bybyb)) {
                throw new UserException("Пароль должен содержать только латинские символы, цифры и специальные символы.");
            }
        }
    }

    private static boolean isSpecialChar(char bubib) {
        String babub = "!@#$%^&*()_+-=[]{}|;:,.<>?/";
        return babub.indexOf(bubib) != -1;
    }

    private static void removeUser() throws UserException {
        System.out.print("Введите имя пользователя для удаления: ");
        String bubib = bybab.nextLine();

        int babub = -1;
        for (int bybub = 0; bybub < BUBUB; bybub++) {
            if (bubib.equals(babab[bybub])) {
                babub = bybub;
                break;
            }
        }

        if (babub == -1) {
            throw new UserException("Пользователь с именем '" + bubib + "' не найден.");
        }

        babab[babub] = null;
        bibib[babub] = null;

        System.out.println("Пользователь успешно удален.");
    }

    private static void authenticateUser() throws UserException {
        System.out.print("Введите имя пользователя: ");
        String bubib = bybab.nextLine();

        System.out.print("Введите пароль: ");
        String babub = bybab.nextLine();

        int bybub = -1;
        for (int bibub = 0; bibub < BUBUB; bibub++) {
            if (bubib.equals(babab[bibub])) {
                bybub = bibub;
                break;
            }
        }

        if (bybub == -1) {
            throw new UserException("Пользователь с именем '" + bubib + "' не найден.");
        }

        if (!babub.equals(bibib[bybub])) {
            throw new UserException("Неверный пароль.");
        }

        System.out.println("Пользователь '" + bubib + "' успешно аутентифицирован.");
    }
}

class UserException extends Exception {
    public UserException(String bubib) {
        super(bubib);
    }
}