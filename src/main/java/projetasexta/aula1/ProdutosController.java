package projetasexta.aula1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;

@Controller
public class ProdutosController {
    private ProdutosService produtosService;

    @Autowired
    public void setProdutosService(ProdutosService produtosService) {
        this.produtosService = produtosService;
    }

    @RequestMapping("/")
    public String PaginaInicial(Model model, HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession();
        if (!session.isNew()) {

            Date created = new Date(session.getCreationTime());
            Date accessed = new Date(session.getLastAccessedTime());

            response.getWriter().println("Ultimo Acesso:" +created);
            response.getWriter().println("Atual acesso:"+ accessed);
        }

        List<Produtos> produtosList = produtosService.findAll();
        model.addAttribute("produtosList", produtosList);
        return "index";
    }

    @RequestMapping("/cadastrar")
    public String cadastroProduto(Model model){
        var produtos = new Produtos();
        model.addAttribute("produtos", produtos);
        return "cadastrar";
    }

    @RequestMapping(value = "/salvar", method = RequestMethod.POST)
    public String salvarProduto( @Valid Produtos produtos, Errors errors,Model model, HttpServletResponse response){

        if (errors.hasErrors()){
            return "cadastrar";

        }else{
            produtosService.adcionarProduto(produtos);
            return "redirect:/";


        }

    }

    @RequestMapping("/editar/{id}")
    public ModelAndView editProdutos(@PathVariable(name = "id") Long id){
        var modelAndView = new ModelAndView("editar");
        var produtos = produtosService.get(id);
        modelAndView.addObject("produtos",produtos);
        return modelAndView;
    }

    @RequestMapping("/deletar/{id}")
    public String deletarProduto(@PathVariable(name = "id") Long id){
        produtosService.deletar(id);
        return "redirect:/";
    }






}
