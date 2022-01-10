package de.magoeke.lecture.demo.romannumbers.control;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

@Service
public class RomanNumbersConverter {

    public static final int MIN_VALUE = 1;
    public static final int MAX_VALUE = 3999;
    private final Map<Integer, String> arabicToRomanMap;

    public RomanNumbersConverter() {
        arabicToRomanMap = new HashMap<Integer, String>();
        arabicToRomanMap.put(1, "I");
        arabicToRomanMap.put(4, "IV");
        arabicToRomanMap.put(5, "V");
        arabicToRomanMap.put(9, "IX");
        arabicToRomanMap.put(10, "X");
        arabicToRomanMap.put(40, "XL");
        arabicToRomanMap.put(50, "L");
        arabicToRomanMap.put(90, "XC");
        arabicToRomanMap.put(100, "C");
        arabicToRomanMap.put(400, "CD");
        arabicToRomanMap.put(500, "D");
        arabicToRomanMap.put(900, "CM");
        arabicToRomanMap.put(1000, "M");
    }

    // This method is just for error handling
    public String convertToRoman(final int arabicNumber) {
        // ignore invalid
        if(arabicNumber < MIN_VALUE || arabicNumber > MAX_VALUE) {
            return "NAN";
        }
        // execute calculation
        return convertToRomanR(arabicNumber);
    }

    // calculates roman number
    private String convertToRomanR(final int arabicNumber) {
        // stop recursion
        if(arabicNumber == 0) { return ""; }

        // get number from Map that is the closest to arabicNumber (same, smaller)
        final int nearestNumber = arabicToRomanMap.keySet().stream()
                .filter(number -> arabicNumber >= number)
                .max(Integer::compare)
                .get();

        // recursive call
        return arabicToRomanMap.get(nearestNumber) + convertToRomanR(arabicNumber - nearestNumber);
    }


}
