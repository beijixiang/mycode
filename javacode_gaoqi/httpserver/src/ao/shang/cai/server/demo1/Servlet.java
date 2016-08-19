package ao.shang.cai.server.demo1;

/**
 * Created by 蔡尚澳 on 2016/8/4.
 */
public class Servlet {
    public void service(Request req, Respose rep) {
        rep.println("<html><head><title>响应测试</title></head><body>");
        rep.println("欢迎：").println(req.getParameter("uname")).println(" 回来");
        rep.println("</body></html>");
    }
}
