package gui.dialog;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.rmi.Naming;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import control.NhanVienControl;
import entities.NhanVien;
import entities.TaiKhoan;
import gui.FrmMain;

/**
 * Tạo giao diện đăng nhập
 * 
 * @author Gia Hưng ngày 22/10/2019
 */
public class DlgDangNhap extends JDialog implements ActionListener {
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtTaiKhoan;
	private JPasswordField txtMatKhau;
	private JButton btnDangNhap;
	private JButton btnThoat;

	public DlgDangNhap() {
		super((DlgDangNhap) null);
		setResizable(false);
		setTitle("Đăng nhập");
		setIconImage(Toolkit.getDefaultToolkit().getImage(DlgDangNhap.class.getResource("/images/iconLogo.png")));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 565, 353);

		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JPanel pnLoGo = new JPanel();

		JPanel pnDangNhap = new JPanel();

		JLabel lblTitleDN = new JLabel("ĐĂNG NHẬP HỆ THỐNG");
		lblTitleDN.setFont(new Font("Calibri", Font.BOLD, 28));
		lblTitleDN.setHorizontalAlignment(SwingConstants.CENTER);

		JLabel lblTaiKhoan = new JLabel("Tài khoản:");
		lblTaiKhoan.setFont(new Font("Tahoma", Font.PLAIN, 18));

		JLabel lblMatKhau = new JLabel("Mật khẩu:");
		lblMatKhau.setFont(new Font("Tahoma", Font.PLAIN, 18));

		txtTaiKhoan = new JTextField();
		txtTaiKhoan.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtTaiKhoan.setColumns(10);

		txtMatKhau = new JPasswordField();
		txtMatKhau.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtMatKhau.setColumns(10);

		btnDangNhap = new JButton("ĐĂNG NHẬP");
		btnDangNhap.setFocusable(false);
		btnDangNhap.setBorder(new LineBorder(new Color(0, 255, 0), 1, true));
		btnDangNhap.setMnemonic(KeyEvent.VK_ENTER);
		btnDangNhap.setForeground(Color.WHITE);
		btnDangNhap.setBackground(Color.GREEN);
		btnDangNhap.setFont(new Font("Arial", Font.BOLD, 20));

		btnThoat = new JButton("HỦY");
		btnThoat.setFocusable(false);
		btnThoat.setBorder(new LineBorder(new Color(255, 0, 0), 1, true));
		btnThoat.setForeground(Color.WHITE);
		btnThoat.setBackground(new Color(255, 0, 0));
		btnThoat.setFont(new Font("Arial", Font.BOLD, 20));
		GroupLayout gl_pnDangNhap = new GroupLayout(pnDangNhap);
		gl_pnDangNhap.setHorizontalGroup(gl_pnDangNhap.createParallelGroup(Alignment.LEADING).addGroup(gl_pnDangNhap
				.createSequentialGroup()
				.addGroup(gl_pnDangNhap.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_pnDangNhap.createSequentialGroup()
								.addGroup(gl_pnDangNhap.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_pnDangNhap.createSequentialGroup().addContainerGap().addComponent(
												lblTitleDN, GroupLayout.DEFAULT_SIZE, 375, Short.MAX_VALUE))
										.addGroup(gl_pnDangNhap.createSequentialGroup()
												.addGroup(gl_pnDangNhap.createParallelGroup(Alignment.LEADING)
														.addGroup(gl_pnDangNhap.createSequentialGroup().addGap(67)
																.addComponent(btnDangNhap, GroupLayout.PREFERRED_SIZE,
																		130, GroupLayout.PREFERRED_SIZE)
																.addGap(18).addComponent(btnThoat,
																		GroupLayout.PREFERRED_SIZE, 121,
																		GroupLayout.PREFERRED_SIZE))
														.addGroup(gl_pnDangNhap.createSequentialGroup().addGap(22)
																.addGroup(gl_pnDangNhap
																		.createParallelGroup(Alignment.LEADING, false)
																		.addGroup(gl_pnDangNhap.createSequentialGroup()
																				.addComponent(lblMatKhau,
																						GroupLayout.PREFERRED_SIZE, 92,
																						GroupLayout.PREFERRED_SIZE)
																				.addPreferredGap(
																						ComponentPlacement.RELATED)
																				.addComponent(txtMatKhau))
																		.addGroup(gl_pnDangNhap.createSequentialGroup()
																				.addComponent(lblTaiKhoan,
																						GroupLayout.PREFERRED_SIZE, 92,
																						GroupLayout.PREFERRED_SIZE)
																				.addPreferredGap(
																						ComponentPlacement.RELATED)
																				.addComponent(txtTaiKhoan,
																						GroupLayout.PREFERRED_SIZE, 226,
																						GroupLayout.PREFERRED_SIZE)))))
												.addGap(32)))
								.addContainerGap()))));
		gl_pnDangNhap.setVerticalGroup(gl_pnDangNhap.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnDangNhap.createSequentialGroup().addGap(21)
						.addComponent(lblTitleDN, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE).addGap(40)
						.addGroup(gl_pnDangNhap.createParallelGroup(Alignment.LEADING)
								.addComponent(txtTaiKhoan, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblTaiKhoan, GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE))
						.addGap(34)
						.addGroup(gl_pnDangNhap.createParallelGroup(Alignment.LEADING)
								.addComponent(lblMatKhau, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtMatKhau, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE))
						.addGap(26)
						.addGroup(gl_pnDangNhap.createParallelGroup(Alignment.BASELINE)
								.addComponent(btnThoat, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnDangNhap, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE))
						.addGap(23)));
		pnDangNhap.setLayout(gl_pnDangNhap);
		contentPane.setLayout(new BorderLayout(0, 0));
		contentPane.add(pnLoGo, BorderLayout.WEST);
		contentPane.add(pnDangNhap, BorderLayout.CENTER);
		pnLoGo.setLayout(new BorderLayout(0, 0));

		JLabel lblLogo = new JLabel("");
		lblLogo.setBackground(new Color(0, 191, 255));
		lblLogo.setHorizontalAlignment(SwingConstants.CENTER);
		pnLoGo.add(lblLogo);
		ImageIcon icon = new ImageIcon(DlgDangNhap.class.getResource("/images/dangnhap.png"));

		/*
		 * Chỉnh kích thước ảnh
		 */
		lblLogo.setSize(150, 290);
		Dimension size = lblLogo.getSize();
		Image imageResize = icon.getImage().getScaledInstance(size.width, size.height, Image.SCALE_SMOOTH);
		lblLogo.setIcon(new ImageIcon(imageResize));
		contentPane.add(pnLoGo, BorderLayout.WEST);

		txtTaiKhoan.setText("nv003");
		txtMatKhau.setText("000000");

		btnDangNhap.addActionListener(this);
		btnThoat.addActionListener(this);
	}

	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if (o.equals(btnDangNhap)) {

			if (validData()) {

				NhanVienControl nhanVienControl = null;
				try {
					nhanVienControl = (NhanVienControl) Naming.lookup("rmi://localhost:1099/nhanvien");
					TaiKhoan taiKhoan = new TaiKhoan(txtTaiKhoan.getText(), txtMatKhau.getText());
					if (nhanVienControl != null) {
						NhanVien nv = nhanVienControl.layNhanVienTheoTaiKhoan(taiKhoan);
						if (nv != null) {
							new FrmMain(nv).setVisible(true);
							this.dispose();
						} else {
							JOptionPane.showMessageDialog(this, "Tài khoản không tồn tại", "Lỗi",
									JOptionPane.ERROR_MESSAGE);
						}

					}

				} catch (Exception e2) {
					e2.printStackTrace();
					JOptionPane.showMessageDialog(this, "Lối phía máy chủ: " + e2.getMessage());

				}

			}
		} else if (o.equals(btnThoat)) {
			int confirm = JOptionPane.showConfirmDialog(this, "Xác nhận thoát ?", "Thông báo",
					JOptionPane.YES_NO_OPTION);
			if (confirm == JOptionPane.YES_OPTION) {
				System.exit(0);
			}
		}

	}

	public boolean validData() {

		String taiKhoan = txtTaiKhoan.getText().trim();

		String matKhau = txtMatKhau.getText().trim();
		if (taiKhoan.length() == 0 || matKhau.length() == 0) {
			if (taiKhoan.length() == 0) {
				JOptionPane.showMessageDialog(null, "Tên tài khoản không được rỗng!");
				txtTaiKhoan.requestFocus();
				txtTaiKhoan.selectAll();
				return false;
			}
			if (matKhau.length() == 0) {
				JOptionPane.showMessageDialog(null, "Mật khẩu không được rỗng!");
				txtMatKhau.requestFocus();
				txtMatKhau.selectAll();
				return false;
			}
		}

		else if (!(taiKhoan.matches("[a-zA-Z][a-zA-Z0-9]+"))) {
			JOptionPane.showMessageDialog(null, "Tên tài khoản không chứa ký tự đặc biệt, bắt đầu bằng kí tự chữ!");
			txtTaiKhoan.requestFocus();
			txtTaiKhoan.selectAll();
			return false;
		} else if (!(matKhau.matches("[^:&\\.~ ]{6,}"))) {
			JOptionPane.showMessageDialog(null, "Mật khẩu không chứa ký tự đặt biệt và gồm 6 ký tự trở lên!");
			return false;
		}
		return true;
	}

}
