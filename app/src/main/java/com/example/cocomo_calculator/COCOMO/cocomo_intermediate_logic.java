package com.example.cocomo_calculator.COCOMO;

import android.os.Build;
import androidx.annotation.RequiresApi;
import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

public class cocomo_intermediate_logic {


    public static BigDecimal calculate_intermediate_organic_type(double kloc, List<String> parameters){
        double a = 3.2;
        double b = 1.05;
        double EAF = 1;
        MathContext context = new MathContext(5, RoundingMode.HALF_UP);
            do{
                for (int i=0; i< parameters.size(); i++){
                    if(parameters.get(i).equals("n/a")){
                        parameters.remove(i);
                    }
                }
            }while(parameters.contains("n/a"));
        List<Double> parametersToDouble = new ArrayList<>(parameters.size());
           for (String oldItem: parameters){
               parametersToDouble.add(Double.valueOf(oldItem));
           }
        // Calculating EAF
           for (int i = 0; i<parametersToDouble.size(); i++){
               EAF *= parametersToDouble.get(i);
           }
        double PM = EAF * a * Math.pow(kloc, b);
        BigDecimal bigDecimal_PM = new BigDecimal(PM,context);

        return bigDecimal_PM;
    }


    public static BigDecimal calculate_intermediate_SemiIndependent_type(double kloc, List<String> parameters){
        double a = 3.0;
        double b = 1.12;
        double EAF = 1;
        MathContext context = new MathContext(5, RoundingMode.HALF_UP);
        do{
            for (int i=0; i< parameters.size(); i++){
                if(parameters.get(i).equals("n/a")){
                    parameters.remove(i);
                }
            }
        }while(parameters.contains("n/a"));
        List<Double> parametersToDouble = new ArrayList<>(parameters.size());
        for (String oldItem: parameters){
            parametersToDouble.add(Double.valueOf(oldItem));
        }
        // Calculating EAF
        for (int i = 0; i<parametersToDouble.size(); i++){
            EAF *= parametersToDouble.get(i);
        }
        double PM = EAF * a * Math.pow(kloc, b);
        BigDecimal bigDecimal_PM = new BigDecimal(PM,context);

        return bigDecimal_PM;
    }


    public static BigDecimal calculate_intermediate_Embedded_type(double kloc, List<String> parameters){
        double a = 2.8;
        double b = 1.20;
        double EAF = 1;
        MathContext context = new MathContext(5, RoundingMode.HALF_UP);
        do{
            for (int i=0; i< parameters.size(); i++){
                if(parameters.get(i).equals("n/a")){
                    parameters.remove(i);
                }
            }
        }while(parameters.contains("n/a"));
        List<Double> parametersToDouble = new ArrayList<>(parameters.size());
        for (String oldItem: parameters){
            parametersToDouble.add(Double.valueOf(oldItem));
        }
        // Calculating EAF
        for (int i = 0; i<parametersToDouble.size(); i++){
            EAF *= parametersToDouble.get(i);
        }
        double PM = EAF * a * Math.pow(kloc, b);
        BigDecimal bigDecimal_PM = new BigDecimal(PM,context);

        return bigDecimal_PM;
    }

}
