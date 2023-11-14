/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 * The main class for the sequence application. It parses command-line arguments
 * and delegates the execution to either SeqToOutApp or SeqToFileApp based on the
 * number of provided arguments.
 *
 * @author alina
 */
package pwo.app;

public class Sequence {

    /**
     * The main method for the sequence application.
     *
     * @param args Command-line arguments. Expects either 3 or 4 arguments:
     *             - seqName: Name of the sequence
     *             - from: Starting index of the sequence
     *             - to: Ending index of the sequence
     *             - [fileName]: Optional - Name of the file to write the sequence to
     */
    public static void main(String[] args) {

        // Parse command-line arguments and delegate execution to the appropriate app
        switch (args.length) {
            case 3:
                (new SeqToOutApp()).run(args);
                break;
            case 4:
                (new SeqToFileApp()).run(args);
                break;
            default:
                System.out.println("!Illegal arguments\n"
                        + "Legal usage: seqName from to [fileName]");
        }
    }
}
