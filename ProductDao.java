import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
/*import java.sql.SQLDataException;
import java.util.ArrayList;
import java.util.List;
import java.sql.PreparedStatement;
*/


public class ProductDao {
    private final Connection CONEXAO_DB;

    //construtor que inicializa a conexao com o DB
    public ProductDao(Connection conexao){
        this.CONEXAO_DB = conexao; // <- Vai vir da classe criada para a conexão (connectionDB.java)
    }

    //Inserir item no db
    public void Inserir(Product product){
        String sql = "INSERT INTO produtos (nome_produto, quantidade, preco, status) VALUES (? , ? , ? , ?)";
        try (PreparedStatement stmt = CONEXAO_DB.prepareStatement(sql)) {
            stmt.setString(1, product.getName());
            stmt.setInt(2, product.getQuantidade());
            stmt.setDouble(3, product.getPreco());
            stmt.setString(4, product.getStatus());
            stmt.executeUpdate();
        } catch (SQLException e){
            e.getMessage();
        }
    }

    public void ExcluirTodos(){
        String sql = "DELETE FROM produtos";
        try (PreparedStatement stmt = CONEXAO_DB.prepareStatement(sql)){
                stmt.executeUpdate();
        } catch (SQLException e){
            e.getMessage();
        }
    
}

    public Product consultarPorId(int id){
        String sql = "SELECT * FROM produtos WHERE id_produto = ?";
           try (PreparedStatement stmt = CONEXAO_DB.prepareStatement(sql);
                ResultSet rs = stmt.executeQuery())
                { stmt.setInt(1, id);
                    if(rs.next()){
                        Product product = new Product();
                        product.setId(rs.getInt("id_produto"));
                        product.setName(rs.getString("nome_produto"));
                        product.setQuantidade(rs.getInt("quantidade_produto"));
                        product.setStatus(rs.getString("status_produto"));
                        product.setPreco(rs.getDouble("preco_produto"));
                        return product;
                    }
                } catch (SQLException e){
            e.getMessage();
        } return null;
    }
}