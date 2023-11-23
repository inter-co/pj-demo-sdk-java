package inter.sdk.demo.cobranca.boletos;

import inter.InterSdk;
import inter.sdk.demo.App;
import inter.sdk.exemplos.cobranca.boletos.RecuperarBoletoPdf;
import inter.utils.HttpUtils;

public class RecuperarBoletoPdfDemo {
    public void execute(InterSdk interSdk) {
        try {
            interSdk.setDebug(true);
            interSdk.listaAvisos().forEach(System.out::println);

            String nossoNumero = App.getString("nossoNumero");
            String arquivo = "boleto.pdf";

            System.out.println("Aguarde...");
            new RecuperarBoletoPdf().exemplo(interSdk, nossoNumero, arquivo);

            System.out.println("GET Url: " + HttpUtils.getLastUrl());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
