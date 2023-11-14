package pwo.seq;

import java.math.BigDecimal;
import pwo.utils.SequenceGenerator;

/**
 * This class represents a Fibonacci sequence generator, extending the Generator class.
 * It generates Fibonacci sequence values using the formula f(n) = f(n-1) + f(n-2).
 * The generator uses a caching mechanism to store previously computed values for efficiency.
 *
 * @author [Author Name]
 */
public class FibonacciGenerator extends Generator {

    // Array to cache Fibonacci sequence values
    private BigDecimal[] cache;

    /**
     * Constructs a FibonacciGenerator object, initializing the cache and setting initial values for f(0) and f(1).
     */
    public FibonacciGenerator() {
        super(); // Call the constructor of the parent class
        cache = new BigDecimal[100]; // Set an appropriate buffer size
        initializeCache();
    }

    /**
     * Initializes the cache array, setting values for f(0) and f(1).
     */
    private void initializeCache() {
        for (int i = 0; i < cache.length; i++) {
            cache[i] = null;
        }
        cache[0] = new BigDecimal(0);
        cache[1] = new BigDecimal(1);
    }

    /**
     * Resets the generator to its initial state, including reinitializing the cache.
     */
    @Override
    public void reset() {
        super.reset(); // Call the reset method of the parent class
        initializeCache();
    }

    /**
     * Generates and returns the next term in the Fibonacci sequence using a caching mechanism.
     * If the value is not already computed, it calculates it and stores it in the cache for future use.
     *
     * @return The next term in the Fibonacci sequence.
     */
    @Override
    public BigDecimal nextTerm() {
        if (lastIndex >= cache.length) {
            expandCache();
        }

        if (cache[lastIndex] == null) {
            // Calculate and store the Fibonacci value in the cache
            cache[lastIndex] = cache[lastIndex - 1].add(cache[lastIndex - 2]);
        }

        current = cache[lastIndex];
        lastIndex++;
        return current;
    }

    /**
     * Expands the size of the cache array when needed.
     */
    private void expandCache() {
        int newSize = cache.length * 2;
        BigDecimal[] newCache = new BigDecimal[newSize];
        System.arraycopy(cache, 0, newCache, 0, cache.length);
        cache = newCache;
    }
}
