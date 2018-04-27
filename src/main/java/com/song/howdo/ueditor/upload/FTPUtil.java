package com.song.howdo.ueditor.upload;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPReply;
import org.springframework.web.multipart.MultipartFile;

public class FTPUtil {

	//ftp服务器ip地址
    private static final String FTP_ADDRESS = "101.132.186.20";
    //端口号
    private static final int FTP_PORT = 21;
    //用户名
    private static final String FTP_USERNAME = "eleuser";
    //密码
    private static final String FTP_PASSWORD = "ele_ishare!";
    //图片路径
    private static final String FTP_BASEPATH = "/home/eleuser/file/images";

    public  static boolean uploadFile(String originFileName,InputStream input){
        System.out.println("里面:"+input);
    	boolean success = false;
        FTPClient ftp = new FTPClient();
        ftp.setControlEncoding("utf-8");
        ftp.enterLocalPassiveMode();
        try {
            int reply;
            ftp.connect(FTP_ADDRESS, FTP_PORT);// 连接FTP服务器
            ftp.login(FTP_USERNAME, FTP_PASSWORD);// 登录
            reply = ftp.getReplyCode();
            if (!FTPReply.isPositiveCompletion(reply)) {
                ftp.disconnect();
                return success;
            }
            ftp.setFileType(FTPClient.BINARY_FILE_TYPE);
            ftp.makeDirectory(FTP_BASEPATH );
            boolean a = ftp.changeWorkingDirectory(FTP_BASEPATH );
            System.out.println("是否:"+a);
            ftp.storeFile(originFileName,input);
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
    
    public static boolean upload(MultipartFile file,String fName) throws IOException {
        File directory = new File("");// 参数为空
        String courseFile = directory.getCanonicalPath();
        System.out.println("测试地址："+courseFile);

        if (file.isEmpty()) {
//            return "文件为空";
            System.out.println("文件为空");
            return false;
        }
        // 获取文件名
        String fileName = file.getOriginalFilename();
//        logger.info("上传的文件名为：" + fileName);
        // 获取文件的后缀名
        String suffixName = fileName.substring(fileName.lastIndexOf("."));
//        logger.info("上传的后缀名为：" + suffixName);
        // 文件上传后的路径D:\springbootstudy\fileupload\src\main\resources\files
//        String filePath = courseFile+"\\src\\main\\resources\\files\\";
        String filePath = "E:\\workspace\\howdo\\src\\main\\webapp\\pic\\";
        // 解决中文问题，liunx下中文路径，图片显示问题
        // fileName = UUID.randomUUID() + suffixName;
        File dest = new File(filePath + fName);
        String path = dest.getPath();
        // 检测是否存在目录
        if (!dest.getParentFile().exists()) {
            dest.getParentFile().mkdirs();
        }
        try {
            file.transferTo(dest);
            System.out.println("地址"+path);
//            return path;
            return true;
        } catch (IllegalStateException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return true;
    }
    
    
    public static boolean uploadFileFTP1(String fileName, InputStream input){
        System.out.println("hihihihihi:"+fileName);
        String path = "/home/eleuser/www/images";
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
//            ftp.enterLocalPassiveMode();
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

	
}
