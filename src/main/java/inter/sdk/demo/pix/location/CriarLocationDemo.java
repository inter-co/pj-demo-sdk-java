package inter.sdk.demo.pix.location;

import inter.InterSdk;
import inter.pix.model.enums.TipoCob;
import inter.sdk.demo.App;
import inter.sdk.exemplos.pix.location.CriarLocation;
import inter.utils.HttpUtils;

public class CriarLocationDemo {
    public void execute(InterSdk interSdk) {
        try {
            interSdk.setDebug(true);
            interSdk.listaAvisos().forEach(System.out::println);

            String tipo = App.getString("Tipo (cob, cobv)");

            TipoCob tipoCob = TipoCob.valueOf(tipo);

            System.out.println("Aguarde...");
            new CriarLocation().exemplo(interSdk, tipoCob);

            System.out.println("POST Url: " + HttpUtils.getLastUrl());
            System.out.println("Requisição:");
            System.out.println(HttpUtils.getLastRequest());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
