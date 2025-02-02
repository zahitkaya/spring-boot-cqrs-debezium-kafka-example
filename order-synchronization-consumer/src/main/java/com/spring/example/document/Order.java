package com.spring.example.document;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;
import org.springframework.data.elasticsearch.annotations.WriteTypeHint;

@Document(indexName = "orders",
        writeTypeHint = WriteTypeHint.FALSE) // to ignore _class property from document
@Data
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
@NoArgsConstructor
@AllArgsConstructor
public class Order {

    @Id
    @Field(type = FieldType.Long)
    Long id;

    @Field(type = FieldType.Text)
    String name;

    @Field(type = FieldType.Text)
    @JsonProperty("customer_id")
    String customerId;
}
