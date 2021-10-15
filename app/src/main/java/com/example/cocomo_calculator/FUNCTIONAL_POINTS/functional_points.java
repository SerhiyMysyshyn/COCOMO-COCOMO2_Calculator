package com.example.cocomo_calculator.FUNCTIONAL_POINTS;

import static com.example.cocomo_calculator.FUNCTIONAL_POINTS.functional_points_methods.*;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.cocomo_calculator.COCOMO_II.cocomo2;
import com.example.cocomo_calculator.COCOMO_II.cocomo2_post_architecture_logic;
import com.example.cocomo_calculator.MainActivity;
import com.example.cocomo_calculator.R;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class functional_points extends AppCompatActivity {

    String[] type_data = {"Розповсюджений","Напівнезалежний", "Вбудований"};
    String[] pr_languages = {"(128) П. файли DOS","(107) Basic", "(80) PL/1"
                            , "(58) C#", "(56) Розширений Lisp"
                            , "(55) Java", "(54) JavaScript", "(53) C++"
                            , "(50) Visual Basic", "(40) Мови баз даних", "(38) Access"
                            , "(38) VBScript", "(35) Мови підтримки прийняття", "(34) FoxPro 2.5"
                            , "(29) DELPHI", "(29) Стандартні ООМ", "(28) VB.Net"
                            , "(20) Стандартні мови 4-го пок.", "(15) HTML 3.0", "(13) SQL"
                            , "(11) SQL Forms", "(6) Excel"
    };

    String[] factorE_data = {"0","1","2","3","4","5"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_functional_points);

        ImageButton exit = (ImageButton) findViewById(R.id.button_exit3);

        EditText externalInput1 = (EditText) findViewById(R.id.externalInput1);
        EditText externalInput2 = (EditText) findViewById(R.id.externalInput2);
        EditText externalInput3 = (EditText) findViewById(R.id.externalInput3);

        EditText externalOutput1 = (EditText) findViewById(R.id.externalOutput1);
        EditText externalOutput2 = (EditText) findViewById(R.id.externalOutput2);
        EditText externalOutput3 = (EditText) findViewById(R.id.externalOutput3);

        EditText externalRequest1 = (EditText) findViewById(R.id.externalRequest1);
        EditText externalRequest2 = (EditText) findViewById(R.id.externalRequest2);
        EditText externalRequest3 = (EditText) findViewById(R.id.externalRequest3);

        EditText localLogicFile1 = (EditText) findViewById(R.id.localLogicFile1);
        EditText localLogicFile2 = (EditText) findViewById(R.id.localLogicFile2);
        EditText localLogicFile3 = (EditText) findViewById(R.id.localLogicFile3);

        EditText externalInterfaceFile1 = (EditText) findViewById(R.id.externalInterfaceFile1);
        EditText externalInterfaceFile2 = (EditText) findViewById(R.id.externalInterfaceFile2);
        EditText externalInterfaceFile3 = (EditText) findViewById(R.id.externalInterfaceFile3);

        Spinner factorEnvironment1_spinner = (Spinner) findViewById(R.id.factorEnvironment1);
        Spinner factorEnvironment2_spinner = (Spinner) findViewById(R.id.factorEnvironment2);
        Spinner factorEnvironment3_spinner = (Spinner) findViewById(R.id.factorEnvironment3);
        Spinner factorEnvironment4_spinner = (Spinner) findViewById(R.id.factorEnvironment4);
        Spinner factorEnvironment5_spinner = (Spinner) findViewById(R.id.factorEnvironment5);
        Spinner factorEnvironment6_spinner = (Spinner) findViewById(R.id.factorEnvironment6);
        Spinner factorEnvironment7_spinner = (Spinner) findViewById(R.id.factorEnvironment7);
        Spinner factorEnvironment8_spinner = (Spinner) findViewById(R.id.factorEnvironment8);
        Spinner factorEnvironment9_spinner = (Spinner) findViewById(R.id.factorEnvironment9);
        Spinner factorEnvironment10_spinner = (Spinner) findViewById(R.id.factorEnvironment10);
        Spinner factorEnvironment11_spinner = (Spinner) findViewById(R.id.factorEnvironment11);
        Spinner factorEnvironment12_spinner = (Spinner) findViewById(R.id.factorEnvironment12);
        Spinner factorEnvironment13_spinner = (Spinner) findViewById(R.id.factorEnvironment13);
        Spinner factorEnvironment14_spinner = (Spinner) findViewById(R.id.factorEnvironment14);

        Spinner type_spinner = (Spinner) findViewById(R.id.FPtype);
        Spinner languages_spinner = (Spinner) findViewById(R.id.programmingLanguages);
        Button bCalculate = (Button) findViewById(R.id.calculateFP);
        LinearLayout result_layoutFP = (LinearLayout) findViewById(R.id.result_layoutFP);

        TextView countFPoint = (TextView) findViewById(R.id.countFP);
        TextView result_N = (TextView) findViewById(R.id.result_N);
        TextView result_CAF = (TextView) findViewById(R.id.CAF_result);
        TextView AFP_result = (TextView) findViewById(R.id.AFP_result);
        TextView LOC_result = (TextView) findViewById(R.id.LOC_result);
        TextView Trudovytraty_result = (TextView) findViewById(R.id.Trudovytraty_result);

/* ------------------------------------------------------------------------------------------------------------------------------------ */
        ArrayAdapter<String> factorEnvironment1_adapter = new ArrayAdapter<String>(this, R.layout.custom_spinner, factorE_data);
        factorEnvironment1_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        factorEnvironment1_spinner.setAdapter(factorEnvironment1_adapter);
        factorEnvironment1_spinner.setSelection(0);

        ArrayAdapter<String> factorEnvironment2_adapter = new ArrayAdapter<String>(this, R.layout.custom_spinner, factorE_data);
        factorEnvironment2_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        factorEnvironment2_spinner.setAdapter(factorEnvironment2_adapter);
        factorEnvironment2_spinner.setSelection(0);

        ArrayAdapter<String> factorEnvironment3_adapter = new ArrayAdapter<String>(this, R.layout.custom_spinner, factorE_data);
        factorEnvironment3_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        factorEnvironment3_spinner.setAdapter(factorEnvironment3_adapter);
        factorEnvironment3_spinner.setSelection(0);

        ArrayAdapter<String> factorEnvironment4_adapter = new ArrayAdapter<String>(this, R.layout.custom_spinner, factorE_data);
        factorEnvironment4_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        factorEnvironment4_spinner.setAdapter(factorEnvironment4_adapter);
        factorEnvironment4_spinner.setSelection(0);

        ArrayAdapter<String> factorEnvironment5_adapter = new ArrayAdapter<String>(this, R.layout.custom_spinner, factorE_data);
        factorEnvironment5_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        factorEnvironment5_spinner.setAdapter(factorEnvironment5_adapter);
        factorEnvironment5_spinner.setSelection(0);

        ArrayAdapter<String> factorEnvironment6_adapter = new ArrayAdapter<String>(this, R.layout.custom_spinner, factorE_data);
        factorEnvironment6_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        factorEnvironment6_spinner.setAdapter(factorEnvironment6_adapter);
        factorEnvironment6_spinner.setSelection(0);

        ArrayAdapter<String> factorEnvironment7_adapter = new ArrayAdapter<String>(this, R.layout.custom_spinner, factorE_data);
        factorEnvironment7_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        factorEnvironment7_spinner.setAdapter(factorEnvironment7_adapter);
        factorEnvironment7_spinner.setSelection(0);

        ArrayAdapter<String> factorEnvironment8_adapter = new ArrayAdapter<String>(this, R.layout.custom_spinner, factorE_data);
        factorEnvironment8_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        factorEnvironment8_spinner.setAdapter(factorEnvironment8_adapter);
        factorEnvironment8_spinner.setSelection(0);

        ArrayAdapter<String> factorEnvironment9_adapter = new ArrayAdapter<String>(this, R.layout.custom_spinner, factorE_data);
        factorEnvironment9_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        factorEnvironment9_spinner.setAdapter(factorEnvironment9_adapter);
        factorEnvironment9_spinner.setSelection(0);

        ArrayAdapter<String> factorEnvironment10_adapter = new ArrayAdapter<String>(this, R.layout.custom_spinner, factorE_data);
        factorEnvironment10_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        factorEnvironment10_spinner.setAdapter(factorEnvironment10_adapter);
        factorEnvironment10_spinner.setSelection(0);

        ArrayAdapter<String> factorEnvironment11_adapter = new ArrayAdapter<String>(this, R.layout.custom_spinner, factorE_data);
        factorEnvironment11_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        factorEnvironment11_spinner.setAdapter(factorEnvironment11_adapter);
        factorEnvironment11_spinner.setSelection(0);

        ArrayAdapter<String> factorEnvironment12_adapter = new ArrayAdapter<String>(this, R.layout.custom_spinner, factorE_data);
        factorEnvironment12_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        factorEnvironment12_spinner.setAdapter(factorEnvironment12_adapter);
        factorEnvironment12_spinner.setSelection(0);

        ArrayAdapter<String> factorEnvironment13_adapter = new ArrayAdapter<String>(this, R.layout.custom_spinner, factorE_data);
        factorEnvironment13_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        factorEnvironment13_spinner.setAdapter(factorEnvironment13_adapter);
        factorEnvironment13_spinner.setSelection(0);

        ArrayAdapter<String> factorEnvironment14_adapter = new ArrayAdapter<String>(this, R.layout.custom_spinner, factorE_data);
        factorEnvironment14_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        factorEnvironment14_spinner.setAdapter(factorEnvironment14_adapter);
        factorEnvironment14_spinner.setSelection(0);

        /* -------------------------------------------------------------------------------------------------------------------------- */

        ArrayAdapter<String> languages_adapter = new ArrayAdapter<String>(this, R.layout.custom_spinner, pr_languages);
        languages_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        languages_spinner.setAdapter(languages_adapter);
        languages_spinner.setSelection(0);

        ArrayAdapter<String> type_adapter = new ArrayAdapter<String>(this, R.layout.custom_spinner, type_data);
        type_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        type_spinner.setAdapter(type_adapter);
        type_spinner.setSelection(0);

        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(functional_points.this, MainActivity.class);
                functional_points.this.startActivity(intent);
                functional_points.this.finish();
            }
        });

        bCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                List<Integer> elementsFP = new ArrayList<>();
                int element1 = (checkIfEmptyString(externalInput1.getText().toString()) * 3)+
                                (checkIfEmptyString(externalInput2.getText().toString()) * 4)+
                                (checkIfEmptyString(externalInput3.getText().toString()) * 6);
                int element2 = (checkIfEmptyString(externalOutput1.getText().toString()) * 4)+
                                (checkIfEmptyString(externalOutput2.getText().toString()) * 5)+
                                (checkIfEmptyString(externalOutput3.getText().toString()) * 7);
                int element3 = (checkIfEmptyString(externalRequest1.getText().toString()) * 3)+
                                (checkIfEmptyString(externalRequest2.getText().toString()) * 4)+
                                (checkIfEmptyString(externalRequest3.getText().toString()) * 6);
                int element4 = (checkIfEmptyString(localLogicFile1.getText().toString()) * 7)+
                                (checkIfEmptyString(localLogicFile2.getText().toString()) * 10)+
                                (checkIfEmptyString(localLogicFile3.getText().toString()) * 15);
                int element5 = (checkIfEmptyString(externalInterfaceFile1.getText().toString()) * 5)+
                                (checkIfEmptyString(externalInterfaceFile2.getText().toString()) * 7)+
                                (checkIfEmptyString(externalInterfaceFile3.getText().toString()) * 10);

                elementsFP.add(element1);
                elementsFP.add(element2);
                elementsFP.add(element3);
                elementsFP.add(element4);
                elementsFP.add(element5);

                result_layoutFP.setBackground(getResources().getDrawable(R.drawable.custom_background_true));

            // Знаходжу функціональні  точки
                int countFunctionalPoint = calculateCountFP(elementsFP);
                countFPoint.setText(String.valueOf(countFunctionalPoint));

            // Знаходжу суму факторів середовища
                List<Integer> N_params = new ArrayList<>();
                    N_params.add(Integer.parseInt(factorEnvironment1_spinner.getSelectedItem().toString()));
                    N_params.add(Integer.parseInt(factorEnvironment2_spinner.getSelectedItem().toString()));
                    N_params.add(Integer.parseInt(factorEnvironment3_spinner.getSelectedItem().toString()));
                    N_params.add(Integer.parseInt(factorEnvironment4_spinner.getSelectedItem().toString()));
                    N_params.add(Integer.parseInt(factorEnvironment5_spinner.getSelectedItem().toString()));
                    N_params.add(Integer.parseInt(factorEnvironment6_spinner.getSelectedItem().toString()));
                    N_params.add(Integer.parseInt(factorEnvironment7_spinner.getSelectedItem().toString()));
                    N_params.add(Integer.parseInt(factorEnvironment8_spinner.getSelectedItem().toString()));
                    N_params.add(Integer.parseInt(factorEnvironment9_spinner.getSelectedItem().toString()));
                    N_params.add(Integer.parseInt(factorEnvironment10_spinner.getSelectedItem().toString()));
                    N_params.add(Integer.parseInt(factorEnvironment11_spinner.getSelectedItem().toString()));
                    N_params.add(Integer.parseInt(factorEnvironment12_spinner.getSelectedItem().toString()));
                    N_params.add(Integer.parseInt(factorEnvironment13_spinner.getSelectedItem().toString()));
                    N_params.add(Integer.parseInt(factorEnvironment14_spinner.getSelectedItem().toString()));
                int n_value=calculateN(N_params);
                result_N.setText(String.valueOf(n_value));

            // Обчислюю CAF
                BigDecimal CAF_res = calculateСAF(n_value);
                result_CAF.setText(CAF_res.toString());

            // Обчислюю AFP
                BigDecimal AFP_res = calculateAFP(countFunctionalPoint, CAF_res);
                AFP_result.setText(AFP_res.toString());

            // Обчислюю LOC
                int language_value = findParam(languages_spinner.getSelectedItem().toString());
                BigDecimal LOC_res = calculateLOC(AFP_res, language_value);
                LOC_result.setText(LOC_res.toString());

            // Обчислюю трудовитрати
                String type = type_spinner.getSelectedItem().toString();
                BigDecimal T_res = calculateT(LOC_res, type);
                Trudovytraty_result.setText(T_res.toString());
            }
        });



    }
}