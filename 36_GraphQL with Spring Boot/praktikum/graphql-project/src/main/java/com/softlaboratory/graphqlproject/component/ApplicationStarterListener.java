//package com.softlaboratory.graphqlproject.component;
//
//import com.softlaboratory.graphqlproject.domain.dao.AuthorDao;
//import com.softlaboratory.graphqlproject.repository.AuthorRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.ApplicationListener;
//import org.springframework.context.event.ContextRefreshedEvent;
//import org.springframework.stereotype.Component;
//
//import java.util.List;
//
//@Component
//public class ApplicationStarterListener implements ApplicationListener<ContextRefreshedEvent> {
//
//    @Autowired
//    private AuthorRepository authorRepository;
//
//    @Override
//    public void onApplicationEvent(ContextRefreshedEvent event) {
//        List<AuthorDao> authorDaoList = List.of(
//                AuthorDao.builder()
//                        .name("Author 1")
//                        .thumbnail("Thumbnail 1")
//                        .build(),
//                AuthorDao.builder()
//                        .name("Author 2")
//                        .thumbnail("Thumbnail 2")
//                        .build()
//        );
//        authorRepository.saveAll(authorDaoList);
//    }
//}
