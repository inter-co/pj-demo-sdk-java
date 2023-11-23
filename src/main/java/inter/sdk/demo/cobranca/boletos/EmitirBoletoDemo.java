package inter.sdk.demo.cobranca.boletos;

import inter.InterSdk;
import inter.cobranca.model.enums.TipoPessoa;
import inter.sdk.demo.App;
import inter.sdk.exemplos.cobranca.boletos.EmitirBoleto;
import inter.utils.HttpUtils;

import java.math.BigDecimal;

public class EmitirBoletoDemo {
    public void execute(InterSdk interSdk) {
        try {
            interSdk.setDebug(true);
            interSdk.listaAvisos().forEach(System.out::println);

            //Pela limitação do getString neste demo, as strings não poderão ter espaços em branco!
            System.out.println("Exemplo para pessoa física!");
            TipoPessoa tipoPessoa = TipoPessoa.FISICA;

            String seuNumero = App.getString("seuNumero");
            String dataVencimento = App.getString("dataVencimento(YYYY-MM-DD)");
            BigDecimal valor = App.getBigDecimal("valor(99.99)");

            System.out.println("Dados do pagador:");
            String cpfCnpj = App.getString("cpf");
            String nome = App.getTextoCompleto("nome");
            String endereco = App.getTextoCompleto("endereco");
            String cidade = App.getTextoCompleto("cidade");
            String uf = App.getString("uf");
            String cep = App.getString("cep");

            System.out.println("Aguarde...");
            new EmitirBoleto().exemplo(interSdk, tipoPessoa, cpfCnpj, seuNumero, dataVencimento, valor, nome, endereco, cidade, uf, cep);

            System.out.println("POST Url: " + HttpUtils.getLastUrl());
            System.out.println("Requisição:");
            System.out.println(HttpUtils.getLastRequest());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
