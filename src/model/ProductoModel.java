package model;

import java.sql.Connection;
import java.sql.PreparedStatement;

import entidad.Producto;
import util.MySqlDBConexion;

public class ProductoModel 
{
	public int insertaProducto(Producto p) 
	{
		int salida=-1;
		Connection con=null;
		PreparedStatement pstm=null;
		
		try 
		{
			con=MySqlDBConexion.getConexion();
			String sql="insert into producto values(null,?,?,?,?,?,?,?)";
			pstm=con.prepareStatement(sql);
			pstm.setString(1, p.getNombre());
			pstm.setString(2, p.getSerie());
			pstm.setDouble(3, p.getPrecio());
			pstm.setInt(4, p.getStock());
			pstm.setInt(5, p.getMarca().getIdmarca());
			pstm.setInt(6, p.getPais().getIdpais());
			pstm.setInt(7, p.getProveedor().getIdproveedor());
			salida=pstm.executeUpdate();			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally 
		{
			try 
			{
				if(pstm!=null)pstm.close();
				if(con!=null)con.close();
			}
			catch(Exception e2)
			{
				
			}
		}
		return salida;
	}
}
