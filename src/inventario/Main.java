package inventario;

import java.sql.SQLException;

import javax.swing.JFrame;

public class Main {
	private JFrame window;

	private Main() throws ClassNotFoundException, SQLException {
		initialize();
	}

	private void initialize() throws ClassNotFoundException, SQLException {
		Vista vista = new VistaImplLogin();
		Modelo modelo = new ModeloImpl();
		Controlador controlador = new ControladorImpl();

		vista.setControlador(controlador);
		vista.setModelo(modelo);
		controlador.setVista(vista);
		controlador.setModelo(modelo);
		modelo.setVista(vista);
		modelo.setControlador(controlador);
		modelo.gestionarFichero();
		modelo.iniciarConexion();
		modelo.checkAutologin();
	}

	public void setWindowTitle(String title) {
		window.setTitle(title);
	}

	public void setWindowSize(int s1, int s2, int s3, int s4) {
		window.setBounds(s1, s2, s3, s4);
	}

	public static void main(String args[]) throws ClassNotFoundException, SQLException {
		new Main();
	}
}