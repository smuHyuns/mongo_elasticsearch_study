package mongo_elastic.study.controller;

import lombok.RequiredArgsConstructor;
import mongo_elastic.study.domain.User;
import mongo_elastic.study.domain.UserDocument;
import mongo_elastic.study.service.ElasticsearchService;
import mongo_elastic.study.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {
    @Autowired
    private final UserService userService;

    @Autowired
    private final ElasticsearchService elasticsearchService;

    @GetMapping
    public List<User> getUsers() {
        return userService.getAllUsers();
    }

//    @PostMapping
//    public void createUser(@RequestBody User user) {
//        userService.createUser(user);
//    }

    // Mock 데이터 생성
    @PostMapping("/mock")
    public String createMockUsers() {
        userService.createMockUser();
        return "Mock users created successfully.";
    }

    // 이름으로 검색
    @GetMapping("/search")
    public List<UserDocument> searchByName(@RequestParam String name) {
        return elasticsearchService.searchByName(name);
    }
}
