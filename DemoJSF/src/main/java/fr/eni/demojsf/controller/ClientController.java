package fr.eni.demojsf.controller;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

import fr.eni.demojsf.bll.ClientManager;
import fr.eni.demojsf.bo.Client;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;

@Named
@ViewScoped
public class ClientController implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Client client = new Client();
	Date dateTemp = new Date();

	
	private ClientManager cm = ClientManager.getInstance();

	public ClientController() { }
	
	
	public String ajouterClient() {	
		client.setBday(dateTemp.toInstant()
				.atZone(ZoneId.systemDefault()).toLocalDate());
		cm.addClient(client);
		return "liste";
	}
	
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




	
	
	
}
