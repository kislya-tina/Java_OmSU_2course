package BatchOfProducts;

import ProductsAll.BatchOfProducts.BatchOfProducts;
import ProductsAll.Package.Package;
import ProductsAll.PackagingProducts.IProductPackaging;
import ProductsAll.PackagingProducts.SingleProductPackaging;
import ProductsAll.PackagingProducts.WeightProductPackaging;
import ProductsAll.Products.SingleProduct;
import ProductsAll.Products.WeightProduct;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class NettoBruttoTests {
    Package appleBox = new Package("Box", 10.0);
    SingleProduct apple = new SingleProduct("Apple", "Green apple", 100.0);
    SingleProductPackaging packApple = new SingleProductPackaging(appleBox, apple, 10);

    Package sugarBag = new Package("Bag for sugar", 10.0);
    WeightProduct sugar = new WeightProduct("Sugar", "Sweet sugar");
    WeightProductPackaging packSugar = new WeightProductPackaging(sugarBag, sugar, 150.0);

    Package saltBag = new Package("Bag for salt", 10.0);
    WeightProduct salt = new WeightProduct("Salt", "Salty salt");
    WeightProductPackaging packSalt = new WeightProductPackaging(saltBag, salt, 200.0);

    IProductPackaging[] products = {packSugar, packSalt, packApple};
    BatchOfProducts batch = new BatchOfProducts( "Sugar, salt and apple", products);

    @Test
    public void NettoTest()
    {
        double netto;
        netto = batch.getGeneralWeight() - appleBox.getWeight() - sugarBag.getWeight() - saltBag.getWeight();
        assertEquals(netto, 1350.0);
    }

}