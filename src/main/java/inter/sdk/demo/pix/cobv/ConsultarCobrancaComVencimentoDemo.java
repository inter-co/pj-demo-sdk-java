package inter.sdk.demo.pix.cobv;

import inter.InterSdk;
import inter.sdk.demo.App;
import inter.sdk.exemplos.pix.cobv.ConsultarCobrancaComVencimento;
import inter.utils.HttpUtils;

public class ConsultarCobrancaComVencimentoDemo {

    public void execute(InterSdk interSdk) {
        try {
            interSdk.setDebug(true);
            interSdk.listaAvisos().forEach(System.out::println);

            String txId = App.getString("txId");

            System.out.println("Aguarde...");
            new ConsultarCobrancaComVencimento().exemplo(interSdk, txId);

            System.out.println("GET Url: " + HttpUtils.getLastUrl());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
