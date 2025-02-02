package com.spring.example.document;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;
import org.springframework.data.elasticsearch.annotations.WriteTypeHint;

@Document(indexName = "customers",
        writeTypeHint = WriteTypeHint.FALSE) // to ignore _class property from document
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Customer {

    @Id
    @Field(type = FieldType.Long)
    Long id;

    @Field(type = FieldType.Text)
    String name;

    @Field(type = FieldType.Text)
    @JsonProperty("contact_data") // to decode elk response
    String contactData;
}
