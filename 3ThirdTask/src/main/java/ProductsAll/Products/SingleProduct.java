package ProductsAll.Products;

import java.util.Objects;

public class SingleProduct extends Product{//штучный товар
    protected double singleWeight;

    public SingleProduct(String name, String description, double singleWeight){
        super(name, description);
        this.singleWeight = singleWeight;
    }

    public SingleProduct(SingleProduct singleProduct){
        super(singleProduct.getName(), singleProduct.getDescription());
        this.singleWeight = singleProduct.getSingleWeight();
    }

    public double getSingleWeight() {
        return singleWeight;
    }

    //equal toString hashCode


    @Override
    public String toString() {
        return "SingleProduct: " + name +
                ", description " + description +
                ", singleWeight " + singleWeight + '\n';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SingleProduct)) return false;
        if (!super.equals(o)) return false;
        SingleProduct that = (SingleProduct) o;
        return Double.compare(that.getSingleWeight(), getSingleWeight()) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getSingleWeight());
    }
}
