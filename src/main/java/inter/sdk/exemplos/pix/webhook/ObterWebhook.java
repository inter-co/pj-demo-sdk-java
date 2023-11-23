package inter.sdk.exemplos.pix.webhook;

import com.fasterxml.jackson.databind.ObjectMapper;
import inter.InterSdk;
import inter.exceptions.SdkException;
import inter.model.Webhook;

public class ObterWebhook {
    public void exemplo(InterSdk interSdk, String chave) {
        try {
            Webhook webhook = interSdk.pix().obterWebhook(chave);
            System.out.println(new ObjectMapper().writerWithDefaultPrettyPrinter().writeValueAsString(webhook));
        } catch (SdkException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
