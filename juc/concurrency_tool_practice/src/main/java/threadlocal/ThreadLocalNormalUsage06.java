package threadlocal;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * <p></p>
 *
 * @author zhoupeng peng.zhou@topay.ae
 * @date ThreadLocalNormalUsage06.java v1.0  2020/1/7 7:55 下午
 * <p>
 * ThreadLocal用法2：避免传递参数的麻烦
 * 由于ThreadLocalMap中的value是强引用，会存在内存泄漏的问题
 * OutOfMemoryError : Java heap space
 */
public class ThreadLocalNormalUsage06 {
    public static void main(String[] args) {
        new Service1().process("超哥");
        new Service1().process("三哥");
    }
}

class Service1 {
    public void process(String name) {
        User user = new User(name);
        UserContextHolder.holder.set(user);
        new Service2().process();
    }
}

class Service2 {
    public void process() {
        User user = UserContextHolder.holder.get();
        System.out.println("Service2 " + user);
        new Service3().process();
    }
}

class Service3 {
    public void process() {
        User user = UserContextHolder.holder.get();
        System.out.println("Service3 " + user);

        // 为避免内存泄漏，此时因该调用remove
        UserContextHolder.holder.remove();
    }
}

class UserContextHolder {
    public static ThreadLocal<User> holder = new ThreadLocal<>();
}

@Data
@AllArgsConstructor
class User {
    String name;
}
