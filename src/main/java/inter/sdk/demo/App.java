package inter.sdk.demo;

import inter.InterSdk;
import inter.exceptions.SdkException;

import java.math.BigDecimal;
import java.util.InputMismatchException;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws SdkException {
        int op;
        final String VERSION = "demo-sdk-java v1.0.1.2023-09-26";

        System.out.println(VERSION);
        System.out.println(InterSdk.VERSION);
        System.out.println("**************************************************************************************************");
        System.out.println("ATENÇÃO - APESAR DE SER UM PROJETO DEMO, AS AÇÕES SÃO REALIZADAS NO AMBIENTE DE PRODUÇÃO DO INTER!");
        System.out.println("**************************************************************************************************\n");

        String ambiente = "bancointer";
        System.out.println("Configuração do InterSdk:");
        String clientId = getString("clientId de sua aplicação");
        String clientSecret = getString("clientSecret de sua aplicação");
        String certificado = getString("nome do arquivo com o certificado pfx");
        String senha = getString("senha do arquivo com o certificado pfx");
        String contaCorrenteApp = getStringOrNull("conta corrente da aplicação (caso tenha múltiplas contas)");

//        String ambiente = "uatbi";
//        String clientId = "6401723b-7c08-48e2-baf7-33fb01141557";
//        String clientSecret = "450daced-6cd6-4103-89e1-e072d1768bb9";
//        String certificado = "certificado.pfx";
//        String senha = "123456";
//        String contaCorrenteApp = "8579377";

        InterSdk interSdk = new InterSdk(ambiente, clientId, clientSecret, certificado, senha);
        if (args.length > 0) {
            interSdk.setAmbiente(args[0]);
        }

        atribuirContaCorrenteAoSDK(interSdk, contaCorrenteApp);

        while ((op = menu(ambiente)) != 0) {
            switch (op) {
                case 1:
                    while ((op = MenuCobranca.showMenu(ambiente)) != 0) {
                        MenuCobranca.execute(op, interSdk);
                    }
                    break;
                case 2:
                    while ((op = MenuBanking.showMenu(ambiente)) != 0) {
                        MenuBanking.execute(op, interSdk);
                    }
                    break;
                case 3:
                    while ((op = MenuPix.showMenu(ambiente)) != 0) {
                        MenuPix.execute(op, interSdk);
                    }
                    break;
            }
        }
    }

    private static int menu(String ambiente) {
        System.out.println("AMBIENTE " + ambiente);
        System.out.println("1 - API Cobrança");
        System.out.println("2 - API Banking");
        System.out.println("3 - API Pix");
        System.out.println("0 - Sair");
        System.out.print("=> ");
        Scanner scanner = new Scanner(System.in);
        try {
            return scanner.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("opção inválida");
            return menu(ambiente);
        }
    }

    public static String getString(String prompt) {
        System.out.print(prompt + ": ");
        Scanner scanner = new Scanner(System.in);
        return scanner.next();
    }

    public static String getStringOrNull(String prompt) {
        System.out.print(prompt + ": ");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    public static BigDecimal getBigDecimal(String prompt) {
        System.out.print(prompt + ": ");
        Scanner scanner = new Scanner(System.in);
        return BigDecimal.valueOf(Double.parseDouble(scanner.next()));
    }

    public static String getTextoCompleto(String prompt) {
        System.out.print(prompt + ": ");
        Scanner scanner = new Scanner(System.in).useDelimiter("\n");
        return scanner.next();
    }

    public static void atribuirContaCorrenteAoSDK(InterSdk interSdk, String contaCorrenteApp) {
        if (contaCorrenteApp != null && !contaCorrenteApp.trim().isEmpty()) {
            interSdk.setContaCorrente(contaCorrenteApp);
        }
    }
}