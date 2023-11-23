package inter.sdk.demo.pix.cobv;

import inter.InterSdk;
import inter.pix.model.Devedor;
import inter.sdk.demo.App;
import inter.sdk.exemplos.pix.cobv.RevisarCobrancaComVencimento;
import inter.utils.HttpUtils;

public class RevisarCobrancaComVencimentoDemo {

    public void execute(InterSdk interSdk) {
        try {
            interSdk.setDebug(true);
            interSdk.listaAvisos().forEach(System.out::println);

            String txId = App.getString("txId");

            String cpf = App.getString("cpf devedor");
            String nome = App.getTextoCompleto("nome devedor");
            String cidade = App.getTextoCompleto("cidade devedor");
            String logradouro = App.getTextoCompleto("logradouro devedor");
            String cep = App.getString("cep devedor");
            String email = App.getString("email devedor");
            String uf = App.getString("uf devedor");
            String valor = App.getString("valor(99.99)");
            String chave = App.getString("chave");
            String dataVencimento = App.getString("Data de vencimento (yyyy-MM-dd)");
            String validade = App.getString("Validade (dias)");

            Devedor devedor = Devedor.builder()
                    .cpf(cpf)
                    .nome(nome)
                    .cidade(cidade)
                    .logradouro(logradouro)
                    .cep(cep)
                    .uf(uf)
                    .email(email)
                    .build();

            System.out.println("Aguarde...");
            new RevisarCobrancaComVencimento().exemplo(interSdk, txId, cpf, nome, valor, chave, dataVencimento, validade, devedor);
            System.out.println("PATCH Url: " + HttpUtils.getLastUrl());
            System.out.println("Requisição:");
            System.out.println(HttpUtils.getLastRequest());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
