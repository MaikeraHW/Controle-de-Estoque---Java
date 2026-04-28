import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;



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


    //excluir todos os itens
    public void ExcluirTodos(){
        String sql = "DELETE FROM produtos";
        try (PreparedStatement stmt = CONEXAO_DB.prepareStatement(sql)){
                stmt.executeUpdate();
        } catch (SQLException e){
            e.getMessage();
        }
    
}

    //consultar item pela ID
    public Product consultarPorId(int id){
        String sql = "SELECT * FROM produtos WHERE id_produto = ?";
           try (PreparedStatement stmt = CONEXAO_DB.prepareStatement(sql)){
                     stmt.setInt(1, id);
                    try (ResultSet rs = stmt.executeQuery()){
                    if(rs.next()){
                        Product product = new Product();
                        product.setId(rs.getInt("id_produto"));
                        product.setName(rs.getString("nome_produto"));
                        product.setQuantidade(rs.getInt("quantidade"));
                        product.setStatus(rs.getString("status"));
                        product.setPreco(rs.getDouble("preco"));
                        return product;
                    }
                } catch (SQLException e){
            e.getMessage();
        }
                } catch (SQLException e){
            e.getMessage();
        } return null;
    }

    //atualizar dados
    public void atualizar(Product product){
        String sql = "UPDATE produtos SET nome_produto = ?, quantidade = ?, preco = ?, status = ? WHERE id_produto = ?";
            try (PreparedStatement stmt = CONEXAO_DB.prepareStatement(sql)) {
                stmt.setString(1, product.getName());
                stmt.setInt(2, product.getQuantidade());
                stmt.setDouble(3, product.getPreco());
                stmt.setString(4, product.getStatus());
                stmt.setInt(5, product.getId());
                stmt.executeUpdate();
            } catch (SQLException Ex) {
                Ex.getMessage();
            }
    }

        //método excluir item
    public void excluir(int id){
        String sql = "DELETE FROM produtos WHERE id_produto = ?";
            try(PreparedStatement stmt = CONEXAO_DB.prepareStatement(sql)) {
                stmt.setInt(1, id);
                stmt.executeUpdate();
            } catch (SQLException Ex) {
                Ex.getMessage();
            }
    }

    //método listar todos os itens
    public List<Product> listarTodos() {
        List<Product> products = new ArrayList<>();
        String sql = "SELECT * FROM produtos";
        try (PreparedStatement stmt = CONEXAO_DB.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                Product produto = new Product();
                produto.setId(rs.getInt("id_produto"));
                produto.setName(rs.getString("nome_produto"));
                produto.setQuantidade(rs.getInt("quantidade"));
                produto.setPreco(rs.getDouble("preco"));  
                produto.setStatus(rs.getString("status"));
                products.add(produto);
                }
                
        } catch (Exception ex) {
            ex.getMessage();
        }
        return products;
    }

}