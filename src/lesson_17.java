import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
public class lesson_17 {
    public static void main() {
        //1
        System.out.println(LeetcodeIntToRoman.intToRoman(3));
        System.out.println(LeetcodeIntToRoman.intToRoman(58));
        System.out.println(LeetcodeIntToRoman.intToRoman(1994));
        //2
        int[] nums = {1, 2, 3, 2, 4, 1, 5, 5, 5};
        int[] mostFrequentNumbers = HW.findMostFrequentNumbers(nums);

        System.out.println("Найбільше зустрічаються числа:");
        for (int num : mostFrequentNumbers) {
            System.out.println(num);
        }
        //3
        IntegerListProcessor processor = new IntegerListProcessor();
        processor.addNumbers();

        System.out.println("Сума парних чисел: " + processor.sumOfEvenNumbers());
        System.out.println("Результат множення кожного числа на 2: " + processor.multiplyEachByTwo());
        System.out.println("Максимальне число у списку: " + processor.findMaxNumber());
        System.out.println("Непарні числа: " + processor.oddNumbersAsString());
        System.out.println("Середнє арифметичне: " + processor.calculateAverage());
    }
}

class LeetcodeIntToRoman{
        public static String intToRoman(int num) {
            int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
            String[] symbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

            StringBuilder result = new StringBuilder();
            for (int i = 0; i < values.length; i++) {
                while (num >= values[i]) {
                    result.append(symbols[i]);
                    num -= values[i];
                }
            }

            return result.toString();
        }
}

class HW{
    public static int[] findMostFrequentNumbers(int[] nums) {
        Map<Integer, Integer> frequencyMap = new HashMap<>();


        for (int num : nums) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }


        int maxFrequency = 0;
        for (int frequency : frequencyMap.values()) {
            if (frequency > maxFrequency) {
                maxFrequency = frequency;
            }
        }


        int count = 0;
        for (int key : frequencyMap.keySet()) {
            if (frequencyMap.get(key) == maxFrequency) {
                count++;
            }
        }


        int[] result = new int[count];
        int index = 0;
        for (int key : frequencyMap.keySet()) {
            if (frequencyMap.get(key) == maxFrequency) {
                result[index++] = key;
            }
        }

        return result;
    }
}

class IntegerListProcessor {
    private List<Integer> numbers;

    public IntegerListProcessor() {
        numbers = new ArrayList<>();
    }

    public void addNumbers() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введіть цілі числа через пробіл:");
        String input = scanner.nextLine();
        String[] numberStrings = input.split("\\s+");

        try {
            numbers = Arrays.stream(numberStrings)
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
        } catch (NumberFormatException e) {
            System.out.println("Помилка при зчитуванні чисел. Впевніться, що ви ввели лише цілі числа.");
        }
    }

    public int sumOfEvenNumbers() {
        return numbers.stream()
                .filter(n -> n % 2 == 0)
                .mapToInt(Integer::intValue)
                .sum();
    }

    public List<Integer> multiplyEachByTwo() {
        return numbers.stream()
                .map(n -> n * 2)
                .collect(Collectors.toList());
    }

    public int findMaxNumber() {
        return numbers.stream()
                .mapToInt(Integer::intValue)
                .max()
                .orElseThrow(() -> new IllegalStateException("Список порожній"));
    }

    public String oddNumbersAsString() {
        return numbers.stream()
                .filter(n -> n % 2 != 0)
                .map(Object::toString)
                .collect(Collectors.joining(", "));
    }

    public double calculateAverage() {
        return numbers.stream()
                .mapToInt(Integer::intValue)
                .average()
                .orElse(0);
    }

}
