package inter.sdk.demo.pix.pix;

import inter.InterSdk;
import inter.sdk.demo.App;
import inter.sdk.exemplos.pix.pix.ConsultarPix;
import inter.utils.HttpUtils;

public class ConsultarPixDemo {
    public void execute(InterSdk interSdk) {
        try {
            interSdk.setDebug(true);
            interSdk.listaAvisos().forEach(System.out::println);

            String e2eId = App.getString("e2eId");

            System.out.println("Aguarde...");
            new ConsultarPix().exemplo(interSdk, e2eId);

            System.out.println("GET Url: " + HttpUtils.getLastUrl());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
