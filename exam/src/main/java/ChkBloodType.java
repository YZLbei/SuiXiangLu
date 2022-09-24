import java.util.*;

public class ChkBloodType {
    static public String[] chkBlood(String father, String mother) {
        HashMap<String, String[]> strMap = new HashMap<>();
        strMap.put("OO", new String[] { "O" });
        strMap.put("AO", new String[] { "A", "O" });
        strMap.put("AA", new String[] { "A", "O" });
        strMap.put("AB", new String[] { "A", "AB", "B", "O" });
        strMap.put("AAB", new String[] { "A", "AB", "B" });
        strMap.put("BO", new String[] { "B", "O" });
        strMap.put("BB", new String[] { "B", "O" });
        strMap.put("BAB", new String[] { "A", "AB", "B" });
        strMap.put("ABO", new String[] { "A", "B" });
        strMap.put("ABAB", new String[] { "A", "AB", "B" });
        if (strMap.containsKey(father + mother)) {
            return strMap.get(father + mother);
        } else {
           return strMap.get(mother + father);
        }
    }

    public static void main(String[] args) {
        String[] res = chkBlood("A", "A");
        for (int i = 0; i < res.length; i++) {
            System.out.println(res[i]);
        }
    }
}