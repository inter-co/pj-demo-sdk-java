package inter.sdk.demo.banking.webhook;

import inter.InterSdk;
import inter.sdk.demo.App;
import inter.sdk.exemplos.banking.webhook.CriarWebhook;
import inter.utils.HttpUtils;

public class CriarWebhookBankingDemo {

    public void execute(InterSdk interSdk) {
        try {
            interSdk.setDebug(true);
            interSdk.listaAvisos().forEach(System.out::println);

            String webhookUrl = App.getString("webhookUrl");

            System.out.println("Aguarde...");
            new CriarWebhook().exemplo(interSdk, webhookUrl);

            System.out.println("PUT Url: " + HttpUtils.getLastUrl());
            System.out.println("Requisição:");
            System.out.println(HttpUtils.getLastRequest());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

