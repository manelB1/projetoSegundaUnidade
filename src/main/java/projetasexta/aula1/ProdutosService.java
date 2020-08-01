package projetasexta.aula1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutosService {


    private ProdutosRepository produtosRepository;

    @Autowired
    public void setProdutosRepository(ProdutosRepository produtosRepository) {
        this.produtosRepository = produtosRepository;
    }
    public List<Produtos> findAll(){
        return produtosRepository.findAll();

    }

    public void adcionarProduto(Produtos produtos){
        produtosRepository.save(produtos);
    }

    public Produtos get(Long id){
        return produtosRepository.getOne(id);
    }
    public void deletar(Long id){
        produtosRepository.deleteById(id);
    }
}
