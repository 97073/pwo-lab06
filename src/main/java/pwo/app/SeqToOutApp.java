/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pwo.app;

import pwo.SequenceTools;
import pwo.seq.Generator;

/**
 * CLI application for displaying a sequence to the terminal.
 * Extends SeqToFileApp, inheriting its functionality for handling command-line arguments.
 * Overrides methods to validate arguments and write the sequence to the terminal.
 *
 * @author alina
 */
public class SeqToOutApp extends SeqToFileApp {

    /**
     * Validates command-line arguments for displaying the sequence to the terminal.
     *
     * @param args Command-line arguments.
     * @return true if the arguments are valid; false otherwise.
     */
    @Override
    protected boolean getArgs(String[] args) {
        if (super.getArgs(args)) return true;

        // Check if required arguments are provided
        return seqType != null && from >= 0 && to >= 0;
    }

    /**
     * Writes the sequence to the terminal.
     *
     * @return true if writing to the terminal is successful; false otherwise.
     */
    @Override
    protected boolean writeSeq() {
        System.out.println(SequenceTools.getTermsAsColumn(seqType.getGenerator(), from, to));
        return true;
    }

    /**
     * Executes the CLI application for displaying the sequence to the terminal.
     *
     * @param args Command-line arguments.
     */
    @Override
    public void run(String[] args) {
        System.out.println("Sequence to terminal CLI app");

        // Check if command-line arguments are valid
        if (!super.getArgs(args)) {
            System.out.println("!Illegal arguments\n"
                    + "Legal usage: seqName from to");
            return;
        }

        // Write the sequence to the terminal
        writeSeq();
    }
}
