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

}
