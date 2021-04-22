package hw_01_2;

import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        Logger logger = Logger.getInstance();
        Scanner sc = new Scanner(System.in);
        logger.log("Запускаем программу");
        logger.log("Просим пользователя ввести входные данные для списка\n" +
                "Введите размер списка:");
        int listLength = sc.nextInt();
        logger.log("Введите верхнюю границу для значений: ");
        int maxValue = sc.nextInt();

        List<Integer> list = getRandomList(listLength, maxValue);
        logger.log("Вот случайный список: " + list);
        logger.log("Просим пользователя ввести входные данные для фильтрации\n" +
                "Введите порог для фильтра:");

        int treshold = sc.nextInt();
        Filter filter = new Filter(treshold);
        logger.log("Запускаем фильтрацию");
        List<Integer> newList = filter.filterOut(list);
        printFilteredElementsStatus(list, treshold);
        logger.log("Выводим результат на экран\n" +
                "Отфильтрованный список: " + newList);
        logger.log("Завершаем программу");
        sc.close();
    }

    private static List<Integer> getRandomList(int listLength, int maxValue) {
        int minValue = 0;
        return new Random().ints(listLength, minValue, maxValue)
                .boxed().collect(Collectors.toList());
    }

    private static void printFilteredElementsStatus(List<Integer> list, int treshold) {
        Logger logger = Logger.getInstance();
        list.forEach(i -> logger.log(String.format
                ("Элемент \"%d\" %s", i, i >= treshold ? "проходит" : "не проходит")));
    }
}
