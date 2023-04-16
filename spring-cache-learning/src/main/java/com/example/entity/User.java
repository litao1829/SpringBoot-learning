package com.example.entity;

import com.google.protobuf.Internal;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User  {

//    @Serial
//    private static final long serialVersionUID =124542L;

    private Integer id;
    private String name;
    private String phone;
}
