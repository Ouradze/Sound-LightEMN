package view;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import processing.MainProcessing;
import controller.ControlButtonForms;
import controller.ControlChooseSvg;

public class FormsWindow extends JFrame {

	private MainProcessing window;
	JPanel mainPanel = new JPanel(new GridLayout(4, 1));

	public FormsWindow(MainProcessing window) {
		super("Sound & Light-Control");

		this.window = window;
		this.setSize(100, 400);

		this.createForm();

		this.add(mainPanel);
	}

	public void createForm() {
		JPanel panelForm = new JPanel();

		ControlButtonForms controlFormButtons = new ControlButtonForms(
				this.window);

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

		ControlChooseSvg controlSvg = new ControlChooseSvg(this, this.window);

		JButton FormButton9 = new JButton("Import Form");
		FormButton9.addActionListener(controlSvg);
		panelForm.add(FormButton9);

		mainPanel.add(panelForm);
	}
}
