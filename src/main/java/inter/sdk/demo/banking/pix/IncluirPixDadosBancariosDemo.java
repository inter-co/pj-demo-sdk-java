package inter.sdk.demo.banking.pix;

import inter.InterSdk;
import inter.sdk.demo.App;
import inter.sdk.exemplos.banking.pix.IncluirPixDadosBancarios;
import inter.utils.HttpUtils;

import java.math.BigDecimal;

public class IncluirPixDadosBancariosDemo {
    public void execute(InterSdk interSdk) {
        try {
            interSdk.setDebug(true);
            interSdk.listaAvisos().forEach(System.out::println);

            String cpfCnpj = App.getString("cpfCnpj");
            String nome = App.getTextoCompleto("nome");
            String contaCorrente = App.getString("contaCorrente");
            String agencia = App.getString("agencia");
            BigDecimal valor = App.getBigDecimal("valor(99.99)");
            String codigoBanco = App.getString("codigoBanco");
            String nomeBanco = App.getTextoCompleto("nomeBanco");
            String ispb = App.getString("ispb");

            System.out.println("Aguarde...");
            new IncluirPixDadosBancarios().exemplo(interSdk, cpfCnpj, nome, contaCorrente, agencia, valor, codigoBanco, nomeBanco, ispb);

            System.out.println("POST Url: " + HttpUtils.getLastUrl());
            System.out.println("Requisição:");
            System.out.println(HttpUtils.getLastRequest());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
