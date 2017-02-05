package inventario;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.util.StringTokenizer;

import javax.swing.JOptionPane;

public class ModeloImpl implements Modelo {
	private Vista vista;
	private Controlador controlador;

	private String bd;
	private String url;
	private String urlCorta;
	private String userMySQL;
	private String passwordMySQL;
	private Connection conn;
	// USUARIO
	private String autoLogin;
	private String userLogin;
	private String passwordLogin;
	// Intentos Login
	@SuppressWarnings("unused")
	private Statement stmt;
	private int loginTry = 3;
	// config.ini
	private File config;
	private String rutaFicheroJava = "src/config.ini";
	private String rutaFicheroSystem;

	public ModeloImpl() throws SQLException, ClassNotFoundException {
		super();
		gestionarFichero();
		Class.forName("com.mysql.jdbc.Driver");
		gestionarFichero();
	}

	public void iniciarConexion() {
		try {
			conn = DriverManager.getConnection(url, userMySQL, passwordMySQL);
		} catch (Exception e) {
			JOptionPane
					.showMessageDialog(
							null,
							"Se ha producido un error al conectar con la base de datos.\nPor favor, revise el fichero de configuraci\u00F3n en:\n"
									+ rutaFicheroSystem,
							"Error de Conexi\u00F3n", 0);
			vista.setWindowLoginClose();
		}
	}

	public void checkAutologin() {
		if (autoLogin.equals("true")) {
			vista.autoLogin(true);
			vista.setUserLogin(userLogin);
			checkUser(userLogin, passwordLogin);
		} else {
			vista.autoLogin(false);
		}
	}

	public void setVista(Vista vista) {
		this.vista = vista;
	}

	public void setControlador(Controlador controlador) {
		this.controlador = controlador;
	}

	/**
	 * Cierra la conexion con la base de datos designada.
	 * 
	 * @throws SQLException
	 */
	public void BBDDConnection_OFF() throws SQLException {
		conn.close();
	}

	public void checkUser(String userLogin, String passwordLogin) {
		if (!(userLogin.equals("") || passwordLogin.equals(""))) {
			try {
				PreparedStatement checkUserMySQL = conn
						.prepareStatement("SELECT username, password FROM inventarioprogr.users WHERE username = ? AND password = ?");

				checkUserMySQL.setString(1, userLogin);
				checkUserMySQL.setString(2, passwordLogin);

				ResultSet rSet = checkUserMySQL.executeQuery();

				if (rSet.next()) {
					controlador.changeWindow(2);
				} else {
					loginTry--;
					if (loginTry == 0) {
						vista.setWindowLoginClose();
					} else {
						vista.wrongUserLogin(loginTry);
					}
				}

			} catch (SQLException e) {
				e.printStackTrace();
			}
		} else {
			vista.EmptyField();
		}
	}

	public void addNewUser(String username, String password, String name,
			String dni, String email, String bornDate) {
		try {

			PreparedStatement addUserMySQL = conn
					.prepareStatement("INSERT INTO inventarioprogr.users (username, password, name, dni, email, bornDate) VALUES (?,?,?,?,?,?)");

			addUserMySQL.setString(1, username);
			addUserMySQL.setString(2, password);
			addUserMySQL.setString(3, name);
			addUserMySQL.setString(4, dni);
			addUserMySQL.setString(5, email);
			addUserMySQL.setString(6, bornDate);

			@SuppressWarnings("unused")
			int rSet = addUserMySQL.executeUpdate();

			vista.setWindowRegisterClose();
			vista.setWindowLoginOpen();
			vista.correctRegister();

		} catch (SQLException e) {
			vista.errorRegister();
			e.printStackTrace();
		}
	}

	public void checkUserDisponibility(String username) {
		if (!(username.equals(""))) {
			try {

				PreparedStatement checkUserMySQL = conn
						.prepareStatement("SELECT username FROM inventarioprogr.users WHERE username = ?");

				checkUserMySQL.setString(1, username);

				ResultSet rSet = checkUserMySQL.executeQuery();

				if (rSet.next()) {
					vista.existingUser();
				} else {
					vista.noneExistingUser();
				}

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public void checkDNIDisponibility(String dni) {
		if (!(dni.equals(""))) {
			if (checkDNIFormat(dni)) {
				try {

					PreparedStatement checkUserMySQL = conn
							.prepareStatement("SELECT dni FROM inventarioprogr.users WHERE dni = ?");

					checkUserMySQL.setString(1, dni);

					ResultSet rSet = checkUserMySQL.executeQuery();

					if (rSet.next()) {
						vista.existingDNI();
					} else {
						vista.noneExistingDNI();
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
			} else {
				vista.wrongDNI();
			}
		}
	}

	// <--------------------------------------------------------------#####CHECK_DNI_FORMAT#####-------------------------------------->
	private boolean checkDNIFormat(String dni) {
		boolean estate;

		if (dni.length() == 8) {
			try {
				Integer.parseInt(dni);
				estate = true;
			} catch (NumberFormatException nfe) {
				estate = false;
			}
		} else {
			estate = false;
		}
		return estate;
	}

	public void checkEmailDisponibility(String email) {
		if (!(email.equals(""))) {
			try {

				PreparedStatement checkUserMySQL = conn
						.prepareStatement("SELECT email FROM inventarioprogr.users WHERE email = ?");

				checkUserMySQL.setString(1, email);

				ResultSet rSet = checkUserMySQL.executeQuery();

				if (rSet.next()) {
					vista.existingEmail();
				} else {
					vista.noneExistingEmail();
				}

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public void checkRegisterData(String username, String password,
			String password2, String name, String dni, String email,
			String bornDate) {
		boolean isEmail = false;
		// Comprobamos que las contrasenias sean iguales
		if (!(username.equals("") || password.equals("")
				|| password2.equals("") || name.equals("") || dni.equals("") || email
					.equals(""))) {
			if (password.equals(password2)) {
				// Recorremos el textEmail en busca de la @, para
				// comporbar
				// que sea un email.
				for (int i = 0; i < email.length(); i++) {
					if (email.charAt(i) == '@') {
						isEmail = true;
					}
				}
				if (checkDNIFormat(dni)) {
					// Si es un email seguimos con el proceso de registro.
					if (isEmail) {
						addNewUser(username, password, name, dni, email,
								bornDate);

						// Si NO es un email, mostramos un error.
					} else {
						JOptionPane.showMessageDialog(null,
								"El email introducido no es valido.",
								"¡Email no valido!", 0);

					}
				} else {
					vista.wrongDNI();
				}
				// Si las contrasenias NO coinciden, mostramos un error.
			} else {
				JOptionPane.showMessageDialog(null,
						"Las contrase\u00F1as introducidas no coinciden.",
						"¡Contrase\u00F1as distintas!", 0);
			}
		} else {
			vista.EmptyField();
		}
	}

	//
	// <------------------------------>Eventos_graficos<------------------------------>
	//

	public void focusUsuarioObtained() {
		vista.focusUsuarioObtained();
	}

	public void focusDNIObtained() {
		vista.focusDNIObtained();
	}

	public void focusEmailioObtained() {
		vista.focusEmailioObtained();
	}

	//
	// METODOS INICIO
	//
	public void datosReservaInicio() {

		String query;

		query = "SELECT r.reserve_date fecha_reserva, r.description descripcion, u.username usuario FROM inventarioprogr.reserves r INNER JOIN inventarioprogr.users u ON r.id_user=u.id_user WHERE return_date is NULL";

		try {
			PreparedStatement pstmt = conn.prepareStatement(query);
			ResultSet rset = pstmt.executeQuery();
			int numeroColumna = vista.getNumeroColumnaInicio();
			while (rset.next()) {
				Object[] filaTabla = new Object[numeroColumna];
				filaTabla[0] = rset.getString("fecha_reserva");
				filaTabla[1] = rset.getString("usuario");
				filaTabla[2] = rset.getString("descripcion");
				vista.actualizaTablaInicio(filaTabla);
			}
		} catch (SQLException s) {
			s.printStackTrace();
		}
	}

	//
	// METODOS RESERVA EQUIPO
	//

	public void rellenarTablaEq(String pestana) {
		String query = "SELECT * FROM inventarioprogr.equipments WHERE id_equipment NOT IN "
				+ "(SELECT id_equipment FROM inventarioprogr.reserves WHERE return_date is NULL)";
		try {
			PreparedStatement pstmt = conn.prepareStatement(query);
			ResultSet rset = pstmt.executeQuery();
			int numeroColumnas = vista.getNumColumnTablaReserva();
			while (rset.next()) {
				Object[] filaTabla = new Object[numeroColumnas];
				for (int i = 0; i < numeroColumnas; i++) {
					filaTabla[i] = rset.getString(i + 1);
				}
				if (pestana.equals("pestanaRES")) {
					vista.actualizaTablaReserva(filaTabla);
				} else if (pestana.equals("pestanaMEQ")) {
					vista.actualizaTablaModif(filaTabla);
				}
			}
			rset.close();
			pstmt.close();

			rset.close();
			pstmt.close();
		} catch (SQLException s) {
			s.printStackTrace();
		}
	}

	public void datosBusquedaEquipo(String catPC, String catComp,
			String txtBusq, String pestana) {
		String columna = "";
		switch (catComp) {
		case "Procesador":
			columna = "processor";
			break;
		case "RAM":
			columna = "ram_memory";
			break;
		case "Disco Duro":
			columna = "hard_disk";
			break;
		case "Gráfica":
			columna = "graphic_card";
			break;
		case "SSOO":
			columna = "operative_system";
			break;
		default:
			columna = "Todo";
			break;
		}
		busquedaEQUIPO(catPC, columna, txtBusq, pestana);
		System.out.println(catPC + " " + columna + " " + txtBusq);
	}

	/**
	 * Metodo para buscar un equipo dpendiendo de todas las opciones de
	 * busqueda.
	 */
	public void busquedaEQUIPO(String catPC, String columna, String txtBusq,
			String pestana) {
		String query;
		PreparedStatement pstmt = null;
		if (!catPC.equals("Todo") && !columna.equals("Todo")) {
			/*
			 * Se buscan los equipos que no esten en la tabla reservas con fecha
			 * de devolucion nula, lo que supondria que estan reservados.
			 */
			query = "SELECT * FROM inventarioprogr.equipments EQ "
					+ "INNER JOIN inventarioprogr.categories C ON C.id_category=EQ.category "
					+ "WHERE C.category_name = ? AND EQ."
					+ columna
					+ " LIKE ? "
					+ "AND EQ.id_equipment NOT IN (SELECT id_equipment FROM inventarioprogr.reserves "
					+ "WHERE return_date is NULL)";
			try {
				pstmt = conn.prepareStatement(query);
				pstmt.setString(1, catPC);
				pstmt.setString(2, "%" + txtBusq + "%");
			} catch (SQLException s) {
				s.printStackTrace();
			}
		} else if (catPC.equals("Todo") && !columna.equals("Todo")) {
			query = "SELECT * FROM inventarioprogr.equipments WHERE "
					+ columna
					+ " LIKE ? "
					+ "AND id_equipment NOT IN (SELECT id_equipment FROM inventarioprogr.reserves "
					+ "WHERE return_date is NULL)";
			try {
				pstmt = conn.prepareStatement(query);
				pstmt.setString(1, "%" + txtBusq + "%");
			} catch (SQLException s) {
				s.printStackTrace();
			}

		} else if (catPC.equals("Todo") && columna.equals("Todo")) {
			// Se busca el equipo que contenga en cualquier campo el string
			// introducido en el cuadro de busqueda.
			query = "SELECT * FROM inventarioprogr.equipments "
					+ "WHERE (processor LIKE ? OR ram_memory LIKE ? OR hard_disk LIKE ? OR graphic_card LIKE ? OR operative_system LIKE ?) "
					+ "AND id_equipment NOT IN (SELECT id_equipment FROM inventarioprogr.reserves "
					+ "WHERE return_date is NULL)";
			try {
				pstmt = conn.prepareStatement(query);
				String patron = "%" + txtBusq + "%";
				pstmt.setString(1, patron);
				pstmt.setString(2, patron);
				pstmt.setString(3, patron);
				pstmt.setString(4, patron);
				pstmt.setString(5, patron);
			} catch (SQLException s) {
				s.printStackTrace();
			}
		} else {
			query = "SELECT * FROM inventarioprogr.equipments EQ "
					+ "INNER JOIN inventarioprogr.categories C ON C.id_category=EQ.category "
					+ "WHERE C.category_name = ? "
					+ "AND (EQ.processor LIKE ? OR EQ.ram_memory LIKE ? OR EQ.hard_disk LIKE ? "
					+ "OR EQ.graphic_card LIKE ? OR EQ.operative_system LIKE ?) "
					+ "AND id_equipment NOT IN (SELECT id_equipment FROM inventarioprogr.reserves "
					+ "WHERE return_date is NULL)";
			try {
				pstmt = conn.prepareStatement(query);
				String patron = "%" + txtBusq + "%";
				pstmt.setString(1, catPC);
				pstmt.setString(2, patron);
				pstmt.setString(3, patron);
				pstmt.setString(4, patron);
				pstmt.setString(5, patron);
				pstmt.setString(6, patron);
			} catch (SQLException s) {
				s.printStackTrace();
			}
		}
		int numeroColumnas = vista.getNumColumnTablaReserva();
		try {
			ResultSet rset = pstmt.executeQuery();
			Object[] filaTabla = null;
			while (rset.next()) {
				filaTabla = new Object[numeroColumnas];
				for (int i = 0; i < numeroColumnas; i++) {
					filaTabla[i] = rset.getString(i + 1);
				}
				if (pestana.equals("pestanaRES")) {
					vista.actualizaTablaReserva(filaTabla);
				} else if (pestana.equals("pestanaMOD")) {
					vista.actualizaTablaModif(filaTabla);
				}
			}
			if(filaTabla == null){
				controlador.errorBusqueda();
			}
			rset.close();
			pstmt.close();
		} catch (SQLException s) {
			s.printStackTrace();
		}
	}

	/**
	 * Metodo que recibe los datos de la busqueda del usuario.
	 */
	public void datosBusquedaUsuario(String txtBusquedaUs,
			String catBusquedaUs, String pestana) {
		busquedaUSUARIO(txtBusquedaUs, catBusquedaUs, pestana);
	}

	/**
	 * Metodo para buscar un usuario en la BBDD. Se entra con el parametro de la
	 * pestaña donde este el buscador para no repetir metodos parecidos.
	 */
	public void busquedaUSUARIO(String txtBusqUs, String catBusqUs,
			String pestana) {

		String query;
		PreparedStatement pstmt;
		ResultSet rset;
		try {
			if (catBusqUs.equalsIgnoreCase("nombre")) {
				query = "SELECT * FROM inventarioprogr.users WHERE name LIKE ?";
				pstmt = conn.prepareStatement(query);
				pstmt.setString(1, txtBusqUs);
				rset = pstmt.executeQuery();
			} else {
				query = "SELECT * FROM inventarioprogr.users WHERE "
						+ catBusqUs + " = ?";
				pstmt = conn.prepareStatement(query);
				pstmt.setString(1, txtBusqUs);
				rset = pstmt.executeQuery();
			}
			if (rset.next()) {
				if (pestana.equals("pestanaRES")) {
					vista.rellenaCampoUsuarioRes(rset.getString("name"));
				} else if (pestana.equals("pestanaDEVOL")) {
					vista.rellenaCampoUsuarioDevol(rset.getString("name"));
				} else if (pestana.equals("pestanaMODU")) {
					String dniUsuario = rset.getString("dni");
					String nickUsuario = rset.getString("username");
					String nombreUsuario = rset.getString("name");
					String mailUsuario = rset.getString("email");
					String generoUsuario = rset.getString("gender");
					String fnacimientoUsuario = rset.getString("borndate");
					rellenarFormularioMU(dniUsuario, nickUsuario,
							nombreUsuario, mailUsuario, fnacimientoUsuario,
							generoUsuario);
				}
			} else {
				vista.borrarTexto(pestana);
				controlador.errorBusqueda();
			}
			rset.close();
			pstmt.close();
		} catch (SQLException s) {
			s.printStackTrace();
		}
	}

	/**
	 * Metodo que inserta los datos de la reserva en la BBDD.
	 */
	public void reservar(String idEq, String tipoIdUs, String idUs) {
		int ins = 0;
		String idUsuario = "";
		String descripEquipo = "";
		String queryUser = "SELECT id_user FROM inventarioprogr.users WHERE "
				+ tipoIdUs + " = ?";
		String queryEquip = "SELECT CONCAT(processor,'/ RAM ',ram_memory,'/ HDD ',hard_disk) AS descripcion "
				+ "FROM inventarioprogr.equipments WHERE id_equipment = ?";
		try {
			PreparedStatement pstmt = conn.prepareStatement(queryUser);
			pstmt.setString(1, idUs);
			ResultSet rset = pstmt.executeQuery();
			if (rset.next()) {
				idUsuario = rset.getString("id_user");
				pstmt.close();
				rset.close();
				pstmt = conn.prepareStatement(queryEquip);
				pstmt.setString(1, idEq);
				rset = pstmt.executeQuery();
				if (rset.next()) {
					descripEquipo = rset.getString("descripcion");
				}
				pstmt.close();
				rset.close();
				String insertRegistro = "INSERT INTO inventarioprogr.reserves (id_user,id_equipment,reserve_date,description) VALUES(?,?,CURDATE(),?)";
				PreparedStatement pstmt_2 = conn
						.prepareStatement(insertRegistro);
				pstmt_2.setString(1, idUsuario);
				pstmt_2.setString(2, idEq);
				pstmt_2.setString(3, descripEquipo);
				ins = pstmt_2.executeUpdate();
				if (ins > 0) {
					controlador.avisarReserva();
				}
				pstmt_2.close();
			} else {
				controlador.errorReserva();
			}
		} catch (SQLException s) {
			s.printStackTrace();
		}
	}

	//
	// METODOS DEVOLUCION
	//

	/**
	 * Metodo para mostrar las reservas en la tabla de inventario.
	 */
	public void mostrarReservas(String idUsr, String tipoIdUsr, String tipo) {
		String query = null;
		switch (tipo) {
		case "Reservas Pendientes":
			query = "SELECT * FROM inventarioprogr.reserves R INNER JOIN inventarioprogr.users U "
					+ "ON R.id_user = U.id_user WHERE "
					+ tipoIdUsr
					+ " = ? AND return_date IS NULL";
			break;
		case "Devoluciones":
			query = "SELECT * FROM inventarioprogr.reserves R INNER JOIN inventarioprogr.users U "
					+ "ON R.id_user = U.id_user WHERE "
					+ tipoIdUsr
					+ " = ? AND return_date IS NOT NULL";
			break;
		case "Todo":
			query = "SELECT * FROM inventarioprogr.reserves R INNER JOIN inventarioprogr.users U "
					+ "ON R.id_user = U.id_user WHERE " + tipoIdUsr + " = ?";
		default:
			break;
		}
		try {
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setString(1, idUsr);
			ResultSet rset = pstmt.executeQuery();
			int numeroColumnas = vista.getNumColumnasTablaDEVOL();
			while (rset.next()) {
				Object[] filaTabla = new Object[numeroColumnas];
				filaTabla[0] = rset.getString("id_equipment");
				filaTabla[1] = rset.getString("description");
				filaTabla[2] = rset.getString("reserve_date");
				if (rset.getString("observations") == null) {
					filaTabla[3] = "Pendiente";
				} else {
					filaTabla[3] = rset.getString("observations");
				}
				vista.actualizaTablaDevol(filaTabla);
			}
			rset.close();
			pstmt.close();
		} catch (SQLException s) {
			s.printStackTrace();
		}
	}

	public void realizarDevolucion(String dniUsuario, String tipoId,
			String idEquipo, String fechaReserva) {
		String query = "";
		String idReserva = "";
		String detallePlazo = calculaPlazo(fechaReserva);

		query = "SELECT id_reserve FROM inventarioprogr.reserves  WHERE id_equipment = ? AND reserve_date = ? "
				+ "AND id_user = (SELECT id_user FROM inventarioprogr.users WHERE "
				+ tipoId + " = ?) AND return_date IS NULL";
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, idEquipo);
			pstmt.setString(2, fechaReserva);
			pstmt.setString(3, dniUsuario);
			rset = pstmt.executeQuery();
			if (rset.next()) {
				idReserva = rset.getString("id_reserve");
				System.out.println(idReserva);

				rset.close();
				pstmt.close();
				query = "UPDATE inventarioprogr.reserves SET return_date = curdate(), observations = ? WHERE id_reserve = ?";
				pstmt = conn.prepareStatement(query);
				pstmt.setString(1, detallePlazo);
				pstmt.setString(2, idReserva);
				int updt = pstmt.executeUpdate();
				if (updt > 0) {
					controlador.avisarConfirmacionDevol(
							"La devolución se ha realizado con exito",
							" Devolucion realizada");
				} else {
					controlador
							.avisarErrorDevol(
									"Ha habido un fallo en la devolución. Compruebe los datos.",
									"Fallo en la devolución");
				}
				pstmt.close();
			} else {
				controlador.avisarErrorDevol(
						"No ha seleccionado una reserva valida.",
						"Fallo en la devolución");
			}
		} catch (SQLException s) {
			s.printStackTrace();
		}
	}

	private String calculaPlazo(String fecha) {
		System.out.println("la fecha de reserva es: " + fecha);
		String plazo = "";
		String mensaje = "";
		String query = "SELECT DATEDIFF(CURDATE(), ?) AS dias";
		try {
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setString(1, fecha);
			ResultSet rset = pstmt.executeQuery();
			if (rset.next()) {
				plazo = rset.getString("dias");
			}
			rset.close();
			pstmt.close();
		} catch (SQLException s) {
			s.printStackTrace();
		}
		int numeroDias = Integer.parseInt(plazo);
		if (numeroDias < 3) {
			mensaje = "Devuelto - En plazo";
		} else if (numeroDias > 3 && numeroDias <= 5) {
			mensaje = "Devuelto - Con retraso";
		} else {
			mensaje = "Devuelto - Con penalización";
		}

		return mensaje;
	}

	//
	// METODOS ALTA EQUIPO
	//
	/**
	 * Metodo para dar de alta un equipo en la BBDD.
	 */
	public void realizarAlta(String procesador, String memoria,
			String discoDuro, int ssd, String grafica, String ssoo,
			String armario, String categoria, String observaciones) {

		if (procesador.replace(" ", "").length() > 0
				&& memoria.replace(" ", "").length() > 0
				&& discoDuro.replace(" ", "").length() > 0
				&& grafica.replace(" ", "").length() > 0
				&& ssoo.replace(" ", "").length() > 0
				&& armario.replace(" ", "").length() > 0
				&& categoria.replace(" ", "").length() > 0
				&& observaciones.replace(" ", "").length() > 0) {

			PreparedStatement pstmt;
			ResultSet rset;
			PreparedStatement pstmt_2;
			int numCategoria = 0;
			int numArmario = 0;
			int ins;
			String queryCategoria = "SELECT id_category FROM inventarioprogr.categories WHERE category_name = ?";
			String queryNumArmario = "SELECT id_storage FROM inventarioprogr.storages WHERE name =?";
			try {
				// Se coge la id de la categoria segun el parametro del
				// comboBox.
				pstmt = conn.prepareStatement(queryCategoria);
				pstmt.setString(1, categoria);
				rset = pstmt.executeQuery();
				if (rset.next()) {
					numCategoria = rset.getInt("id_category");
				}
				pstmt.close();
				rset.close();
				// Se coge la id del numero de armario segun el parametro del
				// comboBox.
				pstmt = conn.prepareStatement(queryNumArmario);
				pstmt.setString(1, armario);
				rset = pstmt.executeQuery();
				if (rset.next()) {
					numArmario = rset.getInt("id_storage");
				}
				pstmt.close();
				rset.close();
				// Realizamos el Insert con preparedstatement.
				String insertRegistro = "INSERT INTO inventarioprogr.equipments (processor,ram_memory,hard_disk,ssd,graphic_card,"
						+ "operative_system,category,storage_number,observations) "
						+ "VALUES(?,?,?,?,?,?,'"
						+ numCategoria
						+ "','"
						+ numArmario + "',?)";
				pstmt_2 = conn.prepareStatement(insertRegistro);
				// Se asigna el valor a los parametros de la query.
				pstmt_2.setString(1, procesador);
				pstmt_2.setString(2, memoria);
				pstmt_2.setString(3, discoDuro);
				pstmt_2.setInt(4, ssd);
				pstmt_2.setString(5, grafica);
				pstmt_2.setString(6, ssoo);
				pstmt_2.setString(7, observaciones);
				ins = pstmt_2.executeUpdate();
				// Si se ejecuta el insert se lanza un mensaje de confirmacion.
				if (ins > 0) {
					controlador.avisarConfirmacionDevol(
							"El equipo se ha guardado", "Alta realida");
					vista.limpiarCamposFormularioAlta();
				} else {
					controlador.avisarErrorDevol(
							"Ha habido un error en el alta del equipo",
							"Fallo en el alta");
				}
				pstmt_2.close();
			} catch (SQLException s) {
				s.printStackTrace();
			}
		} else {
			// Si alguno de los campos esta vacio se informa a la vista para que
			// informe al usuario.
			controlador.informarCampoVacio();
		}
	}

	//
	// METODOS MODIFICAR EQUIPO
	//
	public void modificarEquipo(String idEquipo, String procesador,
			String memoria, String discoDuro, int ssd, String grafica,
			String ssoo, String armario) {

		PreparedStatement pstmt = null;
		ResultSet rset = null;
		int numArmario = 0;

		if (procesador.replace(" ", "").length() > 0
				&& memoria.replace(" ", "").length() > 0
				&& discoDuro.replace(" ", "").length() > 0
				&& grafica.replace(" ", "").length() > 0
				&& ssoo.replace(" ", "").length() > 0
				&& armario.replace(" ", "").length() > 0) {

			String queryNumArmario = "SELECT id_storage FROM inventarioprogr.storages WHERE name =?";
			try {
				// Se coge la id del numero de armario segun el parametro del
				// comboBox.
				pstmt = conn.prepareStatement(queryNumArmario);
				pstmt.setString(1, armario);
				rset = pstmt.executeQuery();
				if (rset.next()) {
					numArmario = rset.getInt("id_storage");
				}
				pstmt.close();
				rset.close();
			} catch (SQLException s) {
				s.printStackTrace();
			}

			int insert;
			String query = "UPDATE inventarioprogr.equipments SET processor = ?, ram_memory = ?, "
					+ "hard_disk = ?, ssd = ?, graphic_card = ?, operative_system = ?, storage_number = ? "
					+ "WHERE id_equipment = ?";
			try {
				pstmt = conn.prepareStatement(query);
				pstmt.setString(1, procesador);
				pstmt.setString(2, memoria);
				pstmt.setString(3, discoDuro);
				pstmt.setInt(4, ssd);
				pstmt.setString(5, grafica);
				pstmt.setString(6, ssoo);
				pstmt.setInt(7, numArmario);
				pstmt.setString(8, idEquipo);
				insert = pstmt.executeUpdate();
				if (insert > 0) {
					controlador.avisarActualizacion();
					vista.limpiarCamposMEQ();
				} else {
					controlador.avisarErrorDevol(
							"Ha habido un error en la actualizacion",
							"Fallo al actualizar");
				}
				pstmt.close();
			} catch (SQLException s) {
				s.printStackTrace();
			}
		}
		else{
			controlador.avisarErrorDevol("Los campos no pueden estar vacios.", "Campos vacios");
		}
	}

	public void eliminarEquipo(String idEquipo) {
		String query = "DELETE FROM inventarioprogr.equipments WHERE id_equipment = ?";
		int idEq = Integer.parseInt(idEquipo);
		try {
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, idEq);
			int regBorrados = pstmt.executeUpdate();
			if (regBorrados > 0) {
				controlador.avisarEquipoEliminado();
			}
			pstmt.close();
		} catch (SQLException s) {
			s.printStackTrace();
		}

	}

	//
	// METODOS MODIFICACION USUARIO
	//
	String query = "SELECT * FROM inventarioprogr.users";

	public void rellenarTablaModifUsuario() {
		try {
			PreparedStatement pstmt = conn.prepareStatement(query);
			ResultSet rset = pstmt.executeQuery();
			int numeroColumnas = vista.getNumColumnasTablaMU();
			while (rset.next()) {
				Object[] filaTabla = new Object[numeroColumnas];
				filaTabla[0] = rset.getString("dni");
				filaTabla[1] = rset.getString("username");
				filaTabla[2] = rset.getString("name");
				filaTabla[3] = rset.getString("email");
				filaTabla[4] = rset.getString("borndate");
				filaTabla[5] = rset.getString("gender");
				vista.actualizaTablaMU(filaTabla);
			}
			rset.close();
			pstmt.close();
		} catch (SQLException s) {
			s.printStackTrace();
		}
	}

	public void rellenarFormularioMU(String dniUsuario, String nickUsuario,
			String nombreUsuario, String mailUsuario,
			String fnacimientoUsuario, String generoUsuario) {

		StringTokenizer str = new StringTokenizer(fnacimientoUsuario, "-");
		String dia = str.nextToken();
		String mes = str.nextToken();
		String anio = str.nextToken();
		vista.actualizaFormularioMU(dniUsuario, nickUsuario, nombreUsuario,
				mailUsuario, generoUsuario, dia, mes, anio);
	}

	public void bajaUsuario(String dniBaja) {
		String query = "DELETE FROM inventarioprogr.users WHERE dni = ?";
		try {
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setString(1, dniBaja);
			int regBorrados = pstmt.executeUpdate();
			if (regBorrados > 0) {
				controlador
						.avisarCambioUsuario("El Usuario se ha eliminado de la base de datos.");
			} else {
				controlador
						.avisarErrorCambioUsuario("No se ha seleccionado ningun Usuario.");
			}
			pstmt.close();
		} catch (SQLException s) {
			s.printStackTrace();
		}
	}

	public void cambioUsuario(String dniOriginal, String usuarioOriginal,
			String nombreOriginal, String mailOriginal, String dniForm,
			String nickForm, String nombreForm, String mailForm, String genero,
			String fechaNacimiento) {

		if (checkDNIFormat(dniForm) && nickForm.replace(" ","").length() > 0 && nombreForm.replace(" ","").length() > 0 
			&& mailForm.replace(" ","").length() > 0) {
			String query;
			PreparedStatement pstmt = null;
			ResultSet rset = null;
			/*
			 * Hacemos una select para comprobar que los datos de la tabla que
			 * deben ser únicos no aparezcan en los campos modificados
			 * introducidos en el formulario.
			 */
			query = "SELECT * FROM inventarioprogr.users WHERE (dni = ? OR username = ? OR email = ?) AND id_user <>("
					+ "SELECT id_user FROM inventarioprogr.users WHERE dni = ? AND username= ? AND email = ?)";
			try {
				pstmt = conn.prepareStatement(query);
				pstmt.setString(1, dniForm);
				pstmt.setString(2, nickForm);
				pstmt.setString(3, mailForm);
				pstmt.setString(4, dniOriginal);
				pstmt.setString(5, usuarioOriginal);
				pstmt.setString(6, mailOriginal);
				rset = pstmt.executeQuery();
				if (!rset.next()) {
					pstmt.close();
					rset.close();
					query = "UPDATE inventarioprogr.users SET dni = ?, username = ?, password = ?, name = ?, email = ?, gender = ?, borndate = ? "
							+ "WHERE dni = ?";
					pstmt = conn.prepareStatement(query);
					pstmt.setString(1, dniForm);
					pstmt.setString(2, nickForm);
					pstmt.setString(3, nickForm);
					pstmt.setString(4, nombreForm);
					pstmt.setString(5, mailForm);
					pstmt.setString(6, genero);
					pstmt.setString(7, fechaNacimiento);
					pstmt.setString(8, dniOriginal);
					int regActualizados = pstmt.executeUpdate();
					if (regActualizados > 0) {
						controlador
								.avisarCambioUsuario("Se han modificado los datos del usuario.");
						vista.limpiarCamposFormularioDevol();
					} else {
						controlador
								.avisarErrorCambioUsuario("No se ha seleccionado ningun Usuario.");
					}
					pstmt.close();
				} else {
					controlador.identificadorDuplicado();
				}
			} catch (SQLException s) {
				s.printStackTrace();
			}
		} else {
			JOptionPane.showMessageDialog(null,
					"DNI no valido. (DNI: XXXXXXXX (8 números)) o campos vacios.", "¡Campos no validos!", 2);
		}

	}

	public void anadirUsuario(String dniForm, String nickForm,
			String nombreForm, String mailForm, String genero,
			String fechaNacimiento) {
		
		if (checkDNIFormat(dniForm)  && nickForm.replace(" ","").length() > 0 && nombreForm.replace(" ","").length() > 0 
				&& mailForm.replace(" ","").length() > 0) {
			String query;
			PreparedStatement pstmt = null;
			ResultSet rset = null;
			query = "SELECT * FROM inventarioprogr.users WHERE dni = ? OR username = ? OR email = ?";
			try {
				pstmt = conn.prepareStatement(query);
				pstmt.setString(1, dniForm);
				pstmt.setString(2, nickForm);
				pstmt.setString(3, mailForm);
				rset = pstmt.executeQuery();
				if (!rset.next()) {
					pstmt.close();
					rset.close();
					query = "INSERT INTO inventarioprogr.users (dni,username,password,name,email,gender,borndate) "
							+ "VALUES(?,?,?,?,?,?,?)";

					pstmt = conn.prepareStatement(query);
					pstmt.setString(1, dniForm);
					pstmt.setString(2, nickForm);
					pstmt.setString(3, nickForm);
					pstmt.setString(4, nombreForm);
					pstmt.setString(5, mailForm);
					pstmt.setString(6, genero);
					pstmt.setString(7, fechaNacimiento);

					int nuevoRegistro = pstmt.executeUpdate();
					if (nuevoRegistro > 0) {
						controlador
								.avisarCambioUsuario("El usuario se ha añadido a la base de datos.");
					} else {
						controlador
								.avisarErrorCambioUsuario("No se ha seleccionado ningun Usuario.");
					}
					pstmt.close();
				} else {
					controlador.identificadorDuplicado();
				}
			} catch (SQLException s) {
				s.printStackTrace();
			}
		} else {
			JOptionPane.showMessageDialog(null,
					"DNI no valido. (DNI: XXXXXXXX (8 números)) o campos vacios.", "¡Campos no validos!", 2);
		}
	}

	//
	// METODOS CONFIGURACION INICIO
	//
	public void setDatosConfig() {
		vista.mostrarConfiguracion(urlCorta, bd, userMySQL, passwordMySQL,
				userLogin, passwordLogin);
	}

	public void gestionarFichero() {
		// Preguntamos al sistema por la ruta de la carpeta del usuario.
		rutaFicheroSystem = System.getProperty("user.home");
		// Nos vamos a AppData -> Local y buscamos la carpeta Inventario.
		File inventarioDirectory = new File(rutaFicheroSystem
				+ "\\AppData\\Local\\Inventario");
		// Si no existe la creamos.
		inventarioDirectory.mkdir();
		// Establecemos la ruta final del fichero;
		rutaFicheroSystem += "\\AppData\\Local\\Inventario\\config.ini";
		//
		//
		//

		config = new File(rutaFicheroSystem);
		if (config.exists()) {
			leerFichero();
		} else {
			copiarFichero();
			leerFichero();
		}
	}

	public void leerFichero() {
		Properties propiedades = new Properties();
		InputStream entrada;
		try {
			entrada = new FileInputStream(config);

			try {
				propiedades.load(entrada);
			} catch (IOException e) {
				e.printStackTrace();
			}

			if (propiedades.getProperty("BBDD_NAME") != null
					&& propiedades.getProperty("BBDD_URL") != null
					&& propiedades.getProperty("BBDD_USER") != null
					&& propiedades.getProperty("BBDD_PASSWORD") != null
					&& propiedades.getProperty("AUTO_LOGIN") != null
					&& propiedades.getProperty("LOGIN_USER") != null
					&& propiedades.getProperty("LOGIN_PASSWORD") != null) {

				this.bd = propiedades.getProperty("BBDD_NAME");
				this.urlCorta = propiedades.getProperty("BBDD_URL");
				this.url = "jdbc:mysql://"
						+ propiedades.getProperty("BBDD_URL") + "/" + bd;
				this.userMySQL = propiedades.getProperty("BBDD_USER");
				this.passwordMySQL = propiedades.getProperty("BBDD_PASSWORD");
				this.autoLogin = propiedades.getProperty("AUTO_LOGIN");
				this.userLogin = propiedades.getProperty("LOGIN_USER");
				this.passwordLogin = propiedades.getProperty("LOGIN_PASSWORD");
			} else {
				copiarFichero();

				this.bd = propiedades.getProperty("BBDD_NAME");
				this.urlCorta = propiedades.getProperty("BBDD_URL");
				this.url = "jdbc:mysql://"
						+ propiedades.getProperty("BBDD_URL") + "/" + bd;
				this.userMySQL = propiedades.getProperty("BBDD_USER");
				this.passwordMySQL = propiedades.getProperty("BBDD_PASSWORD");
				this.autoLogin = propiedades.getProperty("AUTO_LOGIN");
				this.userLogin = propiedades.getProperty("LOGIN_USER");
				this.passwordLogin = propiedades.getProperty("LOGIN_PASSWORD");
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	public void escribirFichero(String bd_url, String bd_name, String bd_user,
			String bd_password, Boolean auto_login, String lg_user,
			String lg_password) {
		Properties propiedades = new Properties();
		FileOutputStream salida;
		try {
			salida = new FileOutputStream(config);

			propiedades.setProperty("BBDD_URL", bd_url);
			propiedades.setProperty("BBDD_NAME", bd_name);
			propiedades.setProperty("BBDD_USER", bd_user);
			propiedades.setProperty("BBDD_PASSWORD", bd_password);
			propiedades.setProperty("AUTO_LOGIN", auto_login.toString());
			propiedades.setProperty("LOGIN_USER", lg_user);
			propiedades.setProperty("LOGIN_PASSWORD", lg_password);
			vista.autoLogin(auto_login);

			try {
				propiedades.store(salida, "");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	public void copiarFichero() {
		try {
			FileInputStream fi = new FileInputStream(rutaFicheroJava);
			BufferedInputStream bi = new BufferedInputStream(fi);

			FileOutputStream fo = new FileOutputStream(rutaFicheroSystem);
			BufferedOutputStream bo = new BufferedOutputStream(fo);

			byte[] arr = new byte[1000];
			int leidos = bi.read(arr);
			while (leidos > 0) {
				bo.write(arr, 0, leidos);
				leidos = bi.read(arr);
			}
			bi.close();
			bo.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
