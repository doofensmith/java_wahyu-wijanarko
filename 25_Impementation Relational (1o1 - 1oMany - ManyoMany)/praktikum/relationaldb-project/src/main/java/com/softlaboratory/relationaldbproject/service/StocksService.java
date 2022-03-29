package com.softlaboratory.relationaldbproject.service;

import com.softlaboratory.relationaldbproject.constant.AppConstant;
import com.softlaboratory.relationaldbproject.domain.dao.ProductsDao;
import com.softlaboratory.relationaldbproject.domain.dao.StocksDao;
import com.softlaboratory.relationaldbproject.domain.dto.BrandsDto;
import com.softlaboratory.relationaldbproject.domain.dto.CategoriesDto;
import com.softlaboratory.relationaldbproject.domain.dto.ProductsDto;
import com.softlaboratory.relationaldbproject.domain.dto.StocksDto;
import com.softlaboratory.relationaldbproject.repository.StocksRepository;
import com.softlaboratory.relationaldbproject.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class StocksService {

    @Autowired
    private StocksRepository stocksRepository;

    public ResponseEntity<Object> getAllStock() {
        List<StocksDao> stocksDaoList = stocksRepository.findAll();
        List<StocksDto> stocksDtoList = new ArrayList<>();
        for (StocksDao stocksDao : stocksDaoList) {
            stocksDtoList.add(StocksDto.builder()
                    .stockId(stocksDao.getStockId())
                    .product(ProductsDto.builder()
                            .productId(stocksDao.getProductsDao().getProductId())
                            .productName(stocksDao.getProductsDao().getProductName())
                            .brand(BrandsDto.builder()
                                    .brandName(stocksDao.getProductsDao().getBrandsDao().getBrandName())
                                    .build())
                            .category(CategoriesDto.builder()
                                    .categoryName(stocksDao.getProductsDao().getBrandsDao().getBrandName())
                                    .build())
                            .modelYear(stocksDao.getProductsDao().getModelYear())
                            .listPrice(stocksDao.getProductsDao().getListPrice())
                            .build())
                    .quantity(stocksDao.getQuantity())
                    .build());
        }

        return ResponseUtil.build(HttpStatus.OK, AppConstant.KEY_SUCCESS,stocksDtoList);

    }

    public ResponseEntity<Object> getStockById(Long stockId) {
        Optional<StocksDao> stocksDao = stocksRepository.findById(stockId);

        if (stocksDao.isPresent()) {
            StocksDto stocksDto = StocksDto.builder()
                    .stockId(stocksDao.get().getStockId())
                    .product(ProductsDto.builder()
                            .productId(stocksDao.get().getProductsDao().getProductId())
                            .productName(stocksDao.get().getProductsDao().getProductName())
                            .build())
                    .quantity(stocksDao.get().getQuantity())
                    .build();

            return ResponseUtil.build(HttpStatus.OK, AppConstant.KEY_SUCCESS, stocksDto);

        }else {
            return ResponseUtil.build(HttpStatus.BAD_REQUEST, AppConstant.KEY_DATA_NOT_FOUND, null);
        }
    }

    public ResponseEntity<Object> saveNewStock(StocksDto requestBody) {
        StocksDao stocksDao = StocksDao.builder()
                .productsDao(ProductsDao.builder()
                        .productId(requestBody.getProduct().getProductId())
                        .build())
                .quantity(requestBody.getQuantity())
                .build();

        stocksRepository.save(stocksDao);

        StocksDto stocksDto = StocksDto.builder()
                .stockId(stocksDao.getStockId())
                .product(ProductsDto.builder()
                        .productId(stocksDao.getProductsDao().getProductId())
                        .productName(stocksDao.getProductsDao().getProductName())
                        .build())
                .quantity(stocksDao.getQuantity())
                .build();

        return ResponseUtil.build(HttpStatus.OK, AppConstant.KEY_SUCCESS, stocksDto);
    }

    public ResponseEntity<Object> updateStock(Long stockId, StocksDto requestBody) {
        Optional<StocksDao> stocksDaoOld = stocksRepository.findById(stockId);

        if (stocksDaoOld.isPresent()) {
            StocksDao stocksDaoNew = stocksDaoOld.get();
            stocksDaoNew.setQuantity(requestBody.getQuantity());

            stocksRepository.save(stocksDaoNew);

            StocksDto stocksDto = StocksDto.builder()
                    .stockId(stocksDaoNew.getStockId())
                    .product(ProductsDto.builder()
                            .productId(stocksDaoNew.getProductsDao().getProductId())
                            .productName(stocksDaoNew.getProductsDao().getProductName())
                            .build())
                    .quantity(stocksDaoNew.getQuantity())
                    .build();

            return ResponseUtil.build(HttpStatus.OK, AppConstant.KEY_SUCCESS, stocksDto);

        }else {
            return ResponseUtil.build(HttpStatus.BAD_REQUEST, AppConstant.KEY_DATA_NOT_FOUND, null);
        }
    }

    public ResponseEntity<Object> deleteStock(Long stockId) {
        Optional<StocksDao> stocksDao = stocksRepository.findById(stockId);

        if (stocksDao.isPresent()) {
            stocksRepository.deleteById(stockId);
            return ResponseUtil.build(HttpStatus.OK, AppConstant.KEY_SUCCESS, null);
        }else {
            return ResponseUtil.build(HttpStatus.BAD_REQUEST, AppConstant.KEY_DATA_NOT_FOUND, null);
        }
    }

}
