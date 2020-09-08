import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class task2 {

    public static void main(String[] args) throws IOException {
        Analyzer start = new Analyzer(args);
        start.analise();
        String inputname = start.getInputname();
        String outputname = start.getOutputname();
        String res = new String(Files.readAllBytes(Paths.get(inputname)));
        String[] words = res.split(" ");
        Crypter crypto = new Crypter(start.getKey(), words, outputname);
        crypto.begin();
    }

}