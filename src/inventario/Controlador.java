package inventario;

public interface Controlador {
	
	public void setModelo(Modelo modelo);

	public void setVista(Vista vista);

	public void checkUserLogin();

	public void changeWindow(int type);
	
	public void checkUserDisponibility();
	
	public void focusUsuarioObtained();
	
	public void checkDNIDisponibility();
	
	public void focusDNIObtained();
	
	public void checkEmailDisponibility();
	
	public void focusEmailioObtained();
	
	public void checkRegisterData();
	
	//METODOS RESERVA EQUIPO
	
	public void solicitaRellenarTablaEq(String pestana);
	
	public void buscarEQUIPO(String pestana);
	
	public void buscarUSUARIORes(String pestana);
	
	public void errorBusqueda();
	
	public void confirmarReserva();
	
	public void avisarReserva();
	
	public void errorReserva();
		
	public void buscarUSUARIODevol(String pestana);
	
	public void mostrarReserv(String tipoReserv);
	
	//METODO CONFIGURACION INICIO
	
	public void getConfiguracion(String bd_url, String bd_name, String bd_user,
			String bd_password, Boolean auto_login, String lg_user, String lg_password);
	
	//METODOS ALTA EQUIPO
	
	public void recibirDatosEquipo(String procesador, String memoria, String discoDuro, int ssd, 
			String grafica, String ssoo, String armario, String categoria, String observaciones);
	
	public void informarCampoVacio();
	
	//METODOS DEVOLUCION
	
	public void solicitarDevolucion();
	
	public void avisarConfirmacionDevol(String mensaje, String tituloVentana);
	
	public void avisarErrorDevol(String mensaje, String tituloVentana);
	
	//METODOS MODIFICACION EQUIPO
	
	public void recibirDatosEquipoModif(String idEquipo, String procesador, String memoria, String discoDuro, int ssd, 
			String grafica, String ssoo, String armario);
	
	public void eliminarEquipoConfirm();
	
	public void avisarActualizacion();
	
	public void avisarEquipoEliminado();
	
	//METODOS MODIFIACION USUARIO
	
	public void solicitaRellenarTablaMU();
	
	public void buscarUSUARIOModif(String pestana);
	
	public void tablaAFormularioMU(String dniUsuario, String nickUsuario, String nombreUsuario, String mailUsuario, String fnacimientoUsuario, String generoUsuario);
	
	public void eliminarUsuario(String dniForm);
	
	public void modificarUsuario(String dniOriginal, String usuarioOriginal, String nombreOriginal, String mailOriginal, String dniForm, 
			String nickForm, String nombreForm, String mailForm, String sexoForm, String diaForm, String mesForm, String anioForm);
	
	public void crearUsuario(String dniForm,String nickForm, String nombreForm, String mailForm, 
							String sexoForm, String diaForm, String mesForm, String anioForm);
	
	public void avisarCambioUsuario(String mensaje);
	
	public void avisarErrorCambioUsuario(String mensaje);
	
	public void identificadorDuplicado();
}
