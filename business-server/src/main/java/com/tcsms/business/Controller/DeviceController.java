package com.tcsms.business.Controller;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.tcsms.business.Entity.OperationLog;
import com.tcsms.business.JSON.ResultJSON;
import com.tcsms.business.Service.ReceiveServiceImp.DeviceRegistryServiceImp;
import com.tcsms.business.Service.ReceiveServiceImp.RedisServiceImp;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@Log4j2
public class DeviceController {
    @Autowired
    DeviceRegistryServiceImp deviceRegistryServiceImp;
    @Autowired
    RedisServiceImp redisServiceImp;
    @Autowired
    WebSocket webSocket;

    @RequestMapping("/deviceInfo")
    public String getDeviceInfo() {
        JsonArray jsonArray = deviceRegistryServiceImp.getAllDeviceInfo();
        log.info(jsonArray);
        return jsonArray.toString();
    }

    @RequestMapping(value = "/operationLog", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public String getOperationLog(@RequestBody String json, HttpServletRequest request) {
        JsonObject jsonObject = new Gson().fromJson(json, JsonObject.class);
        String deviceId = jsonObject.get("deviceId").getAsString();
        String name = request.getHeader("authorization").replaceAll("Bearer ", "");
        OperationLog operationLog = new Gson().fromJson(redisServiceImp.getRedis().get(deviceId), OperationLog.class);
        operationLog.setAngle(359.0);
        operationLog.setRadius(50.0);
        Thread thread = new Thread(() -> {
            while (true) {
                try {
                    //String operationLog = redisServiceImp.getRedis().get(deviceId);
                    //OperationLog operationLog = new Gson().fromJson(redisServiceImp.getRedis().get(deviceId), OperationLog.class);
                    operationLog.setAngle((operationLog.getAngle() - 2) % 360);
                    operationLog.setRadius(operationLog.getRadius() - 1);
                    log.info(operationLog);
                    webSocket.AppointSending(name, operationLog.toString());
                    Thread.sleep(500);
                } catch (Exception e) {
                    e.printStackTrace();
                    return;
                }
            }
        });
        thread.start();
        return new ResultJSON(200, true, "获取设备运行信息成功！", null).toString();
    }

}
