package br.com.crud_jsf_hibernate.dao;

import br.com.crud_jsf_hibernate.entity.Pessoa;
import br.com.crud_jsf_hibernate.util.HibernateUtil;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Rose
 */
public class PessoaDao{

    private Session sessao;
    private Transaction trans;
    private List<Pessoa> list;
   

    public void add(Pessoa p) {
        try {
            sessao = HibernateUtil.getSessionFactory().openSession();
            trans = sessao.beginTransaction();

            Pessoa pessoa = new Pessoa();

            pessoa.setNome(p.getNome());
            pessoa.setTelefone(p.getTelefone());
            pessoa.setEmail(p.getEmail());

            sessao.save(pessoa);
            trans.commit();

        } catch (Exception e) {
            e.printStackTrace();

        } finally {
            sessao.close();
        }
    }

    public void remove(Pessoa p) {
        try {
            sessao = HibernateUtil.getSessionFactory().openSession();
            trans = sessao.beginTransaction();

            sessao.delete(p);
            trans.commit();

        } catch (Exception e) {
            e.printStackTrace();

        } finally {
            sessao.close();
        }

    }

    public void update(Pessoa p) {
        try {
            sessao = HibernateUtil.getSessionFactory().openSession();
            trans = sessao.beginTransaction();

            sessao.update(p);
            trans.commit();

        } catch (Exception e) {
            e.printStackTrace();

        } finally {
            sessao.close();
        }

    }

    /**
     * @return the list
     */
    public List<Pessoa> getList() {
        sessao = HibernateUtil.getSessionFactory().openSession();
        trans = sessao.beginTransaction();
        Criteria cri = sessao.createCriteria(Pessoa.class);//classe ja compilada
        this.list = cri.list();

        return list;
    }

}
