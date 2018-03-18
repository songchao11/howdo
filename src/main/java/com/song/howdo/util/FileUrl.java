package com.song.howdo.util;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by songchao on 2018/3/17.
 */
public class FileUrl {

    /**
     * 查找出内容中的文件地址
     * @param content
     * @return
     */
    public List<String> getFileUrl(String content){
        List<String> list = new ArrayList<String>();
        Pattern p_img = Pattern.compile("(<img[^>]+src\\s*=\\s*['\"]([^'\"]+)['\"][^>]*>)");
        Matcher m_img = p_img.matcher(content);
        while (m_img.find()) {
            String img = m_img.group(2); //m_img.group(1) 为获得整个img标签  m_img.group(2) 为获得src的值
            list.add(img);
        }
        return list;
    }

}
