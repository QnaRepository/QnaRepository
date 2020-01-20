package bum.spring.collection;

import java.util.List;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;


public class CollectionBeanClient {
	public static void main(String[] args) {
		
		AbstractApplicationContext factory = new GenericXmlApplicationContext("applicationContext.xml");
		CollectionBean bean = (CollectionBean)factory.getBean("collectionBean");
		
		List<String> addressList = bean.getAddressList();
		
		for(String address: addressList) {
			System.out.println(address);
		}
		factory.close();
	}
}
