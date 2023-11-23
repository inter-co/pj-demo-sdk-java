package inter.sdk.demo.pix.webhook;

import inter.InterSdk;
import inter.sdk.demo.App;
import inter.sdk.exemplos.pix.webhook.ExcluirWebhook;
import inter.utils.HttpUtils;

public class ExcluirWebhookPixDemo {
    public void execute(InterSdk interSdk) {
        try {
            interSdk.setDebug(true);
            interSdk.listaAvisos().forEach(System.out::println);

            String chave = App.getString("chave");

            System.out.println("Aguarde...");
            new ExcluirWebhook().exemplo(interSdk, chave);

            System.out.println("DELETE Url: " + HttpUtils.getLastUrl());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
