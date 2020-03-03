import cn.hutool.core.convert.Convert;
import cn.hutool.core.date.DateUtil;

import java.util.regex.Pattern;

import static java.util.regex.Pattern.*;

public class Test {

    public static void main(String[] args) {

//        [^0-9]

        String regEx = "[^0-9]";
        System.out.println(compile(regEx).matcher(DateUtil.now()).replaceAll("").length());
        System.out.println(DateUtil.now().replace("-","").replace(":","").replace(" ",""));
    }
}
