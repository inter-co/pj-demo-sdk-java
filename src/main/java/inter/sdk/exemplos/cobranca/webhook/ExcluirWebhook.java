package inter.sdk.exemplos.cobranca.webhook;

import inter.InterSdk;
import inter.exceptions.SdkException;

public class ExcluirWebhook {
    public void exemplo(InterSdk interSdk) {
        try {
            interSdk.cobranca().excluirWebhook();
            System.out.println("webhook excluído com sucesso");
        } catch (SdkException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
