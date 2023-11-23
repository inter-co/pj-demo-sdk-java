package inter.sdk.demo.banking.webhook;

import inter.InterSdk;
import inter.banking.model.FiltroBuscarCallbacks;
import inter.sdk.demo.App;
import inter.sdk.exemplos.banking.webhook.ConsultarCallbacks;
import inter.utils.HttpUtils;

public class ConsultarCallbacksDemo {

    public void execute(InterSdk interSdk) {
        try {
            interSdk.setDebug(true);
            interSdk.listaAvisos().forEach(System.out::println);

            FiltroBuscarCallbacks filtro = null;
            String dataHoraInicial = App.getString("dataHoraInicial(YYYY-MM-DDTHH:MM:SSZ ex:2022-04-01T10:30:00Z)");
            String dataHoraFinal = App.getString("dataHoraFinal(YYYY-MM-DDTHH:MM:SSZ ex:2022-04-01T10:30:00Z)");

            System.out.println("Aguarde...");
            new ConsultarCallbacks().exemplo(interSdk, "pix-pagamento", dataHoraInicial, dataHoraFinal, filtro);

            System.out.println("GET Url: " + HttpUtils.getLastUrl());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
