package inter.sdk.exemplos.banking.pagamento;

import inter.InterSdk;
import inter.banking.model.PagamentoDarf;
import inter.banking.model.RespostaIncluirPagamentoDarf;
import inter.exceptions.SdkException;

public class IncluirPagamentoDarf {
    public void exemplo(InterSdk interSdk, String cnpjCpf, String codigoReceita, String dataVencimento, String descricao,
                        String nomeEmpresa, String periodoApuracao, String valorPrincipal, String referencia) {
        try {
            PagamentoDarf pagamento = PagamentoDarf.builder()
                    .cnpjCpf(cnpjCpf)
                    .codigoReceita(codigoReceita)
                    .dataVencimento(dataVencimento)
                    .descricao(descricao)
                    .nomeEmpresa(nomeEmpresa)
                    .periodoApuracao(periodoApuracao)
                    .valorPrincipal(valorPrincipal)
                    .referencia(referencia)
                    .build();
            RespostaIncluirPagamentoDarf resposta = interSdk.banking().incluirPagamentoDarf(pagamento);
            System.out.println("Pagamento DARF efetuado, transacao=" + resposta.getCodigoTransacao());
        } catch (SdkException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
