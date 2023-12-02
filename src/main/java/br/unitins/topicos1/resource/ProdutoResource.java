package br.unitins.topicos1.resource;

import java.io.IOException;

import org.eclipse.microprofile.jwt.JsonWebToken;
import org.jboss.logging.Logger;
import org.jboss.resteasy.annotations.providers.multipart.MultipartForm;

import br.unitins.topicos1.dto.ProdutoDTO;
import br.unitins.topicos1.dto.ProdutoResponseDTO;
import br.unitins.topicos1.dto.ProdutoResponseDTO;
import br.unitins.topicos1.form.ProdutoImagemForm;
import br.unitins.topicos1.model.Produto;
import br.unitins.topicos1.service.ProdutoFileService;
import br.unitins.topicos1.application.Error;
import br.unitins.topicos1.service.ProdutoService;
import jakarta.annotation.security.RolesAllowed;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.PATCH;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.ResponseBuilder;
import jakarta.ws.rs.core.Response.Status;


@Path("/produto")    
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ProdutoResource {

    @Inject
    ProdutoService ProdutoService;

    @Inject
    ProdutoService produtoService;
    

       @Inject
    JsonWebToken jwt;

    @Inject
    ProdutoFileService fileService;

    private static final Logger LOG = Logger.getLogger(AuthResource.class);

    @POST
    @RolesAllowed({"Admin"})
    public Response insert(@Valid ProdutoDTO dto){
        LOG.infof("Iniciando o processo de inserçao do produto %s", dto.getNome());
        return Response.status(Status.CREATED).entity(ProdutoService.insert(dto)).build();
    }

    @PUT
    @RolesAllowed({"Admin"})
    @Transactional
    @Path("/{id}")
    public Response update (ProdutoDTO dto, @PathParam("id") Long id) {
        LOG.infof("Iniciando o processo de update do produto %s", dto.getNome());
        ProdutoService.update(dto, id);
        return Response.status(Status.NO_CONTENT).build();
    }

    @DELETE
    @RolesAllowed({"Admin"})
    @Transactional
    @Path("/{id}")
    public Response delete(@PathParam("id") Long id){
        LOG.infof("Iniciando o processo de delete do produto %s");
        ProdutoService.delete(id);
        return Response.status(Status.NO_CONTENT).build();
    }

    @GET
    @RolesAllowed({"User", "Admin"})
    public Response findAll(){
        LOG.infof("buscando todos os produtos");
        return Response.ok(ProdutoService.findByAll()).build();
    }

    @GET
    @RolesAllowed({"User", "Admin"})
    @Path("/{id}")
    public Response findById(@PathParam("id") Long id){
        LOG.infof("buscando todos o prduto por id");
        return Response.ok(ProdutoService.findById(id)).build();
    }

    @GET
    @RolesAllowed({"User", "Admin"})
    @Path("/search/nome/{nome}")
    public Response findByNome(@PathParam("nome") String nome){
        LOG.infof("buscando o produto pelo nome");
        return Response.ok(ProdutoService.findByNome(nome)).build();
    }

        @GET
        @RolesAllowed({"User", "Admin"})
    @Path("/search/estoque/{etoque}")
    public Response findByEstoque(@PathParam("estoque") Integer estoque){
        LOG.infof("buscando o produto pelo estoque");
        return Response.ok(ProdutoService.findByEstoque(estoque)).build();
    }

        @PATCH
    @Path("/upload/imagem")
    @RolesAllowed({ "User", "Admin" })
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    public Response salvarImagem(@MultipartForm ProdutoImagemForm form){
        String nomeImagem;
        try {
            nomeImagem = fileService.salvar(form.getNomeImagem(), form.getImagem());
        } catch (IOException e) {
            e.printStackTrace();
            Error error = new Error("409", e.getMessage());
            return Response.status(Status.CONFLICT).entity(error).build();
        }

        String login = jwt.getSubject();
        ProdutoResponseDTO produtoDTO = produtoService.findById();
        produtoDTO = produtoService.updateNomeImagem(produtoDTO.id(), nomeImagem);

        return Response.ok(produtoDTO).build();

    }

    @GET
    @Path("/download/imagem/{nomeImagem}")
    @RolesAllowed({ "User", "Admin" })
    @Produces(MediaType.APPLICATION_OCTET_STREAM)
    public Response download(@PathParam("nomeImagem") String nomeImagem) {
        ResponseBuilder response = Response.ok(fileService.obter(nomeImagem));
        response.header("Content-Disposition", "attachment;filename="+nomeImagem);
        return response.build();
    }

    
}

