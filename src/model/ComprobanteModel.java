package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import entidad.Cliente;
import entidad.Comprobante;
import entidad.Pedido;
import entidad.Usuario;
import util.MySqlDBConexion;

public class ComprobanteModel 
{
	public ArrayList<Comprobante> listaComprobante()
	{
		ArrayList<Comprobante> lista=new ArrayList<Comprobante>();
		
		Connection conn=null;
		PreparedStatement pstm=null;
		ResultSet rs=null;
		
		try 
		{
			conn=MySqlDBConexion.getConexion();
			String sql="SELECT * from comprobante";
			pstm=conn.prepareStatement(sql);
			
			System.out.println(pstm);
			rs=pstm.executeQuery();
			
			Comprobante objComprobante=null;
			Cliente objCliente=null;
			Pedido objPedido=null;
			Usuario objUsuario=null;
			
			while(rs.next()) 
			{
				objCliente=new Cliente();
				objCliente.setIdcliente(rs.getInt(6));
				//objCliente.setNombres(rs.getString(6));
				
				objUsuario=new Usuario();
				objUsuario.setIdusuario(rs.getInt(7));
				//objUsuario.setNombre(rs.getString(7));
				
								
				objPedido=new Pedido();
				objPedido.setIdpedido(rs.getInt(5));
				
				
				
				objComprobante=new Comprobante();
				objComprobante.setIdcomprobante(rs.getInt(1));
				objComprobante.setFechaRegistro(rs.getDate(2));
				objComprobante.setFechaPago(rs.getDate(3));
				objComprobante.setEstado(rs.getString(4));
				objComprobante.setPedido(objPedido);
				objComprobante.setCliente(objCliente);
				objComprobante.setUsuario(objUsuario);
				
				
				lista.add(objComprobante);				
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally 
		{
			try 
			{
				if(rs!=null)rs.close();
				if(pstm!=null)pstm.close();
				if(conn!=null)conn.close();
			}
			catch(Exception e2) 
			{
				
			}
		}
		return lista;
	}
	
	public ArrayList<Comprobante> listaComprobantePorCliente (int idcliente)
	{
		ArrayList<Comprobante> lista=new ArrayList<Comprobante>();
		
		Connection conn=null;
		PreparedStatement pstm=null;
		ResultSet rs=null;
		
		try 
		{
			conn=MySqlDBConexion.getConexion();
			
			String sql="SELECT co.*,c.nombres from comprobante co inner join cliente c on co.idcliente=c.idcliente " + 
					 "inner join usuario u on co.idusuario=u.idusuario inner join pedido p on co.idpedido=p.idpedido " + 
					 "where c.idcliente=?";
			pstm=conn.prepareStatement(sql);
			pstm.setInt(1, idcliente);
			
			System.out.println(pstm);
			
			rs=pstm.executeQuery();
			
			Comprobante objComprobante=null;
			Cliente objCliente=null;
			Pedido objPedido=null;
			Usuario objUsuario=null;
			
			while(rs.next()) 
			{
				objCliente=new Cliente();
				objCliente.setIdcliente(rs.getInt(6));
				objCliente.setNombres(rs.getString(6));
				
				objUsuario=new Usuario();
				objUsuario.setIdusuario(rs.getInt(7));
				//objUsuario.setNombre(rs.getString(7));
				
								
				objPedido=new Pedido();
				objPedido.setIdpedido(rs.getInt(5));
				//objPedido.setEstado(rs.getString(5));
				
				
				
				objComprobante=new Comprobante();
				objComprobante.setIdcomprobante(rs.getInt(1));
				objComprobante.setFechaRegistro(rs.getDate(2));
				objComprobante.setFechaPago(rs.getDate(3));
				objComprobante.setEstado(rs.getString(4));
				objComprobante.setPedido(objPedido);
				objComprobante.setCliente(objCliente);
				objComprobante.setUsuario(objUsuario);
				
				
				lista.add(objComprobante);				
			}
		}
		catch(Exception e) 
		{
			e.printStackTrace();
		}
		finally 
		{
			try 
			{
				if (rs != null) rs.close();
				if (pstm != null) pstm.close();
				if (conn != null) conn.close(); 
			}
			catch(Exception e2) 
			{
				
			}
		}
		return lista;
	}
}
