package inter.sdk.demo.cobranca.boletos;

import inter.InterSdk;
import inter.cobranca.model.enums.MotivoCancelamento;
import inter.sdk.demo.App;
import inter.sdk.exemplos.cobranca.boletos.CancelarBoleto;
import inter.utils.HttpUtils;

public class CancelarBoletoDemo {
    public void execute(InterSdk interSdk) {
        try {
            interSdk.setDebug(true);
            interSdk.listaAvisos().forEach(System.out::println);

            String nossoNumero = App.getString("nossoNumero");
            MotivoCancelamento motivoCancelamento = MotivoCancelamento.APEDIDODOCLIENTE;

            System.out.println("Aguarde...");
            new CancelarBoleto().exemplo(interSdk, nossoNumero, motivoCancelamento);

            System.out.println("POST Url: " + HttpUtils.getLastUrl());
            System.out.println("Requisição:");
            System.out.println(HttpUtils.getLastRequest());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
