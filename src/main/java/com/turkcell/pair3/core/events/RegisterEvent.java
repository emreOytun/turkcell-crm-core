package com.turkcell.pair3.core.events;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RegisterEvent {

    @NotBlank
    private String email;

    @NotBlank
    private String password;

}

