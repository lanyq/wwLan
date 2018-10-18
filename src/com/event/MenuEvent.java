package com.event;


/**
 * 
 * 菜单事件消息
 * @author jack
 * @version 1.0
 *
 */
public class MenuEvent  extends BaseEvent
{
	//事件KEY值
	private String EventKey;

	public String getEventKey() {
		return EventKey;
	}

	public void setEventKey(String eventKey) {
		EventKey = eventKey;
	}
}
