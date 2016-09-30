package ao.shang.cai.io.others;

import ao.shang.cai.io.util.FileUtil;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.Vector;

/**
 * 文件分割
 * Created by 蔡尚澳 on 2016/7/30.
 */
public class SplitFile {
    //    文件大小
    private long length;
    //    文件名
    private String fileName;
    //    文件路径
    private String filePath;
    //    每块大小
    private long blockSize;
    //    总的块数
    private long size;
    //    每块名称
    private List<String> blockName;
    //    分割后的目录
    private String destBlockPath;


    public SplitFile(){
        blockName = new ArrayList<>();

    }

    public SplitFile(String filePath,String destBlockPath) {
        this(filePath,destBlockPath, 1024);
    }

    public SplitFile(String filePath,String destBlockPath, long blockSize) {
        this();
        this.filePath = filePath;
        this.blockSize = blockSize;
        this.destBlockPath = destBlockPath;
        init(destBlockPath);

    }
//    初始化操作，计算块数，文件名
    public void init(String dest){
        File file = null;
//        健壮性
        if (filePath == null || !(file = new File(filePath)).exists()) {
            return;
        }
//        如果是文件夹不操作
        if (file.isDirectory()) {
            return;
        }
        fileName = file.getName();
//        计算每块大小
        this.length = file.length();
        if (blockSize > length) {
            this.blockSize = length;
        }
//        确定块数
        this.size = (long) Math.ceil(this.length*1.0 /this.blockSize);
        initPathName(dest);

    }

    public void initPathName(String destPath) {
        for (int i = 0; i < this.size; i++) {
            this.blockName.add(destPath+"/"+fileName + ".part" + i);
        }

    }

    /**
     * 文件分隔
     * 第几块
     * 起始位置
     * 实际大小
     *
     * @param dest
     */

    public void split(String dest){

//        计算所以块的大小 索引
        long actualBlockSize=blockSize;
        long beginPos = 0;
        for (int i = 0; i < size; i++) {

            if (i == size - 1) {
                actualBlockSize = length - beginPos;
            }
            splitDetal(i, beginPos, actualBlockSize);
            beginPos += blockSize;
        }

    }

    /**
     * 文件分割
     * @param idx
     * @param beginPos
     * @param actualBlockSize
     */
    public void splitDetal(int idx, long beginPos, long actualBlockSize) {

//        建立源
        File src = new File(filePath);
        File dest = new File(this.blockName.get(idx));
        RandomAccessFile raf = null;
        BufferedOutputStream bos = null;
//        选择流
        try {
             raf= new RandomAccessFile(src, "r");
             bos= new BufferedOutputStream(new FileOutputStream(dest));
//            起始位置
            raf.seek(beginPos);

//      缓冲
            byte[] flush = new byte[1024];
            int len = 0;
            while (-1 != (len = raf.read(flush))) {
                if (actualBlockSize > len) {
                    bos.write(flush, 0, len);
                    actualBlockSize -= len;
                } else {
                    bos.write(flush, 0, (int) actualBlockSize);
                    break;
                }

            }
//            读取数据
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                raf.close();
                bos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    /**
     * 文件合并
     * @param destPath
     */
    public void merge(String destPath) {
        File dest = new File(destPath);
//        选择流
        BufferedOutputStream bos = null;
        SequenceInputStream sis = null;
        try {
            Vector<InputStream> v = new Vector<>();
            bos = new BufferedOutputStream(new FileOutputStream(dest,true));

            for (int i = 0; i < blockName.size(); i++) {
                v.add(new BufferedInputStream(new FileInputStream(new File(blockName.get(i)))));
            }
            sis = new SequenceInputStream(v.elements());

                byte[] flush = new byte[1024];
                int len = 0;
                while (-1 != (len = sis.read(flush))) {
                    bos.write(flush, 0, len);

                }
                FileUtil.close(sis);
                bos.flush();
            } catch (FileNotFoundException e1) {
            e1.printStackTrace();
        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }

    /**
     * 文件合并
     * @param destPath
     */
    public void merge1(String destPath) {
        File dest = new File(destPath);
//        选择流
        BufferedInputStream bis =null;
        BufferedOutputStream bos = null;


        try {
            bos = new BufferedOutputStream(new FileOutputStream(dest,true));
            for (int i = 0; i < blockName.size(); i++) {
                File src = new File(blockName.get(i));
                bis=new BufferedInputStream(new FileInputStream(src));
                byte[] flush = new byte[1024];
                int len = 0;
                while (-1 != (len = bis.read(flush))) {
                    bos.write(flush, 0, len);

                }
                FileUtil.close(bis);
                bos.flush();
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            FileUtil.close(bos);
        }

    }



    public static void main(String[] args) {
        SplitFile sp = new SplitFile("H:/javacode_gaoqi/Demo2.java","H:/javacode_gaoqi", 50);
//        sp.split("H:/javacode_gaoqi");
        sp.merge("H:/javacode_gaoqi/Split2.java");

        System.out.println(sp.size );
    }




}
