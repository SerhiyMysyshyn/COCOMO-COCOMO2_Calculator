package com.example.cocomo_calculator.COCOMO;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

public class cocomo_basic_logic {

    public static BigDecimal[] calculate_organic_type(double kloc){
        double a = 2.4;
        double b = 1.05;
        double c = 2.5;
        double d = 0.38;

        MathContext context = new MathContext(5, RoundingMode.HALF_UP);
        double PM = a * Math.pow(kloc, b);
        double TM = c * Math.pow(PM, d);
        double SS = PM / TM;
        double P = kloc / PM;

        BigDecimal bigDecimal_PM = new BigDecimal(PM,context);
        BigDecimal bigDecimal_TM = new BigDecimal(TM,context);
        BigDecimal bigDecimal_SS = new BigDecimal(SS,context);
        BigDecimal bigDecimal_P = new BigDecimal(P,context);

        return new BigDecimal[]{bigDecimal_PM, bigDecimal_TM, bigDecimal_SS, bigDecimal_P};
    }
    public static BigDecimal[] calculate_SemiIndependent_type(double kloc){
        double a = 3.0;
        double b = 1.12;
        double c = 2.5;
        double d = 0.35;

        MathContext context = new MathContext(5, RoundingMode.HALF_UP);
        double PM = a * Math.pow(kloc, b);
        double TM = c * Math.pow(PM, d);
        double SS = PM / TM;
        double P = kloc / PM;

        BigDecimal bigDecimal_PM = new BigDecimal(PM,context);
        BigDecimal bigDecimal_TM = new BigDecimal(TM,context);
        BigDecimal bigDecimal_SS = new BigDecimal(SS,context);
        BigDecimal bigDecimal_P = new BigDecimal(P,context);

        return new BigDecimal[]{bigDecimal_PM, bigDecimal_TM, bigDecimal_SS, bigDecimal_P};
    }
    public static BigDecimal[] calculate_Embedded_type(double kloc){
        double a = 3.6;
        double b = 1.20;
        double c = 2.5;
        double d = 0.32;

        MathContext context = new MathContext(5, RoundingMode.HALF_UP);
        double PM = a * Math.pow(kloc, b);
        double TM = c * Math.pow(PM, d);
        double SS = PM / TM;
        double P = kloc / PM;

        BigDecimal bigDecimal_PM = new BigDecimal(PM,context);
        BigDecimal bigDecimal_TM = new BigDecimal(TM,context);
        BigDecimal bigDecimal_SS = new BigDecimal(SS,context);
        BigDecimal bigDecimal_P = new BigDecimal(P,context);

        return new BigDecimal[]{bigDecimal_PM, bigDecimal_TM, bigDecimal_SS, bigDecimal_P};
    }
}
