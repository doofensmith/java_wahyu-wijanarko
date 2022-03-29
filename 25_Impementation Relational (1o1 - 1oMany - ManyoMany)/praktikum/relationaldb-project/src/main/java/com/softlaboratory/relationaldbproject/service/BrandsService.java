package com.softlaboratory.relationaldbproject.service;

import com.softlaboratory.relationaldbproject.constant.AppConstant;
import com.softlaboratory.relationaldbproject.domain.dao.BrandsDao;
import com.softlaboratory.relationaldbproject.domain.dto.BrandsDto;
import com.softlaboratory.relationaldbproject.repository.BrandsRepository;
import com.softlaboratory.relationaldbproject.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BrandsService {

    @Autowired
    private BrandsRepository brandsRepository;

    public ResponseEntity<Object> getAllBrand() {
        List<BrandsDao> brandsDaoList = brandsRepository.findAll();
        List<BrandsDto> brandsDtoList = new ArrayList<>();
        for (BrandsDao brandsDao : brandsDaoList) {
            brandsDtoList.add(BrandsDto.builder()
                    .brandId(brandsDao.getBrandId())
                    .brandName(brandsDao.getBrandName())
                    .build());
        }

        return ResponseUtil.build(HttpStatus.OK, AppConstant.KEY_SUCCESS,brandsDtoList);

    }

    public ResponseEntity<Object> getBrandById(Long brandId) {
        Optional<BrandsDao> brandsDao = brandsRepository.findById(brandId);

        if (brandsDao.isPresent()) {
            BrandsDto brandsDto = BrandsDto.builder()
                    .brandId(brandsDao.get().getBrandId())
                    .brandName(brandsDao.get().getBrandName())
                    .build();

            return ResponseUtil.build(HttpStatus.OK, AppConstant.KEY_SUCCESS, brandsDto);

        }else {
            return ResponseUtil.build(HttpStatus.BAD_REQUEST, AppConstant.KEY_DATA_NOT_FOUND, null);
        }
    }

    public ResponseEntity<Object> saveNewBrand(BrandsDto requestBody) {
        BrandsDao brandsDao = BrandsDao.builder()
                .brandName(requestBody.getBrandName())
                .build();

        brandsRepository.save(brandsDao);

        BrandsDto brandsDto = BrandsDto.builder()
                .brandId(brandsDao.getBrandId())
                .brandName(brandsDao.getBrandName())
                .build();

        return ResponseUtil.build(HttpStatus.OK, AppConstant.KEY_SUCCESS, brandsDto);
    }

    public ResponseEntity<Object> updateBrand(Long brandId, BrandsDto requestBody) {
        Optional<BrandsDao> brandsDaoOld = brandsRepository.findById(brandId);

        if (brandsDaoOld.isPresent()) {
            BrandsDao brandsDaoNew = brandsDaoOld.get();
            brandsDaoNew.setBrandName(requestBody.getBrandName());

            brandsRepository.save(brandsDaoNew);

            BrandsDto brandsDto = BrandsDto.builder()
                    .brandId(brandsDaoNew.getBrandId())
                    .brandName(brandsDaoNew.getBrandName())
                    .build();

            return ResponseUtil.build(HttpStatus.OK, AppConstant.KEY_SUCCESS, brandsDto);

        }else {
            return ResponseUtil.build(HttpStatus.BAD_REQUEST, AppConstant.KEY_DATA_NOT_FOUND, null);
        }
    }

    public ResponseEntity<Object> deleteBrand(Long brandId) {
        Optional<BrandsDao> brandsDao = brandsRepository.findById(brandId);

        if (brandsDao.isPresent()) {
            brandsRepository.deleteById(brandId);
            return ResponseUtil.build(HttpStatus.OK, AppConstant.KEY_SUCCESS, null);
        }else {
            return ResponseUtil.build(HttpStatus.BAD_REQUEST, AppConstant.KEY_DATA_NOT_FOUND, null);
        }
    }

}
