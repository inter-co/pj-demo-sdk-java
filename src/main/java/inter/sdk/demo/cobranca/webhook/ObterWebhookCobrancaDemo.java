package inter.sdk.demo.cobranca.webhook;

import inter.InterSdk;
import inter.sdk.exemplos.cobranca.webhook.ObterWebhook;
import inter.utils.HttpUtils;

public class ObterWebhookCobrancaDemo {
    public void execute(InterSdk interSdk) {
        try {
            interSdk.setDebug(true);
            interSdk.listaAvisos().forEach(System.out::println);

            System.out.println("Aguarde...");
            new ObterWebhook().exemplo(interSdk);

            System.out.println("GET Url: " + HttpUtils.getLastUrl());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
