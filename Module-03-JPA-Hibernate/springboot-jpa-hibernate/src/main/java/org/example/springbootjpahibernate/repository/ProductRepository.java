package org.example.springbootjpahibernate.repository;
/*
import org.example.springbootjpahibernate.entity.ProductEntity;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<ProductEntity, Long> {

//    List<ProductEntity> findByTitle(String title);
//    List<ProductEntity> findByCreatedAtAfter(LocalDateTime createdAt);
//    List<ProductEntity> findByCreatedAtBefore(LocalDateTime dateTime);
//    List<ProductEntity> findByTitleContains(String title);
//    List<ProductEntity> findByTitleEndsWith(String title);

//    @Query("select e from ProductEntity e where e.title = ?1 and e.price=?2")
//    List<ProductEntity> findByTitleAndPriceEqual(String title, BigDecimal price);
//
//    @Query("select e from ProductEntity e where e.title = ?1 or e.price=?2")
//    List<ProductEntity> findByTitleOrPriceEqual(String title, BigDecimal price);

// Sorting --
//    List<ProductEntity> findByOrderBySkuDesc();
//    List<ProductEntity> findBy(Sort sort);

// Pagination --
    List<ProductEntity> findByTitleContainingIgnoreCase(String title, Pageable pageable);

}

*/