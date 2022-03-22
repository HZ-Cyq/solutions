package books.code_out_efficiency.B06_collection_test.hashcode_equals;

import java.util.HashSet;
import java.util.Objects;

/**
 * @author chenyuqun
 * @date 2022/3/2 4:10 下午
 */
public class Product {

    private Integer id;

    private String name;

    public Product(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // 重写equals
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Product product = (Product) o;
        return Objects.equals(id, product.id);
    }

//    @Override
//    public int hashCode() {
//        return Objects.hash(id);
//    }

    public static void main(String[] args) {
        Product product1 = new Product(1, "包子");
        Product product2 = new Product(1, "馒头");

        HashSet<Product> products = new HashSet<>();
        products.add(product1);
        products.add(product2);
        // 使用equals判断是否相等
        System.out.println(product1.equals(product2));
        // 查看HashSet中元素个数
        // 如果没有覆写hashCode，这个返回值是2，如果写了就会返回1.
        System.out.println(products.size());
    }
}
