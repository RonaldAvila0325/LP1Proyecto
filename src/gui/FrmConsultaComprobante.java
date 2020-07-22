package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import componentes.JComboBoxBD;
import entidad.Comprobante;
import model.ComprobanteModel;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.awt.event.ActionEvent;

@SuppressWarnings({ "serial", "unused" })
public class FrmConsultaComprobante extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTable table;
	private JButton btnFiltrar;
	private JComboBoxBD cboCliente;

	private ResourceBundle rb=ResourceBundle.getBundle("combo");
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmConsultaComprobante frame = new FrmConsultaComprobante();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FrmConsultaComprobante() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 783, 412);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Cliente");
		lblNewLabel.setBounds(89, 97, 83, 14);
		contentPane.add(lblNewLabel);
		
		cboCliente = new JComboBoxBD(rb.getString("SQL_COMBO_CLIENTE"));
		cboCliente.setBounds(182, 94, 332, 20);
		contentPane.add(cboCliente);
		
		btnFiltrar = new JButton("Filtrar");
		btnFiltrar.addActionListener(this);
		btnFiltrar.setBounds(535, 93, 89, 23);
		contentPane.add(btnFiltrar);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 142, 747, 220);
		contentPane.add(scrollPane);
		
		JLabel lblNewLabel_1 = new JLabel("Consulta de Comprobante por Cliente");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1.setBounds(182, 40, 332, 20);
		contentPane.add(lblNewLabel_1);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"idComprobante", "FechaRegistro", "FechaPago", "Estado", "idPedido", "idCliente", "idUsuario"
			}
		));
		scrollPane.setViewportView(table);
		
		
	}
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnFiltrar) {
			actionPerformedBtnNewButtonJButton(arg0);
		}
	}
	
	
	protected void actionPerformedBtnNewButtonJButton(ActionEvent arg0) 
	{
		int pos=cboCliente.getSelectedIndex();
		
		ComprobanteModel m=new ComprobanteModel();
		ArrayList<Comprobante> lista=null;
		if(pos==0) 
		{
			lista=m.listaComprobante();
		}
		else 
		{
			String sel=cboCliente.getSelectedItem().toString();
			int idcliente=Integer.parseInt(sel.split(":")[0]);
			
			lista=m.listaComprobantePorCliente(idcliente);
		}
		
		DefaultTableModel dtm=(DefaultTableModel) table.getModel();
		dtm.setRowCount(0);
		
		for(Comprobante x : lista) 
		{
			Object[] fila= 
				{
						x.getIdcomprobante(),
						x.getFechaRegistro(),
						x.getFechaPago(),
						x.getEstado(),
						x.getPedido().getIdpedido(),
						//x.getCliente().getNombres(),
						x.getCliente().getIdcliente(),
						x.getUsuario().getIdusuario()
				};
			dtm.addRow(fila);
		}
	
	}
}
