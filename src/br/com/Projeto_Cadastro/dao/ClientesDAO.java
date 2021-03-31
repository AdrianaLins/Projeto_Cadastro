package br.com.projetoVendas.dao;

import br.com.projeto.jdbc.ConnectionFactory;
import br.com.projetoVendas.model.Clientes;
import java.sql.Connection;
import javax.swing.JOptionPane;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author adria
 */
public class ClientesDAO { //Objetos que acessam dados

    /*
    Essa classe terão os métodos que irão fazer a interação
    com a tabela de cliente. Para cada tabela do banco de dados
    terá uma classe na DAO para ter mais organização do código.
     */
    private Connection con;

    public ClientesDAO() {
        this.con = new ConnectionFactory().getConnection(); //o atributo con vai receber uma nova conexão com o BD

    }

    //Método cadastrar cliente
    public void cadastrarCliente(Clientes obj) { //Recebe um Objeto da classe cliente

        try {

            //1º passo - criar o comando sql
            String sql = "insert into tb_clientes (nome, rg, cpf, email, telefone, celular, cep, endereco, numero, complemento, bairro, cidade, estado)"
                    + "values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

            //2º passo - conectar o banco de dados e organizar o comando sql
            //classe responsavel por tratar e executar os comandos sql
            java.sql.PreparedStatement stmt = con.prepareStatement(sql);

            stmt.setString(1, obj.getNome());
            stmt.setString(2, obj.getRg());
            stmt.setString(3, obj.getCpf());
            stmt.setString(4, obj.getEmail());
            stmt.setString(5, obj.getTelefone());
            stmt.setString(6, obj.getCelular());
            stmt.setString(7, obj.getCep());
            stmt.setString(8, obj.getEndereco());
            stmt.setString(9, obj.getNumero());
            stmt.setString(10, obj.getComplemento());
            stmt.setString(11, obj.getBairro());
            stmt.setString(12, obj.getCidade());
            stmt.setString(13, obj.getUf());

            //3º passo - executar o comando sql
            stmt.execute();
            stmt.close();

            JOptionPane.showMessageDialog(null, "Cadastrado com sucesso!");

        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro: " + erro);
        }

    }

    //Método alterar cliente
    public void alterarCliente(Clientes obj) {

        try {

            //1º passo - criar o comando sql
            String sql = "update tb_clientes set nome=?, rg=?, cpf=?, email=?, telefone=?,"
                    + "celular=?, cep=?, endereco=?, numero=?, complemento=?, bairro=?, cidade=?, estado=? where id=?";

            //2º passo - conectar o banco de dados e organizar o comando sql
            //classe responsavel por tratar e executar os comandos sql
            java.sql.PreparedStatement stmt = con.prepareStatement(sql);

            stmt.setString(1, obj.getNome());
            stmt.setString(2, obj.getRg());
            stmt.setString(3, obj.getCpf());
            stmt.setString(4, obj.getEmail());
            stmt.setString(5, obj.getTelefone());
            stmt.setString(6, obj.getCelular());
            stmt.setString(7, obj.getCep());
            stmt.setString(8, obj.getEndereco());
            stmt.setString(9, obj.getNumero());
            stmt.setString(10, obj.getComplemento());
            stmt.setString(11, obj.getBairro());
            stmt.setString(12, obj.getCidade());
            stmt.setString(13, obj.getUf());
            stmt.setInt(14, obj.getId());

            //3º passo - executar o comando sql
            stmt.execute();
            stmt.close();

            JOptionPane.showMessageDialog(null, "Alterado com sucesso!");

        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro: " + erro);
        }

    }

    //Método excluir cliente
    public void excluirCliente(Clientes obj) {

        try {

            //1º passo - criar o comando sql
            String sql = "delete from tb_clientes where id = ? ";

            //2º passo - conectar o banco de dados e organizar o comando sql
            //classe responsavel por tratar e executar os comandos sql
            java.sql.PreparedStatement stmt = con.prepareStatement(sql);

            stmt.setInt(1, obj.getId());

            //3º passo - executar o comando sql
            stmt.execute();
            stmt.close();

            JOptionPane.showMessageDialog(null, "Excluído com sucesso!");

        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro: " + erro);
        }

    }

    //Método listar todos os clientes
    public List<Clientes> listarClientes() {

        try {

            //1º passo - criar a lista
            List<Clientes> lista = new ArrayList<>();

            //2º passo - crirar o comando sql, organizar e executar.
            String sql = "select * from tb_clientes";
            java.sql.PreparedStatement stmt = con.prepareStatement(sql); //executar o comando, chamando a execução
            java.sql.ResultSet rs = stmt.executeQuery(); //Todo comando select, ele executa e armazena o resultado em outro objeto.Essa é a classe

            while (rs.next()) {
                Clientes obj = new Clientes();
                obj.setId(rs.getInt("id"));
                obj.setNome(rs.getString("nome"));
                obj.setRg(rs.getString("rg"));
                obj.setCpf(rs.getString("cpf"));
                obj.setEmail(rs.getString("email"));
                obj.setTelefone(rs.getString("telefone"));
                obj.setCpf(rs.getString("cpf"));
                obj.setCelular(rs.getString("celular"));
                obj.setCep(rs.getString("cep"));
                obj.setEndereco(rs.getString("endereco"));
                obj.setNumero(rs.getString("numero"));
                obj.setComplemento(rs.getString("complemento"));
                obj.setBairro(rs.getString("bairro"));
                obj.setCidade(rs.getString("cidade"));
                obj.setUf(rs.getString("estado"));

                lista.add(obj);

            }

            return lista;

        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro: " + erro);
            return null;
        }

    }

    //Método consulta por nome
    public Clientes consultaPorNome(String nome) {
        try {

            //2 passo - criar o SQL, organizar e executar
            String sql = "select * from tb_clientes where nome=?";
            java.sql.PreparedStatement stmt = con.prepareStatement(sql); //executar o comando, chamando a execução
            stmt.setString(1, nome);
           

            java.sql.ResultSet rs = stmt.executeQuery();
            Clientes obj = new Clientes();
            if (rs.next()) {

                obj.setId(rs.getInt("id"));
                obj.setNome(rs.getString("nome"));
                obj.setRg(rs.getString("rg"));
                obj.setCpf(rs.getString("cpf"));
                obj.setEmail(rs.getString("email"));
                obj.setTelefone(rs.getString("telefone"));
                obj.setCpf(rs.getString("cpf"));
                obj.setCelular(rs.getString("celular"));
                obj.setCep(rs.getString("cep"));
                obj.setEndereco(rs.getString("endereco"));
                obj.setNumero(rs.getString("numero"));
                obj.setComplemento(rs.getString("complemento"));
                obj.setBairro(rs.getString("bairro"));
                obj.setCidade(rs.getString("cidade"));
                obj.setUf(rs.getString("estado"));

            }
            return obj;
            
           

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Cliente não encontrado!");
            return null;
        }

    }

    //Método buscar cliente por nome - retorna uma lista
    public List<Clientes> buscaClientePorNome(String nome) {

        try {

            //1º passo - criar a lista
            List<Clientes> lista = new ArrayList<>();

            //2º passo - crirar o comando sql, organizar e executar.
            String sql = "select * from tb_clientes where nome like ?";
            java.sql.PreparedStatement stmt = con.prepareStatement(sql); //executar o comando, chamando a execução
            stmt.setString(1, nome);
            java.sql.ResultSet rs = stmt.executeQuery(); //Todo comando select, ele executa e armazena o resultado em outro objeto.Essa é a classe

            while (rs.next()) {
                Clientes obj = new Clientes();
                obj.setId(rs.getInt("id"));
                obj.setNome(rs.getString("nome"));
                obj.setRg(rs.getString("rg"));
                obj.setCpf(rs.getString("cpf"));
                obj.setEmail(rs.getString("email"));
                obj.setTelefone(rs.getString("telefone"));
                obj.setCpf(rs.getString("cpf"));
                obj.setCelular(rs.getString("celular"));
                obj.setCep(rs.getString("cep"));
                obj.setEndereco(rs.getString("endereco"));
                obj.setNumero(rs.getString("numero"));
                obj.setComplemento(rs.getString("complemento"));
                obj.setBairro(rs.getString("bairro"));
                obj.setCidade(rs.getString("cidade"));
                obj.setUf(rs.getString("estado"));

                lista.add(obj);

            }

            return lista;

        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro: " + erro);
            return null;
        }

    }

}
