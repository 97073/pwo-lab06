/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 * This abstract class serves as a base class for sequence generators, implementing the SequenceGenerator interface.
 * It provides common functionality for managing sequence state and obtaining terms.
 * Subclasses are expected to implement the specific logic for generating sequence values.
 *
 * @author alina
 */
package pwo.seq;

import java.math.BigDecimal;
import pwo.utils.SequenceGenerator;

public abstract class Generator implements SequenceGenerator {

    // Common fields for managing sequence state
    protected int lastIndex = 0;
    protected BigDecimal current = null,
            f_1 = null,
            f_2 = null,
            f_3 = null;

    /**
     * Resets the sequence generator to its initial state.
     */
    @Override
    public void reset() {
        lastIndex = 0;
    }

    /**
     * Retrieves the term at the specified index in the sequence.
     *
     * @param i The index of the term to retrieve.
     * @return The term at the specified index.
     * @throws IllegalArgumentException if the index is less than 0.
     */
    @Override
    public final BigDecimal getTerm(int i) {
        if (i < 0) {
            throw new IllegalArgumentException();
        }
        if (i < lastIndex) {
            reset();
        }
        while (lastIndex <= i) {
            nextTerm();
        }
        return current;
    }

    /**
     * Abstract method to be implemented by subclasses.
     * Generates and returns the next term in the sequence.
     *
     * @return The next term in the sequence.
     */
    public abstract BigDecimal nextTerm();
}
