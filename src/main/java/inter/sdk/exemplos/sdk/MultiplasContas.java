package inter.sdk.exemplos.sdk;

import inter.InterSdk;

public class MultiplasContas {
    public void exemplo(String clientId, String clientSecret, String certificado, String senha) throws Exception {
        InterSdk interSdk = new InterSdk(clientId, clientSecret, certificado, senha);
        interSdk.setContaCorrente("8579377");
        String contaSelecionada = interSdk.getContaCorrente();
        System.out.println(contaSelecionada);
        // executa comandos na conta selecionada ...
        interSdk.setContaCorrente("9588752");
        // executa comandos na nova conta selecionada
        interSdk.setControleRateLimit(false);
    }
}
