package ao.shang.cai.observer2;

/**
 * Created by 蔡尚澳 on 2016/8/13.
 */
public class Client {
    public static void main(String[] args) {

        ConcreteSubject subject = new ConcreteSubject();

        ObserverA o1 = new ObserverA();
        ObserverA o2 = new ObserverA();
        ObserverA o3 = new ObserverA();


//        将上面三个观察对象添加进目标对象
        subject.addObserver(o1);
        subject.addObserver(o2);
        subject.addObserver(o3);

//        改变对象状态
        subject.set(3000);

        System.out.println("================状态改变");
        System.out.println(o1.getMyState());
        System.out.println(o2.getMyState());
        System.out.println(o3.getMyState());
    }
}
