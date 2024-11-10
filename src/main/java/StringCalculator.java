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


}
