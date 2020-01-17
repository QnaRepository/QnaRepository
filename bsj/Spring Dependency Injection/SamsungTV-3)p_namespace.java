package chris.board.polymorphism;

public class SamsungTV implements TV{

	//speaker속성을 사용하기 위해 값 또는 객체를 담을 멤버변수 생성
	private Speaker speaker;
	//price속성을 사용하기 위해 값 또는 객체를 담을 멤버변수 생성
	private int price;
	
	//XML 네임스페이스를 이용한 설정 (P 네임스페이스를 이용한 설정)
	//ApplicationContext.xml파일을 열고 파일 하단에 Namespace탭을 선택한다.
	//목록들중 p를 선택하고 apply를 클릭한다.
	
	//그 후에 p네임스페이스를 사용하여 의존성을 주입하고 싶다면 SamsungTV에 해당하는 Bean태그에
	//p:변수명-ref="객체명" 그리고 p:변수명-value:"값"으로 여는태그 안에 입력해주면 된다.
	//ex) p:price-value=280000
	
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
