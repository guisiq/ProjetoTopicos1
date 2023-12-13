package br.unitins.topicos1.resource;

import java.io.IOException;

import org.eclipse.microprofile.jwt.JsonWebToken;
// import org.jboss.resteasy.annotations.providers.multipart.MultipartForm;

import br.unitins.topicos1.dto.UsuarioResponseDTO;
import br.unitins.topicos1.service.UsuarioService;
import jakarta.annotation.security.RolesAllowed;
import jakarta.inject.Inject;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.PATCH;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.ResponseBuilder;
import jakarta.ws.rs.core.Response.Status;

@Path("/usuariologado")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class UsuarioLogadoResource {

    @Inject
    JsonWebToken jwt;

    @Inject
    UsuarioService usuarioService;

    @GET
    @RolesAllowed({ "User", "Admin" })
    public Response getUsuario() {

        // Obtendo o login pelo token jwt
        String login = jwt.getSubject();

        return Response.ok(usuarioService.findByLogin(login)).build();
    }

    // @PATCH
    // @Patch("/download/imagem")
    // @RolesAllowed({ "User", "Admin" })
    // @Consumes(MediaType.MULTIPART_FORM_DATA)
    // public Response salvarImagem(@MultipartForm UsuarioImagemForm form) {

    //     String nomeImagem;
    //     try{
    //         nomeImagem = fileService.salvar(form.getNomeImagem(), form.getImagem());
    //     } catch (IOException e){
    //         e.printStackTrace();
    //         Error error = new Error("409", e.getMessage());
    //         return Response.status(Status.CONFLICT).entity(error).build();
    //     }


    //     String login = jwt.getSubject();
    //     UsuarioResponseDTO usuarioDTO = usuarioService.findByLogin(login);
    //     usuarioDTO = usuarioService.updateNomeImagem(usuarioDTO.id(), nomeImagem);

    //     return Response.ok(usuarioDTO).build();
    // }


    // @GET
    // @Path("/download/imagem")
    // @RolesAllowed({"User","Admin"})
    // @Produces(MediaType.APPLICATION_OCTET_STREAM)
    // public Response download(@PathParam("nomeImagem")String nomeImagem){
    //         ResponseBuilder response = Response.ok(fileService.obter(nomeImagem));
    //         response.header("Content-Disposition", "attachment;filename="+nomeImagem);
    //         return response.build();
    // }



}