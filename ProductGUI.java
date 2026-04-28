import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.cell.PropertyValueFactory;
import java.sql.Connection;
import java.util.List;

public class ProductGUI extends Application {
    private ProductDao productDao;
    private ObservableList<Product> products;
    private TableView<Product> tableView;
    private TextField nomeInput, quantidadeInput, precoInput;
    private ComboBox<String> statusComboBox;
    private Connection conexaoDB;

    
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage palco){
        conexaoDB = connectionDB.connectTo();
        productDao = new ProductDao(conexaoDB);
        products = FXCollections.observableArrayList(productDao.listarTodos());

        palco.setTitle("Gerenciamento de estoque de produtos");

        VBox vbox = new VBox();
        vbox.setPadding(new Insets(10,10,10,10));
        vbox.setSpacing(10);

        HBox nomeProdutoBox = new HBox();
        nomeProdutoBox.setSpacing(10);
        Label nomeLabel = new Label("Produto:");
        nomeInput = new TextField();
        nomeProdutoBox.getChildren().addAll(nomeLabel, nomeInput);

        HBox quantidadeBox = new HBox();
        quantidadeBox.setSpacing(10);
        Label quantidadeLabel = new Label("Quantidade:");
        quantidadeInput = new TextField();
        quantidadeBox.getChildren().addAll(quantidadeLabel, quantidadeInput);

        HBox precoBox = new HBox();
        precoBox.setSpacing(10);
        Label precoLabel = new Label("Preço:");
        precoInput = new TextField();
        precoBox.getChildren().addAll(precoLabel, precoInput);

        HBox statusBox = new HBox();
        statusBox.setSpacing(10);
        Label statusLabel = new Label("Status:");
        statusComboBox = new ComboBox<>();
        statusComboBox.getItems().addAll("Estoque Baixo", "Estoque Normal", "Estoque Alto");
        statusBox.getChildren().addAll(statusLabel, statusComboBox);

        vbox.getChildren().addAll(nomeProdutoBox, quantidadeBox, precoBox, statusBox);

        Scene scene = new Scene(vbox, 600, 600);
        palco.setScene(scene);
        palco.show();

    }
}

