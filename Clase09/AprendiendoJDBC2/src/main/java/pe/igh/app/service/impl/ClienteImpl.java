package pe.igh.app.service.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import pe.igh.app.db.AccesoDB;
import pe.igh.app.model.Cliente;
import pe.igh.app.service.spec.ClienteSpec;

/**
 * @author Eric Gustavo Coronel Castillo
 * @blog www.desarrollasoftware.com
 * @email gcoronelc@gmail.com
 * @youtube www.youtube.com/c/DesarrollaSoftware
 * @facebook www.facebook.com/groups/desarrollasoftware/
 */
public class ClienteImpl implements ClienteSpec {

	@Override
	public Cliente traer(String idCliente) {
		Cliente cliente = null;
		Connection cn = null;
		try {
			cn = AccesoDB.getConnection();
			String sql = "select chr_cliecodigo, vch_cliepaterno, vch_cliematerno, "
							+ "vch_clienombre, chr_cliedni, vch_clieciudad, "
							+ "vch_cliedireccion, vch_clietelefono, vch_clieemail "
							+ "from cliente "
							+ "where chr_cliecodigo = ?";
			PreparedStatement pstm = cn.prepareStatement(sql);
			pstm.setString(1, idCliente);
			ResultSet rs = pstm.executeQuery();
			if (rs.next()) {
				cliente = new Cliente();
				cliente.setCodigo(rs.getString("chr_cliecodigo"));
				cliente.setPaterno(rs.getString("vch_cliepaterno"));
				cliente.setMaterno(rs.getString("vch_cliematerno"));
				cliente.setNombre(rs.getString("vch_clienombre"));
				cliente.setDni(rs.getString("chr_cliedni"));
				cliente.setCiudad(rs.getString("vch_clieciudad"));
				cliente.setDireccion(rs.getString("vch_cliedireccion"));
				cliente.setTelefono(rs.getString("vch_clietelefono"));
				cliente.setEmail(rs.getString("vch_clieemail"));
			}
			rs.close();
			pstm.close();
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage());
		} catch (Exception e) {
			throw new RuntimeException("Error de acceso a la tabla Cliente.");
		} finally {
			try {
				cn.close();
			} catch (Exception e) {
			}
		}
		return cliente;

	} // Fin de traer

	@Override
	public List<Cliente> traer(String paterno, String materno, String nombre) {
		List<Cliente> lista = new ArrayList<>();
		Connection cn = null;
		paterno = "%" + paterno + "%";
		materno = "%" + materno + "%";
		nombre = "%" + nombre + "%";
		try {
			cn = AccesoDB.getConnection();
			String sql = "select chr_cliecodigo, vch_cliepaterno, vch_cliematerno, "
							+ "vch_clienombre, chr_cliedni, vch_clieciudad, "
							+ "vch_cliedireccion, vch_clietelefono, vch_clieemail "
							+ "from cliente "
							+ "where lower(vch_cliepaterno) like lower(?) "
							+ "and lower(vch_cliematerno) like lower(?) "
							+ "and lower(vch_clienombre) like lower(?) ";
			PreparedStatement pstm = cn.prepareStatement(sql);
			pstm.setString(1, paterno);
			pstm.setString(2, materno);
			pstm.setString(3, nombre);
			ResultSet rs = pstm.executeQuery();
			while (rs.next()) {
				Cliente cliente = new Cliente();
				cliente.setCodigo(rs.getString("chr_cliecodigo"));
				cliente.setPaterno(rs.getString("vch_cliepaterno"));
				cliente.setMaterno(rs.getString("vch_cliematerno"));
				cliente.setNombre(rs.getString("vch_clienombre"));
				cliente.setDni(rs.getString("chr_cliedni"));
				cliente.setCiudad(rs.getString("vch_clieciudad"));
				cliente.setDireccion(rs.getString("vch_cliedireccion"));
				cliente.setTelefono(rs.getString("vch_clietelefono"));
				cliente.setEmail(rs.getString("vch_clieemail"));
				lista.add(cliente);
			}
			rs.close();
			pstm.close();
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage());
		} catch (Exception e) {
			throw new RuntimeException("Error de acceso a la tabla Cliente.");
		} finally {
			try {
				cn.close();
			} catch (Exception e) {
			}
		}
		return lista;

	}

	@Override
	public void inertar(Cliente cliente) {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}

	@Override
	public void actualizar(Cliente cliente) {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}

	@Override
	public void eliminar(String idCliente) {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}

}
