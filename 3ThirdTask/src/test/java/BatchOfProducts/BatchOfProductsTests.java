package BatchOfProducts;

import static org.testng.Assert.*;

import ProductsAll.BatchOfProducts.BatchOfProducts;
import ProductsAll.PackagingProducts.IProductPackaging;
import ProductsAll.PackagingProducts.SingleProductPackaging;
import ProductsAll.PackagingProducts.WeightProductPackaging;
import ProductsAll.Products.SingleProduct;
import ProductsAll.Products.WeightProduct;
import org.testng.annotations.Test;
import ProductsAll.Package.Package;

public class BatchOfProductsTests {

    Package pack = new Package("Box", 10.0);
    SingleProduct apple = new SingleProduct("Apple", "Green apple", 100.0);
    SingleProductPackaging packApple = new SingleProductPackaging(pack, apple, 10);

    Package sugarBag = new Package("Bag for sugar", 10.0);
    WeightProduct sugar = new WeightProduct("Sugar", "Sweet sugar");
    WeightProductPackaging packSugar = new WeightProductPackaging(sugarBag, sugar, 150.0);

    Package saltBag = new Package("Bag for salt", 10.0);
    WeightProduct salt = new WeightProduct("Salt", "Salty salt");
    WeightProductPackaging packSalt = new WeightProductPackaging(saltBag, salt, 200.0);

    IProductPackaging[] products = {packSugar, packSalt, packApple};
    IProductPackaging[] twoApples = {packApple, packApple};
    BatchOfProducts batch = new BatchOfProducts( "Sugar, salt and apple", products);
    BatchOfProducts batchOf2Apples = new BatchOfProducts( "Sugar, salt and apple", twoApples);


    @Test
    public void BatchTest()
    {
        System.out.println("""
                10 + 100*10 = 1010 apple
                10 + 150 = 160 sugar
                10 + 200 = 210 salt
                summary = 1010 + 160 + 210 = 1380""");
        assertEquals(batch.getGeneralWeight(), 1380.0);
    }
    @Test
    public void testGetProducts() {
        assertEquals(batch.getProductPackaging(), products);
    }

    @Test
    public void testToString(){
        assertEquals(apple.toString(), "SingleProduct: Apple, description Green apple, singleWeight 100.0\n");
    }

    @Test
    public void testGetBrutto() {
        assertEquals(batchOf2Apples.getGeneralWeight(), 2020.0);
    }


}