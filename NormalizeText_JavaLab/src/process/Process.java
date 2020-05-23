package process;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Admin
 */
public class Process {

    public String process(String s) {
        String result = "";
        String[] arrParagraph = splitParagraph(s);
        for (String string : arrParagraph) {
            result += formatParagraph(string) + "\n";
        }
        return result;
    }

    public String[] splitParagraph(String s) {
        s = s.replaceAll("\\n+", "\n");
        String[] arrParagraph = s.split("\n");
        return arrParagraph;
    }

    public String formatParagraph(String s) {
        s = s.trim().replaceAll("\\s+", " ").toLowerCase();
        StringBuilder sb = new StringBuilder(s);
        sb.setCharAt(0, Character.toUpperCase(sb.charAt(0)));
        if (sb.charAt(sb.length() - 1) != '.') {
            sb.append('.');
        }
        formatSpace1(sb);
        formatSpace2(sb,'(',')');
        formatSpace2(sb,'"','"');
        uppercaseCharAfterDot(sb);
        return sb.toString();
    }

    public StringBuilder uppercaseCharAfterDot(StringBuilder sb) {
        for (int i = 0; i < sb.length(); i++) {
            String ch = Character.toString(sb.charAt(i));
            if (ch.matches("[.?!]") && i + 2 < sb.length() - 2) {
                sb.setCharAt(i + 2, Character.toUpperCase(sb.charAt(i + 2)));
            }
        }
        return sb;
    }

    public StringBuilder formatSpace1(StringBuilder sb) {
        for (int i = 0; i < sb.length(); i++) {
            String ch = Character.toString(sb.charAt(i));
            if (i > 0 && i + 1 < sb.length()) {
                String next = Character.toString(sb.charAt(i + 1));
                String before = Character.toString(sb.charAt(i - 1));
                if (ch.matches("[.:,!?;]")) {
                    if (!next.equals(" ")) {
                        sb.insert(i + 1, " ");
                    }
                    if (before.equals(" ")) {
                        sb.deleteCharAt(i - 1);
                        i--;
                    }
                }
            }
        }
        return sb;
    }

    public StringBuilder formatSpace2(StringBuilder sb, char cOpen, char cClose) {
        int count = 0;
        for (int i = 0; i < sb.length(); i++) {
            if (i > 0 && i + 1 < sb.length()) {
                if (sb.charAt(i) == cOpen && count%2==0 ) {
                    count++;
                    if (sb.charAt(i - 1) != ' ') {
                        sb.insert(i, " ");
                        i++;
                    }
                    if (sb.charAt(i + 1) == ' ') {
                        sb.deleteCharAt(i + 1);
                    }
                }
                if (sb.charAt(i) == cClose && count%2==1 ) {
                    count++;
                    if (sb.charAt(i - 1) == ' ') {
                        sb.deleteCharAt(i - 1);
                        i--;

                    }
                    if (sb.charAt(i + 1) != ' ' && i < sb.length() - 2) {
                        sb.insert(i + 1, " ");
                    }
                }
            }
            if (i==0 && sb.charAt(i) == cOpen && sb.charAt(i + 1) == ' ' )
                sb.deleteCharAt(i + 1);
        }
        return sb;
    }
}
