package ru.netology.domain;

public class ProductRepository {

    protected Product[] products = new Product[0];


    public void save(Product product) {
        int length = products.length + 1;
        Product[] tmp = new Product[length];
        System.arraycopy(products, 0, tmp, 0, products.length);
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = product;
        products = tmp;


    }

    public Product[] findAll() {
        return products;
    }


    public void removeById(int id) {
        findById(id);
        if (findById(id) == null) {
            throw new NotFoundException("id товара не найден:" + id);
        }
        int length = products.length - 1;
        Product[] tmp = new Product[length];
        int index = 0;
        for (Product product : products) {
            if (product.getId() != id) {
                tmp[index] = product;
                index++;
            }
        }

        products = tmp;

    }


    public Product findById(int id) {
        for (Product product : products) {
            if (product.getId() == id) {
                return product;
            }
        }
        return null;
    }


    //throw new NotFoundException("id товара не найден:" + "id");

}














