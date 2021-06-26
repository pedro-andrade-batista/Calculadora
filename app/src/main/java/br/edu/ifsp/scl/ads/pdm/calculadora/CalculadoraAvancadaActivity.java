package br.edu.ifsp.scl.ads.pdm.calculadora;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import br.edu.ifsp.scl.ads.pdm.calculadora.databinding.ActivityAvancadaCalculadoraBinding;

public class CalculadoraAvancadaActivity extends AppCompatActivity {
    private ActivityAvancadaCalculadoraBinding activityAvancadaCalculadoraBinding;
    private String calculation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityAvancadaCalculadoraBinding = ActivityAvancadaCalculadoraBinding.inflate(getLayoutInflater());

        getSupportActionBar().setTitle("Calculadora");
        getSupportActionBar().setSubtitle("Avançada");
        setContentView(activityAvancadaCalculadoraBinding.getRoot());

        calculation = activityAvancadaCalculadoraBinding.resultAdvancedTv.getText().toString();
    }

    public void onClick(View view) {
        switch (view.getId()){
            case R.id.number0Bt:
                fillTextView("0", false);
                break;
            case R.id.number1Bt:
                fillTextView("1", false);
                break;
            case R.id.number2Bt:
                fillTextView("2", false);
                break;
            case R.id.number3Bt:
                fillTextView("3", false);
                break;
            case R.id.number4Bt:
                fillTextView("4", false);
                break;
            case R.id.number5Bt:
                fillTextView("5", false);
                break;
            case R.id.number6Bt:
                fillTextView("6", false);
                break;
            case R.id.number7Bt:
                fillTextView("7", false);
                break;
            case R.id.number8Bt:
                fillTextView("8", false);
                break;
            case R.id.number9Bt:
                fillTextView("9", false);
                break;
            case R.id.plusBt:
                fillTextView("+", true);
                break;
            case R.id.lessBt:
                fillTextView("-", true);
                break;
            case R.id.divisionBt:
                fillTextView("/", true);
                break;
            case R.id.multiplyBt:
                fillTextView("*", true);
                break;
            case R.id.pointBt:
                fillTextView(".", false);
                break;
            case R.id.exponentiationBt:
                fillTextView("^", true);
                break;
            case R.id.squareBt:
                fillTextView("√", true);
                break;
            case R.id.percentBt:
                fillTextView("%", true);
                break;
        }
    }

    private void fillTextView(String number, Boolean operation) {
        if (activityAvancadaCalculadoraBinding.resultAdvancedTv.getText().toString().equals("0") && activityAvancadaCalculadoraBinding.resultAdvancedTv.getText().toString().length() == 1)
            clearInput(true);
        if(operation && (calculation.contains("+")) || calculation.contains("-") || calculation.contains("/") || calculation.contains("*"))
            getResult();

        calculation = activityAvancadaCalculadoraBinding.resultAdvancedTv.getText().toString();
        activityAvancadaCalculadoraBinding.resultAdvancedTv.setText(calculation.concat(number));
    }

    private void getResult() {
        calculation = activityAvancadaCalculadoraBinding.resultAdvancedTv.getText().toString();
        Object result;
        Util util = new Util();

        result = util.calculateResult(calculation);

        if(result != null){
            clearInput(false);
            activityAvancadaCalculadoraBinding.resultAdvancedTv.setText(result.toString());
        }
    }

    private void clearInput(Boolean firstTime) {
        if(firstTime)
            activityAvancadaCalculadoraBinding.resultAdvancedTv.setText("");
        else
            activityAvancadaCalculadoraBinding.resultAdvancedTv.setText("0");
    }

    public void onClickOperation(View view) {
        switch (view.getId()){
            case R.id.clearBt:
                clearInput(false);
                break;
            case R.id.equalsBt:
                calculation = activityAvancadaCalculadoraBinding.resultAdvancedTv.getText().toString();
                getResult();
                break;
        }
    }
}
