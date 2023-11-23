package inter.sdk.exemplos.cobranca.boletos;

import inter.InterSdk;
import inter.cobranca.model.enums.MotivoCancelamento;
import inter.exceptions.SdkException;

public class CancelarBoleto {
    public void exemplo(InterSdk interSdk, String nossoNumero, MotivoCancelamento motivoCancelamento) {
        try {
            interSdk.cobranca().cancelarBoleto(nossoNumero, motivoCancelamento);
            System.out.println("boleto cancelado com sucesso: " + nossoNumero);
        } catch (SdkException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
