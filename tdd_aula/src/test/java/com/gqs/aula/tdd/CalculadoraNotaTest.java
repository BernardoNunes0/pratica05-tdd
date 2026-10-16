package com.gqs.aula.tdd;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class CalculadoraNotaTest {
    @Test
    void deveSomarAsTresNotas() {
        CalculadoraNota calc = new CalculadoraNota();
        assertEquals(70, calc.calcularNotaFinal(20, 20, 30));
    }

    @Test
    void deveSomarOutrasNotas() {
        CalculadoraNota calc = new CalculadoraNota();
        assertEquals(50, calc.calcularNotaFinal(10, 15, 25));
    }

    @Test
    void deveAprovarComNota70() {
        CalculadoraNota calc = new CalculadoraNota();
        assertTrue(calc.estaAprovadoPorNota(70));
    }

    @Test
    void deveReprovarComNota69() {
        CalculadoraNota calc = new CalculadoraNota();
        assertFalse(calc.estaAprovadoPorNota(69));
    }

    @Test
    void deveRejeitarA1MaiorQue30() {
        CalculadoraNota calc = new CalculadoraNota();
        assertThrows(IllegalArgumentException.class, () -> calc.calcularNotaFinal(35, 20, 30));
    }

    @Test
    void deveRejeitarA2MaiorQue30() {
        CalculadoraNota calc = new CalculadoraNota();
        assertThrows(IllegalArgumentException.class, () -> calc.calcularNotaFinal(20, 35, 30));
    }

    @Test
    void deveRejeitarA3MaiorQue40() {
        CalculadoraNota calc = new CalculadoraNota();
        assertThrows(IllegalArgumentException.class, () -> calc.calcularNotaFinal(20, 20, 45));
    }

    @Test
    void deveRejeitarA1Negativa() {
        CalculadoraNota calc = new CalculadoraNota();
        assertThrows(IllegalArgumentException.class, () -> calc.calcularNotaFinal(-1, 20, 30));
    }

    @Test
    void deveAceitarNotasMaximas() {
        CalculadoraNota calc = new CalculadoraNota();
        assertEquals(100, calc.calcularNotaFinal(30, 30, 40));
    }

    @Test
    void deveAprovarComNotaEFrequenciaSuficientes() {
        CalculadoraNota calc = new CalculadoraNota();
        assertEquals("APROVADO", calc.situacao(80, 90));
    }

    @Test
    void deveReprovarComNotaBaixa() {
        CalculadoraNota calc = new CalculadoraNota();
        assertEquals("REPROVADO POR NOTA", calc.situacao(60, 90));
    }

    @Test
    void deveReprovarPorFrequenciaMesmoComNotaAlta() {
        CalculadoraNota calc = new CalculadoraNota();
        assertEquals("REPROVADO POR FALTA", calc.situacao(95, 74));
    }

    @Test
    void deveAprovarComFrequenciaExatamente75() {
        CalculadoraNota calc = new CalculadoraNota();
        assertEquals("APROVADO", calc.situacao(70, 75));
    }

    @Test
    void devePermitirAIPelaSomaA2A3() {
        CalculadoraNota calc = new CalculadoraNota();
        assertTrue(calc.podeFazerAI(10, 20, 30, 80));
    }

    @Test
    void devePermitirAINoLimiteDaSomaA1A3() {
        CalculadoraNota calc = new CalculadoraNota();
        assertTrue(calc.podeFazerAI(10, 5, 30, 80));
    }

    @Test
    void deveNegarAIParaAlunoAprovado() {
        CalculadoraNota calc = new CalculadoraNota();
        assertFalse(calc.podeFazerAI(25, 25, 30, 80));
    }

    @Test
    void deveNegarAIComFrequenciaBaixa() {
        CalculadoraNota calc = new CalculadoraNota();
        assertFalse(calc.podeFazerAI(10, 20, 30, 70));
    }

    @Test
    void deveNegarAISemSomaMinima() {
        CalculadoraNota calc = new CalculadoraNota();
        assertFalse(calc.podeFazerAI(5, 5, 30, 80));
    }

    @Test
    void deveSubstituirA1PelaAI() {
        CalculadoraNota calc = new CalculadoraNota();
        assertEquals(75, calc.aplicarAI(10, 20, 30, 25));
    }

    @Test
    void deveSubstituirA2PelaAI() {
        CalculadoraNota calc = new CalculadoraNota();
        assertEquals(75, calc.aplicarAI(20, 10, 30, 25));
    }

    @Test
    void naoDeveSubstituirComAIBaixa() {
        CalculadoraNota calc = new CalculadoraNota();
        assertEquals(60, calc.aplicarAI(10, 20, 30, 5));
    }

    @Test
    void naoDeveSubstituirComAIIgualAMenor() {
        CalculadoraNota calc = new CalculadoraNota();
        assertEquals(60, calc.aplicarAI(10, 20, 30, 10));
    }

    @Test
    void deveSubstituirUmaNotaQuandoA1EA2SaoIguais() {
        CalculadoraNota calc = new CalculadoraNota();
        assertEquals(65, calc.aplicarAI(10, 10, 30, 25));
    }

    @Test
    void deveAceitarAIZero() {
        CalculadoraNota calc = new CalculadoraNota();
        assertEquals(60, calc.aplicarAI(10, 20, 30, 0));
    }

    @Test
    void deveAceitarAIMaxima() {
        CalculadoraNota calc = new CalculadoraNota();
        assertEquals(80, calc.aplicarAI(10, 20, 30, 30));
    }

    @Test
    void deveRejeitarAINegativa() {
        CalculadoraNota calc = new CalculadoraNota();
        assertThrows(IllegalArgumentException.class, () -> calc.aplicarAI(10, 20, 30, -1));
    }

    @Test
    void deveRejeitarAIMaiorQue30() {
        CalculadoraNota calc = new CalculadoraNota();
        assertThrows(IllegalArgumentException.class, () -> calc.aplicarAI(10, 20, 30, 31));
    }

    @Test
    void devePriorizarFaltaQuandoNotaEFrequenciaSaoBaixas() {
        CalculadoraNota calc = new CalculadoraNota();
        assertEquals("REPROVADO POR FALTA", calc.situacao(50, 60));
    }

    @Test
    void deveSomarNotasZero() {
        CalculadoraNota calc = new CalculadoraNota();
        assertEquals(0, calc.calcularNotaFinal(0, 0, 0));
    }

    @Test
    void deveSomarNotasDecimais() {
        CalculadoraNota calc = new CalculadoraNota();
        assertEquals(70, calc.calcularNotaFinal(20.5, 19.5, 30));
    }

    @Test
    void deveRejeitarA2Negativa() {
        CalculadoraNota calc = new CalculadoraNota();
        assertThrows(IllegalArgumentException.class, () -> calc.calcularNotaFinal(20, -1, 30));
    }

    @Test
    void deveRejeitarA3Negativa() {
        CalculadoraNota calc = new CalculadoraNota();
        assertThrows(IllegalArgumentException.class, () -> calc.calcularNotaFinal(20, 20, -1));
    }

    @Test
    void devePermitirAIComFrequenciaExatamente75() {
        CalculadoraNota calc = new CalculadoraNota();
        assertTrue(calc.podeFazerAI(10, 5, 30, 75));
    }

    @Test
    void deveNegarAIComNotaExatamente70() {
        CalculadoraNota calc = new CalculadoraNota();
        assertFalse(calc.podeFazerAI(20, 20, 30, 80));
    }

    @Test
    void deveReprovarComNotaImediatamenteAbaixoDe70() {
        CalculadoraNota calc = new CalculadoraNota();
        assertEquals("REPROVADO POR NOTA", calc.situacao(69.99, 75));
    }

    @Test
    void deveRejeitarNotaOriginalInvalidaAoAplicarAI() {
        CalculadoraNota calc = new CalculadoraNota();
        assertThrows(IllegalArgumentException.class, () -> calc.aplicarAI(-1, 20, 30, 25));
    }

}
