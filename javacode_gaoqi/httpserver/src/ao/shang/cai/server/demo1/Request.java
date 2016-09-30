package ao.shang.cai.server.demo1;

import sun.nio.cs.ext.GBK;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.*;

/**
 * Created by 蔡尚澳 on 2016/8/4.
 */
public class Request {
    //  请求方式
    private String method;
    //  请求资源
    private String url;
    //    请求参数
    private Map<String, List<String>> parameterMapValue;


    //    内部使用
    public static final String CRLF = "\r\n";
    private InputStream is;
    private String requstInfo;


    public Request() {
        method = "";
        url = "";
        parameterMapValue = new HashMap<String, List<String>>();

    }

    public Request(InputStream is) {
        this();
        try {
            this.is = is;
            byte[] data = new byte[20480];
            int len = is.read(data);
            requstInfo = new String(data, 0, len);

        } catch (IOException e) {
            return;
        }

//      分析头信息
        parseRequstInfo();

    }

    public void parseRequstInfo(){
        if (requstInfo == null || requstInfo.trim().equals("")) {
            return;
        }


//        接收请求参数
        String paramString = "";

        //获取请求方式
        int idx = requstInfo.indexOf("/");
        String firstLine = requstInfo.substring(0, requstInfo.indexOf(CRLF));
        this.method = firstLine.substring(0, idx).trim();

        String urlStr=firstLine.substring(idx, firstLine.indexOf("HTTP/")).trim();
        if (this.method.equalsIgnoreCase("post")) {
            this.url = urlStr;
            paramString = requstInfo.substring(requstInfo.lastIndexOf(CRLF)).trim();


        } else if (this.method.equalsIgnoreCase("get")) {
            if (urlStr.contains("?")) { //是否存在参数

                String[] urlArrays = urlStr.split("\\?");
                this.url = urlArrays[0];
                paramString = urlArrays[1]; //请求参数
            } else {
                this.url = urlStr;
            }
        }

        //    将请求参数封装在Map中
        parseParams(paramString);

    }


    /**
     * 将请求参数封装在map中
     * @param paramString
     */
    public void parseParams(String paramString) {
//        分割字符串转成数组
        StringTokenizer token = new StringTokenizer(paramString, "&");
        while (token.hasMoreTokens()) {
            String keyvalue = token.nextToken();
            String[] keyvalues = keyvalue.split("=");
            if (keyvalues.length == 1){
                keyvalues = Arrays.copyOf(keyvalues, 2);
                keyvalues[1] = null;
            }

            String key = keyvalues[0].trim();
            String value = keyvalues[1] == null ? null : decode(keyvalues[1].trim(), "gbk");
//            转化成map，分拣思想
            if (!parameterMapValue.containsKey(key)) {
                parameterMapValue.put(key, new ArrayList<>());
            }

            List<String> values = parameterMapValue.get(key);
            values.add(value);


        }

    }


    public String decode(String value, String decode) {

        try {
            return java.net.URLDecoder.decode(value, decode);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 根据页面获得name对应的多个值
     * @param name
     * @return
     */

    public String[] getParameterValues(String name) {

        List<String> values = null;
        if ((values = parameterMapValue.get(name)) == null) {
            return null;
        }else {
            return values.toArray(new String[0]);
        }

    }

    /**
     * 根据页面name获得单个值
     *
     * @param name
     * @return
     */
    public String getParameter(String name) {

        String[] values = getParameterValues(name);
        if (null == values) {
            return null;
        }

        return values[0];
    }




}
