## 1. Por que `return 70` é aceitável no Ciclo 1? O que obrigou a soma real?
O primeiro teste descrevia apenas um exemplo: 20 + 20 + 30 deve produzir 70. Retornar 70 era a implementação mínima que deixava esse teste verde, técnica conhecida como "fake it". Isso não provava que qualquer soma funcionava. O segundo exemplo, 10 + 15 + 25 = 50, falhou com o valor fixo e obrigou a generalização para `a1 + a2 + a3`, por triangulação.

## 2. Por que testar com 69 e 70, em vez de 50 e 90?
69 e 70 ficam nos dois lados da fronteira de aprovação. O teste com 70 detecta o erro de usar `> 70` no lugar de `>= 70`. Com apenas 50 e 90, as duas implementações passariam e esse defeito ficaria escondido.

## 3. O que mudou na refatoração do Ciclo 4? Como verificar que nada quebrou?
As três validações repetidas foram extraídas para `validarNota`, que recebe a nota, o máximo e o nome da avaliação. Os limites 30 e 40 ganharam constantes. A regra de negócio permaneceu igual. A mesma suíte foi executada antes e depois da refatoração e continuou verde, verificando tanto as rejeições quanto as notas válidas.

## 4. Por que alterar os testes antes do código no Ciclo 8?
Os testes precisam expressar primeiro o novo requisito: distinguir reprovação por nota e por falta, priorizando a falta quando ambas ocorrem. Ver os testes falharem com a implementação anterior mostra que eles detectam a mudança. Só depois a implementação foi ajustada até satisfazer a nova especificação.

## 5. Qual ciclo foi o mais difícil para você, e por quê?
o Ciclo 7 exige mais atenção porque é preciso substituir somente a menor nota entre A1 e A2, sem reduzir a nota final quando a AI é menor ou igual. Os casos de notas iguais e AI nos limites 0 e 30 também precisam ser considerados. A expressão com `Math.min` e `Math.max` ajuda a tornar a melhoria explícita.
