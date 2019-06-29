package com.rimpressao.exerciciolocacao.helpers;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

public class DinheiroHelper {

    public static String doubleParaDinheiro(double valor) {
        Locale ptBr = new Locale("pt", "BR");
        String valorString = NumberFormat.getCurrencyInstance(ptBr).format(valor);
        return valorString;
    }

    public static Double dinheiroParaDouble(String money) {
        Locale ptBr = new Locale("pt", "BR");
        try {
            if (money == null)
                return 0.00;
            Number valor = NumberFormat.getCurrencyInstance(ptBr).parse(money);
            return Double.parseDouble(valor.toString());
        } catch (ParseException e) {
            return 0.00;
        }
    }

    public static int converterReaisParaCentavos(double valor) {
        double real = valor;
        int centavos = (int) (real * 100); //drops off fractional amounts
        return centavos;
    }
}
