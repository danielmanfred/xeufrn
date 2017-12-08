package main;

import service.CategoriaService;
import service.UsuarioService;

public class main {

	public main() {
		
	}
	
	
	public static void main(String[] args) {
	
            UsuarioService usuario = new UsuarioService();
            CategoriaService categoria = new CategoriaService();
            
            //usuario.vizualizarCategorias();
            usuario.logar("John");
            
            System.out.println(usuario.getUsuario().getNome());
	}

}
