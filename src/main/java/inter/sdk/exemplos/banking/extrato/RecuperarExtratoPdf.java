package inter.sdk.exemplos.banking.extrato;

import inter.InterSdk;
import inter.exceptions.SdkException;

public class RecuperarExtratoPdf {
    public void exemplo(InterSdk interSdk, String dataInicial, String dataFinal, String arquivo) {
        try {
            interSdk.banking().recuperarExtratoPdf(dataInicial, dataFinal, arquivo);
            System.out.println("Arquivo gerado: " + arquivo);
        } catch (SdkException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
