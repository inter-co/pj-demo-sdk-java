package inter.sdk.exemplos.sdk;

import inter.InterSdk;
import inter.banking.model.Saldo;
import inter.exceptions.SdkException;
import inter.model.Violacao;

public class TratamentoErros {
    public void exemplo(InterSdk interSdk) {
        try {
            // executa um método do sdk
            Saldo saldo = interSdk.banking().consultarSaldo();
            // método executado com sucesso
            System.out.println(saldo.getDisponivel());

        } catch (SdkException e) {
            // pode ser ClientException ou ServerException
            System.out.println(e.getClass().getName());
            // retorna uma lista de erros com título, detalhe e uma lista de violações
            System.out.println(e.getErro().getTitle());  //ex: A presente requisicao nao respeita o schema ou não faz sentido semanticamente.
            System.out.println(e.getErro().getDetail()); //ex: Requisicao invalida.
            for (Violacao violacao : e.getErro().getViolacoes()) {
                System.out.println(violacao.getRazao()); // ex: Periodo maximo entre as datas é de 90 dias.
                System.out.println(violacao.getPropriedade()); // ex: Data inicio, Data Fim
                System.out.println(violacao.getValor());
            }
            e.printStackTrace();

        } catch (Exception e) {
            // trata outras exceções
            e.printStackTrace();
        }
    }
}
