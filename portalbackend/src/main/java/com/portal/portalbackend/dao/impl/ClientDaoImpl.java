package com.portal.portalbackend.dao.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.portal.portalbackend.Client;
import com.portal.portalbackend.dao.ClientDao;

@Repository("clientDao")
@Transactional
public class ClientDaoImpl implements ClientDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public boolean addClient(Client client) {
		try {
			sessionFactory.getCurrentSession().save(client);
			return true;
		} catch (Exception ex) {
			System.out.println(ex);
			return false;
		}
	}

	@Override
	public boolean deleteClient(Client client) {
		try {
			sessionFactory.getCurrentSession().delete(client);
			return true;
		} catch (Exception ex) {
			return false;
		}
	}

	@Override
	public boolean updateClient(Client client) {
		try {
			sessionFactory.getCurrentSession().update(client);
			return true;
		} catch (Exception ex) {
			return false;
		}
	}

	@Override
	public Client getClient(int id) {
		try {
			return sessionFactory.getCurrentSession().get(Client.class, id);
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}

	@Override
	public List<Client> retrieveAllClients() {
		try {

			return sessionFactory.getCurrentSession().createQuery("from Client", Client.class).getResultList();
		} catch (HibernateException e) {
			e.printStackTrace();
			return null;

		}
	}

	@Override
	public Client getClientByEmailId(Client client) {
		try {
			Session session = sessionFactory.getCurrentSession();
			Query query = session.createQuery("from Client where EmailId=?and Password=?");
			query.setParameter(0, client.getEmailId());
			query.setParameter(1, client.getPassword());
			Client validClient = (Client) query.getSingleResult();
			return validClient;
		} catch (HibernateException e) {
			e.printStackTrace();
			return null;
		}
	}
}
