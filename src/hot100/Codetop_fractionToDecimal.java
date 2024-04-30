package hot100;

import java.util.HashMap;
import java.util.Map;

public class Codetop_fractionToDecimal {

    public static String fractionToDecimal(int numerator, int denominator) {
        long numeratorLong = (long) numerator;
        long denominatorLong = (long) denominator;
        if (numeratorLong % denominatorLong == 0) {
            return String.valueOf(numeratorLong / denominatorLong);
        }
        StringBuilder resultBuffer = new StringBuilder();
        if ((numerator > 0 && denominator < 0) || (numerator < 0 && denominator > 0)) {
            resultBuffer.append("-");
        }

        //整数
        numeratorLong = Math.abs(numeratorLong);
        denominatorLong = Math.abs(denominatorLong);
        long intPart = numeratorLong / denominatorLong;
        resultBuffer.append(intPart).append(".");
        //小数
        StringBuilder fractionPart = new StringBuilder();
        Map<Long, Integer> remainIndexMap = new HashMap<>();
        long remain = numeratorLong % denominatorLong;
        int index = 0;
        while (remain != 0 && !remainIndexMap.containsKey(remain)) {
            remainIndexMap.put(remain, index++);
            remain *= 10;
            fractionPart.append(remain / denominatorLong);
            remain %= denominatorLong;
        }
        if (remain != 0) {
            int remainIndex = remainIndexMap.get(remain);
            fractionPart.insert(remainIndex, "(");
            fractionPart.append(")");
        }
        resultBuffer.append(fractionPart.toString());
        return resultBuffer.toString();
    }

    public static void main(String[] args) {
        String s = fractionToDecimal(-2147483648, -1);
        System.out.println(s);
    }

}
