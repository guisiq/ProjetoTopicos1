package br.unitins.topicos1.dto;

import br.unitins.topicos1.model.Telefone;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public record TelefoneDTO(

        @Size(min = 2, max = 2, message = "O Codigo de Area é sem o 0") String codigoArea,
        @Pattern(regexp = "\\d{5}\\-\\d{4}$", message = "O número deve estar formulado: 9****-****") String numero) {
    public static TelefoneDTO valueOf(Telefone telefone) {
        return new TelefoneDTO(
                telefone.getCodigoArea(),
                telefone.getNumero());
    }
}
