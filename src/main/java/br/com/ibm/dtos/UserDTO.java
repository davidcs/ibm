package br.com.ibm.dtos;
import java.time.LocalDate;
import br.com.ibm.models.UserType;

public record UserDTO (
    Long id,
    String fullName,
    String email,
    String phone,
    LocalDate birthDate,
    UserType userType
    )
    {
}
