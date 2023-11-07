/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author alina
 */
package pwo.seq;

import java.math.BigDecimal;

public class LucasGenerator extends FibonacciGenerator {

    public LucasGenerator() {
        current = new BigDecimal(2);
        f_2 = new BigDecimal(2);
        lastIndex = 1; // Set lastIndex to 1 initially
    }

    @Override
    public void reset() {
        super.reset();
        current = new BigDecimal(2);
        f_2 = new BigDecimal(2);
        lastIndex = 1; // Reset lastIndex to 1
    }

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

