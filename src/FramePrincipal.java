import java.awt.BorderLayout;
import java.awt.Image;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JToolBar;
import javax.swing.KeyStroke;
import javax.swing.filechooser.FileNameExtensionFilter;

public class FramePrincipal {
	private JFrame frame;
	private BufferedImage canvas;
	JButton btnTextoSimple;
	JMenuItem itemTextoSimple;

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
		frame.setLayout(new BorderLayout());
		// -------------------------------------
		// Barra d menu
		JMenuBar menuBar = new JMenuBar();
		// Anadir barra al frame
		frame.setJMenuBar(menuBar);
		// -------------------------------------
		// MENU PRINCIPAL
		JMenu menu1 = new JMenu("File");
		menuBar.add(menu1);
		// -------------------------------------
		// ITEM MENU PRINCIPAL
		itemTextoSimple = new JMenuItem("Texto 1");
		itemTextoSimple.setEnabled(true);
		itemTextoSimple.setMnemonic(KeyEvent.VK_C);
		itemTextoSimple.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, ActionEvent.CTRL_MASK));
		menu1.add(itemTextoSimple);
		// -------------------------------------
		// SEPARAR
		menu1.addSeparator();
		// -------------------------------------
		// CHECK BOX
		JCheckBoxMenuItem check1 = new JCheckBoxMenuItem("Soy checkbox 1");
		menu1.add(check1);
		JCheckBoxMenuItem check2 = new JCheckBoxMenuItem("Soy checkbox 2");
		menu1.add(check2);
		// SEPARAR
		menu1.addSeparator();
		// RADIO BUTTON
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
		// -------------------------------------
		// ToolBar Fuente
		JToolBar toolbar = new JToolBar();
		toolbar.setFloatable(false);

		btnTextoSimple = new JButton("Texto");
		btnTextoSimple.setEnabled(true);
		try {
			this.canvas = ImageIO.read(new File("img/ir.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		btnTextoSimple.setIcon(new ImageIcon(canvas.getScaledInstance(30, 30, Image.SCALE_SMOOTH)));
		toolbar.add(btnTextoSimple);
		
		frame.add(toolbar, BorderLayout.NORTH);
		
		
	

		// -------------------------------------

		frame.add(new TextArea());
	}

	public void iniciarListened() {
		btnTextoSimple.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				itemTextoSimple.doClick();
			}
		});
		
		itemTextoSimple.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JFileChooser chooser = new JFileChooser();
				chooser.setCurrentDirectory(new File(System.getProperty("user.home")));
				chooser.setFileFilter(new FileNameExtensionFilter("Ficheros de CSV", "csv"));
				chooser.setAcceptAllFileFilterUsed(false);
				if (chooser.showOpenDialog(frame) == JFileChooser.APPROVE_OPTION) {
					System.out.println("Aprobado");
					//manejador.setFicheroActual(chooser.getSelectedFile());
				}
			}
		});
	}
}
