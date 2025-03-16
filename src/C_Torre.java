import java.util.Stack;
public class C_Torre {
    private char nombre;
    private Stack<Integer> discos;

    public C_Torre(char nombre) {
        this.nombre = nombre;
        this.discos = new Stack<>();
    }
    public char getNombre() {
        return nombre;
    }
    public Stack<Integer> getDiscos() {
        return discos;
    }
    public boolean agregarDisco(int disco) {
        if (!discos.isEmpty() && discos.peek() < disco) {
            System.out.println("¡Error! No se puede mover un disco más grande sobre uno más pequeño.");
            return false;
        }
        discos.push(disco);
        return true;
    }
    public int removerDisco() {
        return discos.isEmpty() ? -1 : discos.pop();
    }
    @Override
    public String toString() {
        return nombre + ": " + discos;
    }
}
