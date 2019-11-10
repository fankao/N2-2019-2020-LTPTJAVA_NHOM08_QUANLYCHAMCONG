package test;

import javax.swing.SwingUtilities;
import javax.swing.UIManager;

import gui.dialog.DlgDangNhap;

public class Testing {
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				try {
					/*
					 * Hiển thị giao diện
					 */
					UIManager.setLookAndFeel("com.jtattoo.plaf.mint.MintLookAndFeel");
					new DlgDangNhap().setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
