/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ws;

import com.google.gson.Gson;
import domain.Categoria;
import domain.Usuario;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import service.CategoriaService;
import service.UsuarioService;


/**
 * REST Web Service
 *
 * @author Manfred
 */
@Path("usuario")
public class UsuarioWS {

    private List<Usuario> usuarios;
    private UsuarioService usuarioService;
    
    
    @Context
    private UriInfo context;

    /**
     * Creates a new instance of UsuarioWS
     */
    public UsuarioWS() {
        usuarios = new ArrayList<>();
        usuarioService = new UsuarioService();
    }

    /**
     * Retrieves representation of an instance of ws.UsuarioWS
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getJson() {
        return "Xé Economia Compartilhada";
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("get")
    public String getUsuarios() {
        
        
        
        Gson g = new Gson();
        
        return g.toJson("eu posso");
    } 
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("criarconta")
    public String criarConta() {
        	
	UsuarioService service = new UsuarioService();
		
	service.criarConta("Beto", "9f8r");
	
        
        return "Conta foi criado";
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("categorias")
    public String visualizarCategorias () {
        CategoriaService cs = new CategoriaService();   
        List<Categoria> categorias = cs.buscarCategorias();
        
        Gson g = new Gson();
        
        return g.toJson(categorias);
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("logar/{nome}/{senha}")
    public String logar(@PathParam("nome") String nome, @PathParam("senha") String senha) {
        usuarioService.logar(nome, senha);
        
        Gson g = new Gson();
        
        return g.toJson(usuarioService.getUsuario());
    }
    
    /**
     * PUT method for updating or creating an instance of UsuarioWS
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(String content) {
    }
}
