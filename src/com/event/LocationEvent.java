package com.event;

/**
 * 位置事件消息
 * 
 * @author jack
 * @version 1.0
 *
 */
public class LocationEvent extends  BaseEvent
{
	//地理位置纬度
	private String Latitude;
	
	//地理位置经度
	private String Longitude;
	
	//地理位置精度
	private String Precision;

	public String getLatitude() {
		return Latitude;
	}

	public void setLatitude(String latitude) {
		Latitude = latitude;
	}

	public String getLongitude() {
		return Longitude;
	}

	public void setLongitude(String longitude) {
		Longitude = longitude;
	}

	public String getPrecision() {
		return Precision;
	}

	public void setPrecision(String precision) {
		Precision = precision;
	}
}

