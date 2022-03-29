package com.softlaboratory.relationaldbproject.repository;

import com.softlaboratory.relationaldbproject.domain.dao.ProductsDao;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductsRepository extends JpaRepository<ProductsDao, Long> {

    @Query("select p from ProductsDao p order by p.categoriesDao.categoryName")
    List<ProductsDao> sortProductByCategory(Sort sort);

    @Query("select p from ProductsDao p where upper(p.productName) like concat('%',upper(:productName),'%') or upper(p.categoriesDao.categoryName) = upper(:category)")
    List<ProductsDao> findByProductNameAndCategory(
            @Param("productName") @Nullable String productName,
            @Param("category") @Nullable  String category);

    Page<ProductsDao> findAll(Pageable pageable);

}
