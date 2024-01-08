package com.enigma.tokopedia.Service;


import com.enigma.tokopedia.Dto.Request.ProductRequest;
import com.enigma.tokopedia.Dto.Response.ProductResponse;
import com.enigma.tokopedia.Entity.Product;
import com.enigma.tokopedia.Entity.ProductPrice;
import com.enigma.tokopedia.Entity.Store;
import org.springframework.data.domain.Page;

import java.util.List;

public interface ProductService {

    ProductResponse createProduct(ProductRequest productRequest);

    ProductResponse getByIdProduct(ProductRequest productRequest);

    List<ProductResponse> getAllProduct();

    ProductResponse updateProduct(ProductRequest productRequest);

    void deleteProduct(String id);

    ProductResponse createProductAndProductPrice(ProductRequest productRequest);

    Page<ProductResponse> getAllByNameOrPrice(String name , Long maxPrice , Integer page, Integer size);



}
