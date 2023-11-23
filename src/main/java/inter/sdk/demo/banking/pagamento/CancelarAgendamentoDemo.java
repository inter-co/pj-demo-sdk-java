package inter.sdk.demo.banking.pagamento;

import inter.InterSdk;
import inter.sdk.demo.App;
import inter.sdk.exemplos.banking.pagamento.CancelarAgendamento;
import inter.utils.HttpUtils;

public class CancelarAgendamentoDemo {

    public void execute(InterSdk interSdk) {
        try {
            interSdk.setDebug(true);
            interSdk.listaAvisos().forEach(System.out::println);

            String codigoTransacao = App.getString("codigoTransacao");

            System.out.println("Aguarde...");
            new CancelarAgendamento().exemplo(interSdk, codigoTransacao);

            System.out.println("GET Url: " + HttpUtils.getLastUrl());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
