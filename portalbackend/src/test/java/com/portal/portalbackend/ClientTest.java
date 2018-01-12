package com.portal.portalbackend;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.portal.portalbackend.dao.ClientDao;
import com.portal.portalbackend.Client;

public class ClientTest {
	AnnotationConfigApplicationContext context;
	ClientDao clientDao;
	Client client;

	@Before
	public void init() {
		context = new AnnotationConfigApplicationContext();
		context.scan("com.portal");
		context.refresh();
		clientDao = (ClientDao) context.getBean("clientDao");
		client = new Client();

	}

	@Test
	public void createTest() {
		client.setClientId(7);
		client.setFirstName("Dr.");
		client.setLastName("Strange");
		client.setPassword("Marvel");
		client.setConfirmPassword("Marvel");
		client.setEmailId("strange@gmail.com");
		client.setMobileNumber("1234567890");
		client.setRole("ROLE_CUSTOMER");

		Assert.assertEquals("User is added", true, clientDao.addClient(client));
	}

	@Test
	public void deleteTest() {
		client.getFirstName();
		client.setClientId(24);
		Assert.assertEquals("Client Deleted.!", true, clientDao.deleteClient(client));

	}

	@Test
	public void updateTest() {

		client = clientDao.getClient(25);
		client.setFirstName("Vaibhav");
		client.setLastName("Strange");

		Assert.assertEquals("update successful", true, clientDao.updateClient(client));
	}

	@Test
	public void test() {

		List<Client> clients = clientDao.retrieveAllClients();
		for (int i = 0; i < clients.size(); i++) {
			Client client = (Client) clients.get(i);
			System.out.println(client.getClientId() + " " + client.getFirstName() + " " + client.getLastName());
		}
	}

}
