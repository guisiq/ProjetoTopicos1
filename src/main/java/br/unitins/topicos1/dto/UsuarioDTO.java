package br.unitins.topicos1.dto;


import br.unitins.topicos1.model.Perfil;
import jakarta.validation.constraints.NotBlank;

public record UsuarioDTO(
        @NotBlank(message = "O campo nome não pode ser nulo.")
        String login,
        String senha,
        Integer idPerfil
) {        

}