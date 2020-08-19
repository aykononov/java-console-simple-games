/* Консольная игра "Крестики нолики" размером поля 3х3.
   Два пользователя по очереди вводят цифры от 1 до 9 и 0 для прерывания и выхода из игры.
   Тот игрок, у которого будет три одинаковых символа в одной линии, станет победителем.
   В простом варианте можно проверять совпадение только в горизонтальных линиях, но у нас
   более сложный. Проверять нужно горизонтальные линии, вертикальные и по диагонали.
*/
import java.util.Arrays;
import java.util.Scanner;
class KrestikiNoliki {
    // Метод вывода поля 3x3 на экран
    static void show (char[] field) {
        for (int i = 0; i < field.length; i++) {
            System.out.print(field[i] + " ");
            if ((i + 1) % (field.length / 3) == 0) {
                System.out.println();
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("Консольная игра Крестики нолики.");
        final int ROW_SIZE = 3; // задаем размер поля
        char[]field = new char[ROW_SIZE * ROW_SIZE];
        Arrays.fill(field, '-'); // заполняем массив специальным библиотечным методом
        show(field);
        Scanner scanner = new Scanner(System.in);
        int userInput = -1;
        do {
            while (!(userInput >= 1 && userInput <= field.length && field[userInput -1 ] == 'x' || userInput == 0)) {
                System.out.print("\n1 игрок (X). \nВаш ход, введите от 1 до 9 (0 - выход): ");
                while (true) { 
                    if (scanner.hasNextInt()) { // проверка ввода цифр
                        userInput = scanner.nextInt();
                        scanner.nextLine(); // считываем оставшиеся символы
                        break;
                    } else {
                        String temp = scanner.nextLine(); // очистка кеша
                        System.out.print("(X) Введите от 1 до 9 (0 - выход): "); 
                    }
                }
                if (userInput >= 1 && userInput <= field.length && field[userInput -1 ] == '-') {
                    field[userInput -1 ] = 'x';
                    show(field); 
                }
                // Проверяем горизонтальные линии, вертикальные и по диагонали.
                if (   (field[0] == field[1] && field[1] == field[2] && field[0] == field[2] && field[0] == 'x')
                    || (field[3] == field[4] && field[4] == field[5] && field[3] == field[5] && field[3] == 'x')
                    || (field[6] == field[7] && field[7] == field[8] && field[6] == field[8] && field[6] == 'x')
                    || (field[0] == field[3] && field[3] == field[6] && field[3] == field[6] && field[0] == 'x')
                    || (field[1] == field[4] && field[4] == field[7] && field[1] == field[7] && field[1] == 'x')
                    || (field[2] == field[5] && field[5] == field[8] && field[2] == field[8] && field[2] == 'x')
                    || (field[0] == field[4] && field[4] == field[8] && field[0] == field[8] && field[0] == 'x')
                    || (field[2] == field[4] && field[4] == field[6] && field[2] == field[6] && field[2] == 'x') ) {
                    System.out.println("ОТЛИЧО!!! Выиграл 1 игрок (X)");
                    userInput = 0;
                } else if (field[0] != '-' && field[1] != '-' && field[2] != '-' &&
                        field[3] != '-' && field[4] != '-' && field[5] != '-' &&
                        field[6] != '-' && field[7] != '-' && field[8] != '-') {
                    System.out.println("\nХоды закончились - Никто не выиграл.");
                    userInput = 0;
                }
            }

            while (!(userInput >= 1 && userInput <= field.length && field[userInput -1 ] == 'o' || userInput == 0)) {
                System.out.print("\n2 игрок (O). \nВаш ход, введите от 1 до 9 (0 - выход): ");
                while (true) { 
                    if (scanner.hasNextInt()) { // проверка ввода цифр
                        userInput = scanner.nextInt();
                        scanner.nextLine(); // считываем оставшиеся символы
                        break;
                    } else {
                        String temp = scanner.nextLine(); // очистка кеша
                        System.out.println("(O). Введите от 1 до 9 (0 - выход): "); 
                    }
                }
                
                if (userInput >= 1 && userInput <= field.length && field[userInput -1 ] == '-') {
                    field[userInput -1 ] = 'o';
                    show(field); 
                }
                // Проверяем горизонтальные линии, вертикальные и по диагонали.
                if (   (field[0] == field[1] && field[1] == field[2] && field[0] == field[2] && field[0] == 'o')
                    || (field[3] == field[4] && field[4] == field[5] && field[3] == field[5] && field[3] == 'o')
                    || (field[6] == field[7] && field[7] == field[8] && field[6] == field[8] && field[6] == 'o')
                    || (field[0] == field[3] && field[3] == field[6] && field[3] == field[6] && field[0] == 'o')
                    || (field[1] == field[4] && field[4] == field[7] && field[1] == field[7] && field[1] == 'o')
                    || (field[2] == field[5] && field[5] == field[8] && field[2] == field[8] && field[2] == 'o')
                    || (field[0] == field[4] && field[4] == field[8] && field[0] == field[8] && field[0] == 'o')
                    || (field[2] == field[4] && field[4] == field[6] && field[2] == field[6] && field[2] == 'o') ) {
                    System.out.println("ОТЛИЧО!!! Выиграл 2 игрок (O)");
                    userInput = 0;
                } else if (field[0] != '-' && field[1] != '-' && field[2] != '-' &&
                           field[3] != '-' && field[4] != '-' && field[5] != '-' &&
                           field[6] != '-' && field[7] != '-' && field[8] != '-') {
                    System.out.println("\nХоды закончились - Никто не выиграл.");
                    userInput = 0;
                }
            }

            if (userInput == 0) {
                System.out.println("\nВыход из игры.");
                scanner.close();
                break;
            }
        } while (true);
    }    
}
/* --------------------------------------
Консольная игра Крестики нолики.
- - -
- - -
- - -

1 игрок (X).
Ваш ход, введите от 1 до 9 (0 - выход): 1
x - -
- - -
- - -

2 игрок (O).
Ваш ход, введите от 1 до 9 (0 - выход): 2
x o -
- - -
- - -

1 игрок (X).
Ваш ход, введите от 1 до 9 (0 - выход): 3
x o x
- - -
- - -

2 игрок (O).
Ваш ход, введите от 1 до 9 (0 - выход): 5
x o x
- o -
- - -

1 игрок (X).
Ваш ход, введите от 1 до 9 (0 - выход): 8
x o x
- o -
- x -

2 игрок (O).
Ваш ход, введите от 1 до 9 (0 - выход): 4
x o x
o o -
- x -

1 игрок (X).
Ваш ход, введите от 1 до 9 (0 - выход): 6
x o x
o o x
- x -

2 игрок (O).
Ваш ход, введите от 1 до 9 (0 - выход): 9
x o x
o o x
- x o

1 игрок (X).
Ваш ход, введите от 1 до 9 (0 - выход): 8

2 игрок (O).
Ваш ход, введите от 1 до 9 (0 - выход): 7
x o x
o o x
o x o

Ходы закончились - Никто не выиграл.

Выход из игры.
 */