import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StringCalculator {

    // Empty String input
    public int add(String numbers) {
        if (numbers.isEmpty()) {
            return 0;
        }
        return -1;
    }

    // Single String element input
    public int addSingleNumber(String numbers){
        if (numbers.isEmpty()) {
            return 0;
        }
        return Integer.parseInt(numbers);
    }

    // 2 elements as input with comma separated
    public int addTwoNumbers(String numbers){
        if (numbers.isEmpty()) {
            return 0;
        }
        String[] parts = numbers.split(",");
        if (parts.length == 1) {
            return Integer.parseInt(parts[0]);
        }
        return Integer.parseInt(parts[0]) + Integer.parseInt(parts[1]);
    }

    // multiple elements as input with comma separated
    public int addMultipleNumbers(String numbers){
        if (numbers.isEmpty()) {
            return 0;
        }
        String[] parts = numbers.split(",");
        int sum = 0;
        for (String part : parts) {
            sum += Integer.parseInt(part);
        }
        return sum;
    }

    //Test New Lines as Delimiters
    public int addWithNewLineDelimiter(String numbers) {
        if (numbers.isEmpty()) {
            return 0;
        }
        String[] parts = numbers.split("[,\n]");
        int sum = 0;
        for (String part : parts) {
            sum += Integer.parseInt(part);
        }
        return sum;
    }

    //Custom delimiter as input
    public int addWithCustomDelimiter(String numbers){
        if (numbers.isEmpty()) {
            return 0;
        }
        String delimiter = ",|\n";
        if (numbers.startsWith("//")) {
            int delimiterIndex = numbers.indexOf("\n");
            delimiter = numbers.substring(2, delimiterIndex);
            numbers = numbers.substring(delimiterIndex + 1);
        }
        String[] parts = numbers.split(delimiter);
        int sum = 0;
        for (String part : parts) {
            sum += Integer.parseInt(part);
        }
        return sum;
    }

     // Throw Exception for Negative Numbers
     public int addWithNegativeNumbers(String numbers){
         if (numbers.isEmpty()) {
             return 0;
         }

         String delimiter = ",|\n";
         if (numbers.startsWith("//")) {
             int delimiterIndex = numbers.indexOf("\n");
             delimiter = numbers.substring(2, delimiterIndex);
             numbers = numbers.substring(delimiterIndex + 1);
         }

         List<Integer> parts = Stream.of(numbers.split(delimiter))
                 .map(Integer::parseInt)
                 .toList();

         List<Integer> negatives = parts.stream()
                 .filter(n -> n < 0)
                 .toList();

         if (!negatives.isEmpty()) {
             throw new IllegalArgumentException("Negatives not allowed: " + negatives);
         }

         return parts.stream()
                 .mapToInt(Integer::intValue)
                 .sum();
     }

}
