package demoJPQLDynamic.ihm;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import demoJPQLDynamic.bo.Computer;
import demoJPQLDynamic.dal.ComputerDao;

@WebServlet("")
public class HomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ComputerDao cDao = new ComputerDao();
//		cDao.saveComputer( new Computer("config1", "Intel Core i5 13600KF", "Corsair Vengeance Black - 2 x 8", "Samsung 970 EVO Plus - 2 To", "ASRock Radeon RX 6950 XT Phantom Gaming", "MSI MAG Z790 TOMAHAWK WIFI") );
//		cDao.saveComputer( new Computer("config2", "Intel Core i7 12600KF", "Corsair Vengeance Black - 2 x 16", "Kingston Fury Renegade SSD - 1 To", "MSI GeForce RTX 4060 VENTUS 2X BLACK 8G OC", "MSI MAG Z790 TOMAHAWK WIFI") );
//		cDao.saveComputer( new Computer("config3", "Intel Core i7 10600KF", "Corsair Vengeance Black - 2 x 8", "Samsung 970 EVO Plus - 1 To", "ASRock Radeon RX 6950 XT Phantom Gaming", "MSI MAG Z790 TOMAHAWK WIFI") );
//		cDao.saveComputer( new Computer("config4", "Intel Core i5 14600KF", "Corsair Vengeance Black - 2 x 16", "Kingston Fury Renegade SSD - 1 To", "ASRock Radeon RX 6950 XT Phantom Gaming", "MSI MAG Z790 TOMAHAWK WIFI") );
//		cDao.saveComputer( new Computer("config5", "Intel Core i5 12600KF", "Corsair Vengeance Black - 2 x 4", "Samsung 970 EVO Plus - 2 To", "MSI GeForce RTX 4060 VENTUS 2X BLACK 8G OC", "MSI MAG Z790 TOMAHAWK WIFI") );
//		Map<String, String> filtreCriteres = new HashMap<String, String>();
//		filtreCriteres.put("cpu","i5");
//		filtreCriteres.put("gpu","MSI");
//		filtreCriteres.put("ram","1g");
//		List<Computer> computers = cDao.filter(filtreCriteres);
		List<Computer> computers = cDao.findByCpu("i5");
		System.out.println(computers);
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

}
