package com.softlaboratory.relationaldbproject.service;

import com.softlaboratory.relationaldbproject.constant.AppConstant;
import com.softlaboratory.relationaldbproject.domain.dao.CategoriesDao;
import com.softlaboratory.relationaldbproject.domain.dto.CategoriesDto;
import com.softlaboratory.relationaldbproject.repository.CategoriesRepository;
import com.softlaboratory.relationaldbproject.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CategoriesService {

    @Autowired
    private CategoriesRepository categoriesRepository;

    public ResponseEntity<Object> getAllCategory() {
        List<CategoriesDao> categoriesDaoList = categoriesRepository.findAll();
        List<CategoriesDto> categoriesDtoList = new ArrayList<>();
        for (CategoriesDao categoriesDao : categoriesDaoList) {
            categoriesDtoList.add(CategoriesDto.builder()
                    .categoryId(categoriesDao.getCategoryId())
                    .categoryName(categoriesDao.getCategoryName())
                    .build());
        }

        return ResponseUtil.build(HttpStatus.OK, AppConstant.KEY_SUCCESS,categoriesDtoList);

    }

    public ResponseEntity<Object> getCategoryById(Long categoryId) {
        Optional<CategoriesDao> categoriesDao = categoriesRepository.findById(categoryId);

        if (categoriesDao.isPresent()) {
            CategoriesDto categoriesDto = CategoriesDto.builder()
                    .categoryId(categoriesDao.get().getCategoryId())
                    .categoryName(categoriesDao.get().getCategoryName())
                    .build();

            return ResponseUtil.build(HttpStatus.OK, AppConstant.KEY_SUCCESS, categoriesDto);

        }else {
            return ResponseUtil.build(HttpStatus.BAD_REQUEST, AppConstant.KEY_DATA_NOT_FOUND, null);
        }
    }

    public ResponseEntity<Object> saveNewCategory(CategoriesDto requestBody) {
        CategoriesDao categoriesDao = CategoriesDao.builder()
                .categoryName(requestBody.getCategoryName())
                .build();

        categoriesRepository.save(categoriesDao);

        CategoriesDto categoriesDto = CategoriesDto.builder()
                .categoryId(categoriesDao.getCategoryId())
                .categoryName(categoriesDao.getCategoryName())
                .build();

        return ResponseUtil.build(HttpStatus.OK, AppConstant.KEY_SUCCESS, categoriesDto);
    }

    public ResponseEntity<Object> updateCategory(Long categoryId, CategoriesDto requestBody) {
        Optional<CategoriesDao> categoriesDaoOld = categoriesRepository.findById(categoryId);

        if (categoriesDaoOld.isPresent()) {
            CategoriesDao categoriesDaoNew = categoriesDaoOld.get();
            categoriesDaoNew.setCategoryName(requestBody.getCategoryName());

            categoriesRepository.save(categoriesDaoNew);

            CategoriesDto categoriesDto = CategoriesDto.builder()
                    .categoryId(categoriesDaoNew.getCategoryId())
                    .categoryName(categoriesDaoNew.getCategoryName())
                    .build();

            return ResponseUtil.build(HttpStatus.OK, AppConstant.KEY_SUCCESS, categoriesDto);

        }else {
            return ResponseUtil.build(HttpStatus.BAD_REQUEST, AppConstant.KEY_DATA_NOT_FOUND, null);
        }
    }

    public ResponseEntity<Object> deleteCategory(Long categoryId) {
        Optional<CategoriesDao> categoriesDao = categoriesRepository.findById(categoryId);

        if (categoriesDao.isPresent()) {
            categoriesRepository.deleteById(categoryId);
            return ResponseUtil.build(HttpStatus.OK, AppConstant.KEY_SUCCESS, null);
        }else {
            return ResponseUtil.build(HttpStatus.BAD_REQUEST, AppConstant.KEY_DATA_NOT_FOUND, null);
        }
    }

}
