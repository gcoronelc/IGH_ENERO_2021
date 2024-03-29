package pe.igh.app.service.spec;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author Eric Gustavo Coronel Castillo
 * @blog www.desarrollasoftware.com
 * @email gcoronelc@gmail.com
 * @youtube www.youtube.com/c/DesarrollaSoftware
 * @facebook www.facebook.com/groups/desarrollasoftware/
 */
public interface RowMapper<T> {
	
	T mapRow(ResultSet rs) throws SQLException;

}
