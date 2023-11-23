package inter.sdk.exemplos.sdk;

import inter.InterSdk;

public class InicializacaoSdk {
    public InterSdk inicializa(String clientId,     // Client Id obtido no detalhe da tela de aplicações no IB
                               String clientSecret, // Client Secret obtido no detalhe da tela de aplicações no IB
                               String certificado,  // Certificado PFX gerado conforme instruções em "Obtenção e configuração do certificado"
                               String senha         // Senha utilizada na geração do certificado PFX
    ) throws Exception {
        return new InterSdk(clientId, clientSecret, certificado, senha);
    }
}
