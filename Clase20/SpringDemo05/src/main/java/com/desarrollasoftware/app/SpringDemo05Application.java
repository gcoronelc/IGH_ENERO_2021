package com.desarrollasoftware.app;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.desarrollasoftware.app.model.ClienteModel;
import com.desarrollasoftware.app.repository.DemoRepository;

@SpringBootApplication
public class SpringDemo05Application implements CommandLineRunner {

	@Autowired
	private DemoRepository demoRepository;

	public static void main(String[] args) {
		SpringApplication.run(SpringDemo05Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		System.out.println("Cant. cuentas: " + demoRepository.getNroCuentas());
		System.out.println("Saldo soles: " + demoRepository.getSaldoSoles());
		System.out.println("Cliente: " + demoRepository.getNombreCliente("000016"));

		// Bean
		ClienteModel bean = demoRepository.getCliente("000041");
		if (bean != null) {
			System.out.println("Nombre: " + bean.getNombre());
			System.out.println("Paterno: " + bean.getPaterno());
			System.out.println("Materno: " + bean.getMaterno());
		}
		
		// Lista
		System.out.println("---------------------------------------------------------");
		List<ClienteModel> lista = demoRepository.getClientes("", "c");
		for (ClienteModel r : lista) {
			System.out.println(
					r.getCodigo() + " " + r.getNombre() 
					+ " " + r.getPaterno() + " " + r.getMaterno());
		}
		
		
		// Lista 2
		System.out.println("-----------------------------------------------------");
		List<Map<String,Object>> lista2 = demoRepository.getMovimientos("00100001");
		for(Map<String,Object> r2: lista2){
			System.out.println(r2.get("nromov") + " " + r2.get("fecha") +
			" " + r2.get("tipo") + " " + r2.get("importe"));
		}
		
		// Prueba de TX
		ClienteModel clie1 = new ClienteModel();
		clie1.setPaterno("Torres");
		clie1.setMaterno("Ramos");
		clie1.setNombre("Julio");
		clie1.setDni("65723476");
		clie1.setCiudad("Lima");
		clie1.setDireccion("Mi Casa");
		clie1.setEmail("algo@gmail.com");
		try {
			demoRepository.ejmTX(clie1);
			System.out.println("Proceso ok. Código: " + clie1.getCodigo());
		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
		}
		

	}

}
