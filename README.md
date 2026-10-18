# Prática 05 — TDD em Java

Calculadora de notas da disciplina Gestão e Qualidade de Software. Projeto Maven, Java 8 e JUnit 5.

## Regras implementadas

- A1 e A2: 0 a 30; A3: 0 a 40. Notas fora da faixa lançam `IllegalArgumentException`.
- Nota final: A1 + A2 + A3; aprovação: nota >= 70 e frequência >= 75%.
- Situação: `APROVADO`, `REPROVADO POR FALTA` ou `REPROVADO POR NOTA`. Falta tem prioridade.
- Elegibilidade para AI: nota < 70, frequência >= 75 e A1 + A3 >= 40 ou A2 + A3 >= 40.
- AI: 0 a 30, substitui somente a menor entre A1 e A2 quando houver melhora.

## Executar no Codespaces / VS Code

1. Abra este repositório no Codespaces.
2. Instale **Extension Pack for Java**, se necessário.
3. Aguarde o Java terminar de carregar o projeto `tdd_aula`.
4. Abra o painel **Testing** (frasquinho) e execute `CalculadoraNotaTest`.
5. Capture o painel real com todos os testes verdes para a entrega.

O histórico contém os oito ciclos com commits RED antes de GREEN e as refatorações. As fases foram realmente compiladas e executadas com Java 8 e JUnit Platform Console; os RED falharam e os GREEN/REFACTOR passaram. A verificação automatizada usa o mesmo JUnit 5, mas não substitui o print do frasquinho solicitado nos slides.
