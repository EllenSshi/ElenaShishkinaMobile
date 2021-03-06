package dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class NativeTestDataDto {
    private String email;
    private String username;
    private String password;
    private String expectedBudgetPageTitle;
}
