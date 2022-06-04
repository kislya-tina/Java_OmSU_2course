package ProductsAll.Package;

import java.util.Objects;

public class Package {//упаковка товара
    protected String name;
    protected double weight;

    public Package(String name, double weight) {
        if (name == null || name.isEmpty()) throw new IllegalArgumentException("name is null");
        this.name = name;
        this.weight = weight;
    }
    public Package(Package pack){
        if (pack == null) throw new IllegalArgumentException("pack is null");
        this.name = pack.getName();
        this.weight = pack.getWeight();
    }

    public String getName() {
        return name;
    }

    public double getWeight() {
        return weight;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Package that = (Package) o;
        return Double.compare(that.weight, weight) == 0 && name.equals(that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, weight);
    }

    @Override
    public String toString() {
        return "ProductsAll.ProductsAll.Products.Products.Package: " +
                "name='" + name + '\'' +
                ", weight=" + weight;
    }
}
