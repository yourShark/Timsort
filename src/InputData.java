import java.io.*;
import java.util.concurrent.ThreadLocalRandom;

public class InputData {
    public void addFile() throws IOException {

        File file = new File("src/file");
        PrintWriter pw = new PrintWriter(file);
        
        int size = 1;
        int value = 100;
        int min = -100000;
        int max = 100000;

        while (size <= 100) {
            for (int i = 0; i < value; i++) {
                int s = ThreadLocalRandom.current().nextInt(min,max);
                pw.print(s + " ");
            }
            size++;
            value=100*size;
            pw.println();
        }
        pw.close();
    }
}
