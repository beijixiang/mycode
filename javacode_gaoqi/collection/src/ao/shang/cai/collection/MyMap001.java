package ao.shang.cai.collection;

import ao.shang.cai.collection.Wife;

/**
 * 实现自定义Map
 * 暂不完美
 * Map存放键值对，根据键对象找到值对象，键对象不能重复
 * Created by 蔡尚澳 on 2016/7/17.
 */
public class MyMap001 {
    Entry[] arr = new Entry[990];
    int size;

    public void put(Object key,Object value){
        Entry e = new Entry(key, value);
        for (int i = 0; i < size; i++) {
            if (arr[i].key.equals(key)) {
                arr[i].value = value;
                return;
            }

        }
        arr[size++] = e;
    }

    public Object get(Object key) {
        for (int i = 0; i < size; i++) {
            if (arr[i].key.equals(key)) {
                return arr[i].value;
            }

        }
        return null;
    }

    public boolean containKey(Object key) {
        for (int i = 0; i < size; i++) {
            if (arr[i].key.equals(key)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        MyMap001 map001 = new MyMap001();
        map001.put("张三", new Wife("李四"));
        map001.put("尚澳", new Wife("高圆圆"));
        Wife wife= (Wife) map001.get("尚澳");
        System.out.println(wife.name);

    }

}

class Entry {
    Object key;
    Object value;

    public Entry(Object key, Object value) {
        this.key = key;
        this.value = value;
    }
}
