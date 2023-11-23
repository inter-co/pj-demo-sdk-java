package inter.sdk.demo.pix.cob;

import inter.InterSdk;
import inter.sdk.demo.App;
import inter.sdk.exemplos.pix.cob.CriarCobrancaImediata;
import inter.utils.HttpUtils;

public class CriarCobrancaImediataTxIdDemo {

    public void execute(InterSdk interSdk) {
        try {
            interSdk.setDebug(true);
            interSdk.listaAvisos().forEach(System.out::println);

            String cpf = App.getString("cpf");
            String nome = App.getTextoCompleto("nome");
            String valor = App.getString("valor(99.99)");
            String chave = App.getString("chave");
            String txId = App.getString("txId");
            Integer expiracao = 86400;

            System.out.println("Aguarde...");
            new CriarCobrancaImediata().exemplo(interSdk, txId, cpf, nome, valor, chave, expiracao);
            System.out.println("PUT Url: " + HttpUtils.getLastUrl());
            System.out.println("Requisição:");
            System.out.println(HttpUtils.getLastRequest());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
