
package br.com.projeto.jdbc;

import java.sql.DriverManager;
import java.sql.Connection;

/**
 *
 * @author adria
 */
public class ConnectionFactory {
    
    public Connection getConnection() {
        
        try{  
            return DriverManager.getConnection("jdbc:mysql://127.0.0.1/bdvendas?useTimezone=true&serverTimezone=UTC&useSSL=false","root","alp1206pla");
            
        } catch(Exception erro) {
            throw new RuntimeException(erro);
            
        }
        
    }
    
}
