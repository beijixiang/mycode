package cn.bjsxt.opp.polimorphism;

import cn.bjsxt.opp.polimorphism.Aniaml;

/**
 * Created by 蔡尚澳 on 2016/7/8.
 */
public class Test {

    public static void testAnimalVoice(Aniaml c){
        c.voice();
        if (c instanceof Cat) {
            ((Cat) c).catchMouse();
        }
    }
    public static void main(String[] args) {
        Aniaml a=new Cat();
        Aniaml b=new Dog();
        Aniaml c=new Tiger();
        testAnimalVoice(a);
        testAnimalVoice(b);
        testAnimalVoice(c);

        Cat cat2=(Cat)a;
        cat2.catchMouse();
    }
}
