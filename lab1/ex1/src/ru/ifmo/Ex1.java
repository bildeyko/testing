package ru.ifmo;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by bilde_000 on 30.03.2016.
 */
public class Ex1 {

    public double sec(double x, double accuracy) {
        double y = 0;
        int i = 0;
        boolean negative = false;
        if ((x > Math.PI/2))
        {
            int buf = (int) (x * 2 / Math.PI);
            buf = --buf / 2;
            if (buf % 2 == 0)
                negative = true;
            x -= Math.PI * (1 + buf);
        }
        if ((x < -Math.PI/2)) {
            int buf = (int) (-x * 2 / Math.PI);
            buf = --buf / 2;
            if (buf % 2 == 0)
                negative = true;
            x += Math.PI * (1 + buf);
        }

        if(x == Double.NEGATIVE_INFINITY || x == Double.POSITIVE_INFINITY)
            return Double.NaN;

        while (true) {
            BigDecimal tmpBig = getEuler(i).multiply(BigDecimal.valueOf(Math.pow(x, i)));
            tmpBig = tmpBig.divide(factorial(i), BigDecimal.valueOf(accuracy).scale(), RoundingMode.HALF_UP);

            Double tmpDouble = Math.abs(tmpBig.doubleValue());

            if (tmpDouble > accuracy)
                y += tmpDouble;
            else
                break;
            i = i + 2;
        }

        if (negative == true)
            return -y;
        else return y;
    }


    private BigDecimal getEuler(int n) {
        if (n == 0)
            return BigDecimal.valueOf(1L);
        if (n % 2 != 0)
            return BigDecimal.valueOf(0L);
        else {
            int m;
            List<BigDecimal> eulerNums = new ArrayList<>();
            eulerNums.add(BigDecimal.valueOf(1L));
            eulerNums.add(BigDecimal.valueOf(0L));
            m = n / 2 - 1;
            for (int i = 1; i <= m; i++) {
                BigDecimal eil = BigDecimal.valueOf(0L);
                for (int j = 0; j < i; j++) {
                    BigDecimal tmp = factorial(2 * i);
                    tmp = tmp.multiply(eulerNums.get(2 * j));
                    tmp = tmp.divide(factorial(2 * i - 2 * j));
                    tmp = tmp.divide(factorial(2 * j));
                    eil = eil.add(tmp);
                }
                eil = eil.multiply(BigDecimal.valueOf(-1L));
                eulerNums.add(eil);
                eulerNums.add(BigDecimal.valueOf(0L));
            }
            BigDecimal eil = BigDecimal.valueOf(0L);
            for (int j = 0; j <= m; j++) {
                BigDecimal tmp = factorial(n);
                tmp = tmp.multiply(eulerNums.get(2 * j));
                tmp = tmp.divide(factorial(n - 2 * j));
                tmp = tmp.divide(factorial(2 * j));
                eil = eil.add(tmp);
            }
            eil = eil.multiply(BigDecimal.valueOf(-1L));
            return eil;
        }
    }

    private BigDecimal factorial(int num) {
        BigDecimal fact = BigDecimal.valueOf(1);

        for (; num > 0; fact = fact.multiply(BigDecimal.valueOf(num--))) ;

        return fact;
    }

}
