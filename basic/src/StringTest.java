import java.io.UnsupportedEncodingException;

/**
 * Created by mars on 2017/2/7.
 */
public class StringTest {
    public static void main(String... args) {

        {
            String baseStr = "baseStr";
            final String baseFinalStr = "baseStr";
            String str1 = "baseStr01";
            String str2 = "baseStr" + "01";
            String str3 = baseStr + "01";
            String str4 = baseFinalStr + "01";
            String str5 = new String("baseStr01").intern();
            System.out.println(str1 == str2);
            System.out.println(str1 == str3);
            System.out.println(str1 == str4);
            System.out.println(str1 == str5);
            System.out.println("**********");
        }

        {
            String str2 = new String("str")+new String("01");
            str2.intern();
            String str1 = "str01";
            System.out.println(str2==str1);
            System.out.println("**********");
        }

        {
            String str1 = "str01";
            String str2 = new String("str")+new String("01");
            str2.intern();
            System.out.println(str2==str1);
            System.out.println("**********");
        }

        {
            String s0 = "kvill";
            String s1 = "kvill";
            String s2 = "kv" + "ill";
            System.out.println(s0 == s1);
            System.out.println(s0 == s2);
            System.out.println(s0 == s2.intern());
            System.out.println(s1 == s2.intern());
            System.out.println(s0 == s1.intern());
            System.out.println("**********");
        }

        {
            String s0 = "kvill";
            String s1 = new String("kvill");
            String s2 = new String("kvill");
            System.out.println(s0 == s1);
            s1.intern();
            s2 = s2.intern(); // 把常量池中“kvill”的引用赋给s2
            System.out.println(s0 == s1);
            System.out.println(s0 == s1.intern());
            System.out.println(s0 == s2);
            System.out.println("**********");
        }

        {
            String s0 = "kvill";
            String s1 = new String("kvill");
            String s2 = "kv" + new String("ill");
            System.out.println(s0 == s1);
            System.out.println(s0 == s2);
            System.out.println(s1 == s2);
            System.out.println("**********");
        }

        {
            String s1 = new String("kvill");
            String s2 = s1.intern();
            System.out.println(s1 == s1.intern());
            System.out.println(s1 + " " + s2);
            System.out.println(s2 == s1.intern());
            System.out.println("**********");
        }

        {
            String s1 = "你好";
            try {
                String s2 = new String(s1.getBytes("GB2312"), "ISO-8859-1");
                System.out.println(s2);
                System.out.println(s1.getBytes("GB2312"));
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }

    }
}

class StringTest2 {
    String str = "kv" + "ill" + "ans";
}
