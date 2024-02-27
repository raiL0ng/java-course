package main.ru.sgu;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Scanner;


public class Bpp {
    public void run () {
        Scanner in = new Scanner(System.in);
        ArrayList<BigDecimal> ans = new ArrayList<>();
        try {
            while (in.hasNext()) {
                Double v = in.nextDouble();
                Double u = in.nextDouble();
                String oper = in.nextLine();
                BigDecimal a = new BigDecimal(v);
                BigDecimal b = new BigDecimal(u);
                if (oper.length() == 0) {
                    break;
                }
                if (oper.contains("ADD")) {
                    ans.add(a.add(b));
                } else if (oper.contains("SUB")) {
                    ans.add(a.subtract(b));
                } else if (oper.contains("MULT")) {
                    ans.add(a.multiply(b));
                } else if (oper.contains("DIV")) {
                    ans.add(a.divide(b));
                } else if (oper.contains("REM")) {
                    ans.add(a.remainder(b));
                } else if (oper.contains("POW")) {
                    int tmp = Integer.parseInt(b.toString());
                    ans.add(a.pow(tmp));
                } else {
                    System.out.println("Некорректный ввод операции!");
                    in.close();
                    return;
                }
            }
        } catch (Exception e) {
            System.out.println("Некорректный ввод данных!");
            return;
        } 
        System.out.println("Вывод результата операций:");
        for (BigDecimal el : ans) {
            System.out.println(el);
        }    
        in.close();
    }
}