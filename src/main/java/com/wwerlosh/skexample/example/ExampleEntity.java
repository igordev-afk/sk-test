package com.wwerlosh.skexample.example;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

@Entity
@Table(name = "sk_example_table")
@Getter
@Setter
public class ExampleEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "jsonb", nullable = false)
    @JdbcTypeCode(SqlTypes.JSON)
    private ExampleObject obj;

    public ExampleEntity() {
    }

    public ExampleEntity(Long id, ExampleObject obj) {
        this.id = id;
        this.obj = obj;
    }

    @Getter
    @Setter
    public static class ExampleObject implements Serializable {
        @JsonProperty("current")
        private int current;

        public ExampleObject(int current) {
            this.current = current;
        }
    }
}
