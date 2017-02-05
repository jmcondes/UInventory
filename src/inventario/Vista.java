package inventario;

import javax.swing.JTable;

public interface Vista {
	public void setControlador(Controlador controlador);

	public void setModelo(Modelo modelo);

	public void correctUserLogin();

	public void wrongUserLogin(int loginTry);

	public void setLoginExced();
	
	public void setUserLogin(String user);

	public Object getUserLogin();

	public Object getPasswordLogin();

	public void setWindowLoginOpen();

	public void setWindowLoginClose();

	public void setWindowRegisterOpen();

	public void setWindowRegisterClose();
	
	public void setWindowInventarioOpen();
	
	public void setWindowInventarioClose();
	
	public void setWindowConfigOpen();
	
	public void setWindowConfigClose();

	public String getRegisterDataUser();
	
	public void existingUser();
	
	public void noneExistingUser();
	
	public void focusUsuarioObtained();
	
	public void existingDNI();
	
	public void noneExistingDNI();
	
	public void focusDNIObtained();
	
	public void wrongDNI();
	
	public void existingEmail();
	
	public void noneExistingEmail();
	
	public void focusEmailioObtained();

	public String getRegisterDataPassword();

	public String getRegisterDataPassword2();

	public String getRegisterDataName();

	public String getRegisterDataDNI();

	public String getRegisterDataEmail();

	public String getBornDate();

	public void correctRegister();

	public void errorRegister();

	public void wrongEmail();

	public void EmptyField();
	
	// METODOS INICIO
	
	public int getNumeroColumnaInicio();
	
	public void actualizaTablaInicio(Object[] fila);
	
	//METODOS RESERVA EQUIPO
	
	public String getCategoriaPC();
	
	public String getCategoriaComp();
	
	public String getTextoBusqueda();
	
	public void actualizaTablaReserva(Object[] fila);
	
	public void borrarTabla(JTable tabla, int filas);
	
	public String getTxtUSUARIOReserva();
	
	public int getNumColumnTablaReserva();
	
	public String getCatUSUARIOReserva();
	
	public void rellenaCampoUsuarioRes(String nomUsuarioRE);
	
	public void mensErrorBusq();
	
	public String getIDEquipoRE();
	
	public void mensErrorUsuario();
	
	public void mensConfirmReserva();
	
	public void mensFalloReserva();
	
	public void mensEquipoNoSelec();
	
	public void borrarTexto(String pestana);
	
	//METODOS DEVOLUCION EQUIPO
	
	public String getTxtUSUARIODevol();
	
	public String getCatUSUARIODevol();
	
	public void rellenaCampoUsuarioDevol(String nomUsuarioRE);
	
	public int getNumColumnasTablaDEVOL();
	
	public void actualizaTablaDevol(Object[] fila);
	
	public String getDniUsuarioDevol();
	
	public String getIdEquipoDevol();
	
	public String getFechaReservaDevol();
	
	public String getTipoIdDevol();
	
	public void mensajeConfirmacionDevol(String mensaje, String titulo);
	
	public void mensajeErrorDevol(String mensaje, String titulo);
	
	public void limpiarCamposMEQ();
	
	//METODOS CONFIGURACION INICIO

	public void mostrarConfiguracion(String bd_url, String bd_name, String bd_user,
			String bd_password, String lg_user, String lg_password);
	
	public void autoLogin(Boolean check);
	
	//METODOS ALTA EQUIPO
	
	public void mensCampoVacio();
	
	public void limpiarCamposFormularioAlta();
	
	//METODOS MODIFICACION EQUIPO
	
	public void actualizaTablaModif(Object[] fila);
	
	public String getCategoriaPCModif();
	
	public String getCategoriaCompModif();
	
	public String getTextoBusquedaModif();
	
	public String getIdEquipoEliminado();
	
	public void mensModifEquipo(String mensaje);
	
	//METODOS MODIFICACION USUARIO
	
	public String getTxtUSUARIOModif();
	
	public String getCatUSUARIOModif();
	
	public int getNumColumnasTablaMU();
	
	public void actualizaTablaMU(Object[] fila);
	
	public void actualizaFormularioMU(String dniUsuario,String nickUsuario,String nombreUsuario,String mailUsuario
			,String generoUsuario,String dia,String mes,String anio);
	
	public void mensajeCambioUsuario(String mensaje);
	
	public void mensajeErrorCambioUsuario(String mensaje);
	
	public void mensajeIdDuplicado();
	
	public void limpiarCamposFormularioDevol();
	
}