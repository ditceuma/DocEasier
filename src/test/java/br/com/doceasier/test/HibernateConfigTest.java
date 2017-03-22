package br.com.doceasier.test;

import org.hibernate.SessionFactory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import org.springframework.test.context.web.WebAppConfiguration;

import br.com.doceasier.config.SpringConfiguration;

@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=SpringConfiguration.class, loader=AnnotationConfigContextLoader.class)
public class HibernateConfigTest {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Autowired
	private AutowireCapableBeanFactory beanFactoryCapable;
	
	@Test
	public void deveValidarSessionFactoryNull(){
		//Assert.assertNotNull(sessionFactory);
		beanFactoryCapable.autowireBean(sessionFactory);
		Assert.assertNotNull(sessionFactory);
	}
}
