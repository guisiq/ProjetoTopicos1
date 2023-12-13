package br.unitins.topicos1;

import com.fasterxml.jackson.databind.ObjectMapper;

import static io.restassured.RestAssured.given;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.CoreMatchers.is;

import static org.junit.jupiter.api.Assertions.assertEquals;


import org.junit.jupiter.api.Test;


import io.restassured.http.ContentType;


import io.restassured.response.Response;

import br.unitins.topicos1.dto.UsuarioDTO;
import br.unitins.topicos1.dto.UsuarioResponseDTO;

import br.unitins.topicos1.service.UsuarioService;
import io.quarkus.test.junit.QuarkusTest;
import jakarta.inject.Inject;


@QuarkusTest
public class UsuarioResourceTest {

        @Inject
        UsuarioService usuarioService;

        ObjectMapper objectMapper = new ObjectMapper();

        @Test
        public void testInsert() {
                UsuarioDTO usuarioDTO = new UsuarioDTO("Teste", "1234", 1);
                given()
                                .contentType(ContentType.JSON)
                                .body(usuarioDTO)
                                .when().post("/usuarios")
                                .then()
                                .statusCode(201)
                                .body(
                                                "login", is("Teste"),
                                                "senha",
                                                is("O2JdqlPMBBKPaus+zYDOx/D6Ol9IZk9UFD95DcsTQLBD4euH4P9Sh1OrL4c1l4vLPkYjGgxrMFFUy09ouL7vDA=="));
                ;

        }

        @Test
        public void testUpdate() {
                // Crie um novo usuário para atualização
                UsuarioDTO usuarioDTO = new UsuarioDTO("Teste", "1234", 2);

                UsuarioResponseDTO usuarioTest = usuarioService.insert(usuarioDTO);
                Long id = usuarioTest.id();

                // Crie um novo DTO para a atualização do usuário
                UsuarioDTO dtoUpdate = new UsuarioDTO(
                                "testeNovo",
                                "555",
                                2);

                // Faça a requisição PUT para atualizar o usuário
                given()
                                .contentType(ContentType.JSON)
                                .body(dtoUpdate)
                                .when().put("/usuarios/" + id)
                                .then()
                                .statusCode(204);

                UsuarioResponseDTO updatedUser = usuarioService.findById(id);
                assertEquals(dtoUpdate.login(), "testeNovo");
                assertEquals(dtoUpdate.senha(), "555");

        }

        @Test
        public void testDelete() {
                // Insira um registro de teste antes de deletar
                UsuarioDTO usuarioDTO = new UsuarioDTO("Teste", "1234", 1);

                Response insertResponse = given()
                                .contentType(ContentType.JSON)
                                .body(usuarioDTO)
                                .when()
                                .post("/usuarios");

                insertResponse.then()
                                .statusCode(201);

                Long id = insertResponse.jsonPath().getLong("id");

                // Agora teste o método de exclusão
                given()
                                .when()
                                .delete("/usuarios/" + id)
                                .then()
                                .statusCode(204);
        }

        @Test
        public void testFindAll() {

                UsuarioDTO usuarioDTO = new UsuarioDTO("Teste", "1234", 1);

                given()
                                .contentType(ContentType.JSON)
                                .body(usuarioDTO)
                                .when().post("/usuarios")
                                .then()
                                .statusCode(201);

                // Agora você pode testar o método findAll
                given()
                                .when().get("/usuarios")
                                .then()
                                .statusCode(200);

        }

        @Test
        public void testFindById() {
                // Insira um registro de teste para testar o findById
                UsuarioDTO usuarioDTO = new UsuarioDTO("Teste", "1234", 1);

                Response insertResponse = given()
                                .contentType(ContentType.JSON)
                                .body(usuarioDTO)
                                .when().post("/usuarios");

                insertResponse.then()
                                .statusCode(201);
                Long id = insertResponse.jsonPath().getLong("id");

                // Agora teste o método findById
                given()
                                .when()
                                .get("/usuarios/" + id)
                                .then()
                                .statusCode(200)
                                .body("id", equalTo(id.intValue()));
        }

}
