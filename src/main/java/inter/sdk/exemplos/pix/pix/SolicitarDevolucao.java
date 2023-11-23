package inter.sdk.exemplos.pix.pix;

import inter.InterSdk;
import inter.exceptions.SdkException;
import inter.pix.model.Devolucao;
import inter.pix.model.DevolucaoDetalhada;
import inter.pix.model.enums.NaturezaDevolucao;

public class SolicitarDevolucao {
    public void exemplo(InterSdk interSdk, String e2eId, String id, String valor, NaturezaDevolucao natureza, String descricao) {
        try {
            Devolucao devolucao = Devolucao.builder()
                    .valor(valor)
                    .natureza(natureza)
                    .descricao(descricao)
                    .build();
            DevolucaoDetalhada devolucaoDetalhada = interSdk.pix().solicitarDevolucao(e2eId, id, devolucao);
            System.out.println("Devolução efetuata, status=" + devolucaoDetalhada.getStatus());
        } catch (SdkException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
