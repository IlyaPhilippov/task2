public class Analyzer {
    private String key;
    private String inputname;
    private String outputname;
    private String[] arguments;

    public Analyzer(String[] arguments) {
        this.arguments = arguments;
    }

    public void analise() {
        if (arguments.length > 4)
            throw new IllegalArgumentException("Error");

        int index;
        boolean oStatus = false;
        for (index = 0; index < arguments.length; index++) {
            switch (arguments[index]) {
                case "-c":
                case "-d":
                    key = arguments[index + 1];
                    index++;
                    break;
                case "-o":
                    oStatus = true;
                    outputname = arguments[index + 1];
                    index++;
                    break;
                default:
                    inputname = arguments[index];
            }
        }

        if (!oStatus) outputname = inputname;
    }

    public String getKey() {
        return key;
    }

    public String getInputname() {
        return inputname;
    }

    public String getOutputname() {
        return outputname;
    }


}