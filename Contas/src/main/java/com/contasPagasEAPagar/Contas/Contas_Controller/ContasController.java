package com.contasPagasEAPagar.Contas.Contas_Controller;

import com.contasPagasEAPagar.Contas.Contas_Model.ContasModel;
import com.contasPagasEAPagar.Contas.Contas_Service.ContasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ContasController {

    @Autowired
    private ContasService contasService;

    @PostMapping(path = "/contas")
    @ResponseStatus
    public ContasModel cadastrarConta(@RequestBody ContasModel contasModel){
        return contasService.adicionarConta(contasModel);
    }
}
