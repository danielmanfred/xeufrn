package service;

import java.util.ArrayList;
import java.util.List;

import dao.UsuarioDAO;
import domain.Categoria;
import domain.Usuario;

public class UsuarioService {

	private List<Usuario> usuarios;
	private Usuario usuario;
	private UsuarioDAO dao;

	public UsuarioService() {
		dao = new UsuarioDAO();
		usuarios = new ArrayList<>();
	}

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	public void criarConta(String nome, String senha) {
		dao.salvar(nome, senha);
		logar(nome, senha);
	}

	public void excluirConta(Integer id) {

	}

	public void alterarNome(Integer id, String nome) {

	}

	public Integer buscar(String nome, String senha) {

		return null;
	}

	public void logar(String nome, String senha) {

		usuario = dao.logar(nome, senha);
	}
        
        public void logar(String nome) {

		usuario = dao.logar(nome);
	}

	public void demandar(String nome, String descricao, Integer categoria) {
		ItemService is = new ItemService();
		Integer item;

		item = is.adicionarItem(nome, descricao, categoria);

		DemandaService ds = new DemandaService();

		ds.criarDemanda(usuario.getId(), item);
	}

	public void ofertarDemanda(Double valor, Integer demanda) {
		OfertaDemandadaService ods = new OfertaDemandadaService();
		
		ods.adicionarOferta(valor, usuario.getId(), demanda);
	}

	public void ofertar(String nome, String descricao, Integer categoria, Double valor) {
		ItemService is = new ItemService();
		Integer item;

		item = is.adicionarItem(nome, descricao, categoria);
		
		OfertaNaoDemandadaService onds = new OfertaNaoDemandadaService();
		
		onds.adicionarOferta(valor, usuario.getId(), item);
	}
	
	public void visualizarListaOfertas(Integer categoria) {
		OfertaNaoDemandadaService onds = new OfertaNaoDemandadaService();
		
		onds.listarOfertas(categoria);
	}
	
	public void selecionarDemanda() {
		
	}
	
	public void selecionarOfertaNaoDemandada(Integer oferta) {
		SelecaoOferta sond = new SelecaoOfertaNaoDemandada();
		
		sond.selecionarOferta(oferta);
	}
	
	public void selecionarOfertaDemandada(Integer oferta) {
		SelecaoOferta sod = new SelecaoOfertaDemandada();
		
		sod.selecionarOferta(oferta);
	}
	
	public void visualizarDemandasUsuario() {
		
	}
	
	public List<Usuario> listarUsuarios() {
		return dao.listar();
	}
        
        public void vizualizarCategorias() {
           CategoriaService cs = new CategoriaService();
           
           List<Categoria> categorias = cs.buscarCategorias();
           
           categorias.forEach((c) -> {
               System.out.println(c.getNome());
            });
        }
}
