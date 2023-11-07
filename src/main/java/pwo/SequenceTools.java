package pwo;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import pwo.seq.Generator;

public class SequenceTools {

    public static boolean writeToFile(
            FibonacciGenerator generator,
            int from, int to,
            String fileName) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
            for (int i = from; i <= to; i++) {
                writer.write(generator.getTerm(i) + "\n");
            }
            writer.close();
        } catch (IOException ex) {
            return false;
        }
        return true;
    }
    public static String getTermsAsColumn(Generator generator, int from, int to) {
StringBuilder column = new StringBuilder();
for (int i = from; i <= to; i++) {
column.append(generator.getTerm(i)).append("\n");
}
return column.toString();
}
    
}
