/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 * This class represents a Lucas sequence generator, extending the FibonacciGenerator class.
 * It generates Lucas sequence values using the formula f(n) = f(n-1) + f(n-2) with initial values f(0) = 2, f(1) = 2.
 * For more information on Lucas sequences, refer to:
 * @see <a href="https://en.wikipedia.org/wiki/Lucas_number">Wikipedia</a>
 *
 * @author alina
 */
package pwo.seq;

import java.math.BigDecimal;

public class LucasGenerator extends FibonacciGenerator {

    /**
     * Constructs a LucasGenerator object, initializing the current value to 2, f_2 to 2, and lastIndex to 1.
     */
    public LucasGenerator() {
        current = new BigDecimal(2);
        f_2 = new BigDecimal(2);
        lastIndex = 1; // Set lastIndex to 1 initially
    }

    /**
     * Resets the generator to its initial state, including setting the current value, f_2, and lastIndex.
     */
    @Override
    public void reset() {
        super.reset(); // Call the reset method of the parent class
        current = new BigDecimal(2);
        f_2 = new BigDecimal(2);
        lastIndex = 1; // Reset lastIndex to 1
    }

    /**
     * Generates and returns the next term in the Lucas sequence, skipping the first term calculation.
     * If the generator is at the first term, it increments the lastIndex and returns the current value.
     *
     * @return The next term in the Lucas sequence.
     */
    @Override
    public BigDecimal nextTerm() {
        // You can skip the first term calculation by incrementing lastIndex
        if (lastIndex == 1) {
            lastIndex++;
            return current;
        }

        return super.nextTerm();
    }
}
