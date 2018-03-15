package com.song.howdo.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPReply;

public class FileTest {

//	public static void main(String[] args) {
//		
//		//创建客户端对象
//	       FTPClient ftp = new FTPClient();
//	       InputStream local=null;
////	       ftp.enterLocalPassiveMode();
//	       try {
//	           //连接ftp服务器
//	           ftp.connect("101.132.186.20", 21);
//	           //登录
//	           ftp.login("eleuser", "ele_ishare!");
//	           //设置上传路径
//	           String path="/home/eleuser/file/images";
//	           //检查上传路径是否存在 如果不存在返回false
//	          
//	           boolean flag = ftp.changeWorkingDirectory(path);
//	           if(!flag){
//	               //创建上传的路径  该方法只能创建一级目录，在这里如果/home/ftpuser存在则可创建image
//	               ftp.makeDirectory(path);
//	           }
//	           //指定上传路径
//	           ftp.changeWorkingDirectory(path);
//	           //指定上传文件的类型  二进制文件
//	           ftp.setFileType(FTP.BINARY_FILE_TYPE);
//	           //读取本地文件
//	           File file = new File("e://cat.jpg");
//	           local = new FileInputStream(file);
//	           //第一个参数是文件名
//	           ftp.storeFile(file.getName(), local);
//	        } catch (SocketException e) {
//	            e.printStackTrace();
//	        } catch (IOException e) {
//	            e.printStackTrace();
//	        }finally {
//	            try {
//	                //关闭文件流
//	                local.close();
//	                //退出
//	                ftp.logout();
//	                //断开连接
//	                ftp.disconnect();
//	            } catch (IOException e) {
//	                e.printStackTrace();
//	            }
//		
//	        }
//	}
	
	
	public static boolean uploadFileFTP1(String fileName, InputStream input, String path){
        path = "/home/eleuser/www"+path;
        boolean success = false;
        FTPClient ftp = new FTPClient();
        ftp.setControlEncoding("UTF-8");
        try {
            int reply;
            ftp.connect("119.23.77.220", 21);// 连接FTP服务器
            ftp.login("eleuser", "eleuser");// 登录
            reply = ftp.getReplyCode();
            if (!FTPReply.isPositiveCompletion(reply)) {
                ftp.disconnect();
                return success;
            }
            ftp.setFileType(FTPClient.BINARY_FILE_TYPE);
            ftp.makeDirectory(path);
            ftp.changeWorkingDirectory(path);
            ftp.storeFile(fileName,input);
            input.close();
            ftp.logout();
            success = true;
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (ftp.isConnected()) {
                try {
                    ftp.disconnect();
                } catch (IOException ioe) {
                }
            }
        }
        return success;
    }

    public static void main(String[] args) {
        File file = new File("e://alibaba.jpg");
        System.out.println(file);
        try {
            InputStream local = new FileInputStream(file);
            System.out.println(local);
            uploadFileFTP1("alibaba.jpg",local,"/images");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
	
}
