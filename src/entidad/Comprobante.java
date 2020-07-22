package entidad;

import java.sql.Date;

public class Comprobante
{
	private int idcomprobante;
	private Date fechaRegistro;
	private Date fechaPago;
	private String estado;
	private Pedido pedido;
	private Cliente cliente;
	private Usuario usuario;
	
	public int getIdcomprobante() {
		return idcomprobante;
	}
	public void setIdcomprobante(int idcomprobante) {
		this.idcomprobante = idcomprobante;
	}
	public Date getFechaRegistro() {
		return fechaRegistro;
	}
	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}
	public Date getFechaPago() {
		return fechaPago;
	}
	public void setFechaPago(Date fechaPago) {
		this.fechaPago = fechaPago;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public Pedido getPedido() {
		return pedido;
	}
	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	

	
}
