package chris.board.polymorphism;

public class SamsungTV implements TV{

	//speaker�Ӽ��� ����ϱ� ���� �� �Ǵ� ��ü�� ���� ������� ����
	private Speaker speaker;
	//price�Ӽ��� ����ϱ� ���� �� �Ǵ� ��ü�� ���� ������� ����
	private int price;
	
	//setter injection - setter�޼��带 ���Ͽ� ������ ������ �ϴ� ����̴�.
	//Applicationcontext.xml�� samsungTV�� ���� Bean�±� ���� setter�޼��带 ���� ������ ������ �ϰ� �ʹٸ�
	//<property name = "speaker" ref = "sony">
	//<property name = "price" value = "3000000">
	//���� ���� �ۼ����ָ� �ȴ�.
	//�̴� ���� setSpeaker(sony),setPrice(3000000)�� ���� �ڵ��̴�.
	//�̶� �Ű������� ���� �ڷ����� ��ü��� property�� �Ӽ��� ref�̰�
	//�Ű������� �⺻ �ڷ����� ���ٸ� property�� �Ӽ��� value�� �����ָ� �ȴ�.
	
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
