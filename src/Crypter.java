import java.io.FileOutputStream;
import java.io.IOException;

public class Crypter {
    private String key;
    private String[] words;
    private String outputname;

    public Crypter(String key, String[] words, String outputname) throws IOException {
        this.key = key;
        this.words = words;
        this.outputname = outputname;
    }

    public void begin() throws IOException {
       FileOutputStream out = new FileOutputStream(outputname);

       String hexDigits = "0123456789ABCDEF";
        key = key.toUpperCase();
       int result = 0;
       for (int i = 0; i < key.length(); i++) {
           char c = key.charAt(i);
           int hexhDigit = hexDigits.indexOf(c);
           result += 16 * result + hexhDigit;
       }

        for (String word : words) {
            byte[] arr = word.getBytes();
            byte[] res = new byte[arr.length];
            for (int j = 0; j < arr.length; j++) {
                if (arr[j] == 10) {
                    out.write(10);
                }
                if (arr[j] != 10) {
                    res[j] = (byte) (arr[j] ^ result);
                    out.write(res[j]);
                }
            }
            out.write(32);
        }
   }
}