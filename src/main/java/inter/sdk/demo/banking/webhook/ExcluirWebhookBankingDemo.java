package inter.sdk.demo.banking.webhook;

import inter.InterSdk;
import inter.sdk.exemplos.banking.webhook.ExcluirWebhook;
import inter.utils.HttpUtils;

public class ExcluirWebhookBankingDemo {

    public void execute(InterSdk interSdk) {
        try {
            interSdk.setDebug(true);
            interSdk.listaAvisos().forEach(System.out::println);

            System.out.println("Aguarde...");
            new ExcluirWebhook().exemplo(interSdk);

            System.out.println("DELETE Url: " + HttpUtils.getLastUrl());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
