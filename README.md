# Tic Tac Toe App

## Descrição
Este é um aplicativo de **jogo da velha** desenvolvido em **Kotlin** para o sistema operacional Android. O jogo é para dois jogadores locais ("X" e "O"), onde os jogadores se alternam marcando suas jogadas em um tabuleiro 3x3 até que haja um vencedor ou empate. O aplicativo inclui um botão para reiniciar o jogo e é projetado para funcionar em orientação retrato (portrait).

## Funcionalidades
- **Jogabilidade 2 jogadores:** Cada jogador joga alternadamente marcando "X" ou "O".
- **Reconhecimento de vitória ou empate:** Identifica automaticamente quando um jogador vence ou se o jogo termina em empate.
- **Botão de reinício:** Permite que o tabuleiro seja limpo e o jogo reiniciado.
- **Orientação travada:** A orientação da tela está fixa em modo retrato.

## Requisitos
- **Android Studio**: Arctic Fox ou superior.
- **SDK Android**: Mínimo 21 (Lollipop).
- **Linguagem**: Kotlin.

## Imagem do Jogo em Execução

Adicione aqui uma captura de tela do jogo em execução:

<img src="https://github.com/Micael-Resende/Tic-Tac-Toe---Game-Mobile/blob/main/images/tic_tac_toe-mobile.jpg" alt="Interface do App" width="300">

## Estrutura de Arquivos

### **1. Layout Principal (`activity_main.xml`)**
- Contém o layout do tabuleiro 3x3 e o botão de reinício.
- Elementos principais:
  - **`TextView`** para exibir o turno atual.
  - **`LinearLayout`** para organizar os botões do tabuleiro.
  - **`Button`** para reiniciar o jogo.

### **2. Lógica Principal (`MainActivity.kt`)**
- Implementa a lógica do jogo:
  - Alternância de turnos.
  - Verificação de condições de vitória ou empate.
  - Função para reinício do jogo.


## Como Rodar o Projeto
1. **Clone ou baixe o repositório**.
2. **Abra o projeto no Android Studio**.
3. Certifique-se de que o SDK mínimo está configurado.
4. Clique em **Run** para compilar e executar o aplicativo em um dispositivo ou emulador.

## Como Jogar
1. O jogo inicia com o jogador "X".
2. Toque em uma célula vazia para marcar sua jogada.
3. Alternem os turnos até que:
   - Um jogador alinhe três símbolos (linhas, colunas ou diagonais) e vença.
   - Todas as células sejam preenchidas, resultando em empate.
4. Clique no botão **Reset Game** para reiniciar o jogo.

## Licença
Este projeto é de uso livre para estudos e aplicações pessoais.

## Autor
Micael Resende

