package com.song.howdo.ueditor.upload;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPReply;
import org.springframework.web.multipart.MultipartFile;

public class FTPUtil {

	//ftp������ip��ַ
    private static final String FTP_ADDRESS = "101.132.186.20";
    //�˿ں�
    private static final int FTP_PORT = 21;
    //�û���
    private static final String FTP_USERNAME = "eleuser";
    //����
    private static final String FTP_PASSWORD = "ele_ishare!";
    //ͼƬ·��
    private static final String FTP_BASEPATH = "/home/eleuser/file/images";

    public  static boolean uploadFile(String originFileName,InputStream input){
        System.out.println("����:"+input);
    	boolean success = false;
        FTPClient ftp = new FTPClient();
        ftp.setControlEncoding("utf-8");
        ftp.enterLocalPassiveMode();
        try {
            int reply;
            ftp.connect(FTP_ADDRESS, FTP_PORT);// ����FTP������
            ftp.login(FTP_USERNAME, FTP_PASSWORD);// ��¼
            reply = ftp.getReplyCode();
            if (!FTPReply.isPositiveCompletion(reply)) {
                ftp.disconnect();
                return success;
            }
            ftp.setFileType(FTPClient.BINARY_FILE_TYPE);
            ftp.makeDirectory(FTP_BASEPATH );
            boolean a = ftp.changeWorkingDirectory(FTP_BASEPATH );
            System.out.println("�Ƿ�:"+a);
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
    
    public String upload(MultipartFile file) throws IOException {
        File directory = new File("");// ����Ϊ��
        String courseFile = directory.getCanonicalPath();
        System.out.println("���Ե�ַ��"+courseFile);

        if (file.isEmpty()) {
            return "�ļ�Ϊ��";
        }
        // ��ȡ�ļ���
        String fileName = file.getOriginalFilename();
//        logger.info("�ϴ����ļ���Ϊ��" + fileName);
        // ��ȡ�ļ��ĺ�׺��
        String suffixName = fileName.substring(fileName.lastIndexOf("."));
//        logger.info("�ϴ��ĺ�׺��Ϊ��" + suffixName);
        // �ļ��ϴ����·��D:\springbootstudy\fileupload\src\main\resources\files
        String filePath = courseFile+"\\src\\main\\resources\\files\\";
        // ����������⣬liunx������·����ͼƬ��ʾ����
        // fileName = UUID.randomUUID() + suffixName;
        File dest = new File(filePath + fileName);
        String path = dest.getPath();
        // ����Ƿ����Ŀ¼
        if (!dest.getParentFile().exists()) {
            dest.getParentFile().mkdirs();
        }
        try {
            file.transferTo(dest);
            System.out.println("��ַ"+path);
            return path;
        } catch (IllegalStateException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }
    
    
    public static boolean uploadFileFTP1(String fileName, InputStream input){
        System.out.println("hihihihihi:"+fileName);
        String path = "/home/eleuser/www/images";
        boolean success = false;
        FTPClient ftp = new FTPClient();
        ftp.setControlEncoding("UTF-8");
        try {
            int reply;
            ftp.connect("119.23.77.220", 21);// ����FTP������
            ftp.login("eleuser", "eleuser");// ��¼
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

	
}
