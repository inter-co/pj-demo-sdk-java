package inter.sdk.demo.pix.cob;

import inter.InterSdk;
import inter.sdk.demo.App;
import inter.sdk.exemplos.pix.cob.RevisarCobrancaImediata;
import inter.utils.HttpUtils;

public class RevisarCobrancaImediataDemo {

    public void execute(InterSdk interSdk) {
        try {
            interSdk.setDebug(true);
            interSdk.listaAvisos().forEach(System.out::println);

            String txId = App.getString("txId");

            String cpf = App.getString("cpf");
            String nome = App.getTextoCompleto("nome");
            String valor = App.getString("valor(99.99)");
            String chave = App.getString("chave");
            Integer expiracao = 86400;
            System.out.println("Aguarde...");
            new RevisarCobrancaImediata().exemplo(interSdk, txId, cpf, nome, valor, chave, expiracao);
            System.out.println("PATCH Url: " + HttpUtils.getLastUrl());
            System.out.println("Requisição:");
            System.out.println(HttpUtils.getLastRequest());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
