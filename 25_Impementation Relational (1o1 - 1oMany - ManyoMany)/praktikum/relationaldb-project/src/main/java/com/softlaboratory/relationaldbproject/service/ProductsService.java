package com.softlaboratory.relationaldbproject.service;

import com.softlaboratory.relationaldbproject.constant.AppConstant;
import com.softlaboratory.relationaldbproject.domain.dao.BrandsDao;
import com.softlaboratory.relationaldbproject.domain.dao.CategoriesDao;
import com.softlaboratory.relationaldbproject.domain.dao.ProductsDao;
import com.softlaboratory.relationaldbproject.domain.dto.BrandsDto;
import com.softlaboratory.relationaldbproject.domain.dto.CategoriesDto;
import com.softlaboratory.relationaldbproject.domain.dto.ProductsDto;
import com.softlaboratory.relationaldbproject.repository.ProductsRepository;
import com.softlaboratory.relationaldbproject.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductsService {

    @Autowired
    private ProductsRepository productsRepository;

    public ResponseEntity<Object> getAllProduct() {
        List<ProductsDao> productsDaoList = productsRepository.findAll();
        List<ProductsDto> productsDtoList = new ArrayList<>();
        for (ProductsDao productsDao : productsDaoList) {
            productsDtoList.add(ProductsDto.builder()
                    .productId(productsDao.getProductId())
                    .productName(productsDao.getProductName())
                    .brand(BrandsDto.builder()
                            .brandId(productsDao.getBrandsDao().getBrandId())
                            .brandName(productsDao.getBrandsDao().getBrandName())
                            .build())
                    .category(CategoriesDto.builder()
                            .categoryId(productsDao.getCategoriesDao().getCategoryId())
                            .categoryName(productsDao.getCategoriesDao().getCategoryName())
                            .build())
                    .modelYear(productsDao.getModelYear())
                    .listPrice(productsDao.getListPrice())
                    .build()
            );
        }

        return ResponseUtil.build(HttpStatus.OK,AppConstant.KEY_SUCCESS,productsDtoList);

    }

    public ResponseEntity<Object> getProductById(Long productId) {
        Optional<ProductsDao> productsDao = productsRepository.findById(productId);

        if (productsDao.isPresent()) {
            ProductsDto productDto = ProductsDto.builder()
                    .productId(productsDao.get().getProductId())
                    .productName(productsDao.get().getProductName())
                    .brand(BrandsDto.builder()
                            .brandId(productsDao.get().getBrandsDao().getBrandId())
                            .brandName(productsDao.get().getBrandsDao().getBrandName())
                            .build())
                    .category(CategoriesDto.builder()
                            .categoryId(productsDao.get().getCategoriesDao().getCategoryId())
                            .categoryName(productsDao.get().getCategoriesDao().getCategoryName())
                            .build())
                    .modelYear(productsDao.get().getModelYear())
                    .listPrice(productsDao.get().getListPrice())
                    .build();

            return ResponseUtil.build(HttpStatus.OK, AppConstant.KEY_SUCCESS, productDto);

        }else {
            return ResponseUtil.build(HttpStatus.BAD_REQUEST, AppConstant.KEY_DATA_NOT_FOUND, null);
        }
    }

    public ResponseEntity<Object> saveNewProduct(ProductsDto requestBody) {
        ProductsDao productsDao = ProductsDao.builder()
                .productName(requestBody.getProductName())
                .brandsDao(BrandsDao.builder()
                        .brandId(requestBody.getBrand().getBrandId())
                        .build())
                .categoriesDao(CategoriesDao.builder()
                        .categoryId(requestBody.getCategory().getCategoryId())
                        .build())
                .modelYear(requestBody.getModelYear())
                .listPrice(requestBody.getListPrice())
                .build();

        productsRepository.save(productsDao);

        ProductsDto productDto = ProductsDto.builder()
                .productId(productsDao.getProductId())
                .productName(productsDao.getProductName())
                .brand(BrandsDto.builder()
                        .brandId(productsDao.getBrandsDao().getBrandId())
                        .build())
                .category(CategoriesDto.builder()
                        .categoryId(productsDao.getCategoriesDao().getCategoryId())
                        .build())
                .modelYear(productsDao.getModelYear())
                .listPrice(productsDao.getListPrice())
                .build();

        return ResponseUtil.build(HttpStatus.OK, AppConstant.KEY_SUCCESS, productDto);
    }

    public ResponseEntity<Object> updateProduct(Long productId, ProductsDto requestBody) {
        Optional<ProductsDao> productsDaoOld = productsRepository.findById(productId);

        if (productsDaoOld.isPresent()) {
            ProductsDao productDaoNew = productsDaoOld.get();
            productDaoNew.setProductName(requestBody.getProductName());
            productDaoNew.setBrandsDao(BrandsDao.builder()
                    .brandId(requestBody.getBrand().getBrandId())
                    .build());
            productDaoNew.setCategoriesDao(CategoriesDao.builder()
                    .categoryId(requestBody.getCategory().getCategoryId())
                    .build());
            productDaoNew.setModelYear(requestBody.getModelYear());
            productDaoNew.setListPrice(requestBody.getListPrice());
            productsRepository.save(productDaoNew);

            ProductsDto productDto = ProductsDto.builder()
                    .productId(productDaoNew.getProductId())
                    .productName(productDaoNew.getProductName())
                    .brand(BrandsDto.builder()
                            .brandId(productDaoNew.getBrandsDao().getBrandId())
                            .build())
                    .category(CategoriesDto.builder()
                            .categoryId(productDaoNew.getCategoriesDao().getCategoryId())
                            .build())
                    .modelYear(productDaoNew.getModelYear())
                    .listPrice(productDaoNew.getListPrice())
                    .build();

            return ResponseUtil.build(HttpStatus.OK, AppConstant.KEY_SUCCESS, productDto);

        }else {
            return ResponseUtil.build(HttpStatus.BAD_REQUEST, AppConstant.KEY_DATA_NOT_FOUND, null);
        }
    }

    public ResponseEntity<Object> deleteProduct(Long productId) {
        Optional<ProductsDao> productsDao = productsRepository.findById(productId);

        if (productsDao.isPresent()) {
            productsRepository.deleteById(productId);
            return ResponseUtil.build(HttpStatus.OK, AppConstant.KEY_SUCCESS, null);
        }else {
            return ResponseUtil.build(HttpStatus.BAD_REQUEST, AppConstant.KEY_DATA_NOT_FOUND, null);
        }
    }

    public ResponseEntity<Object> getAllProductByName(String productName, String category) {
        List<ProductsDao> productsDaoList = productsRepository.findByProductNameAndCategory(productName, category);
        List<ProductsDto> productsDtoList = new ArrayList<>();
        for (ProductsDao productsDao : productsDaoList) {
            productsDtoList.add(ProductsDto.builder()
                    .productId(productsDao.getProductId())
                    .productName(productsDao.getProductName())
                    .brand(BrandsDto.builder()
                            .brandId(productsDao.getBrandsDao().getBrandId())
                            .brandName(productsDao.getBrandsDao().getBrandName())
                            .build())
                    .category(CategoriesDto.builder()
                            .categoryId(productsDao.getCategoriesDao().getCategoryId())
                            .categoryName(productsDao.getCategoriesDao().getCategoryName())
                            .build())
                    .modelYear(productsDao.getModelYear())
                    .listPrice(productsDao.getListPrice())
                    .build()
            );
        }

        return ResponseUtil.build(HttpStatus.OK,AppConstant.KEY_SUCCESS,productsDtoList);

    }

    public ResponseEntity<Object> sortProductByCategory() {
        List<ProductsDao> productsDaoList = productsRepository.sortProductByCategory(Sort.by(Sort.Direction.ASC, "categoriesDao.categoryName"));
        List<ProductsDto> productsDtoList = new ArrayList<>();
        for (ProductsDao productsDao : productsDaoList) {
            productsDtoList.add(ProductsDto.builder()
                    .productId(productsDao.getProductId())
                    .productName(productsDao.getProductName())
                    .brand(BrandsDto.builder()
                            .brandId(productsDao.getBrandsDao().getBrandId())
                            .brandName(productsDao.getBrandsDao().getBrandName())
                            .build())
                    .category(CategoriesDto.builder()
                            .categoryId(productsDao.getCategoriesDao().getCategoryId())
                            .categoryName(productsDao.getCategoriesDao().getCategoryName())
                            .build())
                    .modelYear(productsDao.getModelYear())
                    .listPrice(productsDao.getListPrice())
                    .build()
            );
        }

        return ResponseUtil.build(HttpStatus.OK,AppConstant.KEY_SUCCESS,productsDtoList);

    }

    public ResponseEntity<Object> findAllProductPaging(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<ProductsDao> productsDaoPage = productsRepository.findAll(pageable);
        List<ProductsDao> productsDaoList = productsDaoPage.getContent();
        List<ProductsDto> productsDtoList = new ArrayList<>();
        for (ProductsDao productsDao : productsDaoList) {
            productsDtoList.add(ProductsDto.builder()
                    .productId(productsDao.getProductId())
                    .productName(productsDao.getProductName())
                    .brand(BrandsDto.builder()
                            .brandId(productsDao.getBrandsDao().getBrandId())
                            .brandName(productsDao.getBrandsDao().getBrandName())
                            .build())
                    .category(CategoriesDto.builder()
                            .categoryId(productsDao.getCategoriesDao().getCategoryId())
                            .categoryName(productsDao.getCategoriesDao().getCategoryName())
                            .build())
                    .modelYear(productsDao.getModelYear())
                    .listPrice(productsDao.getListPrice())
                    .build()
            );
        }

        return ResponseUtil.build(HttpStatus.OK,AppConstant.KEY_SUCCESS,productsDtoList);

    }

}
