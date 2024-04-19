package SystemDesign;

public class ShortUrl {


    private static final String ALPHABET = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";

    public static String convertDecimalToBase62(long number) {
        StringBuilder result = new StringBuilder();

        while (number > 0) {
            // 计算余数
            int remainder = (int) (number % 62);
            result.append(ALPHABET.charAt(remainder));
            // 更新待转换的数
            number /= 62;
        }

        return result.reverse().toString();
    }

    public static void main(String[] args) {
        long decimalNumber = 3394174629L;
        String base62 = convertDecimalToBase62(decimalNumber);
        System.out.println("The base62 representation of " + decimalNumber + " is: " + base62);
    }


}
