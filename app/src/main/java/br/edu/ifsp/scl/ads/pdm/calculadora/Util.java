package br.edu.ifsp.scl.ads.pdm.calculadora;

public class Util {

    public Util() {
    }

    public Object calculateResult(String calculation){
        Double result = null;
        String[] numbers = getNumbers(calculation);
        if(numbers.length > 1 && (!calculation.contains("√") || !calculation.contains("%"))){
            if(calculation.contains("+"))
                result = Double.parseDouble(numbers[0]) + Double.parseDouble(numbers[1]);
            else if(calculation.contains("-"))
                result = Double.parseDouble(numbers[0]) - Double.parseDouble(numbers[1]);
            else if(calculation.contains("*"))
                result = Double.parseDouble(numbers[0]) * Double.parseDouble(numbers[1]);
            else if(calculation.contains("/"))
                result = numbers[1].equals("0") ? 0 : Double.parseDouble(numbers[0]) / Double.parseDouble(numbers[1]);
            else if(calculation.contains("^"))
                result = numbers[1].equals("0")? 1 : Math.pow(Double.parseDouble(numbers[0]), Double.parseDouble(numbers[1]));
        }
        else{
            if (calculation.contains("√"))
                result = Math.sqrt(Double.parseDouble(numbers[0]));
            else if(calculation.contains("%")){
                result = Double.parseDouble(numbers[0]) / 100;
            }
        }
        if(result != null && result.toString().endsWith(".0"))
            return result.intValue();
        return result;
    }

    private String[] getNumbers(String calculation) {
        String[] numbers;

        if(calculation.contains("+"))
            numbers = calculation.split("\\+");
        else if(calculation.contains("-"))
            numbers = calculation.split("-");
        else if(calculation.contains("*"))
            numbers = calculation.split("\\*");
        else if(calculation.contains("^"))
            numbers = calculation.split("\\^");
        else if(calculation.contains("√"))
            numbers = calculation.split("\\√");
        else if(calculation.contains("%"))
            numbers = calculation.split("%");
        else
            numbers = calculation.split("/");
        return numbers;
    }
}
