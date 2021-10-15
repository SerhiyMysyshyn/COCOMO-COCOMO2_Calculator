package com.example.cocomo_calculator.COCOMO;

import static android.view.View.GONE;
import static android.view.View.VISIBLE;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.cocomo_calculator.MainActivity;
import com.example.cocomo_calculator.R;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class cocomo1 extends AppCompatActivity {

    String[] level_data = {"Базовий","Проміжний"};
    String[] type_data = {"Розповсюджений","Напівнезалежний", "Вбудований"};

    String[] RELY_data = {"Дуже низький (0.75)", "Низький (0.88)", "Середній (1)", "Високий (1.15)", "Дуже високий (1.4)", "Критичний (n/a)"};
    String[] DATA_data = {"Дуже низький (n/a)", "Низький (0.94)", "Середній (1)", "Високий (1.08)", "Дуже високий (1.16)", "Критичний (n/a)"};
    String[] CPLX_data = {"Дуже низький (0.7)", "Низький (0.85)", "Середній (1)", "Високий (1.15)", "Дуже високий (1.3)", "Критичний (1.65)"};
    String[] TIME_data = {"Дуже низький (n/a)", "Низький (n/a)", "Середній (1)", "Високий (1.11)", "Дуже високий (1.3)", "Критичний (1.66)"};
    String[] STOR_data = {"Дуже низький (n/a)", "Низький (n/a)", "Середній (1)", "Високий (1.06)", "Дуже високий (1.21)", "Критичний (1.56)"};
    String[] VIRT_data = {"Дуже низький (n/a)", "Низький (0.87)", "Середній (1)", "Високий (1.15)", "Дуже високий (1.3)", "Критичний (n/a)"};
    String[] TURN_data = {"Дуже низький (n/a)", "Низький (0.87)", "Середній (1)", "Високий (1.07)", "Дуже високий (1.15)", "Критичний (n/a)"};
    String[] ACAP_data = {"Дуже низький (1.46)", "Низький (1.19)", "Середній (1)", "Високий (0.86)", "Дуже високий (0.71)", "Критичний (n/a)"};
    String[] AEXP_data = {"Дуже низький (1.29)", "Низький (1.13)", "Середній (1)", "Високий (0.91)", "Дуже високий (0.82)", "Критичний (n/a)"};
    String[] PCAP_data = {"Дуже низький (1.42)", "Низький (1.17)", "Середній (1)", "Високий (0.86)", "Дуже високий (0.7)", "Критичний (n/a)"};
    String[] VEXP_data = {"Дуже низький (1.21)", "Низький (1.1)", "Середній (1)", "Високий (0.9)", "Дуже високий (n/a)", "Критичний (n/a)"};
    String[] LEXP_data = {"Дуже низький (1.14)", "Низький (1.07)", "Середній (1)", "Високий (0.95)", "Дуже високий (n/a)", "Критичний (n/a)"};
    String[] MODP_data = {"Дуже низький (1.24)", "Низький (1.1)", "Середній (1)", "Високий (0.91)", "Дуже високий (0.82)", "Критичний (n/a)"};
    String[] TOOL_data = {"Дуже низький (1.24)", "Низький (1.1)", "Середній (1)", "Високий (0.91)", "Дуже високий (0.83)", "Критичний (n/a)"};
    String[] SCED_data = {"Дуже низький (1.23)", "Низький (1.08)", "Середній (1)", "Високий (1.04)", "Дуже високий (1.1)", "Критичний (n/a)"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cocomo1);

        ImageButton button_exit = (ImageButton)findViewById(R.id.button_exit1);
        Spinner level_spinner = (Spinner) findViewById(R.id.level);
        Spinner type_spinner = (Spinner) findViewById(R.id.type);
        LinearLayout result_LinearLayout = (LinearLayout)findViewById(R.id.result_layout);
        LinearLayout intermediate_LinearLayout = (LinearLayout)findViewById(R.id.intermediateLayout);
        RelativeLayout kloc_relativeLayout = (RelativeLayout)findViewById(R.id.kloc_relativeLayout);
        EditText kloc = (EditText) findViewById(R.id.countLinesOfCode);
    //-----------------------------------------------------------------------------
        Spinner rely_spinner = (Spinner) findViewById(R.id.RELY_spinner);
        Spinner data_spinner = (Spinner) findViewById(R.id.DATA_spinner);
        Spinner cplx_spinner = (Spinner) findViewById(R.id.CPLX_spinner);
        Spinner time_spinner = (Spinner) findViewById(R.id.TIME_spinner);
        Spinner stor_spinner = (Spinner) findViewById(R.id.STOR_spinner);
        Spinner virt_spinner = (Spinner) findViewById(R.id.VIRT_spinner);
        Spinner turn_spinner = (Spinner) findViewById(R.id.TURN_spinner);
        Spinner acap_spinner = (Spinner) findViewById(R.id.ACAP_spinner);
        Spinner aexp_spinner = (Spinner) findViewById(R.id.AEXP_spinner);
        Spinner pcap_spinner = (Spinner) findViewById(R.id.PCAP_spinner);
        Spinner vexp_spinner = (Spinner) findViewById(R.id.VEXP_spinner);
        Spinner lexp_spinner = (Spinner) findViewById(R.id.LEXP_spinner);
        Spinner modp_spinner = (Spinner) findViewById(R.id.MODP_spinner);
        Spinner tool_spinner = (Spinner) findViewById(R.id.TOOL_spinner);
        Spinner sced_spinner = (Spinner) findViewById(R.id.SCED_spinner);
    //-----------------------------------------------------------------------------
        RelativeLayout timeDevLayout = (RelativeLayout)findViewById(R.id.timeDev_result_layout);
        RelativeLayout avaragePersonalLayout = (RelativeLayout)findViewById(R.id.avaragePersonal_result_layout);
        RelativeLayout productivityLayout = (RelativeLayout)findViewById(R.id.productivity_result_layout);

        TextView pm = (TextView) findViewById(R.id.trudoemnist_result);
        TextView tm = (TextView) findViewById(R.id.timeDev_result);
        TextView ss = (TextView) findViewById(R.id.avaragePersonal_result);
        TextView p = (TextView) findViewById(R.id.productivity_result);
    //-----------------------------------------------------------------------------
        Button calculate = (Button) findViewById(R.id.calculate);
    //-----------------------------------------------------------------------------
        ArrayAdapter<String> Level_adapter = new ArrayAdapter<String>(this, R.layout.custom_spinner, level_data);
        Level_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        level_spinner.setAdapter(Level_adapter);
        level_spinner.setSelection(0);

        ArrayAdapter<String> Type_adapter = new ArrayAdapter<String>(this, R.layout.custom_spinner, type_data);
        Type_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        type_spinner.setAdapter(Type_adapter);
        type_spinner.setSelection(0);
//-----------Adapters-----------------------------------------------------------------------------------------------------------------------
        ArrayAdapter<String> rely_adapter = new ArrayAdapter<String>(this, R.layout.custom_spinner, RELY_data);
        rely_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        rely_spinner.setAdapter(rely_adapter);
        rely_spinner.setSelection(0);

        ArrayAdapter<String> data_adapter = new ArrayAdapter<String>(this, R.layout.custom_spinner, DATA_data);
        data_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        data_spinner.setAdapter(data_adapter);
        data_spinner.setSelection(0);

        ArrayAdapter<String> cplx_adapter = new ArrayAdapter<String>(this, R.layout.custom_spinner, CPLX_data);
        cplx_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        cplx_spinner.setAdapter(cplx_adapter);
        cplx_spinner.setSelection(0);

        ArrayAdapter<String> time_adapter = new ArrayAdapter<String>(this, R.layout.custom_spinner, TIME_data);
        time_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        time_spinner.setAdapter(time_adapter);
        time_spinner.setSelection(0);

        ArrayAdapter<String> stor_adapter = new ArrayAdapter<String>(this, R.layout.custom_spinner, STOR_data);
        stor_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        stor_spinner.setAdapter(stor_adapter);
        stor_spinner.setSelection(0);

        ArrayAdapter<String> virt_adapter = new ArrayAdapter<String>(this, R.layout.custom_spinner, VIRT_data);
        virt_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        virt_spinner.setAdapter(virt_adapter);
        virt_spinner.setSelection(0);

        ArrayAdapter<String> turn_adapter = new ArrayAdapter<String>(this, R.layout.custom_spinner, TURN_data);
        turn_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        turn_spinner.setAdapter(turn_adapter);
        turn_spinner.setSelection(0);

        ArrayAdapter<String> acap_adapter = new ArrayAdapter<String>(this, R.layout.custom_spinner, ACAP_data);
        acap_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        acap_spinner.setAdapter(acap_adapter);
        acap_spinner.setSelection(0);

        ArrayAdapter<String> aexp_adapter = new ArrayAdapter<String>(this, R.layout.custom_spinner, AEXP_data);
        aexp_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        aexp_spinner.setAdapter(aexp_adapter);
        aexp_spinner.setSelection(0);

        ArrayAdapter<String> pcap_adapter = new ArrayAdapter<String>(this, R.layout.custom_spinner, PCAP_data);
        pcap_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        pcap_spinner.setAdapter(pcap_adapter);
        pcap_spinner.setSelection(0);

        ArrayAdapter<String> vexp_adapter = new ArrayAdapter<String>(this, R.layout.custom_spinner, VEXP_data);
        vexp_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        vexp_spinner.setAdapter(vexp_adapter);
        vexp_spinner.setSelection(0);

        ArrayAdapter<String> lexp_adapter = new ArrayAdapter<String>(this, R.layout.custom_spinner, LEXP_data);
        lexp_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        lexp_spinner.setAdapter(lexp_adapter);
        lexp_spinner.setSelection(0);

        ArrayAdapter<String> modp_adapter = new ArrayAdapter<String>(this, R.layout.custom_spinner, MODP_data);
        modp_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        modp_spinner.setAdapter(modp_adapter);
        modp_spinner.setSelection(0);

        ArrayAdapter<String> tool_adapter = new ArrayAdapter<String>(this, R.layout.custom_spinner, TOOL_data);
        tool_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        tool_spinner.setAdapter(tool_adapter);
        tool_spinner.setSelection(0);

        ArrayAdapter<String> sced_adapter = new ArrayAdapter<String>(this, R.layout.custom_spinner, SCED_data);
        sced_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sced_spinner.setAdapter(sced_adapter);
        sced_spinner.setSelection(0);

//------------------------------------------------------------------------------------------------------------------------------------------
        level_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (level_spinner.getSelectedItem().toString().equals("Проміжний")){
                    pm.setText("");
                    intermediate_LinearLayout.setVisibility(VISIBLE);
                        timeDevLayout.setVisibility(GONE);
                        avaragePersonalLayout.setVisibility(GONE);
                        productivityLayout.setVisibility(GONE);
                }else{
                    intermediate_LinearLayout.setVisibility(GONE);
                    timeDevLayout.setVisibility(VISIBLE);
                    avaragePersonalLayout.setVisibility(VISIBLE);
                    productivityLayout.setVisibility(VISIBLE);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
//------------------------------------------------------------------------------------------------------------------------------------------
        type_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
//------------------------------------------------------------------------------------------------------------------------------------------

        calculate.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onClick(View v) {
                if (kloc.getText().toString().equals("")){
                    kloc_relativeLayout.setBackground(getResources().getDrawable(R.drawable.custom_background_false_small_radius));
                    result_LinearLayout.setBackground(getResources().getDrawable(R.drawable.custom_background_false));
                    calculate.setBackground(getResources().getDrawable(R.drawable.custom_background_false));
                    Toast.makeText(getBaseContext(), "Заповніть, будь ласка, порожні поля поля!", Toast.LENGTH_LONG).show();
                }else{
                    pm.setText("");
                    tm.setText("");
                    ss.setText("");
                    p.setText("");
                    kloc_relativeLayout.setBackground(getResources().getDrawable(R.color.transparent));
                    result_LinearLayout.setBackground(getResources().getDrawable(R.drawable.custom_background_true));
                    calculate.setBackground(getResources().getDrawable(R.drawable.custom_background_true));

                    double KLOC = Double.parseDouble(kloc.getText().toString());

                    switch (level_spinner.getSelectedItem().toString()){
                        case "Базовий":
                            switch (type_spinner.getSelectedItem().toString()){
                                case "Розповсюджений":
                                    BigDecimal result_organic[] =  cocomo_basic_logic.calculate_organic_type(KLOC);
                                    pm.setText(String.valueOf(result_organic[0]));
                                    tm.setText(String.valueOf(result_organic[1]));
                                    ss.setText(String.valueOf(result_organic[2]));
                                    p.setText(String.valueOf(result_organic[3]));
                                    break;
                                case "Напівнезалежний":
                                    BigDecimal result_SemiIndependent[] =  cocomo_basic_logic.calculate_SemiIndependent_type(KLOC);
                                        pm.setText(String.valueOf(result_SemiIndependent[0]));
                                        tm.setText(String.valueOf(result_SemiIndependent[1]));
                                        ss.setText(String.valueOf(result_SemiIndependent[2]));
                                        p.setText(String.valueOf(result_SemiIndependent[3]));
                                    break;
                                case "Вбудований":
                                    BigDecimal result_Embedded[] = cocomo_basic_logic.calculate_Embedded_type(KLOC);
                                    pm.setText(String.valueOf(result_Embedded[0]));
                                    tm.setText(String.valueOf(result_Embedded[1]));
                                    ss.setText(String.valueOf(result_Embedded[2]));
                                    p.setText(String.valueOf(result_Embedded[3]));
                                    break;
                                default:
                                    Toast.makeText(getBaseContext(), "Виникла непередбачувана помилка!", Toast.LENGTH_SHORT).show();
                                    break;
                            }
                            break;
                        case "Проміжний":
                            List<String> params = new ArrayList<>();
                                params.add(rely_spinner.getSelectedItem().toString().replaceAll("[^0-9\\/an.]", ""));
                                params.add(data_spinner.getSelectedItem().toString().replaceAll("[^0-9\\/an.]", ""));
                                params.add(cplx_spinner.getSelectedItem().toString().replaceAll("[^0-9\\/an.]", ""));
                                params.add(time_spinner.getSelectedItem().toString().replaceAll("[^0-9\\/an.]", ""));
                                params.add(stor_spinner.getSelectedItem().toString().replaceAll("[^0-9\\/an.]", ""));
                                params.add(virt_spinner.getSelectedItem().toString().replaceAll("[^0-9\\/an.]", ""));
                                params.add(turn_spinner.getSelectedItem().toString().replaceAll("[^0-9\\/an.]", ""));
                                params.add(acap_spinner.getSelectedItem().toString().replaceAll("[^0-9\\/an.]", ""));
                                params.add(aexp_spinner.getSelectedItem().toString().replaceAll("[^0-9\\/an.]", ""));
                                params.add(pcap_spinner.getSelectedItem().toString().replaceAll("[^0-9\\/an.]", ""));
                                params.add(vexp_spinner.getSelectedItem().toString().replaceAll("[^0-9\\/an.]", ""));
                                params.add(lexp_spinner.getSelectedItem().toString().replaceAll("[^0-9\\/an.]", ""));
                                params.add(modp_spinner.getSelectedItem().toString().replaceAll("[^0-9\\/an.]", ""));
                                params.add(tool_spinner.getSelectedItem().toString().replaceAll("[^0-9\\/an.]", ""));
                                params.add(sced_spinner.getSelectedItem().toString().replaceAll("[^0-9\\/an.]", ""));

                            switch (type_spinner.getSelectedItem().toString()){

                                case "Розповсюджений":
                                    BigDecimal result1 = cocomo_intermediate_logic.calculate_intermediate_organic_type(KLOC, params);
                                    pm.setText(result1.toString());
                                    break;
                                case "Напівнезалежний":
                                    BigDecimal result2 = cocomo_intermediate_logic.calculate_intermediate_SemiIndependent_type(KLOC, params);
                                    pm.setText(result2.toString());
                                    break;
                                case "Вбудований":
                                    BigDecimal result3 = cocomo_intermediate_logic.calculate_intermediate_Embedded_type(KLOC, params);
                                    pm.setText(result3.toString());
                                    break;
                            }
                            break;
                    }
                }
            }
        });

        button_exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(cocomo1.this, MainActivity.class);
                cocomo1.this.startActivity(intent);
                cocomo1.this.finish();
            }
        });

    }

    public void rely_hint_function(View view) {
        Toast.makeText(getBaseContext(), getResources().getString(R.string.hint_rely), Toast.LENGTH_LONG).show();
    }
    public void data_hint_function(View view) {
        Toast.makeText(getBaseContext(), getResources().getString(R.string.hint_data), Toast.LENGTH_LONG).show();
    }
    public void cplx_hint_function(View view) {
        Toast.makeText(getBaseContext(), getResources().getString(R.string.hint_cplx), Toast.LENGTH_LONG).show();
    }
    public void time_hint_function(View view) {
        Toast.makeText(getBaseContext(), getResources().getString(R.string.hint_time), Toast.LENGTH_LONG).show();
    }
    public void stor_hint_function(View view) {
        Toast.makeText(getBaseContext(), getResources().getString(R.string.hint_stor), Toast.LENGTH_LONG).show();
    }
    public void virt_hint_function(View view) {
        Toast.makeText(getBaseContext(), getResources().getString(R.string.hint_virt), Toast.LENGTH_LONG).show();
    }
    public void turn_hint_function(View view) {
        Toast.makeText(getBaseContext(), getResources().getString(R.string.hint_turn), Toast.LENGTH_LONG).show();
    }
    public void acap_hint_function(View view) {
        Toast.makeText(getBaseContext(), getResources().getString(R.string.hint_acap), Toast.LENGTH_LONG).show();
    }
    public void aexp_hint_function(View view) {
        Toast.makeText(getBaseContext(), getResources().getString(R.string.hint_aexp), Toast.LENGTH_LONG).show();
    }
    public void pcap_hint_function(View view) {
        Toast.makeText(getBaseContext(), getResources().getString(R.string.hint_pcap), Toast.LENGTH_LONG).show();
    }
    public void vexp_hint_function(View view) {
        Toast.makeText(getBaseContext(), getResources().getString(R.string.hint_vexp), Toast.LENGTH_LONG).show();
    }
    public void lexp_hint_function(View view) {
        Toast.makeText(getBaseContext(), getResources().getString(R.string.hint_lexp), Toast.LENGTH_LONG).show();
    }
    public void modp_hint_function(View view) {
        Toast.makeText(getBaseContext(), getResources().getString(R.string.hint_modp), Toast.LENGTH_LONG).show();
    }
    public void tool_hint_function(View view) {
        Toast.makeText(getBaseContext(), getResources().getString(R.string.hint_tool), Toast.LENGTH_LONG).show();
    }
    public void sced_hint_function(View view) {
        Toast.makeText(getBaseContext(), getResources().getString(R.string.hint_sced), Toast.LENGTH_LONG).show();
    }
}