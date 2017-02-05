package inventario;

public interface Modelo {

	public void setVista(Vista vista);

	public void setControlador(Controlador controlador);

	public void iniciarConexion();

	public void checkAutologin();

	public void checkUser(String userLogin, String passwordLogin);

	public void checkUserDisponibility(String user);

	public void focusUsuarioObtained();
	
	public void checkDNIDisponibility(String dni);
	
	public void focusDNIObtained();

	public void checkEmailDisponibility(String email);

	public void focusEmailioObtained();

	public void checkRegisterData(String username, String password,
			String password2, String name, String surname, String email,
			String bornDate);

	public void datosReservaInicio();
	
	//METODOS RESERVA EQUIPO
	
	public void rellenarTablaEq(String pestana);
	
	public void datosBusquedaEquipo(String catPC, String catComp,
			String txtBusq, String pestana);

	public void busquedaEQUIPO(String catPC, String catComp, String txtBusq,
			String pestana);

	public void datosBusquedaUsuario(String txtBusquedaUs,
			String catBusquedaUs, String pestana);

	public void busquedaUSUARIO(String txtBusqUs, String catBusqUs,
			String pestana);

	public void reservar(String idEq, String tipoIdUs, String idUs);

	public void mostrarReservas(String idUsr, String tipoIdUsr, String tipo);
	//METODOS DEVOLUCION EQUIPO
	
	public void realizarDevolucion(String dniUsuario, String tipoId, String idEquipo, String fechaReserva);
	
	// METODOS ALTA EQUIPO
	public void realizarAlta(String procesador, String memoria,
			String discoDuro, int ssd, String grafica, String ssoo,
			String armario, String categoria, String observaciones);

	// METODOS CONFIGURACION INICIO
	public void setDatosConfig();

	public void gestionarFichero();

	public void leerFichero();

	public void escribirFichero(String bd_url, String bd_name, String bd_user,
			String bd_password, Boolean auto_login, String lg_user,
			String lg_password);

	public void copiarFichero();

	// METODOS MODIFICACION EQUIPO

	public void modificarEquipo(String idEquipo, String procesador,
			String memoria, String discoDuro, int ssd, String grafica,
			String ssoo, String armario);

	public void eliminarEquipo(String idEquipo);

	// METODOS MODIFICACION USUARIO

	public void rellenarTablaModifUsuario();

	public void rellenarFormularioMU(String dniUsuario, String nickUsuario,
			String nombreUsuario, String mailUsuario,
			String fnacimientoUsuario, String generoUsuario);

	public void bajaUsuario(String dniBaja);

	public void cambioUsuario(String dniOriginal, String usuarioOriginal, String nombreOriginal, String mailOriginal, 
			String dniForm,String nickForm, String nombreForm, String mailForm, String genero, String fechaNacimiento);

	public void anadirUsuario(String dniForm, String nickForm,
			String nombreForm, String mailForm, String genero,
			String fechaNacimiento);
}
