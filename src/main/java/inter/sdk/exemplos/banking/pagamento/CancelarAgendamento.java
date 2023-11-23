package inter.sdk.exemplos.banking.pagamento;

import inter.InterSdk;
import inter.exceptions.SdkException;

public class CancelarAgendamento {

    public void exemplo(InterSdk interSdk, String codigoTransacao) {
        try {
            interSdk.banking().cancelarAgendamento(codigoTransacao);
            System.out.println("Cancelamento do agendamento efetuado");
        } catch (SdkException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
