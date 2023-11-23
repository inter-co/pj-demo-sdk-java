package inter.sdk.exemplos.pix.webhook;

import inter.InterSdk;
import inter.exceptions.SdkException;

public class ExcluirWebhook {
    public void exemplo(InterSdk interSdk, String chave) {
        try {
            interSdk.pix().excluirWebhook(chave);
            System.out.println("webhook excluído com sucesso");
        } catch (SdkException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
