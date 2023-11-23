package inter.sdk.demo.cobranca.boletos;

import inter.InterSdk;
import inter.sdk.demo.App;
import inter.sdk.exemplos.cobranca.boletos.RecuperarBoletoDetalhado;
import inter.utils.HttpUtils;

public class RecuperarBoletoDetalhadoDemo {
    public void execute(InterSdk interSdk) {
        try {
            interSdk.setDebug(true);
            interSdk.listaAvisos().forEach(System.out::println);

            String nossoNumero = App.getString("nossoNumero");

            System.out.println("Aguarde...");
            new RecuperarBoletoDetalhado().exemplo(interSdk, nossoNumero);

            System.out.println("GET Url: " + HttpUtils.getLastUrl());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
