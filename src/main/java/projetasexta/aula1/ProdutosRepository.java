package projetasexta.aula1;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProdutosRepository extends JpaRepository <Produtos,Long>{

    List<Produtos> findByDescricao(String descricao);
    List<Produtos> findByNome(String nome);

}
