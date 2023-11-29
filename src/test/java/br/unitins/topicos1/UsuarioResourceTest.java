package br.unitins.topicos1;


import com.fasterxml.jackson.databind.ObjectMapper;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItem;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.parsing.Parser;
import static org.hamcrest.MatcherAssert.assertThat;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import br.unitins.topicos1.dto.UsuarioDTO;
import br.unitins.topicos1.dto.UsuarioResponseDTO;
import br.unitins.topicos1.service.UsuarioService;
import io.quarkus.test.junit.QuarkusTest;
import jakarta.inject.Inject;

@QuarkusTest
public class UsuarioResourceTest {

    @Inject
    UsuarioService service;


    ObjectMapper objectMapper = new ObjectMapper();

    @Test
    public void testInsert() {
        UsuarioDTO usuarioDTO = new UsuarioDTO("Teste", "1234",1);
        given()
                .contentType(ContentType.JSON)
                .body(usuarioDTO)
                .when().post("/usuarios")
                .then()
                .statusCode(201)
                ;
                     
    }

    @Test
    public void testUpdate() {
        // Crie um novo usuário para atualização
        UsuarioDTO usuarioDTO = new UsuarioDTO("Teste", "1234",1);
        Response insertResponse = given()
                .contentType(ContentType.JSON)
                .body(usuarioDTO)
                .when()
                .post("/usuarios");
        insertResponse.then()
                .statusCode(201);

        // Obtenha o ID do usuário criado
        Long id = insertResponse.jsonPath().getLong("id");

        // Crie um novo DTO para a atualização do usuário
        UsuarioDTO dtoUpdate = new UsuarioDTO("teste", "555",2);

        // Faça a requisição PUT para atualizar o usuário
        given()
                .contentType(ContentType.JSON)
                .body(dtoUpdate)
                .when().put("/usuarios/" + id)
                .then()
                .statusCode(204);

        // Obtenha o objeto UsuarioResponseDTO da resposta
        Response updatedResponse = given()
                .when()
                .get("/usuarios/" + id);

        // Verifique se o usuário foi atualizado corretamente
        assertEquals("teste", dtoUpdate.getLogin());
        assertEquals("555", dtoUpdate.getSenha());
        assertEquals("2", dtoUpdate.);
    }

    @Test
    public void testFindAll() {

        UsuarioDTO usuarioDTO = new UsuarioDTO("Teste", "1234");

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
    public void testDelete() {
        // Insira um registro de teste antes de deletar
        UsuarioDTO usuarioDTO = new UsuarioDTO("Teste", "1234");

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

}
