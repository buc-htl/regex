import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {

        //normale Zeichen
        System.out.println("-- Zeichen --");
        Pattern pattern = Pattern.compile("abc");
        Matcher m = pattern.matcher("abc");
        System.out.println(m.matches());
        m = pattern.matcher("abcd");
        System.out.println(m.matches());

        //Character Classes
        System.out.println("-- Character Classes --");
        pattern = Pattern.compile("abc[aef]");
        m = pattern.matcher("abce");
        System.out.println(m.matches());


        //Character Classes - negation ([^abc])
        System.out.println("-- Character Classes - Negation --");
        pattern = Pattern.compile("abc[^ae]");
        m = pattern.matcher("abcf");
        System.out.println(m.matches());


        //Character Classes - range [a-zA-Z]
        System.out.println("-- Character Classes - ranges --");
        pattern = Pattern.compile("1a[a-z]47");
        m = pattern.matcher("1az47");
        System.out.println(m.matches());

        //Predefined character classes - example (\d \D \s)
        System.out.println("-- Predefined character classes --");
        pattern = Pattern.compile("r\\s7");
        m = pattern.matcher("r 7");
        System.out.println(m.matches());

        //any character (.)
        System.out.println("-- any character . --");
        pattern = Pattern.compile("r.7");
        m = pattern.matcher("ra7");
        System.out.println(m.matches());

        //quantifier ?
        System.out.println("-- Quantifier ? --");
        pattern = Pattern.compile("ra?7");
        m = pattern.matcher("r7");
        System.out.println(m.matches());

        //quantifier *
        System.out.println("-- Quantifier * --");
        pattern = Pattern.compile("ra*7");
        m = pattern.matcher("r7");
        System.out.println(m.matches());

        //quantifier +
        System.out.println("-- Quantifier + --");
        pattern = Pattern.compile("ra+7");
        m = pattern.matcher("r7");
        System.out.println(m.matches());

        //quantifier {n} - exactly n times
        System.out.println("-- Quantifier {n}  --");
        pattern = Pattern.compile("ra{2}7");
        m = pattern.matcher("raa7");
        System.out.println(m.matches());

        //quantifier {n,} - min n times
        System.out.println("-- Quantifier {n,}  --");
        pattern = Pattern.compile("ra{2,}7");
        m = pattern.matcher("raaa7");
        System.out.println(m.matches());

        //quantifier {n,m} - between n and m times
        System.out.println("-- Quantifier {n,m}  --");
        pattern = Pattern.compile("ra{2,5}7");
        m = pattern.matcher("raaa7");
        System.out.println(m.matches());

        //logical operator |
        System.out.println("-- logical operator |  --");
        pattern = Pattern.compile("cat|dog");
        m = pattern.matcher("dog");
        System.out.println(m.matches());

        //unicode categories
        System.out.println("-- unicode categories  --");
        //e.g. \p{L} matches any kind of letter from any language.
        pattern = Pattern.compile("1\\p{L}2");
        m = pattern.matcher("1ü2");
        System.out.println(m.matches());
        m = pattern.matcher("1ê2");
        System.out.println(m.matches());
        //for more unicode categories see: https://www.regular-expressions.info/unicode.html

        //groups
        System.out.println("-- groups  --");
        pattern = Pattern.compile("(hallo)\\s(.+)");
        m = pattern.matcher("hallo Welt!");
        System.out.println(m.matches());
        System.out.println(m.groupCount());
        System.out.println(m.group());
        for (int i = 0; i <= m.groupCount(); i++) {
            System.out.println(m.group(i));
        }

        //find
        System.out.println("-- find  --");
        pattern = Pattern.compile("a.b");
        m = pattern.matcher("xxxxxxa1bxxxxxxabbxxxxxxaabbbxx");
        while (m.find()){
            System.out.println(m.group());
        }

        //greedy
        System.out.println("-- greedy  --");
        pattern = Pattern.compile("<.+>");
        m = pattern.matcher("<h1>Tolle Überschrift</h1>");
        System.out.println(m.find());
        System.out.println(m.group());

        //non-greedy
        System.out.println("-- non greedy  --");
        pattern = Pattern.compile("<.+?>");
        m = pattern.matcher("<h1>Tolle Überschrift</h1>");
        System.out.println(m.find());
        System.out.println(m.group());
        System.out.println(m.find());
        System.out.println(m.group());


        //replaceFirst
        System.out.println("-- replaceFirst  --");
        pattern = Pattern.compile("1\\d2");
        m = pattern.matcher("aaa122aaa132aaa");
        System.out.println(m.replaceFirst("zzz"));

        //replaceAll
        System.out.println("-- replaceAll  --");
        pattern = Pattern.compile("1\\d2");
        m = pattern.matcher("aaa122aaa132aaa");
        System.out.println(m.replaceAll("zzz"));

        //regular expression used in the class String
        System.out.println("-- String class & regular expressions --");
        System.out.println("mut".matches("m.?t"));
        System.out.println("mat mut mit".replaceFirst("m.?t","xxx"));
        System.out.println("mat mut mit".replaceAll("m.?t","xxx"));
        System.out.println(Arrays.toString("mat---mut-mit--rups".split("-+")));



        //beginning of a line
        System.out.println("-- ^ beginning of a line  --");
        pattern = Pattern.compile("[0-9]");
        m = pattern.matcher("1a2b3c4");
        while (m.find()){
            System.out.println(m.group());
        }
        System.out.println("----- now with ^");
        pattern = Pattern.compile("^[0-9]");
        m = pattern.matcher("1a2b3c4");
        while (m.find()){
            System.out.println(m.group());
        }

        //end of a line
        System.out.println("-- $ end of a line  --");
        pattern = Pattern.compile("[0-9]$");
        m = pattern.matcher("1a2b3c4");
        while (m.find()){
            System.out.println(m.group());
        }


        //multiline
        System.out.println("-- multiline --");
        pattern = Pattern.compile("[0-9]");
        m = pattern.matcher("1a2b3c4\n5d6e7f8");
        while (m.find()){
            System.out.println(m.group());
        }
        System.out.println("-- by default ^ and $ match the beginning, respectively the end, of the whole input string.");
        pattern = Pattern.compile("[0-9]$");
        m = pattern.matcher("1a2b3c4\n5d6e7f8");
        while (m.find()){
            System.out.println(m.group());
        }
        System.out.println("-- with Pattern.MULTILINE, ^ and $ match  the beginning, respectively the end, of a line");
        pattern = Pattern.compile("[0-9]$",Pattern.MULTILINE);
        m = pattern.matcher("1a2b3c4\n5d6e7f8");
        while (m.find()){
            System.out.println(m.group());
        }

        System.out.println("--the dot . doesn't match newlines by default");
        pattern = Pattern.compile("a.*b");
        m = pattern.matcher("a343434kl\n34dfdfb");
        System.out.println(m.matches());

        System.out.println("--with Pattern.DOTALL the dot . also matches newlines");
        pattern = Pattern.compile("a.*b",Pattern.DOTALL);
        m = pattern.matcher("a343434kl\n34dfdfb");
        System.out.println(m.matches());

        //!!! Achtung !!! Je nach Betriebssystem und verwendetem Programm werden Zeilenumbrüche unterschiedlich kodiert.
        //Siehe: https://de.wikipedia.org/wiki/Zeilenumbruch#ASCII_und_EBCDIC


    }

}
