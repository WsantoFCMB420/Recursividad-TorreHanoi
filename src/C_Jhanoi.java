public class C_Jhanoi {
    private C_Torre torreorigen,torreauxiliar,torredestino;

    public C_Jhanoi (int numDiscos) {
        this.torreorigen = new C_Torre('A');
        this.torreauxiliar = new C_Torre('B');
        this.torredestino = new C_Torre('C');

        for (int i = numDiscos; i >= 1; i--) {
            torreorigen.agregarDisco(i);
        }
    }
    public void resolver(int n, C_Torre torreorigen, C_Torre torreauxiliar, C_Torre torredestino) {
        if (n == 1) {
            moverDisco(torreorigen, torredestino);
            return;
        }
        resolver(n - 1, torreorigen, torredestino, torreauxiliar);
        moverDisco(torreorigen, torredestino);
        resolver(n - 1, torreauxiliar, torreorigen, torredestino);
    }
    private void moverDisco(C_Torre desde, C_Torre hacia) {
        int disco = desde.removerDisco();
        if (disco != -1) {
            if (hacia.agregarDisco(disco)) {
                System.out.println("Mover disco " + disco + " de " + desde.getNombre() + " a " + hacia.getNombre());
                mostrarEstado();
            } else {
                // Si el movimiento es inválido, devolver el disco a su torre original
                desde.agregarDisco(disco);
            }
        }
    }
    public void mostrarEstado() {
        System.out.println("\nEstado actual:");
        System.out.println(torreorigen);
        System.out.println(torreauxiliar);
        System.out.println(torredestino);
        System.out.println("-------------------------");
    }

    public void ejecutar(int numDiscos) {
        System.out.println("\n🔄 Secuencia de movimientos:");
        mostrarEstado();
        resolver(numDiscos, torreorigen, torreauxiliar, torredestino);
    }
}
