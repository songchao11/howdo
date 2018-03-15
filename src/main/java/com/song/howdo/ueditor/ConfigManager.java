package com.song.howdo.ueditor;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.song.howdo.ueditor.define.ActionMap;



/**
 * ���ù�����
 */
public final class ConfigManager {

    private static final String configFileName = "config.json";
    private JSONObject jsonConfig = null;
    // Ϳѻ�ϴ�filename����
    private final static String SCRAWL_FILE_NAME = "scrawl";
    // Զ��ͼƬץȡfilename����
    private final static String REMOTE_FILE_NAME = "remote";
    //������Ϣ
    private UEditorConfig uEditorConfig;

    /*
     * ͨ��һ��������·������һ�����ù������� �ù�����Ҫ���ַ·������Ŀ¼�±������config.properties�ļ�
     */
    private ConfigManager(UEditorConfig uEditorConfig) throws IOException {
        this.uEditorConfig = uEditorConfig;
        String configPath = uEditorConfig.getConfig();
        configPath = configPath == null || configPath.isEmpty() ? configFileName : configPath;
        this.initEnv(configPath);
    }

    /**
     * ���ù��������칤��
     *
     * @param uEditorConfig �����ļ�
     * @return ���ù�����ʵ������null
     */
    public static ConfigManager getInstance(UEditorConfig uEditorConfig) {

        try {
            return new ConfigManager(uEditorConfig);
        } catch (Exception e) {
            System.err.println("UEditor ConfigManager load error~");
            return null;
        }

    }

    // ��֤�����ļ������Ƿ���ȷ
    public boolean valid() {
        return this.jsonConfig != null;
    }

    public JSONObject getAllConfig() {

        return this.jsonConfig;

    }

    public Map<String, Object> getConfig(int type) {

        Map<String, Object> conf = new HashMap<String, Object>();
        String savePath = null;

        try {
            switch (type) {

                case ActionMap.UPLOAD_FILE:
                    conf.put("isBase64", "false");
                    conf.put("maxSize", this.jsonConfig.getLong("fileMaxSize"));
                    conf.put("allowFiles", this.getArray("fileAllowFiles"));
                    conf.put("fieldName", this.jsonConfig.getString("fileFieldName"));
                    savePath = this.jsonConfig.getString("filePathFormat");
                    break;

                case ActionMap.UPLOAD_IMAGE:
                    conf.put("isBase64", "false");
                    conf.put("maxSize", this.jsonConfig.getLong("imageMaxSize"));
                    conf.put("allowFiles", this.getArray("imageAllowFiles"));
                    conf.put("fieldName", this.jsonConfig.getString("imageFieldName"));
                    savePath = this.jsonConfig.getString("imagePathFormat");
                    break;

                case ActionMap.UPLOAD_VIDEO:
                    conf.put("maxSize", this.jsonConfig.getLong("videoMaxSize"));
                    conf.put("allowFiles", this.getArray("videoAllowFiles"));
                    conf.put("fieldName", this.jsonConfig.getString("videoFieldName"));
                    savePath = this.jsonConfig.getString("videoPathFormat");
                    break;

                case ActionMap.UPLOAD_SCRAWL:
                    conf.put("filename", ConfigManager.SCRAWL_FILE_NAME);
                    conf.put("maxSize", this.jsonConfig.getLong("scrawlMaxSize"));
                    conf.put("fieldName", this.jsonConfig.getString("scrawlFieldName"));
                    conf.put("isBase64", "true");
                    savePath = this.jsonConfig.getString("scrawlPathFormat");
                    break;

                case ActionMap.CATCH_IMAGE:
                    conf.put("filename", ConfigManager.REMOTE_FILE_NAME);
                    conf.put("filter", this.getArray("catcherLocalDomain"));
                    conf.put("maxSize", this.jsonConfig.getLong("catcherMaxSize"));
                    conf.put("allowFiles", this.getArray("catcherAllowFiles"));
                    conf.put("fieldName", this.jsonConfig.getString("catcherFieldName") + "[]");
                    savePath = this.jsonConfig.getString("catcherPathFormat");
                    break;

                case ActionMap.LIST_IMAGE:
                    conf.put("allowFiles", this.getArray("imageManagerAllowFiles"));
                    conf.put("dir", this.jsonConfig.getString("imageManagerListPath"));
                    conf.put("count", this.jsonConfig.getInt("imageManagerListSize"));
                    break;

                case ActionMap.LIST_FILE:
                    conf.put("allowFiles", this.getArray("fileManagerAllowFiles"));
                    conf.put("dir", this.jsonConfig.getString("fileManagerListPath"));
                    conf.put("count", this.jsonConfig.getInt("fileManagerListSize"));
                    break;

            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

        conf.put("savePath", savePath);
        conf.put("rootPath", uEditorConfig.getUploadPath());
        conf.put("urlPrefix", uEditorConfig.getUrlPrefix());
        return conf;

    }

    private void initEnv(String configPath) throws IOException {

        String configContent = this.readFile(configPath);

        try {
            JSONObject jsonConfig = new JSONObject(configContent);
            //ͳһurl����ǰ׺
            if (uEditorConfig.getUnified()) {
                Iterator iterator = jsonConfig.keys();
                while (iterator.hasNext()) {
                    String key = (String) iterator.next();
                    if (key.contains("UrlPrefix")) {
                        jsonConfig.put(key, uEditorConfig.getUrlPrefix());
                    }
                }
            }
            this.jsonConfig = jsonConfig;
        } catch (Exception e) {
            this.jsonConfig = null;
        }

    }

    private String[] getArray(String key) throws JSONException {

        JSONArray jsonArray = this.jsonConfig.getJSONArray(key);
        String[] result = new String[jsonArray.length()];

        for (int i = 0, len = jsonArray.length(); i < len; i++) {
            result[i] = jsonArray.getString(i);
        }

        return result;

    }

    private String readFile(String path) throws IOException {

        StringBuilder builder = new StringBuilder();

        try {
            InputStream inputStream = getClass().getClassLoader().getResourceAsStream(path);
            InputStreamReader reader = new InputStreamReader(inputStream, "UTF-8");
            BufferedReader bfReader = new BufferedReader(reader);

            String tmpContent = null;

            while ((tmpContent = bfReader.readLine()) != null) {
                builder.append(tmpContent);
            }

            bfReader.close();

        } catch (UnsupportedEncodingException e) {
            // ����
        }

        return this.filter(builder.toString());

    }

    // ���������ַ���, �޳�����ע���Լ��滻����б��
    private String filter(String input) {

        return input.replaceAll("/\\*[\\s\\S]*?\\*/", "");

    }

}
