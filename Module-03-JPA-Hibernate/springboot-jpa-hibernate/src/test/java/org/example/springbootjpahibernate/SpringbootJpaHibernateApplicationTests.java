package org.example.springbootjpahibernate;

//import org.example.springbootjpahibernate.entity.ProductEntity;
//import org.example.springbootjpahibernate.repository.ProductRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

@SpringBootTest
class SpringbootJpaHibernateApplicationTests {

//    @Autowired
//    ProductRepository productRepository;

    @Test
    void contextLoads() {
    }

/*    @Test
    void testRepository() {
        ProductEntity productEntity = ProductEntity.builder()
                .sku("Pepsi123")
                .title("Pepsi")
                .price(BigDecimal.valueOf(25.50))
                .quantity(20)
                .build();

       ProductEntity entity = productRepository.save(productEntity);
       System.out.println(entity);
    }

    @Test
    void getRepository() {
//        ProductEntity entity = productRepository.findById(1L).get();
//        List<ProductEntity> entity = productRepository.findByTitle("Pepsi");

//        LocalDateTime dateTime = LocalDateTime.of(
//                2026,      // year
//                7,         // month
//                30,        // day
//                10,        // hour
//                30         // minute
//        );
//
//        List<ProductEntity> entity = productRepository.findByCreatedAtAfter(dateTime);
//        List<ProductEntity> entity = productRepository.findByCreatedAtBefore(dateTime);
//        List<ProductEntity> entity = productRepository.findByTitleContains("Pepsi");
//        List<ProductEntity> entity = productRepository.findByTitleEndsWith("y");



//        List<ProductEntity> entity = productRepository.findByTitleAndPriceEqual("Pepsi", BigDecimal.valueOf(25.30));
//        List<ProductEntity> entity1 = productRepository.findByTitleOrPriceEqual("Pepsi", BigDecimal.valueOf(25.30));
//
//
//        System.out.println(entity);
//        System.out.println(entity1);

    }*/

}
