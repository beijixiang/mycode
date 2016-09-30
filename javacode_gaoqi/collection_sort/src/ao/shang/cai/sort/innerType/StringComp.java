package ao.shang.cai.sort.innerType;

import java.util.Comparator;

/**
 * Created by 蔡尚澳 on 2016/7/21.
 */
public class StringComp implements Comparator<String> {


    @Override
    public int compare(String o1, String o2) {
        int len1 = o1.length();
        int len2 = o2.length();
        return len2-len1;
    }


}
