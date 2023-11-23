package inter.sdk.exemplos.pix.cobv;

import com.fasterxml.jackson.databind.ObjectMapper;
import inter.InterSdk;
import inter.exceptions.SdkException;
import inter.pix.model.CalendarioCobV;
import inter.pix.model.CobVValor;
import inter.pix.model.CobrancaVencimento;
import inter.pix.model.CobrancaVencimentoDetalhada;
import inter.pix.model.Devedor;

public class CriarCobrancaComVencimento {

    public void exemplo(InterSdk interSdk, String txId, String cpf, String nome, String valorOriginal, String chave, String dataVencimento, String validade, Devedor devedor) {
        try {
            Integer validadeAposVencimento = Integer.parseInt(validade);

            CobVValor valor = CobVValor.builder()
                    .original(valorOriginal)
                    .build();
            CalendarioCobV calendario = CalendarioCobV.builder()
                    .dataDeVencimento(dataVencimento)
                    .validadeAposVencimento(validadeAposVencimento)
                    .build();
            CobrancaVencimento cobranca = CobrancaVencimento.builder()
                    .devedor(devedor)
                    .valor(valor)
                    .chave(chave)
                    .calendario(calendario)
                    .build();
            CobrancaVencimentoDetalhada cobrancaCriada = interSdk.pix().criarCobrancaComVencimentoTxId(txId, cobranca);
            System.out.println(new ObjectMapper().writerWithDefaultPrettyPrinter().writeValueAsString(cobrancaCriada));
            System.out.println("Cobrança criada, status=" + cobrancaCriada.getStatus());
        } catch (SdkException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
