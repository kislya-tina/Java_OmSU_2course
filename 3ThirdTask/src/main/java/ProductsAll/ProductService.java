package ProductsAll;

import Filter.EndStringFilter;
import ProductsAll.BatchOfProducts.BatchOfProducts;
import ProductsAll.Products.Product;

public class ProductService {

    public int countByFilter(BatchOfProducts batchOfProducts, EndStringFilter filter){
        int counter = 0;
        for(int i = 0; i < batchOfProducts.getProductPackaging().length; i++){
            if(filter.apply(((Product) batchOfProducts.getProductPackaging(i)).getName())){
                counter++;
            }


        }
        return counter;
    }

}
