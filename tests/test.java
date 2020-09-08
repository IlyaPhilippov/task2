import org.junit.Test;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.*;

public class test {
    @Test
    public void analise() {
        assertThrows(IllegalArgumentException.class, () -> new Analyzer(new String[] {"-d", "567", "testname.txt", "key", "outputname.txt", "1212"}).analise());
    }

    @Test
    public void begin() throws IOException {
        File expected = new File("expected1.txt");
        String res = new String(Files.readAllBytes(Paths.get("inputfile1.txt")));
        String[] words = res.split(" ");
        Crypter crypto = new Crypter("123", words, "actual1.txt");
        crypto.begin();
        String actual1 = new String(Files.readAllBytes(Paths.get("actual1.txt")));
        String[] wordsact = actual1.split(" ");
        String expected1 = new String(Files.readAllBytes(Paths.get("expected1.txt")));
        String[] wordsexp = expected1.split(" ");
        for (int i = 0; i < wordsexp.length; i++) {
            if (!wordsexp[i].equals(wordsact[i])) assert false;
        }
        assert true;
    }
}
