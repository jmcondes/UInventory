package inventario;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.BevelBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.table.DefaultTableModel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JPasswordField;
import javax.swing.JButton;

import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.ImageIcon;
import javax.swing.JTextArea;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * Esta clase contiene una ventana de "Login" con los campos "Usuario" y
 * "Contrasenia". Dispone de dos metodos para devolver el usuario y la
 * contrasenia.
 * 
 * @author David Navarro de la Morena.
 * @version 2.1 - 25/05/2015
 */
public class VistaImplLogin implements Vista {
	private Modelo modelo;
	private Controlador controlador;
	private DefaultTableModel model;
	//
	// Ventana Login
	//
	// Interfaz ventana
	private JFrame windowLogin;
	private GroupLayout groupLayoutLogin;
	// Areas de Texto
	private JTextField textLoginUsuario;
	private JPasswordField passwordLoginField;
	// Casillas entrada datos
	private JLabel lblLoginUsuario;
	private JLabel lblLoginContrasenia;
	// Botones
	private JButton btnLoginIniciarSesion;
	private JButton btnLoginRegistrarme;
	// Area de Imagen
	private JLabel lblLoginImagen;
	//
	// Ventana Register
	//
	// Interfaz ventana
	private JFrame windowRegister;
	private GroupLayout groupLayoutRegister;
	// Areas de Texto
	private JLabel lblRegisterNombreDeUsuario;
	private JLabel lblRegisterContrasenia;
	private JLabel lblRegisterRepiteContrasenia;
	private JLabel lblRegisterNombre;
	private JLabel lblRegisterDNI;
	private JLabel lblRegisterEmail;
	private JLabel lblRegisterFechaDeNacimiento;
	// Casillas entrada datos
	private JTextField textRegisterUsuario;
	private JPasswordField passwordRegisterContrasenia;
	private JPasswordField passwordRegisterContraseniaRep;
	private JTextField textRegisterNombre;
	private JTextField textRegisterDNI;
	private JTextField textRegisterEmail;
	// Desplegables
	private JComboBox<Integer> comboBoxRegisterFechaDia;
	private JComboBox<String> comboBoxRegisterFechaMes;
	private JComboBox<Integer> comboBoxRegisterFechaAnio;
	// Botones
	private JButton btnTerminarRegistro;
	private JButton btnVolverAtras;
	//
	// Ventana Inventario
	//
	// Interfaz ventana
	private JFrame windowInventario;
	private JTabbedPane panelPestanas;
	private JPanel pestanaInicio;
	private JPanel pestanaReserva;
	private JPanel pestanaDevolucion;
	private JPanel pestanaAlta;
	private JPanel pestanaModificacionEquipo;
	private JPanel pestanaModificacionUsuario;
	// Areas de Texto
	private JLabel lblINICIODevolucionesPendientes;
	private JLabel lblRESERVAUsuario;
	private JLabel lblDEVOLUCIONDatosUsuario;
	private JLabel lblALTAProcesador;
	private JLabel lblALTADatosNuevos;
	private JLabel lblALTAMemoriaRam;
	private JLabel lblALTADiscoDuro;
	private JLabel lblALTATarjetaGrfica;
	private JLabel lblALTASistemaOperativo;
	private JLabel lblALTANmeroDeArmario;
	private JLabel lblALTACategoria;
	private JLabel lblALTAObservaciones;
	private JLabel lblMODIFICACIONUSRDatosDelUsuario;
	private JLabel lblMODIFICACIONEQProcesador;
	private JLabel lblMODIFICACIONEQRam;
	private JLabel lblMODIFICACIONEQHDD;
	private JLabel lblMODIFICACIONEQGrafica;
	private JLabel lblMODIFICACIONEQSSOO;
	private JLabel lblMODIFICACIONEQNmeroDeArmario;
	private JLabel lblMODIFICACIONEQEquiposExistentes;
	private JLabel lblMODIFICACIONUSRDNI;
	private JLabel lblMODIFICACIONUSRUsuario;
	private JLabel lblMODIFICACIONUSRNombreYApellidos;
	private JLabel lblMODIFICACIONUSREmail;
	private JLabel lblMODIFICACIONUSRFechaDeNaciemiento;
	private JLabel lblMODIFICACIONUSRSexo;
	private JLabel lblMODIFICACIONUSRUsuarioExistente;
	// Casillas entrada datos
	private JTextField txtRESERVADNI;
	private JTextField txtRESERVANombre;
	private JTextField txtRESERVABuscar;
	private JTextField txtDEVOLUCIONDNI;
	private JTextField txtDEVOLUCIONNombre;
	private JTextField txtALTAProcesador;
	private JTextField txtALTARAM;
	private JTextField txtALTAHDD;
	private JTextField txtALTAGrafica;
	private JTextField txtMODIFICACIONEQBuscar;
	private JTextField txtMODIFICACIONUSRDNI;
	private JTextField txtMODIFICACIONUSRUsuario;
	private JTextField txtMODIFICACIONUSRNombre;
	private JTextField txtMODIFICACIONUSREmail;
	private JTextField textFieldMODIFICACIONEQProcesador;
	private JTextField textFieldMODIFICACIONEQRam;
	private JTextField textFieldMODIFICACIONEQHDD;
	private JTextField textFieldMODIFICACIONEQGrafica;
	private JTextField textFieldMODIFICACIONEQSSOO;
	private JTextField txtMODIFICACIONUSRBuscar;
	private JTextField txtALTASSOO;
	// Desplegables
	private JComboBox<String> comboBoxRESERVAEquipo;
	private JComboBox<String> comboBoxRESERVABusqueda;
	private JComboBox<String> comboBoxRESERVAUsuario;
	private JComboBox<String> comboBoxDEVOLUCIONRes;
	private JComboBox<String> comboBoxDEVOLUCIONUsuario;
	private JComboBox<String> comboBoxALTAArmario;
	private JComboBox<String> comboBoxALTACategoria;
	private JComboBox<String> comboBoxMODIFICACIONEQComp;
	private JComboBox<String> comboBoxMODIFICACIONEQCat;
	private JComboBox<String> comboBoxMODIFICACIONUSRDia;
	private JComboBox<String> comboBoxMODIFICACIONUSRMes;
	private JComboBox<String> comboBoxMODIFICACIONUSRAnio;
	private JComboBox<String> comboBoxMODIFICACIONEQArmario;
	private JComboBox<String> comboBoxMODIFICACIONUSRSexo;
	private JComboBox<String> comboBoxMODIFICACIONUSRBusqueda;
	// Scroll Panels
	private JScrollPane scrollPaneINICIO;
	private JScrollPane scrollPaneRESERVA;
	private JScrollPane scrollPaneDEVOLUCION;
	private JScrollPane scrollPaneMODIFICACIONEQ;
	private JScrollPane scrollPaneMODIFICACIONUSR;
	// Tablas
	private JTable tablaReservaEquipo;
	private JTable tableDEVOLUCION;
	private JTable tableMODIFICACIONEQ;
	private JTable tableINICIO;
	private JTable tableMODIFICACIONUSR;
	// Botones
	private JButton btnConfiguracinInicio;
	private JButton btnINICIOCerrarSesion;
	private JButton btnRESERVAConfirmar;
	private JButton btnRESERVABuscar;
	private JButton btnRESERVARDNIBuscar;
	private JButton btnDEVOLUCIONDNIBuscar;
	private JButton btnDEVOLUCIONDevolverEquipo;
	private JButton btnMOSTRARReservas;
	private JButton btnALTAConfirmarAlta;
	private JButton btnMODIFICACIONEQBuscar;
	private JButton btnMODIFICACIONEQModificar;
	private JButton btnMODIFICACIONEQEliminar;
	private JButton btnMODIFICACIONUSREliminarUsuario;
	private JButton btnMODIFICACIONUSRConfirmarModificacion;
	private JButton btnMODIFICACIONUSRNuevoUsuario;
	private JButton btnMODIFICACIONUSRBuscar;
	// Check Box
	private JCheckBox chckbxALTASsd;
	private JCheckBox chckbxMODIFICACIONEQSSD;
	// Text Area
	private JTextArea textAreaALTAObservaciones;
	// Groups Layout
	private GroupLayout gl_pestanaInicio;
	private GroupLayout gl_pestanaReserva;
	private GroupLayout gl_pestanaDevolucion;
	private GroupLayout gl_pestanaAlta;
	private GroupLayout gl_pestanaModificacionEquipo;
	private GroupLayout gl_pestanaModificacionUsuario;
	//
	// Ventana Inventario
	//
	// Interfaz ventana
	private JFrame windowConfig;
	// Casillas entrada datos
	private JLabel lblURLBaseDe;
	private JLabel lblNombreBaseDe;
	private JLabel lblUsuarioBaseDe;
	private JLabel lblConfiguracinBaseDe;
	private JLabel lblContrasenaBaseDe;
	private JLabel lblConfiguracionInicioSesion;
	private JLabel lblUsuario;
	private JLabel lblContrasea;
	// Areas de Texto
	private JTextField txtURLBaseDe;
	private JTextField txtNombreBaseDe;
	private JTextField txtUsuarioBaseDe;
	private JTextField txtUsuario;
	// Areas de Contrasena
	private JPasswordField txtContrasenaBaseDe;
	private JPasswordField txtContrasena;
	// Botones
	private JButton btnGuardarCambios;
	private JButton btnDescartarCambios;
	// Check Box
	private JCheckBox chckbxIniciarSesinAutomaticamente;
	private Boolean autoLogin = false;
	// Groups Layout
	private GroupLayout groupLayout;
	private JScrollPane scrollPane;
	private JLabel lblCreatedBy;
	private JLabel lblJosManuelCondes;
	private JLabel lblMiguelJimnez;
	private JLabel lblDavidNavarro;
	// Backup de los datos del usuario
	private String dniOriginal;
	private String nombreOriginal;
	private String usuarioOriginal;
	private String mailOriginal;

	//
	// <------------------------------>Metodos_de_la_Clase<------------------------------>
	//

	public VistaImplLogin() {
		super();
		windowLogin();
		// windowRegister();
		// windowInventario();
		// windowConfig();
		model = new DefaultTableModel();
	}

	public void setControlador(Controlador controlador) {
		this.controlador = controlador;
	}

	public void setModelo(Modelo modelo) {
		this.modelo = modelo;
	}

	public void setUserLogin(String user) {
		textLoginUsuario.setText(user);
	}

	public String getUserLogin() {
		return textLoginUsuario.getText();
	}

	public String getPasswordLogin() {
		char password[] = passwordLoginField.getPassword();
		String str = new String(password);
		return str;
	}

	public void correctUserLogin() {
		JOptionPane.showMessageDialog(null, "Usuario correcto",
				"Usuario correcto", 1);
	}

	public void wrongUserLogin(int loginTry) {
		JOptionPane
				.showMessageDialog(
						null,
						"El usuario o la contrase\u00F1a no coincide.\nPor favor, revisa los campos.\n         Intentos restantes: "
								+ loginTry, "Datos invalidos", 2);
	}

	public void setWindowLoginOpen() {
		windowLogin();
	}

	public void setWindowLoginClose() {
		windowLogin.dispose();
	}

	public void setWindowRegisterOpen() {
		windowRegister();
	}

	public void setWindowRegisterClose() {
		windowRegister.dispose();
	}

	public void setWindowInventarioOpen() {
		windowInventario();
	}

	public void setWindowInventarioClose() {
		windowInventario.dispose();
	}

	public void setWindowConfigOpen() {
		windowConfig();
	}

	public void setWindowConfigClose() {
		windowConfig.dispose();
	}

	public void correctRegister() {
		JOptionPane
				.showMessageDialog(
						null,
						"Te has registrado de forma exitosa.\nYa puedes iniciar sesion.",
						"Registro correcto", 1);
	}

	public void errorRegister() {
		JOptionPane
				.showMessageDialog(
						null,
						"Se ha producido un error inesperado durante el proceso de registro\nPor favor, intentel\u00F3 de nuevo.",
						"Error de registr", 2);
	}

	public void EmptyField() {
		JOptionPane
				.showMessageDialog(
						null,
						"Alguno de los campos esta vacio.\nPor favor, revisa todos los campos.",
						"Campos vacios", 2);
	}

	public void setLoginExced() {
		JOptionPane.showMessageDialog(null,
				"Has excedido el maximo de intentos de inicio de sesi\u00F3n.",
				"Inicio de sesion excedido", 2);
	}

	//
	//
	// <------------------------------><------------------------------>LOGIN_VENTANA<------------------------------><------------------------------>
	//
	//
	private void windowLogin() {
		//
		// <------------------------------>Configuracion_de_la_Ventana<------------------------------>
		//
		windowLogin = new JFrame();
		windowLogin.setTitle("Inicio de Sesi\u00F3n");
		windowLogin.setIconImage(Toolkit.getDefaultToolkit().getImage(
				VistaImplLogin.class.getResource("/pictures/login_64px.png")));
		windowLogin.pack();
		windowLogin.setResizable(false);
		windowLogin.setVisible(true);
		windowLogin.setBounds(100, 100, 360, 170);
		windowLogin.setLocationRelativeTo(null);
		windowLogin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//
		// <------------------------------>Contido_de_interacciï¿½n_con_el_usuario<------------------------------>
		//
		// Campo de Usuario
		//
		lblLoginUsuario = new JLabel("Usuario:");
		lblLoginUsuario.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textLoginUsuario = new JTextField();
		textLoginUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controlador.checkUserLogin();
			}
		});
		textLoginUsuario.setColumns(10);
		//
		// Campo de Contrasenia
		//
		lblLoginContrasenia = new JLabel("Contrase\u00F1a");
		lblLoginContrasenia.setFont(new Font("Tahoma", Font.PLAIN, 14));
		passwordLoginField = new JPasswordField();
		passwordLoginField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				controlador.checkUserLogin();
			}
		});
		//
		// Boton Iniciar Sesion
		//
		btnLoginIniciarSesion = new JButton("Iniciar Sesi\u00F3n");
		btnLoginIniciarSesion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controlador.checkUserLogin();
			}
		});
		//
		// Boton Registrarse
		//
		btnLoginRegistrarme = new JButton("Registrarme");
		btnLoginRegistrarme.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				controlador.changeWindow(1);
			}
		});
		//
		// Imagen Llaves
		//
		lblLoginImagen = new JLabel("");
		lblLoginImagen.setIcon(new ImageIcon(VistaImplLogin.class
				.getResource("/pictures/U-Inventory_x64.png")));
		//
		// <------------------------------>Grupos_y_ordenaciï¿½n_en_la_ventana<------------------------------>
		//
		groupLayoutLogin = new GroupLayout(windowLogin.getContentPane());
		groupLayoutLogin
				.setHorizontalGroup(groupLayoutLogin
						.createParallelGroup(Alignment.LEADING)
						.addGroup(
								groupLayoutLogin
										.createSequentialGroup()
										.addContainerGap()
										.addGroup(
												groupLayoutLogin
														.createParallelGroup(
																Alignment.LEADING)
														.addGroup(
																groupLayoutLogin
																		.createSequentialGroup()
																		.addComponent(
																				lblLoginImagen)
																		.addGap(18)
																		.addGroup(
																				groupLayoutLogin
																						.createParallelGroup(
																								Alignment.TRAILING)
																						.addComponent(
																								lblLoginContrasenia)
																						.addComponent(
																								lblLoginUsuario)))
														.addComponent(
																btnLoginRegistrarme))
										.addGroup(
												groupLayoutLogin
														.createParallelGroup(
																Alignment.TRAILING)
														.addGroup(
																groupLayoutLogin
																		.createSequentialGroup()
																		.addPreferredGap(
																				ComponentPlacement.RELATED)
																		.addComponent(
																				btnLoginIniciarSesion))
														.addGroup(
																Alignment.LEADING,
																groupLayoutLogin
																		.createSequentialGroup()
																		.addPreferredGap(
																				ComponentPlacement.RELATED)
																		.addGroup(
																				groupLayoutLogin
																						.createParallelGroup(
																								Alignment.LEADING)
																						.addComponent(
																								textLoginUsuario,
																								GroupLayout.DEFAULT_SIZE,
																								161,
																								Short.MAX_VALUE)
																						.addComponent(
																								passwordLoginField,
																								GroupLayout.DEFAULT_SIZE,
																								161,
																								Short.MAX_VALUE))))
										.addContainerGap()));
		groupLayoutLogin
				.setVerticalGroup(groupLayoutLogin
						.createParallelGroup(Alignment.TRAILING)
						.addGroup(
								groupLayoutLogin
										.createSequentialGroup()
										.addContainerGap()
										.addGroup(
												groupLayoutLogin
														.createParallelGroup(
																Alignment.LEADING)
														.addComponent(
																lblLoginImagen)
														.addGroup(
																groupLayoutLogin
																		.createSequentialGroup()
																		.addGroup(
																				groupLayoutLogin
																						.createParallelGroup(
																								Alignment.BASELINE)
																						.addComponent(
																								textLoginUsuario,
																								GroupLayout.PREFERRED_SIZE,
																								GroupLayout.DEFAULT_SIZE,
																								GroupLayout.PREFERRED_SIZE)
																						.addComponent(
																								lblLoginUsuario))
																		.addGap(18)
																		.addGroup(
																				groupLayoutLogin
																						.createParallelGroup(
																								Alignment.BASELINE)
																						.addComponent(
																								passwordLoginField,
																								GroupLayout.PREFERRED_SIZE,
																								GroupLayout.DEFAULT_SIZE,
																								GroupLayout.PREFERRED_SIZE)
																						.addComponent(
																								lblLoginContrasenia))))
										.addContainerGap(67, Short.MAX_VALUE))
						.addGroup(
								groupLayoutLogin
										.createSequentialGroup()
										.addContainerGap(113, Short.MAX_VALUE)
										.addGroup(
												groupLayoutLogin
														.createParallelGroup(
																Alignment.BASELINE)
														.addComponent(
																btnLoginRegistrarme)
														.addComponent(
																btnLoginIniciarSesion))
										.addContainerGap()));
		windowLogin.getContentPane().setLayout(groupLayoutLogin);
	}

	//
	//
	//
	//
	// <------------------------------><------------------------------>REGISTRO_VENTANA<------------------------------><------------------------------>
	//
	//
	//
	//

	public String getRegisterDataUser() {
		return textRegisterUsuario.getText();
	}

	public String getRegisterDataPassword() {
		char tmp[] = passwordRegisterContrasenia.getPassword();
		String str = new String(tmp);

		return str;
	}

	public String getRegisterDataPassword2() {
		char tmp[] = passwordRegisterContraseniaRep.getPassword();
		String str = new String(tmp);

		return str;
	}

	public String getRegisterDataName() {
		return textRegisterNombre.getText();
	}

	public String getRegisterDataDNI() {
		return textRegisterDNI.getText();
	}

	public String getRegisterDataEmail() {
		return textRegisterEmail.getText();
	}

	public String getBornDate() {
		String tmp = (comboBoxRegisterFechaDia.getSelectedItem().toString()
				+ "-" + comboBoxRegisterFechaMes.getSelectedItem().toString()
				+ "-" + comboBoxRegisterFechaAnio.getSelectedItem().toString());

		return tmp;
	}

	public void wrongEmail() {
		textRegisterEmail.setBackground(Color.red);
		JOptionPane.showMessageDialog(null,
				"El email introducido no es valido.", "¡Email no valido!",0);
	}

	public void existingUser() {
		textRegisterUsuario.setBackground(Color.red);
		JOptionPane
				.showMessageDialog(
						null,
						"El nombre de usuario introducido ya existe.\nPor favor, elige otro.",
						"El nombre de usuario ya existe", 2);
	}

	public void noneExistingUser() {
		textRegisterUsuario.setBackground(Color.green);
	}

	public void existingDNI() {
		textRegisterDNI.setBackground(Color.red);
		JOptionPane.showMessageDialog(null,
				"El DNI introducido ya existe.\nPor favor, elige otro.",
				"El DNI ya existe", 2);
	}

	public void noneExistingDNI() {
		textRegisterDNI.setBackground(Color.green);
	}
	
	public void wrongDNI() {
		textRegisterDNI.setBackground(Color.red);
		JOptionPane.showMessageDialog(null,
				"El DNI introducido no es valido. Recuerda:\n DNI: XXXXXXXX (8 números).", "¡DNI no valido!", 2);
	}

	public void existingEmail() {
		textRegisterEmail.setBackground(Color.red);
		JOptionPane.showMessageDialog(null,
				"El email introducido ya existe.\nPor favor, elige otro.",
				"El email ya existe", 2);
	}

	public void noneExistingEmail() {
		textRegisterEmail.setBackground(Color.green);
	}

	public void focusUsuarioObtained() {
		textRegisterUsuario.setBackground(Color.WHITE);
	}

	public void focusDNIObtained() {
		textRegisterDNI.setBackground(Color.WHITE);
	}

	public void focusEmailioObtained() {
		textRegisterEmail.setBackground(Color.WHITE);
	}

	/**
	 * Metodo principal de la clase. Contiene todos los elementos de la ventana.
	 */
	private void windowRegister() {
		//
		// <------------------------------>Configuracion_del_Panel<------------------------------>
		//
		windowRegister = new JFrame();
		windowRegister.setTitle("Registro");
		windowRegister.setIconImage(Toolkit.getDefaultToolkit().getImage(
				VistaImplLogin.class
						.getResource("/pictures/U-Programmers_S.L._x64.png")));
		windowRegister.pack();
		windowRegister.setResizable(false);
		windowRegister.setVisible(true);
		windowRegister.setBounds(100, 100, 450, 300);
		windowRegister.setLocationRelativeTo(null);
		windowRegister.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//
		// <------------------------------>Contido_de_interaccion_con_el_usuario<------------------------------>
		//
		// Campo de Usuario
		//
		lblRegisterNombreDeUsuario = new JLabel("Nombre de Usuario:");
		textRegisterUsuario = new JTextField();
		textRegisterUsuario.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent arg0) {
				controlador.focusUsuarioObtained();
			}
		});
		textRegisterUsuario.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				controlador.checkUserDisponibility();
			}
		});
		textRegisterUsuario.setColumns(10);
		//
		// Campo de Contrasenia
		//
		lblRegisterContrasenia = new JLabel("Contrase\u00F1a:");
		passwordRegisterContrasenia = new JPasswordField();
		lblRegisterRepiteContrasenia = new JLabel("Repite Contrase\u00F1a:");
		passwordRegisterContraseniaRep = new JPasswordField();
		//
		// Campo de Nombre
		//
		lblRegisterNombre = new JLabel("Nombre:");
		textRegisterNombre = new JTextField();
		textRegisterNombre.setColumns(10);
		//
		// Campo de Apellido
		//
		lblRegisterDNI = new JLabel("DNI:");
		textRegisterDNI = new JTextField();
		textRegisterDNI.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent arg0) {
				controlador.focusDNIObtained();
			}
		});
		textRegisterDNI.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				controlador.checkDNIDisponibility();
			}
		});
		textRegisterDNI.setColumns(10);
		//
		// Campo de Email
		//
		lblRegisterEmail = new JLabel("Email:");
		textRegisterEmail = new JTextField();
		textRegisterEmail.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent arg0) {
				controlador.focusEmailioObtained();
			}
		});
		textRegisterEmail.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				controlador.checkEmailDisponibility();
			}
		});
		textRegisterEmail.setColumns(10);
		//
		// Campo de Fecha de Nacimiento
		//
		lblRegisterFechaDeNacimiento = new JLabel("Fecha de Nacimiento:");
		// campo de Dia
		comboBoxRegisterFechaDia = new JComboBox<Integer>();
		comboBoxRegisterFechaDia.setEnabled(true);
		comboBoxRegisterFechaDia.setModel(new DefaultComboBoxModel<Integer>(
				new Integer[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14,
						15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28,
						29, 30, 31 }));

		// Campo de Mes
		comboBoxRegisterFechaMes = new JComboBox<String>();
		comboBoxRegisterFechaMes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				diasDelMes();
			}
		});
		comboBoxRegisterFechaMes.setModel(new DefaultComboBoxModel<String>(
				new String[] { "Enero", "Febrero", "Marzo", "Abril", "Mayo",
						"Junio", "Julio", "Agosto", "Septiembre", "Octubre",
						"Noviembre", "Diciembre" }));
		// Campo de Anio
		comboBoxRegisterFechaAnio = new JComboBox<Integer>();
		comboBoxRegisterFechaAnio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				diasDelMes();
			}
		});
		comboBoxRegisterFechaAnio.setModel(new DefaultComboBoxModel<Integer>(
				new Integer[] { 2015, 2014, 2013, 2012, 2011, 2010, 2009, 2008,
						2007, 2006, 2005, 2004, 2003, 2002, 2001, 2000, 1999,
						1998, 1997, 1996, 1995, 1994, 1993, 1992, 1991, 1990,
						1989, 1988, 1987, 1986, 1985, 1984, 1983, 1982, 1981,
						1980, 1979, 1978, 1977, 1976, 1975, 1974, 1973, 1972,
						1971, 1970, 1969, 1968, 1967, 1966, 1965, 1964, 1963,
						1962, 1961, 1960, 1959, 1958, 1957, 1956, 1955, 1954,
						1953, 1952, 1951, 1950, 1949, 1948, 1947, 1946, 1945,
						1944, 1943, 1942, 1941, 1940, 1939, 1938, 1937, 1936,
						1935, 1934, 1933, 1932, 1931, 1930, 1929, 1928, 1927,
						1926, 1925, 1924, 1923, 1922, 1921, 1920, 1919, 1918,
						1917, 1916, 1915, 1914, 1913, 1912, 1911, 1910 }));
		//
		// Boton de Terminar Registro
		//
		btnTerminarRegistro = new JButton("Terminar Registro");
		btnTerminarRegistro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				controlador.checkRegisterData();
			}
		});

		btnVolverAtras = new JButton("Volver Atr\u00E1s");
		btnVolverAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				controlador.changeWindow(0);
			}
		});
		//
		// <------------------------------>Grupos_y_ordenaciï¿½n_en_la_ventana<------------------------------>
		//
		groupLayoutRegister = new GroupLayout(windowRegister.getContentPane());
		groupLayoutRegister
				.setHorizontalGroup(groupLayoutRegister
						.createParallelGroup(Alignment.LEADING)
						.addGroup(
								groupLayoutRegister
										.createSequentialGroup()
										.addGroup(
												groupLayoutRegister
														.createParallelGroup(
																Alignment.LEADING)
														.addGroup(
																groupLayoutRegister
																		.createSequentialGroup()
																		.addGap(23)
																		.addGroup(
																				groupLayoutRegister
																						.createParallelGroup(
																								Alignment.TRAILING)
																						.addComponent(
																								lblRegisterNombreDeUsuario)
																						.addComponent(
																								lblRegisterContrasenia)
																						.addComponent(
																								lblRegisterNombre)
																						.addComponent(
																								lblRegisterDNI)
																						.addComponent(
																								lblRegisterRepiteContrasenia)
																						.addComponent(
																								lblRegisterFechaDeNacimiento)
																						.addComponent(
																								lblRegisterEmail))
																		.addPreferredGap(
																				ComponentPlacement.RELATED)
																		.addGroup(
																				groupLayoutRegister
																						.createParallelGroup(
																								Alignment.LEADING,
																								false)
																						.addComponent(
																								textRegisterDNI,
																								245,
																								245,
																								Short.MAX_VALUE)
																						.addComponent(
																								textRegisterNombre,
																								245,
																								245,
																								Short.MAX_VALUE)
																						.addComponent(
																								passwordRegisterContraseniaRep,
																								245,
																								245,
																								Short.MAX_VALUE)
																						.addComponent(
																								passwordRegisterContrasenia,
																								245,
																								245,
																								Short.MAX_VALUE)
																						.addComponent(
																								textRegisterUsuario)
																						.addGroup(
																								groupLayoutRegister
																										.createSequentialGroup()
																										.addComponent(
																												comboBoxRegisterFechaDia,
																												GroupLayout.PREFERRED_SIZE,
																												GroupLayout.DEFAULT_SIZE,
																												GroupLayout.PREFERRED_SIZE)
																										.addPreferredGap(
																												ComponentPlacement.RELATED)
																										.addComponent(
																												comboBoxRegisterFechaMes,
																												GroupLayout.PREFERRED_SIZE,
																												GroupLayout.DEFAULT_SIZE,
																												GroupLayout.PREFERRED_SIZE)
																										.addPreferredGap(
																												ComponentPlacement.RELATED)
																										.addComponent(
																												comboBoxRegisterFechaAnio,
																												GroupLayout.PREFERRED_SIZE,
																												GroupLayout.DEFAULT_SIZE,
																												GroupLayout.PREFERRED_SIZE))
																						.addComponent(
																								textRegisterEmail)))
														.addGroup(
																Alignment.TRAILING,
																groupLayoutRegister
																		.createSequentialGroup()
																		.addContainerGap()
																		.addComponent(
																				btnVolverAtras)
																		.addPreferredGap(
																				ComponentPlacement.RELATED,
																				186,
																				Short.MAX_VALUE)
																		.addComponent(
																				btnTerminarRegistro)))
										.addContainerGap()));
		groupLayoutRegister
				.setVerticalGroup(groupLayoutRegister
						.createParallelGroup(Alignment.LEADING)
						.addGroup(
								groupLayoutRegister
										.createSequentialGroup()
										.addGap(12)
										.addGroup(
												groupLayoutRegister
														.createParallelGroup(
																Alignment.BASELINE)
														.addComponent(
																textRegisterUsuario,
																GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE)
														.addComponent(
																lblRegisterNombreDeUsuario))
										.addPreferredGap(
												ComponentPlacement.RELATED)
										.addGroup(
												groupLayoutRegister
														.createParallelGroup(
																Alignment.BASELINE)
														.addComponent(
																lblRegisterContrasenia)
														.addComponent(
																passwordRegisterContrasenia,
																GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE))
										.addPreferredGap(
												ComponentPlacement.RELATED)
										.addGroup(
												groupLayoutRegister
														.createParallelGroup(
																Alignment.BASELINE)
														.addComponent(
																passwordRegisterContraseniaRep,
																GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE)
														.addComponent(
																lblRegisterRepiteContrasenia))
										.addGap(18)
										.addGroup(
												groupLayoutRegister
														.createParallelGroup(
																Alignment.BASELINE)
														.addComponent(
																textRegisterNombre,
																GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE)
														.addComponent(
																lblRegisterNombre))
										.addPreferredGap(
												ComponentPlacement.RELATED)
										.addGroup(
												groupLayoutRegister
														.createParallelGroup(
																Alignment.BASELINE)
														.addComponent(
																textRegisterDNI,
																GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE)
														.addComponent(
																lblRegisterDNI))
										.addPreferredGap(
												ComponentPlacement.RELATED)
										.addGroup(
												groupLayoutRegister
														.createParallelGroup(
																Alignment.BASELINE)
														.addComponent(
																textRegisterEmail,
																GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE)
														.addComponent(
																lblRegisterEmail))
										.addPreferredGap(
												ComponentPlacement.RELATED)
										.addGroup(
												groupLayoutRegister
														.createParallelGroup(
																Alignment.BASELINE)
														.addComponent(
																lblRegisterFechaDeNacimiento)
														.addComponent(
																comboBoxRegisterFechaDia,
																GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE)
														.addComponent(
																comboBoxRegisterFechaMes,
																GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE)
														.addComponent(
																comboBoxRegisterFechaAnio,
																GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE))
										.addPreferredGap(
												ComponentPlacement.RELATED, 14,
												Short.MAX_VALUE)
										.addGroup(
												groupLayoutRegister
														.createParallelGroup(
																Alignment.BASELINE)
														.addComponent(
																btnTerminarRegistro)
														.addComponent(
																btnVolverAtras))
										.addContainerGap()));
		windowRegister.getContentPane().setLayout(groupLayoutRegister);
	}

	/**
	 * Metodo para establecer el numero de dias en funcion del mes y del anio
	 * seleccionados
	 */
	private void diasDelMes() {
		// Si el mes es febrero, limitamos los dias a 27.
		if (comboBoxRegisterFechaMes.getSelectedItem().equals("Febrero")) {
			comboBoxRegisterFechaDia.setEnabled(true);
			if (Integer.parseInt(comboBoxRegisterFechaAnio.getSelectedItem()
					.toString()) % 4 == 0
					|| Integer.parseInt(comboBoxRegisterFechaAnio
							.getSelectedItem().toString()) % 100 != 0
					&& Integer.parseInt(comboBoxRegisterFechaAnio
							.getSelectedItem().toString()) % 400 == 0) {
				comboBoxRegisterFechaDia
						.setModel(new DefaultComboBoxModel<Integer>(
								new Integer[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10,
										11, 12, 13, 14, 15, 16, 17, 18, 19, 20,
										21, 22, 23, 24, 25, 26, 27, 28, 29 }));
			} else {
				comboBoxRegisterFechaDia
						.setModel(new DefaultComboBoxModel<Integer>(
								new Integer[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10,
										11, 12, 13, 14, 15, 16, 17, 18, 19, 20,
										21, 22, 23, 24, 25, 26, 27, 28 }));
			}
			// Si se trata de Enero, Marzo, Mayo, Julio, Septiembre o
			// Diciembre, ponemos los 31 dias.
		} else if (comboBoxRegisterFechaMes.getSelectedItem().equals("Enero")
				|| comboBoxRegisterFechaMes.getSelectedItem().equals("Marzo")
				|| comboBoxRegisterFechaMes.getSelectedItem().equals("Mayo")
				|| comboBoxRegisterFechaMes.getSelectedItem().equals("Julio")
				|| comboBoxRegisterFechaMes.getSelectedItem().equals(
						"Septiembre")
				|| comboBoxRegisterFechaMes.getSelectedItem().equals(
						"Diciembre")) {
			comboBoxRegisterFechaDia.setEnabled(true);
			comboBoxRegisterFechaDia
					.setModel(new DefaultComboBoxModel<Integer>(new Integer[] {
							1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15,
							16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28,
							29, 30, 31 }));

			// Para el resto, limitamos a 30 dias.
		} else {
			comboBoxRegisterFechaDia.setEnabled(true);
			comboBoxRegisterFechaDia
					.setModel(new DefaultComboBoxModel<Integer>(new Integer[] {
							1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15,
							16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28,
							29, 30 }));
		}
	}

	//
	//
	//
	//
	// INVENTARIO - METODOS
	//
	//
	//
	//

	public void borrarTextField(JTextField txtBusqueda, String txt) {
		if (txtBusqueda.getText().equals(txt)) {
			txtBusqueda.setText("");
			txtBusqueda.setForeground(Color.BLACK);
		} else if (txtBusqueda.getText().equals("")) {
			txtBusqueda.setText(txt);
			txtBusqueda.setForeground(Color.LIGHT_GRAY);
		}
	}

	//
	//
	//
	// <------------------------------><------------------------------>INVENTARIO_VENTANA<------------------------------><------------------------------>
	//
	//
	//
	@SuppressWarnings("serial")
	private void windowInventario() {
		//
		// <------------------------------>Configuracion_del_Frame<------------------------------>
		//
		windowInventario = new JFrame();
		windowInventario.setIconImage(Toolkit.getDefaultToolkit().getImage(
				VistaImplLogin.class
						.getResource("/pictures/U-Programmers_S.L._x64.png")));
		windowInventario.setTitle("Sesi\u00F3n de " + getUserLogin());
		windowInventario.setVisible(true);
		windowInventario.setResizable(false);
		windowInventario.setBounds(100, 100, 656, 499);
		windowInventario.setLocationRelativeTo(null);
		windowInventario.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//
		// <------------------------------>Contido_de_interacciï¿½n_con_el_usuario<------------------------------>
		//
		// CONTENEDOR DE PESTANAS
		//
		panelPestanas = new JTabbedPane(JTabbedPane.TOP);
		windowInventario.getContentPane().add(panelPestanas,
				BorderLayout.CENTER);
		//
		// <----------------------------PESTANA_INICIO-------------------------------->
		//
		pestanaInicio = new JPanel();
		panelPestanas.addTab("Inicio", null, pestanaInicio, null);

		btnConfiguracinInicio = new JButton("Configuraci\u00F3n Inicio");
		btnConfiguracinInicio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controlador.changeWindow(4);
			}
		});
		btnINICIOCerrarSesion = new JButton("Cerrar Sesi\u00F3n");
		btnINICIOCerrarSesion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				controlador.changeWindow(3);
			}
		});

		lblINICIODevolucionesPendientes = new JLabel("Devoluciones pendientes:");
		lblINICIODevolucionesPendientes.setFont(new Font("Tahoma", Font.BOLD,
				14));

		scrollPaneINICIO = new JScrollPane();

		tableINICIO = new JTable(model);
		tableINICIO.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "Fecha Reserva", "Usuario",
						"Descripci\u00F3n Equipo" }

				) {
					boolean[] columnEditables = new boolean[] {
						false, false, false, false, false, false, false
					};
					public boolean isCellEditable(int row, int column) {
						return columnEditables[column];
					}
				});
		tableINICIO.getColumnModel().getColumn(1).setResizable(false);
		scrollPaneINICIO.setViewportView(tableINICIO);
		//
		// <----------------------------PESTANA_RESERVA_EQUIPO-------------------------------->
		//
		pestanaReserva = new JPanel();
		ChangeListener changeListener = new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {
				JTabbedPane sourceTabbedPane = (JTabbedPane) e.getSource();
				int index = sourceTabbedPane.getSelectedIndex();
				if (index == 0) {
					int filas = tableINICIO.getRowCount();
					if (filas > 0) {
						borrarTabla(tableINICIO, filas);
					}
					modelo.datosReservaInicio();
				}

				else if (index == 1) {
					int filas = tablaReservaEquipo.getRowCount();
					if (filas > 0) {
						borrarTabla(tablaReservaEquipo, filas);
					}
					controlador.solicitaRellenarTablaEq("pestanaRES");
				}  else if (index == 4) {
					int filas = tableMODIFICACIONEQ.getRowCount();
					if (filas > 0) {
						borrarTabla(tableMODIFICACIONEQ, filas);
					}
					controlador.solicitaRellenarTablaEq("pestanaMEQ");
				}
			}
		};
		panelPestanas.addChangeListener(changeListener);
		pestanaReserva.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent me) {

			}
		});
		panelPestanas.addTab("Reserva Equipo", null, pestanaReserva, null);

		comboBoxRESERVAEquipo = new JComboBox<String>();
		comboBoxRESERVAEquipo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// Cuenta las filas de la tabla, si hay filas las borra para
				// iniciar otra búsqueda.
				int filas = tablaReservaEquipo.getRowCount();
				if (filas > 0) {
					borrarTabla(tablaReservaEquipo, filas);
				}
				// Llama al controlador para iniciar la búsqueda.
				controlador.buscarEQUIPO("pestanaRES");
			}
		});
		comboBoxRESERVAEquipo.setModel(new DefaultComboBoxModel<String>(
				new String[] { "Portatil", "Servidor", "Sobremesa", "Todo" }));

		comboBoxRESERVAUsuario = new JComboBox<String>();
		comboBoxRESERVAUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (comboBoxRESERVAUsuario.getSelectedItem().equals("Email")) {
					txtRESERVADNI.setText("Escriba el Email");
					txtRESERVADNI.setForeground(Color.LIGHT_GRAY);
				} else if (comboBoxRESERVAUsuario.getSelectedItem().equals(
						"DNI")) {
					txtRESERVADNI.setText("Escriba el DNI");
					txtRESERVADNI.setForeground(Color.LIGHT_GRAY);
				} else {
					txtRESERVADNI.setText("Escriba el Nombre");
					txtRESERVADNI.setForeground(Color.LIGHT_GRAY);
				}
			}
		});
		comboBoxRESERVAUsuario.setModel(new DefaultComboBoxModel<String>(
				new String[] { "DNI", "Email" }));

		scrollPaneRESERVA = new JScrollPane();
		tablaReservaEquipo = new JTable();
		tablaReservaEquipo.setBorder(new BevelBorder(BevelBorder.LOWERED, null,
				null, null, null));
		tablaReservaEquipo.setModel(new DefaultTableModel(new Object[][] {},
				new String[] {
				"ID", "Procesador", "Memoria", "Disco Duro", "SSD", "Tarjeta Gr\u00E1fica", "SSOO"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		tablaReservaEquipo.getColumnModel().getColumn(0).setResizable(false);

		lblRESERVAUsuario = new JLabel("Datos del usuario que reserva:");
		lblRESERVAUsuario.setFont(new Font("Tahoma", Font.BOLD, 14));

		txtRESERVADNI = new JTextField();
		txtRESERVADNI.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent arg0) {
				if (comboBoxRESERVAUsuario.getSelectedItem().equals("Email")) {
					borrarTextField(txtRESERVADNI, "Escriba el Email");
				} else {
					borrarTextField(txtRESERVADNI, "Escriba el DNI");
				}
			}

			@Override
			public void focusLost(FocusEvent e) {
				if (comboBoxRESERVAUsuario.getSelectedItem().equals("Email")) {
					borrarTextField(txtRESERVADNI, "Escriba el Email");
				} else {
					borrarTextField(txtRESERVADNI, "Escriba el DNI");
				}
			}
		});
		txtRESERVADNI.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controlador.buscarUSUARIORes("pestanaRES");
			}
		});
		txtRESERVADNI.setText("Escriba el DNI");
		txtRESERVADNI.setForeground(Color.LIGHT_GRAY);
		txtRESERVADNI.setColumns(10);

		txtRESERVANombre = new JTextField();
		txtRESERVANombre.setEditable(false);
		txtRESERVANombre.setForeground(Color.LIGHT_GRAY);
		txtRESERVANombre.setText("Nombre y Apellidos");
		txtRESERVANombre.setColumns(10);

		btnRESERVAConfirmar = new JButton("Confirmar Reservar");
		btnRESERVAConfirmar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!txtRESERVANombre.getText().equals("Nombre y Apellidos")) {
					if (tablaReservaEquipo.getSelectedRow() != -1) {
						controlador.confirmarReserva();
						DefaultTableModel modelo = (DefaultTableModel) tablaReservaEquipo
								.getModel();
						modelo.removeRow(tablaReservaEquipo.getSelectedRow());
					} else {
						mensEquipoNoSelec();
					}
				} else {
					mensErrorUsuario();
				}
			}
		});

		txtRESERVABuscar = new JTextField();
		txtRESERVABuscar.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent arg0) {
				borrarTextField(txtRESERVABuscar, "Buscar...");
			}

			@Override
			public void focusLost(FocusEvent e) {
				borrarTextField(txtRESERVABuscar, "Buscar...");
			}
		});
		txtRESERVABuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Cuenta las filas de la tabla, si hay filas las borra para
				// iniciar otra búsqueda.
				int filas = tablaReservaEquipo.getRowCount();
				if (filas > 0) {
					borrarTabla(tablaReservaEquipo, filas);
				}
				// Llama al controlador para iniciar la búsqueda.
				controlador.buscarEQUIPO("pestanaRES");
			}
		});
		txtRESERVABuscar.setForeground(Color.LIGHT_GRAY);
		txtRESERVABuscar.setText("Buscar...");
		txtRESERVABuscar.setColumns(10);

		btnRESERVABuscar = new JButton("");
		btnRESERVABuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Borra las filas en el evento de teclado.
				int filas = tablaReservaEquipo.getRowCount();
				if (filas > 0) {
					borrarTabla(tablaReservaEquipo, filas);
				}
				controlador.buscarEQUIPO("pestanaRES");
			}
		});
		btnRESERVABuscar.setIcon(new ImageIcon(VistaImplLogin.class
				.getResource("/pictures/lupa_16px.png")));

		btnRESERVARDNIBuscar = new JButton("");
		btnRESERVARDNIBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controlador.buscarUSUARIORes("pestanaRES");
			}
		});
		btnRESERVARDNIBuscar.setIcon(new ImageIcon(VistaImplLogin.class
				.getResource("/pictures/lupa_16px.png")));

		comboBoxRESERVABusqueda = new JComboBox<String>();
		comboBoxRESERVABusqueda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Cuenta las filas de la tabla, si hay filas las borra para
				// iniciar otra búsqueda.
				int filas = tablaReservaEquipo.getRowCount();
				if (filas > 0) {
					borrarTabla(tablaReservaEquipo, filas);
				}
				// Llama al controlador para iniciar la búsqueda.
				controlador.buscarEQUIPO("pestanaRES");
			}
		});
		comboBoxRESERVABusqueda.setModel(new DefaultComboBoxModel<String>(
				new String[] { "Procesador", "RAM", "Disco Duro",
						"Gr\u00E1fica", "SSOO", "Todo" }));
		scrollPaneRESERVA.setViewportView(tablaReservaEquipo);
		//
		// <-----------------------------PESTANA_DEVOLUCION_EQUIPO------------------------------->
		//
		pestanaDevolucion = new JPanel();
		panelPestanas.addTab("Devoluci\u00F3n Equipo", null, pestanaDevolucion,
				null);

		lblDEVOLUCIONDatosUsuario = new JLabel(
				"Datos del usuario que devuelve:");
		lblDEVOLUCIONDatosUsuario.setFont(new Font("Tahoma", Font.BOLD, 14));

		comboBoxDEVOLUCIONUsuario = new JComboBox<String>();
		comboBoxDEVOLUCIONUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (comboBoxDEVOLUCIONUsuario.getSelectedItem().equals("Email")) {
					txtDEVOLUCIONDNI.setText("Escriba el Email");
					txtDEVOLUCIONDNI.setForeground(Color.LIGHT_GRAY);
				} else {
					txtDEVOLUCIONDNI.setText("Escriba el DNI");
					txtDEVOLUCIONDNI.setForeground(Color.LIGHT_GRAY);
				}
			}
		});
		comboBoxDEVOLUCIONUsuario.setModel(new DefaultComboBoxModel<String>(
				new String[] { "DNI", "Email" }));

		txtDEVOLUCIONDNI = new JTextField();
		txtDEVOLUCIONDNI.addFocusListener(new FocusAdapter() {
			public void focusGained(FocusEvent e) {
				if (comboBoxDEVOLUCIONUsuario.getSelectedItem().equals("Email")) {
					borrarTextField(txtDEVOLUCIONDNI, "Escriba el Email");
				} else {
					borrarTextField(txtDEVOLUCIONDNI, "Escriba el DNI");
				}
			}

			public void focusLost(FocusEvent e) {
				if (comboBoxDEVOLUCIONUsuario.getSelectedItem().equals("Email")) {
					borrarTextField(txtDEVOLUCIONDNI, "Escriba el Email");
				} else if (comboBoxDEVOLUCIONUsuario.getSelectedItem().equals(
						"DNI")) {
					borrarTextField(txtDEVOLUCIONDNI, "Escriba el DNI");
				} else {
					borrarTextField(txtDEVOLUCIONDNI, "Escriba el Nombre");
				}
			}
		});
		txtDEVOLUCIONDNI.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controlador.buscarUSUARIODevol("pestanaDEVOL");
			}
		});

		btnDEVOLUCIONDNIBuscar = new JButton("");
		btnDEVOLUCIONDNIBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controlador.buscarUSUARIODevol("pestanaDEVOL");
			}
		});
		btnDEVOLUCIONDNIBuscar.setIcon(new ImageIcon(VistaImplLogin.class
				.getResource("/pictures/lupa_16px.png")));

		txtDEVOLUCIONDNI.setForeground(Color.LIGHT_GRAY);
		txtDEVOLUCIONDNI.setText("Escriba el DNI");
		txtDEVOLUCIONDNI.setColumns(10);

		txtDEVOLUCIONNombre = new JTextField();
		txtDEVOLUCIONNombre.setEditable(false);
		txtDEVOLUCIONNombre.setForeground(Color.LIGHT_GRAY);
		txtDEVOLUCIONNombre.setText("Nombre y Apellidos");
		txtDEVOLUCIONNombre.setColumns(10);

		comboBoxDEVOLUCIONRes = new JComboBox<String>();
		comboBoxDEVOLUCIONRes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int filas = tableDEVOLUCION.getRowCount();
				if (filas > 0) {
					borrarTabla(tableDEVOLUCION, filas);
				}
				controlador.mostrarReserv((String) comboBoxDEVOLUCIONRes
						.getSelectedItem());
			}
		});
		comboBoxDEVOLUCIONRes
				.setModel(new DefaultComboBoxModel<String>(new String[] {
						"Reservas Pendientes", "Devoluciones", "Todo" }));

		btnMOSTRARReservas = new JButton("Mostrar Reservas");
		btnMOSTRARReservas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int filas = tableDEVOLUCION.getRowCount();
				if (filas > 0) {
					borrarTabla(tableDEVOLUCION, filas);
				}
				controlador.mostrarReserv((String) comboBoxDEVOLUCIONRes
						.getSelectedItem());
			}
		});

		scrollPaneDEVOLUCION = new JScrollPane();

		btnDEVOLUCIONDevolverEquipo = new JButton("Confirmar Devoluci\u00F3n");
		btnDEVOLUCIONDevolverEquipo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!txtDEVOLUCIONNombre.getText().equals("Nombre y Apellidos")) {
					if (tableDEVOLUCION.getSelectedRow() != -1) {
						controlador.solicitarDevolucion();
						int filas = tableDEVOLUCION.getRowCount();
						if (filas > 0) {
							borrarTabla(tableDEVOLUCION, filas);
						}
						controlador
								.mostrarReserv((String) comboBoxDEVOLUCIONRes
										.getSelectedItem());
					} else {
						mensEquipoNoSelec();
					}
				} else {
					mensErrorUsuario();
				}
			}
		});

		tableDEVOLUCION = new JTable(model);
		tableDEVOLUCION.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "ID Equipo", "Descripci\u00F3n",
						"Fecha de la Reserva", "Estado de la Reserva" }

				) {
					boolean[] columnEditables = new boolean[] {
						false, false, false, false, false, false, false
					};
					public boolean isCellEditable(int row, int column) {
						return columnEditables[column];
					}
				});
		tableDEVOLUCION.getColumnModel().getColumn(0).setPreferredWidth(7);
		scrollPaneDEVOLUCION.setViewportView(tableDEVOLUCION);
		//
		// <-----------------------------PESTANA_ALTA_EQUIPO------------------------------->
		//
		pestanaAlta = new JPanel();
		panelPestanas.addTab("Alta Equipo", null, pestanaAlta, null);

		lblALTAProcesador = new JLabel("Procesador:");

		lblALTAMemoriaRam = new JLabel("Memoria RAM:");

		lblALTADiscoDuro = new JLabel("Disco Duro:");

		chckbxALTASsd = new JCheckBox("SSD");

		lblALTATarjetaGrfica = new JLabel("Tarjeta Gr\u00E1fica:");

		lblALTASistemaOperativo = new JLabel("Sistema Operativo:");

		lblALTANmeroDeArmario = new JLabel("N\u00FAmero de Armario:");

		lblALTACategoria = new JLabel("Categoria:");

		lblALTAObservaciones = new JLabel("Observaciones:");

		comboBoxALTAArmario = new JComboBox<String>();
		comboBoxALTAArmario.setModel(new DefaultComboBoxModel<String>(
				new String[] { "Armario 1", "Armario 2", "Armario 3" }));

		btnALTAConfirmarAlta = new JButton("Confirmar Alta");
		btnALTAConfirmarAlta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setDatosEquipo();
			}
		});

		comboBoxALTACategoria = new JComboBox<String>();
		comboBoxALTACategoria.setModel(new DefaultComboBoxModel<String>(
				new String[] { "Servidor", "Sobremesa", "Portatil" }));

		lblALTADatosNuevos = new JLabel("Datos del nuevo equipo:");
		lblALTADatosNuevos.setFont(new Font("Tahoma", Font.BOLD, 14));

		txtALTAProcesador = new JTextField();
		txtALTAProcesador.setColumns(10);

		txtALTARAM = new JTextField();
		txtALTARAM.setColumns(10);

		txtALTAHDD = new JTextField();
		txtALTAHDD.setColumns(10);

		txtALTAGrafica = new JTextField();
		txtALTAGrafica.setColumns(10);

		txtALTASSOO = new JTextField();
		txtALTASSOO.setColumns(10);
		//
		// <----------------------------PESTANA_MODIFICACION_EQUIPO-------------------------------->
		//
		pestanaModificacionEquipo = new JPanel();
		panelPestanas.addTab("Modificaci\u00F3n Equipo", null,
				pestanaModificacionEquipo, null);

		lblMODIFICACIONEQEquiposExistentes = new JLabel(
				"Equipos no reservados:");
		lblMODIFICACIONEQEquiposExistentes.setFont(new Font("Tahoma",
				Font.BOLD, 14));

		scrollPaneMODIFICACIONEQ = new JScrollPane();

		btnMODIFICACIONEQBuscar = new JButton("");
		btnMODIFICACIONEQBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Borra las filas en el evento de teclado.
				int filas = tableMODIFICACIONEQ.getRowCount();
				if (filas > 0) {
					borrarTabla(tableMODIFICACIONEQ, filas);
				}
				controlador.buscarEQUIPO("pestanaMOD");
			}
		});
		btnMODIFICACIONEQBuscar.setIcon(new ImageIcon(VistaImplLogin.class
				.getResource("/pictures/lupa_16px.png")));

		txtMODIFICACIONEQBuscar = new JTextField();
		txtMODIFICACIONEQBuscar.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				borrarTextField(txtMODIFICACIONEQBuscar, "Buscar...");
			}

			@Override
			public void focusLost(FocusEvent e) {
				borrarTextField(txtMODIFICACIONEQBuscar, "Buscar...");
			}
		});
		txtMODIFICACIONEQBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Cuenta las filas de la tabla, si hay filas las borra para
				// iniciar otra búsqueda.
				int filas = tableMODIFICACIONEQ.getRowCount();
				if (filas > 0) {
					borrarTabla(tableMODIFICACIONEQ, filas);
				}
				// Llama al controlador para iniciar la búsqueda.
				controlador.buscarEQUIPO("pestanaMOD");
			}
		});
		txtMODIFICACIONEQBuscar.setForeground(Color.LIGHT_GRAY);
		txtMODIFICACIONEQBuscar.setText("Buscar...");
		txtMODIFICACIONEQBuscar.setColumns(10);

		btnMODIFICACIONEQModificar = new JButton("Modificar Equipo");
		btnMODIFICACIONEQModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (tableMODIFICACIONEQ.getSelectedRow() != -1) {
					setDatosEquipoModif();
					int filas = tableMODIFICACIONEQ.getRowCount();
					if (filas > 0) {
						borrarTabla(tableMODIFICACIONEQ, filas);
					}
					controlador.solicitaRellenarTablaEq("pestanaMEQ");
				} else {
					mensEquipoNoSelec();
				}
			}
		});

		btnMODIFICACIONEQEliminar = new JButton("Eliminar Equipo");
		btnMODIFICACIONEQEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (tableMODIFICACIONEQ.getSelectedRow() != -1) {
					controlador.eliminarEquipoConfirm();
					int filas = tableMODIFICACIONEQ.getRowCount();
					if (filas > 0) {
						borrarTabla(tableMODIFICACIONEQ, filas);
					}
					controlador.solicitaRellenarTablaEq("pestanaMEQ");
				} else {
					mensEquipoNoSelec();
				}
			}
		});

		textFieldMODIFICACIONEQProcesador = new JTextField();
		textFieldMODIFICACIONEQProcesador.setColumns(10);

		textFieldMODIFICACIONEQRam = new JTextField();
		textFieldMODIFICACIONEQRam.setColumns(10);

		textFieldMODIFICACIONEQHDD = new JTextField();
		textFieldMODIFICACIONEQHDD.setColumns(10);

		textFieldMODIFICACIONEQGrafica = new JTextField();
		textFieldMODIFICACIONEQGrafica.setColumns(10);

		textFieldMODIFICACIONEQSSOO = new JTextField();
		textFieldMODIFICACIONEQSSOO.setColumns(10);

		lblMODIFICACIONEQProcesador = new JLabel("Procesador:");

		lblMODIFICACIONEQRam = new JLabel("Memoria RAM:");

		lblMODIFICACIONEQHDD = new JLabel("Disco Duro:");

		lblMODIFICACIONEQGrafica = new JLabel("Tarjeta Gr\u00E1fica:");

		lblMODIFICACIONEQSSOO = new JLabel("Sistema Operativo:");

		lblMODIFICACIONEQNmeroDeArmario = new JLabel("N\u00FAmero de Armario:");

		comboBoxMODIFICACIONEQArmario = new JComboBox<String>();
		comboBoxMODIFICACIONEQArmario
				.setModel(new DefaultComboBoxModel<String>(new String[] {
						"Armario 1", "Armario 2", "Armario 3" }));

		chckbxMODIFICACIONEQSSD = new JCheckBox("SSD");

		comboBoxMODIFICACIONEQComp = new JComboBox<String>();
		comboBoxMODIFICACIONEQComp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Cuenta las filas de la tabla, si hay filas las borra para
				// iniciar otra búsqueda.
				int filas = tableMODIFICACIONEQ.getRowCount();
				if (filas > 0) {
					borrarTabla(tableMODIFICACIONEQ, filas);
				}
				// Llama al controlador para iniciar la búsqueda.
				controlador.buscarEQUIPO("pestanaMOD");
			}
		});
		comboBoxMODIFICACIONEQComp.setModel(new DefaultComboBoxModel<String>(
				new String[] { "Procesador", "RAM", "Disco Duro",
						"Gr\u00E1fica", "SSOO", "Todo" }));

		comboBoxMODIFICACIONEQCat = new JComboBox<String>();
		comboBoxMODIFICACIONEQCat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Cuenta las filas de la tabla, si hay filas las borra para
				// iniciar otra búsqueda.
				int filas = tableMODIFICACIONEQ.getRowCount();
				if (filas > 0) {
					borrarTabla(tableMODIFICACIONEQ, filas);
				}
				// Llama al controlador para iniciar la búsqueda.
				controlador.buscarEQUIPO("pestanaMOD");
			}
		});
		comboBoxMODIFICACIONEQCat.setModel(new DefaultComboBoxModel<String>(
				new String[] { "Portatil", "Servidor", "Sobremesa", "Todo" }));

		tableMODIFICACIONEQ = new JTable(model);
		tableMODIFICACIONEQ.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				rellenarFormulario();
			}
		});

		tableMODIFICACIONEQ.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				rellenarFormulario();
			}
		});

		tableMODIFICACIONEQ.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "ID", "Procesador", "Memoria", "Disco Duro",
						"SSD", "Tarjeta Gr\u00E1fica", "SSOO" }

				) {
					boolean[] columnEditables = new boolean[] {
						false, false, false, false, false, false, false
					};
					public boolean isCellEditable(int row, int column) {
						return columnEditables[column];
					}
				});
		scrollPaneMODIFICACIONEQ.setViewportView(tableMODIFICACIONEQ);
		//
		// <----------------------------PESTANA_MODIFICACION_USUARIO-------------------------------->
		//
		pestanaModificacionUsuario = new JPanel();
		panelPestanas.addTab("Modificaci\u00F3n Usuario", null,
				pestanaModificacionUsuario, null);

		lblMODIFICACIONUSRDatosDelUsuario = new JLabel(
				"Datos del usuario a modificar:");
		lblMODIFICACIONUSRDatosDelUsuario.setFont(new Font("Tahoma", Font.BOLD,
				14));

		lblMODIFICACIONUSRDNI = new JLabel("DNI:");

		lblMODIFICACIONUSRUsuario = new JLabel("Usuario:");

		lblMODIFICACIONUSRNombreYApellidos = new JLabel("Nombre y Apellidos:");

		lblMODIFICACIONUSREmail = new JLabel("Email:");

		lblMODIFICACIONUSRFechaDeNaciemiento = new JLabel(
				"Fecha de Naciemiento:");

		lblMODIFICACIONUSRSexo = new JLabel("Sexo:");

		txtMODIFICACIONUSRDNI = new JTextField();
		txtMODIFICACIONUSRDNI.setColumns(10);

		txtMODIFICACIONUSRUsuario = new JTextField();
		txtMODIFICACIONUSRUsuario.setColumns(10);

		txtMODIFICACIONUSRNombre = new JTextField();
		txtMODIFICACIONUSRNombre.setColumns(10);

		comboBoxMODIFICACIONUSRSexo = new JComboBox<String>();
		comboBoxMODIFICACIONUSRSexo.setModel(new DefaultComboBoxModel<String>(
				new String[] { "Masculino", "Femenino" }));

		btnMODIFICACIONUSREliminarUsuario = new JButton("Eliminar Usuario");
		btnMODIFICACIONUSREliminarUsuario
				.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						enviarDatosFormularioMU(1);
						int filas = tableMODIFICACIONUSR.getRowCount();
						borrarTabla(tableMODIFICACIONUSR, filas);
						controlador.solicitaRellenarTablaMU();
					}
				});

		btnMODIFICACIONUSRConfirmarModificacion = new JButton(
				"Modificar Usuario");
		btnMODIFICACIONUSRConfirmarModificacion
				.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						enviarDatosFormularioMU(2);
						int filas = tableMODIFICACIONUSR.getRowCount();
						borrarTabla(tableMODIFICACIONUSR, filas);
						controlador.solicitaRellenarTablaMU();
					}
				});

		txtMODIFICACIONUSREmail = new JTextField();
		txtMODIFICACIONUSREmail.setColumns(10);

		btnMODIFICACIONUSRNuevoUsuario = new JButton("Nuevo Usuario");
		btnMODIFICACIONUSRNuevoUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				enviarDatosFormularioMU(3);
				int filas = tableMODIFICACIONUSR.getRowCount();
				borrarTabla(tableMODIFICACIONUSR, filas);
				controlador.solicitaRellenarTablaMU();
			}
		});

		comboBoxMODIFICACIONUSRDia = new JComboBox<String>();
		comboBoxMODIFICACIONUSRDia.setModel(new DefaultComboBoxModel<String>(
				new String[] { "1", "2", "3", "4", "5", " 6", "7", "8", "9",
						" 10", " 11", "12", "13", " 14", "15", "16", "17",
						"18", "19", "20", "21", "22", "23", "24", "25", "26",
						"27", "28", "29", "30", "31" }));

		comboBoxMODIFICACIONUSRMes = new JComboBox<String>();
		comboBoxMODIFICACIONUSRMes.setModel(new DefaultComboBoxModel<String>(
				new String[] { "Enero", "Febrero", "Marzo", "Abril", "Mayo",
						"Junio", "Julio", "Agosto", "Septiembre", "Octubre",
						"Noviembre", "Diciembre" }));

		comboBoxMODIFICACIONUSRAnio = new JComboBox<String>();
		comboBoxMODIFICACIONUSRAnio.setModel(new DefaultComboBoxModel<String>(
				new String[] { "2015", "2014", "2013", "2012", "2011", "2010",
						"2009", "2008", "2007", "2006", "2005", "2004", "2003",
						"2002", "2001", "2000", "1999", "1998", "1997", "1996",
						"1995", "1994", "1993", "1992", "1991", "1990", "1989",
						"1988", "1987", "1986", "1985", "1984", "1983", "1982",
						"1981", "1980", "1979", "1978", "1977", "1976", "1975",
						"1974", "1973", "1972", "1971", "1970", "1969", "1968",
						"1967", "1966", "1965", "1964", "1963", "1962", "1961",
						"1960", "1959", "1958", "1957", "1956", "1955", "1954",
						"1953", "1952", "1951", "1950", "1949", "1948", "1947",
						"1946", "1945", "1944", "1943", "1942", "1941", "1940",
						"1939", "1938", "1937", "1936", "1935", "1934", "1933",
						"1932", "1931", "1930", "1929", "1928", "1927", "1926",
						"1925", "1924", "1923", "1922", "1921", "1920", "1919",
						"1918", "1917", "1916", "1915", "1914", "1913", "1912",
						"1911", "1910" }));

		lblMODIFICACIONUSRUsuarioExistente = new JLabel("Usuario existentes:");
		lblMODIFICACIONUSRUsuarioExistente.setFont(new Font("Tahoma",
				Font.BOLD, 14));

		scrollPaneMODIFICACIONUSR = new JScrollPane();

		txtMODIFICACIONUSRBuscar = new JTextField();
		txtMODIFICACIONUSRBuscar.addFocusListener(new FocusAdapter() {
			public void focusGained(FocusEvent e) {
				if (comboBoxMODIFICACIONUSRBusqueda.getSelectedItem().equals(
						"Email")) {
					borrarTextField(txtMODIFICACIONUSRBuscar,
							"Escriba el Email");
				} else if (comboBoxMODIFICACIONUSRBusqueda.getSelectedItem()
						.equals("DNI")) {
					borrarTextField(txtMODIFICACIONUSRBuscar, "Escriba el DNI");
				} else {
					borrarTextField(txtMODIFICACIONUSRBuscar,
							"Escriba el Nombre");
				}
			}

			public void focusLost(FocusEvent e) {
				if (comboBoxMODIFICACIONUSRBusqueda.getSelectedItem().equals(
						"Email")) {
					borrarTextField(txtMODIFICACIONUSRBuscar,
							"Escriba el Email");
				} else if (comboBoxMODIFICACIONUSRBusqueda.getSelectedItem()
						.equals("DNI")) {
					borrarTextField(txtMODIFICACIONUSRBuscar, "Escriba el DNI");
				} else {
					borrarTextField(txtMODIFICACIONUSRBuscar,
							"Escriba el Nombre");
				}
			}
		});
		txtMODIFICACIONUSRBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controlador.buscarUSUARIOModif("pestanaMODU");
			}
		});
		txtMODIFICACIONUSRBuscar.setForeground(Color.LIGHT_GRAY);
		txtMODIFICACIONUSRBuscar.setText("Escriba el DNI");
		txtMODIFICACIONUSRBuscar.setColumns(10);

		btnMODIFICACIONUSRBuscar = new JButton("");
		btnMODIFICACIONUSRBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controlador.buscarUSUARIOModif("pestanaMODU");
			}
		});
		btnMODIFICACIONUSRBuscar.setIcon(new ImageIcon(VistaImplLogin.class
				.getResource("/pictures/lupa_16px.png")));

		comboBoxMODIFICACIONUSRBusqueda = new JComboBox<String>();
		comboBoxMODIFICACIONUSRBusqueda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (comboBoxMODIFICACIONUSRBusqueda.getSelectedItem().equals(
						"Email")) {
					txtMODIFICACIONUSRBuscar.setText("Escriba el Email");
					txtMODIFICACIONUSRBuscar.setForeground(Color.LIGHT_GRAY);
				} else if (comboBoxMODIFICACIONUSRBusqueda.getSelectedItem()
						.equals("DNI")) {
					txtMODIFICACIONUSRBuscar.setText("Escriba el DNI");
					txtMODIFICACIONUSRBuscar.setForeground(Color.LIGHT_GRAY);
				} else {
					txtMODIFICACIONUSRBuscar.setText("Escriba el Nombre");
					txtMODIFICACIONUSRBuscar.setForeground(Color.LIGHT_GRAY);
				}
			}
		});
		comboBoxMODIFICACIONUSRBusqueda
				.setModel(new DefaultComboBoxModel<String>(new String[] {
						"DNI", "Email", "Nombre" }));

		tableMODIFICACIONUSR = new JTable(model);
		tableMODIFICACIONUSR.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "DNI", "Nick", "Nombre y Apellidos", "Email",
						"Fecha de Nacimiento", "Sexo" }

				) {
					boolean[] columnEditables = new boolean[] {
						false, false, false, false, false, false, false
					};
					public boolean isCellEditable(int row, int column) {
						return columnEditables[column];
					}
				});
		tableMODIFICACIONUSR.getColumnModel().getColumn(0)
				.setPreferredWidth(50);
		tableMODIFICACIONUSR.getColumnModel().getColumn(1)
				.setPreferredWidth(55);
		tableMODIFICACIONUSR.getColumnModel().getColumn(2)
				.setPreferredWidth(117);
		tableMODIFICACIONUSR.getColumnModel().getColumn(3)
				.setPreferredWidth(117);
		tableMODIFICACIONUSR.getColumnModel().getColumn(4)
				.setPreferredWidth(96);
		tableMODIFICACIONUSR.getColumnModel().getColumn(5)
				.setPreferredWidth(20);

		tableMODIFICACIONUSR.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				enviarDatosTablaMU();
			}
		});

		tableMODIFICACIONUSR.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				enviarDatosTablaMU();
			}
		});

		scrollPaneMODIFICACIONUSR.setViewportView(tableMODIFICACIONUSR);

		JLabel lblLogo = new JLabel("");
		lblLogo.setIcon(new ImageIcon(VistaImplLogin.class
				.getResource("/pictures/U-Inventory_x128.png")));

		lblCreatedBy = new JLabel("Created by:");
		lblCreatedBy.setForeground(new Color(28, 62, 81));
		lblCreatedBy.setFont(new Font("Arial Black", Font.BOLD, 11));

		lblJosManuelCondes = new JLabel("Jos\u00E9 Manuel Condes");
		lblJosManuelCondes.setForeground(new Color(28, 62, 81));
		lblJosManuelCondes.setFont(new Font("Arial Black", Font.PLAIN, 11));

		lblMiguelJimnez = new JLabel("Miguel Jim\u00E9nez");
		lblMiguelJimnez.setForeground(new Color(28, 62, 81));
		lblMiguelJimnez.setFont(new Font("Arial Black", Font.PLAIN, 11));

		lblDavidNavarro = new JLabel("David Navarro");
		lblDavidNavarro.setForeground(new Color(28, 62, 81));
		lblDavidNavarro.setFont(new Font("Arial Black", Font.PLAIN, 11));
		//
		// <------------------------------>Grupos_y_ordenacion_en_la_ventana<------------------------------>
		//
		// GRUPO INICIO
		//
		gl_pestanaInicio = new GroupLayout(pestanaInicio);
		gl_pestanaInicio
				.setHorizontalGroup(gl_pestanaInicio
						.createParallelGroup(Alignment.TRAILING)
						.addGroup(
								gl_pestanaInicio
										.createSequentialGroup()
										.addContainerGap()
										.addGroup(
												gl_pestanaInicio
														.createParallelGroup(
																Alignment.LEADING)
														.addGroup(
																gl_pestanaInicio
																		.createSequentialGroup()
																		.addGroup(
																				gl_pestanaInicio
																						.createParallelGroup(
																								Alignment.LEADING)
																						.addGroup(
																								gl_pestanaInicio
																										.createSequentialGroup()
																										.addGap(10)
																										.addGroup(
																												gl_pestanaInicio
																														.createParallelGroup(
																																Alignment.LEADING)
																														.addComponent(
																																lblDavidNavarro)
																														.addComponent(
																																lblMiguelJimnez)
																														.addComponent(
																																lblJosManuelCondes)
																														.addComponent(
																																lblCreatedBy)))
																						.addComponent(
																								lblLogo))
																		.addPreferredGap(
																				ComponentPlacement.RELATED)
																		.addComponent(
																				scrollPaneINICIO,
																				GroupLayout.DEFAULT_SIZE,
																				489,
																				Short.MAX_VALUE))
														.addComponent(
																lblINICIODevolucionesPendientes)
														.addGroup(
																gl_pestanaInicio
																		.createSequentialGroup()
																		.addComponent(
																				btnConfiguracinInicio)
																		.addPreferredGap(
																				ComponentPlacement.RELATED,
																				401,
																				Short.MAX_VALUE)
																		.addComponent(
																				btnINICIOCerrarSesion)))
										.addContainerGap()));
		gl_pestanaInicio
				.setVerticalGroup(gl_pestanaInicio
						.createParallelGroup(Alignment.LEADING)
						.addGroup(
								gl_pestanaInicio
										.createSequentialGroup()
										.addContainerGap()
										.addComponent(
												lblINICIODevolucionesPendientes)
										.addGroup(
												gl_pestanaInicio
														.createParallelGroup(
																Alignment.TRAILING)
														.addGroup(
																gl_pestanaInicio
																		.createSequentialGroup()
																		.addGap(52)
																		.addComponent(
																				lblLogo)
																		.addPreferredGap(
																				ComponentPlacement.RELATED,
																				57,
																				Short.MAX_VALUE)
																		.addComponent(
																				lblCreatedBy)
																		.addGap(18)
																		.addComponent(
																				lblJosManuelCondes)
																		.addGap(18)
																		.addComponent(
																				lblMiguelJimnez)
																		.addGap(18)
																		.addComponent(
																				lblDavidNavarro)
																		.addGap(21))
														.addGroup(
																gl_pestanaInicio
																		.createSequentialGroup()
																		.addPreferredGap(
																				ComponentPlacement.UNRELATED)
																		.addComponent(
																				scrollPaneINICIO,
																				GroupLayout.DEFAULT_SIZE,
																				363,
																				Short.MAX_VALUE)
																		.addPreferredGap(
																				ComponentPlacement.RELATED)))
										.addGroup(
												gl_pestanaInicio
														.createParallelGroup(
																Alignment.BASELINE)
														.addComponent(
																btnINICIOCerrarSesion)
														.addComponent(
																btnConfiguracinInicio))
										.addContainerGap()));
		pestanaInicio.setLayout(gl_pestanaInicio);

		//
		// GRUPO RESERVA EQUIPO
		//
		gl_pestanaReserva = new GroupLayout(pestanaReserva);
		gl_pestanaReserva
				.setHorizontalGroup(gl_pestanaReserva
						.createParallelGroup(Alignment.LEADING)
						.addGroup(
								gl_pestanaReserva
										.createSequentialGroup()
										.addContainerGap()
										.addGroup(
												gl_pestanaReserva
														.createParallelGroup(
																Alignment.TRAILING)
														.addComponent(
																scrollPaneRESERVA,
																GroupLayout.DEFAULT_SIZE,
																625,
																Short.MAX_VALUE)
														.addGroup(
																gl_pestanaReserva
																		.createSequentialGroup()
																		.addComponent(
																				comboBoxRESERVAEquipo,
																				GroupLayout.PREFERRED_SIZE,
																				GroupLayout.DEFAULT_SIZE,
																				GroupLayout.PREFERRED_SIZE)
																		.addPreferredGap(
																				ComponentPlacement.RELATED,
																				330,
																				Short.MAX_VALUE)
																		.addComponent(
																				comboBoxRESERVABusqueda,
																				GroupLayout.PREFERRED_SIZE,
																				GroupLayout.DEFAULT_SIZE,
																				GroupLayout.PREFERRED_SIZE)
																		.addPreferredGap(
																				ComponentPlacement.RELATED)
																		.addComponent(
																				txtRESERVABuscar,
																				GroupLayout.PREFERRED_SIZE,
																				106,
																				GroupLayout.PREFERRED_SIZE)
																		.addPreferredGap(
																				ComponentPlacement.RELATED)
																		.addComponent(
																				btnRESERVABuscar,
																				GroupLayout.PREFERRED_SIZE,
																				20,
																				GroupLayout.PREFERRED_SIZE))
														.addGroup(
																gl_pestanaReserva
																		.createSequentialGroup()
																		.addComponent(
																				comboBoxRESERVAUsuario,
																				GroupLayout.PREFERRED_SIZE,
																				GroupLayout.DEFAULT_SIZE,
																				GroupLayout.PREFERRED_SIZE)
																		.addPreferredGap(
																				ComponentPlacement.RELATED)
																		.addComponent(
																				txtRESERVADNI,
																				GroupLayout.DEFAULT_SIZE,
																				221,
																				Short.MAX_VALUE)
																		.addPreferredGap(
																				ComponentPlacement.RELATED)
																		.addComponent(
																				btnRESERVARDNIBuscar,
																				GroupLayout.PREFERRED_SIZE,
																				20,
																				GroupLayout.PREFERRED_SIZE)
																		.addGap(26)
																		.addComponent(
																				txtRESERVANombre,
																				GroupLayout.PREFERRED_SIZE,
																				297,
																				GroupLayout.PREFERRED_SIZE))
														.addComponent(
																btnRESERVAConfirmar)
														.addComponent(
																lblRESERVAUsuario,
																GroupLayout.DEFAULT_SIZE,
																625,
																Short.MAX_VALUE))
										.addContainerGap()));
		gl_pestanaReserva
				.setVerticalGroup(gl_pestanaReserva
						.createParallelGroup(Alignment.LEADING)
						.addGroup(
								gl_pestanaReserva
										.createSequentialGroup()
										.addContainerGap()
										.addGroup(
												gl_pestanaReserva
														.createParallelGroup(
																Alignment.LEADING)
														.addComponent(
																comboBoxRESERVAEquipo,
																GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE)
														.addGroup(
																gl_pestanaReserva
																		.createParallelGroup(
																				Alignment.BASELINE)
																		.addComponent(
																				txtRESERVABuscar,
																				GroupLayout.PREFERRED_SIZE,
																				GroupLayout.DEFAULT_SIZE,
																				GroupLayout.PREFERRED_SIZE)
																		.addComponent(
																				comboBoxRESERVABusqueda,
																				GroupLayout.PREFERRED_SIZE,
																				GroupLayout.DEFAULT_SIZE,
																				GroupLayout.PREFERRED_SIZE))
														.addComponent(
																btnRESERVABuscar,
																GroupLayout.PREFERRED_SIZE,
																20,
																GroupLayout.PREFERRED_SIZE))
										.addPreferredGap(
												ComponentPlacement.RELATED)
										.addComponent(scrollPaneRESERVA,
												GroupLayout.PREFERRED_SIZE,
												263, GroupLayout.PREFERRED_SIZE)
										.addGap(25)
										.addComponent(lblRESERVAUsuario,
												GroupLayout.PREFERRED_SIZE, 17,
												GroupLayout.PREFERRED_SIZE)
										.addGap(18)
										.addGroup(
												gl_pestanaReserva
														.createParallelGroup(
																Alignment.LEADING)
														.addGroup(
																gl_pestanaReserva
																		.createSequentialGroup()
																		.addComponent(
																				txtRESERVANombre,
																				GroupLayout.PREFERRED_SIZE,
																				GroupLayout.DEFAULT_SIZE,
																				GroupLayout.PREFERRED_SIZE)
																		.addPreferredGap(
																				ComponentPlacement.RELATED,
																				29,
																				Short.MAX_VALUE)
																		.addComponent(
																				btnRESERVAConfirmar))
														.addGroup(
																gl_pestanaReserva
																		.createParallelGroup(
																				Alignment.BASELINE)
																		.addComponent(
																				comboBoxRESERVAUsuario,
																				GroupLayout.PREFERRED_SIZE,
																				GroupLayout.DEFAULT_SIZE,
																				GroupLayout.PREFERRED_SIZE)
																		.addComponent(
																				txtRESERVADNI,
																				GroupLayout.PREFERRED_SIZE,
																				GroupLayout.DEFAULT_SIZE,
																				GroupLayout.PREFERRED_SIZE))
														.addComponent(
																btnRESERVARDNIBuscar,
																GroupLayout.PREFERRED_SIZE,
																20,
																GroupLayout.PREFERRED_SIZE))
										.addContainerGap()));

		pestanaReserva.setLayout(gl_pestanaReserva);

		//
		// GRUPO DEVOLUCION EQUIPO
		//
		gl_pestanaDevolucion = new GroupLayout(pestanaDevolucion);
		gl_pestanaDevolucion
				.setHorizontalGroup(gl_pestanaDevolucion
						.createParallelGroup(Alignment.LEADING)
						.addGroup(
								gl_pestanaDevolucion
										.createSequentialGroup()
										.addContainerGap()
										.addGroup(
												gl_pestanaDevolucion
														.createParallelGroup(
																Alignment.LEADING)
														.addGroup(
																gl_pestanaDevolucion
																		.createParallelGroup(
																				Alignment.LEADING)
																		.addGroup(
																				gl_pestanaDevolucion
																						.createSequentialGroup()
																						.addGroup(
																								gl_pestanaDevolucion
																										.createParallelGroup(
																												Alignment.LEADING)
																										.addComponent(
																												lblDEVOLUCIONDatosUsuario,
																												GroupLayout.DEFAULT_SIZE,
																												625,
																												Short.MAX_VALUE)
																										.addGroup(
																												gl_pestanaDevolucion
																														.createSequentialGroup()
																														.addGap(8)
																														.addGroup(
																																gl_pestanaDevolucion
																																		.createParallelGroup(
																																				Alignment.LEADING)
																																		.addGroup(
																																				gl_pestanaDevolucion
																																						.createSequentialGroup()
																																						.addComponent(
																																								btnMOSTRARReservas)
																																						.addGap(18)
																																						.addComponent(
																																								comboBoxDEVOLUCIONRes,
																																								GroupLayout.PREFERRED_SIZE,
																																								GroupLayout.DEFAULT_SIZE,
																																								GroupLayout.PREFERRED_SIZE))
																																		.addGroup(
																																				gl_pestanaDevolucion
																																						.createSequentialGroup()
																																						.addComponent(
																																								comboBoxDEVOLUCIONUsuario,
																																								GroupLayout.PREFERRED_SIZE,
																																								GroupLayout.DEFAULT_SIZE,
																																								GroupLayout.PREFERRED_SIZE)
																																						.addPreferredGap(
																																								ComponentPlacement.UNRELATED)
																																						.addComponent(
																																								txtDEVOLUCIONDNI,
																																								GroupLayout.DEFAULT_SIZE,
																																								228,
																																								Short.MAX_VALUE)
																																						.addPreferredGap(
																																								ComponentPlacement.RELATED)
																																						.addComponent(
																																								btnDEVOLUCIONDNIBuscar,
																																								GroupLayout.PREFERRED_SIZE,
																																								20,
																																								GroupLayout.PREFERRED_SIZE)
																																						.addGap(22)
																																						.addComponent(
																																								txtDEVOLUCIONNombre,
																																								GroupLayout.PREFERRED_SIZE,
																																								282,
																																								GroupLayout.PREFERRED_SIZE)))))
																						.addContainerGap())
																		.addGroup(
																				Alignment.TRAILING,
																				gl_pestanaDevolucion
																						.createSequentialGroup()
																						.addComponent(
																								scrollPaneDEVOLUCION,
																								GroupLayout.PREFERRED_SIZE,
																								615,
																								GroupLayout.PREFERRED_SIZE)
																						.addContainerGap()))
														.addGroup(
																Alignment.TRAILING,
																gl_pestanaDevolucion
																		.createSequentialGroup()
																		.addComponent(
																				btnDEVOLUCIONDevolverEquipo)
																		.addContainerGap()))));
		gl_pestanaDevolucion
				.setVerticalGroup(gl_pestanaDevolucion
						.createParallelGroup(Alignment.LEADING)
						.addGroup(
								gl_pestanaDevolucion
										.createSequentialGroup()
										.addContainerGap()
										.addComponent(
												lblDEVOLUCIONDatosUsuario,
												GroupLayout.PREFERRED_SIZE, 17,
												GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(
												ComponentPlacement.RELATED)
										.addGroup(
												gl_pestanaDevolucion
														.createParallelGroup(
																Alignment.LEADING)
														.addGroup(
																gl_pestanaDevolucion
																		.createSequentialGroup()
																		.addGroup(
																				gl_pestanaDevolucion
																						.createParallelGroup(
																								Alignment.BASELINE)
																						.addComponent(
																								txtDEVOLUCIONDNI,
																								GroupLayout.PREFERRED_SIZE,
																								GroupLayout.DEFAULT_SIZE,
																								GroupLayout.PREFERRED_SIZE)
																						.addComponent(
																								btnDEVOLUCIONDNIBuscar,
																								GroupLayout.PREFERRED_SIZE,
																								20,
																								GroupLayout.PREFERRED_SIZE)
																						.addComponent(
																								comboBoxDEVOLUCIONUsuario,
																								GroupLayout.PREFERRED_SIZE,
																								GroupLayout.DEFAULT_SIZE,
																								GroupLayout.PREFERRED_SIZE))
																		.addGap(18)
																		.addGroup(
																				gl_pestanaDevolucion
																						.createParallelGroup(
																								Alignment.BASELINE)
																						.addComponent(
																								btnMOSTRARReservas)
																						.addComponent(
																								comboBoxDEVOLUCIONRes,
																								GroupLayout.PREFERRED_SIZE,
																								GroupLayout.DEFAULT_SIZE,
																								GroupLayout.PREFERRED_SIZE)))
														.addComponent(
																txtDEVOLUCIONNombre,
																GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE))
										.addPreferredGap(
												ComponentPlacement.UNRELATED)
										.addComponent(scrollPaneDEVOLUCION,
												GroupLayout.DEFAULT_SIZE, 292,
												Short.MAX_VALUE)
										.addPreferredGap(
												ComponentPlacement.UNRELATED)
										.addComponent(
												btnDEVOLUCIONDevolverEquipo)
										.addContainerGap()));
		pestanaDevolucion.setLayout(gl_pestanaDevolucion);

		scrollPane = new JScrollPane();

		//
		// GRUPO ALTA EQUIPO
		//
		gl_pestanaAlta = new GroupLayout(pestanaAlta);
		gl_pestanaAlta
				.setHorizontalGroup(gl_pestanaAlta
						.createParallelGroup(Alignment.LEADING)
						.addGroup(
								gl_pestanaAlta
										.createSequentialGroup()
										.addContainerGap()
										.addGroup(
												gl_pestanaAlta
														.createParallelGroup(
																Alignment.TRAILING)
														.addComponent(
																lblALTADatosNuevos,
																Alignment.LEADING,
																GroupLayout.PREFERRED_SIZE,
																621,
																GroupLayout.PREFERRED_SIZE)
														.addGroup(
																gl_pestanaAlta
																		.createSequentialGroup()
																		.addGap(12)
																		.addGroup(
																				gl_pestanaAlta
																						.createParallelGroup(
																								Alignment.LEADING)
																						.addComponent(
																								lblALTAProcesador)
																						.addComponent(
																								lblALTAMemoriaRam)
																						.addComponent(
																								lblALTADiscoDuro)
																						.addComponent(
																								lblALTATarjetaGrfica)
																						.addComponent(
																								lblALTASistemaOperativo)
																						.addComponent(
																								lblALTANmeroDeArmario)
																						.addComponent(
																								lblALTACategoria,
																								GroupLayout.PREFERRED_SIZE,
																								62,
																								GroupLayout.PREFERRED_SIZE)
																						.addComponent(
																								lblALTAObservaciones,
																								GroupLayout.PREFERRED_SIZE,
																								96,
																								GroupLayout.PREFERRED_SIZE))
																		.addGap(24)
																		.addGroup(
																				gl_pestanaAlta
																						.createParallelGroup(
																								Alignment.LEADING)
																						.addGroup(
																								gl_pestanaAlta
																										.createSequentialGroup()
																										.addPreferredGap(
																												ComponentPlacement.RELATED)
																										.addGroup(
																												gl_pestanaAlta
																														.createParallelGroup(
																																Alignment.TRAILING,
																																false)
																														.addComponent(
																																txtALTAProcesador,
																																Alignment.LEADING)
																														.addComponent(
																																txtALTARAM,
																																Alignment.LEADING)
																														.addGroup(
																																Alignment.LEADING,
																																gl_pestanaAlta
																																		.createSequentialGroup()
																																		.addComponent(
																																				txtALTAHDD,
																																				GroupLayout.PREFERRED_SIZE,
																																				212,
																																				GroupLayout.PREFERRED_SIZE)
																																		.addPreferredGap(
																																				ComponentPlacement.RELATED)
																																		.addComponent(
																																				chckbxALTASsd))
																														.addComponent(
																																txtALTAGrafica,
																																Alignment.LEADING,
																																GroupLayout.DEFAULT_SIZE,
																																341,
																																Short.MAX_VALUE)
																														.addComponent(
																																txtALTASSOO)
																														.addGroup(
																																Alignment.LEADING,
																																gl_pestanaAlta
																																		.createParallelGroup(
																																				Alignment.TRAILING,
																																				false)
																																		.addComponent(
																																				comboBoxALTACategoria,
																																				Alignment.LEADING,
																																				0,
																																				0,
																																				Short.MAX_VALUE)
																																		.addComponent(
																																				comboBoxALTAArmario,
																																				Alignment.LEADING,
																																				0,
																																				GroupLayout.DEFAULT_SIZE,
																																				Short.MAX_VALUE))))
																						.addComponent(
																								scrollPane,
																								GroupLayout.PREFERRED_SIZE,
																								341,
																								GroupLayout.PREFERRED_SIZE)
																						.addGroup(
																								gl_pestanaAlta
																										.createSequentialGroup()
																										.addGap(120)
																										.addComponent(
																												btnALTAConfirmarAlta)))
																		.addGap(767)))
										.addContainerGap()));
		gl_pestanaAlta
				.setVerticalGroup(gl_pestanaAlta
						.createParallelGroup(Alignment.LEADING)
						.addGroup(
								gl_pestanaAlta
										.createSequentialGroup()
										.addContainerGap()
										.addComponent(lblALTADatosNuevos,
												GroupLayout.PREFERRED_SIZE, 17,
												GroupLayout.PREFERRED_SIZE)
										.addGap(18)
										.addGroup(
												gl_pestanaAlta
														.createParallelGroup(
																Alignment.LEADING)
														.addComponent(
																lblALTAProcesador)
														.addComponent(
																txtALTAProcesador,
																GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE))
										.addGap(18)
										.addGroup(
												gl_pestanaAlta
														.createParallelGroup(
																Alignment.LEADING)
														.addComponent(
																lblALTAMemoriaRam)
														.addComponent(
																txtALTARAM,
																GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE))
										.addGap(18)
										.addGroup(
												gl_pestanaAlta
														.createParallelGroup(
																Alignment.LEADING)
														.addComponent(
																lblALTADiscoDuro)
														.addGroup(
																gl_pestanaAlta
																		.createParallelGroup(
																				Alignment.BASELINE)
																		.addComponent(
																				txtALTAHDD,
																				GroupLayout.PREFERRED_SIZE,
																				GroupLayout.DEFAULT_SIZE,
																				GroupLayout.PREFERRED_SIZE)
																		.addComponent(
																				chckbxALTASsd)))
										.addGap(18)
										.addGroup(
												gl_pestanaAlta
														.createParallelGroup(
																Alignment.LEADING)
														.addComponent(
																lblALTATarjetaGrfica)
														.addComponent(
																txtALTAGrafica,
																GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE))
										.addGap(18)
										.addGroup(
												gl_pestanaAlta
														.createParallelGroup(
																Alignment.LEADING)
														.addComponent(
																lblALTASistemaOperativo)
														.addComponent(
																txtALTASSOO,
																GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE))
										.addGap(18)
										.addGroup(
												gl_pestanaAlta
														.createParallelGroup(
																Alignment.BASELINE)
														.addComponent(
																lblALTANmeroDeArmario)
														.addComponent(
																comboBoxALTAArmario,
																GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE))
										.addGap(18)
										.addGroup(
												gl_pestanaAlta
														.createParallelGroup(
																Alignment.BASELINE)
														.addComponent(
																lblALTACategoria)
														.addComponent(
																comboBoxALTACategoria,
																GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE))
										.addGap(18)
										.addGroup(
												gl_pestanaAlta
														.createParallelGroup(
																Alignment.LEADING)
														.addComponent(
																lblALTAObservaciones)
														.addGroup(
																gl_pestanaAlta
																		.createSequentialGroup()
																		.addComponent(
																				scrollPane,
																				GroupLayout.PREFERRED_SIZE,
																				63,
																				GroupLayout.PREFERRED_SIZE)
																		.addGap(18)
																		.addComponent(
																				btnALTAConfirmarAlta)))
										.addGap(31)));

		textAreaALTAObservaciones = new JTextArea();
		scrollPane.setViewportView(textAreaALTAObservaciones);
		pestanaAlta.setLayout(gl_pestanaAlta);

		//
		// GRUPO MODIFICACION EQUIPO
		//
		gl_pestanaModificacionEquipo = new GroupLayout(
				pestanaModificacionEquipo);
		gl_pestanaModificacionEquipo
				.setHorizontalGroup(gl_pestanaModificacionEquipo
						.createParallelGroup(Alignment.TRAILING)
						.addGroup(
								gl_pestanaModificacionEquipo
										.createSequentialGroup()
										.addContainerGap()
										.addGroup(
												gl_pestanaModificacionEquipo
														.createParallelGroup(
																Alignment.TRAILING)
														.addGroup(
																gl_pestanaModificacionEquipo
																		.createSequentialGroup()
																		.addGroup(
																				gl_pestanaModificacionEquipo
																						.createParallelGroup(
																								Alignment.TRAILING)
																						.addGroup(
																								gl_pestanaModificacionEquipo
																										.createSequentialGroup()
																										.addComponent(
																												lblMODIFICACIONEQEquiposExistentes,
																												GroupLayout.PREFERRED_SIZE,
																												171,
																												GroupLayout.PREFERRED_SIZE)
																										.addPreferredGap(
																												ComponentPlacement.RELATED,
																												131,
																												Short.MAX_VALUE)
																										.addComponent(
																												comboBoxMODIFICACIONEQCat,
																												GroupLayout.PREFERRED_SIZE,
																												79,
																												GroupLayout.PREFERRED_SIZE)
																										.addGap(18)
																										.addComponent(
																												comboBoxMODIFICACIONEQComp,
																												GroupLayout.PREFERRED_SIZE,
																												GroupLayout.DEFAULT_SIZE,
																												GroupLayout.PREFERRED_SIZE)
																										.addGap(14)
																										.addComponent(
																												txtMODIFICACIONEQBuscar,
																												GroupLayout.PREFERRED_SIZE,
																												107,
																												GroupLayout.PREFERRED_SIZE)
																										.addPreferredGap(
																												ComponentPlacement.RELATED)
																										.addComponent(
																												btnMODIFICACIONEQBuscar,
																												GroupLayout.PREFERRED_SIZE,
																												20,
																												GroupLayout.PREFERRED_SIZE))
																						.addGroup(
																								gl_pestanaModificacionEquipo
																										.createSequentialGroup()
																										.addComponent(
																												btnMODIFICACIONEQEliminar)
																										.addPreferredGap(
																												ComponentPlacement.RELATED,
																												381,
																												Short.MAX_VALUE)
																										.addComponent(
																												btnMODIFICACIONEQModificar))
																						.addComponent(
																								scrollPaneMODIFICACIONEQ,
																								GroupLayout.DEFAULT_SIZE,
																								625,
																								Short.MAX_VALUE))
																		.addContainerGap())
														.addGroup(
																gl_pestanaModificacionEquipo
																		.createSequentialGroup()
																		.addGroup(
																				gl_pestanaModificacionEquipo
																						.createParallelGroup(
																								Alignment.LEADING)
																						.addComponent(
																								lblMODIFICACIONEQProcesador)
																						.addComponent(
																								lblMODIFICACIONEQRam)
																						.addComponent(
																								lblMODIFICACIONEQHDD)
																						.addComponent(
																								lblMODIFICACIONEQGrafica)
																						.addComponent(
																								lblMODIFICACIONEQSSOO)
																						.addComponent(
																								lblMODIFICACIONEQNmeroDeArmario))
																		.addPreferredGap(
																				ComponentPlacement.RELATED,
																				59,
																				Short.MAX_VALUE)
																		.addGroup(
																				gl_pestanaModificacionEquipo
																						.createParallelGroup(
																								Alignment.TRAILING,
																								false)
																						.addGroup(
																								gl_pestanaModificacionEquipo
																										.createSequentialGroup()
																										.addComponent(
																												comboBoxMODIFICACIONEQArmario,
																												GroupLayout.PREFERRED_SIZE,
																												84,
																												GroupLayout.PREFERRED_SIZE)
																										.addContainerGap(
																												GroupLayout.DEFAULT_SIZE,
																												Short.MAX_VALUE))
																						.addGroup(
																								gl_pestanaModificacionEquipo
																										.createSequentialGroup()
																										.addGroup(
																												gl_pestanaModificacionEquipo
																														.createParallelGroup(
																																Alignment.LEADING,
																																false)
																														.addComponent(
																																textFieldMODIFICACIONEQRam)
																														.addComponent(
																																textFieldMODIFICACIONEQProcesador,
																																GroupLayout.DEFAULT_SIZE,
																																342,
																																Short.MAX_VALUE)
																														.addComponent(
																																textFieldMODIFICACIONEQGrafica)
																														.addComponent(
																																textFieldMODIFICACIONEQSSOO)
																														.addGroup(
																																gl_pestanaModificacionEquipo
																																		.createSequentialGroup()
																																		.addComponent(
																																				textFieldMODIFICACIONEQHDD,
																																				GroupLayout.PREFERRED_SIZE,
																																				209,
																																				GroupLayout.PREFERRED_SIZE)
																																		.addGap(18)
																																		.addComponent(
																																				chckbxMODIFICACIONEQSSD)))
																										.addGap(138)))))));
		gl_pestanaModificacionEquipo
				.setVerticalGroup(gl_pestanaModificacionEquipo
						.createParallelGroup(Alignment.TRAILING)
						.addGroup(
								gl_pestanaModificacionEquipo
										.createSequentialGroup()
										.addContainerGap()
										.addGroup(
												gl_pestanaModificacionEquipo
														.createParallelGroup(
																Alignment.LEADING)
														.addGroup(
																gl_pestanaModificacionEquipo
																		.createParallelGroup(
																				Alignment.BASELINE)
																		.addComponent(
																				lblMODIFICACIONEQEquiposExistentes,
																				GroupLayout.PREFERRED_SIZE,
																				17,
																				GroupLayout.PREFERRED_SIZE)
																		.addComponent(
																				txtMODIFICACIONEQBuscar,
																				GroupLayout.PREFERRED_SIZE,
																				GroupLayout.DEFAULT_SIZE,
																				GroupLayout.PREFERRED_SIZE)
																		.addComponent(
																				comboBoxMODIFICACIONEQComp,
																				GroupLayout.PREFERRED_SIZE,
																				GroupLayout.DEFAULT_SIZE,
																				GroupLayout.PREFERRED_SIZE)
																		.addComponent(
																				comboBoxMODIFICACIONEQCat,
																				GroupLayout.PREFERRED_SIZE,
																				GroupLayout.DEFAULT_SIZE,
																				GroupLayout.PREFERRED_SIZE))
														.addComponent(
																btnMODIFICACIONEQBuscar,
																GroupLayout.PREFERRED_SIZE,
																20,
																GroupLayout.PREFERRED_SIZE))
										.addPreferredGap(
												ComponentPlacement.RELATED)
										.addComponent(scrollPaneMODIFICACIONEQ,
												GroupLayout.PREFERRED_SIZE,
												146, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(
												ComponentPlacement.UNRELATED)
										.addGroup(
												gl_pestanaModificacionEquipo
														.createParallelGroup(
																Alignment.BASELINE)
														.addComponent(
																textFieldMODIFICACIONEQProcesador,
																GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE)
														.addComponent(
																lblMODIFICACIONEQProcesador))
										.addPreferredGap(
												ComponentPlacement.UNRELATED)
										.addGroup(
												gl_pestanaModificacionEquipo
														.createParallelGroup(
																Alignment.BASELINE)
														.addComponent(
																textFieldMODIFICACIONEQRam,
																GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE)
														.addComponent(
																lblMODIFICACIONEQRam))
										.addPreferredGap(
												ComponentPlacement.UNRELATED)
										.addGroup(
												gl_pestanaModificacionEquipo
														.createParallelGroup(
																Alignment.BASELINE)
														.addComponent(
																textFieldMODIFICACIONEQHDD,
																GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE)
														.addComponent(
																lblMODIFICACIONEQHDD)
														.addComponent(
																chckbxMODIFICACIONEQSSD))
										.addPreferredGap(
												ComponentPlacement.UNRELATED)
										.addGroup(
												gl_pestanaModificacionEquipo
														.createParallelGroup(
																Alignment.BASELINE)
														.addComponent(
																textFieldMODIFICACIONEQGrafica,
																GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE)
														.addComponent(
																lblMODIFICACIONEQGrafica))
										.addPreferredGap(
												ComponentPlacement.UNRELATED)
										.addGroup(
												gl_pestanaModificacionEquipo
														.createParallelGroup(
																Alignment.BASELINE)
														.addComponent(
																textFieldMODIFICACIONEQSSOO,
																GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE)
														.addComponent(
																lblMODIFICACIONEQSSOO))
										.addPreferredGap(
												ComponentPlacement.UNRELATED)
										.addGroup(
												gl_pestanaModificacionEquipo
														.createParallelGroup(
																Alignment.BASELINE)
														.addComponent(
																comboBoxMODIFICACIONEQArmario,
																GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE)
														.addComponent(
																lblMODIFICACIONEQNmeroDeArmario))
										.addPreferredGap(
												ComponentPlacement.RELATED, 40,
												Short.MAX_VALUE)
										.addGroup(
												gl_pestanaModificacionEquipo
														.createParallelGroup(
																Alignment.BASELINE)
														.addComponent(
																btnMODIFICACIONEQEliminar)
														.addComponent(
																btnMODIFICACIONEQModificar))
										.addContainerGap()));
		pestanaModificacionEquipo.setLayout(gl_pestanaModificacionEquipo);

		//
		// GRUPO MODIFICACION USUARIO
		//
		gl_pestanaModificacionUsuario = new GroupLayout(
				pestanaModificacionUsuario);
		gl_pestanaModificacionUsuario
				.setHorizontalGroup(gl_pestanaModificacionUsuario
						.createParallelGroup(Alignment.TRAILING)
						.addGroup(
								gl_pestanaModificacionUsuario
										.createSequentialGroup()
										.addContainerGap()
										.addGroup(
												gl_pestanaModificacionUsuario
														.createParallelGroup(
																Alignment.LEADING)
														.addComponent(
																scrollPaneMODIFICACIONUSR,
																GroupLayout.DEFAULT_SIZE,
																625,
																Short.MAX_VALUE)
														.addGroup(
																gl_pestanaModificacionUsuario
																		.createSequentialGroup()
																		.addGap(12)
																		.addGroup(
																				gl_pestanaModificacionUsuario
																						.createParallelGroup(
																								Alignment.LEADING)
																						.addComponent(
																								lblMODIFICACIONUSRSexo)
																						.addComponent(
																								lblMODIFICACIONUSREmail)
																						.addComponent(
																								lblMODIFICACIONUSRFechaDeNaciemiento)
																						.addComponent(
																								lblMODIFICACIONUSRNombreYApellidos)
																						.addComponent(
																								lblMODIFICACIONUSRDNI))
																		.addGap(24)
																		.addGroup(
																				gl_pestanaModificacionUsuario
																						.createParallelGroup(
																								Alignment.LEADING,
																								false)
																						.addGroup(
																								gl_pestanaModificacionUsuario
																										.createSequentialGroup()
																										.addGroup(
																												gl_pestanaModificacionUsuario
																														.createParallelGroup(
																																Alignment.LEADING,
																																false)
																														.addGroup(
																																gl_pestanaModificacionUsuario
																																		.createSequentialGroup()
																																		.addComponent(
																																				txtMODIFICACIONUSRDNI,
																																				GroupLayout.PREFERRED_SIZE,
																																				103,
																																				GroupLayout.PREFERRED_SIZE)
																																		.addPreferredGap(
																																				ComponentPlacement.RELATED,
																																				GroupLayout.DEFAULT_SIZE,
																																				Short.MAX_VALUE)
																																		.addComponent(
																																				lblMODIFICACIONUSRUsuario))
																														.addGroup(
																																gl_pestanaModificacionUsuario
																																		.createSequentialGroup()
																																		.addGroup(
																																				gl_pestanaModificacionUsuario
																																						.createParallelGroup(
																																								Alignment.LEADING)
																																						.addGroup(
																																								gl_pestanaModificacionUsuario
																																										.createSequentialGroup()
																																										.addComponent(
																																												comboBoxMODIFICACIONUSRDia,
																																												GroupLayout.PREFERRED_SIZE,
																																												GroupLayout.DEFAULT_SIZE,
																																												GroupLayout.PREFERRED_SIZE)
																																										.addGap(18)
																																										.addComponent(
																																												comboBoxMODIFICACIONUSRMes,
																																												GroupLayout.PREFERRED_SIZE,
																																												GroupLayout.DEFAULT_SIZE,
																																												GroupLayout.PREFERRED_SIZE))
																																						.addComponent(
																																								comboBoxMODIFICACIONUSRSexo,
																																								GroupLayout.PREFERRED_SIZE,
																																								GroupLayout.DEFAULT_SIZE,
																																								GroupLayout.PREFERRED_SIZE))
																																		.addGap(18)
																																		.addComponent(
																																				comboBoxMODIFICACIONUSRAnio,
																																				GroupLayout.PREFERRED_SIZE,
																																				GroupLayout.DEFAULT_SIZE,
																																				GroupLayout.PREFERRED_SIZE)))
																										.addGap(18)
																										.addComponent(
																												txtMODIFICACIONUSRUsuario))
																						.addComponent(
																								txtMODIFICACIONUSRNombre)
																						.addGroup(
																								gl_pestanaModificacionUsuario
																										.createSequentialGroup()
																										.addComponent(
																												txtMODIFICACIONUSREmail,
																												GroupLayout.PREFERRED_SIZE,
																												380,
																												GroupLayout.PREFERRED_SIZE)
																										.addPreferredGap(
																												ComponentPlacement.RELATED)))
																		.addPreferredGap(
																				ComponentPlacement.RELATED,
																				100,
																				Short.MAX_VALUE))
														.addComponent(
																lblMODIFICACIONUSRDatosDelUsuario,
																GroupLayout.PREFERRED_SIZE,
																353,
																GroupLayout.PREFERRED_SIZE)
														.addGroup(
																gl_pestanaModificacionUsuario
																		.createSequentialGroup()
																		.addComponent(
																				btnMODIFICACIONUSREliminarUsuario)
																		.addPreferredGap(
																				ComponentPlacement.RELATED,
																				151,
																				Short.MAX_VALUE)
																		.addComponent(
																				btnMODIFICACIONUSRNuevoUsuario)
																		.addGap(149)
																		.addComponent(
																				btnMODIFICACIONUSRConfirmarModificacion))
														.addGroup(
																gl_pestanaModificacionUsuario
																		.createSequentialGroup()
																		.addComponent(
																				lblMODIFICACIONUSRUsuarioExistente)
																		.addPreferredGap(
																				ComponentPlacement.RELATED,
																				215,
																				Short.MAX_VALUE)
																		.addComponent(
																				comboBoxMODIFICACIONUSRBusqueda,
																				GroupLayout.PREFERRED_SIZE,
																				GroupLayout.DEFAULT_SIZE,
																				GroupLayout.PREFERRED_SIZE)
																		.addPreferredGap(
																				ComponentPlacement.UNRELATED)
																		.addComponent(
																				txtMODIFICACIONUSRBuscar,
																				GroupLayout.PREFERRED_SIZE,
																				181,
																				GroupLayout.PREFERRED_SIZE)
																		.addPreferredGap(
																				ComponentPlacement.RELATED)
																		.addComponent(
																				btnMODIFICACIONUSRBuscar,
																				GroupLayout.PREFERRED_SIZE,
																				20,
																				GroupLayout.PREFERRED_SIZE)))
										.addContainerGap()));
		gl_pestanaModificacionUsuario
				.setVerticalGroup(gl_pestanaModificacionUsuario
						.createParallelGroup(Alignment.TRAILING)
						.addGroup(
								gl_pestanaModificacionUsuario
										.createSequentialGroup()
										.addContainerGap()
										.addGroup(
												gl_pestanaModificacionUsuario
														.createParallelGroup(
																Alignment.LEADING)
														.addGroup(
																gl_pestanaModificacionUsuario
																		.createParallelGroup(
																				Alignment.BASELINE)
																		.addComponent(
																				lblMODIFICACIONUSRUsuarioExistente)
																		.addComponent(
																				txtMODIFICACIONUSRBuscar,
																				GroupLayout.PREFERRED_SIZE,
																				GroupLayout.DEFAULT_SIZE,
																				GroupLayout.PREFERRED_SIZE)
																		.addComponent(
																				comboBoxMODIFICACIONUSRBusqueda,
																				GroupLayout.PREFERRED_SIZE,
																				GroupLayout.DEFAULT_SIZE,
																				GroupLayout.PREFERRED_SIZE))
														.addComponent(
																btnMODIFICACIONUSRBuscar,
																GroupLayout.PREFERRED_SIZE,
																20,
																GroupLayout.PREFERRED_SIZE))
										.addPreferredGap(
												ComponentPlacement.RELATED)
										.addComponent(
												scrollPaneMODIFICACIONUSR,
												GroupLayout.DEFAULT_SIZE, 170,
												Short.MAX_VALUE)
										.addPreferredGap(
												ComponentPlacement.UNRELATED)
										.addComponent(
												lblMODIFICACIONUSRDatosDelUsuario,
												GroupLayout.PREFERRED_SIZE, 17,
												GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(
												ComponentPlacement.UNRELATED)
										.addGroup(
												gl_pestanaModificacionUsuario
														.createParallelGroup(
																Alignment.BASELINE)
														.addComponent(
																txtMODIFICACIONUSRDNI,
																GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE)
														.addComponent(
																lblMODIFICACIONUSRDNI)
														.addComponent(
																lblMODIFICACIONUSRUsuario)
														.addComponent(
																txtMODIFICACIONUSRUsuario,
																GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE))
										.addPreferredGap(
												ComponentPlacement.UNRELATED)
										.addGroup(
												gl_pestanaModificacionUsuario
														.createParallelGroup(
																Alignment.BASELINE)
														.addComponent(
																txtMODIFICACIONUSRNombre,
																GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE)
														.addComponent(
																lblMODIFICACIONUSRNombreYApellidos))
										.addPreferredGap(
												ComponentPlacement.UNRELATED)
										.addGroup(
												gl_pestanaModificacionUsuario
														.createParallelGroup(
																Alignment.BASELINE)
														.addComponent(
																txtMODIFICACIONUSREmail,
																GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE)
														.addComponent(
																lblMODIFICACIONUSREmail))
										.addPreferredGap(
												ComponentPlacement.UNRELATED)
										.addGroup(
												gl_pestanaModificacionUsuario
														.createParallelGroup(
																Alignment.BASELINE)
														.addComponent(
																lblMODIFICACIONUSRFechaDeNaciemiento)
														.addComponent(
																comboBoxMODIFICACIONUSRDia,
																GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE)
														.addComponent(
																comboBoxMODIFICACIONUSRMes,
																GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE)
														.addComponent(
																comboBoxMODIFICACIONUSRAnio,
																GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE))
										.addPreferredGap(
												ComponentPlacement.UNRELATED)
										.addGroup(
												gl_pestanaModificacionUsuario
														.createParallelGroup(
																Alignment.BASELINE)
														.addComponent(
																lblMODIFICACIONUSRSexo)
														.addComponent(
																comboBoxMODIFICACIONUSRSexo,
																GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE))
										.addGap(18)
										.addGroup(
												gl_pestanaModificacionUsuario
														.createParallelGroup(
																Alignment.BASELINE)
														.addComponent(
																btnMODIFICACIONUSREliminarUsuario)
														.addComponent(
																btnMODIFICACIONUSRConfirmarModificacion)
														.addComponent(
																btnMODIFICACIONUSRNuevoUsuario))
										.addContainerGap()));
		pestanaModificacionUsuario.setLayout(gl_pestanaModificacionUsuario);
		modelo.datosReservaInicio();
		controlador.solicitaRellenarTablaMU();
		controlador.solicitaRellenarTablaEq("pestanaRES");
		controlador.solicitaRellenarTablaEq("pestanaMEQ");
	}

	//
	// METODOS INICIO
	//
	public int getNumeroColumnaInicio() {
		return ((DefaultTableModel) tableINICIO.getModel()).getColumnCount();
	}

	public void actualizaTablaInicio(Object[] fila) {
		((DefaultTableModel) tableINICIO.getModel()).addRow(fila);
	}

	//
	// METODOS RESERVA EQUIPO
	//

	public String getCategoriaPC() {
		String categoriaPC = (String) comboBoxRESERVAEquipo.getSelectedItem();
		return categoriaPC;
	}

	public String getCategoriaComp() {
		String categoriaComp = (String) comboBoxRESERVABusqueda
				.getSelectedItem();
		return categoriaComp;
	}

	public String getTextoBusqueda() {
		String textoBusqueda = txtRESERVABuscar.getText();
		return textoBusqueda;
	}

	public String getTxtUSUARIOReserva() {
		String txtBusquedaUSUARIO = txtRESERVADNI.getText();
		return txtBusquedaUSUARIO;
	}

	public int getNumColumnTablaReserva() {
		return ((DefaultTableModel) tablaReservaEquipo.getModel())
				.getColumnCount();
	}

	public String getCatUSUARIOReserva() {
		return (String) comboBoxRESERVAUsuario.getSelectedItem();
	}

	public String getIDEquipoRE() {
		return (String) ((DefaultTableModel) tablaReservaEquipo.getModel())
				.getValueAt(tablaReservaEquipo.getSelectedRow(), 0);
	}

	/**
	 * Método para borrar las filas de las tablas de la vista.
	 */
	public void borrarTabla(JTable tabla, int filas) {
		try {
			DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();
			for (int i = 0; filas > i; i++) {
				modelo.removeRow(0);
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error al limpiar la tabla.");
		}
	}

	/**
	 * Añade las filas de la consulta mediante un array de objetos donde se
	 * almacenan las columnas.
	 */
	public void actualizaTablaReserva(Object[] fila) {
		((DefaultTableModel) tablaReservaEquipo.getModel()).addRow(fila);
	}

	public void rellenaCampoUsuarioRes(String nomUsuario) {
		txtRESERVANombre.setText(nomUsuario);
		txtRESERVANombre.setForeground(Color.blue);
	}

	/**
	 * Método que lanza un mensaje si no se encuentran resultados en la
	 * búsqueda.
	 */
	public void mensErrorBusq() {
		JOptionPane.showMessageDialog(null, "No se encontraron resultados",
				"Not Found", 1);
	}

	public void mensErrorUsuario() {
		JOptionPane.showMessageDialog(null,
				"No hay ningún usuario seleccionado.", "Seleccione Usuario", 1);
	}

	public void mensConfirmReserva() {
		JOptionPane.showMessageDialog(null,
				"La reserva se ha realizado correctamente.",
				"Reserva Realizada", 1);
	}

	public void mensFalloReserva() {
		JOptionPane
				.showMessageDialog(
						null,
						"Error al realizar la reserva, compruebe los datos del usuario.",
						"Reserva no realizada", 1);
	}

	public void mensEquipoNoSelec() {
		JOptionPane.showMessageDialog(null, "Seleccione un equipo.",
				"Equipo no seleccionado", 1);
	}

	public void borrarTexto(String pestana) {
		if (pestana.equals("pestanaRES")) {
			txtRESERVANombre.setText("Nombre y apellidos");
			txtRESERVANombre.setForeground(Color.lightGray);
		}
		if (pestana.equals("pestanaDEVOL")) {
			txtDEVOLUCIONNombre.setText("Nombre y apellidos");
			txtDEVOLUCIONNombre.setForeground(Color.lightGray);
		}
	}

	//
	// METODOS DEVOLUCION EQUIPO
	//
	public String getTxtUSUARIODevol() {
		return txtDEVOLUCIONDNI.getText();
	}

	public String getCatUSUARIODevol() {
		return (String) comboBoxDEVOLUCIONUsuario.getSelectedItem();
	}

	public void rellenaCampoUsuarioDevol(String nomUsuario) {
		txtDEVOLUCIONNombre.setText(nomUsuario);
		txtDEVOLUCIONNombre.setForeground(Color.blue);
	}

	public void actualizaTablaDevol(Object[] fila) {
		((DefaultTableModel) tableDEVOLUCION.getModel()).addRow(fila);
	}

	public int getNumColumnasTablaDEVOL() {
		return ((DefaultTableModel) tableDEVOLUCION.getModel())
				.getColumnCount();
	}

	public String getDniUsuarioDevol() {
		String dniUsuario = txtDEVOLUCIONDNI.getText();
		return dniUsuario;
	}

	public String getIdEquipoDevol() {
		String idEquipo = (String) ((DefaultTableModel) tableDEVOLUCION
				.getModel()).getValueAt(tableDEVOLUCION.getSelectedRow(), 0);
		return idEquipo;
	}

	public String getFechaReservaDevol() {
		String fechaReserva = (String) ((DefaultTableModel) tableDEVOLUCION
				.getModel()).getValueAt(tableDEVOLUCION.getSelectedRow(), 2);
		return fechaReserva;
	}

	public String getTipoIdDevol() {
		String tipoId = (String) comboBoxDEVOLUCIONUsuario.getSelectedItem();
		return tipoId;
	}

	public void mensajeConfirmacionDevol(String mensaje, String titulo) {
		JOptionPane.showMessageDialog(null, mensaje, titulo, 1);
	}

	public void mensajeErrorDevol(String mensaje, String titulo) {
		JOptionPane.showMessageDialog(null, mensaje, titulo, 1);
	}

	//
	// METODOS ALTA EQUIPO
	//
	private void setDatosEquipo() {
		String procesador = txtALTAProcesador.getText();
		String memoria = txtALTARAM.getText();
		String discoDuro = txtALTAHDD.getText();
		int ssd;
		String grafica = txtALTAGrafica.getText();
		String ssoo = txtALTASSOO.getText();
		String armario = (String) comboBoxALTAArmario.getSelectedItem();
		String categoria = (String) comboBoxALTACategoria.getSelectedItem();
		String observaciones = textAreaALTAObservaciones.getText();
		if (chckbxALTASsd.isSelected()) {
			ssd = 1;
		} else {
			ssd = 0;
		}
		controlador.recibirDatosEquipo(procesador, memoria, discoDuro, ssd,
				grafica, ssoo, armario, categoria, observaciones);
	}

	public void limpiarCamposFormularioAlta() {
		txtALTAProcesador.setText("");
		txtALTARAM.setText("");
		txtALTAHDD.setText("");
		txtALTAGrafica.setText("");
		txtALTASSOO.setText("");
		textAreaALTAObservaciones.setText("");
	}

	public void mensCampoVacio() {
		JOptionPane.showMessageDialog(null,
				"Asegúrese de rellenar todos los campos del equipo.",
				"Campo vacio", 1);
	}

	//
	// METODOS MODIFICACION EQUIPO
	//

	public void actualizaTablaModif(Object[] fila) {
		((DefaultTableModel) tableMODIFICACIONEQ.getModel()).addRow(fila);
	}

	public String getCategoriaPCModif() {
		String categoriaPC = (String) comboBoxMODIFICACIONEQCat
				.getSelectedItem();
		return categoriaPC;
	}

	public String getCategoriaCompModif() {
		String categoriaComp = (String) comboBoxMODIFICACIONEQComp
				.getSelectedItem();
		return categoriaComp;
	}

	public String getTextoBusquedaModif() {
		String textoBusqueda = txtMODIFICACIONEQBuscar.getText();
		return textoBusqueda;
	}

	/**
	 * Metodo que obtiene los datos del formulario de la ventan de modificacion
	 * de equipos y los envia al controlador.
	 */
	private void setDatosEquipoModif() {
		String idEquipo = (String) ((DefaultTableModel) tableMODIFICACIONEQ
				.getModel())
				.getValueAt(tableMODIFICACIONEQ.getSelectedRow(), 0);
		String procesador = textFieldMODIFICACIONEQProcesador.getText();
		String memoria = textFieldMODIFICACIONEQRam.getText();
		String discoDuro = textFieldMODIFICACIONEQHDD.getText();
		int ssd;
		String grafica = textFieldMODIFICACIONEQGrafica.getText();
		String ssoo = textFieldMODIFICACIONEQSSOO.getText();
		String armario = (String) comboBoxMODIFICACIONEQArmario
				.getSelectedItem();
		if (chckbxMODIFICACIONEQSSD.isSelected()) {
			ssd = 1;
		} else {
			ssd = 0;
		}
		controlador.recibirDatosEquipoModif(idEquipo, procesador, memoria,
				discoDuro, ssd, grafica, ssoo, armario);
	}

	public void limpiarCamposMEQ() {
		textFieldMODIFICACIONEQProcesador.setText("");
		textFieldMODIFICACIONEQRam.setText("");
		textFieldMODIFICACIONEQHDD.setText("");
		textFieldMODIFICACIONEQGrafica.setText("");
		textFieldMODIFICACIONEQSSOO.setText("");
	}

	/**
	 * Metodo que devuelve la id del equipo que se va a eliminar.
	 * 
	 * @return
	 */
	public String getIdEquipoEliminado() {
		String idEquipo = (String) ((DefaultTableModel) tableMODIFICACIONEQ
				.getModel())
				.getValueAt(tableMODIFICACIONEQ.getSelectedRow(), 0);
		return idEquipo;
	}

	/**
	 * Metodo que rellena los campos del formulario de equipo cuando se
	 * selecciona una fila.
	 */
	private void rellenarFormulario() {
		textFieldMODIFICACIONEQProcesador
				.setText((String) ((DefaultTableModel) tableMODIFICACIONEQ
						.getModel()).getValueAt(
						tableMODIFICACIONEQ.getSelectedRow(), 1));
		textFieldMODIFICACIONEQRam
				.setText((String) ((DefaultTableModel) tableMODIFICACIONEQ
						.getModel()).getValueAt(
						tableMODIFICACIONEQ.getSelectedRow(), 2));
		textFieldMODIFICACIONEQHDD
				.setText((String) ((DefaultTableModel) tableMODIFICACIONEQ
						.getModel()).getValueAt(
						tableMODIFICACIONEQ.getSelectedRow(), 3));
		textFieldMODIFICACIONEQGrafica
				.setText((String) ((DefaultTableModel) tableMODIFICACIONEQ
						.getModel()).getValueAt(
						tableMODIFICACIONEQ.getSelectedRow(), 5));
		textFieldMODIFICACIONEQSSOO
				.setText((String) ((DefaultTableModel) tableMODIFICACIONEQ
						.getModel()).getValueAt(
						tableMODIFICACIONEQ.getSelectedRow(), 6));
		if (((String) ((DefaultTableModel) tableMODIFICACIONEQ.getModel())
				.getValueAt(tableMODIFICACIONEQ.getSelectedRow(), 4))
				.equals("1")) {
			chckbxMODIFICACIONEQSSD.setSelected(true);
		} else {
			chckbxMODIFICACIONEQSSD.setSelected(false);
		}
	}

	public void mensModifEquipo(String mensaje) {
		JOptionPane.showMessageDialog(null, mensaje, "Equipo Modificado", 1);
	}

	//
	// METODOS MODIFICACION USUARIO
	//
	public String getTxtUSUARIOModif() {
		return txtMODIFICACIONUSRBuscar.getText();
	}

	public String getCatUSUARIOModif() {
		return (String) comboBoxMODIFICACIONUSRBusqueda.getSelectedItem();
	}

	public int getNumColumnasTablaMU() {
		return ((DefaultTableModel) tableMODIFICACIONUSR.getModel())
				.getColumnCount();
	}

	public void actualizaTablaMU(Object[] fila) {
		((DefaultTableModel) tableMODIFICACIONUSR.getModel()).addRow(fila);
	}

	public void actualizaFormularioMU(String dniUsuario, String nickUsuario,
			String nombreUsuario, String mailUsuario, String generoUsuario,
			String dia, String mes, String anio) {

		this.dniOriginal = dniUsuario;
		this.usuarioOriginal = nickUsuario;
		this.nombreOriginal = nombreUsuario;
		this.mailOriginal = mailUsuario;
		txtMODIFICACIONUSRDNI.setText(dniUsuario);
		txtMODIFICACIONUSRUsuario.setText(nickUsuario);
		txtMODIFICACIONUSRNombre.setText(nombreUsuario);
		txtMODIFICACIONUSREmail.setText(mailUsuario);
		if (generoUsuario.equalsIgnoreCase("female")) {
			comboBoxMODIFICACIONUSRSexo.setSelectedItem("Femenino");
		} else {
			comboBoxMODIFICACIONUSRSexo.setSelectedItem("Masculino");
		}
		comboBoxMODIFICACIONUSRDia.setSelectedItem(dia);
		comboBoxMODIFICACIONUSRMes.setSelectedItem(mes);
		comboBoxMODIFICACIONUSRAnio.setSelectedItem(anio);
	}

	public void enviarDatosTablaMU() {
		String dniUsu = (String) ((DefaultTableModel) tableMODIFICACIONUSR
				.getModel()).getValueAt(tableMODIFICACIONUSR.getSelectedRow(),
				0);
		String nickUsuario = (String) ((DefaultTableModel) tableMODIFICACIONUSR
				.getModel()).getValueAt(tableMODIFICACIONUSR.getSelectedRow(),
				1);
		String nombreUsu = (String) ((DefaultTableModel) tableMODIFICACIONUSR
				.getModel()).getValueAt(tableMODIFICACIONUSR.getSelectedRow(),
				2);
		String mailUsu = (String) ((DefaultTableModel) tableMODIFICACIONUSR
				.getModel()).getValueAt(tableMODIFICACIONUSR.getSelectedRow(),
				3);
		String fNacUsu = (String) ((DefaultTableModel) tableMODIFICACIONUSR
				.getModel()).getValueAt(tableMODIFICACIONUSR.getSelectedRow(),
				4);
		String genUsu = (String) ((DefaultTableModel) tableMODIFICACIONUSR
				.getModel()).getValueAt(tableMODIFICACIONUSR.getSelectedRow(),
				5);
		controlador.tablaAFormularioMU(dniUsu, nickUsuario, nombreUsu, mailUsu,
				fNacUsu, genUsu);
	}

	private void enviarDatosFormularioMU(int caso) {
		String dniForm = txtMODIFICACIONUSRDNI.getText();
		String nickForm = txtMODIFICACIONUSRUsuario.getText();
		String nombreForm = txtMODIFICACIONUSRNombre.getText();
		String mailForm = txtMODIFICACIONUSREmail.getText();
		String sexoForm = (String) comboBoxMODIFICACIONUSRSexo
				.getSelectedItem();
		String diaForm = (String) comboBoxMODIFICACIONUSRDia.getSelectedItem();
		String mesForm = (String) comboBoxMODIFICACIONUSRMes.getSelectedItem();
		String anioForm = (String) comboBoxMODIFICACIONUSRAnio
				.getSelectedItem();
		switch (caso) {
		case 1:
			controlador.eliminarUsuario(dniForm);
			break;
		case 2:
			controlador.modificarUsuario(this.dniOriginal,
					this.usuarioOriginal, this.nombreOriginal,
					this.mailOriginal, dniForm, nickForm, nombreForm, mailForm,
					sexoForm, diaForm, mesForm, anioForm);
			break;
		case 3:
			controlador.crearUsuario(dniForm, nickForm, nombreForm, mailForm,
					sexoForm, diaForm, mesForm, anioForm);
			break;
		default:
			break;
		}
	}

	public void mensajeCambioUsuario(String mensaje) {
		JOptionPane.showMessageDialog(null, mensaje, "Modificacion Usuario", 1);
	}

	public void mensajeErrorCambioUsuario(String mensaje) {
		JOptionPane.showMessageDialog(null, mensaje, "Modificacion Usuario", 1);
	}

	public void mensajeIdDuplicado() {
		JOptionPane.showMessageDialog(null,
				"El DNI, Nombre, Email o Nick ya existen.",
				"Modificacion Usuario", 1);
	}

	public void limpiarCamposFormularioDevol() {
		txtMODIFICACIONUSRDNI.setText("");
		txtMODIFICACIONUSRUsuario.setText("");
		txtMODIFICACIONUSRNombre.setText("");
		txtMODIFICACIONUSREmail.setText("");
	}

	//
	// SECCIÓN CONFIGURACION INICIO
	//
	public void mostrarConfiguracion(String bd_url, String bd_name,
			String bd_user, String bd_password, String lg_user,
			String lg_password) {

		txtURLBaseDe.setText(bd_url);
		txtNombreBaseDe.setText(bd_name);
		txtUsuarioBaseDe.setText(bd_user);
		txtContrasenaBaseDe.setText(bd_password);

		txtUsuario.setText(lg_user);
		txtContrasena.setText(lg_password);
	}

	public void autoLogin(Boolean check) {
		autoLogin = check;
	}

	private void windowConfig() {
		windowConfig = new JFrame();
		windowConfig.setIconImage(Toolkit.getDefaultToolkit().getImage(
				VistaImplLogin.class
						.getResource("/pictures/U-Programmers_S.L._x64.png")));
		windowConfig.setVisible(true);
		windowConfig.setResizable(false);
		windowConfig.setBounds(100, 100, 491, 355);
		windowConfig.setLocationRelativeTo(null);

		lblConfiguracinBaseDe = new JLabel("Configuraci\u00F3n Base de Datos");
		lblConfiguracinBaseDe.setFont(new Font("Lucida Grande", Font.BOLD, 15));
		lblConfiguracinBaseDe.setHorizontalAlignment(SwingConstants.CENTER);

		lblURLBaseDe = new JLabel("URL Base de Datos:");
		txtURLBaseDe = new JTextField();
		txtURLBaseDe.setColumns(10);

		lblNombreBaseDe = new JLabel("Nombre Base de Datos:");
		txtNombreBaseDe = new JTextField();
		txtNombreBaseDe.setColumns(10);

		lblUsuarioBaseDe = new JLabel("Usuario Base de Datos:");
		txtUsuarioBaseDe = new JTextField();
		txtUsuarioBaseDe.setColumns(10);

		lblContrasenaBaseDe = new JLabel("Contrase\u00F1a Base de Datos:");
		txtContrasenaBaseDe = new JPasswordField();

		lblConfiguracionInicioSesion = new JLabel(
				"Configuraci\u00F3n Inicio de Sesi\u00F3n");
		lblConfiguracionInicioSesion
				.setHorizontalAlignment(SwingConstants.CENTER);
		lblConfiguracionInicioSesion.setFont(new Font("Lucida Grande",
				Font.BOLD, 15));

		chckbxIniciarSesinAutomaticamente = new JCheckBox(
				"Iniciar Sesi\u00F3n Automaticamente");
		chckbxIniciarSesinAutomaticamente.setSelected(autoLogin);
		chckbxIniciarSesinAutomaticamente
				.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						if (chckbxIniciarSesinAutomaticamente.isSelected()) {
							txtUsuario.setEnabled(true);
							txtContrasena.setEnabled(true);
						} else {
							txtUsuario.setEnabled(false);
							txtUsuario.setText("");
							txtContrasena.setEnabled(false);
							txtContrasena.setText("");
						}

					}
				});

		lblUsuario = new JLabel("Usuario:");
		txtUsuario = new JTextField();
		txtUsuario.setEnabled(autoLogin);
		txtUsuario.setColumns(10);

		lblContrasea = new JLabel("Contrase\u00F1a:");
		txtContrasena = new JPasswordField();
		txtContrasena.setEnabled(autoLogin);

		btnGuardarCambios = new JButton("Guardar Cambios");
		btnGuardarCambios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {// <------------------------------------------------------CREAR_METODO--------------------------------------------->
				char tmp_bd[] = txtContrasenaBaseDe.getPassword();
				String str_bd = new String(tmp_bd);

				char tmp_lg[] = txtContrasena.getPassword();
				String str_lg = new String(tmp_lg);

				controlador.getConfiguracion(txtURLBaseDe.getText(),
						txtNombreBaseDe.getText(), txtUsuarioBaseDe.getText(),
						str_bd, chckbxIniciarSesinAutomaticamente.isSelected(),
						txtUsuario.getText(), str_lg);
			}
		});

		btnDescartarCambios = new JButton("Descartar Cambios");
		btnDescartarCambios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controlador.changeWindow(5);
			}
		});

		groupLayout = new GroupLayout(windowConfig.getContentPane());
		groupLayout
				.setHorizontalGroup(groupLayout
						.createParallelGroup(Alignment.LEADING)
						.addGroup(
								groupLayout
										.createSequentialGroup()
										.addContainerGap()
										.addGroup(
												groupLayout
														.createParallelGroup(
																Alignment.LEADING)
														.addGroup(
																groupLayout
																		.createSequentialGroup()
																		.addGroup(
																				groupLayout
																						.createParallelGroup(
																								Alignment.LEADING)
																						.addGroup(
																								groupLayout
																										.createSequentialGroup()
																										.addComponent(
																												btnDescartarCambios)
																										.addPreferredGap(
																												ComponentPlacement.RELATED,
																												213,
																												Short.MAX_VALUE)
																										.addComponent(
																												btnGuardarCambios))
																						.addComponent(
																								lblConfiguracinBaseDe,
																								Alignment.TRAILING,
																								GroupLayout.DEFAULT_SIZE,
																								451,
																								Short.MAX_VALUE)
																						.addGroup(
																								Alignment.TRAILING,
																								groupLayout
																										.createSequentialGroup()
																										.addGroup(
																												groupLayout
																														.createParallelGroup(
																																Alignment.LEADING)
																														.addComponent(
																																lblUsuarioBaseDe)
																														.addComponent(
																																lblNombreBaseDe)
																														.addComponent(
																																lblURLBaseDe)
																														.addComponent(
																																lblContrasenaBaseDe))
																										.addGap(14)
																										.addGroup(
																												groupLayout
																														.createParallelGroup(
																																Alignment.TRAILING,
																																false)
																														.addComponent(
																																txtURLBaseDe)
																														.addComponent(
																																txtNombreBaseDe,
																																GroupLayout.DEFAULT_SIZE,
																																296,
																																Short.MAX_VALUE)
																														.addGroup(
																																Alignment.LEADING,
																																groupLayout
																																		.createParallelGroup(
																																				Alignment.LEADING,
																																				false)
																																		.addComponent(
																																				txtUsuarioBaseDe,
																																				Alignment.TRAILING)
																																		.addComponent(
																																				txtContrasenaBaseDe,
																																				Alignment.TRAILING,
																																				GroupLayout.DEFAULT_SIZE,
																																				296,
																																				Short.MAX_VALUE))))
																						.addComponent(
																								lblConfiguracionInicioSesion,
																								Alignment.TRAILING,
																								GroupLayout.PREFERRED_SIZE,
																								438,
																								GroupLayout.PREFERRED_SIZE)
																						.addGroup(
																								Alignment.TRAILING,
																								groupLayout
																										.createSequentialGroup()
																										.addGap(29)
																										.addGroup(
																												groupLayout
																														.createParallelGroup(
																																Alignment.LEADING)
																														.addComponent(
																																lblContrasea)
																														.addComponent(
																																lblUsuario))
																										.addGap(18)
																										.addGroup(
																												groupLayout
																														.createParallelGroup(
																																Alignment.LEADING,
																																false)
																														.addComponent(
																																txtContrasena)
																														.addComponent(
																																txtUsuario,
																																GroupLayout.DEFAULT_SIZE,
																																232,
																																Short.MAX_VALUE))
																										.addPreferredGap(
																												ComponentPlacement.RELATED,
																												117,
																												Short.MAX_VALUE)))
																		.addGap(14))
														.addGroup(
																groupLayout
																		.createSequentialGroup()
																		.addComponent(
																				chckbxIniciarSesinAutomaticamente)
																		.addContainerGap(
																				294,
																				Short.MAX_VALUE)))));
		groupLayout
				.setVerticalGroup(groupLayout
						.createParallelGroup(Alignment.LEADING)
						.addGroup(
								groupLayout
										.createSequentialGroup()
										.addContainerGap()
										.addComponent(lblConfiguracinBaseDe)
										.addPreferredGap(
												ComponentPlacement.RELATED)
										.addGroup(
												groupLayout
														.createParallelGroup(
																Alignment.BASELINE)
														.addComponent(
																txtURLBaseDe,
																GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE)
														.addComponent(
																lblURLBaseDe))
										.addPreferredGap(
												ComponentPlacement.RELATED)
										.addGroup(
												groupLayout
														.createParallelGroup(
																Alignment.BASELINE)
														.addComponent(
																txtNombreBaseDe,
																GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE)
														.addComponent(
																lblNombreBaseDe))
										.addPreferredGap(
												ComponentPlacement.RELATED)
										.addGroup(
												groupLayout
														.createParallelGroup(
																Alignment.BASELINE)
														.addComponent(
																lblUsuarioBaseDe)
														.addComponent(
																txtUsuarioBaseDe,
																GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE))
										.addPreferredGap(
												ComponentPlacement.RELATED)
										.addGroup(
												groupLayout
														.createParallelGroup(
																Alignment.BASELINE)
														.addComponent(
																txtContrasenaBaseDe,
																GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE)
														.addComponent(
																lblContrasenaBaseDe))
										.addPreferredGap(
												ComponentPlacement.RELATED)
										.addComponent(
												lblConfiguracionInicioSesion,
												GroupLayout.PREFERRED_SIZE, 19,
												GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(
												ComponentPlacement.RELATED)
										.addComponent(
												chckbxIniciarSesinAutomaticamente)
										.addGap(17)
										.addGroup(
												groupLayout
														.createParallelGroup(
																Alignment.BASELINE)
														.addComponent(
																txtUsuario,
																GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE)
														.addComponent(
																lblUsuario))
										.addPreferredGap(
												ComponentPlacement.UNRELATED)
										.addGroup(
												groupLayout
														.createParallelGroup(
																Alignment.BASELINE)
														.addComponent(
																lblContrasea)
														.addComponent(
																txtContrasena,
																GroupLayout.PREFERRED_SIZE,
																GroupLayout.DEFAULT_SIZE,
																GroupLayout.PREFERRED_SIZE))
										.addGap(63))
						.addGroup(
								Alignment.TRAILING,
								groupLayout
										.createSequentialGroup()
										.addContainerGap(282, Short.MAX_VALUE)
										.addGroup(
												groupLayout
														.createParallelGroup(
																Alignment.BASELINE)
														.addComponent(
																btnDescartarCambios)
														.addComponent(
																btnGuardarCambios))
										.addContainerGap()));
		windowConfig.getContentPane().setLayout(groupLayout);
	}
}
