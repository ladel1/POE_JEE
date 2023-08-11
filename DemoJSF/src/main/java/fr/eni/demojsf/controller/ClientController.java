package fr.eni.demojsf.controller;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

import fr.eni.demojsf.bll.ClientManager;
import fr.eni.demojsf.bo.Client;
import jakarta.annotation.PostConstruct;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;

@Named
@ViewScoped
public class ClientController implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Client client = new Client();
	private int clientId;
	Date dateTemp = new Date();

	
	private ClientManager cm = ClientManager.getInstance();

	public ClientController() { }
	
	@PostConstruct
	public void init() {
//		System.out.println("******* init *********");
//		System.out.println(client.getId());
//		if(client.getId()!=null) {
//			System.out.println("********* if ************");
//			client = detailsClient(client.getId());
//			System.out.println(client);
//		}
	}
	
	public Client detailsClient(int id) {
		return cm.getOneClient(id);
	}
	
	public List<Client> afficherTous(){
		return cm.getClients();
	}
	
	public String ajouterClient() {	
		client.setBday(dateTemp.toInstant()
				.atZone(ZoneId.systemDefault()).toLocalDate());
		cm.addClient(client);
		return "liste";
	}
	
	public String supprimerClient(Client client) {
		cm.removeClient(client);
		return "liste";
	}
	
	
	/**
	 * Fin actions
	 * 
	 */
	
	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	


	public Date getDateTemp() {
		return dateTemp;
	}


	public void setDateTemp(Date dateTemp) {
		this.dateTemp = dateTemp;
	}

	public int getClientId() {
		return clientId;
	}

	public void setClientId(int clientId) {
		this.clientId = clientId;
	}




	
	
	
}
