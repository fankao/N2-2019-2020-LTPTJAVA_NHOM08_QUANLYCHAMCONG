package gui.panel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import control.BacLuongConTrol;
import control.NhanVienControl;
import control.NhanVien_BacLuongControl;
import control.PhongBanControl;
import entities.BacLuong;
import entities.NhanVien;
import entities.NhanVien_BacLuong;
import entities.PhongBan;
import entities.TaiKhoan;
import utils.TienIch;

public class PnlQuanLyTaiKhoan extends JPanel implements ActionListener {
	private static final long serialVersionUID = 1L;

	private JTable tblDSNhanVien;
	private JTextField txtMaNV;
	private JTextField txtTenNV;
	private static JTextField txtChucVu;
	private JTextField txtTenTaiKhoan;
	private JTextField txtMatKhau;
	private JComboBox<Integer> cbbQuyen;
	private DefaultComboBoxModel<String> modelQuyen;
	private JPanel pnlQuyen;
	private NhanVienControl nhanVienControl;
	private static List<NhanVien> dsNhanVien;
	private DefaultTableModel tblModel;
	private JPanel pnButton;
	private JPanel pnChonPB;
	private JComboBox<PhongBan> cbbChonPB;
	private DefaultComboBoxModel<PhongBan> modelPhongban;
	private List<PhongBan> dspb;
	private JButton btnLuu;
	private JButton btnXoa;
	private JLabel lblQuyen;
	private PhongBanControl phongbanControl;
	private JButton btnSua;
	private JButton btnHuy;

	private BacLuongConTrol bacLuongConTrol;
	private NhanVien_BacLuongControl chiTietLuongControl;
	private JCheckBox chkBacLuong;
	private JCheckBox chkChonPB;
	private JComboBox<PhongBan> cmbChonPhongBan;
	private JComboBox<BacLuong> cmbBacLuong;

	public PnlQuanLyTaiKhoan() {
		setLayout(new BorderLayout(0, 0));

		JPanel pnlTieuDe = new JPanel();
		add(pnlTieuDe, BorderLayout.NORTH);

		JLabel lblTieuDe = new JLabel("QUẢN LÝ TÀI KHOẢN");
		lblTieuDe.setFont(new Font("Tahoma", Font.BOLD, 28));
		pnlTieuDe.add(lblTieuDe);

		JPanel pnQuanLy = new JPanel();
		add(pnQuanLy, BorderLayout.CENTER);
		pnQuanLy.setLayout(new BorderLayout(0, 0));

		JPanel pnlThongTinTaiKhoan = new JPanel();

		pnlThongTinTaiKhoan.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)),
				"Th\u00F4ng tin t\u00E0i kho\u1EA3n nh\u00E2n vi\u00EAn", TitledBorder.LEADING, TitledBorder.TOP, null,
				new Color(0, 0, 0)));

		pnQuanLy.add(pnlThongTinTaiKhoan, BorderLayout.NORTH);
		pnlThongTinTaiKhoan.setLayout(new GridLayout(6, 0, 0, 0));

		JPanel panel = new JPanel();
		FlowLayout flowLayout_2 = (FlowLayout) panel.getLayout();
		flowLayout_2.setAlignment(FlowLayout.LEFT);
		pnlThongTinTaiKhoan.add(panel);

		JLabel lblMaNV = new JLabel("Mã nhân viên:");
		panel.add(lblMaNV);
		lblMaNV.setFont(new Font("Tahoma", Font.PLAIN, 20));

		txtMaNV = new JTextField();
		txtMaNV.setEditable(false);
		txtMaNV.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panel.add(txtMaNV);
		txtMaNV.setColumns(15);

		JPanel panel_1 = new JPanel();
		FlowLayout flowLayout_3 = (FlowLayout) panel_1.getLayout();
		flowLayout_3.setAlignment(FlowLayout.LEFT);
		pnlThongTinTaiKhoan.add(panel_1);

		JLabel lblTenNV = new JLabel("Tên nhân viên:");
		lblTenNV.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panel_1.add(lblTenNV);

		txtTenNV = new JTextField();
		txtTenNV.setEditable(false);
		txtTenNV.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panel_1.add(txtTenNV);
		txtTenNV.setColumns(15);

		JPanel panel_3 = new JPanel();
		FlowLayout flowLayout_4 = (FlowLayout) panel_3.getLayout();
		flowLayout_4.setAlignment(FlowLayout.LEFT);
		pnlThongTinTaiKhoan.add(panel_3);

		JLabel lblChucVu = new JLabel("Chức vụ:");
		lblChucVu.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panel_3.add(lblChucVu);

		txtChucVu = new JTextField();
		txtChucVu.setEditable(false);
		txtChucVu.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panel_3.add(txtChucVu);
		txtChucVu.setColumns(15);

		JPanel panel_4 = new JPanel();
		FlowLayout flowLayout_5 = (FlowLayout) panel_4.getLayout();
		flowLayout_5.setAlignment(FlowLayout.LEFT);
		pnlThongTinTaiKhoan.add(panel_4);

		JLabel lblTenTaiKhoan = new JLabel("Tên tài khoản:");
		lblTenTaiKhoan.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panel_4.add(lblTenTaiKhoan);

		txtTenTaiKhoan = new JTextField();
		txtTenTaiKhoan.setEditable(false);
		txtTenTaiKhoan.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panel_4.add(txtTenTaiKhoan);
		txtTenTaiKhoan.setColumns(15);

		JPanel panel_5 = new JPanel();
		FlowLayout flowLayout_7 = (FlowLayout) panel_5.getLayout();
		flowLayout_7.setAlignment(FlowLayout.LEFT);
		pnlThongTinTaiKhoan.add(panel_5);

		JLabel lblMatKhau = new JLabel("Mật khẩu:");
		lblMatKhau.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panel_5.add(lblMatKhau);

		txtMatKhau = new JTextField();
		txtMatKhau.setEditable(false);
		txtMatKhau.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panel_5.add(txtMatKhau);
		txtMatKhau.setColumns(15);

		JPanel pnlBangThongTinNV = new JPanel();
		pnlBangThongTinNV.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)),
				"B\u1EA3ng danh s\u00E1ch nh\u00E2n vi\u00EAn c\u1EE7a ph\u00F2ng ban", TitledBorder.LEADING,
				TitledBorder.TOP, null, new Color(0, 0, 0)));
		pnQuanLy.add(pnlBangThongTinNV, BorderLayout.CENTER);
		pnlBangThongTinNV.setLayout(new BorderLayout(0, 0));

		JPanel pnCN = new JPanel();
		pnlBangThongTinNV.add(pnCN, BorderLayout.NORTH);
		pnCN.setLayout(new GridLayout(0, 2, 0, 0));

		pnChonPB = new JPanel();
		FlowLayout flowLayout = (FlowLayout) pnChonPB.getLayout();
		flowLayout.setVgap(10);
		flowLayout.setAlignment(FlowLayout.LEFT);
		pnCN.add(pnChonPB);

		JLabel lblChonPB = new JLabel("Chọn phòng ban:");
		pnChonPB.add(lblChonPB);
		lblChonPB.setFont(new Font("Tahoma", Font.PLAIN, 20));

		cbbChonPB = new JComboBox<PhongBan>();
		pnChonPB.add(cbbChonPB);
		cbbChonPB.setMaximumRowCount(15);
		cbbChonPB.setFont(new Font("Tahoma", Font.PLAIN, 20));
		cbbChonPB.setPreferredSize(new Dimension(260, 25));

		pnButton = new JPanel();
		FlowLayout flowLayout_1 = (FlowLayout) pnButton.getLayout();
		flowLayout_1.setAlignment(FlowLayout.RIGHT);
		pnCN.add(pnButton);

		btnSua = new JButton("Cập nhật");
		btnSua.setIcon(new ImageIcon(PnlQuanLyTaiKhoan.class.getResource("/images/pencil_tip_32px.png")));
		btnSua.setEnabled(false);
		btnSua.setFont(new Font("Tahoma", Font.PLAIN, 17));
		pnButton.add(btnSua);

		btnXoa = new JButton("Xoá");
		btnXoa.setIcon(new ImageIcon(PnlQuanLyTaiKhoan.class.getResource("/images/delete_32px.png")));
		btnXoa.setEnabled(false);
		btnXoa.setFont(new Font("Tahoma", Font.PLAIN, 17));
		pnButton.add(btnXoa);

		btnLuu = new JButton("Lưu");
		btnLuu.setIcon(new ImageIcon(PnlQuanLyTaiKhoan.class.getResource("/images/save_32px.png")));
		btnLuu.setEnabled(false);
		btnLuu.setFont(new Font("Tahoma", Font.PLAIN, 17));
		pnButton.add(btnLuu);

		btnHuy = new JButton("Huỷ bỏ");
		btnHuy.setIcon(new ImageIcon(PnlQuanLyTaiKhoan.class.getResource("/images/cancel_2_32px.png")));
		btnHuy.setEnabled(false);
		btnHuy.setFont(new Font("Tahoma", Font.PLAIN, 17));
		pnButton.add(btnHuy);

		JPanel pnlBangTTNV = new JPanel();
		pnlBangTTNV.setBorder(new CompoundBorder(new LineBorder(new Color(0, 0, 0), 2), new EmptyBorder(2, 2, 2, 2)));
		pnlBangThongTinNV.add(pnlBangTTNV, BorderLayout.CENTER);
		pnlBangTTNV.setLayout(new BorderLayout(0, 0));

		pnlQuyen = new JPanel();
		FlowLayout flowLayout_6 = (FlowLayout) pnlQuyen.getLayout();
		flowLayout_6.setAlignment(FlowLayout.LEFT);
		pnlThongTinTaiKhoan.add(pnlQuyen);

		lblQuyen = new JLabel("Quyền:");
		lblQuyen.setFont(new Font("Tahoma", Font.PLAIN, 20));
		pnlQuyen.add(lblQuyen);

		modelQuyen = new DefaultComboBoxModel<String>();
		modelQuyen.addElement("Nhân viên");
		modelQuyen.addElement("Trưởng phòng");
		cbbQuyen = new JComboBox(modelQuyen);
		cbbQuyen.setFont(new Font("Tahoma", Font.PLAIN, 20));
		cbbQuyen.setEnabled(false);

		//
		pnlQuyen.add(cbbQuyen);
		cbbQuyen.setPreferredSize(new Dimension(260, 25));

		/*
		 * Hiện danh sách nhân viên
		 */
		try {
			nhanVienControl = (NhanVienControl) Naming.lookup("rmi://localhost:1099/nhanvien");
		} catch (MalformedURLException | RemoteException | NotBoundException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(this, "Lỗi phía máy chủ: " + e.getMessage(), "Lỗi",
					JOptionPane.ERROR_MESSAGE);
		}

		String[] tieuDe = { "STT", "Mã nhân viên", "Họ và tên", "Giới tính", "Ngày sinh", "Chức vụ", "Tài khoản",
				"Bậc lương" };
		tblDSNhanVien = new JTable(new DefaultTableModel(tieuDe, 0)) {
			private static final long serialVersionUID = 1L;

			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		tblDSNhanVien.setFillsViewportHeight(true);
		tblDSNhanVien.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tblDSNhanVien.setFont(new Font("Arial", Font.PLAIN, 15));

		tblDSNhanVien.setRowHeight(30);
		tblDSNhanVien.getTableHeader().setFont(new Font("arial", Font.BOLD, 15));
		tblDSNhanVien.getColumnModel().getColumn(0).setPreferredWidth(10);
		tblDSNhanVien.getColumnModel().getColumn(1).setPreferredWidth(15);
		tblDSNhanVien.getColumnModel().getColumn(3).setPreferredWidth(45);

		pnlBangTTNV.add(new JScrollPane(tblDSNhanVien));

		lblMaNV.setPreferredSize(lblChonPB.getPreferredSize());
		lblChucVu.setPreferredSize(lblChonPB.getPreferredSize());

		JLabel lblHeSo = new JLabel("Chọn bậc lương:");
		lblHeSo.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panel_3.add(lblHeSo);

		cmbBacLuong = new JComboBox();
		cmbBacLuong.setEnabled(false);
		cmbBacLuong.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panel_3.add(cmbBacLuong);

		chkBacLuong = new JCheckBox("Chọn lại bậc lương");
		chkBacLuong.setEnabled(false);
		chkBacLuong.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panel_3.add(chkBacLuong);
		lblTenTaiKhoan.setPreferredSize(lblChonPB.getPreferredSize());
		lblMatKhau.setPreferredSize(lblChonPB.getPreferredSize());
		lblTenNV.setPreferredSize(lblChonPB.getPreferredSize());

		JLabel lblNewLabel = new JLabel("Chọn phòng ban:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panel_1.add(lblNewLabel);

		cmbChonPhongBan = new JComboBox();
		cmbChonPhongBan.setEnabled(false);
		cmbChonPhongBan.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panel_1.add(cmbChonPhongBan);

		chkChonPB = new JCheckBox("Chọn lại phòng ban");
		chkChonPB.setEnabled(false);
		chkChonPB.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panel_1.add(chkChonPB);
		lblQuyen.setPreferredSize(lblChonPB.getPreferredSize());

		modelPhongban = new DefaultComboBoxModel<PhongBan>();
		try {
			phongbanControl = (PhongBanControl) Naming.lookup("rmi://localhost:1099/phongban");
			bacLuongConTrol = (BacLuongConTrol) Naming.lookup("rmi://localhost:1099/bacluong");
			chiTietLuongControl = (NhanVien_BacLuongControl) Naming.lookup("rmi://localhost:1099/chitietluong");
			DefaultComboBoxModel<BacLuong> cmModel = (DefaultComboBoxModel<BacLuong>) cmbBacLuong.getModel();
			cmModel.removeAllElements();
			bacLuongConTrol.layDanhSachBacLuong().forEach(x -> {
				cmModel.addElement(x);
			});

			DefaultComboBoxModel<PhongBan> cmPBModel = (DefaultComboBoxModel<PhongBan>) cmbChonPhongBan.getModel();
			cmPBModel.removeAllElements();
			phongbanControl.laydsPhongBan().forEach(x -> {
				cmPBModel.addElement(x);
			});
			dspb = phongbanControl.laydsPhongBan();
		} catch (Exception e) {
			e.printStackTrace();
		}

		lblHeSo.setPreferredSize(lblChonPB.getPreferredSize());
		TienIch.chinhKichThuocTitleTrenBorder(new JPanel[] { pnlBangThongTinNV, pnlThongTinTaiKhoan }, "arial",
				Font.PLAIN, 20);

		/*
		 * Gắn sự kiện
		 */

		ganSuKien();
		hienThiCMBPhongBan(dspb);
		cbbChonPB.setSelectedIndex(0);
		cmbBacLuong.setPreferredSize(cmbChonPhongBan.getPreferredSize());

	}

	private void hienThiCMBPhongBan(List<PhongBan> dspb) {
		modelPhongban.removeAllElements();
		for (PhongBan phongBan : dspb) {
			modelPhongban.addElement(phongBan);
		}
		cbbChonPB.setModel(modelPhongban);
	}

	private void ganSuKien() {

		tblDSNhanVien.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent arg0) {
				int row = tblDSNhanVien.getSelectedRow();
				if (row == -1)
					return;
				try {
					txtMaNV.setText(tblDSNhanVien.getValueAt(row, 1).toString());
					txtTenNV.setText(tblDSNhanVien.getValueAt(row, 2).toString());

					NhanVien nvTim = nhanVienControl.layNhanVienTheoMa((String) tblDSNhanVien.getValueAt(row, 1));
					if (nvTim.getTaiKhoan().getQuyen() == 1) {
						txtChucVu.setText("Nhân viên");
						cbbQuyen.setSelectedIndex(0);

					} else if (nvTim.getTaiKhoan().getQuyen() == 2) {
						txtChucVu.setText("Trưởng phòng");
						cbbQuyen.setSelectedIndex(1);
					}
					txtTenTaiKhoan.setText(nvTim.getTaiKhoan().getTenDangNhap().trim());
					txtMatKhau.setText(nvTim.getTaiKhoan().getMatKhau().trim());
					cbbQuyen.setSelectedItem(nvTim.getTaiKhoan().getQuyen());

				} catch (Exception e) {
					// TODO: handle exception4
					e.printStackTrace();
				}
				TienIch.hienAnCacControl(false, btnLuu, btnHuy);
				TienIch.hienAnCacControl(true, btnSua, btnXoa);
			}

		});
		cbbChonPB.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				PhongBan pb = (PhongBan) cbbChonPB.getSelectedItem();
				try {
					dsNhanVien = nhanVienControl.layDanhSachNhanVienTheoPhongBan(pb.getMaPB());
					hienBangDanhSachNhanVien(dsNhanVien);
				} catch (Exception e2) {
					e2.printStackTrace();
				}
				TienIch.hienAnCacControl(false, btnHuy, btnLuu, btnSua, btnXoa, txtTenTaiKhoan, txtMatKhau);
			}

		});
		chkBacLuong.addActionListener(this);
		chkChonPB.addActionListener(this);
		btnSua.addActionListener(this);
		btnLuu.addActionListener(this);
		btnXoa.addActionListener(this);
		btnHuy.addActionListener(this);

	}

	private void hienBangDanhSachNhanVien(List<NhanVien> ds) throws RemoteException {
		int i = 0;
		String chucVu = "";
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		tblModel = (DefaultTableModel) tblDSNhanVien.getModel();
		tblModel.setRowCount(0);

		for (NhanVien x : ds) {
			NhanVien_BacLuong nvbl = chiTietLuongControl.layChiTietLuongTheoIdNV(x.getId());
			double heSo = 0.0;
			if (nvbl != null) {
				heSo = nvbl.getBacLuong().getHeSo();
			}
			i++;
			if (x.getTaiKhoan().getQuyen() != 3) {
				chucVu = x.getTaiKhoan().getQuyen() == 1 ? "Nhân viên" : "Trưởng phòng";
				tblModel.addRow(new Object[] { i, x.getMaNV(), x.getHoVaTen(), x.isGioiTinh() ? "Nam" : "Nữ",
						x.getNgaySinh().format(dtf), chucVu,
						x.getTaiKhoan().getTenDangNhap().isEmpty() ? "Chưa có" : x.getTaiKhoan().getTenDangNhap(),
						heSo });
			}

		}

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if (o.equals(btnSua)) {
			chkBacLuong.setEnabled(true);
			chkChonPB.setEnabled(true);
			txtTenTaiKhoan.requestFocus();

			TienIch.hienAnCacControl(false, btnXoa, btnSua);
			TienIch.hienAnCacControl(true, btnLuu, btnHuy, txtTenTaiKhoan, txtMatKhau, cbbQuyen);

		} else if (o.equals(btnLuu)) {
			try {
				int confirm = JOptionPane.showConfirmDialog(this,
						"Xác nhận cập nhật nhân viên " + txtTenNV.getText() + " ?", "Cập nhật nhân viên",
						JOptionPane.YES_NO_OPTION);
				if (confirm == JOptionPane.YES_OPTION) {
					if (kiemTraNhapLieu()) {
						TienIch.hienAnCacControl(true, btnSua);
						TienIch.hienAnCacControl(false, btnHuy, btnLuu, btnXoa, txtTenTaiKhoan, txtMatKhau, txtChucVu,
								cbbQuyen);
						tblDSNhanVien.setEnabled(true);
						dsNhanVien = nhanVienControl
								.layDanhSachNhanVienTheoPhongBan(((PhongBan) cbbChonPB.getSelectedItem()).getMaPB());
						int row = tblDSNhanVien.getSelectedRow();
						if (row == -1)
							return;
						NhanVien nv = nhanVienControl.layNhanVienTheoMa((String) tblDSNhanVien.getValueAt(row, 1));
						TaiKhoan tk = new TaiKhoan();
						tk.setTenDangNhap(txtTenTaiKhoan.getText());
						tk.setMatKhau(txtMatKhau.getText());
						tk.setQuyen((Integer) cbbQuyen.getSelectedIndex() + 1);
						nv.setTaiKhoan(tk);

						for (NhanVien nhanVienPB : dsNhanVien) {
							if (nv.getTaiKhoan().getQuyen() == 2) {
								nhanVienPB.getTaiKhoan().setQuyen(1);
								nhanVienControl.suaNhanVien(nhanVienPB);
							}
						}

						if (chkChonPB.isSelected()) {
							nv.setPhongBan((PhongBan) cmbChonPhongBan.getSelectedItem());
						}

						nv.setTaiKhoan(tk);
						NhanVien nvDaSua = nhanVienControl.suaNhanVien(nv);
						if (nvDaSua != null) {
							txtChucVu.setText((String) cbbQuyen.getSelectedItem());
							tblDSNhanVien.setValueAt((String) cbbQuyen.getSelectedItem(),
									tblDSNhanVien.getSelectedRow(), 5);
						}
						if (chkBacLuong.isSelected()) {

							NhanVien_BacLuong nvbl = chiTietLuongControl.layChiTietLuongTheoIdNV(nv.getId());
							NhanVien_BacLuong nvblCapNhat = null;

							if (nvbl != null) {
								nvblCapNhat = chiTietLuongControl.suaChiTietLuong(
										new NhanVien_BacLuong(nv, (BacLuong) cmbBacLuong.getSelectedItem()));
							} else {
								nvblCapNhat = chiTietLuongControl.themChiTietLuong(
										new NhanVien_BacLuong(nv, (BacLuong) cmbBacLuong.getSelectedItem()));
							}

						}
						chkChonPB.setSelected(false);
						chkBacLuong.setSelected(false);
						chkChonPB.setEnabled(false);
						chkBacLuong.setEnabled(false);
						cmbBacLuong.setSelectedIndex(0);
						cmbChonPhongBan.setEnabled(false);

						dsNhanVien = nhanVienControl
								.layDanhSachNhanVienTheoPhongBan(((PhongBan) cbbChonPB.getSelectedItem()).getMaPB());
						hienBangDanhSachNhanVien(dsNhanVien);
					}
				}

			} catch (Exception e2) {
				e2.printStackTrace();
			}
		} else if (o.equals(btnXoa)) {
			try {
				NhanVien nv = nhanVienControl
						.layNhanVienTheoMa((String) tblDSNhanVien.getValueAt(tblDSNhanVien.getSelectedRow(), 1));
				int confirm = JOptionPane.showConfirmDialog(this, "Có muốn xóa nhân viên này ?", "Xóa nhân viên",
						JOptionPane.YES_NO_OPTION);
				if (confirm == JOptionPane.YES_OPTION) {
					NhanVien nvXoa = nhanVienControl.xoaNhanVien(nv);
					if (nvXoa != null) {
						hienBangDanhSachNhanVien(nhanVienControl
								.layDanhSachNhanVienTheoPhongBan(((PhongBan) cbbChonPB.getSelectedItem()).getMaPB()));
						
						TienIch.hienAnCacControl(false, btnHuy, btnLuu, btnSua, btnXoa, txtTenTaiKhoan, txtMatKhau);
						TienIch.xoaTrangCacJTextField(txtMaNV, txtTenNV, txtTenTaiKhoan, txtMatKhau, txtChucVu);

					}

				}
			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}

		} else if (o.equals(btnHuy)) {
			TienIch.hienAnCacControl(false, btnHuy, btnLuu, btnSua, btnXoa, txtTenTaiKhoan, txtMatKhau);
			TienIch.xoaTrangCacJTextField(txtMaNV, txtTenNV, txtTenTaiKhoan, txtMatKhau, txtChucVu);
			cbbQuyen.setEnabled(false);
			tblDSNhanVien.setEnabled(true);

			chkChonPB.setSelected(false);
			chkBacLuong.setSelected(false);
			chkChonPB.setEnabled(false);
			chkBacLuong.setEnabled(false);
			cmbBacLuong.setSelectedIndex(0);
			cmbChonPhongBan.setEnabled(false);

		} else if (o.equals(chkBacLuong)) {
			if (chkBacLuong.isSelected()) {
				cmbBacLuong.setEnabled(true);
			} else {
				cmbBacLuong.setEnabled(false);
			}

		} else if (o.equals(chkChonPB)) {
			if (chkChonPB.isSelected()) {
				cmbChonPhongBan.setEnabled(true);
			} else {
				cmbChonPhongBan.setEnabled(false);
			}
		}

	}

	/**
	 * Hàm kiểm tra nhập liệu
	 * 
	 * @return
	 */
	public boolean kiemTraNhapLieu() {

		String taiKhoan = txtTenTaiKhoan.getText().trim();

		String matKhau = txtMatKhau.getText().trim();
		if (taiKhoan.length() == 0 || matKhau.length() == 0) {
			if (taiKhoan.length() == 0) {
				JOptionPane.showMessageDialog(null, "Tên tài khoản không được rỗng!");
				txtTenTaiKhoan.requestFocus();
				txtTenTaiKhoan.selectAll();
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
			JOptionPane.showMessageDialog(null, "Tên tài khoản không chứa ký tự đặt biệt!");
			txtTenTaiKhoan.requestFocus();
			txtTenTaiKhoan.selectAll();
			return false;
		} else if (!(matKhau.matches("[^:&\\.~ ]{6,}"))) {
			JOptionPane.showMessageDialog(null, "Mật khẩu không chứa ký tự đặt biệt và gồm 6 ký tự trở lên!");
			return false;
		}
		return true;
	}

}
