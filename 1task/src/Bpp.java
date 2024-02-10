import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Scanner;

public class Bpp {
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        ArrayList<BigDecimal> ans = new ArrayList<>();
        while (in.hasNextLine()) {
            Double v = in.nextDouble();
            Double u = in.nextDouble();
            String oper = in.nextLine();
            BigDecimal a = new BigDecimal(v);
            BigDecimal b = new BigDecimal(u);
            if (oper.contains("ADD")) {
                ans.add(a.add(b));
            } else if (oper.contains("SUB")) {
                ans.add(a.subtract(b));
            } else if (oper.contains("MULT")) {
                ans.add(a.multiply(b));
            } else if (oper.contains("DIV")) {
                if (b.equals(BigDecimal.ZERO)) {
                    System.out.println("None: (деление на ноль!)");
                    System.exit(0);
                }
                else {
                    ans.add(a.divide(b));
                }
            } else if (oper.contains("REM")) {
                ans.add(a.remainder(b));
            } else if (oper.contains("POW")) {
                ans.add(a.pow(Integer.parseInt(b.toString())));
            } else {
                System.out.println("None");
                System.exit(0);
            }
        }
        for (BigDecimal el : ans) {
            System.out.println(el);
        }
        in.close();
    }
}