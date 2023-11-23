package inter.sdk.exemplos.cobranca.webhook;

import inter.InterSdk;
import inter.exceptions.SdkException;

public class CriarWebhook {
    public void exemplo(InterSdk interSdk, String webhookUrl) {
        try {
            interSdk.cobranca().criarWebhook(webhookUrl);
            System.out.println("webhook criado com sucesso");
        } catch (SdkException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
