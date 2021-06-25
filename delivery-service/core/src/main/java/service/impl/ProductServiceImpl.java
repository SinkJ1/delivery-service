package service.impl;

import entity.Product;
import service.ProductService;

import java.util.List;

public class ProductServiceImpl extends BaseServiceImpl<Product, Long> implements ProductService {
    @Override
    public List<Product> sortProductsByCost(List<Product> list) {
        return null;
    }
}
