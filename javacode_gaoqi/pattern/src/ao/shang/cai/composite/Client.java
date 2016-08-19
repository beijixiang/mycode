package ao.shang.cai.composite;

/**
 * Created by 蔡尚澳 on 2016/8/12.
 */
public class Client {

    public static void main(String[] args) {
        AbstractFile f2, f3, f4, f5;
        Folder f1 = new Folder("我的收藏");

        f2 = new ImageFile("我的头像.jpg");
        f3 = new TextFile("我的稿件");

        f1.add(f2);
        f1.add(f3);

        Folder f11 = new Folder("我的电影");
        f4 = new VideoFile("里约大冒险");
        f5 = new VideoFile("小男孩");

        f11.add(f4);
        f11.add(f5);
        f1.add(f11);

        f1.killVirus();


    }
}
