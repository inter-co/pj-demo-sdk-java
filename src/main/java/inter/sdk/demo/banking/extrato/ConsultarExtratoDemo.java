package inter.sdk.demo.banking.extrato;

import inter.InterSdk;
import inter.sdk.demo.App;
import inter.sdk.exemplos.banking.extrato.ConsultarExtrato;
import inter.utils.HttpUtils;

public class ConsultarExtratoDemo {
    public void execute(InterSdk interSdk) {
        try {
            interSdk.setDebug(true);
            interSdk.listaAvisos().forEach(System.out::println);

            String dataInicial = App.getString("dataInicial(YYYY-MM-DD)");
            String dataFinal = App.getString("dataFinal(YYYY-MM-DD)");

            System.out.println("Aguarde...");
            new ConsultarExtrato().exemplo(interSdk, dataInicial, dataFinal);

            System.out.println("GET Url: " + HttpUtils.getLastUrl());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
