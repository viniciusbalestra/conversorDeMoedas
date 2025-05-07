# Conversor de Moedas em Java

Este é um projeto simples de conversor de moedas desenvolvido em Java. Ele permite que o usuário escolha uma moeda inicial, insira um valor, selecione uma moeda de destino e veja o valor convertido com base nas taxas de câmbio mais recentes obtidas de uma API online.

## Funcionalidades

* **Seleção de Moedas:** Oferece um menu com as 15 moedas mais famosas do mundo para o usuário escolher como moeda inicial e final.
* **Obtenção de Taxas de Câmbio:** Utiliza a API [ExchangeRate-API](https://www.exchangerate-api.com/) para buscar as taxas de câmbio em tempo real.
* **Conversão:** Realiza a conversão do valor inserido na moeda inicial para a moeda de destino, com base na taxa de câmbio obtida.
* **Formatação de Saída:** Exibe o valor convertido formatado com duas casas decimais para representar valores monetários.

## Como Usar

1.  **Pré-requisitos:**
    * Java Development Kit (JDK) instalado no seu sistema.
    * Uma chave de API válida do [ExchangeRate-API](https://www.exchangerate-api.com/). Você precisará substituir `YOUR-API-KEY` no código com a sua chave.
    * O projeto utiliza a biblioteca Gson para manipulação de JSON. Certifique-se de que ela esteja incluída no seu projeto (por exemplo, como uma dependência Maven ou Gradle).

2.  **Clonar o Repositório (se ainda não o fez):**
    ```bash
    git clone [https://github.com/SEU_USUARIO/SEU_REPOSITORIO.git](https://github.com/SEU_USUARIO/SEU_REPOSITORIO.git)
    cd SEU_REPOSITORIO
    ```
    *(Substitua `SEU_USUARIO/SEU_REPOSITORIO.git` pela URL do seu repositório no GitHub)*

3.  **Configurar a Chave da API:**
    * Abra o arquivo `RequisicaoApi.java` e localize a linha:
        ```java
        String url_str = "https://v6.exchangerate-api.com/v6/YOUR-API-KEY/pair/"+ moedaInicial + "/" + moedaFinal;
        ```
    * Substitua `YOUR-API-KEY` pela sua chave de API real do ExchangeRate-API.

4.  **Compilar e Executar o Projeto:**
    * Se você estiver usando um IDE como IntelliJ, pode compilar e executar o arquivo `Main.java` diretamente.
    * Se estiver compilando e executando pela linha de comando:
        ```bash
        javac src/principal/Main.java src/requisicaoapi/RequisicaoApi.java src/moedas/Moeda.java src/conversor/Conversor.java src/util/NumeroParaCodigo.java -cp .:./libs/gson-*.jar # (Linux/macOS - ajuste o caminho para o seu arquivo Gson)
        java -cp .:./libs/gson-*.jar principal.Main # (Linux/macOS)
        ```
        ```bash
        javac src\principal\Main.java src\requisicaoapi\RequisicaoApi.java src\moedas\Moeda.java src\conversor\Conversor.java src\util\NumeroParaCodigo.java -cp .;.\libs\gson-*.jar # (Windows - ajuste o caminho para o seu arquivo Gson)
        java -cp .;.\libs\gson-*.jar principal.Main # (Windows)
        ```
        *(Certifique-se de ter o arquivo `gson-*.jar` na pasta `libs` ou ajuste o caminho conforme necessário)*

5.  **Interagir com o Conversor:**
    * O programa exibirá um menu com as opções de moedas.
    * Digite o número correspondente à moeda que você possui.
    * Digite o valor que você deseja converter.
    * Digite o número correspondente à moeda para a qual deseja converter.
    * O resultado da conversão será exibido.

## Estrutura do Projeto

conversor-de-moedas-java/
├── src/
│   ├── conversor/
│   │   └── Conversor.java
│   ├── moedas/
│   │   └── Moeda.java
│   ├── principal/
│   │   └── Main.java
│   ├── requisicaoapi/
│   │   └── RequisicaoApi.java
│   └── util/
│       └── NumeroParaCodigo.java
├── libs/
│   └── gson-*.jar         # Biblioteca Gson
└── README.md


## Dependências

* [Gson](https://github.com/google/gson): Biblioteca Java para serializar e desserializar objetos Java para (ou de) JSON.

## Próximos Passos (Melhorias Futuras)

* Tratamento de erros mais robusto (por exemplo, falhas na conexão com a API, entrada inválida do usuário).
* Implementação de caching para evitar chamadas excessivas à API.
* Adição de mais moedas.
* Interface de usuário gráfica (GUI) para uma experiência mais amigável.
* Opção para o usuário inserir os códigos das moedas diretamente.
* Testes unitários para garantir a funcionalidade do código.

## Autor

Vinicius Gross Balestrin 
