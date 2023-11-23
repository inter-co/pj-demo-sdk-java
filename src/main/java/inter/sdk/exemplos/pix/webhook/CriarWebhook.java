package inter.sdk.exemplos.pix.webhook;

import inter.InterSdk;
import inter.exceptions.SdkException;

public class CriarWebhook {
    public void exemplo(InterSdk interSdk, String chave, String webhookUrl) {
        try {
            interSdk.pix().criarWebhook(webhookUrl, chave);
            System.out.println("webhook criado com sucesso");
        } catch (SdkException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
