package com.tcsms.securityserver.Config;

public enum WarningInfo {
    DEVICE_COLLISION_YELLOW_WARNING(500, "设备间碰撞黄色警报！"),
    DEVICE_COLLISION_RED_WARNING(501, "设备间碰撞红色警报！"),
    TORQUE_YELLOW_WARNING(502, "设备超重黄色警报！"),
    TORQUE_RED_WARNING(503, "设备超重红色警报！"),
    WIND_VELOCITY_YELLOW_WARNING(504, "黄色四级大风警报！"),
    WIND_VELOCITY_RED_WARNING(505, "红色六级大风警报！"),
    OPERATOR_RED_WARNING(506, "为未注册的驾驶员红色警报！"),
    ;
    private int code;
    private String msg;

    WarningInfo(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
