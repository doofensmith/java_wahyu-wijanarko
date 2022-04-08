package com.softlaboratory.graphqlproject.service;

import com.softlaboratory.graphqlproject.domain.dao.AuthorDao;
import com.softlaboratory.graphqlproject.domain.dto.AuthorDto;
import com.softlaboratory.graphqlproject.repository.AuthorRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AuthorService {

    private ModelMapper modelMapper = new ModelMapper();

    @Autowired
    private AuthorRepository authorRepository;

    public List<AuthorDto> getAllAuthor() {
        try {
            List<AuthorDao> authorDaoList = authorRepository.findAll();
            List<AuthorDto> authorDtoList = new ArrayList<>();
            for (AuthorDao authorDao : authorDaoList) {
                authorDtoList.add(modelMapper.map(authorDao,AuthorDto.class));
            }
            return authorDtoList;
        }catch (Exception e) {
            throw e;
        }
    }

    public AuthorDto getAuthorById(Long id) {
        try {
            Optional<AuthorDao> authorDao = authorRepository.findById(id);
            if (authorDao.isPresent()) {
                return modelMapper.map(authorDao.get(),AuthorDto.class);
            }else {
                throw new IllegalArgumentException("author not found.");
            }
        } catch (Exception e) {
            throw e;
        }
    }

    public AuthorDto addAuthor(String name, String thumbnail) {
        try {
            AuthorDto authorDto = AuthorDto.builder()
                    .name(name)
                    .thumbnail(thumbnail)
                    .build();

            AuthorDao authorDao = modelMapper.map(authorDto, AuthorDao.class);
            authorDao = authorRepository.save(authorDao);
            return modelMapper.map(authorDao, AuthorDto.class);
        }catch (Exception e) {
            throw e;
        }
    }

}
