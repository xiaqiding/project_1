package com.example.test_1;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * autour: 夏奇顶
 * date: 2016-11-30 19:28
 * update: 2016-11-30
 */
//遍历出一个文件夹下的所有文件，并展示出层级关系，文件夹优先显示，最后以一定格式写入文本中
//要求：尽可能简单、逻辑清晰
public class Test {

    public static void main(String[] args) {
        //路径
        String filePath = "F://音乐";
        getFiles(filePath);
    }

    private static List<String> fileList=new ArrayList<>();

    private static void getFiles(String filePath) {
        File file=new File(filePath);
        //文件
        File[] files=file.listFiles();
        //遍历
        for (File f:files) {
            //判断是否为文件夹
            if (f.isDirectory()){
                //所有文件夹的路径
                getFiles(f.getAbsolutePath());
                //添加到集合
                fileList.add(f.getAbsolutePath());

                System.out.println("显示\"+filePath+\"下所有子目录及其文件\"+file.getAbsolutePath()");
            }else{
                System.out.println("显示"+filePath+"下所有子目录"+file.getAbsolutePath());
            }
        }
    }
}
