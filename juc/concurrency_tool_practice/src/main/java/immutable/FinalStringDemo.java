package immutable;

/**
 * <p></p>
 *
 * @author zhoupeng peng.zhou@topay.ae
 * @date FinalStringDemo.java v1.0  2020/1/21 3:49 下午
 */
public class FinalStringDemo {
    public static void main(String[] args) {
        String a = "wukong2";
        final String b = "wukong";
        String d = "wukong";

        String c = b + 2;
        String e = d + 2;
        System.out.println(a == c);//指向栈中地址
        System.out.println(a == e);//指向堆中的  运行时才生成e
    }


}
