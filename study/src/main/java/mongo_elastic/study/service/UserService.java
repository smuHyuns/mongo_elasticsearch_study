package mongo_elastic.study.service;

import mongo_elastic.study.domain.User;
import mongo_elastic.study.domain.UserDocument;
import mongo_elastic.study.repository.UserDocumentRepository;
import mongo_elastic.study.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserDocumentRepository userDocumentRepository;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User createUser(User user) {
        // MongoDB 저장
        User savedUser = userRepository.save(user);

        // Elasticsearch에 동기화
        UserDocument userDocument = new UserDocument();
        userDocument.setId(savedUser.getId());
        userDocument.setName(savedUser.getName());
        userDocument.setAge(savedUser.getAge());
        userDocumentRepository.save(userDocument);

        return savedUser;
    }

    public void createMockUser() {
        String[] names = {"현수", "준일", "준수", "규찬", "예지", "서연", "테츠"};
        for (int i = 1; i <= 10_000_000; i++) {
            User user = new User();
            user.setAge((int) (Math.random() % 40));
            user.setName(names[(int) (Math.random() % names.length)]);

            createUser(user);
        }
    }
}