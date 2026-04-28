import java.sql.Connection;
import java.sql.SQLException;


public class Main {
    public static void main(String[] args) {
        try (Connection conexao = connectionDB.connectTo()){
            ProductDao productDao = new ProductDao(conexao);


        //mostrarProdutos(ProductDao);

        Product product1 = new Product("Notebook", 10, 2000, "Em estoque");
        Product product2 = new Product("Tablet", 15, 1000, "Fora de estoque");
        Product product3 = new Product("Microondas", 4, 599, "Em estoque");

        productDao.Inserir(product1);
        productDao.Inserir(product2);
        productDao.Inserir(product3);


        //mostrarProdutos(ProductDao);

        } catch (SQLException e) {
            e.getMessage();
        }
    
}
}