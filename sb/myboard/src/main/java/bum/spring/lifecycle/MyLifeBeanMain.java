package bum.spring.lifecycle;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MyLifeBeanMain {
	
	public static void main(String[] args) {
		
//		FileSystemResource resource = new FileSystemResource("src/main/resources/applicationContext.xml");
//		XmlBeanFactory factory = new XmlBeanFactory(resource);
		
//		factory.addBeanPostProcessor(new CustomBeanPostProcessor());
		
		AbstractApplicationContext factory = new GenericXmlApplicationContext("applicationContext.xml");
		
		MyLifeBean bean = (MyLifeBean) factory.getBean("myLifeBean");
		System.out.println("---------------- 9 -----------");
		bean.sayHello();
		
		factory.close();
//		factory.destroyBean("myLifeBean", bean);
		
	}

}
