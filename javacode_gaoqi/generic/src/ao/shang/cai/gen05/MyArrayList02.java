package ao.shang.cai.gen05;

import java.util.Iterator;

/**
 * Created by 蔡尚澳 on 2016/7/19.
 */
public class MyArrayList02 {
        String[] elem = {"a", "b", "c", "d", "e", "f", "g"};
        int size = elem.length;

        private class MyIt implements Iterator<String> {

            int cursor = -1;

            /**
             * 判断是否有下一个元素，有的话返回true
             *
             * @return
             */
            public boolean hasNext() {
                return cursor + 1 < size;
            }

            /**
             * 获取下一个元素
             *
             * @return
             */

            public String next() {
                cursor += 1;
                return elem[cursor];

            }

            public void remove() {
                //删除元素
            }
        }
        public Iterator<String> iterator(){
            return new MyIt();
        }

        public static void main(String[] args) {
            MyArrayList02 list = new MyArrayList02();
            Iterator<String> it = list.iterator();
            while (it.hasNext()) {
                System.out.println(it.next());
            }
        }

    }


