package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import entities.NhanVien;
import gui.panel.PnlBangChamCong;
import gui.panel.PnlChamCong;
import gui.panel.PnlQuanLyBangLuong;
import gui.panel.PnlQuanLyNhanVien;
import gui.panel.PnlQuanLyTaiKhoan;
import gui.panel.PnlXemTT_DoiMK;
import test.Testing;

public class FrmMain extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTabbedPane tabChucNang;
	private JPanel pnlTTNhanVien;
	private JPanel pnlChamCong;
	private JPanel pnlQuanLyTTNhanVien;
	private JPanel pnlQuanLyBangChamCong;
	private JPanel pnlQuanlyBangLuong;
	private JPanel pnlQuanlyTaiKhoan;
	private NhanVien nv;
	private JButton btnThoat;

	public FrmMain(NhanVien nv) {
		this.nv = nv;
		setTitle("Ch\u01B0\u01A1ng tr\u00ECnh qu\u1EA3n l\u00FD ch\u1EA5m c\u00F4ng");
		setIconImage(Toolkit.getDefaultToolkit().getImage(FrmMain.class.getResource("/images/iconLogo.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1366, 800);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JPanel pnlNorth = new JPanel();
		pnlNorth.setBackground(new Color(0, 204, 255));
		pnlNorth.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.add(pnlNorth, BorderLayout.NORTH);
		pnlNorth.setLayout(new GridLayout(1, 2, 0, 0));

		JPanel pnlTD = new JPanel();
		pnlTD.setBorder(new EmptyBorder(5, 5, 5, 5));
		pnlTD.setBackground(new Color(0, 204, 255));
		FlowLayout flowLayout = (FlowLayout) pnlTD.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		pnlNorth.add(pnlTD);

		JLabel lblTieuDe = new JLabel("CH\u01AF\u01A0NG TR\u00CCNH QU\u1EA2N L\u00DD CH\u1EA4M C\u00D4NG");
		lblTieuDe.setForeground(Color.WHITE);
		lblTieuDe.setBorder(new EmptyBorder(5, 0, 5, 0));
		pnlTD.add(lblTieuDe);
		lblTieuDe.setFont(new Font("Arial", Font.BOLD, 25));

		JPanel panel = new JPanel();
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		panel.setBackground(new Color(0, 204, 255));
		FlowLayout flowLayout_1 = (FlowLayout) panel.getLayout();
		flowLayout_1.setAlignment(FlowLayout.RIGHT);
		pnlNorth.add(panel);

		btnThoat = new JButton("");
		btnThoat.setFocusable(false);
		btnThoat.setIcon(new ImageIcon(FrmMain.class.getResource("/images/shutdown_32px.png")));
		btnThoat.setBorder(new EmptyBorder(0, 0, 0, 0));
		btnThoat.setBackground(new Color(0, 204, 255));
		panel.add(btnThoat);

		JLabel lblLoiChao = new JLabel("Xin ch\u00E0o, ...");
		lblLoiChao.setForeground(Color.WHITE);
		lblLoiChao.setHorizontalAlignment(SwingConstants.CENTER);
		lblLoiChao.setFont(new Font("Tahoma", Font.BOLD, 20));
		panel.add(lblLoiChao);

		JPanel pnlContent = new JPanel();
		contentPane.add(pnlContent, BorderLayout.CENTER);
		pnlContent.setLayout(new BorderLayout(0, 0));

		tabChucNang = new JTabbedPane(JTabbedPane.TOP);
		tabChucNang.setFont(new Font("Tahoma", Font.PLAIN, 20));
		pnlContent.add(tabChucNang, BorderLayout.CENTER);

		/*
		 * 
		 */

		tabChucNang.setFocusable(false);

		hienThiThanhPhanGiaoDien(nv.getTaiKhoan().getQuyen());

		lblLoiChao.setText("Xin chào, " + nv.getHoVaTen());

		btnThoat.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				int confirm = JOptionPane.showConfirmDialog(null, "Xác nhận thoát khỏi hệ thống ?", "Thoát",
						JOptionPane.YES_NO_OPTION);
				if (confirm == JOptionPane.YES_OPTION) {
					((Window) getRootPane().getParent()).dispose();
					Testing.main(new String[] {});
				}

			}
		});
		

	}

	/**
	 * Hiển thị giao diện theo quyền của nhân viên
	 * 
	 * @param quyen: quyên của tài khoản đăng nhập
	 */
	private void hienThiThanhPhanGiaoDien(int quyen) {

		switch (quyen) {
		case 1:
			pnlTTNhanVien = new JPanel(new BorderLayout());

			pnlChamCong = new JPanel(new BorderLayout());

			pnlChamCong.add(new PnlChamCong(nv));
			pnlTTNhanVien.add(new PnlXemTT_DoiMK(nv));

			tabChucNang.addTab("Thông tin nhân viên", null, pnlTTNhanVien, null);
			tabChucNang.setEnabledAt(0, true);
			tabChucNang.addTab("Chấm công", null, pnlChamCong, null);

			break;
		case 2:
			pnlTTNhanVien = new JPanel(new BorderLayout());

			pnlChamCong = new JPanel(new BorderLayout());

			pnlQuanLyTTNhanVien = new JPanel(new BorderLayout());

			pnlChamCong.add(new PnlChamCong(nv));
			pnlTTNhanVien.add(new PnlXemTT_DoiMK(nv));
			pnlQuanLyTTNhanVien.add(new PnlQuanLyNhanVien(nv));

			tabChucNang.addTab("Thông tin nhân viên", null, pnlTTNhanVien, null);
			tabChucNang.setEnabledAt(0, true);
			tabChucNang.addTab("Chấm công", null, pnlChamCong, null);
			tabChucNang.addTab("Quản lý thông tin nhân viên", null, pnlQuanLyTTNhanVien, null);

			break;
		case 3:
			pnlQuanLyBangChamCong = new JPanel(new BorderLayout());

			pnlQuanlyBangLuong = new JPanel(new BorderLayout());

			pnlQuanlyTaiKhoan = new JPanel(new BorderLayout());

			pnlQuanLyBangChamCong.add(new PnlBangChamCong());
			pnlQuanlyBangLuong.add(new PnlQuanLyBangLuong());
			pnlQuanlyTaiKhoan.add(new PnlQuanLyTaiKhoan());

			tabChucNang.addTab("Quản lý bảng chấm công", null, pnlQuanLyBangChamCong, null);
			tabChucNang.addTab("Quản lý bảng lương", null, pnlQuanlyBangLuong, null);
			tabChucNang.addTab("Quản lý tài khoản", null, pnlQuanlyTaiKhoan, null);

			break;

		default:
			break;
		}
	}

}
