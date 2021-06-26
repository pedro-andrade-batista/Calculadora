package br.edu.ifsp.scl.ads.pdm.calculadora;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import br.edu.ifsp.scl.ads.pdm.calculadora.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding activityMainBinding;
    private String calculation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityMainBinding = ActivityMainBinding.inflate(getLayoutInflater());

        getSupportActionBar().setTitle("Calculadora");
        getSupportActionBar().setSubtitle("Simples");
        setContentView(activityMainBinding.getRoot());

        calculation = activityMainBinding.resultTv.getText().toString();
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
        }
    }

    private void fillTextView(String number, Boolean operation) {
        if (activityMainBinding.resultTv.getText().toString().equals("0") && activityMainBinding.resultTv.getText().toString().length() == 1)
            clearInput(true);

        if(operation && (calculation.contains("+")) || calculation.contains("-") || calculation.contains("/") || calculation.contains("*"))
            getResult();

        calculation = activityMainBinding.resultTv.getText().toString();
        activityMainBinding.resultTv.setText(calculation.concat(number));
    }

    private void getResult() {
        calculation = activityMainBinding.resultTv.getText().toString();
        Object result;
        Util util = new Util();

        result = util.calculateResult(calculation);

        if(result != null){
            clearInput(false);
            activityMainBinding.resultTv.setText(result.toString());
        }
    }

    private void clearInput(Boolean firstTime) {
        if(firstTime)
            activityMainBinding.resultTv.setText("");
        else
            activityMainBinding.resultTv.setText("0");
    }

    public void onClickOperation(View view) {
        switch (view.getId()){
            case R.id.clearBt:
                clearInput(false);
                break;
            case R.id.equalsBt:
                calculation = activityMainBinding.resultTv.getText().toString();
                getResult();
                break;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.calculadora_avancada, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.calculadoraAvancadoMi:
                Intent calcAdvanced = new Intent(this, CalculadoraAvancadaActivity.class);
                startActivity(calcAdvanced);
                return true;
            default:
                return false;
        }

    }
}