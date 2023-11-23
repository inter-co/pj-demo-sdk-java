package inter.sdk.demo.pix.webhook;

import inter.InterSdk;
import inter.sdk.demo.App;
import inter.sdk.exemplos.pix.webhook.CriarWebhook;
import inter.utils.HttpUtils;

public class CriarWebhookPixDemo {
    public void execute(InterSdk interSdk) {
        try {
            interSdk.setDebug(true);
            interSdk.listaAvisos().forEach(System.out::println);

            String chave = App.getString("chave");
            String webhookUrl = App.getString("webhookUrl");

            System.out.println("Aguarde...");
            new CriarWebhook().exemplo(interSdk, chave, webhookUrl);

            System.out.println("PUT Url: " + HttpUtils.getLastUrl());
            System.out.println("Requisição:");
            System.out.println(HttpUtils.getLastRequest());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
