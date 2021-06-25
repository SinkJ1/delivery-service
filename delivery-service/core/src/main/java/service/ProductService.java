package service;

import entity.Product;

import java.util.List;

public interface ProductService extends BaseService<Product, Long>{

    List<Product> sortProductsByCost(List<Product> list);

}
