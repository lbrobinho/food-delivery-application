package com.Bo.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@Document
public class UserInfo {
    @Id
    private String id;

    private String firstName;
    private String lastName;
    private String phone;
    private String address;

}
