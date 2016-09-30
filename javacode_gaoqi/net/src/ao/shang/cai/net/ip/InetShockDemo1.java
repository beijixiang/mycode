package ao.shang.cai.net.ip;

import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.UnknownHostException;

/**
 * Created by 蔡尚澳 on 2016/8/1.
 */
public class InetShockDemo1 {
    public static void main(String[] args) throws UnknownHostException {

        InetSocketAddress address = new InetSocketAddress("localhost", 9999);
        address = new InetSocketAddress(InetAddress.getByName("localhost"), 9999);
        System.out.println(address.getHostName());
        System.out.println(address.getPort());
        System.out.println(address.getAddress());

        InetAddress inetAddress = address.getAddress();
        System.out.println(inetAddress.getHostAddress());
        System.out.println(inetAddress.getHostName());

    }
}
