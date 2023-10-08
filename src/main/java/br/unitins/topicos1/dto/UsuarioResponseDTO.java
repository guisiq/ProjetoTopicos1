package br.unitins.topicos1.dto;

import br.unitins.topicos1.model.Usuario;

public record UsuarioResponseDTO(
        Long id,
        String login,
        String senha) {
    public static UsuarioResponseDTO valueOf(Usuario usuario) {
        return new UsuarioResponseDTO(
                usuario.getId(),
                usuario.getLogin(),
                usuario.getSenha());
    }
}