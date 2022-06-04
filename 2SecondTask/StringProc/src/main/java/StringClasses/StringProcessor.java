package StringClasses;

public class StringProcessor {

    public static String CopyString(String s, int n) {
        if (n < 0) {
            throw new IllegalArgumentException();
        }
        return String.valueOf(s).repeat(n);
    }


    public static int CountEnter(String mainString, String strToFind) {
        if (mainString == null || strToFind == null || mainString.isEmpty() || strToFind.isEmpty()) {
            throw new IllegalArgumentException("some of strings is null");
        }
        int count = 0;
        int index = mainString.indexOf(strToFind);
        while (index != -1) {
            count++;
            index = mainString.indexOf(strToFind, index + 1);
        }
        return count;

    }

    public static String ReplaceStr(String s) {
        if (s == null) throw new IllegalArgumentException();
        String newString = s.replace("1", "один");
        String newString2 = newString.replace("2", "два");
        return newString2.replace("3", "три");
    }

    public static StringBuilder deleteSymbol(StringBuilder s) {
        if (s == null) throw new IllegalArgumentException();
        StringBuilder sb = new StringBuilder(s);
        int i = s.length() - s.length() % 2 - 1;
        for (; i > 0; i -= 2) {
            sb.deleteCharAt(i);
        }
        return new StringBuilder(sb.toString());
    }



}