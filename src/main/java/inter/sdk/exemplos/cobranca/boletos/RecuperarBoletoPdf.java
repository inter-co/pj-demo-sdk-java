package inter.sdk.exemplos.cobranca.boletos;

import inter.InterSdk;
import inter.exceptions.SdkException;

public class RecuperarBoletoPdf {
    public void exemplo(InterSdk interSdk, String nossoNumero, String arquivo) {
        try {
            interSdk.cobranca().recuperarBoletoPdf(nossoNumero, arquivo);
            System.out.println("Arquivo gerado: " + arquivo);
        } catch (SdkException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
