import java.awt.GridLayout;

import javax.swing.ButtonGroup;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JRadioButtonMenuItem;

public class FramePrincipal {
	private JFrame frame;

	public FramePrincipal() {
		frame = new JFrame("");
		frame.setBounds(200, 200, 1100, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public void iniciar() {
		iniciarComponentes();
		iniciarListened();
		frame.setVisible(true);
	}

	public void iniciarComponentes() {
		frame.setLayout(new GridLayout());
		// Barra d menu
		JMenuBar menuBar = new JMenuBar();
		// Anadir barra al frame
		frame.setJMenuBar(menuBar);
		// MENU PRINCIPAL
		JMenu menu1 = new JMenu("File");
		menuBar.add(menu1);
		// ITEM MENU PRINCIPAL
		JMenuItem itemTextoSimple = new JMenuItem("Texto 1");
		menu1.add(itemTextoSimple);
		// SEPARAR
		menu1.addSeparator();
		// CHECK BOX
		JCheckBoxMenuItem check1 = new JCheckBoxMenuItem("Soy checkbox 1");
		menu1.add(check1);
		JCheckBoxMenuItem check2 = new JCheckBoxMenuItem("Soy checkbox 2");
		menu1.add(check2);
		// SEPARAR
		menu1.addSeparator();
		//RADIO BUTTON
		JRadioButtonMenuItem radio1 = new JRadioButtonMenuItem("Soy un botón 1");
		menu1.add(radio1);
		JRadioButtonMenuItem radio2 = new JRadioButtonMenuItem("Soy un botón 2");
		menu1.add(radio2);
		ButtonGroup grupoRadios = new ButtonGroup();
		grupoRadios.add(radio1);
		grupoRadios.add(radio2);
		// SEPARAR
		menu1.addSeparator();
		// SUBMENU
		JMenu submenu = new JMenu("SubMenu");
		JMenuItem textoSubmenu = new JMenuItem("Texto submenu");
		submenu.add(textoSubmenu);
		menu1.add(submenu);

	}

	public void iniciarListened() {
	}
}
