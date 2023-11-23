package inter.sdk.demo.banking.pagamento;

import inter.InterSdk;
import inter.sdk.demo.App;
import inter.sdk.exemplos.banking.pagamento.BuscarLotePagamentos;
import inter.utils.HttpUtils;

public class BuscarLotePagamentosDemo {
    public void execute(InterSdk interSdk) {
        try {
            interSdk.setDebug(true);
            interSdk.listaAvisos().forEach(System.out::println);

            String idLote = App.getString("idLote");

            System.out.println("Aguarde...");
            new BuscarLotePagamentos().exemplo(interSdk, idLote);

            System.out.println("GET Url: " + HttpUtils.getLastUrl());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
