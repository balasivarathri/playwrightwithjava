package POJO_Payloads;


import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class TokenGenerator {

    private String username;    // if needed
    private String accessToken; // add this field

}
