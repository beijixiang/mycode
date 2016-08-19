package ao.shang.cai.collection;

import java.util.LinkedList;

/**
 *
 * 利用数组家链表实现高效查询
 * Created by 蔡尚澳 on 2016/7/17.
 */
public class MyMap002 {
    LinkedList[] arr = new LinkedList[999];
    int size;

    public void put(Object key, Object value) {
        Entry e = new Entry(key, value);
        int hash=key.hashCode();
        hash=hash< 0 ? -hash : hash;
        int a=hash%arr.length;
        if (arr[a] == null) {
            LinkedList list = new LinkedList();
            arr[a] = list;
            list.add(e);
        } else {
            for (int i = 0; i < arr[a].size(); i++) {
                Entry e2 = (Entry) arr[a].get(i);
                if (e2.key.equals(key)) {
                    e2.value = value;
                    return;
                }
            }
            arr[a].add(e);
        }
    }

    public Object get(Object key) {
        int a=key.hashCode()%arr.length;
        if (arr[a] != null) {
            for (int i = 0; i < arr[a].size(); i++) {
                Entry e = (Entry) arr[a].get(i);
                if (e.key.equals(key)) {
                    return e.value;
                }
            }
        }
        return null;
    }

    public static void main(String[] args) {
        MyMap002 map002 = new MyMap002();
        map002.put("尚澳", new Wife("李四"));
        map002.put("尚澳", new Wife("高圆圆"));
        Wife wife= (Wife) map002.get("尚澳");
        System.out.println(wife.name);

    }
}
