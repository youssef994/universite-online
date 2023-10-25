package com.microservices.Entities;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Author implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="author_id", nullable=false)
    private Integer id;

    @NonNull
    @Column(name="author_name", length=320, nullable=false)
    private String name;

    @Column(name="author_add_date", nullable=false, updatable=false, insertable=false,
            columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Timestamp addDate;

    @Column(name="author_status", length=12, nullable=false)
    private String status = "ACTIVE";


    @ManyToMany
    @JoinTable(
            name="book_author_map",
            joinColumns={ @JoinColumn(name="author_id") },
            inverseJoinColumns={ @JoinColumn(name="book_id") }
    )

    private List<Book> books;




}
