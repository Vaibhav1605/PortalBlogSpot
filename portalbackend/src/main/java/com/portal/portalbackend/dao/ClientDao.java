package com.portal.portalbackend.dao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.portal.portalbackend.Client;

@Component
public interface ClientDao {

	public boolean addClient(Client client);

	public boolean deleteClient(Client client);

	public boolean updateClient(Client client);

	public Client getClient(int id);
	
	public Client getClientByEmailId(Client client);
	
	List<Client> retrieveAllClients();

}
