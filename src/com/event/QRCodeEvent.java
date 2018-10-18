package com.event;

/**
 * 
 * 扫描带参数的二维码事件
 * 
 * @author jack
 * @version 1.0
 *
 */
public class QRCodeEvent extends BaseEvent
{
	//事件KEY值
	private String EventKey;
	
	//二维码的ticket
	private String Ticket;

	public String getEventKey() {
		return EventKey;
	}

	public void setEventKey(String eventKey) {
		EventKey = eventKey;
	}

	public String getTicket() {
		return Ticket;
	}

	public void setTicket(String ticket) {
		Ticket = ticket;
	}
}
