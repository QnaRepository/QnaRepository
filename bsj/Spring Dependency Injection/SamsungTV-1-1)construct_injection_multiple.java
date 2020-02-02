package chris.board.polymorphism;

public class SamsungTV implements TV{

	//speaker�Ӽ��� ����ϱ� ���� �� �Ǵ� ��ü�� ���� ������� ����
	private SonySpeaker speaker;
	//price�Ӽ��� ����ϱ� ���� �� �Ǵ� ��ü�� ���� ������� ����
	private int price;
	
	public SamsungTV()	{
		super();
		System.out.println("samsungTV ��ü ����");
	}
	
	//speaker, price�� ���� ���� �����ϴ� �޼����� TVUser.java���� �Էµ����ʾҴ�.
	//�׷��ٸ� �Ʒ��� �����ڿ� �μ��� ��� �������� ���ϱ�?
	//�ٷ� ApplicationContext.xml���Ͽ��� �޾ƿ´�. 
	//Samsung TV��ü�� bean���� ������ �ڵ� �ȿ� ���� speaker�� price�� constructor-args�±׿� ���� �־��ش�. 
	//�̶� ��ü�� �ִ°�� ref, ��ü�� �ƴ� �⺻�ڷ����� ���� �־��ִ� ��� value �Ӽ����� �ְ� ���Ǵ� ��ü�� ���� �־��ش�.
	//���� �ڷ����� ���� ��� ������ ���Ѽ� �־��ְų�, index�Ӽ����� ������ �Ű��־ �Է��Ѵ�.
	public SamsungTV(SonySpeaker speaker, int price) {
		System.out.println("SamsungTV ��ü ���� : ������ ������ - ���߸���");
		this.speaker = speaker;
		this.price = price;
	}
	
	
	public void start() {
		System.out.println("��ü �ʱ�ȭ �۾� ó��");
	}
	public void powerOn() {
		System.out.println("SamsungTV ������ Ų��.(���� : " + price +"��)");
	}
	public void powerOff() {
		System.out.println("SamsungTV ������ ����.");
	}
	public void volumeUp() {
		speaker.volumeUp();
	}
	public void volumeDown() {
		speaker.volumeDown();
	}
	public void stop() {
		System.out.println("��ü ���� ���� ó���� ���� ó��");
	}
	
}
