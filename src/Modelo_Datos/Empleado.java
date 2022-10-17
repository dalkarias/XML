package Modelo_Datos;

public class Empleado {
    private int id;
    private String apellido;
    private int dep;
    private float salario;

    public Empleado() {
    }

    public Empleado(int id, String apellido, int dpt, float salario) {
        this.id = id;
        this.apellido = apellido;
        this.dep = dpt;
        this.salario = salario;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getDep() {
        return dep;
    }

    public void setDep(int dep) {
        this.dep = dep;
    }

    public float getSalario() {
        return salario;
    }

    public void setSalario(float salario) {
        this.salario = salario;
    }

    @Override
    public String toString() {
        return "ID = " + id + "\n"+
                "Apellido = " + apellido +"\n"+
                "DEP = " + dep +"\n"+
                "Salario = " + salario+"\n"+"*******************";
    }
}
