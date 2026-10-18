# Prática 05 — TDD em Java

Calculadora de notas da disciplina Gestão e Qualidade de Software. Projeto Maven, Java 8 e JUnit 5.

## Regras implementadas

- A1 e A2: 0 a 30; A3: 0 a 40. Notas fora da faixa lançam `IllegalArgumentException`.
- Nota final: A1 + A2 + A3; aprovação: nota >= 70 e frequência >= 75%.
- Situação: `APROVADO`, `REPROVADO POR FALTA` ou `REPROVADO POR NOTA`. Falta tem prioridade.
- Elegibilidade para AI: nota < 70, frequência >= 75 e A1 + A3 >= 40 ou A2 + A3 >= 40.
- AI: 0 a 30, substitui somente a menor entre A1 e A2 quando houver melhora.
