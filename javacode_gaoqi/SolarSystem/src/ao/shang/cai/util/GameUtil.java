package ao.shang.cai.util;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

/**
 * Created by 蔡尚澳 on 2016/7/13.
 */
public class GameUtil {
    private GameUtil(){}

    public static Image getImage(String path){
        URL u=GameUtil.class.getClassLoader().getResource(path);
        BufferedImage img = null;
        try {
            img = ImageIO.read(u);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return img;
    }
}
