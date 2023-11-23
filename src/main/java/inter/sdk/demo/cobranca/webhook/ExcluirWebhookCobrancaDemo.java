package inter.sdk.demo.cobranca.webhook;

import inter.InterSdk;
import inter.sdk.exemplos.cobranca.webhook.ExcluirWebhook;
import inter.utils.HttpUtils;

public class ExcluirWebhookCobrancaDemo {
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
