package com.imooc.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

@Service
public class CopyFileServiceImpl {

    @Value("${centos.copyFileDesPath}")

    public String CopyFile(String targetPath){
        File file = new File(targetPath);
        System.out.println("*******"+targetPath);
        String desFilePath = "E:\\exercise\\222.txt";
        startThread(5,file.length(), targetPath, desFilePath);
        return "success";
    }

    public  static void startThread(int threadNum, long fileLength, String sourceFilePath,String desFilePath){
        System.out.println(fileLength);
        long modLength = fileLength % threadNum;
        System.out.println("modLength:" + modLength);
        long desLength = fileLength / threadNum;
        System.out.println("desLength:" + desLength);
        for (int i = 0; i < threadNum; i++) {
            System.out.println((desLength * i) + "-----" + (desLength * (i + 1)));
            new FileWriterThread((desLength * i), (desLength * (i + 1)), sourceFilePath, desFilePath).start();
        }
        if (modLength != 0) {
            System.out.println("最后的文件写入");
            System.out.println((desLength * threadNum) + "-----" + (desLength * threadNum + modLength));
            new FileWriterThread((desLength * threadNum), desLength * threadNum + modLength + 1, sourceFilePath,
                    desFilePath).start();
        }
    }

    public static class FileWriterThread extends Thread{
        private long begin;
        private long end;
        private RandomAccessFile sourceFiles;
        private RandomAccessFile desFile;

        public FileWriterThread(long begin, long end, String sourceFilePath, String desFilePath){
            this.begin = begin;
            this.end = end;

            try{
                this.sourceFiles = new RandomAccessFile(sourceFilePath,"rw");
                this.desFile = new RandomAccessFile(desFilePath,"rw");
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void run() {
            try{
                sourceFiles.seek(begin);
                desFile.seek(begin);
                int hasRead = 0;
                byte[] buffer = new byte[1];
                while(begin < end && -1 != ( hasRead = sourceFiles.read(buffer))){
                    begin += hasRead;
                    desFile.write(buffer,0, hasRead);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }finally{
                try {
                    sourceFiles.close();
                    desFile.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
