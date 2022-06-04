package ProductsAll.Products;

import java.util.Objects;

public class Product {//товар
    protected String name;
    protected String description;

    public Product(String nam, String des){
        if(nam == null || nam.isEmpty() || des == null || des.isEmpty()){
            throw new NullPointerException("Name or description is null");
        }
        this.name = nam;
        this.description = des;
    }
    public Product(){
        this.name = "";
        this.description = "";
    }

    public Product(Product product){
        this.name = product.getName();
        this.description = product.getDescription();
    }

    public String getName(){
        return this.name;
    }

    public String getDescription(){
        return this.description;
    }

    @Override
    public String toString() {
        return "Product:" +
                "name='" + name + '\'' +
                ", description='" + description + "\n";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product;
        product = (Product) o;
        return name.equals(product.name) && description.equals(product.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, description);
    }
}
