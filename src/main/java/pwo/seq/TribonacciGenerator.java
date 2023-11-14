/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 * This class represents a Tribonacci sequence generator, extending the FibonacciGenerator class.
 * It generates Tribonacci sequence values using the formula f(n) = f(n-1) + f(n-2) + f(n-3).
 * For more information on Tribonacci sequences, refer to: 
 * @see <a href="https://pl.wikipedia.org/wiki/Ci%C4%85g_Fibonacciego#Ci%C4%85g_%E2%80%9ETribonacciego%E2%80%9D">Wikipedia</a>
 *
 * @author alina
 */
package pwo.seq;

import java.math.BigDecimal;

public class TribonacciGenerator extends FibonacciGenerator {

    // The third term in the Tribonacci sequence
    private BigDecimal f_3;

    /**
     * Constructs a TribonacciGenerator object, initializing the third term to 0.
     */
    public TribonacciGenerator() {
        f_3 = new BigDecimal(0);
    }

    /**
     * Resets the generator to its initial state, including the third term.
     */
    @Override
    public void reset() {
        super.reset(); // Call the reset method of the parent class
        f_3 = new BigDecimal(0);
    }

    /**
     * Generates and returns the next term in the Tribonacci sequence.
     *
     * @return The next term in the Tribonacci sequence.
     */
    @Override
    public BigDecimal nextTerm() {
        if (lastIndex > 2) {
            current = f_1.add(f_2).add(f_3);
            f_3 = f_2;
            f_2 = f_1;
            f_1 = current;
        } else if (lastIndex == 2) {
            current = new BigDecimal(1);
        } else {
            current = new BigDecimal(0);
        }
        lastIndex++;
        return current;
    }
}
