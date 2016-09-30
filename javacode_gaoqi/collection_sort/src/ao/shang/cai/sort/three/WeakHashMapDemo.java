package ao.shang.cai.sort.three;

import java.util.StringTokenizer;
import java.util.WeakHashMap;

/**WeakHashMap 键为弱引用，gc通知时候立即回收
 * Created by 蔡尚澳 on 2016/7/23.
 */
public class WeakHashMapDemo {
    public static void main(String[] args) {
        WeakHashMap<String, String> map = new WeakHashMap<>();
//        常量池键不会被回收
        map.put("a", "a1");
        map.put("abc", "a1");
        //        通知回收
        System.gc();
        System.runFinalization();
        System.out.println(map.size());
//        gc运行时立即被回收
        map.put(new String("aew"), "a1");
        map.put(new String("asd"), "a1");
        System.out.println(map.size());
        System.gc();
        System.runFinalization();
        System.out.println(map.size());
    }
}
