/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 * CLI application for writing a sequence to a file.
 * Parses command-line arguments, validates them, and writes the sequence to the specified file.
 * Requires the SeqType enum for sequence type identification and SequenceTools for utility methods.
 *
 * @author alina
 */
package pwo.app;

import pwo.seq.SeqType;
import pwo.utils.SequenceTools;

import java.nio.file.Paths;
import java.nio.file.InvalidPathException;

/**
 * Base class for CLI applications that write a sequence to a file.
 */
class SeqToFileApp {

    // Instance variables for storing command-line arguments
    protected SeqType seqType = null;
    protected Integer from = null, to = null;
    protected String fileName = null;

    /**
     * Parses and validates command-line arguments.
     *
     * @param args Command-line arguments.
     * @return true if arguments are valid; false otherwise.
     */
    protected boolean getArgs(String[] args) {
        try {
            // Parse command-line arguments
            seqType = SeqType.fromString(args[0]);
            from = Integer.parseInt(args[1]);
            to = Integer.parseInt(args[2]);
            fileName = args[3];
        } catch (ArrayIndexOutOfBoundsException | NumberFormatException ex) {
            return false;
        }

        // Validate file path
        try {
            Paths.get(fileName);
        } catch (InvalidPathException ex) {
            return false;
        }

        // Check if required arguments are provided and are valid
        return seqType != null && from >= 0 && to >= 0;
    }

    /**
     * Writes the sequence to the specified file.
     *
     * @return true if writing to the file is successful; false otherwise.
     */
    protected boolean writeSeq() {
        return SequenceTools.writeToFile(seqType.getGenerator(), from, to, fileName);
    }

    /**
     * Executes the CLI application for writing a sequence to a file.
     *
     * @param args Command-line arguments.
     */
    public void run(String[] args) {
        System.out.println("Sequence to file CLI app");

        // Check if command-line arguments are valid
        if (!getArgs(args)) {
            System.out.println("!Illegal arguments\n" + "Legal usage: seqName from to fileName");
            return;
        }

        // Write the sequence to the file
        if (!writeSeq()) {
            System.out.println("!Write to the file: " + fileName + " FAILED");
            return;
        }

        System.out.println("Results write to " + fileName);
    }
}
