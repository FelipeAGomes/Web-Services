package uk.co.webservices.entities.enums;

public enum OrderStatus {
	
	WAITING_PAYMENT(1),
	PAID(2),
	SHIPPED(3),
	DELIVERED(4),
	CANCELED(5);
	
	private int code;
	
	private OrderStatus(int code) {
		this.code = code;
	}
	
	public int getCode() {
		return code;
	}
	
	// to return code value // looping to check code and return value
	public static OrderStatus valueOf(int code) throws IllegalAccessException {
		for(OrderStatus value : OrderStatus.values()) { 
			if (value.getCode() == code) {
				return value;
			}
		}
		throw new IllegalAccessException("Ivalid OrderStatus code");
	}
}
