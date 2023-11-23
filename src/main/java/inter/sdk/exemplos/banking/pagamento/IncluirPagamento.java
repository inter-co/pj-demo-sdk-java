package inter.sdk.exemplos.banking.pagamento;

import inter.InterSdk;
import inter.banking.model.PagamentoBoleto;
import inter.banking.model.RespostaIncluirPagamento;
import inter.exceptions.SdkException;

import java.math.BigDecimal;

public class IncluirPagamento {
    public void exemplo(InterSdk interSdk, String linhaDigitavel, BigDecimal valorPago, String dataVencimento) {
        try {
            PagamentoBoleto pagamento = PagamentoBoleto.builder()
                    .codBarraLinhaDigitavel(linhaDigitavel)
                    .valorPagar(valorPago)
                    .dataVencimento(dataVencimento)
                    .build();
            RespostaIncluirPagamento resposta = interSdk.banking().incluirPagamento(pagamento);
            System.out.println("Pagamento efetuado, transacao=" + resposta.getCodigoTransacao());
        } catch (SdkException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
