package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Locale;
import java.util.ResourceBundle;
import java.awt.event.ActionEvent;
import componentes.JComboBoxBD;
import entidad.Marca;
import entidad.Pais;
import entidad.Producto;
import entidad.Proveedor;
import model.ProductoModel;
import util.Validaciones;

@SuppressWarnings({ "serial", "unused" })
public class FrmRegistraProducto extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTextField txtNombre;
	private JTextField txtSerie;
	private JTextField txtPrecio;
	private JTextField txtStock;
	private JButton btnRegistrar;
	private JComboBoxBD cboMarca;
	private JComboBoxBD cboPais;
	private JComboBoxBD cboProveedor;
	
///////////////////////////////////////////////////////////////////
	private ResourceBundle rb=ResourceBundle.getBundle("combo");
//////////////////////////////////////////////////////////////////////	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmRegistraProducto frame = new FrmRegistraProducto();
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
	public FrmRegistraProducto() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 560, 322);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Registra Producto");
		lblNewLabel.setBounds(147, 11, 128, 25);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Nombre");
		lblNewLabel_1.setBounds(10, 61, 74, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Serie");
		lblNewLabel_2.setBounds(10, 101, 74, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Precio");
		lblNewLabel_3.setBounds(10, 146, 74, 14);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Stock");
		lblNewLabel_4.setBounds(10, 192, 74, 14);
		contentPane.add(lblNewLabel_4);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(94, 58, 86, 20);
		contentPane.add(txtNombre);
		txtNombre.setColumns(10);
		
		txtSerie = new JTextField();
		txtSerie.setColumns(10);
		txtSerie.setBounds(94, 98, 86, 20);
		contentPane.add(txtSerie);
		
		txtPrecio = new JTextField();
		txtPrecio.setColumns(10);
		txtPrecio.setBounds(94, 143, 86, 20);
		contentPane.add(txtPrecio);
		
		txtStock = new JTextField();
		txtStock.setColumns(10);
		txtStock.setBounds(94, 189, 86, 20);
		contentPane.add(txtStock);
		
		JLabel lblNewLabel_5 = new JLabel("Marca");
		lblNewLabel_5.setBounds(229, 61, 46, 14);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblPais = new JLabel("Pais");
		lblPais.setBounds(229, 101, 46, 14);
		contentPane.add(lblPais);
		
		JLabel lblProveedor = new JLabel("Proveedor");
		lblProveedor.setBounds(229, 146, 74, 14);
		contentPane.add(lblProveedor);
		
		cboMarca = new JComboBoxBD(rb.getString("SQL_COMBO_MARCA"));
		cboMarca.setBounds(313, 58, 198, 20);
		contentPane.add(cboMarca);
		
		cboPais = new JComboBoxBD(rb.getString("SQL_COMBO_PAIS"));
		cboPais.setBounds(313, 98, 198, 20);
		contentPane.add(cboPais);
		
		cboProveedor = new JComboBoxBD(rb.getString("SQL_COMBO_PROVEEDOR"));
		cboProveedor.setBounds(313, 143, 198, 20);
		contentPane.add(cboProveedor);
		
		btnRegistrar = new JButton("REGISTRAR");
		btnRegistrar.addActionListener(this);
		btnRegistrar.setBounds(218, 235, 108, 23);
		contentPane.add(btnRegistrar);
	}
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnRegistrar) {
			actionPerformedBtnRegistrarJButton(arg0);
		}
	}
	protected void actionPerformedBtnRegistrarJButton(ActionEvent arg0)
	{
		if (txtNombre.getText().isEmpty() && txtSerie.getText().isEmpty() && cboMarca.getSelectedIndex()==0 && cboPais.getSelectedIndex()==0 && cboProveedor.getSelectedIndex()==0 ) {
			mensaje("NO HA COMPLETADO NINGUN CAMPO ");
			
		}
		

		String nom=txtNombre.getText().trim();
		String ser=txtSerie.getText().trim();
		Double pre=Double.parseDouble(txtPrecio.getText().trim());
		int stock=Integer.parseInt(txtPrecio.getText().trim());
		String marca=cboMarca.getSelectedItem().toString();
		String idMarca=marca.split(":")[0];
		String pais=cboPais.getSelectedItem().toString();
		String idPais=pais.split(":")[0];
		String proveedor=cboProveedor.getSelectedItem().toString();
		String idProveedor=proveedor.split(":")[0];
		
		
		if(nom.matches(Validaciones.TEXTO)==false) 
		{
			mensaje("El nombre debe ser entre 2 a 50 carateres");
			
		}
		else if(ser.matches(Validaciones.TEXTO)==false)
		{
			mensaje("La serie es incorrecta");
		} 
		else if(pre<=0) 
		{
			mensaje("El precio debe ser mayor a 0");
		}
		else if(stock<=0) 
		{
			mensaje("Se requiere stockeo");
		}
		else if(cboMarca.getSelectedIndex()== 0)
		{
			mensaje("Seleccione una marca");
		} 
		else if(cboPais.getSelectedIndex()== 0)
		{
			mensaje("Seleccione un pais");
		} 
		else if(cboProveedor.getSelectedIndex()== 0)
		{
			mensaje("Seleccione un proveedor");
		} 
		else 
		{
			Marca objMar=new Marca();
			objMar.setIdmarca(Integer.parseInt(idMarca));
			Pais objPai=new Pais();
			objPai.setIdpais(Integer.parseInt(idPais));
			Proveedor objPro= new Proveedor();
			objPro.setIdproveedor(Integer.parseInt(idProveedor));

			
			Producto objProd= new Producto();
			objProd.setNombre(nom);
			objProd.setSerie(ser);
			objProd.setPrecio(pre);
			objProd.setStock(stock);
			objProd.setMarca(objMar);
			objProd.setPais(objPai);
			objProd.setProveedor(objPro);
			
			ProductoModel model=new ProductoModel();
			int salida=model.insertaProducto(objProd);
			
			if(salida>0) 
			{
				mensaje("Se registro correctamente");
				txtNombre.setText("");
				txtSerie.setText("");
				txtPrecio.setText("");
				txtPrecio.setText("");
				txtStock.setText("");
				cboMarca.setSelectedIndex(0);
				cboPais.setSelectedIndex(0);
				cboProveedor.setSelectedIndex(0);
				
			}
			else 
			{
				mensaje("Error en el registro");
			}
		}
	}	
	
	void mensaje(String msg) 
	{
		JOptionPane.showMessageDialog(this, msg);
	}
}
