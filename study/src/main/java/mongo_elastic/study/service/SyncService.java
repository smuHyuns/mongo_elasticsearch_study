package mongo_elastic.study.service;

import mongo_elastic.study.domain.User;
import mongo_elastic.study.domain.UserDocument;
import mongo_elastic.study.repository.UserRepository;
import mongo_elastic.study.repository.UserDocumentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SyncService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserDocumentRepository userDocumentRepository;

    public void syncData() {
        // MongoDB에서 데이터 가져오기
        Iterable<User> users = userRepository.findAll();

        // Elasticsearch에 데이터 저장
        users.forEach(user -> {
            UserDocument userDocument = new UserDocument();
            userDocument.setId(user.getId());
            userDocument.setName(user.getName());
            userDocument.setAge(user.getAge());
            userDocumentRepository.save(userDocument);
        });
    }
}
