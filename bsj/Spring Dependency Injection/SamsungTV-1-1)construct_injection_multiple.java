package chris.board.polymorphism;

public class SamsungTV implements TV{

	//speaker속성을 사용하기 위해 값 또는 객체를 담을 멤버변수 생성
	private SonySpeaker speaker;
	//price속성을 사용하기 위해 값 또는 객체를 담을 멤버변수 생성
	private int price;
	
	public SamsungTV()	{
		super();
		System.out.println("samsungTV 객체 생성");
	}
	
	//speaker, price의 값은 직접 실행하는 메서드인 TVUser.java에서 입력되지않았다.
	//그렇다면 아래의 생성자에 인수는 어디서 가져오는 것일까?
	//바로 ApplicationContext.xml파일에서 받아온다. 
	//Samsung TV객체를 bean으로 설정한 코드 안에 각각 speaker와 price를 constructor-args태그에 각각 넣어준다. 
	//이때 객체를 넣는경우 ref, 객체가 아닌 기본자료형의 값을 넣어주는 경우 value 속성으로 넣고 값또는 객체의 명을 넣어준다.
	//만일 자료형이 같은 경우 순서를 지켜서 넣어주거나, index속성으로 순서를 매겨주어서 입력한다.
	public SamsungTV(SonySpeaker speaker, int price) {
		System.out.println("SamsungTV 객체 생성 : 생성자 인젝셩 - 다중매핑");
		this.speaker = speaker;
		this.price = price;
	}
	
	
	public void start() {
		System.out.println("객체 초기화 작업 처리");
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
	public void stop() {
		System.out.println("객체 삭제 전에 처리할 로직 처리");
	}
	
}
