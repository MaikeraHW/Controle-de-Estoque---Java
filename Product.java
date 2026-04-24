public class Product {
    private int id;
    private String name;
    private int quantidade;
    private double preco;
    private String status;


        public Product(String name, int quantidade, double preco, String status){
            this.name = name;
            this.quantidade = quantidade;
            this.preco = preco;
            this.status = status;
        }

        public Product(){};

        //setter methods
        
        public void setId(int id){
            this.id = id;
        }
        public void setName(String name){
            this.name = name;
        }
        public void setQuantidade(int quantidade){
            this.quantidade = quantidade;
        }
        public void setPreco(double preco){
            this.preco = preco;
        }
        public void setStatus(String status){
            this.status = status;
        }
        
        //getter methods

        public int getId(){
            return id;
        }
        public String getName(){
            return name;
        }
        public int getQuantidade(){
            return quantidade;
        }
        public double getPreco(){
            return preco;
        }
        public String getStatus(){
            return status;
        }

}