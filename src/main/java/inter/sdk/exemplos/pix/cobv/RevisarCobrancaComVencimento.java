package inter.sdk.exemplos.pix.cobv;

import com.fasterxml.jackson.databind.ObjectMapper;
import inter.InterSdk;
import inter.exceptions.SdkException;
import inter.pix.model.CalendarioCobV;
import inter.pix.model.CobVValor;
import inter.pix.model.CobrancaVencimento;
import inter.pix.model.CobrancaVencimentoDetalhada;
import inter.pix.model.Devedor;

public class RevisarCobrancaComVencimento {

    public void exemplo(InterSdk interSdk, String txId, String cpf, String nome, String valorOriginal, String chave, String dataVencimento, String validade, Devedor devedor) {
        try {
            Integer x = Integer.parseInt(validade);

            CobVValor valor = CobVValor.builder()
                    .original(valorOriginal)
                    .build();
            CalendarioCobV calendario = CalendarioCobV.builder()
                    .dataDeVencimento(dataVencimento)
                    .validadeAposVencimento(x)
                    .build();
            CobrancaVencimento cobranca = CobrancaVencimento.builder()
                    .devedor(devedor)
                    .valor(valor)
                    .chave(chave)
                    .calendario(calendario)
                    .build();
            CobrancaVencimentoDetalhada cobrancaRevisada = interSdk.pix().revisarCobrancaComVencimento(txId, cobranca);
            System.out.println(new ObjectMapper().writerWithDefaultPrettyPrinter().writeValueAsString(cobrancaRevisada));
            System.out.println("Cobrança revisada, status=" + cobrancaRevisada.getStatus());
        } catch (SdkException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
