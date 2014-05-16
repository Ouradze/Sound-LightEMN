package view;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.KeyStroke;

import processing.MainProcessing;
import controller.ControlButtonForms;
import controller.ControlChooseSvg;
import controller.ControlJButtonFile;
import controller.ControlJButtonStream;
import controller.ControlMenu;

public class FullWindow extends JFrame {

	private MainProcessing test;

	JMenuBar menuBar;
	JMenu menu, submenu;
	JMenuItem menuItem;
	JRadioButtonMenuItem rbMenuItem;
	JCheckBoxMenuItem cbMenuItem;

	Container conteneur = this.getContentPane();

	JPanel panel = new JPanel();

	public FullWindow() {
		super("Sound & Light");
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);

		MainProcessing test = new MainProcessing(panel);
		this.test = test;
		panel.add(test);

		conteneur.add(panel, BorderLayout.CENTER);

		/* Adding Menu */
		this.menu();

		/* Adding Defined Forms Panel */
		panel = new JPanel();
		this.createEast();
		conteneur.add(panel, BorderLayout.EAST);

		/* Adding Sound Control Panel */
		panel = new JPanel();
		this.createWest();
		conteneur.add(panel, BorderLayout.WEST);

		test.init();
	}

	public MainProcessing getApplet() {
		return this.test;
	}

	public void createNorth() {

	}

	public void createEast() {
		JPanel panelForm = new JPanel();

		ControlButtonForms controlFormButtons = new ControlButtonForms(
				this.test);

		panelForm.setLayout(new GridLayout(3, 3));// 4 lignes de 3 colonnes

		JButton FormButton1 = new JButton("Surface");
		FormButton1.addActionListener(controlFormButtons);
		panelForm.add(FormButton1);

		JButton FormButton2 = new JButton("Stripes3D");
		FormButton2.addActionListener(controlFormButtons);
		panelForm.add(FormButton2);

		JButton FormButton3 = new JButton("Hypercube");
		FormButton3.addActionListener(controlFormButtons);
		panelForm.add(FormButton3);

		JButton FormButton4 = new JButton("Cercle");
		FormButton4.addActionListener(controlFormButtons);
		panelForm.add(FormButton4);

		JButton FormButton5 = new JButton("Stripe");
		FormButton5.addActionListener(controlFormButtons);
		panelForm.add(FormButton5);

		JButton FormButton6 = new JButton("Cercles");
		FormButton6.addActionListener(controlFormButtons);
		panelForm.add(FormButton6);

		JButton FormButton7 = new JButton("StripeAnal");
		FormButton7.addActionListener(controlFormButtons);
		panelForm.add(FormButton7);

		JButton FormButton8 = new JButton("Spectre");
		FormButton8.addActionListener(controlFormButtons);
		panelForm.add(FormButton8);

		ControlChooseSvg controlSvg = new ControlChooseSvg(this, this.test);

		JButton FormButton9 = new JButton("Import Form");
		FormButton9.addActionListener(controlSvg);
		panelForm.add(FormButton9);

		panel.add(panelForm);
	}

	public void createWest() {
		JPanel panelSound = new JPanel();

		JCheckBox file = new JCheckBox("File");
		ControlJButtonFile controlFile = new ControlJButtonFile(this,
				this.getApplet());

		file.addActionListener(controlFile);

		JCheckBox stream = new JCheckBox("Stream");
		ControlJButtonStream controlStream = new ControlJButtonStream(this,
				this.getApplet());
		stream.addActionListener(controlStream);

		panelSound.add(file);
		panelSound.add(stream);

		panel.add(panelSound);
	}

	public void createSouth() {

	}

	public void createCenter() {

	}

	public void menu() {
		/* -- Menu -- */

		// Create the menu bar.
		menuBar = new JMenuBar();

		// Build the first menu.
		menu = new JMenu("File");
		menu.setMnemonic(KeyEvent.VK_A);
		menu.getAccessibleContext().setAccessibleDescription(
				"The only menu in this program that has menu items");
		menuBar.add(menu);

		// JMenuItems
		menuItem = new JMenuItem("A text-only menu item", KeyEvent.VK_T);
		menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_1,
				ActionEvent.ALT_MASK));
		menuItem.getAccessibleContext().setAccessibleDescription(
				"This doesn't really do anything");
		menu.add(menuItem);

		menuItem = new JMenuItem("Both text and icon", new ImageIcon(
				"images/middle.gif"));
		menuItem.setMnemonic(KeyEvent.VK_B);
		menu.add(menuItem);

		menuItem = new JMenuItem(new ImageIcon("images/middle.gif"));
		menuItem.setMnemonic(KeyEvent.VK_D);
		menu.add(menuItem);

		// RadioButton menu items
		menu.addSeparator();
		ButtonGroup group = new ButtonGroup();
		rbMenuItem = new JRadioButtonMenuItem("Enable mp3");
		rbMenuItem.setSelected(true);
		rbMenuItem.setMnemonic(KeyEvent.VK_R);
		group.add(rbMenuItem);
		menu.add(rbMenuItem);

		rbMenuItem = new JRadioButtonMenuItem("Enable input Stream");
		rbMenuItem.setMnemonic(KeyEvent.VK_O);
		group.add(rbMenuItem);
		menu.add(rbMenuItem);

		// a group of check box menu items
		menu.addSeparator();
		cbMenuItem = new JCheckBoxMenuItem("A check box menu item");
		cbMenuItem.setMnemonic(KeyEvent.VK_C);
		menu.add(cbMenuItem);

		cbMenuItem = new JCheckBoxMenuItem("Another one");
		cbMenuItem.setMnemonic(KeyEvent.VK_H);
		menu.add(cbMenuItem);

		// a submenu
		menu.addSeparator();
		submenu = new JMenu("A submenu");
		submenu.setMnemonic(KeyEvent.VK_S);

		menuItem = new JMenuItem("An item in the submenu");
		menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_2,
				ActionEvent.ALT_MASK));
		submenu.add(menuItem);

		menuItem = new JMenuItem("Another item");
		submenu.add(menuItem);
		menu.add(submenu);

		// Build second menu in the menu bar.
		menu = new JMenu("Edit");
		menu.setMnemonic(KeyEvent.VK_N);
		menu.getAccessibleContext().setAccessibleDescription(
				"This menu does nothing");
		menuBar.add(menu);

		// Build third menu in the menu bar.
		menu = new JMenu("Perspective");
		menu.setMnemonic(KeyEvent.VK_N);
		menu.getAccessibleContext().setAccessibleDescription(
				"This menu does nothing");

		menuItem = new JMenuItem("Retro", KeyEvent.VK_T);
		menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_4,
				ActionEvent.ALT_MASK));
		menuItem.getAccessibleContext().setAccessibleDescription("Show window");

		menuItem.addActionListener(new ControlMenu());

		menu.add(menuItem);

		menuBar.add(menu);

		this.setJMenuBar(menuBar);
	}

}
