package com.example.cocomo_calculator.FUNCTIONAL_POINTS;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class functional_points_methods {





    public static int checkIfEmptyString(String line){
        if (line.equals("")){
            return 0;
        }else{
            return Integer.parseInt(line);
        }
    }






    public static int findParam(String line){
        String regex = "\\d{1,3}";
        String resultInt = "";
            Pattern regexPattern = Pattern.compile(regex);
            Matcher matcher = regexPattern.matcher(line);
        if (matcher.find()) resultInt = matcher.group();

        return Integer.parseInt(resultInt);
    }





    public static int calculateCountFP(List<Integer> elem){
        int sum = 0;
        for (int i=0; i<elem.size(); i++) {
            sum = sum + elem.get(i);
        }
        return sum;
    }





    public static int calculateN(List<Integer> factors){
        int sum = 0;
        for (int i=0; i<factors.size(); i++) {
            sum = sum + factors.get(i);
        }
        return sum;
    }





    public static BigDecimal calculateСAF(int N){
        double CAF = 0.65 + (0.01 * N) ;
            MathContext context = new MathContext(3, RoundingMode.HALF_UP);
            BigDecimal bigDecimal_CAF = new BigDecimal(CAF,context);
        return bigDecimal_CAF;
    }





    public static BigDecimal calculateAFP (int FP, BigDecimal CAF){
        double AFP = FP * CAF.doubleValue();
            MathContext context = new MathContext(5, RoundingMode.HALF_UP);
            BigDecimal bigDecimal_AFP = new BigDecimal(AFP,context);
        return bigDecimal_AFP;
    }





    public static BigDecimal calculateLOC (BigDecimal AFP, int LOC){
        double newLOC = AFP.doubleValue() * LOC;
            MathContext context = new MathContext(7, RoundingMode.HALF_UP);
            BigDecimal bigDecimal_LOC = new BigDecimal(newLOC, context);
        return bigDecimal_LOC;
    }





    public static BigDecimal calculateT (BigDecimal LOC, String type){
        double a = 0.0;
        double b = 0.0;
        switch (type){
            case "Розповсюджений":
                a = 2.4;
                b = 1.05;
                break;
            case "Напівнезалежний":
                a = 3.0;
                b = 1.12;
                break;
            case "Вбудований":
                a = 3.6;
                b = 1.20;
                break;
        }
        double T = a * Math.pow((LOC.doubleValue() / 1000), b);
            MathContext context = new MathContext(5, RoundingMode.HALF_UP);
            BigDecimal bigDecimal_T = new BigDecimal(T, context);
        return bigDecimal_T;
    }

}
