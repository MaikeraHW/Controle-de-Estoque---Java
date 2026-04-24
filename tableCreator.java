import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;



public class tableCreator {
    public static void main(String[] args) {

        try (Connection conexao = connectionDB.connectTo();
                Statement stmt = conexao.createStatement()){

                //creating the table
                String comandoSQL = "CREATE TABLE produtos (id_produto INTEGER PRIMARY KEY, nome_produto TEXT NOT NULL, quantidade INTEGER, preco REAK, status TEXT);";
                System.out.println(comandoSQL);

                stmt.execute(comandoSQL);
                System.out.println("Tabela criada com sucesso!");
                } catch (SQLException e){
                    e.getMessage();
                }
        
    }
    
}
