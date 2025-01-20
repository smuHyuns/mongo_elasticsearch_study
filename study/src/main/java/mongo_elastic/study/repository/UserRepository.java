package mongo_elastic.study.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import mongo_elastic.study.domain.User;


public interface UserRepository extends MongoRepository<User, String> {

}
