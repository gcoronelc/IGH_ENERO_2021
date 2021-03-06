package com.desarrollasoftware.app.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.desarrollasoftware.app.model.Producto;

@Controller
public class AppController {

	@GetMapping({ "/", "/home", "/index" })
	public String home(Model model) {
		model.addAttribute("titulo", "SALUDO");
		model.addAttribute("mensaje", "Bienvenido a Thymeleaf.");
		return "index";
	}

	@GetMapping("/datos")
	public String datos(Model model) {
		Producto producto = new Producto(1000, "Licuadora", 598.00, 768);
		model.addAttribute("titulo", "Datos del Producto");
		model.addAttribute("producto", producto);
		model.addAttribute("disponible", "True");
		return "datos";
	}

	@GetMapping("/listado")
	public String listado(Model model) {
		List<Producto> productos = new ArrayList<>();
		productos.add(new Producto(1001, "Producto A", 598.00, 768));
		productos.add(new Producto(1002, "Producto B", 783.00, 100));
		productos.add(new Producto(1003, "Producto C", 278.00, 350));
		productos.add(new Producto(1004, "Producto D", 723.00, 820));
		productos.add(new Producto(1005, "Producto E", 634.00, 649));
		model.addAttribute("titulo", "Listado de Productos");
		model.addAttribute("productos", productos);
		return "listado";
	}

}
