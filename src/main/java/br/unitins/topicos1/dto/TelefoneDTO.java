package br.unitins.topicos1.dto;

import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class TelefoneDTO {

    @Size(min = 2, max = 2, message = "O Codigo de Area é sem o 0")
    private String codigoArea;
    @Pattern(regexp = "\\d{5}\\-\\d{4}$", message = "O número deve estar formulado: 9****-****")
    private String numero;

    public String getCodigoArea() {
        return codigoArea;
    }

    public String getNumero() {
        return numero;
    }

    public TelefoneDTO(String codigoArea, String numero) {
        this.codigoArea = codigoArea;
        this.numero = numero;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((codigoArea == null) ? 0 : codigoArea.hashCode());
        result = prime * result + ((numero == null) ? 0 : numero.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        TelefoneDTO other = (TelefoneDTO) obj;
        if (codigoArea == null) {
            if (other.codigoArea != null)
                return false;
        } else if (!codigoArea.equals(other.codigoArea))
            return false;
        if (numero == null) {
            if (other.numero != null)
                return false;
        } else if (!numero.equals(other.numero))
            return false;
        return true;
    }

}