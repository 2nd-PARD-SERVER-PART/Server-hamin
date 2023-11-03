package pard.seminar5th.entity.book;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = true)
    private String name;

    public Book(String name){
        if(name == null || name.isBlank()) {
            throw new IllegalArgumentException(String.format("잘못된 이름(%s)이 들어왔습니다.", name));
        }
        this.name = name;
    }

}
