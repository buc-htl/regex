import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexExample {

    public static void main(String[] args) {


        Pattern pattern = Pattern.compile("a.*b", Pattern.DOTALL);
        Matcher  m = pattern.matcher("a343434kl\n34dfdfb");
        System.out.println(m.matches());

    }


}
