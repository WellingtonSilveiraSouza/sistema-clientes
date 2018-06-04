package br.com.clientes.dao;

import br.com.clientes.entidade.Cliente;
import br.com.clientes.util.FabricaConexao;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ClienteDAO {
    // as linhas abaixo criam o metodo salvar
    
    public void salvar(Cliente cliente){
       
        try {
            Connection conexao = FabricaConexao.getConexao();
            // a instrucao esta incorreta
            PreparedStatement ps = conexao.prepareCall("INSERT INTO cliente (`cliNome`,`cliTelefone`,`cliEmail`,`cliCpf`,`cliRg`,`cliEndereco`,`cliNumero`,`cliCidade`,`cliEstado`,`cliBairro`,`cliDataNascimento`)VALUES(?,?,?,?,?,?,?,?,?,?,?)");
            // as  linhas abaixo definem os parametros para a instrucao INSERT criada acima                  
            ps.setString(1, cliente.getNome());
            ps.setString(2, cliente.getTelefone());            
            ps.setString(3, cliente.getCpf());
            ps.setString(4, cliente.getRg());
            ps.setString(5, cliente.getEndereco());            
            ps.setDate(6, new Date(cliente.getDataNascimento().getTime()));
            // a linha abaixo executa a instrucao criada acima
            ps.execute();
            // a linha abaixo fecha a conexao com o banco
            FabricaConexao.fecharConexao();
                    } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
