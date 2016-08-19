package ao.shang.cai.net.ip;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 *
 * InetAdress 没有封装端口
 * Created by 蔡尚澳 on 2016/8/1.
 */
public class InetDemo1 {
    public static void main(String[] args) throws UnknownHostException {
//        getlocalhost 创建inetAdres对象
        InetAddress localAddress = InetAddress.getLocalHost();
        System.out.println(localAddress.getHostAddress());
        System.out.println(localAddress.getHostName());
//        根据域名创建InetAdress对象
        InetAddress address = InetAddress.getByName("www.baidu.com");
        System.out.println(address.getHostAddress());
        System.out.println(address.getHostName());
//        根据地址 创建InetAdress对象
        InetAddress address1 = InetAddress.getByName("115.239.211.112");
        System.out.println(address1.getHostName());
        System.out.println(address1.getHostAddress());
    }
}
