package mongo_elastic.study.service;

import mongo_elastic.study.domain.UserDocument;
import mongo_elastic.study.repository.UserDocumentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ElasticsearchService {
    @Autowired
    private UserDocumentRepository userDocumentRepository;

    // 이름으로 검색
    public List<UserDocument> searchByName(String name) {
        return userDocumentRepository.findByName(name);
    }
}
