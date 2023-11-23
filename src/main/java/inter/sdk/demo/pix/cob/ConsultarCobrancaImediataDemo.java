package inter.sdk.demo.pix.cob;

import inter.InterSdk;
import inter.sdk.demo.App;
import inter.sdk.exemplos.pix.cob.ConsultarCobrancaImediata;
import inter.utils.HttpUtils;

public class ConsultarCobrancaImediataDemo {

    public void execute(InterSdk interSdk) {
        try {
            interSdk.setDebug(true);
            interSdk.listaAvisos().forEach(System.out::println);

            String txId = App.getString("txId");

            System.out.println("Aguarde...");
            new ConsultarCobrancaImediata().exemplo(interSdk, txId);

            System.out.println("GET Url: " + HttpUtils.getLastUrl());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
