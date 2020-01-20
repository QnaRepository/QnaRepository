package bum.spring.polymorphism;

public class SamsungTV implements TV {
	
	private Speaker speaker;
	private int price;
	
	public SamsungTV() {
		System.out.println("SamsungTV 객체 생성");
	}
	public SamsungTV(Speaker speaker) { // 생성자 인젝션
		System.out.println("SamsungTV 객체 생성 - 생성자 인젝션");
		this.speaker = speaker;
	}
	public SamsungTV(Speaker speaker, int price) { // 생성자 인젝션
		System.out.println("SamsungTV 객체 생성 - 생성자 인젝션 : 다중매핑");
		this.speaker = speaker;
		this.price = price;
	}
	public Speaker getSpeaker() {
		return speaker;
	}
	public void setSpeaker(Speaker speaker) { // 세터 인젝션
		System.out.println("setSpeaker() 메서드 호출");
		this.speaker = speaker;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		System.out.println("setPrice() 메서드 호출");
		this.price = price;
	}
	
	
	
	
	public void powerOn() {
		System.out.println("SamsungTV 전원을 켠다 (가격 : " + price + "원)");

	}
	public void powerOff() {
		System.out.println("SamsungTV 전원을 끈다");
	}
	public void volumeUp() {
		speaker.volumeUp();
		
	}
	public void volumeDown() {
		speaker.volumeDown();
	}



}
