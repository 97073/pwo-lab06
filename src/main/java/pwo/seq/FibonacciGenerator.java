package pwo.seq;

import java.math.BigDecimal;
import pwo.utils.SequenceGenerator;

public class FibonacciGenerator extends Generator {

    private BigDecimal[] cache;

    public FibonacciGenerator() {
        super();
        cache = new BigDecimal[100]; // Ustal odpowiednią wielkość bufora
        initializeCache();
    }

    private void initializeCache() {
        for (int i = 0; i < cache.length; i++) {
            cache[i] = null;
        }
        cache[0] = new BigDecimal(0);
        cache[1] = new BigDecimal(1);
    }

    @Override
    public void reset() {
        super.reset();
        initializeCache();
    }

    @Override
    public BigDecimal nextTerm() {
        if (lastIndex >= cache.length) {
            expandCache();
        }

        if (cache[lastIndex] == null) {
            cache[lastIndex] = cache[lastIndex - 1].add(cache[lastIndex - 2]);
        }

        current = cache[lastIndex];
        lastIndex++;
        return current;
    }

    private void expandCache() {
        int newSize = cache.length * 2;
        BigDecimal[] newCache = new BigDecimal[newSize];
        System.arraycopy(cache, 0, newCache, 0, cache.length);
        cache = newCache;
    }
    

}
