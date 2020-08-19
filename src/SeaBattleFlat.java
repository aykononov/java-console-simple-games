import java.util.Scanner;

class SeaBattleFlat {
    static int FIELD_SIZE = 10;
    public static void main(String[] args) {
        int FIELD_SIZE = 10;
        System.out.println("Игра - Линейный морской бой\n");
        doGame();
    }
    static void doGame() {
        char[] cells = new char[FIELD_SIZE];
        for (int i = 0; i < cells.length; i++) {
            cells[i] = '.'; 
        }
        int dead = 4; // палубность корабля 
        int shipPosition = (int) (0 + Math.random() * (FIELD_SIZE - 3)); // позиция корабля /// заменил
        for (int i = 0; i < dead; i++) {
            cells[shipPosition++] = '#'; // помещаем сам корабль 
        }
        Scanner scanner = new Scanner(System.in);
        int shootInput;
        // Главный цикл игры
        do {
            System.out.println(cells);
            System.out.print("\nСтреляйте (введите от 0 до 9): ");
            // Конструкция выстрела
            while (true) {
                if (scanner.hasNextInt()) { // проверяем, что введена цифра
                    shootInput = scanner.nextInt();
                    scanner.nextLine(); 
                    if (shootInput >= 0 && shootInput <= cells.length) { // проверяем, что число от 0 до 9
                        break;
                    } else { // иначе ошибка
                        System.out.print("\nОшибка, слишком большое число (нужно ввести от 0 до 9): ");
                    }
                } else { // иначе введена буква
                    scanner.nextLine(); // очистка кеша 
                    System.out.print("\nОшибка ввода символа (нужно ввести число от 0 до 9): ");
                }
            }
            // Проверка попадания
            switch (cells[shootInput]) {
                case '.':
                    System.out.println("Выстрел в сектор " + shootInput + ": Промах");
                    cells[shootInput] = '*';
                    break;
                case '#':
                    System.out.println("Выстрел в сектор " + shootInput + ": Попал!!!");
                    cells[shootInput] = 'x';
                    dead--;
                    break;
                case '*':
                    System.out.println("Выстрел в сектор " + shootInput + ": уже стреляли...");
                    break;
                case 'x':
                    System.out.println("Выстрел в сектор " + shootInput + ": уже попадали...");
                    break;
            }
        } while (dead != 0);
        System.out.println(cells);
        System.out.println("\nКонец игры.\nКорабль потоплен!!!\n");
    }
}
/*
Игра - Линейный морской бой

......####

Стреляйте (введите от 0 до 9): 1
Выстрел в сектор 1: Промах
.*....####

Стреляйте (введите от 0 до 9): 1
Выстрел в сектор 1: уже стреляли...
.*....####

Стреляйте (введите от 0 до 9): 6
Выстрел в сектор 6: Попал!!!
.*....x###

Стреляйте (введите от 0 до 9): 6
Выстрел в сектор 6: уже попадали...
.*....x###

Стреляйте (введите от 0 до 9): 7
Выстрел в сектор 7: Попал!!!
.*....xx##

Стреляйте (введите от 0 до 9): 8
Выстрел в сектор 8: Попал!!!
.*....xxx#

Стреляйте (введите от 0 до 9): 9
Выстрел в сектор 9: Попал!!!
.*....xxxx

Конец игры.
Корабль потоплен!!!
 */