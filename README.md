# AT2 | Média Geral

**Aluno:** Paulo Cesar Pedro Candiani

## Sobre o Projeto

Este aplicativo Android foi desenvolvido em Kotlin utilizando Programação Orientada a Objetos (POO) e Jetpack Compose. Ele permite cadastrar um aluno, lançar suas três notas parciais e calcular automaticamente a média geral, exibindo o status final conforme o desempenho.

## Funcionalidades
- **Cadastro de Aluno:** Inserção do nome completo do aluno.
- **Lançamento de Notas:** Entrada das três notas parciais (TP1, TP2, TP3).
- **Cálculo da Média:** Média aritmética das três notas.
- **Avaliação de Desempenho:** Exibição do status final:
  - Reprovado: Média < 6.0
  - Aprovado: Média ≥ 6.0 e ≤ 9.0
  - Ótimo Aproveitamento: Média > 9.0

## Requisitos Técnicos Atendidos
- **POO:** Utilização de Data Class para representar o aluno e suas notas.
- **Jetpack Compose:** Interface 100% construída com Compose.
- **Gerenciamento de Estado:** Uso de `remember` e `mutableStateOf` para atualização automática da UI.
- **Estrutura de Dados:** Notas armazenadas em `MutableList<Double>` dentro da classe do aluno.

## Estrutura do Projeto
- `model/`: Data class do aluno e lógica de cálculo.
- `ui/components/`: Componentes reutilizáveis da interface.
- `ui/screens/`: Telas principais do app (cadastro, notas, resultado).
- `ui/navigation/`: Gerenciamento de navegação entre telas.
- `ui/theme/`: Definições de tema e estilos visuais.

## Como Executar
1. Clone o repositório
2. Abra no Android Studio ou VS Code com extensão para Android
3. Execute o projeto em um emulador ou dispositivo físico

## Exemplo de Uso
1. Informe o nome completo do aluno
2. Lance as três notas parciais
3. Veja a média calculada e o status final (Reprovado, Aprovado ou Ótimo Aproveitamento)

---

> Documentação baseada no modelo apresentado em aula. Para referência, consulte: [Guia Fatec Registro](https://fatec-registro-yuri-villanova.github.io/docs)
