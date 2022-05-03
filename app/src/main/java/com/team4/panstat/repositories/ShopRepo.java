package com.team4.panstat.repositories;


import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.team4.panstat.models.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class ShopRepo {

    private MutableLiveData<List<Product>> mutableProductList;

    public LiveData<List<Product>> getProducts() {
        if (mutableProductList == null) {
            mutableProductList = new MutableLiveData<>();
            loadProducts();
        }
        return mutableProductList;
    }

    private void loadProducts() {
        List<Product> productList = new ArrayList<>();
        productList.add(new Product(UUID.randomUUID().toString(), "PPE kit", 1299, true, "https://raw.githubusercontent.com/Duchies/PhotoResources/master/3697003.jpg" ));
        productList.add(new Product(UUID.randomUUID().toString(), "PPE kit Pack", 799, true, "https://raw.githubusercontent.com/Duchies/PhotoResources/master/3697003.jpg"));
        productList.add(new Product(UUID.randomUUID().toString(), "Santizer", 999, true, "https://raw.githubusercontent.com/Duchies/PhotoResources/master/3697003.jpg"));
        productList.add(new Product(UUID.randomUUID().toString(), "iPhone 11", 699, false, "https://raw.githubusercontent.com/Duchies/PhotoResources/master/3697003.jpg"));
        productList.add(new Product(UUID.randomUUID().toString(), "iPhone 11 Pro", 999, true, "https://raw.githubusercontent.com/Duchies/PhotoResources/master/3697003.jpg"));
        productList.add(new Product(UUID.randomUUID().toString(), "iPhone 11 Pro Max", 1099, true, "https://raw.githubusercontent.com/Duchies/PhotoResources/master/3697003.jpg"));
        productList.add(new Product(UUID.randomUUID().toString(), "iPhone SE", 399, true, "https://raw.githubusercontent.com/Duchies/PhotoResources/master/3697003.jpg"));
        productList.add(new Product(UUID.randomUUID().toString(), "MacBook Air", 999, true, "https://raw.githubusercontent.com/Duchies/PhotoResources/master/3697003.jpg"));
        productList.add(new Product(UUID.randomUUID().toString(), "MacBook Pro 13", 1299, true, "https://raw.githubusercontent.com/Duchies/PhotoResources/master/3697003.jpg"));
        productList.add(new Product(UUID.randomUUID().toString(), "MacBook Pro 16", 2399, true, "https://raw.githubusercontent.com/Duchies/PhotoResources/master/3697003.jpg"));
        mutableProductList.setValue(productList);
    }
}
