package chris.board.polymorphism;

public class SamsungTV implements TV{

	private SonySpeaker speaker;
	
	public SamsungTV()	{
		super();
		System.out.println("samsungTV 객체 생성");
	}
	//applicationContext.xml에서 bean태그를 사용하여 SonySpeaker에 대한 객체설정을 하고
	//SamsungTV Bean태그 하위에 Construct-args태그를 작성하여 ref속성으로 
	//SonySpeaker Bean에서 설정한 id인 sony를 입력한다.
	public SamsungTV(SonySpeaker speaker)	{
		System.out.println("SamsungTV 객체 생성 : 생성자 인젝션");
		this.speaker = speaker;
	}
	
	
	
	
	public void start() {
		System.out.println("객체 초기화 작업 처리");
	}
	public void powerOn() {
		System.out.println("SamsungTV 전원을 킨다.");
	}
	public void powerOff() {
		System.out.println("SamsungTV 전원을 끈다.");
	}
	public void volumeUp() {
		//생성자의 인수로 SonySpeaker타입의 객체가 들어오는 경우 실행이 된다.
		speaker.volumeUp();
	}
	public void volumeDown() {
		//생성자의 인수로 SonySpeaker타입의 객체가 들어오는 경우 실행이 된다.
		speaker.volumeDown();
	}
	public void stop() {
		System.out.println("객체 삭제 전에 처리할 로직 처리");
	}
	
}
