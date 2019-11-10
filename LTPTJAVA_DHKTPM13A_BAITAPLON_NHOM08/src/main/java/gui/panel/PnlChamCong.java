package gui.panel;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import org.hibernate.hql.ast.origin.hql.parse.HQLParser.elements_key_return;

import com.sun.javafx.webkit.ThemeClientImpl;

import control.ChiTietChamCongControl;
import entities.ChiTietChamCong;
import entities.NgayChamCong;
import entities.NhanVien;

public class PnlChamCong extends JPanel implements ActionListener {

	private static final long serialVersionUID = 1L;
	private ChiTietChamCongControl chamCongControl;
	private JTextField txtMaNV;
	private JTextField txtHoTenNV;
	private JTextField txtPhongBan;
	private JTextField txtNgayChamCong;
	private JButton btnXacNhan;

	private NhanVien nhanVien;
	private JTextField txtSoNgay;
	private static int tongSoNgayCham = 0;
	private static ChiTietChamCong chiTietChamCong;

	public PnlChamCong(NhanVien nv) {
		this.nhanVien = nv;
		setBorder(new EmptyBorder(5, 5, 5, 5));
		setLayout(new BorderLayout(0, 0));

		JPanel pnlTieuDe = new JPanel();
		pnlTieuDe.setBorder(new EmptyBorder(5, 0, 5, 0));
		add(pnlTieuDe, BorderLayout.NORTH);

		JLabel lblTieuDe = new JLabel("CHẤM CÔNG NHÂN VIÊN");
		lblTieuDe.setBorder(null);
		lblTieuDe.setFont(new Font("Arial", Font.BOLD, 30));
		pnlTieuDe.add(lblTieuDe);

		JPanel pnChamCong = new JPanel();
		add(pnChamCong, BorderLayout.CENTER);

		JPanel pnChiTiet = new JPanel();
		GroupLayout gl_pnChamCong = new GroupLayout(pnChamCong);
		gl_pnChamCong.setHorizontalGroup(gl_pnChamCong.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnChamCong.createSequentialGroup().addGap(312)
						.addComponent(pnChiTiet, GroupLayout.PREFERRED_SIZE, 619, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(312, Short.MAX_VALUE)));
		gl_pnChamCong.setVerticalGroup(gl_pnChamCong.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnChamCong.createSequentialGroup().addGap(50)
						.addComponent(pnChiTiet, GroupLayout.PREFERRED_SIZE, 308, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(293, Short.MAX_VALUE)));
		pnChiTiet.setLayout(new GridLayout(6, 0, 0, 0));

		JPanel pnMaNV = new JPanel();
		pnChiTiet.add(pnMaNV);

		JLabel lblMaNV = new JLabel("Mã nhân viên:");
		lblMaNV.setFont(new Font("Tahoma", Font.PLAIN, 20));

		txtMaNV = new JTextField();
		txtMaNV.setEditable(false);
		txtMaNV.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtMaNV.setColumns(10);
		GroupLayout gl_pnMaNV = new GroupLayout(pnMaNV);
		gl_pnMaNV.setHorizontalGroup(gl_pnMaNV.createParallelGroup(Alignment.LEADING).addGroup(gl_pnMaNV
				.createSequentialGroup().addGap(121)
				.addComponent(lblMaNV, GroupLayout.PREFERRED_SIZE, 154, GroupLayout.PREFERRED_SIZE).addGap(18)
				.addComponent(txtMaNV, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
				.addContainerGap(154, Short.MAX_VALUE)));
		gl_pnMaNV.setVerticalGroup(gl_pnMaNV.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnMaNV.createSequentialGroup().addGap(12)
						.addGroup(gl_pnMaNV.createParallelGroup(Alignment.BASELINE)
								.addComponent(txtMaNV, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblMaNV, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE))
						.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
		pnMaNV.setLayout(gl_pnMaNV);

		JPanel pnTenNV = new JPanel();
		pnChiTiet.add(pnTenNV);

		JLabel lblHoTenNV = new JLabel("Họ và tên:");
		lblHoTenNV.setFont(new Font("Tahoma", Font.PLAIN, 20));

		txtHoTenNV = new JTextField();
		txtHoTenNV.setEditable(false);
		txtHoTenNV.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtHoTenNV.setColumns(10);
		GroupLayout gl_pnTenNV = new GroupLayout(pnTenNV);
		gl_pnTenNV.setHorizontalGroup(gl_pnTenNV.createParallelGroup(Alignment.LEADING).addGroup(Alignment.TRAILING,
				gl_pnTenNV.createSequentialGroup().addContainerGap(121, Short.MAX_VALUE)
						.addComponent(lblHoTenNV, GroupLayout.PREFERRED_SIZE, 154, GroupLayout.PREFERRED_SIZE)
						.addGap(18)
						.addComponent(txtHoTenNV, GroupLayout.PREFERRED_SIZE, 255, GroupLayout.PREFERRED_SIZE)
						.addGap(71)));
		gl_pnTenNV.setVerticalGroup(gl_pnTenNV.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnTenNV.createSequentialGroup().addGap(12)
						.addGroup(gl_pnTenNV.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblHoTenNV, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtHoTenNV, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE))
						.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
		pnTenNV.setLayout(gl_pnTenNV);

		JPanel pnPhongBan = new JPanel();
		pnChiTiet.add(pnPhongBan);

		JLabel lblPhongBan = new JLabel("Phòng ban:");
		lblPhongBan.setFont(new Font("Tahoma", Font.PLAIN, 20));

		txtPhongBan = new JTextField();
		txtPhongBan.setEditable(false);
		txtPhongBan.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtPhongBan.setColumns(10);
		GroupLayout gl_pnPhongBan = new GroupLayout(pnPhongBan);
		gl_pnPhongBan
				.setHorizontalGroup(gl_pnPhongBan.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_pnPhongBan.createSequentialGroup().addGap(121)
								.addComponent(lblPhongBan, GroupLayout.PREFERRED_SIZE, 154, GroupLayout.PREFERRED_SIZE)
								.addGap(18).addComponent(txtPhongBan, GroupLayout.PREFERRED_SIZE,
										GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addContainerGap(150, Short.MAX_VALUE)));
		gl_pnPhongBan.setVerticalGroup(gl_pnPhongBan.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnPhongBan.createSequentialGroup().addGap(12)
						.addGroup(gl_pnPhongBan.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblPhongBan, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtPhongBan, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE))
						.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
		pnPhongBan.setLayout(gl_pnPhongBan);

		JPanel pnNgayCC = new JPanel();
		pnChiTiet.add(pnNgayCC);

		JLabel lblNgayChamCong = new JLabel("Ngày chấm công:");
		lblNgayChamCong.setFont(new Font("Tahoma", Font.PLAIN, 20));

		txtNgayChamCong = new JTextField();
		txtNgayChamCong.setEditable(false);
		txtNgayChamCong.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtNgayChamCong.setColumns(10);
		GroupLayout gl_pnNgayCC = new GroupLayout(pnNgayCC);
		gl_pnNgayCC
				.setHorizontalGroup(gl_pnNgayCC.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_pnNgayCC.createSequentialGroup().addGap(121).addComponent(lblNgayChamCong)
								.addGap(18).addComponent(txtNgayChamCong, GroupLayout.PREFERRED_SIZE,
										GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addContainerGap(150, Short.MAX_VALUE)));
		gl_pnNgayCC.setVerticalGroup(gl_pnNgayCC.createParallelGroup(Alignment.LEADING).addGroup(gl_pnNgayCC
				.createSequentialGroup().addGap(10)
				.addGroup(gl_pnNgayCC.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_pnNgayCC.createSequentialGroup().addGap(4).addComponent(lblNgayChamCong,
								GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE))
						.addComponent(txtNgayChamCong, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE))
				.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
		pnNgayCC.setLayout(gl_pnNgayCC);

		JPanel pnlXacNhan = new JPanel();
		pnChiTiet.add(pnlXacNhan);

		btnXacNhan = new JButton("Xác nhận chấm công");
		btnXacNhan.setFont(new Font("Tahoma", Font.PLAIN, 20));
		GroupLayout gl_pnlXacNhan = new GroupLayout(pnlXacNhan);
		gl_pnlXacNhan.setHorizontalGroup(gl_pnlXacNhan.createParallelGroup(Alignment.LEADING).addGroup(gl_pnlXacNhan
				.createSequentialGroup().addGap(201).addComponent(btnXacNhan).addContainerGap(201, Short.MAX_VALUE)));
		gl_pnlXacNhan.setVerticalGroup(gl_pnlXacNhan.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlXacNhan.createSequentialGroup().addGap(8)
						.addComponent(btnXacNhan, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
		pnlXacNhan.setLayout(gl_pnlXacNhan);

		btnXacNhan.addActionListener(this);

		JPanel pnSoNgCC = new JPanel();
		pnChiTiet.add(pnSoNgCC);

		JLabel lblSoNgCham = new JLabel("Số ngày chấm công:");
		lblSoNgCham.setFont(new Font("Tahoma", Font.PLAIN, 20));

		txtSoNgay = new JTextField();
		txtSoNgay.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtSoNgay.setEditable(false);
		txtSoNgay.setColumns(10);
		GroupLayout gl_pnSoNgCC = new GroupLayout(pnSoNgCC);
		gl_pnSoNgCC
				.setHorizontalGroup(
						gl_pnSoNgCC.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_pnSoNgCC.createSequentialGroup().addGap(121).addComponent(lblSoNgCham)
										.addPreferredGap(ComponentPlacement.RELATED).addComponent(txtSoNgay,
												GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
										.addContainerGap(213, Short.MAX_VALUE)));
		gl_pnSoNgCC.setVerticalGroup(gl_pnSoNgCC.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnSoNgCC.createSequentialGroup().addGap(8)
						.addGroup(gl_pnSoNgCC.createParallelGroup(Alignment.LEADING)
								.addComponent(txtSoNgay, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 35,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(lblSoNgCham, Alignment.TRAILING))
						.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
		gl_pnSoNgCC.linkSize(SwingConstants.VERTICAL, new Component[] { lblSoNgCham, txtSoNgay });
		pnSoNgCC.setLayout(gl_pnSoNgCC);
		pnChamCong.setLayout(gl_pnChamCong);
		hienThongTinNV(nv);

	}

	/**
	 * Hiên thông tin chấm công nhân viên
	 * 
	 * @param nv
	 */
	private void hienThongTinhChamCong(NhanVien nvs) {
		/*
		 * Kiểm tra nhân viên đã chấm công
		 */
		try {
			chamCongControl = (ChiTietChamCongControl) Naming.lookup("rmi://localhost:1099/chitietchamcong");
			List<ChiTietChamCong> chamCongs = chamCongControl.layDSCTNhanVienChamTheoThang(nvs.getId(),
					LocalDate.now().getMonthValue());
			if (chamCongs.size() != 0) {
				tongSoNgayCham = chamCongControl.tinhNgayDaChamCongTheoThang(nvs, LocalDate.now().getMonthValue());
				boolean kiemTra = kiemTraChamCong(chamCongs);
				if (kiemTra) {
					btnXacNhan.setEnabled(false);
				} else {
					chamCongControl.suaChiTietChamCong(chiTietChamCong);
				}
			} else {
				chiTietChamCong = chamCongControl
						.themChiTietChamCong(new ChiTietChamCong(new NgayChamCong(LocalDate.now()), nvs, false));
			}

			txtSoNgay.setText(tongSoNgayCham + " /26");

		} catch (RemoteException | MalformedURLException | NotBoundException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(this, "Lỗi phía máy chủ: " + e.getMessage(), "Lỗi",
					JOptionPane.WARNING_MESSAGE);
		}

	}

	/**
	 * Hiện thông tin nhân viên
	 * 
	 * @param nv
	 */
	private void hienThongTinNV(NhanVien nvs) {
		txtMaNV.setText(nvs.getMaNV());
		txtHoTenNV.setText(nvs.getHoVaTen());
		txtPhongBan.setText(nvs.getPhongBan().getTenPB());
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		txtNgayChamCong.setText(LocalDate.now().format(dtf));
		txtSoNgay.setText(0 + " /26");
		hienThongTinhChamCong(nvs);
	}

	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if (o.equals(btnXacNhan)) {
			try {

				int confirm = JOptionPane.showConfirmDialog(this,
						"Xác nhận chấm công ngày " + txtNgayChamCong.getText() + " ?", "Thông báo chấm công",
						JOptionPane.YES_NO_OPTION);
				if (confirm == JOptionPane.YES_OPTION) {
					ChiTietChamCong ct;
					if (chiTietChamCong == null) {
						ChiTietChamCong ctccMoi = new ChiTietChamCong(new NgayChamCong(LocalDate.now()), nhanVien,
								true);
						ct = chamCongControl.themChiTietChamCong(ctccMoi);
					} else {
						chiTietChamCong.setDaChamCong(true);
						ct = chamCongControl.suaChiTietChamCong(chiTietChamCong);
					}
					if (ct != null) {
						tongSoNgayCham++;
						txtSoNgay.setText(tongSoNgayCham + " /26");
						btnXacNhan.setEnabled(false);
					}
				}

			} catch (RemoteException e1) {
				JOptionPane.showMessageDialog(this, e1.getMessage());
			}

		}
	}

	private boolean kiemTraChamCong(List<ChiTietChamCong> lst) throws RemoteException {
		boolean daChamCong = false;
		for (ChiTietChamCong ct : lst) {
			LocalDate date = ct.getNcc().getNgayCham();
			if (date.isEqual(LocalDate.now()) && ct.isDaChamCong()) {
				daChamCong = true;

			} else {
				chiTietChamCong = ct;
			}
		}
		return daChamCong;
	}
}
