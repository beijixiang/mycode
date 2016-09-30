package cn.bjsxt.opp.polimorphism;

import cn.bjsxt.opp.polimorphism.Aniaml;

/**
 * Created by 蔡尚澳 on 2016/7/8.
 */
public class Aniaml {
    public void voice(){
        System.out.println("普通动物叫声");
    }
}

class Cat extends Aniaml{
    public void voice(){
        System.out.println("喵喵喵");
    }

    public void catchMouse(){
        System.out.println("抓老鼠");
    }
}

class Dog extends Aniaml{
    public void voice(){
        System.out.println("汪汪汪");
    }

    public void seeDoor(){
        System.out.println("看门");
    }
}

class Pig extends Aniaml {
    public void voice() {
        System.out.println("哼哼哼");
    }


}
class Tiger extends Aniaml {
    public void voice() {
        System.out.println("哇哇哇");
    }
}