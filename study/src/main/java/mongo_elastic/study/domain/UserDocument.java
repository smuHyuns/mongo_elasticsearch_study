package mongo_elastic.study.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@Document(indexName = "user_index") // Elasticsearch의 Index 이름
public class UserDocument {
    @Id
    private String id;
    private String name;
    private int age;

    // Getter, Setter, Constructors
    public UserDocument() {
    }

    public UserDocument(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
