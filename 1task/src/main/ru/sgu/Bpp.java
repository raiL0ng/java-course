package main.ru.sgu;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Scanner;


public class Bpp {

    // public enum ArifmOpers {

    //     ADD("ADD"),
    //     SUB("SUB"),
    //     MULT("MULT"),
    //     DIV("DIV"),
    //     REM("REM"),
    //     MOD("MOD");
        
    //     private String oper;
        
    //     ArifmOpers(String oper) {
    //         this.oper = oper;
    //     }




    // }

    private BigDecimal getResult(String[] opers) {
        BigDecimal res = null;
        try {

            if (opers.length != 3)
                return null;
            BigDecimal a = new BigDecimal(opers[0]);
            BigDecimal b = new BigDecimal(opers[1]);
            switch (opers[2]) {
                case "ADD":
                    res = a.add(b);
                    break;
                case "SUB":
                    res = a.subtract(b);
                    break;
                case "MULT":
                    res = a.multiply(b);
                    break;
                case "DIV":
                    res = a.divide(b);
                    break;
                case "REM":
                    res = a.remainder(b);
                    break;
                case "POW":
                    int tmp = Integer.parseInt(b.toString());
                    res = a.pow(tmp);
                default:
                    break;
            }
        } catch (Exception e) {
            return null;
        }
        return res;
    }

    public void run() {
        Scanner in = new Scanner(System.in);
        ArrayList<BigDecimal> ans = new ArrayList<>();
            System.out.println("Введите операцию в формате \"число1 число2 операция\":");
            while (in.hasNext()) {
                String[] row = in.nextLine().split(" ");
                BigDecimal res = getResult(row);
                // System.out.println(res);
                if (res != null) {
                    ans.add(res);
                }
                else {
                    System.out.println("Некорректный ввод данных!");
                }
            }
        System.out.println("Вывод результата операций:");
        for (BigDecimal el : ans) {
            System.out.println(el);
        }
        // in.close(); 
    }
}