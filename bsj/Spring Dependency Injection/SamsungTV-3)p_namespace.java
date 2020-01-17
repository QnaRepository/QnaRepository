package chris.board.polymorphism;

public class SamsungTV implements TV{

	//speaker�Ӽ��� ����ϱ� ���� �� �Ǵ� ��ü�� ���� ������� ����
	private Speaker speaker;
	//price�Ӽ��� ����ϱ� ���� �� �Ǵ� ��ü�� ���� ������� ����
	private int price;
	
	//XML ���ӽ����̽��� �̿��� ���� (P ���ӽ����̽��� �̿��� ����)
	//ApplicationContext.xml������ ���� ���� �ϴܿ� Namespace���� �����Ѵ�.
	//��ϵ��� p�� �����ϰ� apply�� Ŭ���Ѵ�.
	
	//�� �Ŀ� p���ӽ����̽��� ����Ͽ� �������� �����ϰ� �ʹٸ� SamsungTV�� �ش��ϴ� Bean�±׿�
	//p:������-ref="��ü��" �׸��� p:������-value:"��"���� �����±� �ȿ� �Է����ָ� �ȴ�.
	//ex) p:price-value=280000
	
	public void setSpeaker(Speaker speaker) {
		this.speaker = speaker;
		System.out.println("setSpeaker() �޼��� ȣ��");
	}
	public void setPrice(int price) {
		this.price = price;
		System.out.println("setPrice() �޼��� ȣ��");
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
	
}
