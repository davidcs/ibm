package br.com.ibm.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "users")
public class User {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "full_name")
    @NotBlank(message = "Nome completo é obrigatório")
    private String fullName;

    @Email(message = "Deve ser um e-mail válido")
    @Column(unique = true, name = "email")
    private String email;

    @Column(name = "phone")
    @Pattern(regexp = "\\+\\d{1,3} \\d{2} \\d{5}-\\d{4}", message = "O telefone deve estar no formato +55 11 99999-9999")
    private String phone;

    @Column(name = "birth_date")
    @Past(message = "A data de nascimento deve ser no passado")
    private LocalDate birthDate;

    @Enumerated(EnumType.STRING)
    @Column(name = "user_type")
    @NotNull(message = "O tipo do Usuário é obrigatório")
    private UserType userType;
}

