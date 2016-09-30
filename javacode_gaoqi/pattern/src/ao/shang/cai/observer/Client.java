package ao.shang.cai.observer;

/**
 * Created by 蔡尚澳 on 2016/8/13.
 */
public class Client {
    public static void main(String[] args) {

//        目标对象
        ConcreteSubject concreteSubject = new ConcreteSubject();

//       创建观察者对象
        ObserverA obsever1 = new ObserverA();
        ObserverA obsever2 = new ObserverA();
        ObserverA obsever3 = new ObserverA();

//        三个对象订阅目标
        concreteSubject.register(obsever1);
        concreteSubject.register(obsever2);
        concreteSubject.register(obsever3);
//          改变状态
        concreteSubject.setState(3000);

        System.out.println(obsever1.getMyState());
        System.out.println(obsever2.getMyState());
        System.out.println(obsever3.getMyState());

    }
}
