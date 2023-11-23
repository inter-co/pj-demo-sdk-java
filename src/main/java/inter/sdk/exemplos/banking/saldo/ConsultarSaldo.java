package inter.sdk.exemplos.banking.saldo;

import com.fasterxml.jackson.databind.ObjectMapper;
import inter.InterSdk;
import inter.banking.model.Saldo;
import inter.exceptions.SdkException;

public class ConsultarSaldo {
    public void exemplo(InterSdk interSdk) {
        try {
            Saldo saldo = interSdk.banking().consultarSaldo();
            System.out.println(new ObjectMapper().writerWithDefaultPrettyPrinter().writeValueAsString(saldo));
            System.out.printf("Saldo disponível: %.2f%n", saldo.getDisponivel());
        } catch (SdkException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
