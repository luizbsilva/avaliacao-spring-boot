package br.com.tokiomarine.seguradora.avaliacao.controller;

import br.com.tokiomarine.seguradora.avaliacao.entidade.Estudante;
import br.com.tokiomarine.seguradora.avaliacao.service.EstudandeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/estudantes/")
public class EstudanteController {

    @Autowired
    private EstudandeService estudandeService;


    @GetMapping("criar")
    public String iniciarCastrado(Estudante estudante) {
        return "cadastrar-estudante";
    }

    @GetMapping("listar")
    public String listarEstudantes(Model model) {
        model.addAttribute("estudantes", estudandeService.buscarEstudantes());
        return "index";
    }

    @PostMapping("add")
    public String adicionarEstudante(@Valid Estudante estudante, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "cadastrar-estudante";
        }

        estudandeService.cadastrarEstudante(estudante);

        return "redirect:listar";
    }

    @GetMapping("editar/{id}")
    public String exibirEdicaoEstudante(@PathVariable("id") long id, Model model) {
        Estudante estudante = estudandeService.buscarEstudante(id);
        model.addAttribute("estudante", estudante);
        return "atualizar-estudante";
    }

    @PostMapping("atualizar/{id}")
    public String atualizarEstudante(@PathVariable("id") long id, @Valid Estudante estudante, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "atualizar-estudante";
        }

        estudandeService.atualizarEstudante(estudante);

        model.addAttribute("estudantes", estudandeService.buscarEstudantes());
        return "index";
    }

    @GetMapping("apagar/{id}")
    public String apagarEstudante(@PathVariable("id") long id, Model model) {
        estudandeService.apagarEstudante(id);
        model.addAttribute("estudantes", estudandeService.buscarEstudantes());
        return "index";
    }
}
