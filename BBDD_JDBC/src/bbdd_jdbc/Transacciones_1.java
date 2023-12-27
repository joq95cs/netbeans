package bbdd_jdbc;

import java.sql.*;

public class Transacciones_1 {

    public static void main(String[] args) {
        
        Connection miConexion = null;	
        
        try {	
            
            miConexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/prueba", "root", "");	

            miConexion.setAutoCommit(false);
            
            Statement miStatement = miConexion.createStatement();

            String instruccionSql_1 = "INSERT INTO CLIENTES (CÓDIGOCLIENTE, EMPRESA, DIRECCIÓN) VALUES ('CT86', 'EJEMPLO', 'P BOTANICO')";

            miStatement.executeUpdate(instruccionSql_1);

            String instruccionSql_2 = "INSERT INTO PEDIDOS (NÚMERODEPEDIDOs, CÓDIGOCLIENTE, FECHADEPEDIDO) VALUES('82', 'CT84', '11/03/2000')";

            miStatement.executeUpdate(instruccionSql_2);
            
            miConexion.commit();

            System.out.println("Datos insertados correctamente");

        } catch(Exception e){

            System.err.println("ERROR EN LA INSERCIÓN DE DATOS");

            e.printStackTrace();	
            
            try {
                
                miConexion.rollback();
                
            } catch(SQLException ex) {
                
            }
            
        }

    }

}