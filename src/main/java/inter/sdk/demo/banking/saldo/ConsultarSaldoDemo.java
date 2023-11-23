package inter.sdk.demo.banking.saldo;

import inter.InterSdk;
import inter.sdk.exemplos.banking.saldo.ConsultarSaldo;
import inter.utils.HttpUtils;

public class ConsultarSaldoDemo {
    public void execute(InterSdk interSdk) {
        try {
            interSdk.setDebug(true);
            interSdk.listaAvisos().forEach(System.out::println);

            System.out.println("Aguarde...");
            new ConsultarSaldo().exemplo(interSdk);

            System.out.println("GET Url: " + HttpUtils.getLastUrl());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
