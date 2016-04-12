package br.com.crud_jsf_hibernate.managedbean;

import br.com.crud_jsf_hibernate.dao.PessoaDao;
import br.com.crud_jsf_hibernate.entity.Pessoa;
import java.util.List;
import java.util.Objects;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author Rose
 */
@ManagedBean
@RequestScoped
public class PessoaMB { //controller

    private Pessoa pessoa = new Pessoa();
    private PessoaDao pessoaDao = new PessoaDao();
    private List<Pessoa> listaDePessoas;

    public PessoaMB() {
    }

    public String adicionarPessoa() {
        pessoaDao.add(pessoa);
        limpaCampos();
        return "index";
    }

    public String removerPessoa(Pessoa p) {
        this.pessoa = p;
        pessoaDao.remove(this.pessoa);
        limpaCampos();
        return "index";
    }

    public List listarPessoas() {
        listaDePessoas = pessoaDao.getList();
        return this.listaDePessoas;
    }

    public String carregarPessoas(Pessoa p) {
        pessoa = p;
        return "editar";

    }

    public String atualizarPessoas() {
        pessoaDao.update(pessoa);
        limpaCampos();
        return "index";
    }

    /**
     * @return the pessoa
     */
    public Pessoa getPessoa() {
        return pessoa;
    }

    /**
     * @param pessoa the pessoa to set
     */
    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public void limpaCampos() {
        pessoa.setNome(null);
        pessoa.setEmail(null);
        pessoa.setTelefone(null);

    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 73 * hash + Objects.hashCode(this.pessoa);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final PessoaMB other = (PessoaMB) obj;
        if (!Objects.equals(this.pessoa, other.pessoa)) {
            return false;
        }
        return true;
    }

}
