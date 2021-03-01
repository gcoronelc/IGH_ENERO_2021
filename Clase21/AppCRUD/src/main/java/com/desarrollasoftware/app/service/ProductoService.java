package com.desarrollasoftware.app.service;

import java.util.List;

import com.desarrollasoftware.app.entity.Producto;

public interface ProductoService {

	public List<Producto> listarTodos();
	public void grabar(Producto producto);
	public Producto buscarPorId(Long id);
	public void eliminar(Long id); 

}
