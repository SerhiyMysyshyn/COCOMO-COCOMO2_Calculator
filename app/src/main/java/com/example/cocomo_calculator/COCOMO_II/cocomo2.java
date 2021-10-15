package com.example.cocomo_calculator.COCOMO_II;

import static android.view.View.GONE;
import static android.view.View.VISIBLE;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
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

public class cocomo2 extends AppCompatActivity {

    String[] stage_data = {"Попередня оцінка", "Детальна оцінка"};

    String[] PREC_data = {"Дуже низький (6.2)", "Низький (4.96)", "Середній (3.72)", "Високий (2.48)", "Дуже високий (1.24)", "Критичний (0.0)"};
    String[] FLEX_data = {"Дуже низький (5.07)", "Низький (4.05)", "Середній (3.04)", "Високий (2.03)", "Дуже високий (1.01)", "Критичний (0.0)"};
    String[] RESL_data = {"Дуже низький (7.07)", "Низький (5.65)", "Середній (4.24)", "Високий (2.83)", "Дуже високий (1.41)", "Критичний (0.0)"};
    String[] TEAM_data = {"Дуже низький (5.48)", "Низький (4.38)", "Середній (3.29)", "Високий (2.19)", "Дуже високий (1.1)", "Критичний (0.0)"};
    String[] PMAT_data = {"Дуже низький (7.8)", "Низький (6.24)", "Середній (4.68)", "Високий (3.12)", "Дуже високий (1.56)", "Критичний (0.0)"};

    String[] EMI_PERS_data = {"Критично низький (2.12)", "Дуже низький (1.62)", "Низький (1.26)", "Середній (1)", "Високий (0.83)", "Дуже високий (0.63)", "Критичний (0.5)"};
    String[] EMI_PREX_data = {"Критично низький (1.59)", "Дуже низький (1.33)", "Низький (1.22)", "Середній (1)", "Високий (0.87)", "Дуже високий (0.74)", "Критичний (0.62)"};
    String[] EMI_RCPX_data = {"Критично низький (0.49)", "Дуже низький (0.6)", "Низький (0.83)", "Середній (1)", "Високий (1.33)", "Дуже високий (1.91)", "Критичний (2.72)"};
    String[] EMI_RUSE_data = {"Критично низький (n/a)", "Дуже низький (n/a)", "Низький (0.95)", "Середній (1)", "Високий (1.07)", "Дуже високий (1.15)", "Критичний (1.24)"};
    String[] EMI_PDIF_data = {"Критично низький (n/a)", "Дуже низький (n/a)", "Низький (0.87)", "Середній (1)", "Високий (1.29)", "Дуже високий (1.81)", "Критичний (2.61)"};
    String[] EMI_FCIL_data = {"Критично низький (1.43)", "Дуже низький (1.3)", "Низький (1.1)", "Середній (1)", "Високий (0.87)", "Дуже високий (0.73)", "Критичний (0.62)"};
    String[] EMI_SCED_data = {"Критично низький (n/a)", "Дуже низький (1.43)", "Низький (1.14)", "Середній (1)", "Високий (1)", "Дуже високий (n/a)", "Критичний (n/a)"};

    String[] EMJ_ACAP_data = {"Дуже низький (1.42)", "Низький (1.29)", "Середній (1)", "Високий (0.85)", "Дуже високий (0.71)", "Критичний (n/a)"};
    String[] EMJ_AEXP_data = {"Дуже низький (1.22)", "Низький (1.1)", "Середній (1)", "Високий (0.88)", "Дуже високий (0.81)", "Критичний (n/a)"};
    String[] EMJ_PCAP_data = {"Дуже низький (1.34)", "Низький (1.15)", "Середній (1)", "Високий (0.88)", "Дуже високий (0.76)", "Критичний (n/a)"};
    String[] EMJ_PCON_data = {"Дуже низький (1.29)", "Низький (1.12)", "Середній (1)", "Високий (0.9)", "Дуже високий (0.81)", "Критичний (n/a)"};
    String[] EMJ_PEXP_data = {"Дуже низький (1.19)", "Низький (1.09)", "Середній (1)", "Високий (0.91)", "Дуже високий (0.85)", "Критичний (n/a)"};
    String[] EMJ_LTEX_data = {"Дуже низький (1.2)", "Низький (1.09)", "Середній (1)", "Високий (0.91)", "Дуже високий (0.84)", "Критичний (n/a)"};
    String[] EMJ_RELY_data = {"Дуже низький (0.84)", "Низький (0.92)", "Середній (1)", "Високий (1.1)", "Дуже високий (1.26)", "Критичний (n/a)"};
    String[] EMJ_DATA_data = {"Дуже низький (n/a)", "Низький (0.23)", "Середній (1)", "Високий (1.14)", "Дуже високий (1.28)", "Критичний (n/a)"};
    String[] EMJ_CPLX_data = {"Дуже низький (0.73)", "Низький (0.87)", "Середній (1)", "Високий (1.17)", "Дуже високий (1.34)", "Критичний (1.74)"};
    String[] EMJ_RUSE_data = {"Дуже низький (n/a)", "Низький (0.95)", "Середній (1)", "Високий (1.07)", "Дуже високий (1.15)", "Критичний (1.24)"};
    String[] EMJ_DOCU_data = {"Дуже низький (0.81)", "Низький (0.91)", "Середній (1)", "Високий (1.11)", "Дуже високий (1.23)", "Критичний (n/a)"};
    String[] EMJ_TIME_data = {"Дуже низький (n/a)", "Низький (n/a)", "Середній (1)", "Високий (1.11)", "Дуже високий (1.29)", "Критичний (1.63)"};
    String[] EMJ_STOR_data = {"Дуже низький (n/a)", "Низький (n/a)", "Середній (1)", "Високий (1.05)", "Дуже високий (1.17)", "Критичний (1.46)"};
    String[] EMJ_PVOL_data = {"Дуже низький (n/a)", "Низький (0.87)", "Середній (1)", "Високий (1.15)", "Дуже високий (1.3)", "Критичний (n/a)"};
    String[] EMJ_TOOL_data = {"Дуже низький (1.17)", "Низький (1.09)", "Середній (1)", "Високий (0.9)", "Дуже високий (0.78)", "Критичний (n/a)"};
    String[] EMJ_SITE_data = {"Дуже низький (1.22)", "Низький (1.09)", "Середній (1)", "Високий (0.93)", "Дуже високий (0.86)", "Критичний (0.8)"};
    String[] EMJ_SCED_data = {"Дуже низький (1.43)", "Низький (1.14)", "Середній (1)", "Високий (1)", "Дуже високий (1)", "Критичний (n/a)"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cocomo2);

        ImageButton button_exit = (ImageButton)findViewById(R.id.button_exit2);
        Spinner stage_spinner = (Spinner) findViewById(R.id.stage_spinner);
        EditText kloc = (EditText) findViewById(R.id.countLinesOfCode);

        RelativeLayout kloc_relativeLayout2 = (RelativeLayout)findViewById(R.id.kloc_relativeLayout2);
        LinearLayout early_designLayout = (LinearLayout)findViewById(R.id.early_design_layout);
        LinearLayout post_architectureLayout = (LinearLayout)findViewById(R.id.post_architecture_layout);
    //-----------------------------------------------------------------------------
        Spinner prec_spinner = (Spinner)findViewById(R.id.PREC_spinner);
        Spinner flex_spinner = (Spinner)findViewById(R.id.FLEX_spinner);
        Spinner resl_spinner = (Spinner)findViewById(R.id.RESL_spinner);
        Spinner team_spinner = (Spinner)findViewById(R.id.TEAM_spinner);
        Spinner pmat_spinner = (Spinner)findViewById(R.id.PMAT_spinner);
    //-----------------------------------------------------------------------------
        Spinner pers_spinner = (Spinner)findViewById(R.id.PERS_spinner);
        Spinner prex_spinner = (Spinner)findViewById(R.id.PREX_spinner);
        Spinner rcpx_spinner = (Spinner)findViewById(R.id.RCPX_spinner);
        Spinner ruse_spinner = (Spinner)findViewById(R.id.RUSE_spinner);
        Spinner pdif_spinner = (Spinner)findViewById(R.id.PDIF_spinner);
        Spinner fcil_spinner = (Spinner)findViewById(R.id.FCIL_spinner);
        Spinner sced_spinner = (Spinner)findViewById(R.id.SCED2_spinner);
    //-----------------------------------------------------------------------------
        Spinner spinner_acap = (Spinner)findViewById(R.id.spinner_ACAP);
        Spinner spinner_aexp = (Spinner)findViewById(R.id.spinner_AEXP);
        Spinner spinner_pcap = (Spinner)findViewById(R.id.spinner_PCAP);
        Spinner spinner_pcon = (Spinner)findViewById(R.id.spinner_PCON);
        Spinner spinner_pexp = (Spinner)findViewById(R.id.spinner_PEXP);
        Spinner spinner_ltex = (Spinner)findViewById(R.id.spinner_LTEX);
        Spinner spinner_rely = (Spinner)findViewById(R.id.spinner_RELY);
        Spinner spinner_data = (Spinner)findViewById(R.id.spinner_DATA);
        Spinner spinner_cplx = (Spinner)findViewById(R.id.spinner_CPLX);
        Spinner spinner_ruse = (Spinner)findViewById(R.id.spinner_RUSE);
        Spinner spinner_docu = (Spinner)findViewById(R.id.spinner_DOCU);
        Spinner spinner_time = (Spinner)findViewById(R.id.spinner_TIME);
        Spinner spinner_stor = (Spinner)findViewById(R.id.spinner_STOR);
        Spinner spinner_pvol = (Spinner)findViewById(R.id.spinner_PVOL);
        Spinner spinner_tool = (Spinner)findViewById(R.id.spinner_TOOL);
        Spinner spinner_site = (Spinner)findViewById(R.id.spinner_SITE);
        Spinner spinner_sced = (Spinner)findViewById(R.id.spinner_SCED);
    //-----------------------------------------------------------------------------
        LinearLayout resLayout = (LinearLayout)findViewById(R.id.result_layout2);
        TextView pm = (TextView) findViewById(R.id.trudoemnist_result2);
        Button calculate2 = (Button) findViewById(R.id.calculate2);
    //-----------------------------------------------------------------------------
        ArrayAdapter<String> stage_adapter = new ArrayAdapter<String>(this, R.layout.custom_spinner, stage_data);
        stage_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        stage_spinner.setAdapter(stage_adapter);
        stage_spinner.setSelection(0);

//------------------------------------------------------------------------------------------------------------------------------------------
        stage_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (stage_spinner.getSelectedItem().toString().equals("Детальна оцінка")){
                    pm.setText("");
                    post_architectureLayout.setVisibility(VISIBLE);
                    early_designLayout.setVisibility(GONE);

                }else{
                    post_architectureLayout.setVisibility(GONE);
                    early_designLayout.setVisibility(VISIBLE);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

//-----------Adapters-----------------------------------------------------------------------------------------------------------------------
        ArrayAdapter<String> prec_adapter = new ArrayAdapter<String>(this, R.layout.custom_spinner, PREC_data);
        prec_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        prec_spinner.setAdapter(prec_adapter);
        prec_spinner.setSelection(0);

        ArrayAdapter<String> flex_adapter = new ArrayAdapter<String>(this, R.layout.custom_spinner, FLEX_data);
        flex_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        flex_spinner.setAdapter(flex_adapter);
        flex_spinner.setSelection(0);

        ArrayAdapter<String> resl_adapter = new ArrayAdapter<String>(this, R.layout.custom_spinner, RESL_data);
        resl_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        resl_spinner.setAdapter(resl_adapter);
        resl_spinner.setSelection(0);

        ArrayAdapter<String> team_adapter = new ArrayAdapter<String>(this, R.layout.custom_spinner, TEAM_data);
        team_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        team_spinner.setAdapter(team_adapter);
        team_spinner.setSelection(0);

        ArrayAdapter<String> pmat_adapter = new ArrayAdapter<String>(this, R.layout.custom_spinner, PMAT_data);
        pmat_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        pmat_spinner.setAdapter(pmat_adapter);
        pmat_spinner.setSelection(0);

//----- Попередня оцінка -----------------------------------------------------------------------------------------------------------
        ArrayAdapter<String> pers_adapter = new ArrayAdapter<String>(this, R.layout.custom_spinner, EMI_PERS_data);
        pers_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        pers_spinner.setAdapter(pers_adapter);
        pers_spinner.setSelection(0);

        ArrayAdapter<String> prex_adapter = new ArrayAdapter<String>(this, R.layout.custom_spinner, EMI_PREX_data);
        prex_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        prex_spinner.setAdapter(prex_adapter);
        prex_spinner.setSelection(0);

        ArrayAdapter<String> rcpx_adapter = new ArrayAdapter<String>(this, R.layout.custom_spinner, EMI_RCPX_data);
        rcpx_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        rcpx_spinner.setAdapter(rcpx_adapter);
        rcpx_spinner.setSelection(0);

        ArrayAdapter<String> ruse_adapter = new ArrayAdapter<String>(this, R.layout.custom_spinner, EMI_RUSE_data);
        ruse_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ruse_spinner.setAdapter(ruse_adapter);
        ruse_spinner.setSelection(0);

        ArrayAdapter<String> pdif_adapter = new ArrayAdapter<String>(this, R.layout.custom_spinner, EMI_PDIF_data);
        pdif_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        pdif_spinner.setAdapter(pdif_adapter);
        pdif_spinner.setSelection(0);

        ArrayAdapter<String> fcil_adapter = new ArrayAdapter<String>(this, R.layout.custom_spinner, EMI_FCIL_data);
        fcil_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        fcil_spinner.setAdapter(fcil_adapter);
        fcil_spinner.setSelection(0);

        ArrayAdapter<String> sced_adapter = new ArrayAdapter<String>(this, R.layout.custom_spinner, EMI_SCED_data);
        sced_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sced_spinner.setAdapter(sced_adapter);
        sced_spinner.setSelection(0);

//----- Детальна оцінка ------------------------------------------------------------------------------------------------------------
        ArrayAdapter<String> acap_adapter = new ArrayAdapter<String>(this, R.layout.custom_spinner, EMJ_ACAP_data);
        acap_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_acap.setAdapter(acap_adapter);
        spinner_acap.setSelection(0);

        ArrayAdapter<String> aexp_adapter = new ArrayAdapter<String>(this, R.layout.custom_spinner, EMJ_AEXP_data);
        aexp_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_aexp.setAdapter(aexp_adapter);
        spinner_aexp.setSelection(0);

        ArrayAdapter<String> pcap_adapter = new ArrayAdapter<String>(this, R.layout.custom_spinner, EMJ_PCAP_data);
        pcap_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_pcap.setAdapter(pcap_adapter);
        spinner_pcap.setSelection(0);

        ArrayAdapter<String> pcon_adapter = new ArrayAdapter<String>(this, R.layout.custom_spinner, EMJ_PCON_data);
        pcon_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_pcon.setAdapter(pcon_adapter);
        spinner_pcon.setSelection(0);

        ArrayAdapter<String> pexp_adapter = new ArrayAdapter<String>(this, R.layout.custom_spinner, EMJ_PEXP_data);
        pexp_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_pexp.setAdapter(pexp_adapter);
        spinner_pexp.setSelection(0);

        ArrayAdapter<String> ltex_adapter = new ArrayAdapter<String>(this, R.layout.custom_spinner, EMJ_LTEX_data);
        ltex_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_ltex.setAdapter(ltex_adapter);
        spinner_ltex.setSelection(0);

        ArrayAdapter<String> rely_adapter = new ArrayAdapter<String>(this, R.layout.custom_spinner, EMJ_RELY_data);
        rely_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_rely.setAdapter(rely_adapter);
        spinner_rely.setSelection(0);

        ArrayAdapter<String> data_adapter = new ArrayAdapter<String>(this, R.layout.custom_spinner, EMJ_DATA_data);
        data_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_data.setAdapter(data_adapter);
        spinner_data.setSelection(0);

        ArrayAdapter<String> cplx_adapter = new ArrayAdapter<String>(this, R.layout.custom_spinner, EMJ_CPLX_data);
        cplx_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_cplx.setAdapter(cplx_adapter);
        spinner_cplx.setSelection(0);

        ArrayAdapter<String> ruse_adapter2 = new ArrayAdapter<String>(this, R.layout.custom_spinner, EMJ_RUSE_data);
        ruse_adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_ruse.setAdapter(ruse_adapter2);
        spinner_ruse.setSelection(0);

        ArrayAdapter<String> docu_adapter = new ArrayAdapter<String>(this, R.layout.custom_spinner, EMJ_DOCU_data);
        docu_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_docu.setAdapter(docu_adapter);
        spinner_docu.setSelection(0);

        ArrayAdapter<String> time_adapter = new ArrayAdapter<String>(this, R.layout.custom_spinner, EMJ_TIME_data);
        time_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_time.setAdapter(time_adapter);
        spinner_time.setSelection(0);

        ArrayAdapter<String> stor_adapter = new ArrayAdapter<String>(this, R.layout.custom_spinner, EMJ_STOR_data);
        stor_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_stor.setAdapter(stor_adapter);
        spinner_stor.setSelection(0);

        ArrayAdapter<String> pvol_adapter = new ArrayAdapter<String>(this, R.layout.custom_spinner, EMJ_PVOL_data);
        pvol_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_pvol.setAdapter(pvol_adapter);
        spinner_pvol.setSelection(0);

        ArrayAdapter<String> tool_adapter = new ArrayAdapter<String>(this, R.layout.custom_spinner, EMJ_TOOL_data);
        tool_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_tool.setAdapter(tool_adapter);
        spinner_tool.setSelection(0);

        ArrayAdapter<String> site_adapter = new ArrayAdapter<String>(this, R.layout.custom_spinner, EMJ_SITE_data);
        site_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_site.setAdapter(site_adapter);
        spinner_site.setSelection(0);

        ArrayAdapter<String> sced_adapter2 = new ArrayAdapter<String>(this, R.layout.custom_spinner, EMJ_SCED_data);
        sced_adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_sced.setAdapter(sced_adapter2);
        spinner_sced.setSelection(0);
//---------------------------------------------------------------------------------------------------------------------------

        calculate2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (kloc.getText().toString().equals("")){
                    kloc_relativeLayout2.setBackground(getResources().getDrawable(R.drawable.custom_background_false_small_radius));
                    resLayout.setBackground(getResources().getDrawable(R.drawable.custom_background_false));
                    calculate2.setBackground(getResources().getDrawable(R.drawable.custom_background_false));
                    Toast.makeText(getBaseContext(), "Заповніть, будь ласка, порожні поля поля!", Toast.LENGTH_LONG).show();
                }else{
                    pm.setText("");
                    kloc_relativeLayout2.setBackground(getResources().getDrawable(R.color.transparent));
                    resLayout.setBackground(getResources().getDrawable(R.drawable.custom_background_true));
                    calculate2.setBackground(getResources().getDrawable(R.drawable.custom_background_true));

                    double KLOC = Double.parseDouble(kloc.getText().toString());

                    List<String> SF_params = new ArrayList<>();
                        SF_params.add(prec_spinner.getSelectedItem().toString().replaceAll("[^0-9\\/an.]", ""));
                        SF_params.add(flex_spinner.getSelectedItem().toString().replaceAll("[^0-9\\/an.]", ""));
                        SF_params.add(resl_spinner.getSelectedItem().toString().replaceAll("[^0-9\\/an.]", ""));
                        SF_params.add(team_spinner.getSelectedItem().toString().replaceAll("[^0-9\\/an.]", ""));
                        SF_params.add(pmat_spinner.getSelectedItem().toString().replaceAll("[^0-9\\/an.]", ""));

                    switch (stage_spinner.getSelectedItem().toString()){
                        case "Попередня оцінка":
                            List<String> EMi_params_1 = new ArrayList<>();
                                EMi_params_1.add(pers_spinner.getSelectedItem().toString().replaceAll("[^0-9\\/an.]", ""));
                                EMi_params_1.add(prex_spinner.getSelectedItem().toString().replaceAll("[^0-9\\/an.]", ""));
                                EMi_params_1.add(rcpx_spinner.getSelectedItem().toString().replaceAll("[^0-9\\/an.]", ""));
                                EMi_params_1.add(ruse_spinner.getSelectedItem().toString().replaceAll("[^0-9\\/an.]", ""));
                                EMi_params_1.add(pdif_spinner.getSelectedItem().toString().replaceAll("[^0-9\\/an.]", ""));
                                EMi_params_1.add(fcil_spinner.getSelectedItem().toString().replaceAll("[^0-9\\/an.]", ""));
                                EMi_params_1.add(sced_spinner.getSelectedItem().toString().replaceAll("[^0-9\\/an.]", ""));

                            BigDecimal result = cocomo2_early_design_logic.calculate_early_design_stage(KLOC, SF_params, EMi_params_1);
                            pm.setText(result.toString());
                            break;
                        case "Детальна оцінка":
                            List<String> EMi_params_2 = new ArrayList<>();
                            EMi_params_2.add(spinner_acap.getSelectedItem().toString().replaceAll("[^0-9\\/an.]", ""));
                            EMi_params_2.add(spinner_aexp.getSelectedItem().toString().replaceAll("[^0-9\\/an.]", ""));
                            EMi_params_2.add(spinner_pcap.getSelectedItem().toString().replaceAll("[^0-9\\/an.]", ""));
                            EMi_params_2.add(spinner_pcon.getSelectedItem().toString().replaceAll("[^0-9\\/an.]", ""));
                            EMi_params_2.add(spinner_pexp.getSelectedItem().toString().replaceAll("[^0-9\\/an.]", ""));
                            EMi_params_2.add(spinner_ltex.getSelectedItem().toString().replaceAll("[^0-9\\/an.]", ""));
                            EMi_params_2.add(spinner_rely.getSelectedItem().toString().replaceAll("[^0-9\\/an.]", ""));
                            EMi_params_2.add(spinner_data.getSelectedItem().toString().replaceAll("[^0-9\\/an.]", ""));
                            EMi_params_2.add(spinner_cplx.getSelectedItem().toString().replaceAll("[^0-9\\/an.]", ""));
                            EMi_params_2.add(spinner_ruse.getSelectedItem().toString().replaceAll("[^0-9\\/an.]", ""));
                            EMi_params_2.add(spinner_docu.getSelectedItem().toString().replaceAll("[^0-9\\/an.]", ""));
                            EMi_params_2.add(spinner_time.getSelectedItem().toString().replaceAll("[^0-9\\/an.]", ""));
                            EMi_params_2.add(spinner_stor.getSelectedItem().toString().replaceAll("[^0-9\\/an.]", ""));
                            EMi_params_2.add(spinner_pvol.getSelectedItem().toString().replaceAll("[^0-9\\/an.]", ""));
                            EMi_params_2.add(spinner_tool.getSelectedItem().toString().replaceAll("[^0-9\\/an.]", ""));
                            EMi_params_2.add(spinner_site.getSelectedItem().toString().replaceAll("[^0-9\\/an.]", ""));
                            EMi_params_2.add(spinner_sced.getSelectedItem().toString().replaceAll("[^0-9\\/an.]", ""));

                            BigDecimal result2 = cocomo2_post_architecture_logic.calculate_post_architecture_stage(KLOC, SF_params, EMi_params_2);
                            pm.setText(result2.toString());
                            break;
                    }
                }
            }
        });

        button_exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(cocomo2.this, MainActivity.class);
                cocomo2.this.startActivity(intent);
                cocomo2.this.finish();
            }
        });
    }

    public void PREC_hint_function(View view) {
        Toast.makeText(getBaseContext(), getResources().getString(R.string.hint2_prec), Toast.LENGTH_LONG).show();
    }
    public void FLEX_hint_function(View view) {
        Toast.makeText(getBaseContext(), getResources().getString(R.string.hint2_flex), Toast.LENGTH_LONG).show();
    }
    public void RESL_hint_function(View view) {
        Toast.makeText(getBaseContext(), getResources().getString(R.string.hint2_resl), Toast.LENGTH_LONG).show();
    }
    public void TEAM_hint_function(View view) {
        Toast.makeText(getBaseContext(), getResources().getString(R.string.hint2_team), Toast.LENGTH_LONG).show();
    }
    public void PMAT_hint_function(View view) {
        Toast.makeText(getBaseContext(), getResources().getString(R.string.hint2_pmat), Toast.LENGTH_LONG).show();
    }
/*############################################################################################################################*/
    public void PERS_hint_function(View view) {
        Toast.makeText(getBaseContext(), getResources().getString(R.string.hint2_pers), Toast.LENGTH_LONG).show();
    }
    public void PREX_hint_function(View view) {
        Toast.makeText(getBaseContext(), getResources().getString(R.string.hint2_prex), Toast.LENGTH_LONG).show();
    }
    public void RCPX_hint_function(View view) {
        Toast.makeText(getBaseContext(), getResources().getString(R.string.hint2_rcpx), Toast.LENGTH_LONG).show();
    }
    public void RUSE_hint_function(View view) {
        Toast.makeText(getBaseContext(), getResources().getString(R.string.hint2_ruse), Toast.LENGTH_LONG).show();
    }
    public void PDIF_hint_function(View view) {
        Toast.makeText(getBaseContext(), getResources().getString(R.string.hint2_pdif), Toast.LENGTH_LONG).show();
    }
    public void FCIL_hint_function(View view) {
        Toast.makeText(getBaseContext(), getResources().getString(R.string.hint2_fcil), Toast.LENGTH_LONG).show();
    }
    public void SCED_hint_function(View view) {
        Toast.makeText(getBaseContext(), getResources().getString(R.string.hint2_sced), Toast.LENGTH_LONG).show();
    }
/*############################################################################################################################*/
    public void ACAP_hint_function(View view) {
        Toast.makeText(getBaseContext(), getResources().getString(R.string.hint2_acap), Toast.LENGTH_LONG).show();
    }
    public void AEXP_hint_function(View view) {
        Toast.makeText(getBaseContext(), getResources().getString(R.string.hint2_aexp), Toast.LENGTH_LONG).show();
    }
    public void PCAP_hint_function(View view) {
        Toast.makeText(getBaseContext(), getResources().getString(R.string.hint2_pcap), Toast.LENGTH_LONG).show();
    }
    public void PCON_hint_function(View view) {
        Toast.makeText(getBaseContext(), getResources().getString(R.string.hint2_pcon), Toast.LENGTH_LONG).show();
    }
    public void PEXP_hint_function(View view) {
        Toast.makeText(getBaseContext(), getResources().getString(R.string.hint2_pexp), Toast.LENGTH_LONG).show();
    }
    public void LTEX_hint_function(View view) {
        Toast.makeText(getBaseContext(), getResources().getString(R.string.hint2_ltex), Toast.LENGTH_LONG).show();
    }
    public void RELY_hint_function(View view) {
        Toast.makeText(getBaseContext(), getResources().getString(R.string.hint2_rely), Toast.LENGTH_LONG).show();
    }
    public void DATA_hint_function(View view) {
        Toast.makeText(getBaseContext(), getResources().getString(R.string.hint2_data), Toast.LENGTH_LONG).show();
    }
    public void CPLX_hint_function(View view) {
        Toast.makeText(getBaseContext(), getResources().getString(R.string.hint2_cplx), Toast.LENGTH_LONG).show();
    }
    public void RUSE2_hint_function(View view) {
        Toast.makeText(getBaseContext(), getResources().getString(R.string.hint2_resu), Toast.LENGTH_LONG).show();
    }
    public void DOCU_hint_function(View view) {
        Toast.makeText(getBaseContext(), getResources().getString(R.string.hint2_docu), Toast.LENGTH_LONG).show();
    }
    public void TIME_hint_function(View view) {
        Toast.makeText(getBaseContext(), getResources().getString(R.string.hint2_time), Toast.LENGTH_LONG).show();
    }
    public void STOR_hint_function(View view) {
        Toast.makeText(getBaseContext(), getResources().getString(R.string.hint2_stor), Toast.LENGTH_LONG).show();
    }
    public void PVOL_hint_function(View view) {
        Toast.makeText(getBaseContext(), getResources().getString(R.string.hint2_pvol), Toast.LENGTH_LONG).show();
    }
    public void TOOL_hint_function(View view) {
        Toast.makeText(getBaseContext(), getResources().getString(R.string.hint2_tool), Toast.LENGTH_LONG).show();
    }
    public void SITE_hint_function(View view) {
        Toast.makeText(getBaseContext(), getResources().getString(R.string.hint2_site), Toast.LENGTH_LONG).show();
    }
    public void SCED2_hint_function(View view) {
        Toast.makeText(getBaseContext(), getResources().getString(R.string.hint2_sced22), Toast.LENGTH_LONG).show();
    }
}