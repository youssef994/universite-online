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
public class Category implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="category_id", nullable=false)
    private Integer id;

    @NonNull
    @Column(name="category_name", length=320, nullable=false)
    private String name;

    @Column(name="category_add_date", nullable=false, updatable=false, insertable=false,
            columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Timestamp addDate;

    @Column(name="category_status", length=12, nullable=false)
    private String status = "ACTIVE";
    @ManyToMany
    @JoinTable(
            name="book_category_map",
            joinColumns={ @JoinColumn(name="category_id") },
            inverseJoinColumns={ @JoinColumn(name="book_id") }
    )
    private List<Book> books;

}
