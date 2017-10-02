package com.biosnettcs.dao.impl;

import java.sql.Types;
import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.object.StoredProcedure;
import org.springframework.stereotype.Repository;

import com.biosnettcs.core.dao.HelperJdbcDao;
import com.biosnettcs.core.dao.OracleTypes;
import com.biosnettcs.core.dao.mapper.GenericMapper;
import com.biosnettcs.dao.EventoDAO;

@Repository
public class EventoDAOImpl extends HelperJdbcDao implements EventoDAO {

	//private final static Logger logger = LoggerFactory.getLogger(EventoDAOImpl.class);
	
	@Override
	public String escalaEvento() throws Exception {
		Map<String, Object> params = new HashMap<String, Object>();
		Map<String, Object> mapResult = ejecutaSP(new EscalaEventoSP(getDataSource()), params);
		return (String) mapResult.get("pv_registro_o");
	}
	
	protected class EscalaEventoSP extends StoredProcedure {

		protected EscalaEventoSP(DataSource dataSource) {
			super(dataSource, "PKG_ESTADISTICA.pr_escala_evento");
	        declareParameter(new SqlOutParameter("pv_msg_id_o", Types.NUMERIC));
	        declareParameter(new SqlOutParameter("pv_title_o",  Types.VARCHAR));
			compile();
		}
	}
    
	@Override
	public String obtenerProcesosBackground() throws Exception {
		Map<String, Object> params = new HashMap<String, Object>();
		Map<String, Object> mapResult = ejecutaSP(new ObtenerProcesosBackgroundSP(getDataSource()), params);
		return (String) mapResult.get("pv_registro_o");
	}
	
	protected class ObtenerProcesosBackgroundSP extends StoredProcedure {

		protected ObtenerProcesosBackgroundSP(DataSource dataSource) {
			super(dataSource, "P_GET_TPROCBKG");
            String[] cols=new String[]{
                    "tipo",
                    "nombre"
            };
            declareParameter(new SqlOutParameter("pv_registro_o",OracleTypes.CURSOR, new GenericMapper(cols)));
	        declareParameter(new SqlOutParameter("pv_msg_id_o", Types.NUMERIC));
	        declareParameter(new SqlOutParameter("pv_title_o",  Types.VARCHAR));
			compile();
		}
	}
	
}