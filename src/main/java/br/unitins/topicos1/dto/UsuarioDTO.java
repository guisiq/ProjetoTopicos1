package br.unitins.topicos1.dto;


import jakarta.validation.constraints.NotBlank;

public record UsuarioDTO(
        @NotBlank(message = "O campo nome não pode ser nulo.")
        String login,
        String senha,
        Integer idPerfil
) {

        // @Override
        // public String toString() {
        //         return "{\"login\":\"" + login + "\",\"senha\":\"" + senha + "\",\"idPerfil\":" + idPerfil + "}";
        // }
        

}