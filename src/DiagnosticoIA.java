public class DiagnosticoIA {

    private String sintomaRelatado;

    public DiagnosticoIA(String sintomaRelatado) {
        this.sintomaRelatado = sintomaRelatado.toLowerCase().trim();
    }

    public String processarSintomas() {
        if (sintomaRelatado.contains("bateria") || sintomaRelatado.contains("elétrico")
                || sintomaRelatado.contains("eletrico") || sintomaRelatado.contains("carga")) {
            return "[DiagnosticoIA] Diagnóstico: Possível desgaste da bateria.\n"
                 + "             Recomendação: Realizar teste de carga e verificar terminais. (Probabilidade 85%)";
        } else if (sintomaRelatado.contains("óleo") || sintomaRelatado.contains("oleo")
                || sintomaRelatado.contains("fumaça") || sintomaRelatado.contains("fumaca")) {
            return "[DiagnosticoIA] Diagnóstico: Possível vazamento ou consumo elevado de óleo.\n"
                 + "             Recomendação: Trocar óleo e verificar juntas. (Probabilidade 80%)";
        } else if (sintomaRelatado.contains("freio") || sintomaRelatado.contains("buzina")
                || sintomaRelatado.contains("rangendo")) {
            return "[DiagnosticoIA] Diagnóstico: Possível desgaste das pastilhas de freio.\n"
                 + "             Recomendação: Inspecionar sistema de freios imediatamente. (Probabilidade 90%)";
        } else if (sintomaRelatado.contains("superaquec") || sintomaRelatado.contains("temperatura")
                || sintomaRelatado.contains("quente")) {
            return "[DiagnosticoIA] Diagnóstico: Possível problema no sistema de arrefecimento.\n"
                 + "             Recomendação: Verificar nível do radiador e correia do ventilador. (Probabilidade 75%)";
        } else if (sintomaRelatado.contains("vibr") || sintomaRelatado.contains("pneu")
                || sintomaRelatado.contains("direção") || sintomaRelatado.contains("direcao")) {
            return "[DiagnosticoIA] Diagnóstico: Possível desequilíbrio ou desgaste nos pneus.\n"
                 + "             Recomendação: Realizar balanceamento e alinhamento. (Probabilidade 70%)";
        } else {
            return "[DiagnosticoIA] Diagnóstico: Sintoma registrado para análise aprofundada.\n"
                 + "             Recomendação: Agendar inspeção presencial com o mecânico.";
        }
    }
}
