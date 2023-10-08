package br.unitins.topicos1.dto;

public class UsuarioDTO {

        private String login;
        private String senha;

        public UsuarioDTO(String login, String senha) {
                this.login = login;
                this.senha = senha;
        }

        public String getLogin() {
                return login;
        }

        public String getSenha() {
                return senha;
        }

        @Override
        public int hashCode() {
                final int prime = 31;
                int result = 1;
                result = prime * result + ((login == null) ? 0 : login.hashCode());
                result = prime * result + ((senha == null) ? 0 : senha.hashCode());
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
                UsuarioDTO other = (UsuarioDTO) obj;
                if (login == null) {
                        if (other.login != null)
                                return false;
                } else if (!login.equals(other.login))
                        return false;
                if (senha == null) {
                        if (other.senha != null)
                                return false;
                } else if (!senha.equals(other.senha))
                        return false;
                return true;
        }

}
