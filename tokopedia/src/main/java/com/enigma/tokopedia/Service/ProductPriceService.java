package com.enigma.tokopedia.Service;

import com.enigma.tokopedia.Entity.ProductPrice;

import java.util.List;

public interface ProductPriceService {
    ProductPrice create(ProductPrice productPrice);

    ProductPrice getById(String id);

    ProductPrice findProductPriceIsActive(String productId ,Boolean active);

    List <ProductPrice> getAllProduct();

}
