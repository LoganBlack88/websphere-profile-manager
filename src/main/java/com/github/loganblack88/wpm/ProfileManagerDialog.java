package com.github.loganblack88.wpm;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableModel;
import java.awt.event.*;

public class ProfileManagerDialog extends JDialog {
	private JPanel contentPane;
	private JButton buttonOK;
	private JButton buttonCancel;
	private JButton buttonApply;
	private JTable tableAppServers;
	private JButton buttonAddAppServer;
	private JTable tableServerProfiles;
	private JButton buttonRunPMT;
	private JButton buttonDeleteProfile;

	public ProfileManagerDialog() {
		setContentPane(contentPane);
		setModal(true);
		getRootPane().setDefaultButton(buttonOK);

		buttonOK.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				onOK();
			}
		});

		buttonCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				onCancel();
			}
		});

		// call onCancel() when cross is clicked
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				onCancel();
			}
		});

		// call onCancel() on ESCAPE
		contentPane.registerKeyboardAction(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				onCancel();
			}
		}, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);

		// Populate tables
		initAppServerTable();
		initServerProfileTable();
	}

	private void initAppServerTable() {
		Object[][] data = new Object[2][2];
		data[0][0] = "WebSphere 8.5.5";
		data[0][1] = "C://Program Files/IBM/WebSphere85/AppServer/";
		data[1][0] = "WebSphere 9.0";
		data[1][1] = "C://Program Files/IBM/WebSphere9/AppServer/";

		String[] columns = new String[2];
		columns[0] = "Installed Runtime Name";
		columns[1] = "Installation Directory";

		TableModel model = new DefaultTableModel(data, columns);
		tableAppServers.setModel(model);
	}

	private void initServerProfileTable() {
		Object[][] data = new Object[2][2];
		data[0][0] = "WasGL";
		data[0][1] = "C://BuildWorkspace/ServerProfiles/Was85GL/";
		data[1][0] = "Was9AC";
		data[1][1] = "C://BuildWorkspace/ServerProfiles/Was9AC/";

		Object[] columns = new Object[2];
		columns[0] = "Profile Name";
		columns[1] = "Profile Location";

		TableModel model = new DefaultTableModel(data, columns);
		tableServerProfiles.setModel(model);
	}

	private void onOK() {
		// add your code here
		dispose();
	}

	private void onCancel() {
		// add your code here if necessary
		dispose();
	}

	public static void main(String[] args) {
		ProfileManagerDialog dialog = new ProfileManagerDialog();
		dialog.setTitle("WebSphere Profile Manager");
		dialog.pack();
		dialog.setVisible(true);
		System.exit(0);
	}

	private void createUIComponents() {
		// TODO: place custom component creation code here
	}
}
