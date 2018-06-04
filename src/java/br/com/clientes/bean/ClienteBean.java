package br.com.clientes.bean;
//import br.com.clientes.dao.ClienteDAO;
import br.com.clientes.entidade.Cliente;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean // gerencia a forma de interacao do xhtml com as classes
@SessionScoped // define o tempo que a sessao fica ativa na memoria
public class ClienteBean {
    
    private Cliente cliente = new Cliente();
    private List<Cliente> clientes = new ArrayList<>();
    
    public void adiciona (){
        clientes.add(cliente);
        // chamando o metodo salvar da classe ClienteDAO
        // new ClienteDAO().salvar(cliente);        
        cliente = new Cliente();
        
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(List<Cliente> clientes) {
        this.clientes = clientes;
    }
        
}