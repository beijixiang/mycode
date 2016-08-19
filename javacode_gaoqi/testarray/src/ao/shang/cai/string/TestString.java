package ao.shang.cai.string;

/**
 * Created by 蔡尚澳 on 2016/7/9.
 */

public class TestString {
    public static void main(String[] args) {
        String str = new String("abcd");
        String str2 = new String("abcd");
        System.out.println(str.charAt(2));
        System.out.println(str.equals(str2));
        System.out.println(str==str2);

        String str3 = "def";
        String str4 = "def";
        System.out.println(str3.equals(str4));
        System.out.println(str3==str4);

        System.out.println(str3.indexOf('e'));
        String s = str3.substring(0);
        System.out.println(s);

        String str5 = str3.replace('e', '*');
        System.out.println(str5);

        String str6 = "sdad,dasda,asdad";
        String[] stringArray = str6.split(",");
        for (int i = 0; i <stringArray.length ; i++) {
            System.out.println(stringArray[i]);
        }

        String str7 = "  aa  bb  ";
        String str77= str7.trim();
        System.out.println(str77.length());

        System.out.println("Abcbd".equalsIgnoreCase("abcbd"));
        System.out.println("Abcbd".indexOf("b"));
        System.out.println("Abcbd".lastIndexOf("b"));
        System.out.println("Abcbd".startsWith("Ab"));
        System.out.println("Abcbd".endsWith("bd"));
        System.out.println("Abcbd".toLowerCase());
        System.out.println("Abcbd".toUpperCase());

        System.out.println("################################");

        StringBuilder gh = new StringBuilder("a");
        for (int i = 0; i < 10; i++) {
            gh.append(i);

        }
        System.out.println(gh);
    }
}

