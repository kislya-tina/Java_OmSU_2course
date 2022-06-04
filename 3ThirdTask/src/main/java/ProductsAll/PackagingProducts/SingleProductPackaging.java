package ProductsAll.PackagingProducts;

import ProductsAll.Package.Package;
import ProductsAll.Products.SingleProduct;

public class SingleProductPackaging extends SingleProduct implements IProductPackaging {//Упакованный штучный товар
    protected int count;
    protected Package pack;

    public SingleProductPackaging(Package pack, String name, String description, double singleWeight, int count) {
        super(name, description, singleWeight);
        this.count = count;
        this.pack = pack;
    }

    public SingleProductPackaging(Package pack, SingleProduct singleProduct, int count) {
        super(singleProduct);
        this.count = count;
        this.pack = new Package(pack);
    }

    @Override
    public double getNetto() {
        return singleWeight * count;
    }

    @Override
    public double getBrutto() {
        return singleWeight * count + pack.getWeight();
    }
}
