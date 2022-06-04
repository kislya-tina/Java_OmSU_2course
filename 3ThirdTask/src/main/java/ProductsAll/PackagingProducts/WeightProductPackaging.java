package ProductsAll.PackagingProducts;

import ProductsAll.Package.Package;
import ProductsAll.Products.WeightProduct;

public class WeightProductPackaging extends WeightProduct implements IProductPackaging {//Упакованый весовой товар
    protected Package pack;
    protected double weight;


    public WeightProductPackaging(Package pack, String name, String description, double weight) {
        super(name, description);
        this.pack = new Package(pack);
        this.weight = weight;
    }
    public WeightProductPackaging(Package pack, WeightProduct weightProduct, double weight){
        super(weightProduct.getName(), weightProduct.getDescription());
        this.pack = new Package(pack);
        this.weight = weight;
    }

    public double getNetto(){
        return weight;
    }

    public double getBrutto(){
        return weight + pack.getWeight();
    }

}
