package com.tcsms.business.Entity;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "device_registry")
public class DeviceRegistry implements Serializable{
    @Id
    @Column(name = "deviceId")
    private String deviceId;
    @Column(name = "isRegistered")
    private String isRegistered;
    @Column(name = "deviceModel")
    private String deviceModel;
    @Column(name = "longitude")
    private Double longitude;
    @Column(name = "latitude")
    private Double latitude;
    @Column(name = "rlt")
    private Double rlt;
    @Column(name = "bigHeight")
    private Double bigHeight;
    @Column(name = "smallHeight")
    private Double smallHeight;
    @Column(name = "bigLength")
    private Double bigLength;
    @Column(name = "smallLength")
    private Double smallLength;


    public String getIsRegistered() {
        return isRegistered;
    }

    public void setIsRegistered(String isRegistered) {
        this.isRegistered = isRegistered;
    }


    public String getDeviceModel() {
        return deviceModel;
    }

    public void setDeviceModel(String deviceModel) {
        this.deviceModel = deviceModel;
    }


    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }


    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }


    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }


    public Double getRlt() {
        return rlt;
    }

    public void setRlt(Double rlt) {
        this.rlt = rlt;
    }


    public Double getBigHeight() {
        return bigHeight;
    }

    public void setBigHeight(Double bigHeight) {
        this.bigHeight = bigHeight;
    }


    public Double getSmallHeight() {
        return smallHeight;
    }

    public void setSmallHeight(Double smallHeight) {
        this.smallHeight = smallHeight;
    }


    public Double getBigLength() {
        return bigLength;
    }

    public void setBigLength(Double bigLength) {
        this.bigLength = bigLength;
    }


    public Double getSmallLength() {
        return smallLength;
    }

    public void setSmallLength(Double smallLength) {
        this.smallLength = smallLength;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DeviceRegistry that = (DeviceRegistry) o;
        return isRegistered == that.isRegistered &&
                Double.compare(that.longitude, longitude) == 0 &&
                Double.compare(that.latitude, latitude) == 0 &&
                Objects.equals(deviceModel, that.deviceModel) &&
                Objects.equals(deviceId, that.deviceId) &&
                Objects.equals(rlt, that.rlt) &&
                Objects.equals(bigHeight, that.bigHeight) &&
                Objects.equals(smallHeight, that.smallHeight) &&
                Objects.equals(bigLength, that.bigLength) &&
                Objects.equals(smallLength, that.smallLength);
    }

    @Override
    public int hashCode() {
        return Objects.hash(isRegistered, deviceModel, deviceId, longitude, latitude, rlt, bigHeight, smallHeight, bigLength, smallLength);
    }
    public String toString() {
        return "{" +
                "\"deviceId\":" + "\"" + deviceId + "\"" + "," +
                "\"isRegistered\":" + "\"" + isRegistered + "\"" + "," +
                "\"deviceModel\":" + "\"" + deviceModel + "\"" + "," +
                "\"longitude\":" + longitude + "," +
                "\"latitude\":" + latitude + "," +
                "\"rlt\":" + rlt + "," +
                "\"bigHeight\":" + bigHeight + "," +
                "\"smallHeight\":" + smallHeight + "," +
                "\"bigLength\":" + bigLength + "," +
                "\"smallLength\":" + smallLength +
                "}";
    }
    public JsonObject getJsonObject() {
        return new JsonParser().parse(toString()).getAsJsonObject();
    }
}
