package main.ru.sgu;

import java.math.BigInteger;
import java.util.concurrent.RecursiveTask;

public class Bpp extends RecursiveTask<BigInteger> {
    private final BigInteger n;

    public Bpp(BigInteger n) {
        this.n = n;
    }
    
    public boolean checkValue() {
        return n.compareTo(BigInteger.ZERO) >= 0;
    }

    @Override
    protected BigInteger compute() {
        if (n.compareTo(BigInteger.ONE) <= 0)
            return n;
        Bpp f1 = new Bpp(n.subtract(BigInteger.ONE));
        f1.fork();
        Bpp f2 = new Bpp(n.subtract(BigInteger.TWO));
        return f2.compute().add(f1.join());
    }
}
