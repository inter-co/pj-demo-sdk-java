package inter.sdk.demo.pix.location;

import inter.InterSdk;
import inter.sdk.demo.App;
import inter.sdk.exemplos.pix.location.RecuperarLocation;
import inter.utils.HttpUtils;

public class RecuperarLocationDemo {
    public void execute(InterSdk interSdk) {
        try {
            interSdk.setDebug(true);
            interSdk.listaAvisos().forEach(System.out::println);

            String id = App.getString("id");

            System.out.println("Aguarde...");
            new RecuperarLocation().exemplo(interSdk, id);

            System.out.println("GET Url: " + HttpUtils.getLastUrl());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
