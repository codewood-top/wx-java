package top.codewood.wx.mnp.bean.updatablemsg;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class WxMnpSetUpdatableMsgRequest implements Serializable {

    /**
     * 动态消息的 ID，通过 updatableMessage.createActivityId 接口获取
     */
    @SerializedName("activity_id")
    private String activytId;

    /**
     * 0: 未开始
     * 1: 已开始
     * 动态消息修改后的状态（具体含义见后文）
     */
    @SerializedName("target_state")
    private int targetState;

    /**
     * 动态消息对应的模板信息
     */
    @SerializedName("template_info")
    private TemplateInfo templateInfo;

    public String getActivytId() {
        return activytId;
    }

    public void setActivytId(String activytId) {
        this.activytId = activytId;
    }

    public int getTargetState() {
        return targetState;
    }

    public void setTargetState(int targetState) {
        this.targetState = targetState;
    }

    public TemplateInfo getTemplateInfo() {
        return templateInfo;
    }

    public void setTemplateInfo(TemplateInfo templateInfo) {
        this.templateInfo = templateInfo;
    }

    public static class TemplateInfo implements Serializable {

        @SerializedName("parameter_list")
        private List<Parameter> parameterList;

        public List<Parameter> getParameterList() {
            return parameterList;
        }

        public void setParameterList(List<Parameter> parameterList) {
            this.parameterList = parameterList;
        }

        @Override
        public String toString() {
            return "TemplateInfo{" +
                    "parameterList=" + parameterList +
                    '}';
        }

    }

    /**
     * 模板中需要修改的参数
     */
    public static class Parameter implements Serializable {

        /**
         * 要修改的参数名
         * -name:
         *  member_count: target_state = 0 时必填，文字内容模板中 member_count 的值
         *  room_limit: target_state = 0 时必填，文字内容模板中 room_limit 的值
         *  path: target_state = 1 时必填，点击「进入」启动小程序时使用的路径。
         *      对于小游戏，没有页面的概念，可以用于传递查询字符串（query），如 "?foo=bar"
         * version_type: target_state = 1 时必填，点击「进入」启动小程序时使用的版本。
         *      有效参数值为：develop（开发版），trial（体验版），release（正式版）
         */
        private String name;

        /**
         * 修改后的参数值
         */
        private String value;

        public Parameter() {}

        public Parameter(String name, String value) {
            this.name = name;
            this.value = value;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "Parameter{" +
                    "name='" + name + '\'' +
                    ", value='" + value + '\'' +
                    '}';
        }
    }


}
