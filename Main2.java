import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;


public class Main2 {
    public static void main(String[] args) {
        try (Connection conexao = connectionDB.connectTo()){
            ProductDao productDao = new ProductDao(conexao);


        mostrarProdutos(productDao);

        Product product1 = new Product("Notebook", 10, 2000, "Em estoque");
        Product product2 = new Product("Tablet", 15, 1000, "Fora de estoque");
        Product product3 = new Product("Microondas", 4, 599, "Em estoque");

        productDao.Inserir(product1);
        productDao.Inserir(product2);
        productDao.Inserir(product3);


        mostrarProdutos(productDao);

        //consulta por ID
        Product produtoConsultado = productDao.consultarPorId(1);
            if (produtoConsultado != null) {
                System.out.println(produtoConsultado.getName());
            } else {
                System.out.println("Item não encontrado");
            }



        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }

        
}

        //método para listar os produtos
        private static void mostrarProdutos(ProductDao productDao) {
            List<Product> todosProducts = productDao.listarTodos();
                if (todosProducts.isEmpty()) {
                    System.out.println("Nenhum produto encontrado");
                } else {
                    System.out.println("Lista de Produtos:");
                    for (Product p : todosProducts){
                        System.out.println(p.getId() + p.getName() + p.getQuantidade() + p.getPreco());
                    }
                }
        }
        
}