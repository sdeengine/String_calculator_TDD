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

}
