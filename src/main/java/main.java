import parser.Parser;

public class main {
    public static void main(String[] args) {
        String example = "" +
                ".wrapper{\n" +
                "    border-radius: ;\n" +
                "    margin: 0 auto;\n" +
                "}";
        Parser parser = new Parser();
        System.out.println(parser.parse(example));
    }
}
