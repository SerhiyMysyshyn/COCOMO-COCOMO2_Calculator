package com.example.cocomo_calculator.COCOMO_II;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

public class cocomo2_post_architecture_logic {

    public static BigDecimal calculate_post_architecture_stage(double kloc, List<String> SF_parameters, List<String> EM_parameters){
        double a = 2.45;
        double b = 0.91;
        double SFj = 0.0;
        double EAF = 1;
        MathContext context = new MathContext(5, RoundingMode.HALF_UP);

//----- Converting to Double SF_parameters list (and delete "n/a") ---------------------------------
        do{
            for (int i=0; i< SF_parameters.size(); i++){
                if(SF_parameters.get(i).equals("n/a")){
                    SF_parameters.remove(i);
                }
            }
        }while(SF_parameters.contains("n/a"));

        List<Double> SF_parametersToDouble = new ArrayList<>(SF_parameters.size());
        for (String oldItem: SF_parameters){
            SF_parametersToDouble.add(Double.valueOf(oldItem));
        }
        for (Double i : SF_parametersToDouble){
            SFj += i;
        }

//----- Converting to Double EM_parameters list (and delete "n/a") ---------------------------------
        do{
            for (int i=0; i< EM_parameters.size(); i++){
                if(EM_parameters.get(i).equals("n/a")){
                    EM_parameters.remove(i);
                }
            }
        }while(EM_parameters.contains("n/a"));

        List<Double> EM_parametersToDouble = new ArrayList<>(EM_parameters.size());
        for (String oldItem: EM_parameters){
            EM_parametersToDouble.add(Double.valueOf(oldItem));
        }
//--------------------------------------------------------------------------------------------------

        double E = b + 0.01 * SFj;

        for (int i = 0; i<EM_parametersToDouble.size(); i++){
            EAF *= EM_parametersToDouble.get(i);
        }

        double PM = EAF * a * Math.pow(kloc, E);
        BigDecimal bigDecimal_PM = new BigDecimal(PM,context);

        return bigDecimal_PM;
    }
}
