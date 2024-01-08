package com.enigma.tokopedia.Service.Impl;

import com.enigma.tokopedia.Entity.ProductPrice;
import com.enigma.tokopedia.Repositori.ProductPriceRepositori;
import com.enigma.tokopedia.Service.ProductPriceService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class ProductPriceServiceImpl implements ProductPriceService {
    private final ProductPriceRepositori productPriceRepositori;

    @Override
    public ProductPrice create(ProductPrice productPrice) {
        return productPriceRepositori.save(productPrice);
    }

    @Override
    public ProductPrice getById(String id) {


        return productPriceRepositori.findById(id).orElse(null);
    }


    @Override
    public ProductPrice findProductPriceIsActive(String productId, Boolean active) {
        return null;
    }

    @Override
    public List <ProductPrice> getAllProduct() {


        return productPriceRepositori.findAll();
    }
}
