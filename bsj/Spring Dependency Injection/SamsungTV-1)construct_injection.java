package chris.board.polymorphism;

public class SamsungTV implements TV{

	private SonySpeaker speaker;
	
	public SamsungTV()	{
		super();
		System.out.println("samsungTV ��ü ����");
	}
	//applicationContext.xml���� bean�±׸� ����Ͽ� SonySpeaker�� ���� ��ü������ �ϰ�
	//SamsungTV Bean�±� ������ Construct-args�±׸� �ۼ��Ͽ� ref�Ӽ����� 
	//SonySpeaker Bean���� ������ id�� sony�� �Է��Ѵ�.
	public SamsungTV(SonySpeaker speaker)	{
		System.out.println("SamsungTV ��ü ���� : ������ ������");
		this.speaker = speaker;
	}
	
	
	
	
	public void start() {
		System.out.println("��ü �ʱ�ȭ �۾� ó��");
	}
	public void powerOn() {
		System.out.println("SamsungTV ������ Ų��.");
	}
	public void powerOff() {
		System.out.println("SamsungTV ������ ����.");
	}
	public void volumeUp() {
		//�������� �μ��� SonySpeakerŸ���� ��ü�� ������ ��� ������ �ȴ�.
		speaker.volumeUp();
	}
	public void volumeDown() {
		//�������� �μ��� SonySpeakerŸ���� ��ü�� ������ ��� ������ �ȴ�.
		speaker.volumeDown();
	}
	public void stop() {
		System.out.println("��ü ���� ���� ó���� ���� ó��");
	}
	
}
