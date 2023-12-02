
package br.unitins.topicos1.resource;


import org.jboss.logging.Logger;

import br.unitins.topicos1.dto.CartaoDTO;
import br.unitins.topicos1.dto.CartaoResponseDTO;
import br.unitins.topicos1.service.CartaoService;
import jakarta.annotation.security.RolesAllowed;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;

@Path("/cartao")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CartaoResource {

    @Inject
    CartaoService service;

    private static final Logger LOG = Logger.getLogger(AuthResource.class);

    @POST
    @RolesAllowed({"User"})
    public Response insert(@Valid CartaoDTO dto) {
        LOG.infof("Iniciando o processo de adicionar um cartao %s");
        CartaoResponseDTO retorno = service.insert(dto);
        return Response.status(201).entity(retorno).build();
    }

    @PUT
    @RolesAllowed({"User"})
    @Transactional
    @Path("/{id}")
    public Response update(CartaoDTO dto, @PathParam("id") Long id) {
        LOG.infof("Iniciando o processo de udadte do cartao %s");
        service.update(dto, id);
        return Response.status(Status.NO_CONTENT).build();
    }

    @DELETE
    @RolesAllowed({"User", "Admin"})
    @Transactional
    @Path("/{id}")
    public Response delete(@PathParam("id") Long id) {
        LOG.infof("Iniciando o processo de delete do cartao %s");
        service.delete(id);
        return Response.status(Status.NO_CONTENT).build();
    }

    @GET
    @RolesAllowed({"User", "Admin"})
    public Response findAll() {
        LOG.infof("buscando todos os cartoes");
        return Response.ok(service.findByAll()).build();
    }

    @GET
    @RolesAllowed({"User", "Admin"})
    @Path("/{id}")
    public Response findById(@PathParam("id") Long id) {
        LOG.infof("buscando os cartoes por id");
       return Response.ok(service.findById(id)).build();
    }
    
    @GET
    @RolesAllowed({"User", "Admin"})
    @Path("/search/nome/{nome}")
    public Response findByNome(@PathParam("nome") String nome) {
        LOG.infof("buscando os cartoes por nome");
        return Response.ok(service.findByNome(nome)).build();
    }
}