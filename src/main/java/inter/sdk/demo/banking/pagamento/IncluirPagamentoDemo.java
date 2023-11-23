package inter.sdk.demo.banking.pagamento;

import inter.InterSdk;
import inter.sdk.demo.App;
import inter.sdk.exemplos.banking.pagamento.IncluirPagamento;
import inter.utils.HttpUtils;

import java.math.BigDecimal;

public class IncluirPagamentoDemo {
    public void execute(InterSdk interSdk) {
        try {
            interSdk.setDebug(true);
            interSdk.listaAvisos().forEach(System.out::println);

            String linhaDigitavel = App.getString("linhaDigitavel");
            BigDecimal valor = App.getBigDecimal("valor(99.99)");
            String dataVencimento = App.getString("dataVencimento(YYYY-MM-DD)");

            System.out.println("Aguarde...");
            new IncluirPagamento().exemplo(interSdk, linhaDigitavel, valor, dataVencimento);

            System.out.println("POST Url: " + HttpUtils.getLastUrl());
            System.out.println("Requisição:");
            System.out.println(HttpUtils.getLastRequest());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
