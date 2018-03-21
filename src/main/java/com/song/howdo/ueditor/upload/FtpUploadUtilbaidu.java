package com.song.howdo.ueditor.upload;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.FileItemStream;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.shiro.web.servlet.ShiroHttpServletRequest;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import com.song.howdo.ueditor.PathFormat;
import com.song.howdo.ueditor.define.AppInfo;
import com.song.howdo.ueditor.define.BaseState;
import com.song.howdo.ueditor.define.FileType;
import com.song.howdo.ueditor.define.State;

public class FtpUploadUtilbaidu {

    public State save(HttpServletRequest request, Map<String, Object> conf) {

    	ShiroHttpServletRequest shiroRequest = (ShiroHttpServletRequest) request;  
        CommonsMultipartResolver commonsMultipartResolver = new CommonsMultipartResolver();  
        MultipartHttpServletRequest multipartRequest = commonsMultipartResolver.resolveMultipart((HttpServletRequest) shiroRequest.getRequest()); 
//        String token = request.getParameter("token");
//    	String a 
//    	System.out.println("����:"+a);
        
        MultipartFile file = multipartRequest.getFile("upfile");
        System.out.println("̫��:"+file.getSize());
        
        FileItemStream fileStream = null;
        boolean isAjaxUpload = request.getHeader( "X_Requested_With" ) != null;
        //��ȡFile     upfile
//        MultipartFile file = ((MultipartHttpServletRequest) request).getFile("upload");
        
        if (!ServletFileUpload.isMultipartContent(request)) {
            return new BaseState(false, AppInfo.NOT_MULTIPART_CONTENT);
        }

        ServletFileUpload upload = new ServletFileUpload(new DiskFileItemFactory());

        if ( isAjaxUpload ) {
            upload.setHeaderEncoding( "UTF-8" );
        }

        try {

            if (file == null) {
                return new BaseState(false, AppInfo.NOTFOUND_UPLOAD_DATA);
            }

            String savePath = (String) conf.get("savePath");
            String originFileName = file.getOriginalFilename();
            String suffix = FileType.getSuffixByFilename(originFileName);

            originFileName = originFileName.substring(0, originFileName.length() - suffix.length());
            savePath = savePath + suffix;
            long maxSize = ((Long) conf.get("maxSize")).longValue();

            if (!validType(suffix, (String[]) conf.get("allowFiles"))) {
                return new BaseState(false, AppInfo.NOT_ALLOW_FILE_TYPE);
            }

            savePath = PathFormat.parse(savePath, originFileName);

            String filename = savePath;

            int pos = savePath.lastIndexOf("/");
            if(pos > -1){
                filename = savePath.substring(pos+1);
            }
            String physicalPath = (String)conf.get("rootPath") + savePath;

//            StorageManager storageManager = new StorageManager();
            FTPUtil ftpUtil = new FTPUtil();

            State storageState = null;
            
            InputStream is = file.getInputStream();
            System.out.println("hehe:"+is);
            System.out.println("终极屁屁:"+filename);
//            ftpUtil.upload(file);
            System.out.println("˵��"+originFileName);//originFileName + suffix
            if(ftpUtil.uploadFileFTP1(filename,is)){
            	System.out.println("�ɹ�");
            	storageState = new BaseState(true);
            	storageState.putInfo("url", "http://119.23.77.220/images/"+filename);
            }
//            State storageState = null;//storageManager.saveFtpFileByInputStream(file, token);
//            is.close();
            System.out.println("�ļ���:"+originFileName + suffix);
            if (storageState.isSuccess()) {
                storageState.putInfo("type", suffix);
                storageState.putInfo("original", originFileName + suffix);
                storageState.putInfo("title", filename);
                storageState.putInfo("size", file.getSize());
            }
            return storageState;
        } catch (IOException e) {
            return new BaseState(false, AppInfo.PARSE_REQUEST_ERROR);
        } catch (Exception e) {
        }
        return new BaseState(false, AppInfo.IO_ERROR);
    }

    private static boolean validType(String type, String[] allowTypes) {
        List<String> list = Arrays.asList(allowTypes);
        return list.contains(type);
    }
}
