package com.desarrollasoftware.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.desarrollasoftware.app.model.VentaModel;

@Controller
@RequestMapping("/venta")
public class VentaController {

	@GetMapping("/form")
	public String formulario() {
		return "venta";
	}

	@PostMapping("/proceso")
	public String proceso(VentaModel ventaModel, Model model) {

		ventaModel.setImporte(ventaModel.getPrecio() * ventaModel.getCantidad());

		model.addAttribute("venta", ventaModel);

		return "venta";
	}

	@PostMapping("/proceso2")
	public String proceso(@ModelAttribute("venta") VentaModel ventaModel) {

		ventaModel.setImporte(ventaModel.getPrecio() * ventaModel.getCantidad());

		return "venta";
	}

	
	@GetMapping("/form2")
	public String formulario2() {
		return "venta2";
	}
	
	@RequestMapping(value = "/proceso3", method = RequestMethod.POST, 
			produces = "application/json; charset=UTF-8")
	@ResponseBody
	public VentaModel proceso3(VentaModel ventaModel) {

		ventaModel.setImporte(ventaModel.getPrecio() * ventaModel.getCantidad());

		return ventaModel;
	}
}
