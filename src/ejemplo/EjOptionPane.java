package ejemplo;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class EjOptionPane extends JFrame implements ActionListener {
	JFrame frame=new JFrame();
	JPanel contentPane=new JPanel();
	JLabel tipoDialog;
	JTextField opcionSeleccionadaText;
	
	public EjOptionPane() {
		super();
		iniciarFrame();
		iniciarComponentes();
	}
	
	public void iniciarFrame() {
		this.setTitle("EJEMPLO DE DISTINTOS OPTIONPANE");
    	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	this.setBounds(100, 100, 450, 433);
    	contentPane = new JPanel();
    	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
    	this.setContentPane(contentPane);
    	this.contentPane.setLayout(new FlowLayout());
	}	
	
	public void iniciarComponentes() {
		//Para mostrar los resultados
		tipoDialog=new JLabel();
		tipoDialog.setText("OPCIÓN SELECCIONADA: ");
		tipoDialog.setVisible(false);
		opcionSeleccionadaText=new JTextField();
		opcionSeleccionadaText.setVisible(false);
		
		//*****bot�n ShowMessage
		JButton bOptionPane=new JButton();
		bOptionPane.setText("MENSAJES");
		bOptionPane.setActionCommand("mensaje");
		bOptionPane.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ventanaMensaje();
			}});
		
		
		
		//*****bot�n Show Option Dialog
		JButton bShowOption=new JButton();
		bShowOption.setText("OPTION DIALOG");
		bShowOption.setActionCommand("comOD");
		bShowOption.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ventanaOption();
			}});
		
				
		//******bot�n InputDialog con mensaje
		JButton bInput=new JButton();
		bInput.setText("INPUT DIALOG");
		bInput.setActionCommand("comIn");
		bInput.addActionListener(evento->ventanaInput());
		
		//******bot�n InputDialog con comboBox
		JButton bInputC=new JButton();
		bInputC.setText("INPUT DIALOG CON COMBO");
		bInputC.setActionCommand("comIC");
		bInputC.addActionListener(e->ventanaInputC());
		
		//******bot�n ShowConfirm con comboBox
		JButton bShowC=new JButton();
		bShowC.setText("CONFIRM DIALOG");
		bShowC.setActionCommand("comSC");
		bShowC.addActionListener(e->showCD());
		
		//A�adimos al panel en el orden qe queremos:
		contentPane.add(bOptionPane);
		contentPane.add(bShowOption);
		contentPane.add(bInput);
		contentPane.add(bInputC);
		contentPane.add(bShowC);
		contentPane.add(tipoDialog);
		contentPane.add(opcionSeleccionadaText);
		
		
	}
	public void ventanaMensaje() {
		JOptionPane.showMessageDialog(this, "Mensaje más básico");
		JOptionPane.showMessageDialog(null, "Mensaje dentro de la ventana de warning", "Mensaje en la barra de titulo", JOptionPane.WARNING_MESSAGE);
		JOptionPane.showMessageDialog(null, "Mensaje dentro de la ventana de error", "MENSAJE DE ERROR", JOptionPane.ERROR_MESSAGE);
		
		
		
	}
	public void ventanaOption() {
		int seleccion = JOptionPane.showOptionDialog(
				   this, //componente padre:  posición de la ventana
				   "Seleccione opcion", //mensaje 
				   "Selector de opciones", //título del mensaje
				   JOptionPane.YES_NO_CANCEL_OPTION,
				   JOptionPane.ERROR_MESSAGE,
				   null,    // null para icono por defecto.
				  // null,
				   new Object[] { "opcion 1", "opcion 2", "opcion 3" },   // null para YES, NO y CANCEL
				   "opcion 1");
		tipoDialog.setText("Selector de opciones: ");
		opcionSeleccionadaText.setText(String.valueOf(seleccion));		
		tipoDialog.setVisible(true);
		opcionSeleccionadaText.setVisible(true);
	
	}
	public void ventanaInput() {
		String seleccion = JOptionPane.showInputDialog(
				   this,//componente padre
				   "EJEMPLO DE VENTANA INPUT DIALOG",
				   JOptionPane.QUESTION_MESSAGE);  // el icono sera un interrogante
		//otras posibilidades del icono: 
	    /*ERROR_MESSAGE
	    INFORMATION_MESSAGE
	    WARNING_MESSAGE
	    QUESTION_MESSAGE
	    PLAIN_MESSAGE */		        
		tipoDialog.setText("CONTENIDO DE INPUT DIALOG:");
		opcionSeleccionadaText.setText(String.valueOf(seleccion));		
		tipoDialog.setVisible(true);
		opcionSeleccionadaText.setVisible(true);
	
	}
	
	public void ventanaInputC() {
		
		Object seleccion = JOptionPane.showInputDialog(
				   this,//componente padre				  
				   "SELECCIONE OPCIÓN:", //mensaje de selección
				   "EJEMPLO DE VENTANA INPUT DIALOG CON COMBO", //título de la ventana
				   JOptionPane.INFORMATION_MESSAGE, // el icono 
				   null,
				   new Object[] { "opcion 1", "opcion 2", "opcion 3" },
				   "opcion 1"); 
			        
		tipoDialog.setText("CONTENIDO DE INPUT DIALOG CON COMBO:");
		opcionSeleccionadaText.setText(String.valueOf(seleccion));		
		tipoDialog.setVisible(true);
		opcionSeleccionadaText.setVisible(true);
	
	}
	
	public void showCD() {
		int confirmado = JOptionPane.showConfirmDialog(
				   this, //componente padre
				   "Lo confirmas?");
//confirmado corresponderá a un entero: YES_OPTION, NO_OPTION, CANCEL_OPTION, OK_OPTION, CLOSED_OPTION
		tipoDialog.setText("CONFIRM DIALOG:");
		opcionSeleccionadaText.setText(String.valueOf(confirmado));		
		tipoDialog.setVisible(true);
		opcionSeleccionadaText.setVisible(true);
				
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		tipoDialog.setVisible(false);
		opcionSeleccionadaText.setVisible(false);
		String opcion=e.getActionCommand();
		if (opcion.equals("mensaje")) {
			ventanaMensaje();
		}
		if (opcion.equals("comOD")) {
			ventanaOption();
		}
		if (opcion.equals("comIn")) {
			ventanaInput();
		}
		if (opcion.equals("comIC")) {
			ventanaInputC();
		}
		if (opcion.equals("comSC")) {
			showCD();
		}
	}
public static void main(String[] args) {
	EjOptionPane miVentana=new EjOptionPane();
	miVentana.setVisible(true);
}


}





