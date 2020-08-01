package projetasexta.aula1;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity

public class Produtos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    Long id;

    @Size(min = 3 , max= 10, message = "Tamanho fora dos padrões, voce e fraco")
    @NotBlank
    String nome;
    @NotBlank
    String descricao;
    Integer quantidade;
    Double preco;

    //@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)



}
