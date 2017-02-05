package inventario;

public class ControladorImpl implements Controlador {
	private Modelo modelo;
	private Vista vista;

	public ControladorImpl() {
		super();
	}

	public void setModelo(Modelo modelo) {
		this.modelo = modelo;
	}

	public void setVista(Vista vista) {
		this.vista = vista;
	}

	public void checkUserLogin() {
		modelo.checkUser(vista.getUserLogin().toString(), vista
				.getPasswordLogin().toString());
	}

	//
	// <------------------------------>Eventos_graficos<------------------------------>
	//
	public void changeWindow(int type) {
		switch (type) {
		case 0: {
			vista.setWindowRegisterClose();
			vista.setWindowLoginOpen();
			break;
		}
		case 1: {
			vista.setWindowLoginClose();
			vista.setWindowRegisterOpen();
			break;
		}
		case 2: {
			vista.setWindowLoginClose();
			vista.setWindowInventarioOpen();
			break;
		}
		case 3: {
			vista.setWindowInventarioClose();
			vista.setWindowLoginOpen();
			break;
		}
		case 4: {
			vista.setWindowConfigOpen();
			modelo.gestionarFichero();
			modelo.setDatosConfig();
			break;
		}
		case 5: {
			vista.setWindowConfigClose();
			break;
		}
		}
	}
	//
	//METODOS CONFIGURACION INICIO
	//
	public void getConfiguracion(String bd_url, String bd_name, String bd_user,
			String bd_password, Boolean auto_login, String lg_user,
			String lg_password) {
		modelo.escribirFichero(bd_url, bd_name, bd_user, bd_password,
				auto_login, lg_user, lg_password);
		vista.setWindowConfigClose();
	}
	
	public void checkUserDisponibility() {		
		modelo.checkUserDisponibility(vista.getRegisterDataUser());
	}
	
	public void focusUsuarioObtained(){
		modelo.focusUsuarioObtained();
	}
	
	public void checkDNIDisponibility() {		
		modelo.checkDNIDisponibility(vista.getRegisterDataDNI());
	}
	
	public void focusDNIObtained(){
		modelo.focusDNIObtained();
	}
	
	public void focusEmailioObtained(){
		modelo.focusEmailioObtained();
	}
	
	public void checkEmailDisponibility() {		
		modelo.checkEmailDisponibility(vista.getRegisterDataEmail());
	}

	public void checkRegisterData() {
		modelo.checkRegisterData(vista.getRegisterDataUser(),
				vista.getRegisterDataPassword(),
				vista.getRegisterDataPassword2(), vista.getRegisterDataName(),
				vista.getRegisterDataDNI(), vista.getRegisterDataEmail(),
				vista.getBornDate());
	}
	//
	//METODOS RESERVA EQUIPO
	//
	
	public void solicitaRellenarTablaEq(String pestana){
		modelo.rellenarTablaEq(pestana);
	}
	
	public void buscarEQUIPO(String pestana){
		String catPC = "";
		String catComp = "";
		String txtBusq = "";
		if(pestana.equals("pestanaRES")){
			catPC = vista.getCategoriaPC();
			catComp = vista.getCategoriaComp();
			txtBusq = vista.getTextoBusqueda();
		}
		else if(pestana.equals("pestanaMOD")){
			catPC = vista.getCategoriaPCModif();
			catComp = vista.getCategoriaCompModif();
			txtBusq = vista.getTextoBusquedaModif();
		}
		modelo.datosBusquedaEquipo(catPC, catComp, txtBusq, pestana);
	}
	
	public void buscarUSUARIORes(String pestana){
		String txtBusq_DNI_MAIL = vista.getTxtUSUARIOReserva();
		String catBusquedaUsuario = vista.getCatUSUARIOReserva();
		modelo.datosBusquedaUsuario(txtBusq_DNI_MAIL, catBusquedaUsuario, pestana);
	}
	
	public void errorBusqueda(){
		vista.mensErrorBusq();
	}
	
	public void confirmarReserva(){
		String idEquipo = vista.getIDEquipoRE();
		String tipoIdUsuario = vista.getCatUSUARIOReserva();
		String idUsuario = vista.getTxtUSUARIOReserva();
		modelo.reservar(idEquipo,tipoIdUsuario,idUsuario);
	}
	
	public void avisarReserva(){
		vista.mensConfirmReserva();
	}
	
	public void errorReserva(){
		vista.mensFalloReserva();
	}
	//
	//METODOS DEVOLUCION EQUIPO
	//
	
	public void buscarUSUARIODevol(String pestana){
		String txtUSUARIODevol = vista.getTxtUSUARIODevol();
		String catUSUARIODevol = vista.getCatUSUARIODevol();
		modelo.datosBusquedaUsuario(txtUSUARIODevol, catUSUARIODevol, pestana);
	}
	
	public void mostrarReserv(String tipoReserv){
		String idUsuario = vista.getTxtUSUARIODevol();
		String tipoIdUsuario = vista.getCatUSUARIODevol();
		modelo.mostrarReservas(idUsuario,tipoIdUsuario,tipoReserv);
	}
	
	public void solicitarDevolucion(){
		String dniUsuario = vista.getDniUsuarioDevol();
		String tipoIdUsuario = vista.getTipoIdDevol();
		String idEquipo = vista.getIdEquipoDevol();
		String fechaReserva = vista.getFechaReservaDevol();
		modelo.realizarDevolucion(dniUsuario, tipoIdUsuario, idEquipo, fechaReserva);
	}
	
	public void avisarConfirmacionDevol(String mensaje, String tituloVentana){
		vista.mensajeConfirmacionDevol(mensaje, tituloVentana);
	}
	
	public void avisarErrorDevol(String mensaje, String tituloVentana){
		vista.mensajeErrorDevol(mensaje,tituloVentana);
	}
	
	//
	//METODOS ALTA EQUIPO
	//
	public void recibirDatosEquipo(String procesador, String memoria, String discoDuro, int ssd, 
			String grafica, String ssoo, String armario, String categoria, String observaciones){
		modelo.realizarAlta(procesador, memoria, discoDuro, ssd, grafica, ssoo, armario, categoria, observaciones);
	}
	
	public void informarCampoVacio(){
		vista.mensCampoVacio();
	}
	
	//
	//METODOS MODIFICACION EQUIPO
	//
	/**
	 * Este metodo recibe los datos del formulario de modificacion de equipo y los manda al modelo.
	 */
	public void recibirDatosEquipoModif(String idEquipo, String procesador, String memoria, String discoDuro, int ssd, 
			String grafica, String ssoo, String armario){
		modelo.modificarEquipo(idEquipo, procesador, memoria, discoDuro, ssd, grafica, ssoo, armario);
	}
	
	public void avisarActualizacion(){
		vista.mensModifEquipo("El equipo se ha modificado con exito.");
	}
	
	public void avisarEquipoEliminado(){
		vista.mensModifEquipo("El equipo se ha eliminado con exito.");
	}
	
	public void eliminarEquipoConfirm(){
		String idEquipo = vista.getIdEquipoEliminado();
		modelo.eliminarEquipo(idEquipo);
	}
	//
	//METODOS MODIFICACION USUARIO
	//
	public void solicitaRellenarTablaMU(){
		modelo.rellenarTablaModifUsuario();
	}
	
	public void buscarUSUARIOModif(String pestana){
		String txtUSUARIOModif = vista.getTxtUSUARIOModif();
		String catUSUARIOModif = vista.getCatUSUARIOModif();
		modelo.datosBusquedaUsuario(txtUSUARIOModif, catUSUARIOModif, pestana);
	}
	
	public void tablaAFormularioMU(String dniUsuario, String nickUsuario, String nombreUsuario, String mailUsuario, String fnacimientoUsuario, String generoUsuario){
		modelo.rellenarFormularioMU(dniUsuario, nickUsuario, nombreUsuario, mailUsuario, fnacimientoUsuario, generoUsuario);
	}
	
	public void eliminarUsuario(String dniForm){
		modelo.bajaUsuario(dniForm);
	}
	
	public void modificarUsuario(String dniOriginal, String usuarioOriginal, String nombreOriginal, String mailOriginal, String dniForm, 
			String nickForm, String nombreForm, String mailForm, String sexoForm, String diaForm, String mesForm, String anioForm){
		String genero;
		if(sexoForm.equals("Masculino")){
			genero = "male";
		}
		else{
			genero = "female";
		}
		String fechaNacimiento = diaForm + "-" + mesForm + "-" + anioForm;
		modelo.cambioUsuario(dniOriginal, usuarioOriginal, nombreOriginal, mailOriginal, dniForm, nickForm, nombreForm, mailForm, genero, fechaNacimiento);
	}
	
	public void crearUsuario(String dniForm,String nickForm, String nombreForm, String mailForm, 
							String sexoForm, String diaForm, String mesForm, String anioForm){
		String genero;
		if(sexoForm.equals("Masculino")){
			genero = "male";
		}
		else{
			genero = "female";
		}
		String fechaNacimiento = diaForm + "-" + mesForm + "-" + anioForm;		
		modelo.anadirUsuario(dniForm, nickForm, nombreForm, mailForm, genero, fechaNacimiento);
	}
	
	public void avisarCambioUsuario(String mensaje){
		vista.mensajeCambioUsuario(mensaje);
	}
	
	public void avisarErrorCambioUsuario(String mensaje){
		vista.mensajeErrorCambioUsuario(mensaje);
	}
	
	public void identificadorDuplicado(){
		vista.mensajeIdDuplicado();
	}
}
