package ProductsAll.BatchOfProducts;

import ProductsAll.PackagingProducts.IProductPackaging;

public class BatchOfProducts {//партия товаров
    protected String description;
    protected IProductPackaging[] productPackaging;
    public BatchOfProducts(String description, IProductPackaging... productPackaging){
        if(description == null || description.isEmpty()){
            throw new NullPointerException("Empty description of Batch od products");
        }
        if(productPackaging == null){
            throw new NullPointerException("Product packaging is null");
        }
        this.description = description;
        this.productPackaging = new IProductPackaging[productPackaging.length];
        System.arraycopy(productPackaging, 0, this.productPackaging, 0, productPackaging.length);
    }

    public double getGeneralWeight(){
        double generalWeight = 0;
        for (IProductPackaging product : productPackaging) {
            generalWeight += product.getBrutto();
        }
        return generalWeight;
    }

    public IProductPackaging getProductPackaging(int i) {
        return productPackaging[i];
    }

    public IProductPackaging[] getProductPackaging() {
        return productPackaging;
    }
}
