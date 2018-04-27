package com.song.howdo.ueditor;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.alibaba.fastjson.JSONException;
import com.song.howdo.ueditor.define.ActionMap;
import com.song.howdo.ueditor.define.AppInfo;
import com.song.howdo.ueditor.define.BaseState;
import com.song.howdo.ueditor.define.State;
import com.song.howdo.ueditor.hunter.FileManager;
import com.song.howdo.ueditor.upload.Uploader;

public class ActionEnter {

	private HttpServletRequest request = null;

    private String actionType = null;

    private ConfigManager configManager = null;

    public ActionEnter(ConfigManager configManager) {
        this.configManager = configManager;
    }

    public String exec(HttpServletRequest request) throws JSONException {
        this.request = request;
        this.actionType = request.getParameter("action");
        String callbackName = this.request.getParameter("callback");
        if (callbackName != null) {
            if (!validCallbackName(callbackName)) {
                return new BaseState(false, AppInfo.ILLEGAL).toJSONString();
            }
            return callbackName + "(" + this.invoke() + ");";
        } else {
            return this.invoke();
        }
    }

    public String invoke() throws JSONException {
        if (actionType == null || !ActionMap.mapping.containsKey(actionType)) {
            return new BaseState(false, AppInfo.INVALID_ACTION).toJSONString();
        }

        if (this.configManager == null || !this.configManager.valid()) {
            return new BaseState(false, AppInfo.CONFIG_ERROR).toJSONString();
        }

        State state = null;

        int actionCode = ActionMap.getType(this.actionType);

        Map<String, Object> conf = null;

        switch (actionCode) {

            case ActionMap.CONFIG:
                return this.configManager.getAllConfig().toString();

            case ActionMap.UPLOAD_IMAGE:
                conf = this.configManager.getConfig(actionCode);
                //����ftp�ϴ��ļ�
                conf.put("useFtpUpload",this.configManager.getAllConfig().getString("useFtpUpload"));
                conf.put("keepLocalFile",this.configManager.getAllConfig().getString("keepLocalFile"));
                state = new Uploader(request, conf).doExec();
                break;
            case ActionMap.UPLOAD_SCRAWL:
            case ActionMap.UPLOAD_VIDEO:
                conf = configManager.getConfig(actionCode);
                conf.put("useFtpUpload",this.configManager.getAllConfig().getString("useFtpUpload"));
                conf.put("keepLocalFile",this.configManager.getAllConfig().getString("keepLocalFile"));
                state = new Uploader(request, conf).doExec();
                break;
            case ActionMap.UPLOAD_FILE:
                conf = this.configManager.getConfig(actionCode);
                conf.put("useFtpUpload",this.configManager.getAllConfig().getString("useFtpUpload"));
                conf.put("keepLocalFile",this.configManager.getAllConfig().getString("keepLocalFile"));
                state = new Uploader(request, conf).doExec();
                break;

            case ActionMap.LIST_IMAGE:
            case ActionMap.LIST_FILE:
                conf = configManager.getConfig(actionCode);
                int start = this.getStartIndex();
                state = new FileManager(conf).listFile(start);
                break;
        }
        return state.toJSONString();
    }

    public int getStartIndex() {

        String start = this.request.getParameter("start");

        try {
            return Integer.parseInt(start);
        } catch (Exception e) {
            return 0;
        }

    }

    /**
     * callback������֤
     */
    public boolean validCallbackName(String name) {

        if (name.matches("^[a-zA-Z_]+[\\w0-9_]*$")) {
            return true;
        }

        return false;

    }

}