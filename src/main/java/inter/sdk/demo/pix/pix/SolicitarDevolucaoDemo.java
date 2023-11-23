package inter.sdk.demo.pix.pix;

import inter.InterSdk;
import inter.pix.model.enums.NaturezaDevolucao;
import inter.sdk.demo.App;
import inter.sdk.exemplos.pix.pix.SolicitarDevolucao;
import inter.utils.HttpUtils;

public class SolicitarDevolucaoDemo {
    public void execute(InterSdk interSdk) {
        try {
            interSdk.setDebug(true);
            interSdk.listaAvisos().forEach(System.out::println);

            String e2eId = App.getString("e2eId");
            String id = App.getString("id");
            String valor = App.getString("valor(99.99)");
            String descricao = App.getTextoCompleto("descricao");
            NaturezaDevolucao naturezaDevolucao = NaturezaDevolucao.ORIGINAL;

            System.out.println("Aguarde...");
            new SolicitarDevolucao().exemplo(interSdk, e2eId, id, valor, naturezaDevolucao, descricao);

            System.out.println("PUT Url: " + HttpUtils.getLastUrl());
            System.out.println("Requisição:");
            System.out.println(HttpUtils.getLastRequest());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
