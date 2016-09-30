package ao.shang.cai.gen05;

import java.util.Iterator;

/**
 * Created by 蔡尚澳 on 2016/7/19.
 */
public class MyArrayList3 implements Iterable<String>{
        String[] elem = {"a", "b", "c", "d", "e", "f", "g"};
        int size = elem.length;

        int cursor = -1;

        /**
         * 判断是否有下一个元素，有的话返回true
         * @return
         */
        public boolean hasNext() {

            return cursor + 1 < size;

        }

        /**
         * 获取下一个元素
         * @return
         */

        public String next(){
            cursor+=1;
            return elem[cursor];

        }

        public void remove(){
            //删除元素
        }

        public Iterator<String> iterator() {
            return new Iterator<String>() {
                int cursor = -1;
                /**
                 * 判断是否有下一个元素，有的话返回true
                 *
                 * @return
                 */
                public boolean hasNext () {
                    return cursor + 1 < size;
                }
                /**
                 * 获取下一个元素
                 *
                 * @return
                 */
                public String next () {
                    cursor += 1;
                    return elem[cursor];

                }
                public void remove () {
                    //删除元素
                }
            };
        }


        public static void main(String[] args) {
            MyArrayList3 list = new MyArrayList3();
            Iterator<String> it = list.iterator();
            while (it.hasNext()) {
                System.out.println(it.next());

            }

            for (String temp : list) {  //需要实现iterable
                list.next();
            }

        }


    }


