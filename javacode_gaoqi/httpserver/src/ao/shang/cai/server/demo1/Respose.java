package ao.shang.cai.server.demo1;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Date;

/**
 * Created by 蔡尚澳 on 2016/8/2.
 */
public class Respose {

    public static final String CRLF = "\r\n";   //回车
    public static final String BLANK = " ";     //空格
    //    储存头信息
    private StringBuilder headInfo;
    private int len = 0;
    //      储存正文信息
    private StringBuilder context;
    //    输出流
    private BufferedWriter bw;


    public Respose() {
        headInfo = new StringBuilder();
        context = new StringBuilder();
        len = 0;
    }

    public Respose(OutputStream os) {
        this();
        bw = new BufferedWriter(new OutputStreamWriter(os));
    }

    public Respose(Socket client) {
        this();
        try {
            bw = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));
        } catch (IOException e) {
            headInfo = null;
        }
    }

    /**
     * 构建正文
     *
     * @param info
     * @return
     */

    public Respose print(String info) {

        context.append(info);
        len += info.getBytes().length;
        return this;
    }

    /**
     * 构建正文+回车
     *
     * @param info
     * @return
     */

    public Respose println(String info) {

        context.append(info).append(CRLF);
        len += (info + CRLF).getBytes().length;
        return this;
    }

    /**
     * 构建头信息
     */
    private void creatHeadInfo(int code) {

        //            http协议版本 状态代码 描述
        headInfo.append("HTTP/1.1").append(BLANK).append(code).append(BLANK);
        switch (code) {
            case 200:
                headInfo.append("ok");
                break;
            case 404:
                headInfo.append("NOT　FOUND");
                break;
            case 500:
                headInfo.append("Server ERROR");
        }
        headInfo.append(CRLF);

//            响应头
        headInfo.append("Server:bjsxt Server/0.0.1").append(CRLF);
//
        headInfo.append("Date:").append(new Date()).append(CRLF);
        headInfo.append("Content-type:text/html;charset=UTF-8").append(CRLF);
//            正文字节长度
        headInfo.append("Content-lenth:").append(len).append(CRLF);
//            正文之前
        headInfo.append(CRLF);


    }

    /**
     * 推送到客户端
     */
    void pushToClient(int code) throws IOException {
        if (null == headInfo) {
            code = 500;
        }

        creatHeadInfo(code);
//        头信息+分隔符
        bw.append(headInfo.toString());
//        正文
        bw.append(context.toString());
        System.out.println(CRLF+CRLF+headInfo.toString());

        close();

    }
    public void close(){
        try {
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
