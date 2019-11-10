package gui.panel;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.text.Format;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Locale;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import com.toedter.calendar.JMonthChooser;

import control.ChiTietChamCongControl;
import control.NhanVienControl;
import control.NhanVien_BacLuongControl;
import entities.ChiTietChamCong;
import entities.NhanVien;
import entities.NhanVien_BacLuong;
import entities.PhongBan;
import test.Testing;

public class PnlXemTT_DoiMK extends JPanel implements ActionListener {
	private static final long serialVersionUID = 1L;

	private JTextField txtHoTen;
	private JTextField txtCMND;
	private JTextField txtEmail;
	private JFormattedTextField txtLuongCoBan;
	private JTextField txtSDT;
	private JTextField txtChucVu;
	private JTextField txtPhongBan;
	private JTextField txtBacLuong;
	private JLabel txtNgayLamViec;
	private JLabel txtNgayNghi;
	private JFormattedTextField txtTongLuong;
	private JTextField txtMaNV;
	private JPasswordField pwdNhapMKCu;
	private JPasswordField pwdNhapMKMoi;
	private JPasswordField pwdNhapLaiMKMoi;
	private JButton btnLuuMK;
	private JButton btnHuy;
	private JTextField txtNgaySinh;
	private NhanVien nhanVien;
	private NhanVienControl nhanVienControl;
	private JTextField txtGioiTinh;
	private JButton btnDangXuat;
	private JMonthChooser mtcThang;
	private JButton btnLamMoi;

	/**
	 * Create the panel.
	 */
	public PnlXemTT_DoiMK(NhanVien nv) {
		this.nhanVien = nv;
		setBorder(new EmptyBorder(5, 5, 5, 5));

		JPanel pnlDoiMK = new JPanel();
		pnlDoiMK.setPreferredSize(new Dimension(350, 10));
		pnlDoiMK.setBorder(new TitledBorder(null, "", TitledBorder.CENTER, TitledBorder.ABOVE_TOP, null, null));

		JPanel pnlXemTTNV = new JPanel();
		pnlXemTTNV.setBorder(new TitledBorder(null, "", TitledBorder.CENTER, TitledBorder.TOP, null, null));

		JLabel lblTieuDeXemTT = new JLabel("THÔNG TIN CÁ NHÂN");
		lblTieuDeXemTT.setBorder(new EmptyBorder(5, 5, 5, 5));
		lblTieuDeXemTT.setHorizontalAlignment(SwingConstants.CENTER);
		lblTieuDeXemTT.setFont(new Font("Tahoma", Font.BOLD, 28));

		JPanel pnlTTNV = new JPanel();
		pnlXemTTNV.setLayout(new BorderLayout(5, 15));
		pnlXemTTNV.add(lblTieuDeXemTT, BorderLayout.NORTH);
		pnlXemTTNV.add(pnlTTNV);
		pnlTTNV.setLayout(new GridLayout(0, 1, 0, 0));

		JPanel pnlMaNV = new JPanel();
		pnlTTNV.add(pnlMaNV);

		JLabel lblMaNV = new JLabel("Mã nhân viên:");
		lblMaNV.setHorizontalAlignment(SwingConstants.CENTER);
		lblMaNV.setFont(new Font("Tahoma", Font.PLAIN, 20));

		JPanel pnlHoTen = new JPanel();
		pnlTTNV.add(pnlHoTen);

		JLabel lblHoTen = new JLabel("H\u1ECD v\u00E0 t\u00EAn:");
		pnlHoTen.add(lblHoTen);
		lblHoTen.setFont(new Font("Tahoma", Font.PLAIN, 20));

		txtHoTen = new JTextField();
		txtHoTen.setEditable(false);
		txtHoTen.setFont(new Font("Tahoma", Font.PLAIN, 20));
		pnlHoTen.add(txtHoTen);
		txtHoTen.setColumns(15);///

		JPanel pnlSoCMND = new JPanel();
		pnlTTNV.add(pnlSoCMND);

		JLabel lblSoCMND = new JLabel("S\u1ED1 CMND:");
		pnlSoCMND.add(lblSoCMND);
		lblSoCMND.setFont(new Font("Tahoma", Font.PLAIN, 20));

		txtCMND = new JTextField();
		txtCMND.setEditable(false);
		txtCMND.setFont(new Font("Tahoma", Font.PLAIN, 20));
		pnlSoCMND.add(txtCMND);
		txtCMND.setColumns(15);

		JPanel pnlEmail = new JPanel();
		pnlTTNV.add(pnlEmail);

		JLabel lblEmail = new JLabel("Email:");
		pnlEmail.add(lblEmail);
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 20));

		txtEmail = new JTextField();
		txtEmail.setEditable(false);
		txtEmail.setFont(new Font("Tahoma", Font.PLAIN, 20));
		pnlEmail.add(txtEmail);
		txtEmail.setColumns(15);

		JPanel pnlLuongCB = new JPanel();
		pnlTTNV.add(pnlLuongCB);

		JLabel lblLuongCoBan = new JLabel("L\u01B0\u01A1ng c\u01A1 b\u1EA3n:");
		pnlLuongCB.add(lblLuongCoBan);
		lblLuongCoBan.setFont(new Font("Tahoma", Font.PLAIN, 20));
		Locale locale = new Locale("vi", "VN");
		Format current = NumberFormat.getCurrencyInstance(locale);
		txtLuongCoBan = new JFormattedTextField(current);
		txtLuongCoBan.setEditable(false);
		txtLuongCoBan.setFont(new Font("Tahoma", Font.PLAIN, 20));
		pnlLuongCB.add(txtLuongCoBan);
		txtLuongCoBan.setColumns(15);

		JPanel pnlSDT = new JPanel();
		pnlTTNV.add(pnlSDT);

		JLabel lblSDT = new JLabel("S\u1ED1 \u0111i\u1EC7n tho\u1EA1i:");
		pnlSDT.add(lblSDT);
		lblSDT.setFont(new Font("Tahoma", Font.PLAIN, 20));

		txtSDT = new JTextField();
		txtSDT.setEditable(false);
		txtSDT.setFont(new Font("Tahoma", Font.PLAIN, 20));
		pnlSDT.add(txtSDT);
		txtSDT.setColumns(15);

		JPanel pnlNgaySinh = new JPanel();
		pnlTTNV.add(pnlNgaySinh);

		JLabel lblNgaySinh = new JLabel("Ng\u00E0y sinh:");
		lblNgaySinh.setFont(new Font("Tahoma", Font.PLAIN, 20));

		JPanel pnlChucVu = new JPanel();
		pnlTTNV.add(pnlChucVu);
		/////

		JLabel lblChucVu = new JLabel("Ch\u1EE9c v\u1EE5:");
		pnlChucVu.add(lblChucVu);
		lblChucVu.setFont(new Font("Tahoma", Font.PLAIN, 20));

		txtChucVu = new JTextField();
		txtChucVu.setEditable(false);
		txtChucVu.setFont(new Font("Tahoma", Font.PLAIN, 20));
		pnlChucVu.add(txtChucVu);
		txtChucVu.setColumns(15);

		JPanel pnlPhongBan = new JPanel();
		pnlTTNV.add(pnlPhongBan);

		JLabel lblPhongBan = new JLabel("Ph\u00F2ng ban:");
		pnlPhongBan.add(lblPhongBan);
		lblPhongBan.setFont(new Font("Tahoma", Font.PLAIN, 20));

		txtPhongBan = new JTextField();
		txtPhongBan.setEditable(false);
		txtPhongBan.setFont(new Font("Tahoma", Font.PLAIN, 20));
		pnlPhongBan.add(txtPhongBan);
		txtPhongBan.setColumns(15);

		JPanel pnlGioiTinh = new JPanel();
		pnlTTNV.add(pnlGioiTinh);

		JLabel lblGioiTinh = new JLabel("Gi\u1EDBi t\u00EDnh:");
		lblGioiTinh.setFont(new Font("Tahoma", Font.PLAIN, 20));

		txtGioiTinh = new JTextField();
		txtGioiTinh.setEditable(false);
		txtGioiTinh.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtGioiTinh.setPreferredSize(new Dimension(260, 30));

		JPanel pnlBacLuong = new JPanel();
		pnlTTNV.add(pnlBacLuong);

		JLabel lblBacLuong = new JLabel("Hệ số lương:");
		pnlBacLuong.add(lblBacLuong);
		lblBacLuong.setFont(new Font("Tahoma", Font.PLAIN, 20));

		txtBacLuong = new JTextField();
		txtBacLuong.setEditable(false);
		txtBacLuong.setFont(new Font("Tahoma", Font.PLAIN, 20));
		pnlBacLuong.add(txtBacLuong);
		txtBacLuong.setColumns(15);

		lblMaNV.setPreferredSize(lblLuongCoBan.getPreferredSize());

		txtMaNV = new JTextField();
		txtMaNV.setEditable(false);
		txtMaNV.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtMaNV.setColumns(15);
		pnlMaNV.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		pnlMaNV.add(lblMaNV);
		pnlMaNV.add(txtMaNV);
		lblHoTen.setPreferredSize(lblLuongCoBan.getPreferredSize());
		lblSoCMND.setPreferredSize(lblLuongCoBan.getPreferredSize());
		lblEmail.setPreferredSize(lblLuongCoBan.getPreferredSize());
		lblLuongCoBan.setPreferredSize(lblLuongCoBan.getPreferredSize());
		lblSDT.setPreferredSize(lblLuongCoBan.getPreferredSize());
		pnlNgaySinh.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		lblNgaySinh.setPreferredSize(lblLuongCoBan.getPreferredSize());
		pnlNgaySinh.add(lblNgaySinh);

		txtNgaySinh = new JTextField();
		txtNgaySinh.setEditable(false);
		txtNgaySinh.setFont(new Font("Tahoma", Font.PLAIN, 20));
		pnlNgaySinh.add(txtNgaySinh);
		txtNgaySinh.setColumns(15);
		lblChucVu.setPreferredSize(lblLuongCoBan.getPreferredSize());
		lblPhongBan.setPreferredSize(lblLuongCoBan.getPreferredSize());
		pnlGioiTinh.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		lblGioiTinh.setPreferredSize(lblLuongCoBan.getPreferredSize());
		pnlGioiTinh.add(lblGioiTinh);
		pnlGioiTinh.add(txtGioiTinh);
		lblBacLuong.setPreferredSize(lblLuongCoBan.getPreferredSize());
		setLayout(new BorderLayout(0, 0));
		add(pnlDoiMK, BorderLayout.WEST);
		pnlDoiMK.setLayout(new BorderLayout(0, 0));

		JPanel pnlTieuDeDoiMK = new JPanel();
		FlowLayout flowLayout = (FlowLayout) pnlTieuDeDoiMK.getLayout();
		pnlDoiMK.add(pnlTieuDeDoiMK, BorderLayout.NORTH);

		JLabel lblTieuDeDoiMK = new JLabel("ĐỔI MẬT KHẨU");
		lblTieuDeDoiMK.setBorder(new EmptyBorder(5, 5, 5, 5));
		lblTieuDeDoiMK.setHorizontalAlignment(SwingConstants.CENTER);
		lblTieuDeDoiMK.setFont(new Font("Tahoma", Font.BOLD, 28));
		pnlTieuDeDoiMK.add(lblTieuDeDoiMK);

		JPanel pnlNhap = new JPanel();
		pnlDoiMK.add(pnlNhap, BorderLayout.CENTER);

		JPanel pnlNhapMKCu = new JPanel();

		JPanel pnlNhapMKMoi = new JPanel();

		JLabel lblNhapMKMoi = new JLabel("Nhập mật khẩu mới:");
		lblNhapMKMoi.setHorizontalAlignment(SwingConstants.CENTER);
		lblNhapMKMoi.setFont(new Font("Tahoma", Font.PLAIN, 20));
		pnlNhapMKMoi.add(lblNhapMKMoi);

		JPanel pnlNhapLaiMKMoi = new JPanel();

		JLabel lblNhapLaiMKMoi = new JLabel("Nhập lại mật khẩu mới:");
		lblNhapLaiMKMoi.setHorizontalAlignment(SwingConstants.CENTER);
		lblNhapLaiMKMoi.setFont(new Font("Tahoma", Font.PLAIN, 20));
		pnlNhapLaiMKMoi.add(lblNhapLaiMKMoi);
		GroupLayout gl_pnlNhap = new GroupLayout(pnlNhap);
		gl_pnlNhap.setHorizontalGroup(gl_pnlNhap.createParallelGroup(Alignment.LEADING)
				.addComponent(pnlNhapMKCu, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 225, Short.MAX_VALUE)
				.addComponent(pnlNhapMKMoi, GroupLayout.DEFAULT_SIZE, 275, Short.MAX_VALUE)
				.addComponent(pnlNhapLaiMKMoi, GroupLayout.DEFAULT_SIZE, 275, Short.MAX_VALUE));
		gl_pnlNhap.setVerticalGroup(gl_pnlNhap.createParallelGroup(Alignment.LEADING).addGroup(gl_pnlNhap
				.createSequentialGroup().addGap(84)
				.addComponent(pnlNhapMKCu, GroupLayout.PREFERRED_SIZE, 82, GroupLayout.PREFERRED_SIZE).addGap(51)
				.addComponent(pnlNhapMKMoi, GroupLayout.PREFERRED_SIZE, 82, GroupLayout.PREFERRED_SIZE).addGap(52)
				.addComponent(pnlNhapLaiMKMoi, GroupLayout.PREFERRED_SIZE, 82, GroupLayout.PREFERRED_SIZE)
				.addContainerGap(193, Short.MAX_VALUE)));

		pwdNhapLaiMKMoi = new JPasswordField();
		pwdNhapLaiMKMoi.setHorizontalAlignment(SwingConstants.CENTER);
		pwdNhapLaiMKMoi.setFont(new Font("Tahoma", Font.PLAIN, 20));
		pwdNhapLaiMKMoi.setColumns(15);
		pnlNhapLaiMKMoi.add(pwdNhapLaiMKMoi);

		pwdNhapMKMoi = new JPasswordField();
		pwdNhapMKMoi.setHorizontalAlignment(SwingConstants.CENTER);
		pwdNhapMKMoi.setFont(new Font("Tahoma", Font.PLAIN, 20));
		pwdNhapMKMoi.setColumns(15);
		pnlNhapMKMoi.add(pwdNhapMKMoi);

		JLabel lblNhapMKCu = new JLabel("Nhập mật khẩu cũ:");
		lblNhapMKCu.setHorizontalAlignment(SwingConstants.CENTER);
		lblNhapMKCu.setFont(new Font("Tahoma", Font.PLAIN, 20));
		pnlNhapMKCu.add(lblNhapMKCu);

		pwdNhapMKCu = new JPasswordField();
		pwdNhapMKCu.setHorizontalAlignment(SwingConstants.CENTER);
		pwdNhapMKCu.setFont(new Font("Tahoma", Font.PLAIN, 20));
		pwdNhapMKCu.setColumns(15);
		pnlNhapMKCu.add(pwdNhapMKCu);
		pnlNhap.setLayout(gl_pnlNhap);

		JPanel pnlChucNang = new JPanel();
		pnlDoiMK.add(pnlChucNang, BorderLayout.SOUTH);

		btnHuy = new JButton("Hủy");
		btnHuy.setIcon(new ImageIcon(PnlXemTT_DoiMK.class.getResource("/images/cancel_32px.png")));
		btnHuy.setFont(new Font("Tahoma", Font.PLAIN, 15));

		btnLuuMK = new JButton("Lưu thay đổi");
		btnLuuMK.setHorizontalAlignment(SwingConstants.LEFT);
		btnLuuMK.setIcon(new ImageIcon(PnlXemTT_DoiMK.class.getResource("/images/save_32px.png")));
		btnLuuMK.setFont(new Font("Tahoma", Font.PLAIN, 15));
		GroupLayout gl_pnlChucNang = new GroupLayout(pnlChucNang);
		gl_pnlChucNang
				.setHorizontalGroup(gl_pnlChucNang.createParallelGroup(Alignment.TRAILING).addGroup(Alignment.LEADING,
						gl_pnlChucNang.createSequentialGroup().addContainerGap().addComponent(btnLuuMK)
								.addPreferredGap(ComponentPlacement.RELATED, 51, Short.MAX_VALUE)
								.addComponent(btnHuy, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)
								.addContainerGap()));
		gl_pnlChucNang.setVerticalGroup(gl_pnlChucNang.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_pnlChucNang.createSequentialGroup()
						.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addGroup(gl_pnlChucNang.createParallelGroup(Alignment.LEADING)
								.addComponent(btnHuy, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnLuuMK, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
						.addContainerGap()));
		pnlChucNang.setLayout(gl_pnlChucNang);
		add(pnlXemTTNV);

		JPanel pnlXemTTLuong = new JPanel();
		pnlXemTTLuong.setPreferredSize(new Dimension(400, 10));
		pnlXemTTLuong.setBorder(new TitledBorder(null, "", TitledBorder.CENTER, TitledBorder.TOP, null, null));
		add(pnlXemTTLuong, BorderLayout.EAST);
		pnlXemTTLuong.setLayout(new BorderLayout(0, 0));

		JLabel lblTieuDeTTLuong = new JLabel("THÔNG TIN LƯƠNG");
		lblTieuDeTTLuong.setBorder(new EmptyBorder(5, 5, 5, 5));
		lblTieuDeTTLuong.setHorizontalAlignment(SwingConstants.CENTER);
		lblTieuDeTTLuong.setFont(new Font("Tahoma", Font.BOLD, 28));
		pnlXemTTLuong.add(lblTieuDeTTLuong, BorderLayout.NORTH);

		JPanel pnlTTLuong = new JPanel();
		pnlXemTTLuong.add(pnlTTLuong, BorderLayout.CENTER);
		pnlTTLuong.setLayout(new GridLayout(0, 1, 0, 0));

		JPanel pnlThang = new JPanel();
		pnlTTLuong.add(pnlThang);

		JPanel pnlNgayLamViec = new JPanel();
		pnlTTLuong.add(pnlNgayLamViec);

		JLabel lblNgayLamViec = new JLabel("Ngày làm việc:");
		lblNgayLamViec.setFont(new Font("Tahoma", Font.PLAIN, 20));

		txtNgayLamViec = new JLabel();
		txtNgayLamViec.setPreferredSize(new Dimension(100, 30));
		txtNgayLamViec.setFont(new Font("Tahoma", Font.PLAIN, 20));
		GroupLayout gl_pnlNgayLamViec = new GroupLayout(pnlNgayLamViec);
		gl_pnlNgayLamViec.setHorizontalGroup(gl_pnlNgayLamViec.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlNgayLamViec.createSequentialGroup().addGap(40)
						.addComponent(lblNgayLamViec, GroupLayout.PREFERRED_SIZE, 135, GroupLayout.PREFERRED_SIZE)
						.addGap(10).addComponent(txtNgayLamViec, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addContainerGap(42, Short.MAX_VALUE)));
		gl_pnlNgayLamViec.setVerticalGroup(gl_pnlNgayLamViec.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlNgayLamViec.createSequentialGroup().addGap(36)
						.addGroup(gl_pnlNgayLamViec.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_pnlNgayLamViec.createSequentialGroup().addGap(3)
										.addComponent(lblNgayLamViec))
								.addComponent(txtNgayLamViec, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE))
						.addContainerGap(35, Short.MAX_VALUE)));
		pnlNgayLamViec.setLayout(gl_pnlNgayLamViec);

		JPanel pnlNgayNghi = new JPanel();
		pnlTTLuong.add(pnlNgayNghi);

		JLabel lblNgayNghi = new JLabel("Ngày nghỉ:");
		lblNgayNghi.setFont(new Font("Tahoma", Font.PLAIN, 20));

		txtNgayNghi = new JLabel();
		txtNgayNghi.setPreferredSize(new Dimension(100, 30));
		txtNgayNghi.setFont(new Font("Tahoma", Font.PLAIN, 20));

		JPanel pnlTongLuong = new JPanel();
		pnlTTLuong.add(pnlTongLuong);

		JLabel lblTongLuong = new JLabel("Tổng lương:");
		lblTongLuong.setFont(new Font("Tahoma", Font.PLAIN, 20));
		Format format = NumberFormat.getCurrencyInstance(new Locale("vi", "VN"));
		txtTongLuong = new JFormattedTextField(format);
		txtTongLuong.setValue(0);
		txtTongLuong.setEditable(false);
		txtTongLuong.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtTongLuong.setColumns(10);

		JPanel pnlTrong1 = new JPanel();
		pnlTTLuong.add(pnlTrong1);

		btnLamMoi = new JButton("Làm mới");
		btnLamMoi.setIcon(new ImageIcon(PnlXemTT_DoiMK.class.getResource("/images/synchronize_32px.png")));
		btnLamMoi.setFont(new Font("Tahoma", Font.PLAIN, 17));
		pnlTrong1.add(btnLamMoi);

		JPanel pnlTrong2 = new JPanel();
		pnlTTLuong.add(pnlTrong2);

		JPanel pnlDangXuat = new JPanel();
		pnlTTLuong.add(pnlDangXuat);

		btnDangXuat = new JButton("Đăng xuất");
		btnDangXuat.setIcon(new ImageIcon(PnlXemTT_DoiMK.class.getResource("/images/shutdown_32px.png")));
		btnDangXuat.setFont(new Font("Tahoma", Font.PLAIN, 17));
		GroupLayout gl_pnlDangXuat = new GroupLayout(pnlDangXuat);
		gl_pnlDangXuat.setHorizontalGroup(gl_pnlDangXuat.createParallelGroup(Alignment.LEADING).addGroup(gl_pnlDangXuat
				.createSequentialGroup().addGap(126).addComponent(btnDangXuat).addContainerGap(125, Short.MAX_VALUE)));
		gl_pnlDangXuat
				.setVerticalGroup(gl_pnlDangXuat.createParallelGroup(Alignment.LEADING).addGroup(Alignment.TRAILING,
						gl_pnlDangXuat.createSequentialGroup().addContainerGap(54, Short.MAX_VALUE)
								.addComponent(btnDangXuat, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
								.addContainerGap()));
		pnlDangXuat.setLayout(gl_pnlDangXuat);

		JLabel lblThang = new JLabel("Chọn tháng:");
		lblThang.setFont(new Font("Tahoma", Font.PLAIN, 20));

		mtcThang = new JMonthChooser();
		mtcThang.getComboBox().setPreferredSize(new Dimension(100, 30));
		mtcThang.setBorder(new EmptyBorder(2, 2, 2, 2));
		mtcThang.setPreferredSize(new Dimension(180, 35));
		mtcThang.getSpinner().setPreferredSize(new Dimension(170, 35));
		mtcThang.getComboBox().setFont(new Font("Tahoma", Font.PLAIN, 18));
		mtcThang.getSpinner().setFont(new Font("Tahoma", Font.PLAIN, 20));
		mtcThang.setAutoscrolls(true);
		BorderLayout bl_mtcThang = (BorderLayout) mtcThang.getLayout();
		mtcThang.setLocale(new Locale("vi"));
		GroupLayout gl_pnlThang = new GroupLayout(pnlThang);
		gl_pnlThang.setHorizontalGroup(gl_pnlThang.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlThang.createSequentialGroup().addGap(40)
						.addComponent(lblThang, GroupLayout.PREFERRED_SIZE, 135, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED).addComponent(mtcThang, GroupLayout.PREFERRED_SIZE,
								GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addGap(51)));
		gl_pnlThang.setVerticalGroup(gl_pnlThang.createParallelGroup(Alignment.LEADING).addGroup(gl_pnlThang
				.createSequentialGroup()
				.addGroup(gl_pnlThang.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_pnlThang.createSequentialGroup().addGap(39).addComponent(lblThang))
						.addGroup(gl_pnlThang.createSequentialGroup().addGap(34).addComponent(mtcThang,
								GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
				.addContainerGap(33, Short.MAX_VALUE)));
		pnlThang.setLayout(gl_pnlThang);
		lblNgayNghi.setPreferredSize(lblNgayLamViec.getPreferredSize());
		GroupLayout gl_pnlNgayNghi = new GroupLayout(pnlNgayNghi);
		gl_pnlNgayNghi
				.setHorizontalGroup(gl_pnlNgayNghi.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_pnlNgayNghi.createSequentialGroup().addGap(42)
								.addComponent(lblNgayNghi, GroupLayout.PREFERRED_SIZE, 135, GroupLayout.PREFERRED_SIZE)
								.addGap(10).addComponent(txtNgayNghi, GroupLayout.PREFERRED_SIZE,
										GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addContainerGap(41, Short.MAX_VALUE)));
		gl_pnlNgayNghi.setVerticalGroup(gl_pnlNgayNghi.createParallelGroup(Alignment.LEADING).addGroup(gl_pnlNgayNghi
				.createSequentialGroup().addGap(36)
				.addGroup(gl_pnlNgayNghi.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_pnlNgayNghi.createSequentialGroup().addGap(3).addComponent(lblNgayNghi,
								GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addComponent(txtNgayNghi, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE))
				.addContainerGap(35, Short.MAX_VALUE)));
		pnlNgayNghi.setLayout(gl_pnlNgayNghi);
		lblTongLuong.setPreferredSize(lblNgayLamViec.getPreferredSize());
		GroupLayout gl_pnlTongLuong = new GroupLayout(pnlTongLuong);
		gl_pnlTongLuong
				.setHorizontalGroup(gl_pnlTongLuong.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_pnlTongLuong.createSequentialGroup().addGap(42)
								.addComponent(lblTongLuong, GroupLayout.PREFERRED_SIZE, 135, GroupLayout.PREFERRED_SIZE)
								.addGap(10).addComponent(txtTongLuong, GroupLayout.PREFERRED_SIZE,
										GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addContainerGap(41, Short.MAX_VALUE)));
		gl_pnlTongLuong.setVerticalGroup(gl_pnlTongLuong.createParallelGroup(Alignment.LEADING).addGroup(gl_pnlTongLuong
				.createSequentialGroup().addGap(36)
				.addGroup(gl_pnlTongLuong.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_pnlTongLuong.createSequentialGroup().addGap(3).addComponent(lblTongLuong,
								GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addComponent(txtTongLuong, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE))
				.addContainerGap(35, Short.MAX_VALUE)));
		pnlTongLuong.setLayout(gl_pnlTongLuong);

		/*
		 * Hiện thông tin nhân viên
		 */
		hienThongTinNhanVien(nv);

		hienThongTinLuong(nv, LocalDate.now().getMonthValue());

		ganSuKien();

	}

	private void hienThongTinNhanVien(NhanVien nvs) {
		txtMaNV.setText(nvs.getMaNV());
		txtHoTen.setText(nvs.getHoVaTen());
		txtCMND.setText(nvs.getSoCMND());
		txtEmail.setText(nvs.getEmail());

		txtLuongCoBan.setValue(nvs.getLuongCoBan());

		DateTimeFormatter dfm = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		txtNgaySinh.setText(nvs.getNgaySinh().format(dfm));

		String chucVu = nvs.getTaiKhoan().getQuyen() == 1 ? "Nhân viên" : "Trưởng phòng";
		txtChucVu.setText(chucVu);
		txtSDT.setText(nvs.getSoDienThoai());

		PhongBan phongBan = nvs.getPhongBan();
		txtPhongBan.setText(phongBan.getTenPB());

		String gioiTinh = nvs.isGioiTinh() ? "Nam" : "Nữ";
		txtGioiTinh.setText(gioiTinh);

		try {
			NhanVien_BacLuongControl luongControl = (NhanVien_BacLuongControl) Naming
					.lookup("rmi://localhost:1099/chitietluong");
			NhanVien_BacLuong ctluong = luongControl.layChiTietLuongTheoIdNV(nvs.getId());
			double heSo = 0.0;
			if (ctluong != null) {
				heSo = ctluong.getBacLuong().getHeSo();
			}
			txtBacLuong.setText(heSo + "");
		} catch (MalformedURLException | RemoteException | NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private void hienThongTinLuong(NhanVien nv, int thang) {
		try {
			ChiTietChamCongControl chamCongControl = (ChiTietChamCongControl) Naming
					.lookup("rmi://localhost:1099/chitietchamcong");
			List<ChiTietChamCong> chamCongs = chamCongControl.layDSCTNhanVienChamTheoThang(nv.getId(), thang);
			int soNgayCham = chamCongControl.tinhNgayDaChamCongTheoThang(nv, thang);

			txtNgayLamViec.setText(soNgayCham + "");
			txtNgayNghi.setText((26 - soNgayCham) + "");

			double luong = nv.getLuongCoBan() / 26 * soNgayCham;
			txtTongLuong.setValue(luong);

		} catch (Exception e) {
			JOptionPane.showConfirmDialog(null, "Lỗi máy chủ: " + e.getMessage());
		}

	}

	public void ganSuKien() {
		btnLuuMK.addActionListener(this);
		btnHuy.addActionListener(this);
		btnDangXuat.addActionListener(this);
		btnLamMoi.addActionListener(this);

	}

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object o = e.getSource();
		if (o.equals(btnLuuMK)) {
			if (kiemTraNhapMatKhau()) {
				int confirm = JOptionPane.showConfirmDialog(this, "Xác nhận đổi mật khẩu ?", "Đổi mật khẩu",
						JOptionPane.YES_NO_OPTION);
				if (confirm == JOptionPane.YES_OPTION) {
					try {

						nhanVienControl = (NhanVienControl) Naming.lookup("rmi://localhost:1099/nhanvien");

						nhanVien.getTaiKhoan().setMatKhau(pwdNhapMKMoi.getText());
						NhanVien nvUpdate = nhanVienControl.suaNhanVien(nhanVien);
						if (nvUpdate != null) {
							JOptionPane.showMessageDialog(this, "Đổi mật khẩu thành công. Mời đăng nhập lại",
									"Thông báo", JOptionPane.INFORMATION_MESSAGE);
							((Window) getRootPane().getParent()).dispose();
							Testing.main(new String[] {});
						}
					} catch (MalformedURLException | RemoteException | NotBoundException e1) {
						System.out.println("Lỗi phía máy chủ: " + e1.getMessage());
					}
				}

			}
		} else if (o.equals(btnHuy)) {
			pwdNhapLaiMKMoi.setText("");
			pwdNhapMKCu.setText("");
			pwdNhapMKMoi.setText("");
			pwdNhapMKCu.requestFocus();
		} else if (o.equals(btnDangXuat)) {
			int confirm = JOptionPane.showConfirmDialog(this, "Xác nhận thoát khỏi hệ thống ?", "Thoát",
					JOptionPane.YES_NO_OPTION);
			if (confirm == JOptionPane.YES_OPTION) {
				((Window) getRootPane().getParent()).dispose();
				Testing.main(new String[] {});
			}
		} else if (o.equals(btnLamMoi)) {
			hienThongTinLuong(nhanVien, mtcThang.getMonth() + 1);
		}

	}

	public boolean kiemTraNhapMatKhau() {
		String matKhauCu = pwdNhapMKCu.getText().trim();
		String matKhauMoi = pwdNhapMKMoi.getText().trim();
		String nhapLaiMKMoi = pwdNhapLaiMKMoi.getText().trim();

		if (!(matKhauCu.length() >= 6)) {
			JOptionPane.showMessageDialog(pwdNhapMKCu,
					"Mật khẩu cũ không được rỗng, từ 6 kí tự trở lên !\n Vui lòng nhập mật khẩu cũ");
			pwdNhapMKCu.requestFocus();
			return false;
		}
		if (!(matKhauMoi.length() >= 6)) {
			JOptionPane.showMessageDialog(pwdNhapMKMoi,
					"Mật khẩu mới không được rỗng, phải từ 6 kí tự trở lên !\n Vui lòng nhập mật khẩu mới");
			pwdNhapMKMoi.requestFocus();
			return false;
		}
		if (!(nhapLaiMKMoi.length() >= 6)) {
			JOptionPane.showMessageDialog(pwdNhapLaiMKMoi,
					"Xác nhận mật khẩu mới không được rỗng, phải từ 6 kí tự trở lên  !\n Vui lòng nhập lại mật khẩu mới");
			pwdNhapLaiMKMoi.requestFocus();
			return false;
		}

		if (!matKhauCu.equals(nhanVien.getTaiKhoan().getMatKhau())) {
			JOptionPane.showMessageDialog(pwdNhapMKCu, "Mật khẩu không đúng!");
			pwdNhapMKCu.requestFocus();
			return false;
		}

		if (!matKhauMoi.equals(nhapLaiMKMoi)) {
			JOptionPane.showMessageDialog(pwdNhapLaiMKMoi, "Xác nhận mật khẩu mới không giống \n với mật khẩu vừa!");
			pwdNhapLaiMKMoi.requestFocus();
			return false;
		}

		if (!(matKhauMoi.matches("[^:&\\.~ ]{6,}"))) {
			JOptionPane.showMessageDialog(null, "Mật khẩu không chứa ký tự đặt biệt và gồm 6 ký tự trở lên!");
			pwdNhapMKMoi.requestFocus();
			return false;
		}
		if (!(nhapLaiMKMoi.matches("[^:&\\.~ ]{6,}"))) {
			JOptionPane.showMessageDialog(null, "Xác nhận mật khẩu không chứa ký tự đặt biệt và gồm 6 ký tự trở lên!");
			pwdNhapMKMoi.requestFocus();
			return false;
		}

		return true;
	}
}
