package inter.sdk.demo.pix.pix;

import inter.InterSdk;
import inter.sdk.demo.App;
import inter.sdk.exemplos.pix.pix.ConsultarDevolucao;
import inter.utils.HttpUtils;

public class ConsultarDevolucaoDemo {
    public void execute(InterSdk interSdk) {
        try {
            interSdk.setDebug(true);
            interSdk.listaAvisos().forEach(System.out::println);

            String e2eId = App.getString("e2eId");
            String id = App.getString("id");

            System.out.println("Aguarde...");
            new ConsultarDevolucao().exemplo(interSdk, e2eId, id);

            System.out.println("GET Url: " + HttpUtils.getLastUrl());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
