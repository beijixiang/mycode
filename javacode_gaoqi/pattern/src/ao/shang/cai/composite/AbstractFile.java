package ao.shang.cai.composite;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 蔡尚澳 on 2016/8/12.
 */
public interface AbstractFile {
    void killVirus();      //杀毒
}

class ImageFile implements AbstractFile {
    private String name;

    public ImageFile(String name) {
        super();
        this.name = name;
    }

    @Override
    public void killVirus() {
        System.out.println("---图像文件："+name+",正在查杀!");
    }
}

class TextFile implements AbstractFile {
    private String name;

    public TextFile(String name) {
        super();
        this.name = name;
    }

    @Override
    public void killVirus() {
        System.out.println("---文本文件："+name+",正在查杀!");
    }
}

class VideoFile implements AbstractFile {
    private String name;

    public VideoFile(String name) {
        super();
        this.name = name;
    }

    @Override
    public void killVirus() {
        System.out.println("---视频文件："+name+",正在查杀!");
    }
}

class Folder implements AbstractFile {
    private String name;
    private List<AbstractFile> lists = new ArrayList<>();

    public Folder(String name) {
        super();
        this.name = name;
    }

    public void add(AbstractFile file) {
        lists.add(file);
    }

    public void remove(AbstractFile file) {
        lists.remove(file);
    }

    public AbstractFile getChild(int idx){
        return lists.get(idx);
    }

    @Override
    public void killVirus() {
        System.out.println("---文件夹：" + name + ",正在查杀!");

        for (AbstractFile file : lists) {
            file.killVirus();
        }
    }


}