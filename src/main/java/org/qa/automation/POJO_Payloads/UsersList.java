package org.qa.automation.POJO_Payloads;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class UsersList {

    private String username;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private String id;
}