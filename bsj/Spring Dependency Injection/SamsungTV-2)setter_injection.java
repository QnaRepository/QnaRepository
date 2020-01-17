package chris.board.polymorphism;

public class SamsungTV implements TV{

	//speaker속성을 사용하기 위해 값 또는 객체를 담을 멤버변수 생성
	private Speaker speaker;
	//price속성을 사용하기 위해 값 또는 객체를 담을 멤버변수 생성
	private int price;
	
	//setter injection - setter메서드를 통하여 의존성 주입을 하는 방법이다.
	//Applicationcontext.xml의 samsungTV에 대한 Bean태그 내에 setter메서드를 통한 의존성 주입을 하고 싶다면
	//<property name = "speaker" ref = "sony">
	//<property name = "price" value = "3000000">
	//위와 같이 작성해주면 된다.
	//이는 각각 setSpeaker(sony),setPrice(3000000)과 같은 코드이다.
	//이때 매개변수로 들어가는 자료형이 객체라면 property의 속성은 ref이고
	//매개변수로 기본 자료형이 들어간다면 property의 속성은 value를 적어주면 된다.
	
	public void setSpeaker(Speaker speaker) {
		this.speaker = speaker;
		System.out.println("setSpeaker() 메서드 호출");
	}
	public void setPrice(int price) {
		this.price = price;
		System.out.println("setPrice() 메서드 호출");
	}

	
	public void powerOn() {
		System.out.println("SamsungTV 전원을 킨다.(가격 : " + price +"원)");
	}
	public void powerOff() {
		System.out.println("SamsungTV 전원을 끈다.");
	}
	public void volumeUp() {
		speaker.volumeUp();
	}
	public void volumeDown() {
		speaker.volumeDown();
	}
	
}
